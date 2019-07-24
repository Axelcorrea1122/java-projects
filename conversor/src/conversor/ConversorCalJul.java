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
public class ConversorCalJul extends Conversor{

    @Override
    public double aToB(double a) {
        return a * 4184;
    }

    @Override
    public double bToA(double b) {
        return b / 4184;
    }

    @Override
    public String nameA() {
        return "Calorias";
    }

    @Override
    public String nameB() {
        return "Julios";
    }
    
}
