/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
