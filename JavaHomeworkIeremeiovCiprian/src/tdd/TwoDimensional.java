/*
 * Class of 2D shape
 */
package tdd;

/**
 *
 * @author Cip
 */
public class TwoDimensional extends GeometricShape implements Definable {
    
    private String definition;


    /**
     *
     * @return definition of 2D shape
     */
    @Override
    public String getDefinition() {
        definition = "Two dimensional " + super.getDefinition();
        return definition;
    }
    
    
    
    
    
}
