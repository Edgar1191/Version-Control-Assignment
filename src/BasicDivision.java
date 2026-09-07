import java.util.Scanner;
import java.util.InputMismatchException;

public class BasicDivision {
    public static void main(String[] resignation) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Part 1: Division Application");
        try {
            System.out.print("Enter the first integer (numerator): ");
            int num1 = scanner.nextInt();

            System.out.print("Enter the second integer (denominator): ");
            int num2 = scanner.nextInt();

            /**
             * Java integer division won't throw ArithmeticException if cast to double,
             * so we manually check or let the integer division trigger it first
             */
            if (num2 == 0) {
                throw new ArithmeticException("Division by zero is not allowed.");
            }

            double result = (double) num1 / num2;
            // Displaying result with 2 decimal places
            System.out.printf("%d / %d = %.2f\n", num1, num2, result);

        } catch (ArithmeticException e) {
            // Catching the arithmetic exception and displaying its message
            System.out.println("Error: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Error: Please enter valid integers.");
        } finally {
            scanner.close();
        }
    }
}