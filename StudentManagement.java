import java.io.*;
import java.util.*;

class Student implements Serializable {
    int id;
    String name;
    int age;

    Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return id + " " + name + " " + age;
    }
}

public class StudentManagement {

    static List<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static final String FILE = "students.dat";

    public static void main(String[] args) {

        loadFromFile();

        while (true) {

            System.out.println("\n1.Add");
            System.out.println("2.View");
            System.out.println("3.Update");
            System.out.println("4.Delete");
            System.out.println("5.Save");
            System.out.println("6.Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1: add(); break;
                case 2: view(); break;
                case 3: update(); break;
                case 4: delete(); break;
                case 5: saveToFile(); break;
                case 6:
                    saveToFile();
                    System.exit(0);
            }
        }
    }

    static void add() {
        System.out.print("ID: ");
        int id = sc.nextInt();

        System.out.print("Name: ");
        String name = sc.next();

        System.out.print("Age: ");
        int age = sc.nextInt();

        students.add(new Student(id, name, age));
    }

    static void view() {
        for (Student s : students)
            System.out.println(s);
    }

    static void update() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        for (Student s : students) {
            if (s.id == id) {
                System.out.print("New Name: ");
                s.name = sc.next();

                System.out.print("New Age: ");
                s.age = sc.nextInt();
                return;
            }
        }
        System.out.println("Student not found");
    }

    static void delete() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        students.removeIf(s -> s.id == id);
    }

    static void saveToFile() {
        try {
            ObjectOutputStream oos =
                    new ObjectOutputStream(new FileOutputStream(FILE));
            oos.writeObject(students);
            oos.close();
            System.out.println("Saved");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void loadFromFile() {
        try {
            ObjectInputStream ois =
                    new ObjectInputStream(new FileInputStream(FILE));
            students = (List<Student>) ois.readObject();
            ois.close();
        } catch (Exception e) {
            System.out.println("No previous data");
        }
    }
}