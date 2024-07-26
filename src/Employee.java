import java.time.LocalDate;

public class Employee {
    int id;
    String name;
    String surname;
    int age;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public Department getDepartment() {
        return department;
    }

    public boolean isEmployer() {
        return isEmployer;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Position getPosition() {
        return position;
    }

    public String getAddress() {
        return address;
    }

    double salary;
    Department department;
    boolean isEmployer;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", department=" + department +
                ", isEmployer=" + isEmployer +
                ", startDate=" + startDate +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", position=" + position +
                ", address='" + address + '\'' +
                '}';
    }

    LocalDate startDate;
    String email;
    String phoneNumber;
    Position position;
    String address;

    public Employee(int id, String name, String surname, int age, double salary, Department department, boolean isEmployer, LocalDate startDate, String email, String phoneNumber, Position position, String address) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.salary = salary;
        this.department = department;
        this.isEmployer = isEmployer;
        this.startDate = startDate;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.position = position;
        this.address = address;
    }
}
