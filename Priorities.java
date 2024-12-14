import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Priorities {
    public List<Student> getStudents(List<String> events) {
        PriorityQueue<Student> queue = new PriorityQueue<>();

        for (String event : events) {
            String[] parts = event.split("\\s+");
            if (parts[0].equals("ENTER")) {
                String name = parts[1];
                double cgpa = Double.parseDouble(parts[2]);
                int id = Integer.parseInt(parts[3]);
                queue.add(new Student(id, name, cgpa));
            } else if (parts[0].equals("SERVED")) {
                queue.poll(); // Удалить студента с наивысшим приоритетом
            }
        }

        // Выгружаем оставшихся студентов в отсортированном порядке
        List<Student> remainingStudents = new ArrayList<>();
        while (!queue.isEmpty()) {
            remainingStudents.add(queue.poll());
        }
        return remainingStudents;
    }
}
