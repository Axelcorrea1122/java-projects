/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

/**
 *
 * @author laboratorios
 */
public class DaoException extends Exception 
{
    public DaoException(String mensaje)
    {
        super(mensaje);
    }
    
    public DaoException(String mensaje, Throwable cause)
    {
        super(mensaje);
    }
}
