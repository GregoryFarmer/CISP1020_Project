package com.cisp1020.cisp1020_project.VehicleSubclasses;
import com.cisp1020.cisp1020_project.Vehicle;

/**
 * A subclass for creating specialty cars (Lamborghini).
 * @author Gregory Farmer
 */
public class SpecialtyCar extends Vehicle { 
    public SpecialtyCar() {
        super("Specialty", 20000);
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