/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.banksampah.app.view;

import id.banksampah.app.model.Nasabah;
import id.banksampah.app.core.config.MySQL;
import id.banksampah.app.core.AccountImpNasabah;
import id.banksampah.app.model.Pengepul;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author M WAFIYUL AHDI
 */
public class viewRegistrationPengepul extends JFrame {

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

    public viewRegistrationPengepul() {
        super("Form Registrasi");

        initView();
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

        newPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Registration Pengepul"));

        add(newPanel);

        pack();
        setLocationRelativeTo(null);

    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new viewRegistrationPengepul().setVisible(true);
            }
        });
    }

}
