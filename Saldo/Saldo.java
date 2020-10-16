import java.util.Date;

class nasabah{
	String nama;
	String idNasabah;

	nasabah(String inputNama, String inputIdNasabah){
		nama = inputNama; 
		idNasabah = inputIdNasabah;	
	}
}

class checkSaldo{
	static int saldoAkhir;
	static int saldoAwal;
	static int saldoTotal;

	public int getSaldoAwal(){
		return this.saldoAwal;
	}

	public int getSaldoAkhir(){
		return this.saldoAkhir;
	}

	public int getSaldoTotal(){
		saldoTotal = this.saldoAwal + this.saldoAkhir;
		return this.saldoTotal;
	}
}

public class Saldo{
	public static void main (String [] args){
		int uang;

		//object class check saldo
		checkSaldo check = new checkSaldo();

		//obj untuk class nasabah
		nasabah cust1 = new nasabah(" otong", "H96219058");

		//obj untuk tanggal 
		Date date = new Date();

		//untuk fitur check saldo
		//read and write dengan menggunakan public
		check.saldoAwal = 1000; //write
		check.saldoAkhir = 150;
		System.out.println("Nama 		   :" + cust1.nama);
		System.out.println("idNasabah	   : " + cust1.idNasabah);
		System.out.println("Waktu          : " + date.toString());
		System.out.println("Saldo Awal     : " + check.saldoAwal); //read
		System.out.println("Saldo akhir    : " + check.saldoAkhir);
		System.out.println("Saldo Totalnya : " + check.getSaldoTotal());
	}
}