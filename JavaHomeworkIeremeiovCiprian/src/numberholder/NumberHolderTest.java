

package numberholder;

/**
 *
 * @author Cip
 */
public class NumberHolderTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // one way would be, careful though, attributes are not encapsulated.
        NumberHolder nh = new NumberHolder();
        nh.anInt = 10;
        nh.aFloat = 5.4f; //specify that it's a float and not a double
        System.out.println("#1\nanInt is: " + nh.anInt + "\naFloat is: " + nh.aFloat);


        System.out.println("\n------------------------------------------\n#2");



        // some other way could be, although the Object is not used. Had to implement an extra Constructor for that
        NumberHolder numberHolder = new NumberHolder(10, 5.4f);


    }
    
}
