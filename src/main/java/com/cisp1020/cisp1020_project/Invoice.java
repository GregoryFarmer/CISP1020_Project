/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cisp1020.cisp1020_project;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

/**
 * Customer-Invoice handling.
 * @author Zemetrik Ellison
 */
public class Invoice implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
   // Basic varbs
    private String invoiceId;
    private Reservation reservation;
    private LocalDateTime issueDate;
    private double totalAmount;
    private boolean paid;
    
  // If you need to add extra varbs
    private Map<String, Object> extras;
    
 
    /**
     * An overloaded constructor that creates an invoice based on 
     * invoidId and reservation parameters.
     * @param invoiceId The id of the invoice.
     * @param reservation The reservation of the invoice.
     */
    public Invoice(String invoiceId, Reservation reservation) {
        this.invoiceId = invoiceId;
        this.reservation = reservation;
        this.issueDate = LocalDateTime.now();
        this.totalAmount = calculateTotal();
        this.paid = false;
        this.extras = new HashMap<>(); 
    }
    
   
    /**
     * @return The invoice's id.
     */
    public String getInvoiceId() { return invoiceId; }
    
    /**
     * @return The Reservation.
     */
    public Reservation getReservation() { return reservation; }
    
    /**
     * @return The LocalDateTime in which the invoice was issued.
     */
    public LocalDateTime getIssueDate() { return issueDate; }
    
    /**
     * @return The amount to be paid.
     */
    public double getTotalAmount() { return totalAmount; }
    
    /**
     * @return Whether the invoice has been paid.
     */
    public boolean isPaid() { return paid; }
    
  
    /**
     * Sets whether the invoice has been paid or not.
     * @param paid Whether the invoice has been paid.
     */
    public void setPaid(boolean paid) { this.paid = paid; }
    
   
    /**
     * Add (key, value) to the extras map.
     * @param key 
     * @param value 
     */
    public void setExtra(String key, Object value) {
        extras.put(key, value);
    }

    /**
     * @param key The key to retrieve
     * @return The value of (key) in the extras map.
     */
    public Object getExtra(String key) {
        return extras.get(key);
    }
    
  
    /**
     * Marks whether it was paid any how.
     * @param paymentMethod The method in which the invoice was paid.
     */
    public void markAsPaid(String paymentMethod) {
        this.paid = true;
        setExtra("paymentMethod", paymentMethod);
        setExtra("paymentDate", LocalDateTime.now());
    }
    
    /**
     * The option to add other charges as an extra.
     * @param description The description of the invoice.
     * @param amount The amount of the invoice.
     */
    public void addCharge(String description, double amount) {
        totalAmount += amount;
        setExtra(description, amount);
    }
    
    /**
     * Applies a discount.
     * @param amount The amount to be discounted.
     */
    public void applyDiscount(double amount) {
        totalAmount -= amount;
        setExtra("discount", amount);
    }
    
    /**
     * Calculates the total.
     * @return The total of the invoice.
     */
    public double calculateTotal(){
        return reservation.getCar().getRentalRate((int) reservation.calculateDays());
    }
    
  
    /**
     * @return A String representation of the invoice.
     */
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        // I did get help to make this as i did not want to use JavaFrame to do this. It helped with the visual.
        StringBuilder sb = new StringBuilder();
        sb.append("\n========================================\n");
        sb.append("              INVOICE\n");
        sb.append("========================================\n");
        sb.append("Invoice #: ").append(invoiceId).append("\n");
        sb.append("Customer:  ").append(reservation.getCustomer().getName()).append("\n");
        sb.append("Car:       ").append(reservation.getCar()).append(" ")
          .append(reservation.getCar().getModel()).append("\n");
        sb.append("Rental:    ").append(reservation.getStartDate()).append(" to ")
          .append(reservation.getEndDate()).append("\n");
        sb.append("Days:      ").append(reservation.calculateDays()).append(" days\n");
        sb.append("Date:      ").append(issueDate.format(formatter)).append("\n");
        sb.append("----------------------------------------\n");
        
        // displays any extras or discounts
        for (Map.Entry<String, Object> entry : extras.entrySet()) {
            if (entry.getValue() instanceof Double) {
                double value = (Double) entry.getValue();
                if (value > 0) {
                    sb.append(String.format("%-10s: $%.2f\n", entry.getKey(), value));
                }
            }
        }
        
        sb.append("----------------------------------------\n");
        sb.append(String.format("TOTAL:      $%.2f\n", totalAmount));
        sb.append("----------------------------------------\n");
        sb.append("Status:     ").append(paid ? "PAID" : "UNPAID");
        
        if (paid && extras.containsKey("paymentMethod")) {
            sb.append(" (").append(extras.get("paymentMethod")).append(")");
        }
        sb.append("\n========================================\n");
        
        return sb.toString();
    }
    
    /**
     * @return A String representation for filesaving.
     */
    public String toFileString() {
        return invoiceId + "," + 
               reservation.getReservationId() + "," +
               totalAmount + "," +
               paid;
    }
}
