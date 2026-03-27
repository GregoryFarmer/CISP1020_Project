/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cisp1020.cisp1020_project;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.UUID;


/**
 *
 * @author jacob
 */
public class Reservation{
    private String reservationID;
    private Customer customer;  
    private Vehicle vehicle;
    private String startDate;
    private String endDate;
    
    public Reservation(Customer customer, Vehicle vehicle, String startDate, String endDate){
        this.reservationID = UUID.randomUUID().toString();
        this.customer = customer;
        this.vehicle = vehicle;
        this.startDate = startDate;
        this.endDate = endDate;
    }
        
    public String getReservationID(){
        return reservationID;
    }
    
        public Customer getCustomer(){//shouldnt this call get name from customer?
            return customer;
        }
        
        public Vehicle getCar(){
            return vehicle;
        }
        
        public String getStartDate(){
            return startDate;
        }
        
        public String getEndDate(){
            return endDate;
        }
        public void setCustomer(Customer customer) {
        this.customer = customer;
        }
    
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        }
    
    public void setStartDate(String startDate) {
        this.startDate = startDate;
        }
    
    public void setEndDate(String endDate) {
        this.endDate = endDate;
        }
        
    
    public long calculateDAys(){
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        return ChronoUnit.DAYS.between(start, end);
    }
        @Override
        public String toString(){
            return customer.getID() + ", " + vehicle.getID() + ", " 
                    +  startDate + ", "  + endDate;
        }
        
    }
   

