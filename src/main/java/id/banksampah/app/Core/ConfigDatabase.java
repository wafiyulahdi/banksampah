/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.banksampah.app.core;

import java.sql.Connection;

/**
 *
 * @author Asus
 */
public class ConfigDatabase {
    private String HOSTNAME = "127.0.0.1";
    private String USERNAME = "root";
    private String PASSWORD = "";
    private String DBNAME = "saldobanksampah";
    private int PORT = 3306;

    protected String getJdbcDatabaseUrl() {
        return String.format("jdbc:mysql://%s:%s@%s:%d/%s?serverTimezone=UTC", this.USERNAME, this.PASSWORD, this.HOSTNAME, this.PORT, this.DBNAME);
    }

    public Connection getConnection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
} 
