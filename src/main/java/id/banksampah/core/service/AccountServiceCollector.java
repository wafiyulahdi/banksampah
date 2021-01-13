/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.banksampah.app.service;

import id.banksampah.app.core.config.Service;
import id.banksampah.app.model.Collector;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import id.banksampah.app.core.AccountImpCollector;

/**
 *
 * @author M WAFIYUL AHDI
 */
public class AccountServiceCollector extends Service implements AccountImpCollector {

    @Override
    public boolean checkAccountPengepul(String email) {
        try {
            PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM pengepul WHERE email = ?"); //queery yang akan dieksekusi
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
    public boolean functionInsert(Collector pengepul) {
        String sql = "INSERT INTO `pengepul` (`nama`, `email`, `telp`, `alamat`, `password`) VALUES ('%s', '%s', '%s', '%s', '%s')";// querry yang akan dieksekusi
        sql = String.format(sql, pengepul.getNama(), pengepul.getEmail(), pengepul.getTelp(), pengepul.getAlamat(), pengepul.getPass()); // mengambil nilai dari variable

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
