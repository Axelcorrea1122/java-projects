/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.Calendar;
import java.util.Objects;

/**
 *
 * @author laboratorios
 */
public class Vehiculo implements Comparable <Vehiculo>
{
    
    protected String vin; //Vehicle Identification Number, numero de serie
    protected String marca;
    protected String modelo;
    protected String color;
    protected Calendar fechaFab;
    protected Motor motor;
    
    
    public  Vehiculo()
    {}

    public Vehiculo(String vin, String marca, String modelo, String color, Calendar fechaFab, Motor motor) throws VehiculoException
	{
		setVin(vin);
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
		this.fechaFab = fechaFab;
		this.motor = motor;
	}
    
    public Vehiculo(String txt)
	{
		//String[] campos = txt.split(",");
                String[] campos = txt.split("\t");
		
		this.vin = campos[0].trim();
		this.marca = campos[1].trim();
		this.modelo = campos[2].trim();
		this.color = campos[3].trim();
		this.fechaFab = FechaUtils.txtACalendar(campos[4]);
		this.motor = new Motor(campos[5].trim(), campos[6].trim(), campos[7].trim(), campos[8].trim(), campos[9].trim());
	}
    
    
    
    public String getVin() {
        return vin;
    }

    public void setVin(String vin) throws VehiculoException
	{
		if(vin == null || vin.length() != 17)
		{
			throw new VehiculoException("El VIN no contiene 17 caracteres. ");
		}
		this.vin = vin;
	}


    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) 
    {
        this.modelo = modelo;
    }
    
    public String getColor()
    {
	return color;
    }

    public void setColor(String color)
    {
	this.color = color;
    }

    public Calendar getFechaFab()
    {
	return fechaFab;
    }

    public void setFechaFab(Calendar fechaFab)
    {
	this.fechaFab = fechaFab;
    }

    public Motor getMotor() 
    {
        return motor;
    }

    public void setMotor(Motor motor) 
    {
        this.motor = motor;
    }
    
    @Override
    public String toString()
    {
	return vin + "\t" + String.format("%-30s", marca) + "\t" + String.format("%-30s", modelo) + "\t" + String.format("%-30s", color) + "\t" + FechaUtils.calendarATxt(fechaFab) + "\t" + motor.toString();
    }
     
    
    
    /*@Override
    public int hashCode()
    {
	int hash = 7;
	hash = 73 * hash + Objects.hashCode(this.vin);
	return hash;
    }	

    @Override
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
		final Vehiculo other = (Vehiculo) obj;
		if(!Objects.equals(this.vin, other.vin))
		{
			return false;
		}
		if(!Objects.equals(this.marca, other.marca))
		{
			return false;
		}
		if(!Objects.equals(this.modelo, other.modelo))
		{
			return false;
		}
		if(!Objects.equals(this.color, other.color))
		{
			return false;
		}
		if(!FechaUtils.equalFecha(this.fechaFab, other.fechaFab))// Llamar a método de FechaUtils que compare d,m y a.
		{
			return false;
		}
		if(!Objects.equals(this.motor, other.motor))
		{
			return false;
		}
		return true;
	}
    */

    /*@Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.vin);
        return hash;
    }

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
        final Vehiculo other = (Vehiculo) obj;
        if (!Objects.equals(this.vin, other.vin)) {
            return false;
        }
        return true;
    }*/

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.vin);
        return hash;
    }

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
        final Vehiculo other = (Vehiculo) obj;
        if (!Objects.equals(this.vin.toUpperCase(), other.vin.toUpperCase())) {
            return false;
        }
        if (!Objects.equals(this.marca.toUpperCase(), other.marca.toUpperCase())) {
            return false;
        }
        if (!Objects.equals(this.modelo.toUpperCase(), other.modelo.toUpperCase())) {
            return false;
        }
        if (!Objects.equals(this.color.toUpperCase(), other.color.toUpperCase())) {
            return false;
        }
        if (!Objects.equals(this.fechaFab, other.fechaFab)) {
            return false;
        }
        if (!Objects.equals(this.motor, other.motor)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Vehiculo t) {
        return this.vin.compareTo(t.vin);
    }

    



    

    
    
    


    
}
