/*
 * Class with a Static Method that receives a file path as a String and writes another String in it
 */
package exceptions;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Cip
 */
public class MyFileWriter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String text = "Hello, my name is Ciprian";
        String outputFile = "Write_here.txt";

        try {
            writeFile(outputFile, text);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    // can throw exceptionsother than IOException depending on what other methods are being invoked inside the try block 
    // although bad practice, I've chosen to throw the exception further so that the exception will be handled in main() in this case
    // it will only throw other exceptions if you manually add more dangerous methods inside the body of writeFile() 
    public static void writeFile(String outputFile, String textToWrite) throws Exception {

        FileWriter file = null;
        PrintWriter writer = null;

        try {

            file = new FileWriter(outputFile); // can throw IOException if file cannot be created

            writer = new PrintWriter(file);

            writer.println(textToWrite);
            writer.close();

        } catch (IOException e) {

            System.err.println("IOException: " + e.getMessage());

        } catch (Exception e) {

            throw e;

        } finally {

            if (writer != null) { // in case the file did open
                writer.close();
            } else {
                System.out.println("PrintWriter is not open.");
            }

        }

    }

}
