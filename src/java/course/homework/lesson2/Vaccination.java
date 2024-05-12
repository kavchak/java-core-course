package java.course.homework.lesson2;

public class Vaccination implements Procedurable {
    private final String name;
    private final String description;
    private final double price;

    public Vaccination() {
        this.name = "Vaccination";
        this.description = "Administering vaccines to prevent diseases.";
        this.price = 50.0;
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
