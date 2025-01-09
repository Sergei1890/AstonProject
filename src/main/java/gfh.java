
import java.util.ArrayList;
import java.util.List;


public class gfh {
    public static void main(String[] args) {
        // Сотрудники
        Employee employee1 = new Employee("Иванов Иван", "Инженер", "ivanov@mailbox.com", "892312312", 30000, 30);
        Employee employee2 = new Employee("Петров Петр", "Менеджер", "petrov@mailbox.com", "812345678", 25000, 29);
        Employee employee3 = new Employee("Павлов Павл", "Техник", "pavlovp@mailbox.com", "822345678", 20000, 28);
        Employee employee4 = new Employee("Павлов Петр", "Техник", "pavlovpet@mailbox.com", "832345678", 20000, 24);
        Employee employee5 = new Employee("Павлов Иван", "Техник", "pavlovI@mailbox.com", "842345678", 20000, 23);

        // Вывод сотрудников
        employee1.printInfo();
        employee2.printInfo();
        employee3.printInfo();
        employee4.printInfo();
        employee5.printInfo();


        // Парк и аттракционы
        Park park = new Park();
        park.addAttraction("Качели", "10:00 - 22:00", 60);
        park.addAttraction("Горка", "10:00 - 20:00", 70);
        park.addAttraction("Паровозик", "17:00 - 20:00", 150);

        // Вывод информаци об аттракционах
        park.printAttractions();
    }
}

class Employee {
    private final String fullName;
    private final String position;
    private final String email;
    private final String phone;
    private final double salary;
    private final int age;

    public Employee(String fullName, String position, String email, String phone, double salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public void printInfo() {
        System.out.println("ФИО: " + fullName);
        System.out.println("Должность: " + position);
        System.out.println("Email: " + email);
        System.out.println("Телефон: " + phone);
        System.out.println("Зарплата: " + salary);
        System.out.println("Возраст: " + age);
        System.out.println();
    }

    @Override
    public String toString() {
        return "Employee{" +
                "fullName='" + fullName + '\'' +
                ", position='" + position + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }

}

class Park {
    private final List<Attraction> attractions;

    public Park() {
        attractions = new ArrayList<>();
    }

    public void addAttraction(String name, String workingHours, double price) {
        attractions.add(new Attraction(name, workingHours, price));
    }

    public void printAttractions() {
        System.out.println("Аттракционы в парке:");
        for (Attraction attraction : attractions) {
            attraction.printInfo();
        }
    }

    static class Attraction {
        private final String name;
        private final String workingHours;
        private final double price;

        public Attraction(String name, String workingHours, double price) {
            this.name = name;
            this.workingHours = workingHours;
            this.price = price;
        }

        public void printInfo() {
            System.out.println("Название: " + name);
            System.out.println("Время работы: " + workingHours);
            System.out.println("Стоимость: " + price + " руб.");
            System.out.println();
        }
    }
}