import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class OnlineBookingSystem {
    private static Map<String, ArrayList<Boolean>> seatMap = new HashMap<>();

    public static void initializeSeats(int rows, int seatsPerRow) {
        for (int i = 1; i <= rows; i++) {
            ArrayList<Boolean> seats = new ArrayList<>();
            for (int j = 1; j <= seatsPerRow; j++) {
                seats.add(false);
            }
            seatMap.put("Row " + i, seats);
        }
    }

    public static void displaySeats() {
        System.out.println("Available Seats:");
        for (Map.Entry<String, ArrayList<Boolean>> entry : seatMap.entrySet()) {
            System.out.print(entry.getKey() + ": ");
            for (boolean seat : entry.getValue()) {
                System.out.print(seat ? "X " : "O ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void bookSeat(int row, int seat) {
        String rowKey = "Row " + row;
        ArrayList<Boolean> seats = seatMap.get(rowKey);

        if (seats == null || seat < 1 || seat > seats.size() || seats.get(seat - 1)) {
            System.out.println("Invalid seat selection. Please try again.");
        } else {
            seats.set(seat - 1, true);
            System.out.println("Seat booked successfully!");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize the seat map with 5 rows and 10 seats per row
        initializeSeats(5, 10);

        while (true) {
            System.out.println("1. Display Available Seats");
            System.out.println("2. Book a Seat");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displaySeats();
                    break;
                case 2:
                    System.out.print("Enter the row number: ");
                    int selectedRow = scanner.nextInt();
                    System.out.print("Enter the seat number: ");
                    int selectedSeat = scanner.nextInt();
                    bookSeat(selectedRow, selectedSeat);
                    break;
                case 3:
                    System.out.println("Exiting the Online Booking System. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        }
    }
}
