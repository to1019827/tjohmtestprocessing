package emailFeatures;
import java.util.ArrayList;
import java.util.HashMap;

public class EmailLength {
    
    public static ArrayList<Integer> emailSpamEmailLength = new ArrayList<>();
    public static ArrayList<Integer> emailNotSpamEmailLength = new ArrayList<>();

    public ArrayList<Integer> getSpamEmailLengthArrList(HashMap<String, String> getSpamEmailLength) {
        for(String spamKey : getSpamEmailLength.keySet()){
            int emailLength = spamKey.length();
            emailSpamEmailLength.add(emailLength);
        }
        return emailSpamEmailLength;
    }

    public ArrayList<Integer> getNotSpamEmailLengthArrList(HashMap<String, String> getNotSpamEmailLength) {
        for(String notSpamKey : getNotSpamEmailLength.keySet()){
            int emailLength = notSpamKey.length();
            emailNotSpamEmailLength.add(emailLength);
        }
        return emailNotSpamEmailLength;
    }
    
}
