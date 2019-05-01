/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

import java.util.ArrayList;

/**
 *
 * @author user
 */
public class CategorizeHub {
    
    private  ArrayList<Categorize> allCategorize = new ArrayList<>();
    private double allPaid = 0;
    
    public ArrayList<Categorize> getAllCategorize (){
        return this.allCategorize;
    }
    
    public void addCategorize(Categorize c){
        this.allCategorize.add(c);
        this.allPaid += c.getPaid();
    }
    
    /*
        update Categorize paid by increase amount if not release the limit 
        else return false.
    */
    public boolean updateCatergorizePaid(String name, double amount){
        for (Categorize c : this.allCategorize){
            if (c.name.equals(name)){
                if (c.increasePaid(amount)){
                    this.allPaid += amount;
                    return true; 
                }
                else 
                    return false;
            }
        }
        return false;
    }
}
