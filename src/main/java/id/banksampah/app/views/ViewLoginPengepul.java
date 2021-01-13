/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.banksampah.app.view;

import id.banksampah.app.model.Loginpengepul;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.*;

/*
  *
  *
 */

public class ViewLoginPengepul extends JFrame {

    private JLabel labelEmail = new JLabel("Email: ");
    private JLabel labelPass = new JLabel("Password: ");
    private JTextField textEmail = new JTextField(20);
    private JTextField textPass = new JTextField(20);
    private JButton login = new JButton("login");
    private JButton pengepul = new JButton("Pengepul");

    protected String email, pass;
    Loginpengepul loginpengepul;

    // membuat fungsi 
    public ViewLoginPengepul() {
        super("Form Login Pengepul");
        // instansiasi jpanel menggunakan gridbaglayout untuk memudahkan tata letak komponen
        initView();
        login();

    }

    private void initView() {
        JPanel newPanel = new JPanel(new GridBagLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

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
        newPanel.add(login, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.EAST;
        newPanel.add(pengepul, constraints);

        // membuat border dan label pada border
        newPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Login Pengepul"));
        // memasukkan komponen
        add(newPanel);
        // mengatur ukuran frame secara otomastis mengikuti isi 
        pack();
        setLocationRelativeTo(null);// mengatur lokasi frame di tengah layar

    }

    private void login() {
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                email = textEmail.getText().toString();
                pass = textPass.getText().toString();

                if (!email.equals("") && !pass.equals(""));
                loginpengepul.setEmail(email);
                loginpengepul.setPass(pass);
                try {
                    if (!checkAccountPenyetor(email)) {
                        functionInsert(penyetor);
                        JOptionPane.showMessageDialog(null, "Login Berhasil");
                    } else {
                        JOptionPane.showMessageDialog(null, "Login Gagal");
                    }

                    //	Untuk membatasi kesalahan user dalam melakukan login
                    count++;
                }

                if (count == 3) {
                    JOptionPane.showMessageDialog(null, "Anda sudah gagal Login sebanyak 3 kali. Harap coba lagi nanti . . .");
                    System.exit(1);
                }

            }
            catch (Exception exception

            
                ) {
                        exception.printStackTrace();
            }

            @Override
            public void actionPerformed(ActionEvent ae) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        }
    }
}
