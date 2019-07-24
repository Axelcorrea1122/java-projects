/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author axelc
 */
public class DAOAutoBDTest {
    
        static List<Auto> autos = new ArrayList<>();
        static String auto1 = "AXELCORREA1234567,VOLKSWAGEN,BOYAGE,NEGRO,2/1/2019,H10,VOLKSWAGEN,V8,1.6,NAFTA,5";
        static String auto2 = "pablocorrea123456,renault,sandero,blanco,18/6/2019,H5,renault,v6,1.8,NAFTA,5";
        static String auto3 = "ManuelGonzalez123,Peugot,308,Gris,24/4/2018,H12,Peugot,V10,1.4,Gnc,5";
        static String auto4 = "yesicaCorrea;[]'.,FIAT,FIORINO,ROJO,6/5/2017,H15,FIAT,V4,1.2,NAFTA,3";
        static String auto5 = "LUCIANAANDRADA\";*,FORD,KA,AMARILLO,8/12/2015,H14,FORD,V5,1.5,GNC,3";
        static DAOAutoBD dao;
        Connection conexion;
        
    
    public DAOAutoBDTest() throws SQLException {
        conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/autos?serverTimezone=GMT-3", "root", "Correa1122");
    }
    
    
    
    ///METODO QUE GUARDA LOS AUTOS DE LA LISTA
    public void guardarLista(List<Auto> lista) throws DaoException
    {
        for(Auto au:lista)
            dao.guardar(au);         
    }
    
    //METODO QUE ELIMINA UN SOLO REGISTRO A TRAVEZ DEL VIN
    public void eliminar(String vin) throws DaoException
    {
        dao.eliminar(vin);
    }
    //METODO QUE ELIMINA LOS AUTOS DE LA LISTA
    public void eliminarLista(List<Auto> lista) throws DaoException
    {
        
        for(Auto au:lista)
        {
            String vin = au.getVin();
            dao.eliminar(vin);
        }        
    }
    //METODO QUE BUSCA UN OBJETO AUTO A TRAVES DEL VIN
    public Auto buscar(String vin) throws DaoException
    {
        Auto auto = dao.buscar(vin);
        return auto;       
    }
    
    @BeforeClass
    public static void setUpClass() throws DaoException, SQLException {
        
        dao = new DAOAutoBD("localhost", "autos",3306, "root", "Correa1122");
        autos.add(new Auto(auto1,auto1.length()+1));
        autos.add(new Auto(auto2,auto2.length()+1));
        autos.add(new Auto(auto3,auto3.length()+1));
        autos.add(new Auto(auto4,auto4.length()+1));
        autos.add(new Auto(auto5,auto5.length()+1));
    }
    
    @AfterClass
    public static void tearDownClass() throws DaoException {
        dao.cerrarConexion();
    }
    
    @Before
    public void setUp() throws DaoException, SQLException {
        guardarLista(autos);
    }
    
    @After
    public void tearDown() throws Exception {
        
        
        PreparedStatement st = conexion.prepareStatement("DELETE FROM autos");
        st.executeUpdate();
        
        st = conexion.prepareStatement("DELETE FROM motores");
        st.executeUpdate();
        
    }
    
    
    @Test
    public void testGuardar() throws DaoException{
        
        System.out.println("guardarOactualizar");
        
                             //AXELCORREA1234567,VOLKSWAGEN,BOYAGE,NEGRO,2/1/2019,H10,VOLKSWAGEN,V8,1.6,NAFTA,5
        String autoprueba1 = "AXELCORREA1234567,renault,clio,verde,2/1/2019,H10,VOLKSWAGEN,v6,1.4,gnc,5"; //MISMO VIN QUE EL PRIMER OBJETO DE LA LISTA EN VEZ DE  
        Auto prueba1 = new Auto(autoprueba1, autoprueba1.length()+1);//DEBE ACTUALIZAR...
        dao.guardar(prueba1);
        assertEquals(prueba1,buscar(prueba1.getVin()));  //COMPARACION DEBERIAN SER IGUALES
        
        String autoprueba2 = "PLMNKOIJBVHUYGCXF,PEUGOT,206,BLANCO,11/7/2019,H23,PEUGOT,V9,1.3,GNC,5";    //REGISTRO NUEVO
        Auto prueba2 = new Auto(autoprueba2, autoprueba2.length()+1);
        dao.guardar(prueba2);                                      //SE GUARDAR
        assertEquals(prueba2, dao.buscar(prueba2.getVin()));  //BUSCA EL OBJETO CARGADO EN LA BASE DE DATO DEBERIA SER IGUAL AL OBJETO CREADO
        
                               //ManuelGonzalez123,Peugot,308,Gris,24/4/2018,H12,Peugot,V10,1.4,Gnc,5
        String autoprueba3 = "ManuelGonzalez123,Peugot,308,Gris,24/4/2018,H12,Peugot,V12,1.9,NAFTA,5"; // YA SE ENCUENTRA CARGADO EN LA BASE DE DATOS
        Auto prueba3 = new Auto(autoprueba3, autoprueba3.length()+1);                                  //DEBERIA ACTUALIZAR EL ID DEL MOTOR Y OTROS CAMPOS
        dao.guardar(prueba3);
        assertEquals(prueba3, dao.buscar(prueba3.getVin()));
        
    }
    

    

    @Test
    public void testBuscar() throws Exception {
        System.out.println("buscar");
        Auto expResult;
        Auto result;
        
        Auto pruebaSoloAuto = new Auto(5,"pablocorrea123456", "renault", "sandero", "blanco", new GregorianCalendar(2019, Calendar.JUNE, 18), new Motor("H5","","","",""));
        assertEquals(pruebaSoloAuto, dao.buscarAuto("pablocorrea123456"));
        
        Motor pruebaMotor = new Motor("H10", "VOLKSWAGEN", "V6", "1.4", "gnc");
        assertEquals(pruebaMotor, dao.buscarMotor(pruebaMotor.getId()));
        Auto prueba = new Auto(auto1,auto1.length()+1); //YA SE ENCUENTRA CARGADO ESTE AUTO DEBERIA ENCUENTRA EL MISMO QUE DE LA LISTA
        assertEquals(prueba,dao.buscar(prueba.getVin()));
        
        
        String autoprueba2 = "qwertyuiopasdfghj,Chevrolet,Camaro,Amarillo,9/9/2018,h21,Chevrolet,v8,1.8,nafta,5";//  2DA - NO ENCUENTRA 
        assertNull(dao.buscar("qwertyuiopasdfghj"));                                                               //RETORNA NULL
        
        
        String autoprueba3 = "PaBlocoRREa123456,renault,sandero,blanco,18/6/2019,H5,renault,v6,1.8,NAFTA,5";  // YA SE ENCUENTRA EN LA BASE DE DATOS
        prueba = new Auto(autoprueba3, autoprueba3.length()+1);
        assertEquals(prueba, dao.buscar(prueba.getVin()));
        
       
        
        for(Auto au:autos) // BUSQUEDA DE LA LISTA<AUTO> autos DEBERIA ENCONTRAR TODOS
        {
            String key = au.getVin();
        
            expResult = new Auto(au.getCantPuertas(),au.getVin(), au.getMarca(), au.getModelo(), au.getColor(),au.getFechaFab(),au.getMotor());
            result = dao.buscar(key);
            assertEquals(expResult, result);
        }
    }
    
   
    

    @Test
    public void testGetTodos() throws DaoException{

        System.out.println("getTodos");
        List<Auto> result = dao.obtenerTodos();  //SE COMPARA LA LISTA OBTENIDA DE LA BASE CON LOS 5 REGISTROS QUE SE INICIAN EN LA TEST 
        List<Auto> listaCopiada = new ArrayList<>(autos);
        List<Auto> expResult = listaCopiada;          //DEBERIAN SER IGUALES
        Collections.sort(expResult);
        assertEquals(expResult, result);   
        
        String autoprueba1 = "qwertyuiopasdfghj,Chevrolet,Camaro,Amarillo,9/9/2018,h21,Chevrolet,v8,1.8,nafta,5"; //SE INSERTA UN NUEVO REGISTRO EN LA BASE
        Auto prueba1 = new Auto(autoprueba1, autoprueba1.length()+1);
        listaCopiada.add(prueba1);
        dao.guardar(prueba1);
        
        eliminarLista(listaCopiada);///SE ELIMINA TODOS LOS REGISTROS DE LA BASE DE DATOS
        
        result = dao.obtenerTodos();  ///SE COMPARA LA LISTA CON LA BASE QUE ESTA VACIA
        assertNull(result);       ///SE ESPERA NULL
       
        
    }
    
    
    
    @Test
    public void testActualizar() throws DaoException {
        System.out.println("actualizar");
        
        String autoprueba0 = "qrtnvuchjilok1234,fiat,palio,verde,13/7/2019,H10,VOLKSWAGEN,V8,1.6,NAFTA,5";          ///MOTOR YA EXISTENTE DEBERIA ACTUALIZAR MOTOR 
        Auto prueba0 = new Auto(autoprueba0, autoprueba0.length()+1);  
        dao.actualizar(prueba0);
        assertEquals(prueba0, buscar(prueba0.getVin()));
        
        
        
        
        String autoprueba1 = "789456123qwertyui,VOLKWAGEN,GOLD,GRIS,20/6/2019,H28,VOLKSWAGEN,V11,1.8,GNC,5";  //REGISTRO NUEVO COMO NO LO ENCUENTRA
        Auto prueba1 = new Auto(autoprueba1, autoprueba1.length()+1);                                            //LO GUARDA EN LA BASE DE DATOS
        dao.actualizar(prueba1);
        assertEquals(prueba1,buscar(prueba1.getVin()));
        
        
        
                                //yesicaCorrea;[]'.,FIAT,FIORINO,ROJO,6/5/2017,H15,FIAT,V4,1.2,NAFTA,3
        String autoprueba2 = "yesicaCorrea;[]'.,FORD,KA,AMARILLO,8/12/2015,H15,FORD,V5,1.5,GNC,3";    // EL REGISTRO YA SE ENCUENTRA 
        Auto prueba2 = new Auto(autoprueba2, autoprueba2.length()+1);                                 //DEBERIA ACTUALIZAR LOS CAMPOS DEL REGISTRO... INTERCAMBIA LOS CAMPOS CON EL REGISTRO DE ABAJO
        dao.actualizar(prueba2);
        assertEquals(prueba2, buscar(prueba2.getVin())); //COMPARA EL OBJETO ANTES DE ACTUALIZAR Y DESPUES Y VERIFICA QUE SON IGUALES
        
        
        
                            //LUCIANAANDRADA\";*,FORD,KA,AMARILLO,8/12/2015,H14,FORD,V5,1.5,GNC,3
        String autoprueba3 = "LUCIANAANDRADA\";*,FIAT,FIORINO,ROJO,6/5/2017,H14,FIAT,V4,1.2,NAFTA,3"; //YA SE ENCUENTRA 
        Auto prueba3 = new Auto(autoprueba3, autoprueba3.length()+1);                                 //ACTUALIZA EL REGISTRO                                                                   
        dao.actualizar(prueba3);
        assertEquals(prueba3, buscar(prueba3.getVin()));         //REALIZA COMPARACION y busca el mismo objeto... INTERCAMBIA LOS CAMPOS CON EL REGISTRO DE ARRIBA
        
       String pruebaauto4 = "ercvfgbntyu123456,toyota,hilux,blanco,13/7/2019,h89,toyota,b8,1.4,gnc,5";    ///VIN EXISTENTE SIN MOTOR
       Auto prueba4 = new Auto(pruebaauto4, pruebaauto4.length()+1);
       dao.actualizar(prueba4);
       assertEquals(prueba4, buscar(prueba4.getVin()));
        
    }
    


    
    
    
    @Test
    public void testEliminar() throws Exception {
        
        System.out.println("eliminar");
        List<Auto> listaCopiada = new ArrayList<>(autos);
        
        String autoprueba1 = "\';/.#mnbvcxzas12"; //EL VIN NO SE ENCUENTRA ES DECIR QUE NO EXISTE EL REGISTRO CON ES VIN
        Auto prueba1;
        try{
            dao.eliminar(autoprueba1);
        }catch(DaoException ex){         // COMO NO SE ENCUENTRA EL REGISTRO DEBERIA LANZAR NULLPOINTER
            prueba1 = null;                     
            assertNull(prueba1);
        }
        
        
        
        String autoprueba2 = "LUCIANAANDRADA\";*";  //El REGISTRO YA SE ENCUENTRA CARGADO
        dao.eliminar(autoprueba2);                  //DEBERIA ELIMINARLO
        listaCopiada.remove(4);
        assertNull(buscar(autoprueba2));            //DEBERIA RETORNAR NULL
        
        String autoprueba3 = "qsczs753159852456,fiat,siena,blanco,6/8/2015,h51,fiat,v8,1.8,nafta,4";  //SE INSERTA UN NUEVO REGISTRO Y LUEGO SE ELIMINA 
        Auto prueba3 = new Auto(autoprueba3, autoprueba3.length()+1);
        dao.guardar(prueba3);
        dao.eliminar(prueba3.getVin());                                                              //LUEGO SE BORRA
        assertNull(buscar(prueba3.getVin()));                                                        //COMO NO SE ENCUENTRA LA BUSQUEDA DEBERIA RETORNAR NULL
        
        
        for(Auto au:listaCopiada)
        {
            String vin = au.getVin();
            dao.eliminar(vin);
            Auto auto = buscar(vin);
            assertNull(auto);
        }
    }
    
}
