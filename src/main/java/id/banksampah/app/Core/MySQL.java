/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.banksampah.app.core;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
/**
 *
 * @author Asus
 */
public class MySQL extends ConfigurationDatabase {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    
    static Connection conn; // deklarasi koneksi
    static Statement stmt; // eksekusi query
    static ResultSet rs; // menampilkan hasil query
    
    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public boolean status = false;
    public String errorMessage = null;

    public MySQL() {
        this.createConnection();
    }

    protected void createConnection() {
        try {
            // register driver yang akan dipakai
            Class.forName(JDBC_DRIVER);
            this.connection = DriverManager.getConnection(this.getJdbcDatabaseUrl());
            this.status = true;
        } catch (Exception e) {
            this.status = false;
            this.errorMessage = e.getMessage();
            System.out.println(e);
        }
    }

    public void close() {
        try {
            this.connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}