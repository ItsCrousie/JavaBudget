import com.sun.source.doctree.IdentifierTree;
import jdk.jfr.Timestamp;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.math.BigDecimal;

public class TransactionListTest {
    //Setup a TransactionList
    private String id;
    private TransactionList tl;

    @BeforeEach 
    public void setUp() {
        tl = new TransactionList();
        Transaction t1 = new Transaction("Aldi", new BigDecimal("10.00")); 
        Transaction t2 = new Transaction("Food Lion", new BigDecimal("11.42")); 
        Transaction t3 = new Transaction("BJs", new BigDecimal("459.94"));

        tl.addTransaction(t1);
        tl.addTransaction(t2);
        tl.addTransaction(t3);
    }
       
    @Test
    public void testAddTransaction() {
        id = "addTransaction successfully adds different transactions";
        // Consider adding Set-ish behavior to prevent duplicates.
        // 💭Although duplicates are rare they might occur and that's ok
        Transaction t4 = new Transaction("Amazon", new BigDecimal("343.09"));
        
        tl.addTransaction(t4);
        int exp = 4;
        int act = tl.getTransactionCount();
        assertEquals(exp, act, id);
    }

    @Test
    public void testGetTransaction() {
        id = "Check that getTransaction returns a Transaction";
        Object act = tl.getTransaction(0);
        assertTrue(act instanceof Transaction);

        id = "Check that getTransaction returns the correct name and value";
        Transaction actTransaction = (Transaction) act;
        Transaction exp = new Transaction("Aldi", new BigDecimal("10.00"));
        assertEquals(actTransaction.getName(), exp.getName(), id);
        assertEquals(actTransaction.getValue(), exp.getValue(), id);
    }

    @Test
    public void testRemoveTransaction() {
        id = "Check that removeTransaction deletes the Transaction";
        tl.removeTransaction(0);
        for (int i = 0; i < tl.getTransactionCount(); i += 1) {
             Transaction t = tl.getTransaction(i);
            assertFalse(t.getName().contains("Aldi"));
        }

        id = "Check that after removing transaction the second transaction is now the first";
        Transaction exp = new Transaction("Food Lion", new BigDecimal("11.42"));
        assertEquals(tl.getTransaction(0).getName(), exp.getName(), id);
        assertEquals(tl.getTransaction(0).getValue(), exp.getValue(), id);
    }

    // FIX: getTransactionCount
    @Test
    public void testGetTransactionCount() {
        id = "Check that getTransactionCount returns the correct count";
        int exp = 3;
        int act = tl.getTransactionCount();
        assertEquals(exp, act, id);

        //Remove one element and retest:
        tl.removeTransaction(0);
        exp = 2;
        assertEquals(exp, act, id);

        //Add two elemets and retest:
        Transaction addedTransaction1 = new Transaction("Hong Kong", new BigDecimal("35.39"));
        Transaction addedTransaction2 = new Transaction("Hong Kong", new BigDecimal("35.39"));
        tl.addTransaction(addedTransaction1);
        tl.addTransaction(addedTransaction2);
        exp = 4;
        assertEquals(exp, act, id);
    }

    @Test
    public void testGetTransactionListTotal() {
        id = "Test getTransactionListTotal returns the correct total";
        BigDecimal exp = new BigDecimal("481.36");
        BigDecimal act = tl.getTransactionListTotal();
        assertEquals(exp, act, id);
    }
     

    @Test
    public void testDisplayTransactionList() {
        id = "Check that displayTransactionList displays properly";
        String exp = "Name: Aldi Value: $10.00\nName: Food Lion Value: $11.42\nName: BJs Value: $459.94\n";
        String act = tl.displayTransactionList();
        assertEquals(exp, act, id);
    }
}