class check {
    String nama;
    String email;
    String pass;
    String emailterdaftar = "wafiyul@gmail.com";
    String namaterdaftar = "wafi";

    check(String inputnama, String inputemail, String inputpass) {
        nama = inputnama;
        email = inputemail;
        pass = inputpass;
    }
    
    public String cekdata (){
        if (email.equals(emailterdaftar)) {
         System.out.println("maaf, email sudah terdaftar");
       }else if (nama.equals(namaterdaftar)) {
         System.out.println("maaf, nama sudah terdaftar");
       }else if (pass.length() < 8) {
            System.out.println("maaf, pasword minimal 8 karakter");
        }else{
        System.out.println("Selamat "+nama+",anda berhasil mendaftar dengan email "+email+" dan password "+pass);
       }
        return nama;
        
    }
}

public class SignUp {

    
    public static void main(String[] args) {
        
        check cek = new check("izam","izam@gmail.com","izam123456");
        cek.cekdata();
    }
}
