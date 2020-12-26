/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.banksampah.app.core.config;

import id.banksampah.app.core.config.MySQL;
import java.sql.Connection;

/**
 *
 * @author M WAFIYUL AHDI
 */
public class Service {

    protected Connection connection; // deklarasi koneksi dengan modifier protected agar dapat diakses clas turunan

    public Service() {
        this.connection = (new MySQL()).getConnection(); // mengambil koneksi agar bisa melakukan querry
    }

}
