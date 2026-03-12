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
    private Car car;// maybe change to vechile
    private String date;
    
    public Reservation(Customer customer, Car car, String date){
        this.customer = customer;
        this.car = car;
        this.date = date;
    }
        
        public Customer getCustomer(){//shouldnt this call get name from customer?
            return customer;
        }
        
        public Car getCar(){
            return car;
        }
        
        public String getDate(){
            return date;
        }
        
        @Override
        public String toString(){
            return customer.getID() + "," + car.getID() + "," + date;
        }
        
    }
   

