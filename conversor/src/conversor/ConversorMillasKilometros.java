/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conversor;

/**
 *
 * @author laboratorios
 */
public class ConversorMillasKilometros extends Conversor
{

    @Override
    public double aToB(double a) {
        
        return a * 1.609;
    }

    @Override
    public double bToA(double b) {
        
        return b / 1.609;
    }

    @Override
    public String nameA() {
     
        return "Millas";
    }

    @Override
    public String nameB() {
        return "Kilometros";
    }
    
}
