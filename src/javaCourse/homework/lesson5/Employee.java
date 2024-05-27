package javaCourse.homework.lesson5;

public class Employee implements Comparable<Employee> {
    private String firstName;
    private String lastName;
    private double salary;
    private EmployeeType type;

    public Employee(String firstName, String lastName, double salary, EmployeeType type) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.type = type;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getSalary() {
        return salary;
    }

    public EmployeeType getType() {
        return type;
    }

    @Override
    public int compareTo(Employee other) {
        if (other.getSalary() == this.getSalary()){
            return 0;
        } else if (other.getSalary() > this.getSalary()) {
            return -1;
        } else {
            return 1;
        }
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                ", type=" + type +
                '}';
    }
}
