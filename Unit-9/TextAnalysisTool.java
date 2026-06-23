import java.util.*;

public class TextAnalysisTool {

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {

            // User Input
            System.out.println("====================================");
            System.out.println("        TEXT ANALYSIS TOOL");
            System.out.println("====================================");

            System.out.println("Enter a paragraph or lengthy text:");
            String text = scanner.nextLine();

            // Input Validation
            if (text == null || text.trim().isEmpty()) {
                System.out.println("Error: Text input cannot be empty.");
                return;
            }

        // Character Count
        int characterCount = text.length();

        // Word Count
        String[] words = text.trim().split("\\s+");
        int wordCount = words.length;

        // Most Common Character
        Map<Character, Integer> charFrequencyMap = new HashMap<>();

        for (char ch : text.toLowerCase().toCharArray()) {
            if (!Character.isWhitespace(ch)) {
                charFrequencyMap.put(
                        ch,
                        charFrequencyMap.getOrDefault(ch, 0) + 1
                );
            }
        }

        char mostCommonChar = ' ';
        int maxFrequency = 0;

        for (Map.Entry<Character, Integer> entry : charFrequencyMap.entrySet()) {
            if (entry.getValue() > maxFrequency) {
                maxFrequency = entry.getValue();
                mostCommonChar = entry.getKey();
            }
        }

        // Display Results
        System.out.println("\n========== ANALYSIS RESULTS ==========");
        System.out.println("Total Characters : " + characterCount);
        System.out.println("Total Words      : " + wordCount);
        System.out.println("Most Common Character : '" +
                mostCommonChar + "' (" + maxFrequency + " times)");

        // Character Frequency
        System.out.print("\nEnter a character to check frequency: ");
        String charInput = scanner.nextLine();

        if (charInput.length() != 1) {
            System.out.println("Invalid input! Please enter exactly one character.");
        } else {
            char searchChar = Character.toLowerCase(charInput.charAt(0));

            int charCount = 0;

            for (char ch : text.toLowerCase().toCharArray()) {
                if (ch == searchChar) {
                    charCount++;
                }
            }

            System.out.println("Character '" + searchChar +
                    "' appears " + charCount + " time(s).");
        }

        // Word Frequency
        System.out.print("\nEnter a word to check frequency: ");
        String searchWord = scanner.nextLine().toLowerCase().trim();

        int wordFrequency = 0;

        for (String word : words) {
            if (word.toLowerCase().equals(searchWord)) {
                wordFrequency++;
            }
        }

        System.out.println("Word \"" + searchWord +
                "\" appears " + wordFrequency + " time(s).");

        // Unique Words
        Set<String> uniqueWords = new HashSet<>();

        for (String word : words) {
            uniqueWords.add(word.toLowerCase());
        }

        System.out.println("Number of Unique Words: " +
                uniqueWords.size());

        System.out.println("====================================");
        System.out.println("      ANALYSIS COMPLETED");
        System.out.println("====================================");

        scanner.close();
        }
    }
}