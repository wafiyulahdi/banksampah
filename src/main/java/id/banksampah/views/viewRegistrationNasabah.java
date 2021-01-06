/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.banksampah.app.view;

import id.banksampah.app.core.AccountImpNasabah;
import id.banksampah.app.core.config.MySQL;
import id.banksampah.app.model.Nasabah;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author M WAFIYUL AHDI
 */
public class viewRegistrationNasabah extends JFrame implements AccountImpNasabah {

    //deklarasi komponen jlabel, jtextfield, dan jbutton
    private JLabel labelNama = new JLabel("Username: ");
    private JLabel labelEmail = new JLabel("Email: ");
    private JLabel labelPass = new JLabel("Password: ");
    private JTextField textNama = new JTextField(20);
    private JTextField textEmail = new JTextField(20);
    private JTextField textPass = new JTextField(20);
    private JButton registrasi = new JButton("Daftar");
    private JButton pengepul = new JButton("Pengepul");

    protected String nama, email, pass;
    Nasabah nasabah;

    // membuat fungsi 
    public viewRegistrationNasabah() {
        super("Form Registrasi");
        // instansiasi jpanel menggunakan gridbaglayout untuk memudahkan tata letak komponen
        initView();
        regis();
        toPengepul();

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
        newPanel.add(labelPass, constraints);

        constraints.gridx = 1;
        newPanel.add(textPass, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        newPanel.add(registrasi, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.EAST;
        newPanel.add(pengepul, constraints);

        // membuat border dan label pada border
        newPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Registration Nasabah"));
        // memasukkan komponen
        add(newPanel);
        // mengatur ukuran frame secara otomastis mengikuti isi 
        pack();
        setLocationRelativeTo(null);// mengatur lokasi frame di tengah layar

    }

    private void regis() {
        registrasi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nama = textNama.getText().toString();
                email = textEmail.getText().toString();
                pass = textPass.getText().toString();

                if (!nama.equals("") && !email.equals("") && !pass.equals("")) {
                    nasabah = new Nasabah();
                    nasabah.setNama(nama);
                    nasabah.setEmail(email);
                    nasabah.setPass(pass);
                    try {
                        if (!checkAccountNasabah(email)) {
                            functionInsert(nasabah);
                            JOptionPane.showMessageDialog(null, "Registrasi Berhasil");
                        } else
                            JOptionPane.showMessageDialog(null, "email sudah digunakan");

                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                }
            }
        }
        );
    }

    private void toPengepul() {
        pengepul.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                viewRegistrationPengepul xx;
                xx = new viewRegistrationPengepul();
                xx.setVisible(true);
                setVisible(false);
            }

        });

    }

    @Override
    public boolean checkAccountNasabah(String email) {
        String query = " SELECT * FROM nasabah WHERE email = ?";
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
            Logger.getLogger(viewRegistrationNasabah.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean functionInsert(Nasabah nasabah) {
        try {
            String query = " INSERT INTO `nasabah`(`nama`, `email`, `password`) VALUES (?,?,?)";
            Connection connection = new MySQL().createConnection();

            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, nasabah.getNama());
            preparedStmt.setString(2, nasabah.getEmail());
            preparedStmt.setString(3, nasabah.getPass());
            preparedStmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(viewRegistrationNasabah.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
