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

    private static String text1 = "public FileWriter(String string) throws IOException";
    private static String text2 = "public PrintWriter(Writer writer)";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String outputFile1 = "Write_here1.txt";
        String outputFile2 = null; // Ooops - NullPointerException
        String outputFile3 = ""; // will cause IOException but will be handled

            writeFile(outputFile1, text1, text2);

            writeFile(outputFile2, "Ciprian", "Ieremeiov");
            
            writeFile(outputFile3, "Hello", null);

    }

    // can throw exceptions other than IOException depending on what other methods are being invoked inside the try block 
    // NullPointerException if the file name points to a null pointer.
    public static void writeFile(String outputFileName, String stringToWrite1, String stringToWrite2) { 

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

        } catch (NullPointerException e) { // 
            
            System.err.println("NullPointerException: " + e.getMessage());

        } finally {

            if (writer != null) { // in case the file did open
                writer.close();
            } else {
                System.out.println("PrintWriter is not open.");
            }

        }

    }

}
