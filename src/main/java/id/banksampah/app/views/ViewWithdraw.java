/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.banksampah.app.view;
import id.banksampah.app.core.WithdrawImp;
import id.banksampah.app.core.config.MySQL;
import id.banksampah.app.model.Withdraw;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Asus
 */
public class ViewWithdraw extends JFrame implements WithdrawImp {
    private JLabel LabelIdCust = new JLabel("Id Customer        ");
    private JLabel LabelName = new JLabel("Name                  ");
    private JLabel LabelTtlWithdraw = new JLabel("Total Withdraw   ");
    private JButton btnWithdraw = new JButton("Withdraw");
    private JButton btnBack = new JButton("Back");
    private JTextField jtfName = new JTextField(30);
    private JTextField jtfIdCust = new JTextField(6);
    private JTextField jtfTtlWithdraw = new JTextField(30);
    
    protected String IdCustomer, Name;
    protected int TotalWithdraw;
    Withdraw Withdraw;
    
    public ViewWithdraw() {
        initView();
        doWithdraw();
        Back();
    }
    
    private void initView() {
        JFrame base1 = new JFrame();
        
        btnBack.setBounds(70,150,110,40);
        btnWithdraw.setBounds(210,150,110,40);    
        LabelIdCust.setBounds(50,50,100,10);
        LabelName.setBounds(50,80,100,10);
        LabelTtlWithdraw.setBounds(50,110,100,10);
        jtfIdCust.setBounds(150,45,200,20);        
        jtfName.setBounds(150,75,200,20);
        jtfTtlWithdraw.setBounds(150,105,200,20);
        
        base1.add(btnBack);        
        base1.add(btnWithdraw);
        base1.add(LabelName);
        base1.add(LabelIdCust);
        base1.add(LabelTtlWithdraw);
        base1.add(jtfName);
        base1.add(jtfIdCust);
        base1.add(jtfTtlWithdraw);
        
        base1.setTitle("Withdraw Bank Sampah");
        base1.setSize(400,250);
        base1.setLayout(null);
        base1.setVisible(true);
        base1.setResizable(false);
        base1.setLocationRelativeTo(null);
        base1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }    

    private void doWithdraw() {
        btnWithdraw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IdCustomer = jtfIdCust.getText().toString();
                Name = jtfName.getText().toString();
                TotalWithdraw = Integer.parseInt(jtfTtlWithdraw.getText());

                if (!IdCustomer.equals("") && !Name.equals("") && TotalWithdraw != 0) {
                    Withdraw = new Withdraw();
                    Withdraw.setIdCustomer(IdCustomer);
                    Withdraw.setName(Name);
                    Withdraw.setTotalWithdraw(TotalWithdraw);
                    try {
                        if (!checkWithdraw(IdCustomer)) {
                            functionInsert(Withdraw);
                            JOptionPane.showMessageDialog(null, "input is successful");
                        } else
                            JOptionPane.showMessageDialog(null, "");

                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                }
            }
        }
        );
    }

    @Override
    public boolean checkWithdraw(String IdCustomer) {
        String query = " SELECT * FROM withdraw WHERE IdCustomer like ?";
        Connection connection = new MySQL().createConnection();
        try {
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, Withdraw.getIdCustomer());
            preparedStmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ViewWithdraw.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean functionInsert(Withdraw withdraw) {
        try {
            String query = " INSERT INTO `withdraw`(`IdCustomer`, `Name`, `TotalWithdraw`) VALUES (?,?,?)";
            Connection connection = new MySQL().createConnection();

            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, Withdraw.getIdCustomer());
            preparedStmt.setString(2, Withdraw.getName());
            preparedStmt.setInt(3, Withdraw.getTotalWithdraw());
            preparedStmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ViewWithdraw.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    private void Back() {
        btnBack.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                ViewSaldo saldo;
                saldo = new ViewSaldo(); 
                saldo.setVisible(true);
                setVisible(false); 
                }
            }
        );
    }
}