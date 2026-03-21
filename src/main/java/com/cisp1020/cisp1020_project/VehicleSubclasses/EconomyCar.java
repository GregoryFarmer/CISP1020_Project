package com.cisp1020.cisp1020_project.VehicleSubclasses;
import com.cisp1020.cisp1020_project.Vehicle;

/**
 *
 * @author Gregory Farmer <gregory.farmer>
 */
public class EconomyCar extends Vehicle {    
    public EconomyCar() {
        super("Economy", 25000);
        this.category = "Car";
    }
    
    @Override public double getRentalRate(int days) {
        return super.getRentalRate(days) + 100;
    }
}
