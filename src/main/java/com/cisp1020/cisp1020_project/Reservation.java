/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cisp1020.cisp1020_project;



/**
 *
 * @author jacob
 */
public class Reservation{
    private Customer customer;  
    private Vehicles vehicle;// maybe change to vechile
    private String startDate;
    private String endDate;
    
    public Reservation(Customer customer, Vehicles vehicle, String startDate, String endDate){
        this.customer = customer;
        this.vehicle = vehicle;
        this.startDate = startDate;
        this.endDate = endDate;
    }
        
        public Customer getCustomer(){//shouldnt this call get name from customer?
            return customer;
        }
        
        public Vehicles getCar(){
            return vehicle;
        }
        
        public String getStartDate(){
            return startDate;
        }
        
        public String getEndDate(){
            return endDate;
        }
        
        @Override
        public String toString(){
            return customer.getID() + ", " + vehicle.getID() + ", " 
                    +  startDate + ", "  + endDate;
        }
        
    }
   

