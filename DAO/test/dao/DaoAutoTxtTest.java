/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author laboratorios
 */
public class DaoAutoTxtTest 
{
    private static DaoAutoTxt daoAutoTxt;
    static List<Auto> autos = new ArrayList<>();
    static String auto1 = "AXELCORREA1234567,VOLKSWAGEN,BOYAGE,NEGRO,2/1/2019,H10,VOLKSWAGEN,V8,1.6,NAFTA,5";
    static String auto2 = "pablocorrea123456,renault,sandero,blanco,18/6/2019,H5,renault,v6,1.8,NAFTA,5";
    static String auto3 = "ManuelGonzalez123,Peugot,308,Gris,24/4/2018,H12,Peugot,V10,1.4,Gnc,5";
    static String auto4 = "yesicaCorrea;[]'.,FIAT,FIORINO,ROJO,6/5/2017,H15,FIAT,V4,1.2,NAFTA,3";
    static String auto5 = "LUCIANAANDRADA\";*,FORD,KA,AMARILLO,8/12/2015,H14,FORD,V5,1.5,GNC,3";
    
    public DaoAutoTxtTest() 
    {
    }
    ///METODO PARA GUARDAR UN REGISTRO
    private void guardar(Auto obj) throws DaoException{
        daoAutoTxt.guardar(obj);
    }
    ///METODO PARA BUSCAR A TRAVEZ DEL VIN
    private Auto buscar(String key) throws DaoException{
        return daoAutoTxt.buscar(key);
    }
    
    ///METODO PARA ELIMINAR LA LISTA INICIAL CARGADA EN EL ARCHIVO
    private void eliminarListaArch(List<Auto> lista) throws DaoException
    {
        for(Auto au:lista)
        {
            daoAutoTxt.eliminar(au.getVin());
        }
    }
    ///METODO PARA ELIMINAR UN REGISTRO
    private void eliminar(String key) throws DaoException{
        daoAutoTxt.eliminar(key);
    }
    
    ///METODO PARA GUARDAR LA LISTA INICIAL EN EL ARCHIVO
    private void guardarListaArch(List<Auto> lista) throws DaoException
    {
        for(Auto au:lista)
        {
            daoAutoTxt.guardar(au);
        }
    }
    
    @BeforeClass
    public static void setUpClass() 
    {
        try 
        {
            daoAutoTxt = new DaoAutoTxt("AutoTest.txt");
            autos.add(new Auto(auto1, auto1.length()+1));
            autos.add(new Auto(auto2, auto2.length()+1));
            autos.add(new Auto(auto3, auto3.length()+1));
            autos.add(new Auto(auto4, auto4.length()+1));
            autos.add(new Auto(auto5, auto5.length()+1));
            
        } 
        catch (DaoException ex) 
        {
            Logger.getLogger(DaoAutoTxtTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @AfterClass
    public static void tearDownClass() throws IOException {
        
         daoAutoTxt.cerrarArchivo();
    }
    
    @Before
    public void setUp() throws DaoException
    {
        RandomAccessFile raf;
        
        try 
        {
            raf = new RandomAccessFile("AutoTest.txt", "rw");
            raf.setLength(0); //Crea el archivo. vacio
            guardarListaArch(autos);
            raf.close();
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(DaoAutoTxtTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @After
    public void tearDown() throws DaoException {
        if(daoAutoTxt.obtenerTodos() != null)
            eliminarListaArch(autos);
        
    }


    
    
    
    
    @Test
    public void testGuardar() throws Exception 
    {
        System.out.println("guardarOActualizar");

        Auto autoEsperado = new Auto(4, "XAG467FGSD2358XBG", "Toyota", "Hilux", "Rojo", new GregorianCalendar(2015, Calendar.JULY, 23), new Motor("1", "VW", "V8", "2000", "GNC")); //REGISTRO NUEVO 
        daoAutoTxt.guardar(autoEsperado);
        Auto autoObtenido = daoAutoTxt.buscar(autoEsperado.getVin()); //LO BUSCA EN EL ARCHIVO
        assertEquals(autoEsperado, autoObtenido);  // LOS COMPARA DEBEN SER IGUALES
        eliminar("XAG467FGSD2358XBG");
        
        String autoprueba1 = "AXELCORREA1234567,renault,clio,verde,2/1/2019,H12,VOLKSWAGEN,v6,1.4,gnc,5"; //MISMO VIN QUE EL PRIMER OBJETO DE LA LISTA EN VEZ DE GUARDAR 
        Auto prueba1 = new Auto(autoprueba1, autoprueba1.length()+1);//DEBE ACTUALIZAR...
        daoAutoTxt.guardar(prueba1);
        assertEquals(prueba1, buscar(prueba1.getVin()));  //COMPARACION DEBERIAN SER iguales

        
        
        String autoprueba2 = "PLMNKOIJBVHUYGCXF,PEUGOT,206,BLANCO,11/7/2019,H23,PEUGOT,V9,1.3,GNC,5";    //REGISTRO NUEVO
        Auto prueba2 = new Auto(autoprueba2, autoprueba2.length()+1);
        daoAutoTxt.guardar(prueba2);                                 //SE GUARDAR
        assertEquals(prueba2, buscar(prueba2.getVin()));  //BUSCA EL OBJETO CARGADO EN EL ARCHIVO DEBERIA SER IGUAL AL OBJETO CREADO
        eliminar(prueba2.getVin());
        
        
        
        String autoprueba3 = "ManuelGonzalez123,Peugot,308,Gris,24/4/2018,H10,Peugot,V12,1.9,NAFTA,5"; // YA SE ENCUENTRA CARGADO EN EL ARCHIVO
        Auto prueba3 = new Auto(autoprueba3, autoprueba3.length()+1);                                  //DEBERIA ACTUALIZAR EL ID DEL MOTOR Y OTROS CAMPOS
        daoAutoTxt.guardar(prueba3);
        assertEquals(prueba3, buscar(prueba3.getVin()));
        
        
    }

    /**
     * Test of buscar method, of class DaoAutoTxt.
     */
    
    @Test
    public void testBuscar() throws Exception {
        System.out.println("buscar");
        Auto expResult;
        Auto result;
        
        
        Auto prueba = new Auto(auto1,auto1.length()+1); //YA SE ENCUENTRA CARGADO ESTE AUTO DEBERIA ENCUENTRA EL MISMO QUE DE LA LISTA
        assertEquals(prueba,daoAutoTxt.buscar(prueba.getVin()));
        
        
        String autoprueba2 = "qwertyuiopasdfghj,Chevrolet,Camaro,Amarillo,9/9/2018,h21,Chevrolet,v8,1.8,nafta,5";//  2DA - NO SE ENCUENTRA EN EL ARCHIVO
        assertNull(daoAutoTxt.buscar("qwertyuiopasdfghj"));                                                               //DEBE RETORNAR NULL
        
        
        String autoprueba3 = "PaBlocoRREa123456,renault,sandero,blanco,18/6/2019,H5,renault,v6,1.8,NAFTA,5";  // YA SE ENCUENTRA EN EL ARCHIVO
        prueba = new Auto(autoprueba3, autoprueba3.length()+1);
        assertEquals(prueba, daoAutoTxt.buscar(prueba.getVin()));
        
       
        
        for(Auto au:autos) // BUSQUEDA DE LA LISTA<AUTO> EN EL ARCHIVO  DEBERIA ENCONTRAR TODOS
        {
            String key = au.getVin();
        
            expResult = new Auto(au.getCantPuertas(),au.getVin(), au.getMarca(), au.getModelo(), au.getColor(),au.getFechaFab(),au.getMotor());
            result = daoAutoTxt.buscar(key);
            assertEquals(expResult, result);
        }
    }

    
    @Test
    public void testObtenerTodos() throws Exception
    {
        System.out.println("getTodos");
        
        List<Auto> result = daoAutoTxt.obtenerTodos();  //SE COMPARA LA LISTA CON LOS 5 REGISTROS QUE SE INICIAN EN LA TEST 
        List<Auto> expResult = autos;          //DEBERIAN SER IGUALES
        assertEquals(expResult, result);

        String autoprueba1 = "qwertyuiopasdfghj,Chevrolet,Camaro,Amarillo,9/9/2018,h21,Chevrolet,v8,1.8,nafta,5"; //SE INSERTA UN NUEVO REGISTRO EN EL ARCHIVO
        Auto prueba1 = new Auto(autoprueba1, autoprueba1.length()+1);
        guardar(prueba1);
        result = daoAutoTxt.obtenerTodos();//SE COMPARA LA MISMA LISTA PERO CON UN REGISTRO DE MAS EN EL ARCHIVO
        assertNotEquals(autos, result);//DEBERIAN SER DISTINTAS
        eliminar(prueba1.getVin());
        
        eliminarListaArch(autos); //ELIMINA TODOS LOS REGISTROS DEL ARCHIVO
        
        result = daoAutoTxt.obtenerTodos();  ///SE COMPRA LA LISTA CON EL ARCHIVO QUE ESTA VACIO
        assertNull(result);       ///SE ESPERA NULL
        
    }

 
    
    @Test
    public void testEliminar() throws Exception
    {
        System.out.println("eliminar");
        String key = "AXELCORREA1234567"; //SE ENCUENTRA EN EL ARCHIVO 
        daoAutoTxt.eliminar(key);          //POR LO TANTO SE ELIMINA
        assertNull(buscar("AXELCORREA1234567"));
        
        String autoprueba2 = "\';/.#mnbvcxzas12"; //EL VIN NO SE ENCUENTRA ES DECIR QUE NO EXISTE EL REGISTRO CON ESE VIN
        Auto prueba2;
        try{
            daoAutoTxt.eliminar(autoprueba2);
        }catch(DaoException ex){         // COMO NO SE ENCUENTRA EL REGISTRO DEBERIA LANZAR EXCEPCION
            prueba2 = null;                     
            assertNull(prueba2);
        }
        
        String autoprueba3 = "LUCIANAANDRADA\";*";  //El REGISTRO YA SE ENCUENTRA CARGADO EN EL ARCHIVO
        daoAutoTxt.eliminar(autoprueba3);                  //DEBERIA ELIMINARLO
        assertNull(buscar(autoprueba3));            //DEBERIA RETORNAR NULL
        
        
        String autoprueba4 = "qsczs753159852456,fiat,siena,blanco,6/8/2015,h51,fiat,v8,1.8,nafta,4";  //SE INSERTA UN NUEVO REGISTRO
        Auto prueba4 = new Auto(autoprueba4, autoprueba4.length()+1);
        guardar(prueba4);
        daoAutoTxt.eliminar(prueba4.getVin());                                                       //LUEGO SE BORRA
        assertNull(buscar(prueba4.getVin()));                                                        //COMO NO SE ENCUENTRA LA BUSQUEDA DEBERIA RETORNAR NULL
        
        
        
        List<Auto> restantes = daoAutoTxt.obtenerTodos();    // ELIMINA LOS RESGISTROS RESTANTE
        for(Auto au:restantes)
        {
            String vin = au.getVin();
            daoAutoTxt.eliminar(vin);
            assertNull(buscar(vin));
        }
    }
    

    
    @Test
    public void testActualizar() throws VehiculoException, DaoException
    {
        System.out.println("actualizar");
        
        String autoprueba1 = "ManuelGonzalez123,Mercedes Benz,508,Negro,24/4/2015,H12,Peugot,V10,1.4,Gnc,5";  //REGISTRO YA CARGADO EN EL TXT
        Auto prueba1 = new Auto(autoprueba1, autoprueba1.length()+1);
        daoAutoTxt.actualizar(prueba1);                                 //DEBE ACTUALIZARLO
        assertEquals(prueba1, buscar(prueba1.getVin()));                  ///COMPARA EL OBJETO deben ser iguales

        
        
        String autoprueba2 = "789456123qwertyui,VOLKWAGEN,GOLD,GRIS,20/6/2019,H28,VOLKSWAGEN,V11,1.8,GNC,5";  //REGISTRO NUEVO COMO NO LO ENCUENTRA PARA ACTUALIZAR
        Auto prueba2 = new Auto(autoprueba2, autoprueba2.length()+1);                                            //LO GUARDA EN EL ARCHIVO
        daoAutoTxt.actualizar(prueba2);
        assertEquals(prueba2,buscar(prueba2.getVin()));
        eliminar(prueba2.getVin());
        
        String autoprueba3 = "yesicaCorrea;[]'.,FORD,KA,AMARILLO,8/12/2015,H14,FORD,V5,1.5,GNC,3";    // EL REGISTRO YA SE ENCUENTRA 
        Auto prueba3 = new Auto(autoprueba3, autoprueba3.length()+1);                                 //DEBERIA ACTUALIZAR LOS CAMPOS DEL REGISTRO... INTERCAMBIA LOS CAMPOS CON EL REGISTRO DE ABAJO
        daoAutoTxt.actualizar(prueba3);
        assertEquals(prueba3, buscar(prueba3.getVin())); //COMPARA EL OBJETO debe ser iguales
       
    
        
        
        
        String autoprueba4 = "LUCIANAANDRADA\";*,FIAT,FIORINO,ROJO,6/5/2017,H15,FIAT,V4,1.2,NAFTA,3"; //YA SE ENCUENTRA 
        Auto prueba4 = new Auto(autoprueba4, autoprueba4.length()+1);                                 //ACTUALIZA EL REGISTRO                                                                     
        daoAutoTxt.actualizar(prueba4);
        assertEquals(prueba4, buscar(prueba4.getVin()));                                              //REALIZA COMPARACION ANTES Y DESPUES DE ACTUALIZAR... INTERCAMBIA LOS CAMPOS CON EL REGISTRO DE ARRIBA
        
    }
    
    
    
    
}
