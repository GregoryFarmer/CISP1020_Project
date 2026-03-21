package com.cisp1020.cisp1020_project;

import java.util.*;
import java.io.*;
import java.util.function.Predicate;

/**
 * The Vehicle superclass that creates a new car with a name.
 * @author Gregory Farmer <gregory.farmer>
 */
public class Vehicle {
    public static ArrayList<Vehicle> vehicles = new ArrayList();
    
    public int id;
    public String model;
    public String licensePlate;
    public boolean isAvailable;
    
    /**
     * A static method for searching all constructed cars for a specific variable.
     * @param Predicate filter 
     * {@snippet
     *  Vehicle v1 = new Vehicle()
     *  Vehicle.search(v -> v.getID().equals(1));
     * }
     * @return ArrayList<Vehicle> - An ArrayList containing *only* the vehicles with the parameters.
     */
    public static ArrayList<Vehicle> search(Predicate filter) {
        ArrayList<Vehicle> result = new ArrayList<>();
        for (Vehicle v : vehicles) {
            if(filter.test(v)) {
                result.add(v);
            }
        };
        return result;
    }
    
    /**
     * Constructs a new vehicle 
     * @param String licensePlate
     * @param String model
     */
    public Vehicle(String licensePlate, String model) {
        this.id = vehicles.size();
        this.licensePlate = licensePlate;
        this.model = model;
        this.isAvailable = true;
        vehicles.add(this);
    }
    
    public Vehicle() {
        this.id = vehicles.size();
        this.licensePlate = "Undefined";
        this.model = "Undefined";
        this.isAvailable = true;
        vehicles.add(this);
    }
    
    /**
     * Retrieves 
     * @return The car's name
     */
    public int getID() {
        return this.id;
    }
    
    @Override public String toString() {
        return String.format("Car model: %s\nCar id: %s", this.model, this.id);
    }
}
