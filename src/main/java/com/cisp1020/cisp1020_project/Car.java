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
    public static int cars = 0;
    private int id;
    
    public Car() {
        this.id = cars;
        id++;
    }
    
    public int getID() {
        return this.id;
    }
}
