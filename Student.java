public class Student implements Comparable<Student> {
    
    private final int id;
    private final String name;
    private final double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCGPA() {
        return cgpa;
    }

    @Override
    public int compareTo(Student other) {
        if (Double.compare(this.cgpa, other.cgpa) != 0) {
            return Double.compare(other.cgpa, this.cgpa); // Сортировка по убыванию cgpa
        } else if (!this.name.equals(other.name)) {
            return this.name.compareTo(other.name); // Алфавитный порядок имени
        } else {
            return Integer.compare(this.id, other.id); // Сортировка по возрастанию id
        }
    }
}