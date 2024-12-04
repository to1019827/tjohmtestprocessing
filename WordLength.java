package emailFeatures;
import java.util.ArrayList;
import java.util.HashMap;

public class WordLength {
    
    public static ArrayList<Integer> emailSpamWordLength = new ArrayList<>();
    public static ArrayList<Integer> emailNotSpamWordLength = new ArrayList<>();
    
    public ArrayList<Integer> getSpamWordLengthArrList(HashMap<String, String> getSpamEmailLength) {
        for(String spamKey : getSpamEmailLength.keySet()){
            String[] words = spamKey.split("\\s+");
            for(String word : words) {
                int wordLength = word.length();
                emailSpamWordLength.add(wordLength);
            }
        }
        return emailSpamWordLength;
    }

    public ArrayList<Integer> getNotSpamWordLengthArrList(HashMap<String, String> getNotSpamEmailLength) {
        for(String notSpamKey : getNotSpamEmailLength.keySet()){
            String[] words = notSpamKey.split("\\s+");
            for(String word : words) {
                int wordLength = word.length();
                emailNotSpamWordLength.add(wordLength);
            }
        }
        return emailNotSpamWordLength;
    }
}
