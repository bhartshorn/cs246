package fileTopic;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

/**
 * @author: Brandon Hartshorn (brandonhartshorn@gmail.com)
 * Program: fileTopic
 * @version: 1.01
 *
 * Description:
 *    Helper class for fileTopic
 *
 */
public class Topic {
   private String[] topicWords;
   private String topicName;

   /**
    * Returns the title of the Topic
    *
    * @return Returns a string representing the title of the topic
    */
   public String getTitle() {
      return topicName;
   }

   /**
    * Returns the words that map to this topic
    *
    * @return Returns an array of strings that map to this topic
    */
   public String[] getWords() {
      return topicWords;
   }

   /**
    * Initializes the topic from a string of format "Topic:word1,word2,..."
    *
    * @param rawTopicLine A string of format "Topic:word1,word2,..."
    */
   public void createTopic(String rawTopicLine) {
      topicName = rawTopicLine.split(":")[0];
      topicWords = rawTopicLine.split(":")[1].split(",");
   }
}
