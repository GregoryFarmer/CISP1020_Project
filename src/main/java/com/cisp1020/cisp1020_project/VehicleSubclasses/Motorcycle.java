package com.cisp1020.cisp1020_project.VehicleSubclasses;
import com.cisp1020.cisp1020_project.Vehicle;

/**
 *
 * @author Gregory Farmer <gregory.farmer>
 */
public class Motorcycle extends Vehicle {    
    public Motorcycle() {
        super("Motorcycle", 8000);
        this.category = "Bike";
    }
    
    @Override public double getRentalRate(int days) {
        return super.getRentalRate(days) + 50;
    }
}
