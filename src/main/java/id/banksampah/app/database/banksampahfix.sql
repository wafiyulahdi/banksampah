-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 09 Des 2020 pada 15.33
-- Versi Server: 10.1.9-MariaDB
-- PHP Version: 7.0.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `banksampahfix`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `inti`
--

CREATE TABLE `inti` (
  `id_inti` int(6) NOT NULL,
  `id_penarikan` int(6) NOT NULL,
  `id_saldo` int(6) NOT NULL,
  `id_setor` int(6) NOT NULL,
  `id_sampah` int(6) NOT NULL,
  `id_nasabah` int(6) NOT NULL,
  `id_pengepul` int(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struktur dari tabel `nasabah`
--

CREATE TABLE `nasabah` (
  `id_nasabah` int(6) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `nasabah`
--

INSERT INTO `nasabah` (`id_nasabah`, `nama`, `email`, `password`) VALUES
(1, 'wafi', 'wafi.com', '1234');

-- --------------------------------------------------------

--
-- Struktur dari tabel `penarikan`
--

CREATE TABLE `penarikan` (
  `id_penarikan` int(6) NOT NULL,
  `id_saldo` int(6) NOT NULL,
  `jumlah_penarikan` int(6) NOT NULL,
  `tanggal` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struktur dari tabel `pengepul`
--

CREATE TABLE `pengepul` (
  `id_pengepul` int(6) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `telp` varchar(13) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struktur dari tabel `saldo`
--

CREATE TABLE `saldo` (
  `id_saldo` int(6) NOT NULL,
  `jumlah_saldo` int(20) NOT NULL,
  `id_nasabah` int(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struktur dari tabel `sampah`
--

CREATE TABLE `sampah` (
  `id_sampah` int(6) NOT NULL,
  `jenis` varchar(20) NOT NULL,
  `harga` int(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struktur dari tabel `setor`
--

CREATE TABLE `setor` (
  `id_setor` int(6) NOT NULL,
  `id_sampah` int(6) NOT NULL,
  `id_saldo` int(6) NOT NULL,
  `tanggal` date NOT NULL,
  `berat_kg` int(6) NOT NULL,
  `id_nasabah` int(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `inti`
--
ALTER TABLE `inti`
  ADD PRIMARY KEY (`id_inti`),
  ADD KEY `id_sampah` (`id_sampah`),
  ADD KEY `id_saldo` (`id_saldo`),
  ADD KEY `id_nasabah` (`id_nasabah`),
  ADD KEY `id_penarikan` (`id_penarikan`),
  ADD KEY `id_setor` (`id_setor`),
  ADD KEY `id_pengepul` (`id_pengepul`);

--
-- Indexes for table `nasabah`
--
ALTER TABLE `nasabah`
  ADD PRIMARY KEY (`id_nasabah`),
  ADD UNIQUE KEY `email` (`email`),
  ADD KEY `email_2` (`email`);

--
-- Indexes for table `penarikan`
--
ALTER TABLE `penarikan`
  ADD PRIMARY KEY (`id_penarikan`),
  ADD KEY `id_saldo` (`id_saldo`);

--
-- Indexes for table `pengepul`
--
ALTER TABLE `pengepul`
  ADD PRIMARY KEY (`id_pengepul`),
  ADD UNIQUE KEY `email` (`email`),
  ADD KEY `email_2` (`email`);

--
-- Indexes for table `saldo`
--
ALTER TABLE `saldo`
  ADD PRIMARY KEY (`id_saldo`),
  ADD KEY `id_nasabah` (`id_nasabah`);

--
-- Indexes for table `sampah`
--
ALTER TABLE `sampah`
  ADD PRIMARY KEY (`id_sampah`);

--
-- Indexes for table `setor`
--
ALTER TABLE `setor`
  ADD PRIMARY KEY (`id_setor`),
  ADD KEY `id_sampah` (`id_sampah`),
  ADD KEY `id_saldo` (`id_saldo`),
  ADD KEY `id_nasabah` (`id_nasabah`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `inti`
--
ALTER TABLE `inti`
  MODIFY `id_inti` int(6) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `nasabah`
--
ALTER TABLE `nasabah`
  MODIFY `id_nasabah` int(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `penarikan`
--
ALTER TABLE `penarikan`
  MODIFY `id_penarikan` int(6) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `pengepul`
--
ALTER TABLE `pengepul`
  MODIFY `id_pengepul` int(6) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `saldo`
--
ALTER TABLE `saldo`
  MODIFY `id_saldo` int(6) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `sampah`
--
ALTER TABLE `sampah`
  MODIFY `id_sampah` int(6) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `setor`
--
ALTER TABLE `setor`
  MODIFY `id_setor` int(6) NOT NULL AUTO_INCREMENT;
--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `inti`
--
ALTER TABLE `inti`
  ADD CONSTRAINT `inti_ibfk_1` FOREIGN KEY (`id_sampah`) REFERENCES `sampah` (`id_sampah`) ON DELETE CASCADE,
  ADD CONSTRAINT `inti_ibfk_2` FOREIGN KEY (`id_saldo`) REFERENCES `saldo` (`id_saldo`) ON DELETE CASCADE,
  ADD CONSTRAINT `inti_ibfk_3` FOREIGN KEY (`id_nasabah`) REFERENCES `nasabah` (`id_nasabah`) ON DELETE CASCADE,
  ADD CONSTRAINT `inti_ibfk_4` FOREIGN KEY (`id_penarikan`) REFERENCES `penarikan` (`id_penarikan`) ON DELETE CASCADE,
  ADD CONSTRAINT `inti_ibfk_5` FOREIGN KEY (`id_setor`) REFERENCES `setor` (`id_setor`) ON DELETE CASCADE,
  ADD CONSTRAINT `inti_ibfk_6` FOREIGN KEY (`id_pengepul`) REFERENCES `pengepul` (`id_pengepul`) ON DELETE CASCADE;

--
-- Ketidakleluasaan untuk tabel `penarikan`
--
ALTER TABLE `penarikan`
  ADD CONSTRAINT `penarikan_ibfk_1` FOREIGN KEY (`id_saldo`) REFERENCES `saldo` (`id_saldo`) ON DELETE CASCADE;

--
-- Ketidakleluasaan untuk tabel `saldo`
--
ALTER TABLE `saldo`
  ADD CONSTRAINT `saldo_ibfk_1` FOREIGN KEY (`id_nasabah`) REFERENCES `nasabah` (`id_nasabah`) ON DELETE CASCADE;

--
-- Ketidakleluasaan untuk tabel `setor`
--
ALTER TABLE `setor`
  ADD CONSTRAINT `setor_ibfk_1` FOREIGN KEY (`id_sampah`) REFERENCES `sampah` (`id_sampah`) ON DELETE CASCADE,
  ADD CONSTRAINT `setor_ibfk_2` FOREIGN KEY (`id_saldo`) REFERENCES `saldo` (`id_saldo`) ON DELETE CASCADE,
  ADD CONSTRAINT `setor_ibfk_3` FOREIGN KEY (`id_nasabah`) REFERENCES `nasabah` (`id_nasabah`) ON DELETE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
