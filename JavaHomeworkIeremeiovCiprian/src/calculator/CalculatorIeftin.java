/*
 *   Ai grija ca stiu doar adunare!
 */
package calculator;

/**
 *
 * @author Cip
 */
public class CalculatorIeftin {
    
    private double[] numere = new double[2];
    private char operatie;
    private double rezultat;
    private boolean amCalculat = false;
    
    /**
     * Porneste calculatorul. 
     */
    public CalculatorIeftin() {
        CalculatorIeftin.salut();
    }
    
    /**
     * Porneste calculatorul cu parametrii pre-setati
     * @param numerePrimite numerele pe care vreti sa le calculati
     * @param operatiePrimita operatia pe care vreti sa o efectuati
     */
    public CalculatorIeftin(double[] numerePrimite, char operatiePrimita) {
        System.out.println("1...2...3...");
        this.setNumarul(1, numerePrimite[0]);
        this.setNumarul(2, numerePrimite[1]);
        this.setOperatie(operatiePrimita);
    }
    
    public static void salut() {
        System.out.println("Salut! Stai sa caut o foaie si-un pix");
    }
    
    
    /**
     *Calculeaza rezultatul daca toate verificarile au fost validate. 
     */
    public void calculeaza() {
            if (verificaOperatia(operatie)) {
                    amCalculat = true;
                } 
    }
    
    /**
     *  Printeaza rezultatul daca a reusit sa calculeze;
     *  daca nu detine tehnologia necesara, iti va sugera surse capabile sa-ti ofere raspunsul
     */
    public void printResult() {
        if(amCalculat) {
            System.out.println("Rezultatul operatiei de " + 
                this.getStringOperation() + " este " + this.getRezultat());
        } else {
            System.out.println("Pentru " + this.getStringOperation() + ", cauta pe Google!");
        }
        
    }
    
    
    
    private boolean verificaOperatia(char operatiePrimita) {
        
        switch(operatiePrimita) {
            case '+':
                operatie = operatiePrimita;
                rezultat = numere[0] + numere[1];
                return true;
            default:
                System.out.println("Imi pare rau, "
                    + "domnu' Pacurar ne-a invatat doar adunare!");
                 return false;
        }
    }
    
    private String getStringOperation() {
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
                return "orice altceva";
        }
    }
    
    /**
     *  Returneaza "true" daca recunoastem sau stim sa utilizam operatia respectiva,
     *  altfel returneaza "false" si ne permite sa intrerupem procesul imediat dupa
     *  ce ati selectat o operatie invalida.
     * @return true/false
     */
    public boolean verificaOperatiaPublic() {
        return verificaOperatia(this.operatie);
    }
    
    
    private double getRezultat() {
        return rezultat;
    }
    
    /**
     *
     *  Seteaza al 'n'-lea numar pe care vreti sa il calculati
     *  
     * @param n ordinul numarului
     * @param numar valoarea numarului
     */
    public void setNumarul(int n, double numar) {
        this.numere[n-1] = numar;
    }
    
    /**
     *  Seteaza operatia pe care vreti sa o efectueze calculatorul
     * @param operatiePrimita operation
     */
    public void setOperatie(char operatiePrimita) {
        operatie = operatiePrimita;
    }
    
}
