import java.util.Scanner;

class Room {
    private String guestName;
    private boolean isBooked;

    public Room() {
        this.isBooked = false;
        this.guestName = "";
    }

    public void bookRoom(String guestName) {
        if (!isBooked) {
            this.guestName = guestName;
            this.isBooked = true;
            System.out.println("Room booked successfully for " + guestName);
        } else {
            System.out.println("Sorry, the room is already booked.");
        }
    }

    public void checkout() {
        if (isBooked) {
            System.out.println(guestName + " has checked out.");
            this.isBooked = false;
            this.guestName = "";
        } else {
            System.out.println("No one is currently staying in this room.");
        }
    }

    public void roomStatus(int roomNumber) {
        if (isBooked) {
            System.out.println("Room " + roomNumber + " is booked by " + guestName);
        } else {
            System.out.println("Room " + roomNumber + " is available.");
        }
    }

    public boolean isAvailable() {
        return !isBooked;
    }
}

public class HotelManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int TOTAL_ROOMS = 5; // Change this number to add more rooms
        Room[] rooms = new Room[TOTAL_ROOMS];

        // Initialize all rooms
        for (int i = 0; i < TOTAL_ROOMS; i++) {
            rooms[i] = new Room();
        }

        while (true) {
            System.out.println("\nHotel Management System");
            System.out.println("1. Book Room");
            System.out.println("2. Checkout");
            System.out.println("3. Room Status");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter room number (0 - " + (TOTAL_ROOMS - 1) + "): ");
                    int roomNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    if (roomNumber >= 0 && roomNumber < TOTAL_ROOMS) {
                        if (rooms[roomNumber].isAvailable()) {
                            System.out.print("Enter Guest Name: ");
                            String guestName = scanner.nextLine();
                            rooms[roomNumber].bookRoom(guestName);
                        } else {
                            System.out.println("Room " + roomNumber + " is already booked.");
                        }
                    } else {
                        System.out.println("Invalid room number.");
                    }
                    break;

                case 2:
                    System.out.print("Enter room number (0 - " + (TOTAL_ROOMS - 1) + ") to checkout: ");
                    int checkoutRoom = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    if (checkoutRoom >= 0 && checkoutRoom < TOTAL_ROOMS) {
                        rooms[checkoutRoom].checkout();
                    } else {
                        System.out.println("Invalid room number.");
                    }
                    break;

                case 3:
                    System.out.println("Room Status:");
                    for (int i = 0; i < TOTAL_ROOMS; i++) {
                        rooms[i].roomStatus(i);
                    }
                    break;

                case 4:
                    System.out.println("Exiting... Thank you!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}