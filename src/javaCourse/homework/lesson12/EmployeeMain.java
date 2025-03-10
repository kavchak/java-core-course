package javaCourse.homework.lesson12;

public class EmployeeMain {
    private static final int EMPLOYEE_COUNT = 10;

    public static void main(String[] args) {
        for (int i = 0; i < EMPLOYEE_COUNT; i++) {
            Employee employee = EmployeeGenerator.createRandomEmployee();
            try {
                NotNullValidator.validate(employee);
                System.out.println("Created " + employee);
            } catch (NotNullFieldException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
