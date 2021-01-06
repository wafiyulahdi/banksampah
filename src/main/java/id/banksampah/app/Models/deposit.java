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
    public String IdCustomer;
    public String name;
    public int totalDeposit;
    
    public String getIdCustomer() {
        return IdCustomer; 
    }
    
    public void setIdNasabah(String IdCustomer) {
        this.IdCustomer = IdCustomer; 
    }
    
    public String getName() {
        return name;
    }
    
    public void setNama(String name) {
        this.name = name;
    }
    
    public int getTotalDeposit() {
        return totalDeposit;
    }
    
    public void setTotalDeposit(int totalDeposit) {
        this.totalDeposit = totalDeposit;
    }
}