/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Cip
 */
public class MyFileReader {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String reader = null;
        
        try {
            
            reader = readFirstLineFromFile("Write_here.txt");
            System.out.println(reader);
            
        } catch (IOException e) {
            
            e.printStackTrace();

        }

        
        
    }

    static String readFirstLineFromFile(String path) throws IOException {

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            return br.readLine();

        }
    }

}
