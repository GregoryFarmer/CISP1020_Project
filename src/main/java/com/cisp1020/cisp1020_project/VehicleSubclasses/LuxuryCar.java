package com.cisp1020.cisp1020_project.VehicleSubclasses;
import com.cisp1020.cisp1020_project.Vehicle;

/**
 *
 * @author Gregory Farmer <gregory.farmer>
 */
public class LuxuryCar extends Vehicle {
    private final String category = "Car";
    
    public LuxuryCar() {
        super("Luxury Car", 50000);
    }
    
    @Override public double getRentalRate(int days) {
        return ((this.price * (Vehicle.rentalRate / 100)) * days) + 150;
    }
    
    @Override public String getCategory() {
        return this.category;
    };
}
