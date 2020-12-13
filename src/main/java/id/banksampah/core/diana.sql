-- menghapus database bank sampah bila ada --
drop database if exists banksampah;

-- membuat database banksampah --
create database banksampah;

-- menggunakan database banksampah --
use banksampah;

-- menghapus tabel nasabah bila ada --
drop table if exists nasabah;

-- membuat tabel nasabah --
create table nasabah (
     idNasabah int collate utf8mb4_general_ci auto_increment not null primary key,
     nama varchar (50) collate utf8mb4_general_ci not null,
     email varchar (50) collate utf8mb4_general_ci not null,
     password varchar (50) collate utf8mb4_general_ci not null,
     alamat varchar (50) collate utf8mb4_general_ci not null,
     index (email)
     ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- menghapus tabel pengepul bila ada --
drop table if exists pengepul;

-- membuat tabel pengepul -- 
create table pengepul(
     idPengepul int collate utf8mb4_general_ci auto_increment not null primary key,
     nama varchar (50) collate utf8mb4_general_ci not null,
     email varchar (50) collate utf8mb4_general_ci not null,
     password varchar (50) collate utf8mb4_general_ci not null,
     alamat varchar (50) collate utf8mb4_general_ci not null,
     index (email)
     ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- menghapus tabel saldo bila ada --
drop table if exists saldo;

-- membuat tabel saldo --
create table saldo(
     idSaldo int collate utf8mb4_general_ci auto_increment not null primary key,
     jmlSaldo int(20) collate utf8mb4_general_ci not null,
     idSetor int(6) collate utf8mb4_general_ci not null,
     idTarik int(6) collate utf8mb4_general_ci not null,
     idNasabah int(6) collate utf8mb4_general_ci not null,
     foreign key (idNasabah) references nasabah (id_nasabah) on delete cascade,
     foreign key (idTarik) references tarik (idTarik) on delete cascade,
     foreign key (idSetor) references setor (idSetor) on delete cascade
     ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- menghapus tabel setor bila ada --
drop table if exists setor;

-- membuat tabel setor --
create table setor (
     idSetor int(6) collate utf8mb4_general_ci not null primary key,
     tglSetor date collate utf8mb4_general_ci not null,
     jmlSetor int(6) collate utf8mb4_general_ci not null,
     idSaldo int(6) collate utf8mb4_general_ci not null,
     foreign key (idSaldo) references saldo (id_saldo) on delete cascade
     ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- menghapus tabel penarikan bila ada --
drop table if exists ;

-- membuat tabel penarikan --
create table tarik (
     idTarik int(6) collate utf8mb4_general_ci not null primary key,
     jmlsTarik int(6) collate utf8mb4_general_ci not null,
     tglTarik date collate utf8mb4_general_ci not null,
     idSaldo int(6) collate utf8mb4_general_ci not null,
     foreign key (idSaldo) references saldo (idSaldo) on delete cascade
     ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;