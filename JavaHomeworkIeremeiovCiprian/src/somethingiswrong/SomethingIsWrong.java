/*
 * Creates a Rectangle, sets the width and the height then displays the area
 */
package somethingiswrong;

/**
 *
 * @author Cip
 */
public class SomethingIsWrong {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // myRect's Constructor is now called using "new"
        Rectangle myRect = new Rectangle();

        // Rectangle attributes are now encapsulated
        myRect.setWidth(40);
        myRect.setHeight(50);

        System.out.println("myRect's area is " + myRect.area());
    }
    
}
