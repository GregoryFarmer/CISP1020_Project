package com.cisp1020.cisp1020_project;

import java.util.*; import java.io.*; import java.lang.*;
import java.util.function.Predicate;

/**
 * The Vehicles superclass responsible for creating new vehicles.
 * @author Gregory Farmer <gregory.farmer>
 */
public class Vehicles {
    public static ArrayList<Vehicles> vehicles = new ArrayList();
    
    // These variables must be passed as arguments when calling new Vehicles() (unless if you're testing).
    public String model = "Undefined"; 
    public String category = "Undefined";
    public double price; 

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
  Vehicles.search(v -> v.getID() == 0);
 }
     * @return ArrayList<Vehicle> An ArrayList containing *only* the vehicles with the parameters.
     */
    public static ArrayList<Vehicles> search(Predicate<Vehicles> filter) {
        ArrayList<Vehicles> result = new ArrayList<>();
        for (Vehicles v : vehicles) {
            if(filter.test(v)) {
                result.add(v);
            }
        };
        return result;
    }
    
    /**
     * Constructs a new vehicle with given model, category, and price and adds it to the vehicle ArrayList.
     * @param String model The model of the vehicle. (e.g. Honda Civic)
     * @param String category The category the vehicle is in (i.e. Car vs Bike)
     * @param double price The price of the vehicle.
     */
    public Vehicles(String model, String category, double price) {
        this.id = vehicles.size();
        this.licensePlate = generateLicense();
        this.model = model; this.category = category; this.price = price;
        this.isAvailable = true;
        vehicles.add(this);
    }
    
    /**
     * For testing purposes - so you don't have to pass parameters every time!
     */
    public Vehicles() {
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
     * @return The vehicle's category.
     */
    public String getCategory() {
        return this.category;
    }
    
    /**
     * @return The vehicle's price.
     */
    public double getPrice() {
        return this.price;
    }
    
    /**
     * Sets the vehicle's price.
     * @param price The new price of the vehicle.
     */
    public void setPrice(double price) {
        this.price = price;
    }
    
    /**
     * Sets the category of the vehicle.
     * @param category The new category of the vehicle.
     */
    public void setCategory(String category) {
        this.category = category;
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
     * @return A String representation of the vehicle
     */
    @Override public String toString() {
        return String.format("Model: %s\nLicense Plate:%s\nId: %s\nCategory:%s\nPrice:%s", this.model, this.licensePlate, this.id, this.category, this.price);
    }
}
