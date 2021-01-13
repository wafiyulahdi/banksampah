-- menghapus database bank sampah bila ada
drop database if exists banksampah;

-- membuat database banksampah
create database banksampah;

-- menggunakan database banksampah
use banksampah;

-- menghapus tabel nasabah bila ada
drop table if exists nasabah;

-- membuat tabel nasabah
create table nasabah(
     id_nasabah int(6) collate utf8mb4_general_ci not null primary key,
     nama varchar (50) collate utf8mb4_general_ci not null,
     email varchar (50) collate utf8mb4_general_ci not null unique,
     password varchar (50) collate utf8mb4_general_ci not null,
     index (email)
     ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- menghapus tabel pengepul bila ada
drop table if exists pengepul;

-- membuat tabel pengepul
create table pengepul(
     id_pengepul int(6) collate utf8mb4_general_ci not null primary key,
     nama varchar(50) collate utf8mb4_general_ci not null,
     email varchar (50) collate utf8mb4_general_ci not null unique,
     password varchar (50) collate utf8mb4_general_ci not null,
     alamat varchar(50) collate utf8mb4_general_ci not null,
     telp varchar(13) collate utf8mb4_general_ci not null,
     index (email)
     ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- menghapus tabel saldo bila ada
drop table if exists saldo;

-- membuat tabel saldo
create table saldo(
     id_saldo int(6) collate utf8mb4_general_ci not null primary key,
     jumlah_saldo int(20) collate utf8mb4_general_ci not null,
     id_nasabah int(6) collate utf8mb4_general_ci not null,
     foreign key (id_nasabah) references nasabah (id_nasabah) on delete cascade
     ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- menghapus tabel sampah bila ada
drop table if exists sampah;

-- membuat tabel sampah
create table sampah(
     id_sampah int(6) collate utf8mb4_general_ci not null primary key,
     jenis varchar(20)collate utf8mb4_general_ci not null,
     harga int(6) collate utf8mb4_general_ci not null
     ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- menghapus tabel setor bila ada
drop table if exists setor;

-- membuat tabel setor
create table setor(
     id_setor int(6) collate utf8mb4_general_ci not null primary key,
     id_sampah int(6) collate utf8mb4_general_ci not null,
     id_saldo int(6) collate utf8mb4_general_ci not null,
     tanggal date collate utf8mb4_general_ci not null,
     berat_kg int(6) collate utf8mb4_general_ci not null,
     foreign key (id_sampah) references sampah (id_sampah) on delete cascade,
     foreign key (id_saldo) references saldo (id_saldo) on delete cascade
     ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- menghapus tabel penarikan bila ada
drop table if exists penarikan;

-- membuat tabel penarikan
create table penarikan(
     id_penarikan int(6) collate utf8mb4_general_ci not null primary key,
     id_saldo int(6) collate utf8mb4_general_ci not null,
     jumlah_penarikan int(6) collate utf8mb4_general_ci not null,
     tanggal date collate utf8mb4_general_ci not null,
     foreign key (id_saldo) references saldo (id_saldo) on delete cascade
     ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


