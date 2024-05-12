package java.course.homework.lesson2;

public abstract class Animal {
    private final String name;
    private final int age;
    private final String breed;
    private final HealthRecord healthRecord;

    public Animal(String name, int age, String breed, String lastVisitDate, String medicalHistory) {
        this.name = name;
        this.age = age;
        this.breed = breed;
        this.healthRecord = new HealthRecord(this, lastVisitDate, medicalHistory);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getBreed() {
        return breed;
    }

    public abstract AnimalType getType();

    @Override
    public String toString() {
        return "Animal: " + getType() + "," +
                "\nAnimal breed: " + getBreed() + "," +
                "\nAnimal age: " + getAge() + "," +
                "\nAnimal name: " + getName() + ",";
    }

    public static class HealthRecord {
        private final Animal animal;
        private final String lastVisitDate;
        private final String medicalHistory;

        public HealthRecord(Animal animal, String lastVisitDate, String medicalHistory) {
            this.animal = animal;
            this.lastVisitDate = lastVisitDate;
            this.medicalHistory = medicalHistory;
        }

        public String getLastVisitDate() {
            return lastVisitDate;
        }

        public String getMedicalHistory() {
            return medicalHistory;
        }

        public void printHealthRecordInformation() {
            if (animal.getHealthRecord() != null) {
                System.out.println("\nAccessing Health Record for " + animal.getName());
                System.out.println("Last Visit Date: " + getLastVisitDate());
                System.out.println("Medical History: " + getMedicalHistory());
            } else {
                System.out.println("No health record found for " + animal.getName());
            }
        }
    }

    public HealthRecord getHealthRecord() {
        return healthRecord;
    }
}