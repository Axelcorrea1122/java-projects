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
public class ConversorFahCelsius extends Conversor{

    @Override
    public double aToB(double a) {
        return (a - 32) * (5/9);
    }

    @Override
    public double bToA(double b) {
        return (b * (9/5)) + 32;
    }

    @Override
    public String nameA() {
        return "Fahrenheit";
    }

    @Override
    public String nameB() {
        return "Celsius";
    }
    
}

   