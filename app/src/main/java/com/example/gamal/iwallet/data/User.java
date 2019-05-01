/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

/**
 *
 * @author Bakr
 */
public class User {
    private String name;
    private String email;
    private String password;
    private double budget;
    
    
   
    /*
        this is the sing up function to enter the new user data
    */
    public void signUp(String name, String email, String password, double budget) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.budget = budget;
    }
    
    /*
        this function return the current user's  budget.
    */
    public double getBudget (){
        return this.budget;
    }
    /*
        this function update the current user's budget.
    */
    public void updateBudget(double b) {
        this.budget = b;
    }
    
    /*
        login with the email and password.
    */
    public  boolean logIn(String email, String pass){
        return (this.email.equals(email) && this.password.equals(pass));
    }
 
}
