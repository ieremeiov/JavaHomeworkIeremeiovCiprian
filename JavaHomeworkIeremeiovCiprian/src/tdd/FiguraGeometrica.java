/*
 * Class FiguraGeometrica implements the root of hierarchy
 */
package tdd;

/**
 *
 * @author Cip
 */
public class FiguraGeometrica implements Definibila {

    private String definitie;


    @Override
    public String getDefinition() {
        definitie = "Figura geometrica ";
        return definitie;
    }

}
