import java.util.Scanner;

/**
 * QuizGame.java
 * A simple console-based quiz application.
 */
public class QuizGame {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int score = 0;
            int totalQuestions = 5;

            System.out.println("--- Welcome to the Computer Science Quiz! ---");

            // Question 1
            score += askQuestion(scanner, "1. Which component is the 'brain' of the computer?", 
                                 "A. RAM", "B. CPU", "C. Hard Drive", "D. GPU", "B");

            // Question 2
            score += askQuestion(scanner, "2. What is the standard language for relational databases?", 
                                 "A. Java", "B. Python", "C. SQL", "D. HTML", "C");

            // Question 3
            score += askQuestion(scanner, "3. Which data structure follows FIFO principle?", 
                                 "A. Stack", "B. Queue", "C. Tree", "D. Graph", "B");

            // Question 4
            score += askQuestion(scanner, "4. Which of these is a low-level programming language?", 
                                 "A. Assembly", "B. Python", "C. Ruby", "D. Swift", "A");

            // Question 5
            score += askQuestion(scanner, "5. What does JVM stand for?", 
                                 "A. Java Virtual Machine", "B. Java Visual Model", "C. Just Very Modern", "D. Java Variable Method", "A");

            // Calculate and display final score
            double percentage = ((double) score / totalQuestions) * 100;
            System.out.println("\n--- Quiz Finished ---");
            System.out.println("Your final score is: " + score + "/" + totalQuestions);
            System.out.println("Percentage: " + percentage + "%");
        }
    }

    // Helper method to handle input validation and question logic
    public static int askQuestion(Scanner sc, String q, String a, String b, String c, String d, String correct) {
        System.out.println("\n" + q);
        System.out.println(a + "\n" + b + "\n" + c + "\n" + d);
        
        String input;
        while (true) {
            System.out.print("Enter your answer (A, B, C, or D): ");
            input = sc.next().toUpperCase();
            
            // Input validation
            if (input.equals("A") || input.equals("B") || input.equals("C") || input.equals("D")) {
                break;
            } else {
                System.out.println("Invalid input! Please enter A, B, C, or D.");
            }
        }

        // Using switch case to compare input
        return switch (input) {
            case "A", "B", "C", "D" -> {
                if (input.equals(correct)) {
                    System.out.println("Correct!");
                    yield 1;
                } else {
                    System.out.println("Incorrect. The correct answer was " + correct);
                    yield 0;
                }
            }
            default -> 0;
        };
    }
}