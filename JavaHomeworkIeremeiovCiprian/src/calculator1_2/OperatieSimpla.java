/*
 *  Aici delegam si operatiei cateva chestii :)
 *
 */
package calculator1_2;

/**
 *
 * @author Cip
 */
public class OperatieSimpla {
    
    private char simbolOperatie[] = {'+', '-', '*', '/'};

    
    private String stringOperatie[] = {"adunare", "scadere", "inmultire", "impartire"};

    /**
     *
     */
    public char operatie;
    private int indexOperatie;
    private boolean cunoscOperatia = true;
    private char operatieNecunoscuta = ' ';
    
    /**
     *
     * @param operatiePrimita operatia pe care o introduce utilizatorul
     */
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
    
    private boolean verificaOperatie(char operatiePrimita) {
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
    
    /**
     *
     * @param numere un array de numere pe care vrem sa le adunam
     * @return rezultatul operatiei de adunare
     */
    public double adunare(double[] numere) {
        double rezultat = 0;
        for(int i = 0; i < numere.length; i++) {
            rezultat = rezultat + numere[i];
        }
        return rezultat;
    }
    
    /**
     *
     * @return simbolul operatiei selectate
     */
    public char getSimbolOperatie() {
        return simbolOperatie[this.indexOperatie];
    }
    
    /**
     *
     * @return daca este o operatie cunoscuta ( in versiunea 1.2 este valabil doar la adunare)
     */
    public boolean getCunoscOperatie() {
        return cunoscOperatia;
    }
    
    /**
     *
     * @return indexul corespunzator operatiei selectate de utilizator, in raport cu array-ul de simboluri al clasei OperatieSimpla:
     *  {'+', '-', '*', '/'}
     */
    public int getIndexOperatie() {
        return indexOperatie;
    }
    
    /**
     *
     * @return simbolul operatiei necunoscute
     */
    public int getOperatieNecunoscuta() {
        return operatieNecunoscuta;
    }
    
    /**
     *
     * @return operatia aleasa, sub forma unui sir de caractere, pentru a le putea printa
     */
    public String getStringOperatie() {
        return this.stringOperatie[this.getIndexOperatie()];
    }
}
