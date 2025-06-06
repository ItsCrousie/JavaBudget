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

    @Test
    // TODO: Fix
    public void testAddTransaction() {
        TransactionList t = new TransactionList();
        String id = "Test addTransaction throws IllegalArgumentException if arg is not a Transaction";
        Exception e = assertThrows(IllegalArgumentException.class, () -> {
                t.add("Blah Blah");
            });
        assertEquals("t is not a Transaction", e.getMessage(), id);
    }

    // TODO: getTransaction

    // TODO: removeTransaction

    // TODO: getTransactionCount
    
    // TODO: displayTransactionList
}