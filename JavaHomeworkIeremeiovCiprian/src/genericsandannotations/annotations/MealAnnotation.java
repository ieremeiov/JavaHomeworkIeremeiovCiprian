/*
 * 
 */
package genericsandannotations.annotations;

import genericsandannotations.annotations.MealAnnotation.Meal;
import java.lang.annotation.Repeatable;

/**
 *
 * @author Cip
 */
public class MealAnnotation {
    
    private String meal;
    private String mainDish;
    
    public MealAnnotation(String meal, String mainDish) {
        this.meal = meal;
        this.mainDish = mainDish;
    }
    
    // The annotation type must be marked with the @Repeatable meta-annotation.
    // The value of the @Repeatable meta-annotation, in parentheses, is the type of the container annotation that the Java compiler generates to store repeating annotations.
    // In this example, the containing annotation type is MealContainer, so repeating @Meal annotations is stored in an @MealContainer annotation.
    // Applying the same annotation to a declaration without first declaring it to be repeatable results in a compile-time error.
    
    @Repeatable(MealContainer.class)
    public @interface Meal {

        String meal() default "snack";
        String mainDish() default "bread and water";
         
    }
    
    // The containing annotation type must have a value element with an array type.
    // The component type of the array type must be the repeatable annotation type. 
    // The declaration for the MealContainer containing annotation type is the following:
    public @interface MealContainer {
        Meal[] value();
    }
    
    
    @Meal(meal="breakfast", mainDish="cereal")
    @Meal(meal="lunch", mainDish="pizza")
    @Meal(meal="dinner", mainDish="salad")
    public void evaluateDiet() {
        System.out.println("Eating " + mainDish + " for " + meal + ".");
    }
    
}
