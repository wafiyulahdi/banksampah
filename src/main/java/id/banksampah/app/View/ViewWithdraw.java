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
public class ViewWithdraw {
    private JLabel LabelIdCust = new JLabel("Id Customer ");
    private JLabel LabelName = new JLabel("Name :");
    private JLabel LabelTtlWithdraw = new JLabel("Total Withdraw : ");
    private JButton btnWithdraw = new JButton("Withdraw");
    private JTextField jtfName = new JTextField(30);
    private JTextField jtfIdCust = new JTextField(6);
    private JTextField jtfTtlWithdraw = new JTextField(30);
    
    public ViewWithdraw() {
        initView();
    }
    
    private void initView() {
        JFrame base1 = new JFrame();
        
        btnWithdraw.setBounds(45,130,130,90);         
        base1.add(btnWithdraw);
        base1.add(LabelName);
        base1.add(LabelIdCust);
        base1.add(LabelTtlWithdraw);
        base1.add(jtfName);
        base1.add(jtfIdCust);
        base1.add(jtfTtlWithdraw);
        
        base1.setTitle("Withdraw Bank Sampah");
        base1.setSize(400,300);
        base1.setLayout(null);
        base1.setVisible(true);
        base1.setResizable(false);
        base1.setLocationRelativeTo(null);
        base1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }    
}
