package javaCourse.homework.lesson2;

public class Dog extends Animal {
    public Dog(String name, int age, String breed, String lastVisitDate, String medicalHistory) {
        super(name, age, breed, lastVisitDate, medicalHistory);
    }

    @Override
    public AnimalType getType() {
        return AnimalType.DOG;
    }
}
