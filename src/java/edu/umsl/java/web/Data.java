/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.umsl.java.web;

import java.util.List;

/**
 *
 * @author Maher
 */
public class Data {
    
    private List<String> cities; 
    
    private double[] taxRate;

    public Data(List<String> cities, double[] taxRate) {
        this.cities = cities;
        this.taxRate = taxRate;
    }

    public List<String> getCities() {
        return cities;
    }

    public void setCities(List<String> cities) {
        this.cities = cities;
    }

    public double[] getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(double[] taxRate) {
        this.taxRate = taxRate;
    }
    
    
    
}
