/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.util.Objects;

/**
 *
 * @author laboratorios
 */
public class Motor 
{
    private String id;
    private String marca;
    private String modelo;
    private String cilindrada;
    private String tipoCombustible;
    
    public Motor(String id, String marca, String modelo, String cilindrada, String tipoCombustible)
	{
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.cilindrada = cilindrada;
		this.tipoCombustible = tipoCombustible;
	}

    public Motor() 
    {    
    }

    public String getId() 
    {
        return id;
    }

    public void setId(String nroSerie) 
    {
        this.id = nroSerie;
    }

    public String getMarca() 
    {
        return marca;
    }

    public void setMarca(String marca) 
    {
        this.marca = marca;
    }

    public String getModelo() 
    {
        return modelo;
    }

    public void setModelo(String modelo) 
    {
        this.modelo = modelo;
    }

    public String getCilindrada() 
    {
        return cilindrada;
    }

    public void setCilindrada(String cilindrada) 
    {
        this.cilindrada = cilindrada;
    }
    
    public String getTipoCombustible()
    {
		return tipoCombustible;
    }
	
	
    public void setTipoCombustible(String tipoCombustible)
    {
		this.tipoCombustible = tipoCombustible;
    }
    
    
    @Override
    public String toString()
    {
     
        return  String.format("%-10s", id)
                + "\t" + String.format("%-20s", marca) 
                + "\t" + String.format("%-20s", modelo)
                + "\t" + String.format("%-4s", cilindrada)
                + "\t" + String.format("%-10s", tipoCombustible);
                
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.id);
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
        final Motor other = (Motor) obj;
        if (!Objects.equals(this.id.toUpperCase(), other.id.toUpperCase())) {
            return false;
        }
        return true;
    }
    
    
}
