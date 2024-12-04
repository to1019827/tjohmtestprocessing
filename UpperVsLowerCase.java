package emailFeatures;
import java.util.HashMap;

public class UpperVsLowerCase {
    
    public static HashMap<Integer,Integer> SpamUvL = new HashMap<>();
    public static HashMap<Integer,Integer> NotSpamUvL = new HashMap<>();

    public HashMap<Integer,Integer>  getSpamUvLHashMap(HashMap<String, String> getSpamUvL) {
        for(String spamKey : getSpamUvL.keySet()) {
            int upperCaseCount = 0;
            int lowerCaseCount = 0;
            for (int i = 0; i < spamKey.length(); i++) {
                char c = spamKey.charAt(i);
                if (Character.isUpperCase(c)) {
                    upperCaseCount++;
                } else if (Character.isLowerCase(c)) {
                    lowerCaseCount++;
                 }
            }
            SpamUvL.put(upperCaseCount, lowerCaseCount);
            }
        return SpamUvL;
    }

    public HashMap<Integer,Integer>  getNotSpamUvLHashMap(HashMap<String, String> getNotSpamUvL) {
        for(String notSpamKey : getNotSpamUvL.keySet()) {
            int upperCaseCount = 0;
            int lowerCaseCount = 0;
            for (int i = 0; i < notSpamKey.length(); i++) {
                char c = notSpamKey.charAt(i);
                if (Character.isUpperCase(c)) {
                    upperCaseCount++;
                } else if (Character.isLowerCase(c)) {
                        lowerCaseCount++;
                }
            }
            NotSpamUvL.put(upperCaseCount, lowerCaseCount);
        }
        return NotSpamUvL;
    }
}
