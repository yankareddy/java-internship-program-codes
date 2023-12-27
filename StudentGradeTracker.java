import java.util.Scanner;

public class StudentGradeTracker {
    public static void main(String[] args) {

        String[] studentNames = { "John Doe", "Jane Smith", "Alice Johnson" };
        int[] studentGrades = { 90, 85, 78 };

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("Student Grade Tracker Menu:");
            System.out.println("1. Add a new student");
            System.out.println("2. View all students and their grades");
            System.out.println("3. Calculate and display the average grade");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            if (choice == 1) {

                System.out.print("Enter the student's name: ");
                String newName = scanner.next();
                System.out.print("Enter the student's grade: ");
                int newGrade = scanner.nextInt();

                studentNames = addStudent(studentNames, newName);
                studentGrades = addGrade(studentGrades, newGrade);
                System.out.println("Student added successfully.");
            } else if (choice == 2) {

                System.out.println("Students and their grades:");
                for (int i = 0; i < studentNames.length; i++) {
                    System.out.println(studentNames[i] + ": " + studentGrades[i]);
                }
            } else if (choice == 3) {

                double averageGrade = calculateAverageGrade(studentGrades);
                System.out.println("Average grade: " + averageGrade);
            } else if (choice == 4) {

                System.out.println("Exiting Student Grade Tracker. Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice. Please select a valid option.");
            }
        }

        scanner.close();
    }

    public static String[] addStudent(String[] names, String newName) {
        String[] newNames = new String[names.length + 1];
        for (int i = 0; i < names.length; i++) {
            newNames[i] = names[i];
        }
        newNames[names.length] = newName;
        return newNames;
    }

    public static int[] addGrade(int[] grades, int newGrade) {
        int[] newGrades = new int[grades.length + 1];
        for (int i = 0; i < grades.length; i++) {
            newGrades[i] = grades[i];
        }
        newGrades[grades.length] = newGrade;
        return newGrades;
    }

    public static double calculateAverageGrade(int[] grades) {
        if (grades.length == 0) {
            return 0.0;
        }

        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }

        return (double) sum / grades.length;
    }
}