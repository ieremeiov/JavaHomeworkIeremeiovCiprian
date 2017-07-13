

package numberholder;

/**
 *
 * @author Cip
 */
public class NumberHolder {

    public int anInt;
    public float aFloat;

    public NumberHolder() {
        
    }
    
    public NumberHolder(int anInt, float aFloat) {
        this.anInt = anInt;
        this.aFloat = aFloat;
        System.out.println("anInt is: " + this.anInt + "\naFloat is: " + this.aFloat);
    }
    
    
}