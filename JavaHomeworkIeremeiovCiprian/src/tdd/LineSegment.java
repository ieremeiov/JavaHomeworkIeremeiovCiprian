/*
 * Segment definition
 */
package tdd;

/**
 *
 * @author Cip
 */
public class LineSegment extends TwoDimensional implements Definable {
    
    private String definition;

  
    @Override
    public String getDefinition() {
        definition = super.getDefinition() + "defined by a part of a line that is bounded by two distinct end points, and contains every point on the line between its endpoints.";
        return definition;
    }
}
