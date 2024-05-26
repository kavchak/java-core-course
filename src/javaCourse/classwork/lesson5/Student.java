package javaCourse.classwork.lesson5;

public class Student {

    private String name;
    private DayOfWeek onDuty;

    public Student(String name, DayOfWeek onDuty) {
        this.name = name;
        this.onDuty = onDuty;
    }

    public String getName() {
        return name;
    }

    public DayOfWeek getOnDuty() {
        return onDuty;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", scheduleAt=" + onDuty +
                '}';
    }
}
