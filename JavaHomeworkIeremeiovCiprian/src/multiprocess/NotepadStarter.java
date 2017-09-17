/*
 * Class that opens Notepad on Windows OS
 */
package multiprocess;

import java.io.IOException;

/**
 *
 * @author Cip
 */
public class NotepadStarter {

    public static void openNotepad() throws IOException{
            ProcessBuilder pb;
            pb = new ProcessBuilder("notepad");
            pb.start();
        } 
    

}
