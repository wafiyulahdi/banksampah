/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.banksampah.app.service;
import id.banksampah.app.core.WithdrawImp;
import id.banksampah.app.core.config.Service;
import id.banksampah.app.model.Withdraw;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Asus
 */
public class WithdrawService extends Service implements WithdrawImp{

    @Override
    public boolean functionInsert(Withdraw withdraw) {
        String sql = "INSERT INTO `withdraw` (`IdCustomer`, `nama`, 'totalWithdraw') VALUES ('%d', '%s', '%d')";// querry yang akan dieksekusi
        sql = String.format(sql, withdraw.getIdCustomer(), withdraw.getName(), withdraw.getTotalWithdraw()); // mengambil nilai dari variable

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

    @Override
    public boolean checkWithdraw(String name) {
        try {
            PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM nasabah WHERE name = ?"); //queery yang akan dieksekusi
            stmt.setString(1, name); 

            ResultSet result = stmt.executeQuery(); // eksekusi querry

            if (result.next()) { // memindahkan penunjuk objek ke baris berikutnya
                return true;
            }

            return false;
        } catch (SQLException ex) {
            Logger.getLogger(DepositService.class.getName()).log(Level.SEVERE, null, ex); // menginformsikan aktifitas sistem
            return false;
        }
    }
    
}
