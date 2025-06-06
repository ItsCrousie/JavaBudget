import java.util.ArrayList;
import java.math.BigDecimal;

public class TransactionList {
    private ArrayList<Transaction> transactions;

    public TransactionList() {
        transactions = new ArrayList<Transaction>();
    }

    public Transaction getTransaction(int index) {
        if (index < 0 || index >= transactions.size()) {
            throw new IllegalArgumentException("Index out of bounds");
        }
        return transactions.get(index);
    }
    
    public void addTransaction(Transaction t) {
        if (!(t instanceof Transaction)) {
            throw new IllegalArgumentException("t is not a Transaction");
        }
        else {
            transactions.add(t);
        }
    }

    public void removeTransaction(int index) {
        if (index < 0 || index >= transactions.size()) {
            throw new IllegalArgumentException("Index out of bounds");
        }
        transactions.remove(index);
    }

    public int getTransactionCount() {
        return transactions.size();
    }

    public String displayTransactionList() {
        String transactionListString = "";
        for (Transaction t : transactions) {
            transactionListString += t.displayTransaction() + "\n";
        }
        return transactionListString;
    }
}