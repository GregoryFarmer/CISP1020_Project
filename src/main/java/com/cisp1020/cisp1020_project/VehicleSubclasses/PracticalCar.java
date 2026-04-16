package com.cisp1020.cisp1020_project.VehicleSubclasses;
import com.cisp1020.cisp1020_project.Vehicle;

/**
 * A subclass for creating practical cars (Honda Civic).
 * @author Gregory Farmer
 */
public class PracticalCar extends Vehicle {    
    public PracticalCar() {
        super("Practical", 30000);
        this.category = "Car"; 
    }
    
    /**
     * @param days - The number of days the vehicle is rented.
     * @return The rental rate 
     */
    @Override public double getRentalRate(int days) {
        return super.getRentalRate(days) + 150;
    }
}