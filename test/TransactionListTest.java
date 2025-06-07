import com.sun.source.doctree.IdentifierTree;
import jdk.jfr.Timestamp;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class TransactionListTest {
    // @Test -> Can't really rest this because transactions is private, so I'll test it as part of the other methods.
    // public void testConstructorPreConditions() {
    //     TransactionList transactionList = new TransactionList();
    //     String id = "TransactionList initiated as an empty ArrayList of transactions";
    //     assertTrue(transactionList. instanceof ArrayList, id);
    // }
    
    //Setup a TransactionList
    @Test
    public void testAddTransaction() {
        String id = "Add transaction successfully adds different transactions";
        // Consider adding Set-ish behavior to prevent duplicates.
        // 💭Although duplicates are rare they might occur and that's ok
        TransactionList tl = new TransactionList();
        Transaction t1 = new Transaction("Aldi", new BigDecimal("10.00")); 
        Transaction t2 = new Transaction("Food Lion", new BigDecimal("11.42")); 
        Transaction t3 = new Transaction("BJs", new BigDecimal("459.94")); 
        
        tl.addTransaction(t1);
        tl.addTransaction(t2);
        tl.addTransaction(t3);

        int exp = 3;
        int act = tl.getTransactionCount();
        assertEquals(exp, act, id);
    }

//     // TODO: getTransaction
//     @Test
//     public void testGetTransaction() {

//     }

//     // TODO: removeTransaction
//     @Test
//     public void testRemoveTransaction() {

//     }

//     // TODO: getTransactionCount
//     @Test
//     public void testGetTransactionCount() {
//     }
    
//     // TODO: displayTransactionList
//     @Test
//     public void testDisplayTransactionList() {
        
//     }
}