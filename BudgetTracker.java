import java.util.InputMismatchException;
import java.util.Scanner;

public class BudgetTracker {
    private double balance;

    public BudgetTracker() {
        balance = 0.0;
    }

    public void addIncome(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Income must be a positive amount.");
        }
    }

    public void addExpense(double amount) {
        if (amount > 0) {
            balance -= amount;
        } else {
            System.out.println("Expense must be a positive amount.");
        }
    }

    public double getBalance() {
        return balance;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BudgetTracker tracker = new BudgetTracker();

        while (true) {
            System.out.println("\n--- Budget Tracker Menu ---");
            System.out.println("1. Add Income");
            System.out.println("2. Add Expense");
            System.out.println("3. View Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            try {
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter income amount: ");
                        double income = scanner.nextDouble();
                        tracker.addIncome(income);
                        break;

                    case 2:
                        System.out.print("Enter expense amount: ");
                        double expense = scanner.nextDouble();
                        tracker.addExpense(expense);
                        break;

                    case 3:
                        // Using printf for better formatting
                        System.out.printf("Current Balance: Rs %.2f%n", tracker.getBalance());
                        break;

                    case 4:
                        System.out.println("Exiting... Thank you!");
                        return;

                    default:
                        System.out.println("Oops! That's not a valid choice.");
                }
            } catch (InputMismatchException e) {
                // This handles non-integer menu input or non-numeric amounts
                System.out.println("Please enter a valid number.");
                scanner.nextLine(); // Clear the invalid input
            }
        }
    }
}
