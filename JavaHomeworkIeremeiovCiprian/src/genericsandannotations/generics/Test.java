/*
 *  
 *
 */
package genericsandannotations.generics;

/**
 *
 * @author Cip
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Exercise 6.
        Node<String> node = new Node<>();
        Comparable<String> comp = node; // compiles just fine

        // Exercise 5.
        Node<Circle> nc = new Node<>();
        
        // The following code is not working because, even though Circle is a Shape, and a Shape can hold a Circle reference,
        // Node<Circle> and is not a Node<Shape>, so a Node<Shape> cannot point to a Node<Circle> reference.
        // Node<Shape> ns = nc;

    }

}
