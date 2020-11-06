/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamap;
import java.util.Scanner;

/**
 *
 * @author nuriv
 */
public class Javamap {
        private String nama;
        private int pilihan;
        
        public Javamap(){
        }
        public void setNama(String nama ){
            this.nama=nama;
        }
        public void setPilihan(int pilihan){
            this.pilihan=pilihan;
           
        }
        public void handle(){
            switch (pilihan){
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
                default:
                System.out.print("\n" + nama + "ANDA SALAH MEMASUKKAN ");
                break;
                

            }
        }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      Scanner in= new Scanner(System.in);
       
       Javamap map= new Javamap();
           System.out.println("Masukkan Nama Anda : ");
           map.setNama(in.nextLine());
           
           System.out.println("pilihan:\n 1.lamongan  \n 2.Sidoarjo \n 3.Surabaya \n 4.Gresik \n 5.Bojonegoro \n\n   Masukkan Pilihan Anda: ");
           map.setPilihan(in.nextInt());
           
           map.handle();

       
    }
    
}
