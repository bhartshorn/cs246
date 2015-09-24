
/*
 * Program: WordCount
 * Author: Brandon Hartshorn (brandonhartshorn@gmail.com)
 *
 * Description:
 *    Displays a file passed as the first command line parameter
 *    line by line, each line preceeded by the number of words
 *    in that line.
 *
 * Usage:
 *    java WordCount <name of file to print>
 *
 * Various reference material for the writing of this program is
 * listed in the inline comments.
 */

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

class WordCount {
   public static void main(String[] args) throws IOException {
      BufferedReader file = null;

      if (args.length == 0) {
         System.out.println("No file specified.");
      } else {
         // reference: https://docs.oracle.com/javase/tutorial/essential/io/charstreams.html
         try {
            file = new BufferedReader(new FileReader(args[0]));
            String line;
            while ((line = file.readLine()) != null) {
               // reference: http://stackoverflow.com/a/28412119
               System.out.print(line.split("\\s").length + ": ");
               System.out.println(line);
            }
         } catch(IOException error) {
            // Reference: https://docs.oracle.com/javase/tutorial/essential/exceptions/putItTogether.html
            System.err.println("Error reading file: " + error.getMessage()); 
            
         } finally {
            if (file != null) {
               file.close();
            }
         }
      }
   }
}
