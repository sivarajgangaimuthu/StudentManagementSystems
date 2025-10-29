import java.io.*;
import java.util.*;

public class StudentManagementSystem {

    private static final String FILE_NAME = "students.txt";
    static Scanner sc = new Scanner(System.in);
    static List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        loadStudents();

        while (true) {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student City");
            System.out.println("4. Delete Student");
            System.out.println("5. Search Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1: addStudent(); break;
                case 2: viewStudents(); break;
                case 3: updateStudent(); break;
                case 4: deleteStudent(); break;
                case 5: searchStudent(); break;
                case 6:
                    saveStudents();
                    System.out.println("Exited!");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    public static void loadStudents() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                students.add(new Student(
                        Integer.parseInt(data[0]), data[1],
                        Integer.parseInt(data[2]), data[3], data[4]
                ));
            }
        } catch (Exception e) {
            System.out.println("No existing data found.");
        }
    }

    public static void saveStudents() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Student s : students) {
                pw.println(s);
            }
        } catch (Exception e) {
            System.out.println("Error saving data");
        }
    }

    public static void addStudent() {
        System.out.print("ID: ");
        int id = sc.nextInt();
        System.out.print("Name: ");
        String name = sc.next();
        System.out.print("Age: ");
        int age = sc.nextInt();
        System.out.print("Course: ");
        String course = sc.next();
        System.out.print("City: ");
        String city = sc.next();

        students.add(new Student(id, name, age, course, city));
        saveStudents();
        System.out.println("Student added!");
    }

    public static void viewStudents() {
        System.out.println("\nID | Name | Age | Course | City");
        for (Student s : students) {
            System.out.println(s.getId() + " | " + s.getName() + " | " + s.getAge() +
                    " | " + s.getCourse() + " | " + s.getCity());
        }
    }

    public static void updateStudent() {
        System.out.print("Enter Student ID to update city: ");
        int id = sc.nextInt();
        for (Student s : students) {
            if (s.getId() == id) {
                System.out.print("New City: ");
                String city = sc.next();
                s.setCity(city);
                saveStudents();
                System.out.println("Updated successfully!");
                return;
            }
        }
        System.out.println("ID not found!");
    }

    public static void deleteStudent() {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        Iterator<Student> it = students.iterator();
        while (it.hasNext()) {
            if (it.next().getId() == id) {
                it.remove();
                saveStudents();
                System.out.println("Deleted successfully!");
                return;
            }
        }
        System.out.println("ID not found!");
    }

    public static void searchStudent() {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        for (Student s : students) {
            if (s.getId() == id) {
                System.out.println("\nDetails:");
                System.out.println("ID: " + s.getId());
                System.out.println("Name: " + s.getName());
                System.out.println("Age: " + s.getAge());
                System.out.println("Course: " + s.getCourse());
                System.out.println("City: " + s.getCity());
                return;
            }
        }
        System.out.println("No student found!");
    }
}
