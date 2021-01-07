DROP database if exists 'bank_sampah';

CREATE database bank_sampah;

USE bank_sampah

DROP TABLE IF EXISTS penyetor;

CREATE TABLE penyetor (
id_penyetor int(10) NOT NULL PRIMARY KEY AUTO_INCREMENT,
nama varchar(50) NULL,
alamat varchar(50) NULL,
no_telp int(12) NULL,
email varchar(30) NULL,
password varchar(20) NULL,
INDEX (email)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci

DROP TABLE if EXISTS pengepul;

CREATE TABLE pengepul (
id_pengepul int(10) NOT NULL PRIMARY KEY AUTO_INCREMENT,
nama varchar(50) NULL,
alamat varchar(50) NULL,
no_telp int(12) NULL,
email varchar(30) NULL,
password varchar(20) NULL,
INDEX (email)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci