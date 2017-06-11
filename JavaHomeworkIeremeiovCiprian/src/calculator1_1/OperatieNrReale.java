/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator1_1;

/**
 *
 * @author Cip
 */
public class OperatieNrReale {
    
    public char simbolOperatie;
    public String stringOperatie;
    private double rezultat;
    private double[] numere = new double[2];
    
    public OperatieNrReale(char operatiePrimita, double[] numere) {
        System.out.println("Constructor OperatieNrReale");
        this.simbolOperatie = operatiePrimita;
        
        this.stringOperatie = getStringOperaite(operatiePrimita);
        
        for(int i = 0; i < numere.length; i++) {
            this.numere[i] = numere[i];
        }
        
    }
    
    public double adunare(double[] numere) {
        System.out.println("operatie.adunare()");
        return numere[0] + numere[1];
    }
    
    public void efectueazaOperatie() {  // java.lang.NullPointerException
        System.out.println("operatie.efectueazaOperatie()");
        System.out.println("Simbol operatie: " + this.simbolOperatie);
        
        
 ///*             
        switch(this.simbolOperatie) {
            case '+':
                this.rezultat = adunare(numere);   
                break;
            default:
                System.out.println("Pentru " + this.stringOperatie + ", cauta pe Google!");
                break;
        }
//*/
    }
    
    public double getRezultat() {
        return this.rezultat;
    }
   
    public String getStringOperaite(char operatie) {
        System.out.println("operatie.getStringOperatie()");
        switch(operatie) {
            case '+':
                return "adunare";
            case '-':
                return "scadere";
            case '*':
                return "inmultire";
            case '/':
                return "impartire";
            default:
                return "";
        }
    }
    
    public char getSimbolOperatie() {
        return this.simbolOperatie;
    }
    
    public void printNumere() {
        for(int i = 0; i < numere.length; i++) {
            System.out.print("" + numere[i] + " ");
        }
        System.out.println("\n");
    }
    
}
