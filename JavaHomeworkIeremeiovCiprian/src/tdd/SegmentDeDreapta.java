/*
 * Segment definition
 */
package tdd;

/**
 *
 * @author Cip
 */
public class SegmentDeDreapta extends Plana implements Definibila {
    
    private String definitie;

  
    @Override
    public String getDefinition() {
        definitie = super.getDefinition() + "determinata de 2 puncte numite capetele segmentului ";
        return definitie;
    }
}
