public class Debit () {
    private String name;
    private double value;

    public Debit (String name, double value) {
        this.name = name;
        this.value = value;
    }
    
    public double getName () {
        return name;
    }

    public double getValue () {
        return value;
    }
}