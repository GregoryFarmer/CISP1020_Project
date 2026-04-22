package com.cisp1020.cisp1020_project;

import java.util.*; 
import java.io.*; 
import java.lang.*;
import java.util.function.Predicate;

/**
 * The Vehicle superclass responsible for creating new vehicles.
 * @author Gregory Farmer
 */
public class Vehicle {
    private static Map<String, ArrayList<Vehicle>> vehicles = new TreeMap<>();

    // These variables must be passed as arguments when calling new Vehicle() (unless if you're testing).
    private String model = "Undefined"; 
    protected String category = "Unknown";

    private double price; 
    private double rentalRate = 1.5;
    
    // These variables will be automatically set when constructing vehicles!
    private String id; // The order in which the vehicle was created
    private String licensePlate;
    public boolean isAvailable; // Whether or not the vehicle is available (use setAvailable() in handling reservations)
    
        /**
     * Adds a vehicle to the necessary ArrayList in the vehicles TreeMap.
     * @param vehicle The vehicle to add to the ArrayList.
     */
    public static void addVehicle(Vehicle vehicle) {
        vehicles.putIfAbsent(vehicle.getModel(), new ArrayList<>());
        vehicles.get(vehicle.getModel()).add(vehicle);
    }

    /**
     * Retrieves the respective ArrayList from the TreeMap.
     * @param model The model to retrieve.
     * @return The ArrayList of vehicles for the model.
     */
    public static ArrayList<Vehicle> getVehiclesByModel(String model) {
        return vehicles.getOrDefault(model, new ArrayList<>());
    }

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
     * @param filter 
     * @return An ArrayList containing *only* the vehicles with the parameters.
     */
    public static ArrayList<Vehicle> search(Predicate<Vehicle> filter) {
        ArrayList<Vehicle> result = new ArrayList<>();
        for (ArrayList<Vehicle> list : vehicles.values()) {
            for (Vehicle v : list) {
                if (filter.test(v)) {
                    result.add(v);
                }
            }
        }

        return result;
    }

    /**
     * Sorts the constructed vehicles by price.
     * @return An ArrayList containing vehicles sorted by price.
     */
    public static ArrayList<Vehicle> sortByPrice() {
        ArrayList<Vehicle> sortedVehicles = new ArrayList<>();
        for (ArrayList<Vehicle> list : vehicles.values()) {
            sortedVehicles.addAll(list);
        }

        sortedVehicles.sort(Comparator.comparingDouble(Vehicle::getPrice));
        return sortedVehicles;
    }
    
    /**
     * Constructs a new vehicle with given model, category, and price and adds it to the vehicle ArrayList.
     * @param model The model of the vehicle. (e.g. Honda Civic)
     * @param price The price of the vehicle.
     */
    public Vehicle(String model, double price) {
        this.id = String.format("%s%s", model, getVehiclesByModel(model).size());
        this.licensePlate = generateLicense();
        this.model = model; this.price = price;
        this.isAvailable = true;
        addVehicle(this);
    }
    
    /**
     * For testing purposes - so you don't have to pass parameters every time!
     */
    public Vehicle() {
        this.id = UUID.randomUUID().toString();
        this.licensePlate = generateLicense();
        this.isAvailable = true;
        addVehicle(this);
    }
    
    /** 
     * @return The order in which the vehicle was constructed.
     */
    public String getID() {
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
     * @return Whether the vehicle is available or not.
     */
    public boolean getAvailable() {
        return this.isAvailable;
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
     * Calculates the daily price if the vehicle is rented for x days.
     * @param days The number of days the vehicle is being rented.
     * @return The price of renting the car for x days.
     */
    public double getRentalRate(int days) {
        return ((this.getPrice() * (this.rentalRate / 100)) * days);
    }
    
    /**
     * @return A String representation of the vehicle
     */
    @Override public String toString() {
        return String.format("%s, %s, %s, %s", this.model, this.licensePlate, this.id, this.price);
    }
}
