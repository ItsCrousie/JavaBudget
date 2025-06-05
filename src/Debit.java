public class Debit {
    private String name;
    private double value;

    public Debit (String name, double value) {
        //Only allow letters and whitespace in names.
        if (name.contains("^[a-zA-z\\s]")) {
            throw new IllegalArgumentException("Name must only contain letters and whitespace.");
        }
        this.name = name;
        //Don't allow less than 0 values because they don't add anything.
        if (value <= 0) {
            throw new IllegalArgumentException("Value must be greater than $0.");
        }

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
        this.value = value;
    }

    public String displayDebitInfo () {
        return "Name: " + getName() + " Value: $" + getValue();
    } 
}