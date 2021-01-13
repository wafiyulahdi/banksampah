/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.banksampah.app;

import id.banksampah.app.view.ViewSaldo;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
//import id.banksampah.app.view.SaldoViewNew;
//import id.banksampah.app.view.windowView;
/**
 *
 * @author AsusS
 */
public class saldo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ViewSaldo();
            }
        });
    }
}
