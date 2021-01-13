/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.banksampah.app.view;

import id.banksampah.app.core.config.MySQL;
import id.banksampah.app.model.Collector;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import id.banksampah.app.core.AccountImpCollector;

/**
 *
 * @author M WAFIYUL AHDI
 */
public class viewRegistrationCollector extends JFrame implements AccountImpCollector {

    private JLabel labelNama = new JLabel("Enter username: ");
    private JLabel labelEmail = new JLabel("Enter Email: ");
    private JLabel labelTelp = new JLabel("Enter telepon: ");
    private JLabel labelAlamat = new JLabel("Enter alamat: ");
    private JLabel labelPass = new JLabel("Enter password: ");
    private JTextField textNama = new JTextField(20);
    private JTextField textEmail = new JTextField(20);
    private JTextField textTelp = new JTextField(20);
    private JTextField textAlamat = new JTextField(20);
    private JTextField textPass = new JTextField(20);
    private JButton registrasi = new JButton("Daftar");
    private JButton nasabah = new JButton("Nasabah");

    protected String nama, email, telp, alamat, pass;
    Collector pengepul;

    public viewRegistrationCollector() {
        super("Form Registrasi");

        initView();
        regis();
        toNasabah();

    }

    private void initView() {

        JPanel newPanel = new JPanel(new GridBagLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

        constraints.gridx = 0;
        constraints.gridy = 0;
        newPanel.add(labelNama, constraints);

        constraints.gridx = 1;
        newPanel.add(textNama, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        newPanel.add(labelEmail, constraints);

        constraints.gridx = 1;
        newPanel.add(textEmail, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        newPanel.add(labelTelp, constraints);

        constraints.gridx = 1;
        newPanel.add(textTelp, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        newPanel.add(labelAlamat, constraints);

        constraints.gridx = 1;
        newPanel.add(textAlamat, constraints);

        constraints.gridx = 0;
        constraints.gridy = 4;
        newPanel.add(labelPass, constraints);

        constraints.gridx = 1;
        newPanel.add(textPass, constraints);

        constraints.gridx = 0;
        constraints.gridy = 5;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        newPanel.add(registrasi, constraints);
        
        constraints.gridx = 0;
        constraints.gridy = 5;
        constraints.gridwidth = 3;
        constraints.anchor = GridBagConstraints.EAST;
        newPanel.add(nasabah, constraints);

        newPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Registration Pengepul"));

        add(newPanel);

        pack();
        setLocationRelativeTo(null);

    }

    private void regis() {
        registrasi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nama = textNama.getText().toString();
                email = textEmail.getText().toString();
                telp = textTelp.getText().toString();
                alamat = textAlamat.getText().toString();
                pass = textPass.getText().toString();

                if (!nama.equals("") && !email.equals("") && !pass.equals("")) {
                    pengepul = new Collector();
                    pengepul.setNama(nama);
                    pengepul.setEmail(email);
                    pengepul.setTelp(telp);
                    pengepul.setAlamat(alamat);
                    pengepul.setPass(pass);
                    try {
                        if (!checkAccountPengepul(email)) {
                            functionInsert(pengepul);
                            JOptionPane.showMessageDialog(null, "Registrasi Berhasil");
                        } else {
                            JOptionPane.showMessageDialog(null, "email sudah digunakan");
                        }
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                }
            }
        }
        );
    }
    
    private void toNasabah(){
      nasabah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                viewRegistrationCostumer xx;
                xx = new viewRegistrationCostumer();
                xx.setVisible(true);
                setVisible(false);
            }

        });
    
    }

    @Override
    public boolean checkAccountPengepul(String email) {
        String query = " SELECT * FROM pengepul WHERE email = ?";
        Connection connection = new MySQL().createConnection();
        try {
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, email);
            ResultSet result = preparedStmt.executeQuery();

            if (result.next()) {
                return true;
            }

            return false;

        } catch (SQLException ex) {
            Logger.getLogger(viewRegistrationCostumer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean functionInsert(Collector pengepul) {
        try {
            String query = " INSERT INTO `pengepul`(`nama`, `email`, `telp`, `alamat`, `password`) VALUES (?,?,?,?,?)";
            Connection connection = new MySQL().createConnection();

            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, pengepul.getNama());
            preparedStmt.setString(2, pengepul.getEmail());
            preparedStmt.setString(3, pengepul.getTelp());
            preparedStmt.setString(4, pengepul.getAlamat());
            preparedStmt.setString(5, pengepul.getPass());
            preparedStmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(viewRegistrationCostumer.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

}
