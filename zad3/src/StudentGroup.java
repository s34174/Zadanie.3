import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentGroup {
    public String nazwa;
    private List<Student> students;
    private final int MAX = 15;

    public StudentGroup(String nazwa) {
        this.nazwa = nazwa;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        if (students.size() >= MAX) {
            throw new IllegalStateException("Grupa ma już 15 osób.");
        }
        if (students.contains(student)) {
            throw new IllegalStateException("Student już jest w grupie.");
        }
        students.add(student);
    }

    public void addStudentsFromScanner(Scanner scanner) {
        while (true) {
            System.out.print("\nDodać nowego studenta? (tak/nie): ");
            String answer = scanner.nextLine();
            if (answer.equalsIgnoreCase("nie")) break;
            if (answer.equalsIgnoreCase("tak")) {
                try {
                    Student s = new Student(scanner);
                    s.addGrade(scanner);
                    addStudent(s);
                } catch (Exception e) {
                    System.out.println("Błąd: " + e.getMessage());
                }
            }
        }
    }

    public void printGroup() {
        System.out.println("\nGrupa: " + nazwa);
        for (Student s : students) {
            s.printStudent();
            System.out.println("----------");
        }
    }
}
