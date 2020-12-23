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
public class Service {
    protected Connection connection;

    public Service() {
        this.connection = (new MySQL()).getConnection();
    }
}