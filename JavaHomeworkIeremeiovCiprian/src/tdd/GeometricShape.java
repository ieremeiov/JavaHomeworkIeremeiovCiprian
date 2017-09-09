/*
 * Class GeometricShape implements the root of hierarchy
 */
package tdd;

/**
 *
 * @author Cip
 */
public class GeometricShape implements Definable {

    private String definition;


    @Override
    public String getDefinition() {
        definition = "geometric shape ";
        return definition;
    }

}
