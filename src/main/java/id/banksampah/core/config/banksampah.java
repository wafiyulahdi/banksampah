
package banksampah;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class banksampah {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/bank";
    static final String USER = "root";
    static final String PASS = "";
    static InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    static BufferedReader input = new BufferedReader(inputStreamReader);

    // Menyiapkan objek yang diperlukan untuk mengelola database
    static Connection conn; // deklarasi koneksi
    static Statement stmt; // eksekusi query
    static ResultSet rs; // menampilkan hasil query

    public static void main(String[] args) {

        // Melakukan koneksi ke database
        // harus dibungkus dalam blok try/catch
        try {
            // register driver yang akan dipakai
            Class.forName(JDBC_DRIVER);

            // buat koneksi ke database
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // buat objek statement
            stmt = conn.createStatement();

            // buat query ke database
            String sql = "SELECT * FROM nasabah";

            // eksekusi query dan simpan hasilnya di obj ResultSet
            rs = stmt.executeQuery(sql);

            // tampilkan hasil query
            while (rs.next()) {
                System.out.println("ID Nasabah: " + rs.getInt("id_nasabah"));
                System.out.println("Nama: " + rs.getString("nama"));
                System.out.println("Email: " + rs.getString("email"));
                System.out.println("Password: " + rs.getString("password"));
            }

            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            // register driver
            Class.forName(JDBC_DRIVER);

            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();

            while (!conn.isClosed()) {
                showMenu();
            }

            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void showMenu() {
        System.out.println("\n========= MENU UTAMA =========");
        System.out.println("1. Insert Data");
        System.out.println("2. Show Data");
        System.out.println("3. Edit Data");
        System.out.println("4. Cari Data");
        System.out.println("5. Delete Data");
        System.out.println("0. Keluar");
        System.out.println("");
        System.out.print("PILIHAN> ");

        try {
            int pilihan = Integer.parseInt(input.readLine());

            switch (pilihan) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    insertNasabah();
                    break;
                case 2:
                    showData();
                    break;
                case 3:
                    updateNasabah();
                    break;
                case 4:
                    cariNasabah();
                    break;
                case 5:
                    deleteNasabah();
                    break;
                default:
                    System.out.println("Pilihan salah!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void showData() {
        String sql = "SELECT n.*,s.jumlah_saldo FROM nasabah n join saldo s on n.id_nasabah = s.id_nasabah";
        try {
            rs = stmt.executeQuery(sql);

            System.out.println("+----------------------------------------+");
            System.out.println("|    DATA SALDO NASABAH DI BANK SAMPAH   |");
            System.out.println("+----------------------------------------+");
            while (rs.next()) {
                int idnasabah = rs.getInt("id_nasabah");
                String nama = rs.getString("nama");
                String email = rs.getString("email");
                String password = rs.getString("password");
                int saldo = rs.getInt("jumlah_saldo");

                System.out.println(String.format("%d. %s -- (%s) -- %d", idnasabah, nama, email, saldo));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void insertNasabah() {
        try {
            // ambil input dari user
            System.out.print("Nama: ");
            String nama = input.readLine().trim();
            System.out.print("Email: ");
            String email = input.readLine().trim();
            System.out.print("Password: ");
            String password = input.readLine().trim();

            // query simpan
            String sql = "INSERT INTO nasabah (nama,email,password) VALUE('%s', '%s', '%s')";
            sql = String.format(sql, nama, email, password);

            // simpan buku
            stmt.execute(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void updateNasabah() {
        try {
            // ambil input dari user
            System.out.print("ID yang mau diedit: ");
            int idNasabah = Integer.parseInt(input.readLine());
            System.out.print("Nama: ");
            String nama = input.readLine().trim();
            System.out.print("Email: ");
            String email = input.readLine().trim();
            System.out.print("Password: ");
            String password = input.readLine().trim();

            // query update
            String sql = "UPDATE nasabah SET nama='%s', email='%s' , password='%s' WHERE id_nasabah=%d";
            sql = String.format(sql, nama, email, password, idNasabah);

            // update data buku
            stmt.execute(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void cariNasabah() {
        try {

            // ambil input dari user
            System.out.print("Nama nasabah yang mau dicari: ");
            String nama = input.readLine().trim();

            // buat query hapus
            String sql = String.format("select * from nasabah where nama = '%s'", nama);
            // hapus data
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String name = rs.getString("nama");
                String email = rs.getString("email");
                String password = rs.getString("password");

                System.out.println(String.format("%s -- (%s)", name, email));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void deleteNasabah() {
        try {

            // ambil input dari user
            System.out.print("ID yang mau dihapus: ");
            int idNasabah = Integer.parseInt(input.readLine());

            // buat query hapus
            String sql = String.format("DELETE FROM nasabah WHERE id_nasabah=%d", idNasabah);
            // hapus data
            stmt.execute(sql);

            System.out.println("Data telah terhapus...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
