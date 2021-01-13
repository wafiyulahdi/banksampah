/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.banksampah.app.model;

/**
 *
 * @author M WAFIYUL AHDI
 */
public class Costumer {

    private String nama;
    private String email;
    private String pass;
    //deklarasi variable dengan modifier private agar hanya dapat diakses class itu sendiri.

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    //mengambil dan mengisi data dalam model

    //To change body of generated methods, choose Tools | Templates.
}
