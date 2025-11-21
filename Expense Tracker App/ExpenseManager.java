import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ExpenseManager {
    private ArrayList<Expense> expenses;
    private int nextId;

    public ExpenseManager() {
        this.expenses = new ArrayList<>();
        this.nextId = 1;
    }

    public Expense addExpense(double amount, String category, String description) {
        Expense e = new Expense(nextId++, amount, category, description);
        expenses.add(e);
        return e;
    }

    public boolean deleteExpense(int expenseId) {
        for (int i = 0; i < expenses.size(); i++) {
            if (expenses.get(i).getExpenseId() == expenseId) {
                expenses.remove(i);
                return true;
            }
        }
        return false;
    }

    public List<Expense> viewAllExpenses() {
        return new ArrayList<>(expenses);
    }

    public List<Expense> searchByCategory(String category) {
        ArrayList<Expense> result = new ArrayList<>();
        if (category == null) return result;
        String catLower = category.trim().toLowerCase(Locale.ROOT);
        for (Expense e : expenses) {
            if (e.getCategory() != null && e.getCategory().trim().toLowerCase(Locale.ROOT).equals(catLower)) {
                result.add(e);
            }
        }
        return result;
    }

    public double getTotalExpense() {
        double total = 0.0;
        for (Expense e : expenses) {
            total += e.getAmount();
        }
        return total;
    }
}
