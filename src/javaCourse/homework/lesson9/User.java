package javaCourse.homework.lesson9;

public class User {
    private static int idCounter = 0;
    private int id;
    private String name;
    private String email;
    private String phone;
    private String password;

    public User(String name, String email, String phone, String password) {
        this.id = ++idCounter;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    public int getId() {
        return id;
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

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
