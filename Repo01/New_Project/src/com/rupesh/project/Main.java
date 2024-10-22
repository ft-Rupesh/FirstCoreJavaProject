package com.rupesh.project;

import java.util.Scanner;

public class Main 
{
	private static final String YELLOW = "\033[1;33m";
	private static final String RED = "\033[1;31m"; 
	private static final String BLUE = "\033[1;34m"; 
	private static final String GREEN = "\033[1;32m"; 
	private static final String GRAY = "\033[1;31m"; 
	private static final String RESET = "\033[0m";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ReservationSystem reservationSystem = new ReservationSystem();

        
        reservationSystem.addUser(new User("Saswati", "saswati@example.com"));
        reservationSystem.addUser(new User("Baraik", "baraik@example.com"));

        reservationSystem.addService(new Service(YELLOW+"Hotel Room"+RESET, 120.00));
        reservationSystem.addService(new Service(BLUE+"Airport Transfer"+RESET, 30.00));
        reservationSystem.addService(new Service(GREEN+"Concert Ticket"+RESET, 50.00));

        // Main loop for user input
        while (true) {
            System.out.println(RED+"\nWelcome to the Online Reservation System!"+RESET);
            System.out.println(GRAY+"1. Display Services"+RESET);
            System.out.println(BLUE+"2. Make Reservation"+RESET);
            System.out.println(GREEN+"3. Exit"+RESET);
            System.out.print(YELLOW+"Choose an option: "+RESET);
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    reservationSystem.displayServices();
                    break;
                case 2:
                    System.out.print(BLUE+"Enter your name: "+RESET);
                    String name = scanner.next();
                    System.out.print(GRAY+"Enter your email: "+RESET);
                    String email = scanner.next();
                    User user = new User(name, email);

                    reservationSystem.addUser(user); 

                    reservationSystem.displayServices();
                    System.out.print("Choose a service (1-" + reservationSystem.getServices().size() + "): ");
                    int serviceChoice = scanner.nextInt();

                    if (serviceChoice < 1 || serviceChoice > reservationSystem.getServices().size()) {
                        System.err.println("Invalid choice -> Try again.");
                    } else {
                        Service service = reservationSystem.getServices().get(serviceChoice - 1);
                        reservationSystem.makeReservation(user, service);
                    }
                    break;
                case 3:
                    System.out.println(BLUE+"Thanks for using Online Reservation System:"+RESET);
                    scanner.close();
                    return;
                default:
                    System.err.println("Invalid choice -> Try again.");
            }
        }
    }
}