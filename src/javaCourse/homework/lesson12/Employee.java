package javaCourse.homework.lesson12;

public class Employee {
    @NotNullValue
    private String name;
    @NotNullValue
    private String email;
    private String phone;
    private double salary;

    public Employee(String name, String email, String phone, double salary) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
    public String getPhone() {
        return phone;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", salary=" + salary +
                '}';
    }
}
