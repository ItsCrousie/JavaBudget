import jdk.jfr.Timestamp;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author Brian Crouse
 */

public class TransactionTest {
    
    @Test
    public void testConstructorPreConditions() {
        // Check input validation for name
        Exception e = assertThrows(IllegalArgumentException.class, () -> new Transaction("Rent#", new BigDecimal("100.00")));
        assertEquals("Name must only contain letters and whitespace.", e.getMessage(), "Correct IllegalArgumentException message");

        // Check input validation for value is greater than 0
        e = assertThrows(IllegalArgumentException.class, () -> new Transaction("Rent", new BigDecimal("-100.00")));
        assertEquals("Value must be positive and greater than 0.", e.getMessage(), "Correct IllegalArgumentException message");

        // Check input validation for value is rounded to two decimal places
        e = assertThrows(IllegalArgumentException.class, () -> new Transaction("Rent", new BigDecimal("100.0212")));
        assertEquals("Value must be rounded to nearest cent.", e.getMessage(), "Correct IllegalArgumentException message");
    }

    // Use this Debit for all following tests
    private Transaction transaction1 = new Transaction("Aldi", new BigDecimal("10.00"));
    private String id;

    @Test
    public void testGetName() {
        id = "Successfully retrieves a Debit's Name";
        String exp = "Aldi";
        assertEquals(transaction1.getName(), exp, id);
    }

    @Test
    public void testGetValue() {
        id = "Successfully retrieves a Debit's Value";
        BigDecimal exp = new BigDecimal("10.00");
        assertEquals(transaction1.getValue(), exp, id);
    }

    @Test
    public void testSetName() {
        id = "Throws IllegalArgumentException if name with special characters entered.";
        Exception e = assertThrows(IllegalArgumentException.class, () -> transaction1.setName("!Hell#"));
        assertEquals("Name must only contain letters and whitespace.", e.getMessage(), id);
        
        id = "Successfully sets a new Name";
        String exp = "Food Lion";
        transaction1.setName("Food Lion");
        assertEquals(transaction1.getName(), exp, id);
    }


    @Test
    public void testSetValue() {
        id = "Throws IllegalArgumentException if value lower than 0 entered.";
        Exception e = assertThrows(IllegalArgumentException.class, () -> transaction1.setValue(new BigDecimal("-10.00")));
        assertEquals("Value must be positive and greater than 0.", e.getMessage(), id);

        id = "Throws IllegalArgumentException if value 0 entered.";
        e = assertThrows(IllegalArgumentException.class, () -> transaction1.setValue(new BigDecimal("0.00")));
        assertEquals("Value must be positive and greater than 0.", e.getMessage(), id);
        
        id = "Throws IllegalArgumentException if value not rounded to two decimal places.";
        e = assertThrows(IllegalArgumentException.class, () -> transaction1.setValue(new BigDecimal("1.203")));
        assertEquals("Value must be rounded to nearest cent.", e.getMessage(), id);
        
        id = "Successfully sets a new value";
        BigDecimal exp = new BigDecimal("15.31");
        transaction1.setValue(new BigDecimal("15.31"));
        assertEquals(transaction1.getValue(), exp, id);
    }

    @Test
    public void testDisplayTransaction() {
        id = "Properly shows in the format \"Name: [...] Value: $[...]\"";
        String exp = "Name: Aldi Value: $10.00";
        assertEquals(transaction1.displayTransaction(), exp, id);

        id = "Properly shows changes in format \"Name: [...] Value: $[...]\"";
        transaction1.setName("Food Lion");
        transaction1.setValue(new BigDecimal("14.99"));
        exp = "Name: Food Lion Value: $14.99";
        assertEquals(transaction1.displayTransaction(), exp, id);
    }
}