package com.cisp1020.cisp1020_project.VehicleSubclasses;
import com.cisp1020.cisp1020_project.Vehicle;

/**
 *
 * @author Gregory Farmer <gregory.farmer>
 */
public class Motorcycle extends Vehicle {
    private final String category = "Bike";
    
    public Motorcycle() {
        super("Motorcycle", 8000);
    }
    
    @Override public double getRentalRate(int days) {
        return ((this.price * (Vehicle.rentalRate / 100)) * days) + 50;
    }
    
    @Override public String getCategory() {
        return this.category;
    };
}
