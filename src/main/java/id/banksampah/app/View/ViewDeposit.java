/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.banksampah.app.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Asus
 */
public class ViewDeposit {
    private JLabel LabelIdCust = new JLabel("Id Customer ");
    private JLabel LabelName = new JLabel("Name :");
    private JLabel LabelTtlDeposit = new JLabel("Total Deposit : ");
    private JButton btnDeposit = new JButton("Deposit");
    private JTextField jtfName = new JTextField(30);
    private JTextField jtfIdCust = new JTextField(6);
    private JTextField jtfTtlDeposit = new JTextField(30);
    
    public ViewDeposit() {
        initView();
    }
    
    private void initView() {
        JFrame base2 = new JFrame();
        
        btnDeposit.setBounds(45,130,130,90);         
        base2.add(btnDeposit);
        base2.add(LabelName);
        base2.add(LabelIdCust);
        base2.add(LabelTtlDeposit);
        base2.add(jtfName);
        base2.add(jtfIdCust);
        base2.add(jtfTtlDeposit);
        
        base2.setTitle("Deposit Bank Sampah");
        base2.setSize(400,300);
        base2.setLayout(null);
        base2.setVisible(true);
        base2.setResizable(false);
        base2.setLocationRelativeTo(null);
        base2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }     
}
