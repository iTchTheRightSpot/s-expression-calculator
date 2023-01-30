import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        long result;
        String input;
        String retry;

        System.out.println("*************** Welcome to S-expression calculator **************");
        do {
            var calculator = new ExpressionCalculator();
            System.out.println();
            System.out.print("Please enter S-expression: ");
            input = scanner.nextLine();
            try {
                result = calculator.evaluate(input);
                System.out.println("S-expression calculation is " + result);
            } catch (NumberFormatException ex) {
                System.out.println("PLEASE ENTER IN THE CORRECT FORMAT");
                System.out.println("**************** Example: (multiply 2 1) ***************");
            }

            System.out.println("************* Enter [Y] to continue or [Any key to] end ************");
            System.out.print("Enter: ");
            retry = scanner.nextLine();
            System.out.println();

        } while (retry.equalsIgnoreCase("y"));
        System.out.println("END");


    }

}
