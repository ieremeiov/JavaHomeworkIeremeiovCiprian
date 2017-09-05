package multiprocess;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cip
 */
public class NotepadProcess {

    public static void main(String[] args) {
        try {
            ProcessBuilder pb;
// Use process builder to start 2 processes multithreading.SayHello with parameter
            pb = new ProcessBuilder("notepad");

            Process p1 = pb.start();
            Process p2 = pb.start();
            Process p3 = pb.start();
        } catch (IOException ex) {
            Logger.getLogger(NotepadProcess.class.getName()).log(Level.SEVERE, "An IO exception is here!", ex);
        }
    }
}
