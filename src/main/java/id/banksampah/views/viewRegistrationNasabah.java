/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.banksampah.app.view;

import id.banksampah.app.core.AccountImpNasabah;
import id.banksampah.app.model.Nasabah;
import id.banksampah.app.service.AccountServiceNasabah;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


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

    private String nama, email, pass;
    Nasabah nasabah;

    // membuat fungsi 
    public viewRegistrationNasabah() {
        super("Form Registrasi");
        // instansiasi jpanel menggunakan gridbaglayout untuk memudahkan tata letak komponen
        initView();
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
            public void actionPerformed(ActionEvent ae) {
                nama = textNama.getText().toString();
                email = textEmail.getText().toString();
                pass = textPass.getText().toString();

                if (!nama.equals("") && !email.equals("") && !pass.equals("")) {
                    nasabah = new Nasabah();
                    nasabah.setNama(nama);
                    nasabah.setEmail(email);
                    nasabah.setPass(pass);

                    try {

                        functionInsert(nasabah);
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                }
            }

        });
    }

    private void toPengepul() {
        pengepul.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                viewRegistrationPengepul xx;
                xx = new viewRegistrationPengepul();
                xx.setVisible(true);

            }

        });

    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        SwingUtilities.invokeLater(new Runnable() { //untuk menjalankan kode dan  memungkinkan Anda memodifikasi GUI dari utas lain.
            @Override
            public void run() {
                new viewRegistrationNasabah().setVisible(true);
            }
        });
    }

    @Override
    public boolean checkAccountNasabah(String email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean functionInsert(Nasabah nasabah) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
