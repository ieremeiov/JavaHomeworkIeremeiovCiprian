/*
 *   Ai grija ca stiu doar adunare!
 */
package calculator1_1;

/**
 *
 * @author Cip
 */
public class CalculatorIeftin {
    
    private double[] numere = new double[2];
    public OperatieNrReale operatie;
    public boolean amCalculat = false;
    public boolean operatieVerificata = false;
    
    public CalculatorIeftin() {
        CalculatorIeftin.salut();
    }
    
    public static void salut() {
        System.out.println("Salut! Stai sa caut o foaie si-un pix");
    }
    
     public void setOperatie(char operatiePrimita) {
        System.out.println("calculator.setOperatie()");
        this.verificaOperatie(operatiePrimita);
        operatie = new OperatieNrReale(operatiePrimita, numere);
    }
   
    public void setNumere(int n, double numar) {
        System.out.println("calculator.setNumere()");
        this.numere[n-1] = numar;
    }
    
    public void calculeaza() {
        System.out.println("calculator.calculeaza()");
        
        if(operatieVerificata) {
            operatie.efectueazaOperatie();  
            amCalculat = true;
        } else {
            amCalculat = false;
        }
        printResult();
    }
  
    public void printResult() {
        System.out.println("calculator.printResult()");
        if(amCalculat) {
            System.out.println("Rezultatul operatiei de " + 
                this.operatie.stringOperatie + " este " + this.operatie.getRezultat());
        } else {
            System.out.println("Nu am reusit sa calculez");
        }
    }
    
    public void verificaOperatie(char operatiePrimita) {
        System.out.println("calculator.verificaOperatie()");
        switch(operatiePrimita) {
            case '+':
                operatieVerificata = true;
                break;
            default:
                System.out.println("Imi pare rau, "
                    + "domnu' Pacurar ne-a invatat doar adunare!");
                 operatieVerificata = false;
        }
    }

    public double getRezultat() {
        return operatie.getRezultat();
    }
    
    public void printNumere() {
        System.out.println("calculator.printNumere()");
        System.out.print(numere[0] + " " + numere[1] + "\n");
    }
   
   
}
