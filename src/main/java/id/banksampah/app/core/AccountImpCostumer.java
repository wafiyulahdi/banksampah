/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.banksampah.app.core;

import id.banksampah.app.model.Costumer;

/**
 *
 * @author M WAFIYUL AHDI
 */
public interface AccountImpCostumer {
    // fungsi interface yang diterapkan pada accountservice sehingga muncul override

    public boolean checkAccountNasabah(String email); // mengecek akun berdasarkan email

    public boolean functionInsert(Costumer nasabah);// memasukkan data pada nasabah

}
