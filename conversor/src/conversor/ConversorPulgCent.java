/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conversor;

/**
 *a: Pulgadas
 * b: Centimetros
 * @author laboratorios
 */
public class ConversorPulgCent extends Conversor
{

    @Override
    public double aToB(double a) 
    {
        return a * 2.54;
    }

    @Override
    public double bToA(double b) {
       
        return b / 2.54;
    }

    @Override
    public String nameA() 
    {
        
        return "Pulgadas";
               
    }

    @Override
    public String nameB() 
    {
        return "Centimetros";
    }
}
