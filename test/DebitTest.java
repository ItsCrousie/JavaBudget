import jdk.jfr.Timestamp;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

/**
 * @author Brian Crouse
 */

public class DebitTest {
    
    @Test
    public void testConstructorPreConditions() {
        // Check input validtaion for name
        Exception e = assertThrows(IllegalArgumentException.class, () -> new Debit("Rent#", new BigDecimal("100.00")));
        assertEquals("Name must only contain letters and whitespace.", e.getMessage(), "Correct IllegalArgumentException message");

        // Check input validation for value is greater than 0
        e = assertThrows(IllegalArgumentException.class, () -> new Debit("Rent", new BigDecimal("-100.00")));
        assertEquals("Value must be positive and greater than 0.", e.getMessage(), "Correct IllegalArgumentException message");

        // Check input validation for value is rounded to two decimal places
        e = assertThrows(IllegalArgumentException.class, () -> new Debit("Rent", new BigDecimal("100.0212")));
        assertEquals("Value must be rounded to nearest cent", e.getMessage(), "Correct IllegalArgumentException message");
    }
}