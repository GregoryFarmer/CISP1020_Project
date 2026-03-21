package com.cisp1020.cisp1020_project;
import com.cisp1020.cisp1020_project.VehicleSubclasses.*;

/**
 *
 * @author Gregory Farmer <GregoryFarmer>, Jacob Hidinger <StronGeek>, Ryan McClure, Zemetrik Ellison
 * 
 */
public class CISP1020_Project {
    public static void main(String[] args) {
        EconomyCar v2 = new EconomyCar();
        Vehicle v3 = new SUV();
        Vehicle v4 = new Motorcycle();
                       
        System.out.println(Vehicle.sortByPrice());
    }
}
