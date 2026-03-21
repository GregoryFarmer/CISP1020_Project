package com.cisp1020.cisp1020_project;

import java.util.*; import java.io.*; import java.lang.*;
import java.util.function.Predicate;

/**
 * The Vehicle superclass responsible for creating new vehicles.
 * @author Gregory Farmer <gregory.farmer>
 */
public class Vehicle {
    public static ArrayList<Vehicle> vehicles = new ArrayList();
    
    // These variables must be passed as arguments when calling new Vehicle() (unless if you're testing).
    public String model = "Undefined"; 
    public double price; 
 
    public String category = "Unknown";
    public static final double rentalRate = 1.5;
    
    // These variables will be automatically set when constructing vehicles!
    public int id; // The order in which the vehicle was created
    public String licensePlate;
    public boolean isAvailable; // Whether or not the vehicle is available (use setAvailable() in handling reservations)
    
    /**
     * Generates a String for license plates! 
     * @return A formatted string in the form of a license plate (XXX-XXXX).
     */
    public static String generateLicense() {
        String[] randomChars = {
            "A","B","C","D","E","F",
            "G","H","I","J","K","L",
            "M","N","O","P","Q","R",
            "S","T","U","V","W","X",
            "Y","Z","1","2","3","4",
            "5","6","7","8","9","0",
        };
        String firstHalf = ""; String secondHalf = "";
        for (int i = 0; i < 3; i++) {  
            int index = (int)(Math.random() * randomChars.length);
            firstHalf += randomChars[index];
        }
        for (int i = 0; i < 4; i++) {
            int index = (int)(Math.random() * randomChars.length);
            secondHalf += randomChars[index];
        }

        return String.format("%s-%s", firstHalf, secondHalf);
    }
    
    /**
     * Searches all constructed vehicles for a specific predicate.
     * @param Predicate filter 
     * {@snippet
     *  Vehicle v1 = new Vehicle()
  Vehicle.search(v -> v.getID() == 0);
 }
     * @return ArrayList<Vehicle> An ArrayList containing *only* the vehicles with the parameters.
     */
    public static ArrayList<Vehicle> search(Predicate<Vehicle> filter) {
        ArrayList<Vehicle> result = new ArrayList<>();
        for (Vehicle v : vehicles) {
            if(filter.test(v)) {
                result.add(v);
            }
        };
        return result;
    }
    
    /**
     * Sorts the constructed vehicles by price.
     * @return ArrayList<Vehicle> An ArrayList containing vehicles sorted by price.
     */
    public static ArrayList<Vehicle> sortByPrice() {
        vehicles.sort(Comparator.comparingDouble(Vehicle::getPrice));
        return vehicles;
    }
    
    /**
     * Constructs a new vehicle with given model, category, and price and adds it to the vehicle ArrayList.
     * @param String model The model of the vehicle. (e.g. Honda Civic)
     * @param double price The price of the vehicle.
     */
    public Vehicle(String model, double price) {
        this.id = vehicles.size();
        this.licensePlate = generateLicense();
        this.model = model; this.price = price;
        this.isAvailable = true;
        vehicles.add(this);
    }
    
    /**
     * For testing purposes - so you don't have to pass parameters every time!
     */
    public Vehicle() {
        this.id = vehicles.size();
        this.licensePlate = generateLicense();
        this.isAvailable = true;
        vehicles.add(this);
    }
    
    /** 
     * @return The order in which the vehicle was constructed.
     */
    public int getID() {
        return this.id;
    }
    
    /**
     * @return The vehicle's license plate.
     */
    public String getLicensePlate() {
        return this.licensePlate;
    }
    
    /**
     * @return The model of the vehicle.
     */
    public String getModel() {
        return this.model;
    }

    /**
     * @return The vehicle's price.
     */
    public double getPrice() {
        return this.price;
    }
    
    /**
     * @return The vehicle's category.
     */
    public String getCategory() {
        return this.category;
    }
    
    /**
     * Sets the vehicle's price.
     * @param price The new price of the vehicle.
     */
    public void setPrice(double price) {
        this.price = price;
    }
    
    /**
     * Sets the vehicle's model.
     * @param model The new model of the vehicle.
     */
    public void setModel(String model) {
        this.model = model;
    }
    
    /**
     * Sets whether the vehicle is available or not.
     * @param isAvailable Whether the vehicle is available.
     */
    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
    
    
    /**
     * Calculates 
     * @param days The number of days the vehicle is being rented.
     * @return The price of renting the car for x days.
     */
    public double getRentalRate(int days) {
        return ((this.price * (Vehicle.rentalRate / 100)) * days);
    }
    
    /**
     * @return A String representation of the vehicle
     */
    @Override public String toString() {
        return String.format("%s, %s, %s, %s", this.model, this.licensePlate, this.id, this.price);
    }
}
