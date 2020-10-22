/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalocation;

import java.util.Scanner;

/**
 *
 * @author nuriv
 */
public class JavaLocation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // TODO code application logic here
        String nama;
        int pilihan;
        Scanner in = new Scanner(System.in);
        System.out.println("Masukkan  nama anda  :");
        nama = in.nextLine();
        System.out.println("pilihan: \n 1.lamongan \n 2.sidoarjo \n 3.surabaya \n 4.Gresik \n 5.Bojonegoro \n\n Masukkan pilihan : ");

        pilihan = in.nextInt();
        switch (pilihan) {
            case 1:
                System.out.print("\n " + nama + "Memilih lokasi lamongan");
                break;
            case 2:
                System.out.print("\n " + nama + "Memilih lokasi Sidoarjo");
                break;
            case 3:
                System.out.print("\n " + nama + "Memilih lokasi Surabaya ");
                break;
            case 4:
                System.out.print("\n " + nama + "Memilih lokasi Gresik");
                break;
            case 5:
                System.out.print("\n" + nama + "Memilih lokasi Bojonegoro");
                break;
        }

    }

}
