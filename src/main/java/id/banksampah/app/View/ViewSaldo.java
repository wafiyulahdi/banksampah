/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.banksampah.app.view;

import id.banksampah.app.view.ViewDeposit;
import id.banksampah.app.view.ViewWithdraw;
import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;


/**
 *
 * @author Asus
 */
public class ViewSaldo {
    private JLabel LabelCome = new JLabel("Welcome in Saldo Bank Sampah ");
    private JLabel LabelIdCust = new JLabel("Id Customer ");
    private JLabel LabelName = new JLabel("Name :");
    private JLabel LabelTtlWithdraw = new JLabel("Total Withdraw : ");
    private JLabel LabelTtlDeposit = new JLabel("Total Deposit : ");
    private JButton btnWithdraw = new JButton("Withdraw");
    private JButton btnDeposit = new JButton("Deposit");
    private JTextField jtfName = new JTextField(30);
    private JTextField jtfIdCust = new JTextField(6);
    private JTextField jtfTtlWithdraw = new JTextField(30);
    private JTextField jtfTtlDeposit = new JTextField(30);
    
    public ViewSaldo() {
        initView();
    }
    
    private void initView() {
        JFrame base = new JFrame();
        
        btnWithdraw.setBounds(45,130,130,90); 
        btnDeposit.setBounds(220,130,130,90); 
        LabelCome.setBounds(90, 50, 300, 30);
        
        base.add(btnWithdraw);
        base.add(btnDeposit);
        base.add(LabelCome);
        
        base.setTitle("Saldo Bank Sampah");
        base.setSize(400,300);
        base.setLayout(null);
        base.setVisible(true);
        base.setResizable(false);
        base.setLocationRelativeTo(null);
        base.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    
}