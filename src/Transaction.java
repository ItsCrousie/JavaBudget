
import java.math.BigDecimal;

/**
 * @author Brian Crouse
 */

public class Transaction {
    private String name;
    private BigDecimal value;

    public Transaction(String name, BigDecimal value) {
        setName(name);
        setValue(value);
    }
    
    public String getName() {
        return name;
    }

    public BigDecimal getValue () {
        return value;
    }

    public void setName(String name) {
        if (!name.matches("[a-zA-Z\\s]+")) {
            throw new IllegalArgumentException("Name must only contain letters and whitespace.");
        }
        this.name = name;
    }

    public void setValue(BigDecimal value) {
        //Check if value is greater than 0
        if (value.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Value must be positive and greater than 0."); 
        }
        //Check if value is rounded to two decimal places
        if (value.scale() > 2) {
            throw new IllegalArgumentException("Value must be rounded to nearest cent.");
        }
        this.value = value;
    }

    public String displayTransaction() {
        return "Name: " + getName() + " Value: $" + getValue();
    } 
}