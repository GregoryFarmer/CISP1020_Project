package com.cisp1020.cisp1020_project;

/**
 * The Car superclass that creates a new car with a name.
 * 
 * @author Gregory Farmer <gregory.farmer>
 */
public class Car {
    private static int cars = 0;
    public int id;
    public String licensePlate;//added to be able to track cars individually
    public String name;
   
    /**
     * 
     * @param name 
     */
    public Car(String licensePlate, String name) {
        this.id = cars;
        this.licensePlate = licensePlate;
        this.name = name;
        cars++;//this change increments cars across objects, not just the local copy
    }
    
    /**
     * 
     * @return The car's name
     */
    public int getID() {
        return this.id;
    }
    
    @Override public String toString() {
        return String.format("Car name: %s\nCar id: %s", this.name, this.id);
    }
}
