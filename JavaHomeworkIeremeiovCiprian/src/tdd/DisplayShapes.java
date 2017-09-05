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

    public static Map<Definibila, String> definitii = new LinkedHashMap<>();
    public static String[] definitiiArray = null;

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String[] args) {
//
//        Definibila segment = new SegmentDeDreapta();
//        Definibila romb = new Romb();
//        Definibila patrat = new Patrat();
//        Definibila cerc = new Cerc();
//
//        definitii.put(segment, segment.getDefinition());
//        definitii.put(romb, romb.getDefinition());
//        definitii.put(patrat, patrat.getDefinition());
//        definitii.put(new Cerc(), cerc.getDefinition());
//
////        for (Iterator<Definibila> it = definitii.keySet().iterator(); it.hasNext(); ) {
////            String definitie = definitii.get(it.next());
////            System.out.println(definitie);
////        }
//// init + display
//        definitiiArray = new String[definitii.values().size()];
//        DisplayShapes.setDefinitiiArray(definitiiArray);
//
//        for (String s : definitiiArray) {
//            System.out.println(s);
//        }
//
//    }

    public static void setDefinitiiArray(String[] def) {
        int i = 0;
        for (String definitie : definitii.values()) {
            def[i] = definitie;
            i++;
        }

//        definitiiArray = (String[]) definitii.values().toArray();
    }

    /*
    Figura geometrica plana patrulaterul care are toate laturile egale si toate unghiurile drepte. 
    Figura geometrica plana determinata de 2 puncte numite capetele segmentului 
    Figura geometrica plana patrulaterul cu laturile opuse paralele si congruente
    Figura geometrica plana formata din multimea tuturor punctelor egal departate de un punct fix
     */
}
