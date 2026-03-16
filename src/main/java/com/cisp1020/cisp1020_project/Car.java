package com.cisp1020.cisp1020_project;

/**
 * The Car superclass that creates a new car with a name.
 * 
 * @author Gregory Farmer <gregory.farmer>
 */
public class Car {
    private static int cars = 0;
    public int id;
    public String name;
   
    /**
     * 
     * @param name 
     */
    public Car(String name) {
        this.id = cars;
        this.name = name;
        id++;
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
