/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.banksampah.app.view;

import id.banksampah.app.core.DepositImp;
import id.banksampah.app.core.WithdrawImp;
import id.banksampah.app.core.config.MySQL;
import id.banksampah.app.model.Deposit;

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
public class ViewDeposit extends JFrame implements DepositImp{
    private JLabel LabelIdCust = new JLabel("Id Customer   ");
    private JLabel LabelName = new JLabel("Name             ");
    private JLabel LabelTtlDeposit = new JLabel("Total Deposit  ");
    private JButton btnDeposit = new JButton("Deposit");
    private JButton btnBack = new JButton("Back");
    private JTextField jtfName = new JTextField(30);
    private JTextField jtfIdCust = new JTextField(6);
    private JTextField jtfTtlDeposit = new JTextField(30);
    
    protected String IdCustomer, Name;
    protected int TotalDeposit;
    Deposit Deposit;
    
    public ViewDeposit() {
        initView();
        Deposit();
        Back();
    }
    
    private void initView() {
        JFrame base2 = new JFrame();

        btnBack.setBounds(70,150,110,40); 
        btnDeposit.setBounds(210,150,110,40);         
        LabelIdCust.setBounds(50,50,100,10);
        LabelName.setBounds(50,80,100,10);
        LabelTtlDeposit.setBounds(50,110,100,10);
        jtfIdCust.setBounds(130,45,200,20);        
        jtfName.setBounds(130,75,200,20);
        jtfTtlDeposit.setBounds(130,105,200,20);
        
        base2.add(btnDeposit);
        base2.add(btnBack);
        base2.add(LabelName);
        base2.add(LabelIdCust);
        base2.add(LabelTtlDeposit);
        base2.add(jtfName);
        base2.add(jtfIdCust);
        base2.add(jtfTtlDeposit);
        
        base2.setTitle("Deposit Bank Sampah");
        base2.setSize(400,250);
        base2.setLayout(null);
        base2.setVisible(true);
        base2.setResizable(false);
        base2.setLocationRelativeTo(null);
        base2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }     

    private void Deposit() {
        btnDeposit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IdCustomer = jtfIdCust.getText().toString();
                Name = jtfName.getText().toString();
                TotalDeposit = Integer.parseInt(jtfTtlDeposit.getText());

                if (!IdCustomer.equals("") && !Name.equals("") && TotalDeposit != 0) {
                    Deposit = new Deposit();
                    Deposit.setIdCustomer(IdCustomer);
                    Deposit.setName(Name);
                    Deposit.setTotalDeposit(TotalDeposit);
                    try {
                        if (!checkDeposit(Name)) {
                            functionInsert(Deposit);
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
    public boolean checkDeposit(String IdCustomer) {
        String query = " SELECT * FROM deposit WHERE IdCustomer like ?";
        Connection connection = new MySQL().createConnection();
        try {
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, Deposit.getIdCustomer());
            preparedStmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ViewDeposit.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean functionInsert(Deposit deposit) {
        try {
            String query = " INSERT INTO `deposit`(`IdCustomer`, `Name`, `TotalDeposit`) VALUES (?,?,?)";
            Connection connection = new MySQL().createConnection();

            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, Deposit.getIdCustomer());
            preparedStmt.setString(2, Deposit.getName());
            preparedStmt.setInt(3, Deposit.getTotalDeposit());
            preparedStmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ViewDeposit.class.getName()).log(Level.SEVERE, null, ex);
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