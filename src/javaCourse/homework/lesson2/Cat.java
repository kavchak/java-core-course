package javaCourse.homework.lesson2;

public class Cat extends Animal {
    public Cat(String name, int age, String breed, String lastVisitDate, String medicalHistory) {
        super(name, age, breed, lastVisitDate, medicalHistory);
    }

    @Override
    public AnimalType getType() {
        return AnimalType.CAT;
    }
}
