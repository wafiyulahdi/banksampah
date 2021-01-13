/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.banksampah.app.core;

import id.banksampah.app.model.Deposit;

/**
 *
 * @author Asus
 */
public interface DepositImp {
    public boolean checkDeposit(String IdCustomer); // mengecek akun berdasarkan nama

    public boolean functionInsert(Deposit deposit);// memasukkan data     
}
