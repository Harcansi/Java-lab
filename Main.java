import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    // File input
    private static List<String> finput(String path) {
        List<String> events = new ArrayList<>();
        File file = new File(path);
        try (Scanner scanner = new Scanner(file)) {
            int n = scanner.nextInt();
            scanner.nextLine();
            for (int i = 0; i < n; i++) {
                String event = scanner.nextLine();
                events.add(event);
            }
        }
        catch (Exception e) {
            System.err.println("Произошла ошибка: " + e.getMessage());
        }
        return events;
    }
    // Console input
    private static List<String> input() {
        List<String> events = new ArrayList<>();
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            scanner.nextLine();
            for (int i = 0; i < n; i++) {
                String event = scanner.nextLine();
                events.add(event);
            }
        } catch (Exception e) {
            System.err.println("Произошла ошибка: " + e.getMessage());
        }
        return events;
    }
    // Output function
    private static void print(List<Student> students) {
        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student student : students) {
                System.out.println(student.getName());
            }
        }
    } 

    public static void main(String[] args) {
        //List<String> events = input();
        List<String> events = finput("input.txt");

        Priorities priorities = new Priorities();
        List<Student> students = priorities.getStudents(events);

        print(students);
    }
}
