import java.util.Scanner;
public class setor {
	public static void main(String[] args) {
		int scan;
		Scanner baca = new Scanner (System.in);
while (true){
		System.out.println ("masukkan jenis sampah yang akan di setor");
		System.out.println ("1. botol");
		System.out.println ("2. kertas");
		System.out.println ("3. kaleng");
		System.out.println ("4. keluar");
		System.out.println (" masukkan pilihan anda ");
		scan=baca.nextInt();
		switch (scan) {
			case 1 :
			System.out.println ("------------------------------------------------");
			System.out.println ("harga sampah botol per kilo adalah 5000");
			System.out.println ("masukkan jumlah sampah (dalam satuan kilogram) ");
			int botol;
			botol=baca.nextInt();
			int jbotol=botol*5000;
			System.out.println ("------------------------------------------------");
			System.out.println ("total uang yang didapat "+ jbotol);
			System.out.println ("------------------------------------------------");
			break ;

			case 2 :
			System.out.println ("------------------------------------------------");
			System.out.println ("harga sampah kertas per kilo adalah 8000");
			System.out.println ("masukkan jumlah sampah (dalam satuan kilogram) ");
			int kertas;
			kertas=baca.nextInt();
			int jkertas=kertas*8000;
			System.out.println ("------------------------------------------------");
			System.out.println ("jumlah uang yang didapat "+jkertas);
			System.out.println ("------------------------------------------------");
			break ;

			case 3 :
			System.out.println ("------------------------------------------------");
			System.out.println ("harga sampah kaleng per kilo adalah 10000");
			System.out.println ("masukkan jumlah sampah (dalam satuan kilogram) ");
			int kaleng;
			kaleng=baca.nextInt();
			int jkaleng=kaleng*10000;
			System.out.println ("------------------------------------------------");
			System.out.println ("jumlah uang yang didapat "+jkaleng);
			System.out.println ("------------------------------------------------");

			case 4 :
			System.exit(0);
			break ;
			}
		}
	}
}