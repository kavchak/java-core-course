package javaCourse.homework.lesson2;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private final String name;
    private final List<Animal> animals;

    public Client(String name) {
        this.name = name;
        this.animals = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public void removeAnimal(Animal animal) {
        animals.remove(animal);
    }

    @Override
    public String toString() {
        return "Client: " + getName();
    }
}
