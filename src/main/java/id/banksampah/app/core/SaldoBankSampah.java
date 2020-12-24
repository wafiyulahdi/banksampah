import java.util.*;
import java.util.Date;

class nasabah{
	protected String nama;
	protected String idNasabah;

	nasabah(String inputNama, String inputIdNasabah){
		nama = inputNama; 
		idNasabah = inputIdNasabah;	
	}
}

class saldoUtama {
	protected int uang = 10000;
}

class saldoAwal extends saldoUtama {
	protected int getAwal() {
		return uang;
	}
}

class tambahSaldo extends saldoUtama {
	protected int getTambahUang(int simpan){
		uang = uang + simpan;
		return uang;
	}
}

public class SaldoBankSampah {
	public static void main (String [] args) {

		nasabah cust1 = new nasabah("Diana", "H96219058");
		Date date = new Date();

		saldoUtama saldo1 = new saldoUtama();
		saldoAwal saldoAwal1 = new saldoAwal();
		tambahSaldo tambahSaldo1 = new tambahSaldo();
		Scanner in = new Scanner(System.in);
			while (true) {
				System.out.println("\n\nSelamat Datang di aplikasi Saldo Bank Sampah");
				System.out.println("---- Menu Aplikasi Saldo Bank Sampah ----");
				System.out.println("|			1. Saldo Utama 				|");
				System.out.println("|			2. Tambah Saldo 			|");
				System.out.println("|			3. Exit 	 				|");
				/*System.out.println("|			3. Saldo Total 				|");*/
				/*System.out.println("|			4. Ambil Saldo 				|");*/
				System.out.println("-----------------------------------------");

				System.out.print("Username 	: " + cust1.nama + " \nId Nasabah  : " + cust1.idNasabah + "\nWaktu		: " + date.toString());

				System.out.print("\nMasukkan pilihan anda : ");
				int jawab = in.nextInt();
				switch (jawab){
				case 1:
				//untuk mengambil nilai atau mereturn method uang
				int saldo = saldoAwal1.getAwal();
				System.out.println("saldo anda adalah " + saldo);			
				break;
				case 2:
				System.out.print("\nberapa uang yang ingin anda masukkan : ");
				int x = in.nextInt();
				//untuk mengambil nilai atau mereturn method simpan uang
				saldo = tambahSaldo1.getTambahUang(x);
				System.out.print("anda menyimpan uang sebesar " + saldo);	
				break;
				case 3:
				//untuk kembali ke pilihan yang pertama  
				System.exit(1);
				default:
				System.out.println("no anda tidak valid " ); 	
			}
		}
	}
}