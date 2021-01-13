/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.banksampah.app.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import id.banksampah.app.core.config.Service;
import id.banksampah.app.model.Costumer;
import id.banksampah.app.core.AccountImpCostumer;

/**
 *
 * @author M WAFIYUL AHDI
 */
public class AccountServiceCostumer extends Service implements AccountImpCostumer { // mlekukan inheritance dari service dan interface dari accountimp

    // Nasabah
    @Override
    public boolean checkAccountNasabah(String email) { // menge cek akun berdasarkan email
        try {
            PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM nasabah WHERE email = ?"); //queery yang akan dieksekusi
            stmt.setString(1, email);

            ResultSet result = stmt.executeQuery(); // eksekusi querry

            if (result.next()) { // memindahkan penunjuk objek ke baris berikutnya
                return true;
            }

            return false;
        } catch (SQLException ex) {
            Logger.getLogger(AccountServiceCostumer.class.getName()).log(Level.SEVERE, null, ex); // menginformsikan aktifitas sistem
            return false;
        }
    }

    @Override
    public boolean functionInsert(Costumer nasabah) { // fungsi untuk memasukkan data
        String sql = "INSERT INTO `nasabah` (`nama`, `email`, `password`) VALUES ('%s', '%s', '%s')";// querry yang akan dieksekusi
        sql = String.format(sql, nasabah.getNama(), nasabah.getEmail(), nasabah.getPass()); // mengambil nilai dari variable

        try {
            Statement stmt = this.connection.createStatement();
            stmt.execute(sql); // eksekusi querry
            this.connection.close(); // apabila eksekusi selesai maka koneksi ditutup 

            return true;
        } catch (Exception e) { // pesan error saat fungsi insert gagal dilakukan
            System.out.println(e);
            return false;
        }
    }

}
