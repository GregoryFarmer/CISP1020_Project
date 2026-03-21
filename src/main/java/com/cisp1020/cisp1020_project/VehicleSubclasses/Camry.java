package com.cisp1020.cisp1020_project.VehicleSubclasses;
import com.cisp1020.cisp1020_project.Vehicle;

/**
 *
 * @author Gregory Farmer <gregory.farmer>
 */
public class Camry extends Vehicle {    
    private final String category = "Car";
    
    public Camry() {
        super("Camry", 34000);
    }
    
    @Override public double getRentalRate(int days) {
        return ((this.price * (Vehicle.rentalRate / 100)) * days) + 100;
    }
    
    @Override public String getCategory() {
        return this.category;
    };
}
