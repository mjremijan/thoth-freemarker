/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.thoth.freemarker;

/**
 *
 * @author h1mjr01
 */
public class House {
    String address;
    
    public House(String s) {
        this.address = s;
    }
    
    public String getAddress() {
        return this.address;
    }
}   
