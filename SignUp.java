/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sign.up;

/**
 *
 * @author M WAFIYUL AHDI
 */
import java.util.Scanner;

public class SignUp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        String emailTerdaftar = "abcd@gmail.com";
        String namaTerdaftar = "wafi";
        String PWTerdaftar = "tariksis";

        Scanner q = new Scanner(System.in);
        String inputEmail = q.nextLine();
        String inputNama = q.nextLine();
        String inputPW = q.nextLine();

        if (inputEmail.equals(emailTerdaftar)) {
            System.out.println("maaf, email sudah terdaftar");
        } else if (inputNama.equals(namaTerdaftar)) {
            System.out.println("maaf, nama ini sudah digunakan");
        } else if (inputPW.length() < 8) {
            System.out.println("maaf, pasword minimal 8 karakter");
        } else {
            System.out.println("selamat, anda berhasil mendaftar");
        }

    }
}
