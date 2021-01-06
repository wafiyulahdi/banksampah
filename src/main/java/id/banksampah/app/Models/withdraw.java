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
public class Withdraw {
    public String IdCustomer;
    public String name;
    public int totalWithdraw;
    
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
    
    public int getTotalWithdraw() {
        return totalWithdraw;
    }
    
    public void setJmlPenarikan(int totalWithdraw) {
        this.totalWithdraw = totalWithdraw;
    }
}