public class Debit {
    private String name;
    private double value;

    public Debit (String name, double value) {
        this.name = name;
        this.value = value;
    }
    
    public String getName () {
        return name;
    }

    public double getValue () {
        return value;
    }

    public void setName (String name) {
        if (name.contains("^[a-zA-z\\s]")) {
            throw new IllegalArgumentException("Name must only contain letters and whitespace.");
        }
        this.name = name;
    }

    public void setValue (double value) {
        if (value <= 0) {
            throw new IllegalArgumentException("Value must be greater than $0.");
        }
        this.value = value;
    }

    public String displayDebitInfo () {
        return "Name: " + getName() + " Value: $" + getValue();
    } 
}