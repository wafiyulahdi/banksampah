/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.banksampah.app.service;
import id.banksampah.app.core.config.Service;
import id.banksampah.app.core.DepositImp;
import id.banksampah.app.core.config.ConfigurationDatabase;
import id.banksampah.app.model.Deposit;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
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
public class DepositService extends Service implements DepositImp{

    @Override
    public boolean checkDeposit(String IdCustomer) {
        try {
            PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM deposit WHERE IdCustomer = ?"); //queery yang akan dieksekusi
            stmt.setString(1, IdCustomer); 

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

    @Override
    public boolean functionInsert(Deposit deposit) {
        String sql = "INSERT INTO `deposit` (`IdCustomer`, `Name`, 'TotalDeposit') VALUES ('%s', '%s', '%d')";// querry yang akan dieksekusi
        sql = String.format(sql, deposit.getIdCustomer(), deposit.getName(), deposit.getTotalDeposit()); // mengambil nilai dari variable

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
