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
		checkSaldo check = new checkSaldo();

		//read and write dengan menggunakan public
		check.saldoAwal = 1000; //write
		check.saldoAkhir = 150;
		System.out.println("saldo awal : " + check.saldoAwal); //read
		System.out.println("saldo akhir : " + check.saldoAkhir);
		System.out.println("saldo totalnya : " + check.getSaldoTotal());
	}
}