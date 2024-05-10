package baha;

import java.util.Scanner;

/**
 * This class represents an application for performing basic arithmetic operations.
 */
public class App {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Calculator calculator = new Calculator();

    /**
     * The main method of the application.
     * It prompts the user for two numbers and an operation choice, then performs the selected operation.
     * @param args Command-line arguments (not used)
     */
    public static void main(String[] args) {
        int num1 = readNumber("Enter the first number: ");
        int num2 = readNumber("Enter the second number: ");
        int choice = chooseOperation();

        performOperation(num1, num2, choice);

        scanner.close();
    }

    /**
     * Reads an integer input from the user.
     * @param message The message to display to prompt the user for input.
     * @return The integer entered by the user.
     */
    private static int readNumber(String message) {
        System.out.print(message);
        return scanner.nextInt();
    }

    /**
     * Prompts the user to choose an arithmetic operation.
     * @return The user's choice of operation as an integer.
     */
    private static int chooseOperation() {
        System.out.println("Choose operation:");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");

        return scanner.nextInt();
    }

    /**
     * Performs the selected arithmetic operation on the two given numbers.
     * @param num1 The first number.
     * @param num2 The second number.
     * @param choice The choice of operation.
     */
    private static void performOperation(int num1, int num2, int choice) {
        switch (choice) {
            case 1:
                System.out.println("Result of Addition: " + calculator.add(num1, num2));
                break;
            case 2:
                System.out.println("Result of Subtraction: " + calculator.subtract(num1, num2));
                break;
            case 3:
                System.out.println("Result of Multiplication: " + calculator.multiply(num1, num2));
                break;
            case 4:
                try {
                    System.out.println("Result of Division: " + calculator.divide(num1, num2));
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
}
