/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamap;
import java.util.Scanner;
import java.util.Date;
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
                System.out.println("\n " + nama +   " Memilih lokasi lamongan");
                    System.out.println("kecamatan solokuro, desa glugu, pengepul amir (08523523235)");
                    System.out.println("Kecamatan Pucuk,Desa pucuk ,Pengepul Budi (085738613247)");
                    System.out.println("Kecamatan Glagah,Desa Bapuh  ,Pengepul Puguh  (085738613287)");
                break;
            case 2:
                System.out.println("\n " + nama +   " Memilih lokasi Sidoarjo");
                  System.out.println("Kecamatan waru.desa bungur pengepul andi odang (0852390401339)");
                  System.out.println("Kecamatan candi,Desa Balondowo ,Pengepul Budi (085738613247)");
                  System.out.println("Kecamatan Krembung ,Desa Balanggarut ,Pengepul kusen (085738612247)");
                break;
            case 3:
                System.out.println("\n " + nama +  " Memilih lokasi Surabaya ");
                  System.out.println("Kecamatan wonocolo,Desa jemursari ,Pengepul uden (085738213247)");
                  System.out.println("Kecamatan Wonokromo,Desa siwalankerto ,Pengepul adi (085738613247)");
                  System.out.println("Kecamatan Benowo,Desa GBI ,Pengepul suker (085733613247)");
                break;
            case 4:
                System.out.println("\n " + nama +  " Memilih lokasi Gresik");
                  System.out.println("Kecamatan Bungah ,Desa Kremangi ,Pengepul kiki (0857382313247)");
                  System.out.println("Kecamatan Cerme ,Desa Banjarsari,Pengepul andi(0857386133447)");
                  System.out.println("Kecamatan Duduk sampeyan ,Desa Bendungan ,Pengepul sartono (0857386234247)");
                break;
            case 5:
                System.out.println("\n" + nama +  " Memilih lokasi Bojonegoro");
                  System.out.println("Kecamatan Baureno,Desa Lebaksari ,Pengepul Hartono (082738613247)");
                  System.out.println("Kecamatan Sumberrejo,Desa talun ,Pengepul Kardi (0857386132347)");
                  System.out.println("Kecamatan Balem,Desa Sambungrejo ,Pengepul wewe (0857353890247)");
                break;
                default:
                System.out.print("\n" + nama +  "ANDA SALAH MEMASUKKAN ");
                break;
                
            }
        }
    /**x  
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      Scanner in= new Scanner(System.in);

       Date date = new Date();
       Javamap map= new Javamap();
           System.out.println("Masukkan Nama Anda : ");
           map.setNama(in.nextLine());
           
           System.out.println("Hari ini "+date.toString()+"\n pilihan:\n 1.lamongan  \n 2.Sidoarjo \n 3.Surabaya \n 4.Gresik \n 5.Bojonegoro \n\n   Masukkan Pilihan Anda: ");
           map.setPilihan(in.nextInt());
           
           map.handle();

       
    }
    
}
