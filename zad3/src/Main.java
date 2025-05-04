import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Podaj nazwę grupy: ");
        String groupName = scanner.nextLine();

        StudentGroup group = new StudentGroup(groupName);
        group.addStudentsFromScanner(scanner);
        group.printGroup();

        scanner.close();
    }
}