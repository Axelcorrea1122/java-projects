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
public class ConversorKmHoraMSeg extends Conversor {

    @Override
    public double aToB(double a) {
        return a / 3.6;
    }

    @Override
    public double bToA(double b) {
        return b * 3.6; 
    }

    @Override
    public String nameA() {
        return "Kilometros/Hora";
    }

    @Override
    public String nameB() {
        return "Metros/Segundos";
    }
    
}
