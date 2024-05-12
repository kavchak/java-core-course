package javaCourse.homework.lesson2;

public class Surgery implements Procedurable {
    private final String name;
    private final String description;
    private final double price;

    public Surgery() {
        this.name = "Surgery";
        this.description = "Medical operation performed on the animal.";
        this.price = 500.0;
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
