/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.banksampah.app.view;

import id.banksampah.app.model.Deposit;
import id.banksampah.app.model.Withdraw;
import id.banksampah.app.view.ViewDeposit;
import id.banksampah.app.view.ViewWithdraw;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;


/**
 *
 * @author Asus
 */
public class ViewSaldo extends JFrame {
    private JLabel LabelCome = new JLabel("Welcome in Saldo Bank Sampah ");
    private JButton btnWithdraw = new JButton("Withdraw");
    private JButton btnDeposit = new JButton("Deposit");

    public ViewSaldo() {
        initView();
        doDeposit();
        doWithdraw();
    }
    
    private void initView() {
        JFrame base = new JFrame();   
        LabelCome.setBounds(130, 40, 300, 30);
        btnWithdraw.setBounds(45,100,130,90); 
        btnDeposit.setBounds(220,100,130,90); 
        
        base.add(btnWithdraw);
        base.add(btnDeposit);
        base.add(LabelCome);
        
        base.setTitle("Saldo Bank Sampah");
        base.setSize(400,250);
        base.setLayout(null);
        base.setVisible(true);
        base.setResizable(false);
        base.setLocationRelativeTo(null);
        base.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void doDeposit() {
        btnDeposit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                ViewDeposit deposit;
                deposit = new ViewDeposit(); 
                deposit.setVisible(true);
                setVisible(false); 
                }
            }
        );
    }

    private void doWithdraw() {
        btnWithdraw.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                ViewWithdraw xx;
                xx = new ViewWithdraw(); 
                xx.setVisible(true);
                setVisible(false);
                }
            }
        );
    }    
}