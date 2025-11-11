import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ExpenseTrackerMain {

    private static final Scanner scanner = new Scanner(System.in);
    private static final ExpenseManager manager = new ExpenseManager();

    public static void main(String[] args) {
        System.out.println("=== Simple Expense Tracker ===");
        boolean exit = false;

        while (!exit) {
            printMenu();
            int choice = readIntSafe("Choose an option: ");

            switch (choice) {
                case 1:
                    handleAddExpense();
                    break;
                case 2:
                    handleDeleteExpense();
                    break;
                case 3:
                    handleViewAll();
                    break;
                case 4:
                    handleSearchByCategory();
                    break;
                case 5:
                    handleViewTotal();
                    break;
                case 6:
                    System.out.println("Exiting. Goodbye!");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Add an expense");
        System.out.println("2. Delete an expense");
        System.out.println("3. View all expenses");
        System.out.println("4. Search by category");
        System.out.println("5. View total expense");
        System.out.println("6. Exit");
    }

    private static void handleAddExpense() {
        System.out.println("\n-- Add Expense --");
        double amount = readDoubleSafe("Enter amount: ");
        scanner.nextLine(); // consume leftover newline
        System.out.print("Enter category (e.g., Food, Travel): ");
        String category = scanner.nextLine().trim();
        System.out.print("Enter description (optional): ");
        String description = scanner.nextLine().trim();

        Expense e = manager.addExpense(amount, category, description);
        System.out.println("Added: " + e);
    }

    private static void handleDeleteExpense() {
        System.out.println("\n-- Delete Expense --");
        int id = readIntSafe("Enter expense ID to delete: ");
        boolean removed = manager.deleteExpense(id);
        if (removed) {
            System.out.println("Expense with ID " + id + " deleted successfully.");
        } else {
            System.out.println("No expense found with ID " + id + ".");
        }
    }

    private static void handleViewAll() {
        System.out.println("\n-- All Expenses --");
        List<Expense> all = manager.viewAllExpenses();
        if (all.isEmpty()) {
            System.out.println("No expenses recorded yet.");
            return;
        }
        for (Expense e : all) {
            System.out.println(e);
        }
    }

    private static void handleSearchByCategory() {
        System.out.println("\n-- Search By Category --");
        scanner.nextLine(); // consume newline
        System.out.print("Enter category to search: ");
        String category = scanner.nextLine().trim();
        List<Expense> found = manager.searchByCategory(category);
        if (found.isEmpty()) {
            System.out.println("No expenses found in category \"" + category + "\".");
            return;
        }
        System.out.println("Found:");
        for (Expense e : found) {
            System.out.println(e);
        }
    }

    private static void handleViewTotal() {
        double total = manager.getTotalExpense();
        System.out.printf("\nTotal expense: %.2f%n", total);
    }

    private static int readIntSafe(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                int val = scanner.nextInt();
                return val;
            } catch (InputMismatchException ex) {
                System.out.println("Invalid integer input. Please try again.");
                scanner.nextLine(); // clear invalid token
            }
        }
    }

    private static double readDoubleSafe(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                double val = scanner.nextDouble();
                return val;
            } catch (InputMismatchException ex) {
                System.out.println("Invalid number input. Please try again.");
                scanner.nextLine(); // clear invalid token
            }
        }
    }
}
