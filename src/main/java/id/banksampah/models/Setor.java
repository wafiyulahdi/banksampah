/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saldo.model;

/**
 *
 * @author Asus
 */
public class Setor {
    public String IdNasabah;
    public String nama;
    public int jmlSetoran;
    
    public String getIdNasabah() {
        return IdNasabah; 
    }
    
    public void setIdNasabah(String IdNasabah) {
        this.IdNasabah = IdNasabah; 
    }
    
    public String getNama() {
        return nama;
    }
    
    public void setNama(String nama) {
        this.nama = nama;
    }
    
    public int getJmlSetoran() {
        return jmlSetoran;
    }
    
    public void setJmlPenarikan(int jmlSetoran) {
        this.jmlSetoran = jmlSetoran;
    }
}
