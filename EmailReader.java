//Travis Ohm Email Reader CLass
import emailFeatures.*;
import java.io.*;
import java.util.HashMap;

public class EmailReader {

    public static HashMap<String,String> emailContent = new HashMap<>();
    public static HashMap<String,String> emailContentSpam = new HashMap<>();
    public static HashMap<String,String> emailContentNotSpam = new HashMap<>();
    
    public static void main(String[] args) {

        BufferedReader reader = null;                                       //Reads csv file using bufferedReader
        String line; 
        String emailSplitArray[]; 
        String fileName = "emailFeaturesData.csv";              

                //email nums to determain spam or not spam ArrayList

        try {
            reader = new BufferedReader(new FileReader("/Users/tjohm/Library/Mobile Documents/com~apple~CloudDocs/TestProcessing/spam_or_not_spam.csv"));
            reader.readLine();
            while((line = reader.readLine()) != null) {                     //Read and process each different email
                emailSplitArray = line.split(",");           //Seperate nums and content
                emailContent.put(emailSplitArray[0], emailSplitArray[1]);
                if(emailSplitArray[1].equals("0")) {
                emailContentSpam.put(emailSplitArray[0], emailSplitArray[1]);
                }
                else if(emailSplitArray[1].equals("1")) {
                emailContentNotSpam.put(emailSplitArray[0], emailSplitArray[1]);
                }
                else {
                System.out.println("invalid email content");
                }
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            try {                                   //Errors testing
                reader.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }

        //Create objects for features
        WordCount spamCount = new WordCount();
        spamCount.getSpamCount(emailContentSpam);

        WordCount notSpamCount = new WordCount();
        notSpamCount.getNotSpamCount(emailContentNotSpam);

        EmailLength spamEmailLengthCount = new EmailLength();
        spamEmailLengthCount.getSpamEmailLengthArrList(emailContentSpam);

        EmailLength notSpamEmailLengthCount = new EmailLength();
        notSpamEmailLengthCount.getSpamEmailLengthArrList(emailContentNotSpam);

        WordLength spamWordLengthCount = new WordLength();
        spamWordLengthCount.getSpamWordLengthArrList(emailContentSpam);

        WordLength notSpamWordLengthCount = new WordLength();
        notSpamWordLengthCount.getNotSpamWordLengthArrList(emailContentNotSpam);

        UpperVsLowerCase spamUvLCount = new UpperVsLowerCase();
        spamUvLCount.getSpamUvLHashMap(emailContentSpam);

        UpperVsLowerCase notSpamUvLCount = new UpperVsLowerCase();
        notSpamUvLCount.getNotSpamUvLHashMap(emailContentNotSpam);

        
        writeToCSVFile(fileName);

    }
    public static HashMap<String,String> getEmailContent() {
        return emailContent;
    }
    public static HashMap<String,String> getEmailContentSpam() {
        return emailContentSpam;
    }
    public static HashMap<String,String> getEmailContentNotSpam() {
        return emailContentNotSpam;
    }

    private static void writeToCSVFile(String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {

            writer.write("Email Number" + ",");
            writer.write("Word Length" + ",");
            writer.write("Email Length" + ",");
            writer.write("Uppercase Letters" + ",");
            writer.write("Lowercase Letters" + ",");
            writer.write("Word Count" + ",");
            

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
