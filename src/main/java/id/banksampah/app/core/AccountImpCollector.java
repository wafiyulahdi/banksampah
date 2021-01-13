/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.banksampah.app.core;

import id.banksampah.app.model.Collector;

/**
 *
 * @author M WAFIYUL AHDI
 */
public interface AccountImpCollector {
   
    
    public boolean checkAccountPengepul(String email);

    public boolean functionInsert(Collector pengepul);
}
