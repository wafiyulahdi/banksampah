/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.banksampah.app.core;

import id.banksampah.app.model.Loginpengepul;

/**
 *
 *
 */
public interface AccountImpPengepul {
   
    
    public boolean checkAccountPengepul(String email);

    public boolean functionInsert(Loginpengepul pengepul);
}