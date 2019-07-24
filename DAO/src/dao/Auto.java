/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author laboratorios
 */
public class Auto extends Vehiculo    
{
    private int cantPuertas;
    
    
    public Auto(){
        super.vin = null;
        super.marca = null;
        super.modelo = null;
        super.fechaFab = new GregorianCalendar();
        cantPuertas = 0;
        super.motor = null;
    }
    
    
    public Auto(int cantPuertas, String vin, String marca, String modelo, String color, Calendar fechaFab, Motor motor) throws VehiculoException
	{
		super(vin, marca, modelo, color, fechaFab, motor);
		this.cantPuertas = cantPuertas;
	}
    
    Auto(String linea) throws VehiculoException
	{
		super(linea.substring(0, 190));
		
		this.cantPuertas = Integer.valueOf(linea.substring(191));
	}
    
    Auto(String linea, int longitud)
    {
        String[] campos = linea.split(",");
        
        this.vin = campos[0];
	this.marca = campos[1];
	this.modelo = campos[2];
	this.color = campos[3];
	this.fechaFab = FechaUtils.txtACalendar(campos[4]);
	this.motor = new Motor(campos[5], campos[6], campos[7], campos[8], campos[9]);
        
        this.cantPuertas = Integer.valueOf(linea.substring(longitud-2));
    }
    

    
    public int getCantPuertas() 
    {
        return cantPuertas;
    }

    public void setCantPuertas(int cantPuertas) 
    {
        this.cantPuertas = cantPuertas;
    }
    
    @Override
	public String toString()
	{
            
            return super.toString() + "\t" + String.format("%d", cantPuertas);
	}

        
	/*@Override
	public boolean equals(Object obj)
	{
		if(this == obj)
		{
			return true;
		}
		if(obj == null)
		{
			return false;
		}
		if(getClass() != obj.getClass())
		{
			return false;
		}
		final Auto other = (Auto) obj;
		
		if(!((Vehiculo)this).equals(other)) // !super.equals(other)
			return false;
		
		if(this.cantPuertas != other.cantPuertas)
		{
			return false;
		}
		return true;
	}*/


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Auto other = (Auto) obj;
        
        if(!super.equals(other))
            return false;
        if (this.cantPuertas != other.cantPuertas) {
            return false;
        }
        return true;
    }
        
   
    

}
