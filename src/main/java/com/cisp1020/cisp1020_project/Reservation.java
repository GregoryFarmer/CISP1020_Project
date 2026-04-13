/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cisp1020.cisp1020_project;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.UUID;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author jacob
 */
public class Reservation {

    private String reservationId;
    private Customer customer;
    private Vehicle vehicle;
    private String startDate;
    private String endDate;

    /**
     * overloaded constructor
     *
     * @param customer
     * @param vehicle
     * @param startDate
     * @param endDate
     */
    public Reservation(Customer customer, Vehicle vehicle, String startDate, String endDate) {
        this.reservationId = UUID.randomUUID().toString();
        this.customer = customer;
        this.vehicle = vehicle;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    /**
     * get reservation method
     *
     * @return reservationID
     */
    public String getReservationId() {
        return reservationId;
    }

    /**
     * get customer method
     *
     * @return customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * get car method
     *
     * @return vehicle
     */
    public Vehicle getCar() {
        return vehicle;
    }

    /**
     * get start date method
     *
     * @return start date
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * get end date method
     *
     * @return end date
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * sets customer
     *
     * @param customer
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * sets vehicle
     *
     * @param vehicle
     */
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    /**
     * sets the start date
     *
     * @param startDate
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    /**
     * sets the end date
     *
     * @param endDate
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    /**
     * calculates the number of days the car was rented for
     *
     * @return start and end days
     */
    public long calculateDays() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        LocalDate start = LocalDate.parse(startDate, formatter);
        LocalDate end = LocalDate.parse(endDate, formatter);
        return ChronoUnit.DAYS.between(start, end);
    }

    @Override
    public String toString() {
        return customer.getID() + ", " + vehicle.getID() + ", "
                + startDate + ", " + endDate;
    }

}
