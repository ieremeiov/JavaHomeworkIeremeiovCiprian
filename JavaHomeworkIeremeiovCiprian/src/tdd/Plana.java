/*
 * Class of 2D shape
 */
package tdd;

/**
 *
 * @author Cip
 */
public class Plana extends FiguraGeometrica implements Definibila {
    
    private String definitie;


    /**
     *
     * @return definition of 2D shape
     */
    @Override
    public String getDefinition() {
        definitie = super.getDefinition() + "plana ";
        return definitie;
    }
    
    
    
    
    
}
