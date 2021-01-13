/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.banksampah.app.core;

import id.banksampah.app.model.Withdraw;

/**
 *
 * @author Asus
 */
public interface WithdrawImp {
    public boolean checkWithdraw(String IdCustomer); // mengecek akun berdasarkan total withdraw

    public boolean functionInsert(Withdraw withdraw);// memasukkan data    
}
