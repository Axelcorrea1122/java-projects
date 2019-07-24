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
public class ConversorLibrasKilogramos extends Conversor {

    @Override
    public double aToB(double a) {
        return a / 2.205;
    }

    @Override
    public double bToA(double b) {
        return b * 2.205;
    }

    @Override
    public String nameA() {
        return "Libras";
    }

    @Override
    public String nameB() {
        return "Kilogramos";
    }
    
}
