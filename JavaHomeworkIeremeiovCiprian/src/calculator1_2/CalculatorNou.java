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
public class CalculatorNou {
    
    public int indexNumar = 0;
    
    public double[] numere = new double[2];
    public OperatieSimpla operatie;
    double rezultat;
    boolean nuAmInvatatIncaOperatia = false;
    boolean nuAmAuzitDeOperatie = false;
    
    public CalculatorNou() {
        printMenu();
    }
    
    public void printMenu() {
        System.out.println(" <<< CALCULATOR 1_2 >>>\n");
    }
    
    public void bagaNumarul() {
        if(indexNumar == 0) {
            System.out.println("Spune-mi primul numar: ");
        } else {
            System.out.println("Spune-mi numarul al " + (indexNumar+2) + "-lea");
        }
    }
    
    public void setNumere(int index, double[] numere) {
        this.numere[index] = numere[index];
    }
    
    public void printNumere() {
        System.out.print("\nNumerele sunt: ");
        for(int i = 0; i < numere.length; i++) {
            System.out.print("[" + numere[i] + "] ");
        }
        System.out.println("\n");
    }
    
    public void bagaOperatia() {
        System.out.println("Ce sa facem cu numerele astea?");
        System.out.println("Daca vrei adunare apasa: '+'\n"
                + "Daca vrei scadere apasa: '-'\nDaca vrei inmultire apasa: '*'\n"
                + "Daca vrei impartire apasa: '/'");
    }
    
    public void setOperatie(char operatie) {
        this.operatie = new OperatieSimpla(operatie);
        
    }
    
    public void efectueazaOperatia() {
      //  System.out.println("operatie.efectueazaOperatia()");
        switch(operatie.simbolOperatie[operatie.indexOperatie]) {
            case '+':
                rezultat = operatie.adunare(numere);
                break;
            case '-':
            case '*':
            case '/':
                System.out.println("Nu am invatat inca aceasta operatie");
                nuAmInvatatIncaOperatia = true;
                break;
            default:
                nuAmAuzitDeOperatie = true;
                break;
        }
    }
    
    
    public void printRezultat() {
        if(!nuAmAuzitDeOperatie && operatie.cunoscOperatia) {
            if(!nuAmInvatatIncaOperatia) {
                System.out.println("Rezultatul operatiei de " 
                    + operatie.stringOperatie[operatie.indexOperatie] + " este: " +
                    rezultat);
                System.out.println("Scoala Informala nu Greseste Niciodata! :)");
            } else {
                System.out.println("Domnul Pacurar ma va pregati si pentru "
                    + "operatia de " + operatie.stringOperatie[operatie.indexOperatie]);
                System.out.println("Pana atunci da-i si tu un Search pe GOOGLE");
            }
        } else {
            System.out.println("Chiar nu am auzit de operatia: " + 
                    operatie.operatieNecunoscuta);
        }
    }
    
    
}
