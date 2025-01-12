public class Main {
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


