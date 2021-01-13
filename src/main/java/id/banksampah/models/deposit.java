/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.banksampah.app.model;

/**
 *
 * @author Asus
 */
public class Deposit {
    private String IdCustomer;
    private String Name;
    private int TotalDeposit;
    
    public String getIdCustomer() {
        return IdCustomer; 
    }
    
    public void setIdCustomer(String IdCustomer) {
        this.IdCustomer = IdCustomer; 
    }
    
    public String getName() {
        return Name;
    }
    
    public void setName(String Name) {
        this.Name = Name;
    }
    
    public int getTotalDeposit() {
        return TotalDeposit;
    }
    
    public void setTotalDeposit(int TotalDeposit) {
        this.TotalDeposit = TotalDeposit;
    }
}