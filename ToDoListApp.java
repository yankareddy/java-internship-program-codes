import java.util.ArrayList;
import java.util.Scanner;

public class ToDoListApp {

    // Data structure to store the to-do list
    private static ArrayList<String> toDoList = new ArrayList<>();

    // Method to add a task to the to-do list
    private static void addTask(String task) {
        toDoList.add(task);
        System.out.println("Task added: " + task);
    }

    // Method to delete a task from the to-do list
    private static void deleteTask(int taskIndex) {
        if (taskIndex >= 0 && taskIndex < toDoList.size()) {
            String removedTask = toDoList.remove(taskIndex);
            System.out.println("Task removed: " + removedTask);
        } else {
            System.out.println("Invalid task index. Please try again.");
        }
    }

    // Method to display the list of tasks
    private static void displayTasks() {
        if (toDoList.isEmpty()) {
            System.out.println("No tasks in the to-do list.");
        } else {
            System.out.println("To-Do List:");
            for (int i = 0; i < toDoList.size(); i++) {
                System.out.println((i + 1) + ". " + toDoList.get(i));
            }
        }
    }

    // Method to mark a task as complete
    private static void markTaskAsComplete(int taskIndex) {
        if (taskIndex >= 0 && taskIndex < toDoList.size()) {
            String completedTask = toDoList.get(taskIndex);
            System.out.println("Task marked as complete: " + completedTask);
            // You can implement additional logic here if needed.
        } else {
            System.out.println("Invalid task index. Please try again.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nTo-Do List Application Menu:");
            System.out.println("1. Add a task");
            System.out.println("2. Delete a task");
            System.out.println("3. Display tasks");
            System.out.println("4. Mark a task as complete");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter the task to add: ");
                    String newTask = scanner.nextLine();
                    addTask(newTask);
                    break;
                case 2:
                    System.out.print("Enter the index of the task to delete: ");
                    int deleteIndex = scanner.nextInt();
                    deleteTask(deleteIndex - 1); // Adjust index for user input
                    break;
                case 3:
                    displayTasks();
                    break;
                case 4:
                    System.out.print("Enter the index of the task to mark as complete: ");
                    int completeIndex = scanner.nextInt();
                    markTaskAsComplete(completeIndex - 1); // Adjust index for user input
                    break;
                case 0:
                    System.out.println("Exiting the application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 0);

        scanner.close();
    }
}