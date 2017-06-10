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
    
    public CalculatorIeftin() {
        System.out.println("Sa inceapa petrecerea!");
    }
    
    public CalculatorIeftin(double[] numerePrimite, char operatiePrimita) {
        System.out.println("Doamne-ajuta!");
        this.setNumarul(1, numerePrimite[0]);
        this.setNumarul(2, numerePrimite[1]);
        this.setOperatie(operatiePrimita);
    }
    
    public void calculeaza() {
        if(verificaNumerele()) {
            if (verificaOperatia(operatie)) {
                if(verificaRezultat()) {
                    amCalculat = true;
                } 
            }
        }
    }
    
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
       
    public String getStringOperation() {
        if(operatie == '+') {
            return "adunare";
        }
        return "";
    }
    
    public boolean verificaOperatiaPublic() {
        return verificaOperatia(this.operatie);
    }
    
    public double getRezultat() {
        return rezultat;
    }
    
    public boolean amCalculat() {
        return amCalculat;
    }
    
    public void setNumarul(int n, double numar) {
        this.numere[n-1] = numar;
    }
    
    public void setOperatie(char operatiePrimita) {
        operatie = operatiePrimita;
    }
    
}
