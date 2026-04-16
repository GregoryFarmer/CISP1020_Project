package com.cisp1020.cisp1020_project;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.UUID;
import java.time.format.DateTimeFormatter;

/**
 * The file that creates Reservations based on Customer and Vehicle data.
 * @author Jacob Hidinger
 */
public class Reservation {
    private Customer customer;
    private Vehicle vehicle;
    private String reservationId, startDate, endDate;

    /**
     * An overloaded constructor that creates a new reservation with given parameters.
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
     * Retrieves the reservation's ID.
     * @return reservationID
     */
    public String getReservationId() {
        return reservationId;
    }

    /**
     * Retrieves the customer involved in the reservation.
     * @return The Customer involved in the reservation.
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Retrieves the vehicle.
     * @return vehicle The vehicle being reserved.
     */
    public Vehicle getCar() {
        return vehicle;
    }

    /**
     * Retrieves the reservation's start date.
     * @return The reservation's start date.
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * Retrieves the reservation's end date.
     * @return The reservation's end date.
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * Sets the reservation's customer.
     * @param customer The Customer involved in the reservation.
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * Sets the reservation's vehicle.
     * @param vehicle The vehicle for the reservation.
     */
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    /**
     * Sets the reservation's begin date.
     * @param startDate The date the vehicle's reservation will begin.
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    /**
     * Sets the reservation's end date.
     * @param endDate The date the vehicle's reservation will expire.
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    /**
     * Calculates the number of days the car was rented for.
     * @return The number of days between the start and end date.
     */
    public long calculateDays() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        LocalDate start = LocalDate.parse(startDate, formatter);
        LocalDate end = LocalDate.parse(endDate, formatter);
        return ChronoUnit.DAYS.between(start, end);
    }

    /**
     * @return A string representation of the Reservation.
     */
    @Override
    public String toString() {
        return String.format("%s, %s, %s, %s", customer.getID(), vehicle.getID(), startDate, endDate);
    }

}
