/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.banksampah.app.service;
import id.banksampah.app.core.config.ConfigDatabase;
import id.banksampah.app.core.DepositImp;
import id.banksampah.app.core.WithdrawImp;
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
public class WithdrawService extends ConfigDatabase implements WithdrawImp{

    @Override
    public boolean functionInsert(Withdraw withdraw) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean checkWithdraw(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
