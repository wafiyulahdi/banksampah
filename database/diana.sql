--menghapus database banksampah bila perlu--
drop database if exists banksampah;

-- membuat database--
create database banksampah;

--mengunakan database banksampah--
use banksampah;

--menghapus table nasabah bila perlu--
drop table if exists nasabah;

--membuat table nasabah--
create table nasabah (
-> IdNasabah int unsigned auto_increment primary key,
-> Nama char(40) not null,
-> NoTelp int(12) not null,
-> Alamat char(50) not null,
-> tglLahir date not null,
foreign key (IdSetor) references setor (IdSetor) on delete cascade,
foreign key (IdSaldo) references saldo (IdSaldo) on delete cascade,
foreign key (IdPengepul) references pengepul (IdPengepul) on delete cascade
);

--menghapus table pengepul bila perlu--
drop table if exists pengepul;

--membuat table pengepul--
create table pengepul (
-> IdPengepul int unsigned auto_increment primary key,
-> Nama char(40) not null,
-> NoTelp int(12) not null,
-> Alamat char(50) not null,
foreign key (IdSetor) references setor (IdSetor) on delete cascade,
foreign key (IdNasabah) references nasabah (IdNasabah) on delete cascade
);

--menghapus table saldo bila perlu--
drop table if exists saldo;

--membuat table setor--
create table setor (
-> IdSetor int unsigned auto_increment primary key,
-> jmlSetor int (10) not null,
-> tglSetor date not null,
foreign key (IdSaldo) references saldo (IdSaldo) on delete cascade,
foreign key (IdNasabah) references nasabah (IdNasabah) on delete cascade
);

--menghapus table saldo bila perlu--
drop table if exists saldo;

--membuat table saldo--
create table saldo (
-> IdSaldo int auto_increment primary key,
-> saldoTarik int(20) not null,
-> tglTarik date not null,
-> foreign key (IdNasabah) references nasabah (IdNasabah) on delete cascade,
-> foreign key (IdSetor) references setor (IdSetor) on delete cascade
);