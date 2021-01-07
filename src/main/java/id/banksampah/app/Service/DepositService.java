/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.banksampah.app.service;
import id.banksampah.app.core.config.Service;
import id.banksampah.app.core.DepositImp;
import id.banksampah.app.core.config.ConfigDatabase;
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
    public boolean checkDeposit(String name) {
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

    @Override
    public boolean functionInsert(Deposit deposit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }    

    private class connection {

        public connection() {
        }
    }
}
