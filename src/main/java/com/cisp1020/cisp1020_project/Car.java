/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cisp1020.cisp1020_project;

/**
 *
 * @author Gregory Farmer <gregory.farmer>
 */
public class Car {
    private static int cars = 0;
    public int id;
    public String name;
    
    public Car(String name) {
        this.id = cars;
        this.name = name;
        id++;
    }
    
    public int getID() {
        return this.id;
    }
    
    @Override public String toString() {
        return String.format("Car name: %s\nCar id: %s", this.name, this.id);
    }
}
