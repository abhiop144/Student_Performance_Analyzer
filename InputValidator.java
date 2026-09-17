import java.util.Scanner;

public class InputValidator {

    public static int getValidMarks(Scanner sc, int subjectNumber) {

        while (true) {

            try {
                System.out.print("Subject " + subjectNumber + ": ");
                int marks = sc.nextInt();

                if (marks < 0 || marks > 100) {
                    System.out.println("Marks must be between 0 and 100.");
                    continue;
                }

                return marks;

            } catch (java.util.InputMismatchException e) {

                System.out.println("Please enter a valid number.");
                sc.nextLine();
            }
        }
    }
}