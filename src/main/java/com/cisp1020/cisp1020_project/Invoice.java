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
 *
 * @author zemet
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
    
 
    // constuctor
    public Invoice(String invoiceId, Reservation reservation) {
        this.invoiceId = invoiceId;
        this.reservation = reservation;
        this.issueDate = LocalDateTime.now();
        this.totalAmount = reservation.getTotalPrice();
        this.paid = false;
        this.extras = new HashMap<>(); 
    }
    
   
    // getters
    public String getInvoiceId() { return invoiceId; }
    public Reservation getReservation() { return reservation; }
    public LocalDateTime getIssueDate() { return issueDate; }
    public double getTotalAmount() { return totalAmount; }
    public boolean isPaid() { return paid; }
    
  
    // setters
    public void setPaid(boolean paid) { this.paid = paid; }
    
   
    public void setExtra(String key, Object value) {
        extras.put(key, value);
    }
    
  // any extra stored info
    public Object getExtra(String key) {
        return extras.get(key);
    }
    
  
    
  // to mark if it was paid and how
    public void markAsPaid(String paymentMethod) {
        this.paid = true;
        setExtra("paymentMethod", paymentMethod);
        setExtra("paymentDate", LocalDateTime.now());
    }
    
  // the option to add extra charges as an extra
    public void addCharge(String description, double amount) {
        totalAmount += amount;
        setExtra(description, amount);
    }
    
 //to apply a discount
    public void applyDiscount(double amount) {
        totalAmount -= amount;
        setExtra("discount", amount);
    }
    
    public double calculateTotal(){
        return reservation.getCar().getRentalRate((int) reservation.calculateDAys());
    }
    
  
    
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
    
    // saving to a file
    public String toFileString() {
        return invoiceId + "," + 
               reservation.getReservationId() + "," +
               totalAmount + "," +
               paid;
    }
}
