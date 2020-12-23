/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.banksampah.app.view;
import javax.swing.*;  

public class saldoView {  
JFrame f;  
public saldoView(){  
f = new JFrame();
//membuat object dari Jframe dengan nama f  
          
JButton b = new JButton("Withdraw");
//membuat object Jbutton dengan nama withdraw

b.setBounds(60,150,150, 240);  
//untuk menyetting luas tampilan (view) pada button
          
JButton c = new JButton("Deposit");
//membuat object Jbutton dengan nama Deposit

c.setBounds(280,150,150, 240);  
//untuk menyetting luas tampilan (view) pada button
//kiri, atas, bawah, kanan

f.add(c);
//menambahkan button atau tombol pada Jframe  

f.add(b);
//menambahkan button atau tombol pada Jframe  
          
f.setTitle("Saldo Bank Sampah");
//untuk memberikan nama pada htampilan Jframe

f.setSize(500,500);
//menyetting ukuran frame (lebar 400 dan panjang 500) 

f.setLayout(null);
//untuk menentukan layout frame  

f.setVisible(true);
//untuk mengaktifkan / menampakkan visible frame 

f.setResizable(false);
//untuk menonaktifkan button maximize pada frame

f.setLocationRelativeTo(null);
// untuk membuat letak fram berada ditengah ketika program dijalankan

f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//untuk mengatur operasi default yang akan terjadi ketika user menutup frame

JLabel label = new JLabel("Selamat Datang Di Saldo Bank Sampah");
//untuk membuat objek JLabel

f.add(label);
//untuk memasukkan label ke dalam frame

label.setBounds(130, 50, 300, 30);
//untuk menentukan posisi label di dalam frame
//20 = posisi X, 20 = posisi Y, 150 = widht, 30 = height


    }  
}  