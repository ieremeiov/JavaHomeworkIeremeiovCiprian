/**
 * Class that opens 3 'Notepad' programs
 */
package multiprocess;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cip
 */
public class NotepadProcess {

    public static void main(String[] args) {

        try {

            for (int i = 0; i < 3; i++) {
                NotepadStarter.openNotepad();
            }

        } catch (IOException ex) {
            Logger.getLogger(NotepadProcess.class.getName()).log(Level.SEVERE, "An IO exception is here!", ex);
        }
    }

}
