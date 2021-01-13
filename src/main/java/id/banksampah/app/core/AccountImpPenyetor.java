/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.banksampah.app.core;

import id.banksampah.app.model.Loginpenyetor;


/**
 *
 * 
 */
public interface AccountImpPenyetor {
    // fungsi interface yang diterapkan pada accountservice sehingga muncul override

    public boolean checkAccountPenyetor(String email); // mengecek akun berdasarkan email

    public boolean functionInsert(Loginpenyetor penyetor);// memasukkan data pada penyetor
    
    
}