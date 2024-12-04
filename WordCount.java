package emailFeatures;
import java.util.ArrayList;
import java.util.HashMap;

public class WordCount {
    
    public static ArrayList<Integer> emailSpamWordCount = new ArrayList<>();
    public static ArrayList<Integer> emailNotSpamWordCount = new ArrayList<>();

    public ArrayList<Integer> getSpamCount(HashMap<String, String> getSpamWordCount) {
        for(String spamKey : getSpamWordCount.keySet()){
            String[] words = spamKey.split("\\s+");
            int wordCount = words.length;
            emailSpamWordCount.add(wordCount);
        }
        return emailSpamWordCount;
    }

    public ArrayList<Integer> getNotSpamCount(HashMap<String, String> getNotSpamWordCount) {
        for(String notSpamKey : getNotSpamWordCount.keySet()){
            String[] words = notSpamKey.split("\\s+");
            int wordCount = words.length;
            emailNotSpamWordCount.add(wordCount);
        }
        return emailNotSpamWordCount;
    }

}
