package com.cisp1020.cisp1020_project;

/**
 * The Customer class stores information for a car rental client. Designed to
 * integrate with the Reservation class.
 *
 * @author Ryan
 */
public class Customer {

    private String name;
    private String id;
    private String paymentType;

    /**
     * Constructs a new Customer.
     *
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
     *
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
     *
     * @return the paymentType
     */
    public String getPaymentType() {
        return paymentType;
    }
/*
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
/*
   /**
 * Sets the customer's name.
 * @param name the new name
 */
public void setName(String name) {
    this.name = name;
    }

/**
 * Sets the customer's ID.
 * @param id the new ID
 */
public void setId(String id) {
    this.id = id;
    }

/**
 * Sets the customer's payment type.
 * @param paymentType the new payment method
 */
public void setPaymentType(String paymentType) {
    this.paymentType = paymentType;
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
