package java.course.homework.lesson2;

public interface Procedurable {
    String getName();
    default String getDescription() {
        return "A general veterinary procedure.";
    }
    double getPrice();
}