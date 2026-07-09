package integration;

import java.util.List;
import java.util.Scanner;

/**
 * Stateless static helper providing common console prompting utilities
 * used across menus.
 */
final class MenuUtil {

    private MenuUtil() {
    }

    /**
     * Prompts the user to choose from a list of options, re-prompting
     * until a valid choice is made.
     *
     * @param scanner the scanner to read input from
     * @param prompt  the prompt message
     * @param options the available options
     * @return the chosen option
     * @author Mohsen Kanj
     * @author Luccas Amorim
     */
    public int promptChoice(Scanner scanner, String prompt, List<String> options) {
        while (true) {
            System.out.println(prompt);

            for (int i = 0; i < options.size(); i++) {
                System.out.println((i + 1) + ". " + options.get(i));
            }

            System.out.print("Enter choice: ");
            String input = scanner.nextLine().trim();

            try {
                int choice = Integer.parseInt(input);

                if (choice >= 1 && choice <= options.size()) {
                    return choice;
                }
            } catch (NumberFormatException e) {
                // keep asking
            }

            System.err.println("Invalid choice. Please try again.");
        }
    }

    /**
     * Prompts the user for a yes/no response.
     *
     * @param scanner the scanner to read input from
     * @param prompt  the prompt message
     * @return true for yes, false for no
     * @author Mohsen Kanj
     */
    public static boolean promptYesNo(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt + " (y/n): ");
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("y") || input.equals("yes")) {
                return true;
            }

            if (input.equals("n") || input.equals("no")) {
                return false;
            }

            System.err.println("Please enter y or n.");
        }
    }
}