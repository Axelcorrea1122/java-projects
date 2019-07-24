/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author laboratorios
 */
public class DaoAutoTxt extends Dao<Auto, String>
{
    private RandomAccessFile archivoAutos;
    
    public DaoAutoTxt(String nombreArch) throws DaoException 
    {
        try 
        {
            archivoAutos = new RandomAccessFile(nombreArch, "rws");
        } 
        catch (FileNotFoundException ex) 
        {
            Logger.getLogger(DaoAutoTxt.class.getName()).log(Level.SEVERE, null, ex);
            throw new DaoException("No se encontró el archivo " + nombreArch + ": " + ex.getMessage());
        }
    }
    
    public void cerrarArchivo() throws IOException
    {
        archivoAutos.close();
    }

    
    @Override
    public Auto buscar(String key) throws DaoException
    {
        String linea;
        try {
            
            long posicion = buscarPosicion(key);
            
            if(posicion == -1)
                return null;
            
            archivoAutos.seek(posicion);
            linea = archivoAutos.readLine();
            
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(DaoAutoTxt.class.getName()).log(Level.SEVERE, null, ex);
            throw new DaoException(ex.getMessage());
        }
        
        Auto auto;
        
        try
	{
		auto = new Auto(linea);
	}
	catch(VehiculoException ex)
	{
			Logger.getLogger(DaoAutoTxt.class.getName()).log(Level.SEVERE, null, ex);
			throw new DaoException(ex.getMessage());
	}
        
        return auto;
    }

    @Override
    public List<Auto> obtenerTodos() throws DaoException
    {
        int cr=0;
        List<Auto> autos = new ArrayList<>();
		
		try
		{
			archivoAutos.seek(0);
			String linea;
			Auto auto;
			while((linea = archivoAutos.readLine()) != null)
			{
				auto = new Auto(linea);
				autos.add(auto);
                                cr++;
			}
                        
                        if(cr == 0)
                            return null;
		}
		catch(IOException | VehiculoException ex)
		{
			Logger.getLogger(DaoAutoTxt.class.getName()).log(Level.SEVERE, null, ex);
			throw new DaoException(ex.getMessage());
		}
		
		return autos;
        
    }

    @Override
    public void eliminar(String key) throws DaoException //Hacer
    {
        File temp= new File("F:\\restaurado\\DAO\\temp.txt");
        BufferedWriter fw;
        File archivo = new File("F:\\restaurado\\DAO\\AutoTest.txt");
        String nombreOrig = archivo.getName();
        try {
            temp.createNewFile();
            fw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(temp,true), "utf-8"));
           
        
        String linea;
        
        if(buscar(key)!=null)
        {
            
                archivoAutos.seek(0);
                while( (linea = archivoAutos.readLine()) != null)
                {
                    if(key.compareTo(linea.substring(0,17)) != 0)
                        fw.write(linea + System.lineSeparator());
                }
                
                fw.close();
                
                archivoAutos.close();
                archivo.delete();
                temp.renameTo(archivo);
                   
                archivoAutos = new RandomAccessFile(nombreOrig, "rws");
                
        }else{
            fw.close();
            throw new DaoException("NO SE ENCONTRO EL REGISTRO CON ESE VIN PARA ELIMINARLO");
        }
        }catch (IOException ex) {
            Logger.getLogger(DaoAutoTxt.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    private long buscarPosicion(String vin) throws IOException
    {
                String linea;
		boolean encontre = false;
		long posicion = 0;
		
		archivoAutos.seek(0);
		
		while(!encontre && (linea = archivoAutos.readLine()) != null)
		{
			encontre = linea.substring(0, 17).equalsIgnoreCase(vin);
			
			if(!encontre)
				posicion = archivoAutos.getFilePointer();
		}
		
		if(!encontre)
			return -1;
		
		return posicion;
    }


    @Override
    public void actualizar(Auto obj) throws DaoException { 
        String linea;
        
        try {
            long pos = buscarPosicion(obj.getVin());
            if(pos == -1)
            {
                guardar(obj);
            }
            else
            {
                archivoAutos.seek(pos);
                archivoAutos.writeBytes(obj.toString() + System.lineSeparator());
            }
        } catch (IOException ex) {
            Logger.getLogger(DaoAutoTxt.class.getName()).log(Level.SEVERE, null, ex);
            throw new DaoException(ex.getMessage());
        } catch (DaoException ex) {
            Logger.getLogger(DaoAutoTxt.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void guardar(Auto obj) throws DaoException {
        try 
        {
            long pos = buscarPosicion(obj.getVin());
            if(pos == -1)
                archivoAutos.writeBytes(obj.toString() + System.lineSeparator());
            else
                actualizar(obj);
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(DaoAutoTxt.class.getName()).log(Level.SEVERE, null, ex);
            throw new DaoException("No se pudo guardar el auto: " + ex.getMessage());
        }        
    }
    
}

