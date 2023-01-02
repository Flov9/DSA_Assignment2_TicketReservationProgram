/*
Name: Loo Sai Hong
Matric no.: 209012
Date: 2 December 2022
 */

import java.util.Scanner;

public class Main_Simple {
    static Scanner scanner = new Scanner(System.in);
    // Create an instance of flight linked list
    static FlightReservation flight1 = new FlightReservation();

    public static void main(String[] args) {
        // Launch the main menu
        mainMenu();
    }

    // Main menu to log in as user or admin
    public static void mainMenu() {
        System.out.print("""
                Are you logging in as an Admin or User?
                =======================================
                1. User
                2. Admin
                
                Type 1 or 2 to proceed.
                """);

        int login = scanner.nextInt();

        if (login == 1) {
            userMenu();
        } else if (login == 2) {
            adminMenu();
        }
    }

    // User menu to decide on different user actions
    public static void userMenu() {
        System.out.print("""
                                USER MENU
                    =================================
                    1. Book flight ticket
                    2. Cancel flight ticket
                    3. Return to main menu
                    
                    Type 1 or 2 to proceed.
                    """);

        userAction(scanner.nextInt());
    }

    // Admin menu to decide on different admin actions
    public static void adminMenu() {
        System.out.print("""
                                ADMIN MENU
                    ==================================
                    1. Check ticket availability
                    2. Display passenger
                    3. Return to main menu
                    
                    Type 1 or 2 to proceed.
                    """);

        adminAction(scanner.nextInt());
    }

    // User action decisions method
    public static void userAction(int choice) {
        scanner.nextLine();

        switch (choice) {
            case 1: { // Book a ticket
                System.out.println("Enter the desired ticket (format: char 'A' followed by 3 digits).");
                Ticket information = new Ticket(scanner.nextLine());
                // Create the input ticket
                flight1.createReservation(information);

                // Back to user menu
                userMenu();

                break;
            }
            case 2: { // Cancel a ticket
                System.out.println("Enter the ticket you want to cancel");
                Ticket information = new Ticket(scanner.nextLine());
                // Cancel the input ticket
                flight1.cancelReservation(information);

                // Back to user menu
                userMenu();

                break;
            }
            case 3: { // Back to main menu
                System.out.println("Back to menu..\n");
                mainMenu();

                break;
            }
            // When the input choice is invalid
            default:
                System.out.println("Invalid option");
                userMenu();
        }
    }

    // Admin action decisions method
    public static void adminAction(int choice) {
        scanner.nextLine();

        switch (choice) {
            case 1: { // Show availability of the ticket
                System.out.println("Enter the desired ticket (format: char 'A' followed by 3 digits).");
                Ticket information = new Ticket(scanner.nextLine());

                if (flight1.checkReservation(information)) {
                    System.out.println("Ticket already reserved.\n");
                } else {
                    System.out.println("Ticket available!\n");
                }

                // Back to admin menu
                adminMenu();

                break;
            }
            case 2: { // Show the detailed info of the passenger after entering a valid ticket
                System.out.println("Enter the ticket you want to display.");
                flight1.displayPassenger(new Ticket(scanner.nextLine()));

                // Back to admin menu
                adminMenu();

                break;
            }
            case 3: { // Back to main menu
                System.out.println("Back to menu..\n");
                mainMenu();
            }
            // When the input choice is invalid
            default:
                System.out.println("Invalid option\n");
                adminMenu();
        }
    }
}

// Class that contains the implemented linked list
class FlightReservation {
    private final Scanner scanner = new Scanner(System.in);
    private final MyLinkedList<Ticket> reservation = new MyLinkedList<>();

    // Constructor that can have the ticket no. passed into it
    public void createReservation(Ticket info) {
        // Check for the ticket availability first
        if (checkReservation(info)) {
            System.out.println("Ticket already reserved. Press 'enter' to try another one.");
            Main_Simple.userAction(1);
        }

        // Add the desired ticket to the end of the linked list
        reservation.addLast(info);
        // Prompt user for their detailed info
        System.out.println("Enter the following information: Full name, departure point and destination");
        info.setName(scanner.nextLine());
        info.setDeparture(scanner.nextLine());
        info.setDestination(scanner.nextLine());
        System.out.println("Ticket successfully booked!\n");
    }

    // Method to cancel reservation (ticket)
    public void cancelReservation(Ticket info) {
        // Check the index of the ticket if it is valid or not
        int index = reservation.indexOf(info);

        // If it is not valid will return -1, otherwise acceptable
        if (index < 0) {
            System.out.println("No such ticket exists!");
            System.out.println("Returning to menu..\n");
        }
        else {
            Ticket ticket = reservation.remove(index);
            System.out.println(ticket + " successfully cancelled!\n");
        }
    }

    // Method to check for validity of reservation (ticket)
    public boolean checkReservation(Ticket info) {
        return reservation.contains(info);
    }

    // Method to display passenger info
    public void displayPassenger(Ticket info) {
        // Check for validity of reservation first
        if (checkReservation(info)) {
            System.out.println(reservation.toString() + "\n");
        }
        else {
            System.out.println("No such ticket exists!\n");
        }
    }
}

// Class that contains the passenger info
class Ticket {
    private String ticketNo, name, departure, destination, flightNo;

    // Main constructors that help create tickets
    public Ticket(String ticketNo) {
        this.ticketNo = ticketNo;
    }

    // Getters and setters
    public String getTicketNo() {
        return ticketNo;
    }

    public void setTicketNo(String ticketNo) {
        this.ticketNo = ticketNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    // toString method that returns the passenger infos
    @Override
    public String toString() {
        return "PassengerInformation {" +
                "ticketNo='" + ticketNo + '\'' +
                ", name='" + name + '\'' +
                ", departure='" + departure + '\'' +
                ", destination='" + destination + '\'' +
                ", flightNo='" + flightNo + '\'' +
                '}';
    }

    // Method to compare the input ticketNo with the ticket in the linked list
    @Override
    public boolean equals(Object o) {
        if (o instanceof Ticket) {
            return ((Ticket) o).ticketNo.equals(this.ticketNo);
        }

        return false;
    }
}