/*
 * Homework
 */
package anonymousnomore;

/**
 * Tests the HelloWorldClasses
 * @author Cip
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        HelloWorldLocalClasses.sayHello();
        System.out.println("------------------");
        HelloWorldLocalClasses.sayHelloTo("Fred");
        System.out.println("------------------");
        
        HelloWorldLocalClasses.sayHelloIn(Language.FRENCH);
        HelloWorldLocalClasses.sayHelloToIn("Cip", Language.SPANISH);

    }

}
