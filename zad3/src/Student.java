import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student {
    public String fname;
    public String lname;
    public String indexNumber;
    public String email;
    public String address;
    public List<Double> grades;

    public Student(Scanner scanner) {
        System.out.print("Imię: ");
        this.fname = scanner.nextLine();

        System.out.print("Nazwisko: ");
        this.lname = scanner.nextLine();

        System.out.print("Numer indeksu: ");
        this.indexNumber = scanner.nextLine();

        System.out.print("Email: ");
        this.email = scanner.nextLine();

        System.out.print("Adres: ");
        this.address = scanner.nextLine();

        this.grades = new ArrayList<>();
    }

    public void addGrade(Scanner scanner) {
        while (true) {
            System.out.print("Dodaj ocenę (lub 'q' by zakończyć): ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("q")) break;

            try {
                double grade = Double.parseDouble(input);
                if (grades.size() >= 20) throw new IllegalStateException("Max 20 ocen.");
                grades.add(grade);
            } catch (NumberFormatException e) {
                System.out.println("Nieprawidłowa wartość.");
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
                break;
            }
        }
    }

    public double calculateAverageGrade() {
        if (grades.isEmpty()) throw new IllegalArgumentException("Brak ocen.");

        double sum = 0;
        for (double g : grades) sum += g;
        double avg = sum / grades.size();

        double[] allowed = {2, 2.5, 3, 3.5, 4, 4.5, 5};
        double closest = allowed[0];
        for (double val : allowed) {
            if (Math.abs(val - avg) < Math.abs(closest - avg)) closest = val;
        }
        return closest;
    }

    public void printStudent() {
        System.out.println(fname + " " + lname + " (" + indexNumber + ")");
        System.out.println("Email: " + email + ", Adres: " + address);
        System.out.println("Oceny: " + grades);
        if (!grades.isEmpty()) {
            System.out.println("Średnia (zaokrąglona): " + calculateAverageGrade());
        }
    }
}