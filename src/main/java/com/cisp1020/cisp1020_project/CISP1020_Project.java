package com.cisp1020.cisp1020_project;
import com.cisp1020.cisp1020_project.VehicleSubclasses.*;

/**
 *
 * @author Gregory Farmer <GregoryFarmer>, Jacob Hidinger <StronGeek>, Ryan McClure, Zemetrik Ellison
 * 
 */


public class CISP1020_Project {

    public static void main(String[] args) {

        
        Vehicle car = new Vehicle("Toyota Camry", 50.00);
        car.setAvailable(true);

        
        Customer customer = new Customer("John Smith", "C001", "Credit Card");

        // Create a reservation (dates must be in yyyy-MM-dd format)
        Reservation reservation = new Reservation(customer, car, "04-01-2026", "04-05-2026");

        
        System.out.println("=== Reservation Created ===");
        System.out.println(reservation);
        System.out.println("Days: " + reservation.calculateDays());

        
        Invoice invoice = new Invoice("INV-001", reservation);

        
        System.out.println(invoice);

        
        invoice.addCharge("GPS Rental", 15.00);

        
        invoice.applyDiscount(10.00);

        
        invoice.markAsPaid("Credit Card");

        
        System.out.println(invoice);

        
        ReservationFileHandler fileHandler = new ReservationFileHandler();
        fileHandler.createReservation(reservation);

        
        fileHandler.getReservation(reservation.getReservationId());
    }
}