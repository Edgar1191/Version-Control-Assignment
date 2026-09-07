/**
 * Course: COP 3330C.31034
 * Date: 6/30/2026
 * * Objective: Demonstrate throwing and catching custom exceptions by managing an account
 * creation screen that validates unique username and password requirements.
 * * Inputs: User strings representing usernames and passwords via standard keyboard entry.
 * Outputs: Success/Error tracking statements and a final printout of successfully created profiles.
 */

import java.util.Scanner;

public class AccountCreationApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PasswordVerify[] accounts = new PasswordVerify[4];
        int validAccountsCount = 0;

        // Loop runs until we successfully fill the array with 4 valid accounts
        while (validAccountsCount < 4) {
            System.out.println("\nAccount Rules:");
            System.out.println("Username Rules: 1) Must end with '!' | 2) Must have exactly 2 uppercase letters.");
            System.out.println("Password Rules: 1) Must have at least 3 vowels | 2) Must have exactly 3 digits.");
            System.out.printf("Creating account slots filled: %d/4\n", validAccountsCount);

            System.out.print("Enter Username: ");
            String username = scanner.nextLine();

            System.out.print("Enter Password: ");
            String password = scanner.nextLine();

            try {
                // Attempting to instantiate the validation object
                PasswordVerify userAccount = new PasswordVerify(username, password);

                // If no exception was thrown, save the account to the array
                accounts[validAccountsCount] = userAccount;
                validAccountsCount++;
                System.out.println("Success! Account created successfully.");

            } catch (PasswordVerifyException e) {
                // Catching the custom exception and printing the validation failure message
                System.out.println("\n[ERROR] Account Creation Failed!");
                System.out.println("Reason: " + e.getMessage());
                System.out.println("Please try again with values that respect the rules.");
            }
        }

        // Exited loop because array is filled
        System.out.println("\n");
        System.out.println("All 4 slots filled! Printing valid accounts:");
        System.out.println("\n");
        for (PasswordVerify account : accounts) {
            System.out.println(account);
        }

        scanner.close();
        System.out.println("\nProgram executed successfully. Exiting.");
    }
}