/*
 * We Thank JavaTutorials from "https://docs.oracle.com/javase/tutorial/java/annotations" for their support with our homework!  
 */
package genericsandannotations.annotations;

/**
 *
 * @author Cip
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        MealAnnotation meal = new MealAnnotation("breakfast", "cereal");
        meal.evaluateDiet();

    }
    
}
