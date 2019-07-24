/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author laboratorios
 */
public class DAOAutoBD extends Dao<Auto, String>
{   
    private Connection conexion;
    private String crearAutoSql;
    private String crearMotorSql;
    private final String buscarSql;
    private String eliminarMotorSql;
    private String eliminarAutoSql;
    private String obtenerTodosSql;
    private String actualizarAutoSql;
    private String actualizarMotorSql;
    private PreparedStatement psBuscar;
    
    
    public DAOAutoBD(String host, String bd,int port, String user, String password) throws DaoException, SQLException
    {//"?serverTimezone=GMT-3"
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/"+bd+"?serverTimezone=GMT-3", user, password);
            //conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/autos?serverTimezone=GMT-3", user, password);
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(DAOAutoBD.class.getName()).log(Level.SEVERE, null, ex);
            throw new DaoException("No se pudo conectar: " + ex.getMessage());
        }
        
        
        
        buscarSql = "select a.vin, a.marca, a.modelo, a.color, a.fechaFab, a.cantPuertas, m.id, m.marca, m.modelo, m.cilindrada, m.tipoCombustible\n" +
                "from autos a\n" +
                "join motores m\n" +
                "  on a.idMotor = m.id\n" +
                "where UPPER(vin) = UPPER(?);\n";
       
        
        
        try 
        {
            psBuscar = conexion.prepareStatement(buscarSql);
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(DAOAutoBD.class.getName()).log(Level.SEVERE, null, ex);
            throw new DaoException(ex.getMessage());
        }
    
    }
    
    protected void guardarAuto(Auto obj) throws DaoException
    {
        try {
            crearAutoSql = "insert into autos (vin, marca, modelo, color, fechaFab, cantPuertas, idMotor) values ( ?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement st;
            st = conexion.prepareStatement(crearAutoSql);
            st.setString(1, obj.getVin());
            st.setString(2, obj.getMarca());
            st.setString(3, obj.getModelo());
            st.setString(4, obj.getColor());
            st.setString(5, FechaUtils.toString(obj.getFechaFab())); // ARREGLAR
            st.setInt(6, (obj.getCantPuertas()));
            st.setString(7, obj.getMotor().getId());
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOAutoBD.class.getName()).log(Level.SEVERE, null, ex);
            throw new DaoException(ex.getMessage());
        }
    }
    
    protected void guardarMotor(Motor obj)
    {
        try {
            crearMotorSql = "insert into motores (id, marca, modelo, cilindrada, tipoCombustible) values ( ?, ?, ?, ?, ?);";
            PreparedStatement st;
            st = conexion.prepareStatement("insert into motores (id, marca, modelo, cilindrada, tipoCombustible) values ( ?, ?, ?, ?, ?);");
            st.setString(1, obj.getId());
            st.setString(2, obj.getMarca());
            st.setString(3, obj.getModelo());
            st.setString(4, obj.getCilindrada());
            st.setString(5, obj.getTipoCombustible());
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOAutoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    protected Auto buscarAuto(String vin) throws DaoException{
        
        try {
            Auto auto = new Auto();
            
            ResultSet rs;
            PreparedStatement st = conexion.prepareStatement("select a.marca, a.modelo, a.color, a.fechaFab, a.cantPuertas, a.idMotor from autos a where UPPER(vin) = UPPER(?);");
            st.setString(1, vin);
            rs = st.executeQuery();
            if(!rs.next())
                return null;
            else
            {
                auto.setVin(vin);
                auto.setMarca(rs.getString("a.marca"));
                auto.setModelo(rs.getString("a.modelo"));
                auto.setColor(rs.getString("a.color"));
                auto.setFechaFab(FechaUtils.toCalendar((rs.getDate("a.fechaFab"))));
                auto.setCantPuertas(rs.getInt("a.cantPuertas"));
                auto.setMotor(new Motor(rs.getString("a.idMotor"), "", "", "", ""));
                return auto;
            }
        } catch (SQLException | VehiculoException ex) {
            Logger.getLogger(DAOAutoBD.class.getName()).log(Level.SEVERE, null, ex);
            throw new DaoException(ex.getMessage());
        }
    }
    protected Motor buscarMotor(String id) throws SQLException, DaoException{
        String buscarMotorsql = "select m.id, m.marca, m.modelo, m.cilindrada, m.tipoCombustible from motores m where UPPER(id) = UPPER(?);";
        
        PreparedStatement st = conexion.prepareStatement(buscarMotorsql);
        st.setString(1, id);
        ResultSet rs = st.executeQuery();
        
        if(!rs.next())
            return null;
        
        return getMotor(rs);
        
    }
    
    
    
    protected void cerrarConexion() throws DaoException{
        try {
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAOAutoBD.class.getName()).log(Level.SEVERE, null, ex);
            throw new DaoException("No se pudo cerrar conexion"+ex.getMessage());
        }
    }
    
    @Override
    public void guardar(Auto obj) throws DaoException {
            
        
        try {
            
            Motor motor;
            motor = buscarMotor(obj.getMotor().getId());
            if (motor == null) {
                guardarMotor(obj.getMotor());
            } else {
                actualizar(obj);
            }
            Auto auto = buscar(obj.getVin());
            
            if(auto==null){
                guardarAuto(obj);
            }
            else{
                actualizar(obj);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAOAutoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
            
    @Override
    public Auto buscar(String key) throws DaoException
    {
        ResultSet rs;

        try {

            psBuscar = conexion.prepareStatement(buscarSql);
            psBuscar.setString(1, key);
            rs = psBuscar.executeQuery();
            return getAuto(rs);
        } catch (SQLException ex) {
            Logger.getLogger(DAOAutoBD.class.getName()).log(Level.SEVERE, null, ex);
            throw new DaoException("HUBO UN PROBLEMA AL BUSCAR" + ex.getMessage());

        } catch (VehiculoException ex) {
            Logger.getLogger(DAOAutoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
                    
    @Override
    public List<Auto> obtenerTodos() throws DaoException //Reformar
    {

        PreparedStatement st;
        ResultSet rs;
        List<Auto> autos = new ArrayList<>();

        obtenerTodosSql = "select a.vin, a.marca, a.modelo, a.color, a.fechaFab, a.cantPuertas, m.id, m.marca, m.modelo, m.cilindrada, m.tipoCombustible \n"
                + "from autos a join motores m on a.idMotor = m.id;";

        try {

            st = conexion.prepareStatement(obtenerTodosSql);
            rs = st.executeQuery();

            while (rs.next()) {
                try {
                    Auto obj = new Auto();

                    obj.setVin(rs.getString("a.vin"));
                    obj.setMarca(rs.getString("a.marca"));
                    obj.setModelo(rs.getString("a.modelo"));
                    obj.setColor(rs.getString("a.color"));
                    obj.setFechaFab(FechaUtils.toCalendar(rs.getDate("a.fechaFab")));
                    obj.setCantPuertas(rs.getInt("a.cantPuertas"));
                    obj.setMotor(getMotor(rs));

                    autos.add(obj);
                } catch (VehiculoException ex) {
                    Logger.getLogger(DAOAutoBD.class.getName()).log(Level.SEVERE, null, ex);
                    throw new DaoException("HUBO UN PROBLEMA AL GENERAR VEHICULO" + ex.getMessage());
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOAutoBD.class.getName()).log(Level.SEVERE, null, ex);
            throw new DaoException("HUBO UN PROBLEMAS AL OBTENER TODOS LOS REGISTROS" + ex.getMessage());
        }

        if (autos.isEmpty()) {
            return null;
        }
        return autos;

    }
                          



    public Auto getAuto(ResultSet rs) throws DaoException, VehiculoException
    {
        Auto auto;
        
        try 
        {
            if(!rs.next())
                return null;
            
            auto = new Auto();
            
            auto.setVin(rs.getString("a.vin"));
            auto.setMarca(rs.getString("a.marca"));
            auto.setModelo(rs.getString("a.modelo"));
            auto.setColor(rs.getString("a.color"));
            auto.setFechaFab(FechaUtils.toCalendar(rs.getDate("a.fechaFab")));
            auto.setCantPuertas(rs.getInt("a.cantPuertas"));
            auto.setMotor(getMotor(rs));
        } 
        catch (SQLException | VehiculoException ex)
        {
            Logger.getLogger(DAOAutoBD.class.getName()).log(Level.SEVERE, null, ex);
            throw new DaoException(ex.getMessage(), ex);
        }
        
       return auto;
    }

    public Motor getMotor(ResultSet rs) throws DaoException
    {
          Motor motor;
          
          motor = new Motor();
        try 
        {
            motor.setId(rs.getString("m.id"));
            motor.setMarca(rs.getString("m.marca"));
            motor.setModelo(rs.getString("m.modelo"));
            motor.setCilindrada(rs.getString("m.cilindrada"));
            motor.setTipoCombustible(rs.getString("m.tipoCombustible"));
        } 
        catch (SQLException ex)
        {
          
            Logger.getLogger(DAOAutoBD.class.getName()).log(Level.SEVERE, null, ex);
            throw new DaoException("HUBO PROBLEMA EN OBTENER EL MOTOR"+ex.getMessage(), ex);
            
        }
        
        return motor;
    }
    
    
    @Override
    public void actualizar(Auto obj) throws DaoException{
        
        try {
            PreparedStatement st;
            actualizarAutoSql = "UPDATE autos SET marca = ?, modelo = ?, color = ?, fechaFab = ?, cantPuertas = ? where UPPER(vin) = UPPER(?);";
            actualizarMotorSql = "UPDATE motores SET marca = ?, modelo = ?, cilindrada = ?, tipoCombustible = ? where UPPER(id) = UPPER(?) ;";
            
            Motor motor = buscarMotor(obj.getMotor().getId());
            if(motor != null)
            {
                
                st = conexion.prepareStatement(actualizarMotorSql);
                st.setString(1, obj.getMotor().getMarca());
                st.setString(2, obj.getMotor().getModelo());
                st.setString(3, obj.getMotor().getCilindrada());
                st.setString(4, obj.getMotor().getTipoCombustible());
                st.setString(5, obj.getMotor().getId());
                st.executeUpdate();
      
            }else
            {
                guardarMotor(obj.getMotor());
            } 
            
            
            Auto auto = buscarAuto(obj.getVin());
            
            if(auto != null)
            {
                st = conexion.prepareStatement(actualizarAutoSql);
                st.setString(1, obj.getMarca());
                st.setString(2, obj.getModelo());
                st.setString(3, obj.getColor());
                st.setString(4, FechaUtils.toString(obj.getFechaFab()));
                st.setInt(5, obj.getCantPuertas());
                st.setString(6, obj.getVin());
                st.executeUpdate();
            }
            else
            {
                guardarAuto(obj);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOAutoBD.class.getName()).log(Level.SEVERE, null, ex);
            throw new DaoException(ex.getMessage());
        }

    }
        
        
    
    
    
        @Override
    public void eliminar(String vin) throws DaoException
    {
        PreparedStatement st;
        try {
            
            Auto auto = buscar(vin);
            if(auto == null)
                throw new DaoException("No se encontro el registro a eliminar");
            
            eliminarAutoSql = "delete from autos where UPPER(vin) = UPPER(?) ;";

            st = conexion.prepareStatement(eliminarAutoSql);
            st.setString(1, auto.getVin());
            st.executeUpdate();

            eliminarMotorSql = "delete from motores where UPPER(id) = UPPER(?) ;";
            st = conexion.prepareStatement(eliminarMotorSql);
            st.setString(1, auto.getMotor().getId());
            st.executeUpdate();

            }
            catch (SQLException ex) {
                Logger.getLogger(DAOAutoBD.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex.getErrorCode());
                throw new DaoException(ex.getMessage());
            }
    }
    


}
