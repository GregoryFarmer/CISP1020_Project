package com.cisp1020.cisp1020_project;

import com.cisp1020.cisp1020_project.VehicleSubclasses.*;
import java.util.Scanner;

/**
 *
 * @author Gregory Farmer <GregoryFarmer>, Jacob Hidinger <StronGeek>, Ryan
 * McClure, Zemetrik Ellison
 *
 */
public class CISP1020_Project {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Get customer info from user
        System.out.println("Enter customer name: ");
        String name = scanner.nextLine();

        String id = name.substring(0, 3).toUpperCase() + (int) (Math.random() * 1000);

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

        System.out.println("Enter start date (MM-dd-yyyy): ");
        String startDate = scanner.nextLine();

        System.out.println("Enter end date (MM-dd-yyyy): ");
        String endDate = scanner.nextLine();

        Reservation reservation = new Reservation(customer, car, startDate, endDate);

        System.out.println("=== Reservation Created ===");
        System.out.println(reservation);
        System.out.println("Days: " + reservation.calculateDays());

        Invoice invoice = new Invoice("INV-001", reservation);

        invoice.addCharge("GPS Rental", 15.00);
        invoice.applyDiscount(10.00);

// Show the invoice before payment
        System.out.println(invoice);

// Ask for payment confirmation
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

        // Extension loop
        // Extension loop
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
        scanner.close();
    }
}
