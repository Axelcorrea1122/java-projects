/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conversor;

/**
 *
 * @author axelc
 */
public class ConversorCelsiusKelvin extends Conversor {

    @Override
    public double aToB(double a) {
        return a + 273.15;
    }

    @Override
    public double bToA(double b) {
        return b - 273.15;
    }

    @Override
    public String nameA() {
        return "Celsius";
    }

    @Override
    public String nameB() {
       return "Kelvin";
    }
    
}
