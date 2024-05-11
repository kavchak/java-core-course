package homework.lesson2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Visit {
    private final Client client;
    private final Animal animal;
    private final VisitType type;
    private final LocalDate date;
    private final List<Procedurable> procedures;

    public Visit(Client client, Animal animal, VisitType type, LocalDate date) {
        this.client = client;
        this.animal = animal;
        this.type = type;
        this.date = date;
        this.procedures = new ArrayList<>();
    }

    public void addProcedure(Procedurable procedure) {
        procedures.add(procedure);
    }

    public void displayVisitInformation() {
        System.out.println("Visit details:");
        System.out.println("\n" + client);
        System.out.println(animal);
        System.out.println("Visit type: " + type);
        System.out.println("Date: " + date);
        System.out.println("Procedures:");
        for (Procedurable procedure : procedures) {
            System.out.println("- " + procedure.getName() + ": " + procedure.getDescription() + "\n- Price: $" + procedure.getPrice());
        }
        System.out.println();
    }
}
