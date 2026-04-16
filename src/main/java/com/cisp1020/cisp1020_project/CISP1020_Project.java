package com.cisp1020.cisp1020_project;

import com.cisp1020.cisp1020_project.VehicleSubclasses.*;
import java.util.*; import java.time.*; import java.time.format.*;

/**
 * The main file for running the project's program.
 * @author Gregory Farmer, Jacob Hidinger, Ryan McClure, Zemetrik Ellison
 */
public class CISP1020_Project {
    /**
     * Executes the program.
     * @param args 
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Boolean isInputing = true;
        
        while (isInputing) {
            System.out.println("Enter customer name: ");
            String name = scanner.nextLine();

            String id = String.format("%s%s", name.substring(0, (int) Math.floor(name.length() / 2)), String.valueOf((int) Math.floor((Math.random() * 1000))));
            System.out.println("Enter payment type (Credit Card/Debit Card/Cash): ");
            String paymentType = scanner.nextLine();

            Customer customer = new Customer(name, id, paymentType);

            System.out.println("\nSelect a vehicle category:");
            System.out.println("1. Economy    - EconomyCar");
            System.out.println("2. Practical  - Honda Civic");
            System.out.println("3. Luxury     - Luxury Car");
            System.out.println("4. Specialty  - Motorcycle");
            System.out.println("Enter choice (1-4): ");

            String carChoice = scanner.nextLine();
            Vehicle car;

            switch (carChoice) {
                case "1":
                    car = new EconomyCar();
                    break;
                case "2":
                    car = new PracticalCar();
                    break;
                case "3":
                    car = new LuxuryCar();
                    break;
                case "4":
                    car = new SpecialtyCar();
                    break;
                default:
                    System.out.println("Invalid choice, defaulting to Economy Car.");
                    car = new EconomyCar();
            }
            System.out.println(car.getID());

            System.out.println("Enter start date (MM-dd-yyyy): ");
            String startDate = scanner.nextLine();

            if(!startDate.matches("[0-9]{2}-[0-9]{2}-[0-9]{4}")) {
                LocalDate def = LocalDate.now().plusDays(1);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
                String formattedDate = def.format(formatter);
                startDate = formattedDate;
                System.out.println(String.format("Invalid date! Defaulting to %s", formattedDate));
            };

            System.out.println("Enter end date (MM-dd-yyyy): ");
            String endDate = scanner.nextLine();

            if(!endDate.matches("[0-9]{2}-[0-9]{2}-[0-9]{4}")) {
                LocalDate def = LocalDate.now().plusDays(4);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
                String formattedDate = def.format(formatter);
                endDate = formattedDate;
                System.out.println(String.format("Invalid date! Defaulting to %s", formattedDate));
            };

            Reservation reservation = new Reservation(customer, car, startDate, endDate);

            System.out.println("=== Reservation Created ===");
            System.out.println(reservation);
            System.out.println("Days: " + reservation.calculateDays());

            Invoice invoice = new Invoice("INV-001", reservation);

            invoice.addCharge("GPS Rental", 15.00);
            invoice.applyDiscount(10.00);


            System.out.println(invoice);


            System.out.println("Would you like to proceed with payment? (yes/no)");
            String payResponse = scanner.nextLine();

            if (payResponse.equalsIgnoreCase("yes")) {
                invoice.markAsPaid(paymentType);
                System.out.println("Payment processed successfully!");
                System.out.println(invoice); // now shows PAID status
            } else {
                System.out.println("Payment pending. Please complete payment to confirm your reservation.");
            }

            ReservationFileHandler fileHandler = new ReservationFileHandler();
            fileHandler.createReservation(reservation);
            fileHandler.getReservation(customer.getID());


            String response = "yes";
            while (response.equalsIgnoreCase("yes")) {
                System.out.println("\nWould you like to extend your reservation? (yes/no)");
                response = scanner.nextLine();

                if (response.equalsIgnoreCase("yes")) {
                    System.out.println("Enter new end date (MM-dd-yyyy): ");
                    String newEndDate = scanner.nextLine();
                    reservation.setEndDate(newEndDate);
                    fileHandler.updateReservation(customer.getID(), reservation);
                    System.out.println("Reservation extended to: " + newEndDate);
                    System.out.println("Updated days: " + reservation.calculateDays());
                }
            }

            System.out.println("Thank you for using our service, " + name + "!");
            
            System.out.println("\nWould you like to enter another reservation? (yes)");
            Boolean inputNext = scanner.nextLine().equalsIgnoreCase("yes") ? true : false;
            isInputing = inputNext;
        }
        scanner.close();
    }
}
