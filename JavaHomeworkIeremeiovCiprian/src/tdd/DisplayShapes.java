/*
 * Create more shapes and display the definitions
 */
package tdd;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author Cip
 */
public class DisplayShapes {

    public static Map<Definable, String> definitions = new LinkedHashMap<>();
    public static String[] definitionsArray = null;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

//        Definable segment = new LineSegment();
//        Definable romb = new Diamond();
//        Definable patrat = new Square();
//        Definable cerc = new Circle();
//
//        definitions.put(segment, segment.getDefinition());
//        definitions.put(romb, romb.getDefinition());
//        definitions.put(patrat, patrat.getDefinition());
//        definitions.put(new Circle(), cerc.getDefinition());

//        for (Iterator<Definibila> it = definitions.keySet().iterator(); it.hasNext(); ) {
//            String definitie = definitions.get(it.next());
//            System.out.println(definitie);
//        }
// init + display
        definitionsArray = new String[definitions.values().size()];
        DisplayShapes.setDefinitionsArray(definitionsArray);

        for (String s : definitionsArray) {
            System.out.println(s);
        }

    }

    public static void setDefinitionsArray(String[] def) {
        int i = 0;
        for (String definition : definitions.values()) {
            def[i] = definition;
            i++;
        }

//        definitionsArray = (String[]) definitions.values().toArray();
    }

    /*
   
    Quadrilateral : has 4 sides
    Line segment :  a part of a line that is bounded by two distinct end points, and contains every point on the line between its endpoints.
    Diamond : a figure with four straight sides of equal length forming two opposite acute angles and two opposite obtuse angles; a rhombus.
    Square : a plane figure with four equal straight sides and four right angles.
    Rectangle : a plane figure with four straight sides and four right angles, especially one with unequal adjacent sides, in contrast to a square.
    
    
     */
}
