package fileTopic;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;

/**
 * @author: Brandon Hartshorn (brandonhartshorn@gmail.com)
 * Program: fileTopic
 * @version: 1.01
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
public class Finder {
   private List<Topic> testTopics;

   /**
    * Main class: like dominos
    */
   public static void main (String[] args) throws IOException {
      Finder mainFinder = new Finder();
      mainFinder.readFiles(args);
   }

   /**
    * This class does all the work
    *
    * @param args Command line arguments for the program
    */
   public void readFiles(String[] args) throws IOException {
      BufferedReader topicFile = null;
      Topic testTopic = new Topic();

      if (args.length < 2) {
         System.out.println("No file specified.");
      } else {
         testTopics = new ArrayList();
         try {
            topicFile = new BufferedReader(new FileReader(args[0]));
            String line;
            while ((line = topicFile.readLine()) != null) {
               Topic tempTopic = new Topic();
               tempTopic.createTopic(line);
               testTopics.add(tempTopic);
            }

            File[] txtFiles = new File(args[1]).listFiles();
            for (File file : txtFiles) {
               if (file.isFile() && file.getName().matches("^.*\\.(txt|TXT)$")) {
                  String currentFile = new String(Files.readAllBytes(Paths.get(file.getPath())));
                  System.out.print(file.getName() + ": ");

                  boolean firstTopic = true;

                  for (Topic currentTopic : testTopics) {
                     for (String testWord : currentTopic.getWords()) {
                        if (currentFile.contains(testWord)) {
                           if (firstTopic == false) {
                              System.out.print(", ");
                           }
                              
                           firstTopic = false;
                           System.out.print(currentTopic.getTitle());
                           break;
                        }
                     }
                  }
                  System.out.println("");
               }
            }
         } finally {
            if (topicFile != null) {
               topicFile.close();
            }
         }
      }
   }
}
