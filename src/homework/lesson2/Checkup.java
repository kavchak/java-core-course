package homework.lesson2;

public class Checkup implements Procedurable {
    private final String name;
    private final String description;
    private final double price;

    public Checkup() {
        this.name = "Checkup";
        this.description = "Comprehensive examination of the animal's health.";
        this.price = 100.0;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public double getPrice() {
        return price;
    }
}
