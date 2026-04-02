
package com.cisp1020.cisp1020_project;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


/**
 *
 * @author 
 */
public class ReservationFileHandler{
    
    private static final String RESERVATION_FOLDER = "reservations/"; 
    /**
     * creates a folder to hold the reservations if one does not exist
     * @param r the reservation to create
     */
    public void createReservation(Reservation r){
        try{
            validateDate(r.getStartDate(), r.getEndDate());
            checkCarAvailablity(String.valueOf(r.getCar().getID()));
            
            File folder = new File(RESERVATION_FOLDER);
            if (!folder.exists()) {
                folder.mkdir();
        }
        
    /**
     * allows user to write to a file and create the reservation.
     */
    File reservationFile = new File(RESERVATION_FOLDER + 
                                    r.getCustomer().getID() + ".txt"); 
            try (PrintWriter writer = new PrintWriter(reservationFile)) {
                writer.println(r.toString());
            }
        System.out.println("Reservation created for: " + r.getCustomer().getID());
        }
    catch (IllegalArgumentException e){
        System.out.println("Invalid date: " + e.getMessage());
    }
    catch (IllegalStateException e){
        System.out.println("Car unavailable: " + e.getMessage());
    }
    catch (FileNotFoundException e){
        System.out.println("Error creating reservation file for: " +
                            r.getCustomer().getName() + " on " +
                            r.getStartDate() + " through " + r.getEndDate());
    }
    }
    /**
     * prints and retrieves a reservation by customerID number
     * @param customerID the Id of the customer to return
     */
    public void getReservation(String customerID){
        File reservationFile = new File(RESERVATION_FOLDER + customerID + ".txt");
        try{
            try (Scanner in = new Scanner(reservationFile)) {
                System.out.println("Reservation for " + customerID);
                while (in.hasNextLine()) {
                    System.out.println(in.nextLine());
                }
                
            }
        }
        catch(FileNotFoundException e){
                System.out.println("Reservation not found for: " + customerID);
                }
    }
    /**
     * 
     * @param date the date to validate
     * @throws IllegalArgumentException if the date is invalid or in the past
     */
    private void validateDate(String startDate, String endDate) throws IllegalArgumentException{
        if(!startDate.matches("\\d{2}-\\d{2}-\\d{4}") ||
                !endDate.matches("\\d{2}-\\d{2}-\\d{4}")){
            throw new IllegalArgumentException("Invalid date format. Use MM-dd-yyyy");
        }
        DateTimeFormatter formattedDate = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        LocalDate reservationStartDate = LocalDate.parse(startDate, formattedDate);
        LocalDate reservationEndDate = LocalDate.parse(endDate, formattedDate);
        if(reservationStartDate.isBefore(LocalDate.now())){
            throw new IllegalArgumentException("Reservation date cannot be in the past."
                   + " They are not Marty McFly");
        }
        if(!reservationEndDate.isAfter(reservationStartDate)){
            throw new IllegalArgumentException("End date must be after the start date");
        }
    }
    /**
     * checks the availability of a car 
     * @param carID the unique id of the car
     * @throws IllegalStateException if car is already reserved
     */
    private void checkCarAvailablity(String carID) throws IllegalStateException{
        File folder = new File(RESERVATION_FOLDER);
        File[] reservations = folder.listFiles();
        if(reservations != null){
            for(File file : reservations){
                    try (Scanner in = new Scanner(file)) {
                        while (in.hasNextLine()) {
                            if(in.nextLine().contains(carID)){
                                throw new IllegalStateException("Car " +
                                        carID +
                                        " is already reserved");
                                
                            }
                        }
                       
                    }
                
                catch (FileNotFoundException e){
                    System.out.println("Error reading reservation file: " + 
                                        e.getMessage());
                }
            }
        }
    }
    }

    //this method can be implemented at any time
    //it will allow us to read through any file and not just reservation files
    /*public void readFile() throws FileNotFoundException{
    File inputFile = new File("example.txt");
    try{
        Scanner in = new Scanner(inputFile); 
        while (in.hasNextLine()){
            System.out.println(in.nextLine());
       } 
       in.close();
    }
    catch (FileNotFoundException e) {
        System.out.println("File not found: " + filename)
    } */
   

