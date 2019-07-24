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
public class ConversorMbKB extends Conversor {

    @Override
    public double aToB(double a) {
        return a * 125;
    }

    @Override
    public double bToA(double b) {
        return b / 125;
    }

    @Override
    public String nameA() {
        return "Megabit por Segundos";
    }

    @Override
    public String nameB() {
        return "KiloBytes por Segundos";
    }
    
}
