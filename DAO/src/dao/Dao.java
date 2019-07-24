/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.util.List;

/**
 *
 * @author laboratorios
 */
public abstract class Dao<T, K> 
{
    public abstract void guardar(T obj) throws DaoException;
   //public abstract void guardar(T obj) throws DaoException;
    public abstract T buscar(K key) throws DaoException;
    public abstract List<T> obtenerTodos() throws DaoException;
    public abstract void actualizar (T obj) throws DaoException;
    public abstract void eliminar(K key) throws DaoException;
}
