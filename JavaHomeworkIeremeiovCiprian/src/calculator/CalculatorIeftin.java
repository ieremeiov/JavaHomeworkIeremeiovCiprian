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
        System.out.println("Sa inceapa petrecerea!");
    }
    
    /**
     * Porneste calculatorul cu parametrii pre-setati
     * @param numerePrimite numerele pe care vreti sa le calculati
     * @param operatiePrimita operatia pe care vreti sa o efectuati
     */
    public CalculatorIeftin(double[] numerePrimite, char operatiePrimita) {
        System.out.println("Doamne-ajuta!");
        this.setNumarul(1, numerePrimite[0]);
        this.setNumarul(2, numerePrimite[1]);
        this.setOperatie(operatiePrimita);
    }
    
    /**
     *Calculeaza rezultatul daca toate verificarile au fost validate. 
     */
    public void calculeaza() {
        if(verificaNumerele()) {
            if (verificaOperatia(operatie)) {
                if(verificaRezultat()) {
                    amCalculat = true;
                } 
            }
        }
    }
    
    /**
     *  Printeaza rezultatul daca a reusit sa calculeze;
     *  daca nu detine tehnologia necesara, iti va sugera surse capabile sa-ti ofere raspunsul
     */
    public void printResult() {
        if(this.amCalculat()) {
            System.out.println("Rezultatul operatiei de " + 
                this.getStringOperation() + " este " + this.getRezultat());
        } else {
            System.out.println("Cauta pe Google!");
        }
        
    }
    
    private boolean verificaNumerele() {
        for(int i = 0; i < numere.length; i++) {
            if(isNotDouble(numere[i])) {
                return false;
            }
        }
        return true;
    }
    
    private boolean isNotDouble(double number) {
        if(number < Double.MIN_VALUE && number > Double.MAX_VALUE ) {
            return true;
        }
        return false;
    }
    
    private boolean verificaOperatia(char operatiePrimita) {
        if(operatiePrimita == '+') {
            operatie = operatiePrimita;
            return true;
        } else {
            System.out.println("Imi pare rau, "
                    + "domnu' Pacurar ne-a invatat doar adunare!");
            return false;
        }
    }
    
    
    private boolean verificaRezultat() {
        if(operatie == '+') {
            rezultat = numere[0] + numere[1];
            return true;
        } else {
            return false;
        }
    }
       
    
    private String getStringOperation() {
        if(operatie == '+') {
            return "adunare";
        }
        return "";
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
    
   
    private boolean amCalculat() {
        return amCalculat;
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
