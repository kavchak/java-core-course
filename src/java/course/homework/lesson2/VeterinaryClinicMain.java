package java.course.homework.lesson2;

import java.time.LocalDate;

public class VeterinaryClinicMain {
    public static void main(String[] args) {
        Client client1 = new Client("Bob");
        Client client2 = new Client("Jack");

        Cat cat1 = new Cat("Tom", 5, "Persian", "2024-05-08", "Vaccinations up to date");
        Dog dog1 = new Dog("Rex", 3, "Labrador", "2024-04-10", "Minor ear infection treated");

        client1.addAnimal(cat1);
        client2.addAnimal(dog1);

        Visit visit1 = new Visit(client1, cat1, VisitType.CHECKUP, LocalDate.now());
        visit1.addProcedure(new Checkup());

        Visit visit2 = new Visit(client2, dog1, VisitType.VACCINATION, LocalDate.now());
        visit2.addProcedure(new Vaccination());

        Visit visit3 = new Visit(client2, dog1, VisitType.SURGERY, LocalDate.now());
        visit3.addProcedure(new Surgery());

        visit1.displayVisitInformation();
        visit2.displayVisitInformation();
        visit3.displayVisitInformation();

        cat1.getHealthRecord().printHealthRecordInformation();
        dog1.getHealthRecord().printHealthRecordInformation();
    }
}
