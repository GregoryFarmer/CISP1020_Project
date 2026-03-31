package com.cisp1020.cisp1020_project;
import com.cisp1020.cisp1020_project.VehicleSubclasses.*;

/**
 *
 * @author Gregory Farmer <GregoryFarmer>, Jacob Hidinger <StronGeek>, Ryan McClure, Zemetrik Ellison
 * 
 */


public class CISP1020_Project {

    public static void main(String[] args) {

        // Create a vehicle
        Vehicle car = new Vehicle("Toyota Camry", 50.00);
        car.setAvailable(true);

        // Create a customer
        Customer customer = new Customer("John Smith", "C001", "Credit Card");

        // Create a reservation (dates must be in yyyy-MM-dd format)
        Reservation reservation = new Reservation(customer, car, "04-01-2026", "04-05-2026");

        // Print reservation details
        System.out.println("=== Reservation Created ===");
        System.out.println(reservation);
        System.out.println("Days: " + reservation.calculateDays());

        // Create an invoice from the reservation
        Invoice invoice = new Invoice("INV-001", reservation);

        // Print the invoice
        System.out.println(invoice);

        // Add an extra charge
        invoice.addCharge("GPS Rental", 15.00);

        // Apply a discount
        invoice.applyDiscount(10.00);

        // Mark as paid
        invoice.markAsPaid("Credit Card");

        // Print the updated invoice
        System.out.println(invoice);

        // Save using ReservationFileHandler
        ReservationFileHandler fileHandler = new ReservationFileHandler();
        fileHandler.createReservation(reservation);

        // Retrieve the reservation by ID
        fileHandler.getReservation(reservation.getReservationId());
    }
}