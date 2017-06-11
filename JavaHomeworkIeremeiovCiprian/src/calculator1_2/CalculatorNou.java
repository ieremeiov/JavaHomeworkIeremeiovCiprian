/*
 * Calculator adunare
 *   
 */
package calculator1_2;

import java.util.Scanner;

/**
 * @version 1.2
 * @author Cip
 */
public class CalculatorNou {
    
    
    private int indexNumar = 0;
    
    private double[] numere = new double[2];
    private OperatieSimpla operatie;
    private double rezultat;
    private boolean nuAmInvatatIncaOperatia = false;
    private boolean nuAmAuzitDeOperatie = false;
    private int NUMERE;
    
    /**
     *
     * @param NUMERE cate numere vrem sa calculam
     */
    public CalculatorNou(int NUMERE) {
        this.NUMERE = NUMERE;
        printMenu();
    }
    
    private void printMenu() {
        System.out.println(" <<< CALCULATOR 1_2 >>>\n");
    }
    
    private void bagaNumarul() {
        if(indexNumar == 0) {
            System.out.println("Spune-mi primul numar: ");
        } else {
            System.out.println("Spune-mi numarul al " + (indexNumar+1) + "-lea numar: ");
        }
    }
    
    private void setNumere(int index, double[] numere) {
        this.numere[index] = numere[index];
    }
    
    private void printNumere() {
        System.out.print("\nNumerele sunt: ");
        for(int i = 0; i < NUMERE; i++) {
            System.out.print("[" + numere[i] + "] ");
        }
        System.out.println("\n");
    }
    
    private void bagaOperatia() {
        System.out.println("Ce sa facem cu numerele astea?");
        System.out.println("Daca vrei adunare apasa: '+'\n"
                + "Daca vrei scadere apasa: '-'\nDaca vrei inmultire apasa: '*'\n"
                + "Daca vrei impartire apasa: '/'");
    }
    
    private void setOperatie(char operatie) {
        this.operatie = new OperatieSimpla(operatie);
    }
    
    private void efectueazaOperatia() {
      //  System.out.println("operatie.efectueazaOperatia()");
        switch(operatie.getSimbolOperatie()) {
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
    
    private void printRezultat() {
        if(!nuAmAuzitDeOperatie && operatie.getCunoscOperatie()) {
            if(!nuAmInvatatIncaOperatia) {
                System.out.println("Rezultatul operatiei de " 
                    + operatie.getStringOperatie() + " este: " +
                    rezultat);
                System.out.println("Scoala Informala nu Greseste Niciodata! :)");
            } else {
                System.out.println("Domnul Pacurar ma va pregati si pentru "
                    + "operatia de " + operatie.getStringOperatie());
                System.out.println("Pana atunci da-i si tu un Search pe GOOGLE");
            }
        } else {
            System.out.println("Chiar nu am auzit de operatia: " +
                  Character.toString ((char) operatie.getOperatieNecunoscuta()));
        }
    }
    
    /**
     *  O sa ceara numerele unul cate unul, apoi operatia
     */
    public void incepeTreaba() {
        
        Scanner scanner = new Scanner(System.in);
        
        while(indexNumar < NUMERE) {
            this.bagaNumarul();
            numere[indexNumar] = scanner.nextDouble();
            this.setNumere(indexNumar, numere);
            indexNumar++;
        }
        
        this.printNumere();
        this.bagaOperatia();
        
        char operatieCitita = scanner.next().charAt(0);
        System.out.println(operatieCitita);
        this.setOperatie(operatieCitita);
        
        this.efectueazaOperatia();
        this.printRezultat();
        
    }
    
    
}
