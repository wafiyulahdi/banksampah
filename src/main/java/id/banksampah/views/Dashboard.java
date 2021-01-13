/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.banksampah.app.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author M WAFIYUL AHDI
 */
public class Dashboard extends JFrame {

    private JButton setor = new JButton("Setor");
    private JButton saldo = new JButton("Saldo");
    private JButton chat = new JButton("Chat");

    public Dashboard() {
        super("Dashboard");

        initView();
        toChat();
        toSaldo();
        
    }

    private void initView() {
        JPanel newPanel = new JPanel(new GridBagLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.CENTER;
        newPanel.add(setor, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        newPanel.add(saldo, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 3;
        constraints.anchor = GridBagConstraints.CENTER;
        newPanel.add(chat, constraints);

        newPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Dashboard"));

        add(newPanel);

        pack();
        setLocationRelativeTo(null);

    }
    
    private void toChat(){
    chat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                JOptionPane.showMessageDialog(null, "Mohon maaf, fitur ini belum tersedia !");
            }

        });
    
    }
    
    private void toSaldo(){
    saldo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ViewSaldo xx;
                xx = new ViewSaldo();
                xx.setVisible(true);
                setVisible(false);
            }

        });
    
    }

    public static void main(String[] args) {
        // TODO code application logic here

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        SwingUtilities.invokeLater(new Runnable() { //untuk menjalankan kode dan  memungkinkan Anda memodifikasi GUI dari utas lain.
            @Override
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }
}
