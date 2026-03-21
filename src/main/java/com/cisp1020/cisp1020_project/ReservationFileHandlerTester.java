/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cisp1020.cisp1020_project;
import com.cisp1020.cisp1020_project.VehicleSubclasses.*;

/**
 *
 * @author jacob
 */
public class ReservationFileHandlerTester {
    public static void main(String[] args) {
        testCreateReservation();
        testGetValidReservation();
        testGetInvalidReservation();
        testInvalidDateFormat();
        testPastDate();
        testCarUnavailable();
    }
        
        private static void testCreateReservation(){
            System.out.println("--- test reservation ---");
            Customer customer = new Customer("Tom Clancy", "C001", "MasterCard");
            Vehicles car = new Camry();
            
            Reservation r = new Reservation(customer, car, "11-25-2026", "11-30-2026");
            ReservationFileHandler handler = new ReservationFileHandler();
            handler.createReservation(r);
            
            System.out.println();
        }
        
        private static void testGetValidReservation(){
            System.out.println("--- test for valid reservation ---");
            ReservationFileHandler validR = new ReservationFileHandler();
            validR.getReservation("Tom Clancy");
            
            System.out.println();
        }
        
        private static void testGetInvalidReservation(){
            System.out.println("--- test invalid reservation ---");
            ReservationFileHandler invalidR = new ReservationFileHandler();
            
            invalidR.getReservation("Reservation not found.");
            
            System.out.println();
        }
        
        private static void testInvalidDateFormat(){
            System.out.println("--- invalid date test ---");
            Customer customer = new Customer("Willoiam DaFoe", " C002", " Money");
            Vehicles car = new Toyota();
            Reservation r = new Reservation(customer, car, "02-04-2027", "02-07-2027");
            
            ReservationFileHandler invalidDate = new ReservationFileHandler();
            invalidDate.createReservation(r);
            
            System.out.println();
        }
        
        private static void testPastDate(){
            System.out.println("--- past date test ---");
            Customer customer = new Customer("Bob Belcher", " C003", " Gold");
            Vehicles car = new HondaCivic();
            
            Reservation r = new Reservation(customer, car, "02-10-1995", "02-15-1995");
            
            ReservationFileHandler pastDate = new ReservationFileHandler();
            pastDate.createReservation(r);
            
            System.out.println();
        }
        
        private static void testCarUnavailable(){
            System.out.println("--- car unavailable test ---");
            Vehicles sameCar = new Camry();
            Customer customer2 = new Customer("Jim Brownie", "C004", "Gambling");
            
            Reservation r2 = new Reservation(customer2, sameCar, "06-30-2026", "07-03-2026");
            
            
        }
        
    
}
