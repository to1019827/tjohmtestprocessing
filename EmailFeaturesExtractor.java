import java.io.*;

public class EmailFeaturesExtractor {

    public static void main(String[] args) {
        String inputFile = "spam_or_not_spam.csv";
        String outputFile = "emailFeaturesData.csv";
        
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            writer.write("email_number,word_length,email_length,uppercase_letters,lowercase_letters,word_count\n");

            String line;
            int emailNumber = 1;

            while ((line = reader.readLine()) != null) {
                // Skip the header line
                if (line.startsWith("email,label")) {
                    continue;
                }
                
                // Split by comma to get email/label
                String[] columns = line.split(",", 2);
                String email = columns[0].trim();  // First part is email
                
                // Process the email content
                int emailLength = email.length();
                int uppercaseLetters = countUppercase(email);
                int lowercaseLetters = countLowercase(email);
                int wordCount = countWords(email);
                double wordLength = calculateAverageWordLength(email);
                
                writer.write(String.format("%d,%.2f,%d,%d,%d,%d\n", emailNumber, wordLength, emailLength, uppercaseLetters, lowercaseLetters, wordCount));
                
                emailNumber++;
            }

            System.out.println("Email features extraction complete.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int countUppercase(String text) {
        int count = 0;
        for (char c : text.toCharArray()) {
            if (Character.isUpperCase(c)) {
                count++;
            }
        }
        return count;
    }

    public static int countLowercase(String text) {
        int count = 0;
        for (char c : text.toCharArray()) {
            if (Character.isLowerCase(c)) {
                count++;
            }
        }
        return count;
    }

    public static int countWords(String text) {
        String[] words = text.split("\\s+");
        return words.length;
    }

    public static double calculateAverageWordLength(String text) {
        String[] words = text.split("\\s+");
        int totalLength = 0;
        for (String word : words) {
            totalLength += word.length();
        }
        return words.length > 0 ? (double) totalLength / words.length : 0;
    }
}
