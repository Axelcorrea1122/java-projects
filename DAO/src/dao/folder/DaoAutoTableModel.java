/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.folder;

import dao.Auto;
import dao.DAOAutoBD;
import dao.DaoException;
import dao.FechaUtils;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author axelc
 */
class DaoAutoTableModel extends AbstractTableModel{

    private DAOAutoBD dao;
    private List<Auto> datos = new ArrayList<>();
    public DaoAutoTableModel(DAOAutoBD dao){
        this.dao = dao; 
    }
    
    
    public void updateModel() throws DaoException{
        datos = dao.obtenerTodos();
    }
    
    
    @Override
    public String getColumnName(int column) {
        switch (column){
            case 0: return "Vin";
            case 1: return "Marca";
            case 2: return "Modelo";
            case 3: return "Color";
            case 4: return "fechaFab";
            case 5: return "cantPuertas";
            case 6: return "idMotor";
            case 7: return "Marca";
            case 8: return "Modelo";
            case 9: return "Cilindrada";
            case 10: return "tipoCombustible";
        }
        return null;
    }

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return 10;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Auto preguntado = datos.get(rowIndex);
        switch (columnIndex) {
            case 0: return preguntado.getVin();
            case 1: return preguntado.getMarca();
            case 2: return preguntado.getModelo();
            case 3: return preguntado.getColor();
            case 4 : return FechaUtils.toString(preguntado.getFechaFab());
            case 5: return preguntado.getCantPuertas();
            case 6: return preguntado.getMotor().getId();
            case 7: return preguntado.getMotor().getMarca();
            case 8: return preguntado.getMotor().getModelo();
            case 9: return preguntado.getMotor().getCilindrada();
            case 10: return preguntado.getMotor().getTipoCombustible();
            default: return "";
            
        }
    }
}
