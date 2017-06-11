/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator1_2;

/**
 *
 * @author Cip
 */
public class OperatieSimpla {
    
    public char simbolOperatie[] = {'+', '-', '*', '/'};
    public String stringOperatie[] = {"adunare", "scadere", "inmultire", "impartire"};
    public char operatie;
    public int indexOperatie;
    boolean cunoscOperatia = true;
    public char operatieNecunoscuta = ' ';
    
    public OperatieSimpla(char operatiePrimita) {
     //   System.out.println("Constructor OperatieSimpla");
        
        if(verificaOperatie(operatiePrimita)) {
                this.operatie = simbolOperatie[indexOperatie];
            } else {
                cunoscOperatia = false;
                operatieNecunoscuta = operatiePrimita;
                System.out.println("Esti sigur ca ai bagat o operatie valida?");
            }
    }
    
    
    public boolean verificaOperatie(char operatiePrimita) {
    //    System.out.println("operatie.verificaOperaite()");
        boolean flag = true;
        for(int i = 0; i < simbolOperatie.length; i++) {
            if(operatiePrimita == simbolOperatie[i]) {
                indexOperatie = i;
                return true;
            } else {
                
                flag = false;
            }
        }
        return flag;
    }
    
    public double adunare(double[] numere) {
        double rezultat = 0;
        for(int i = 0; i < numere.length; i++) {
            rezultat = rezultat + numere[i];
        }
        return rezultat;
    }
    
   

}
