/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cisp1020.cisp1020_project;

/**
 *
 * @author jacob
 */

/**
 * The Customer class stores information for a car rental client.
 * Designed to integrate with the Reservation class.
 *  @author Ryan
 */
public class Customer {
    private String name;
    private String id;
    private String paymentType;

    /**
     * Constructs a new Customer.
     * @param name the customer's full name
     * @param id the identification number
     * @param paymentType the method of payment
     */
    public Customer(String name, String id, String paymentType) {
        this.name = name;
        this.id = id;
        this.paymentType = paymentType;
    }

    /**
     * Gets the customer's name.
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the customer ID. 
     * 
     * @return the id
     */
    public String getID() {
        return id;
    }

    /**
     * Gets the payment type on file.
     * @return the paymentType
     */
    public String getPaymentType() {
        return paymentType;
    }

    /**
     * Returns a formatted string of the customer data.
     * 
     * @return the formatted string
     */
    @Override
    public String toString() {
        return name + "," + id + "," + paymentType;
    }
}
