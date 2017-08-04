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

        String text1 = "public FileWriter(String string) throws IOException";
        String text2 = "public PrintWriter(Writer writer)";

        String outputFile1 = "Write_here1.txt";
        String outputFile2 = "";

        try {
            writeFile(outputFile1, text1, text2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            writeFile(outputFile2, "Hello", null);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    // can throw exceptions other than IOException depending on what other methods are being invoked inside the try block 
    // although bad practice, I've chosen to throw the exception further so that the exception will be handled in main() in this case
    // it will only throw other exceptions if you manually add more dangerous methods inside the body of writeFile() 
    public static void writeFile(String outputFileName, String stringToWrite1, String stringToWrite2) throws Exception {

        FileWriter file;
        PrintWriter writer = null;

        try {

            file = new FileWriter(outputFileName); // can throw the checked exception IOException if file cannot be created

            writer = new PrintWriter(file); // if PrintWriter's Constructor would have taken a String filename, 
            // it could have thrown the checked exception FileNotFoundException

            writer.println(stringToWrite1);
            writer.println(stringToWrite2);

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
