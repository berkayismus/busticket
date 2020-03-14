-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Anamakine: 127.0.0.1
-- Üretim Zamanı: 09 May 2019, 22:28:52
-- Sunucu sürümü: 10.1.38-MariaDB
-- PHP Sürümü: 7.3.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `bus`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `bus`
--

CREATE TABLE `bus` (
  `id` int(11) NOT NULL,
  `model` varchar(100) COLLATE utf8_turkish_ci NOT NULL,
  `plaka` varchar(25) COLLATE utf8_turkish_ci NOT NULL,
  `seat` int(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `bus`
--

INSERT INTO `bus` (`id`, `model`, `plaka`, `seat`) VALUES
(2, 'temsa maraton', '34gkn34', 30),
(9, 'mercedes travego', '67brk67', 40),
(10, 'man XL', '34XL34', 20);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `ticket`
--

CREATE TABLE `ticket` (
  `id` int(25) NOT NULL,
  `nereden` varchar(50) COLLATE utf8_turkish_ci NOT NULL,
  `nereye` varchar(50) COLLATE utf8_turkish_ci NOT NULL,
  `bus` varchar(50) COLLATE utf8_turkish_ci NOT NULL,
  `date` varchar(50) COLLATE utf8_turkish_ci NOT NULL,
  `time` varchar(50) COLLATE utf8_turkish_ci NOT NULL,
  `price` int(25) NOT NULL,
  `TC` varchar(20) COLLATE utf8_turkish_ci NOT NULL,
  `name` varchar(50) COLLATE utf8_turkish_ci NOT NULL,
  `sex` varchar(50) COLLATE utf8_turkish_ci NOT NULL,
  `seat` int(25) NOT NULL,
  `pnr` varchar(50) COLLATE utf8_turkish_ci NOT NULL,
  `stat` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `ticket`
--

INSERT INTO `ticket` (`id`, `nereden`, `nereye`, `bus`, `date`, `time`, `price`, `TC`, `name`, `sex`, `seat`, `pnr`, `stat`) VALUES
(5, 'Çorlu', 'İstanbul', 'temsa maraton', '11-05-2019', '15:30', 30, '11111111111', 'berkay', 'Erkek', 14, 'PNR-1719', 1);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `travel`
--

CREATE TABLE `travel` (
  `id` int(11) NOT NULL,
  `nereden` varchar(100) COLLATE utf8_turkish_ci NOT NULL,
  `nereye` varchar(100) COLLATE utf8_turkish_ci NOT NULL,
  `price` int(25) NOT NULL,
  `route` varchar(254) COLLATE utf8_turkish_ci NOT NULL,
  `date` varchar(50) COLLATE utf8_turkish_ci NOT NULL,
  `time` varchar(50) COLLATE utf8_turkish_ci NOT NULL,
  `bus` varchar(50) COLLATE utf8_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `travel`
--

INSERT INTO `travel` (`id`, `nereden`, `nereye`, `price`, `route`, `date`, `time`, `bus`) VALUES
(19, 'Çorlu', 'İstanbul', 30, 'Orion-Esenler Otogar ekspress', '11-05-2019', '15:30', 'temsa maraton'),
(20, 'İstanbul', 'İzmir', 90, 'ekspress', '12-05-2019', '15:30', 'mercedes travego'),
(21, 'Ankara', 'Çorlu', 60, 'ekspress', '13-05-2019', '11:30', 'man XL');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `user`
--

CREATE TABLE `user` (
  `id` int(10) NOT NULL,
  `name` varchar(100) COLLATE utf8_turkish_ci NOT NULL,
  `phone` varchar(100) COLLATE utf8_turkish_ci NOT NULL,
  `email` varchar(100) COLLATE utf8_turkish_ci NOT NULL,
  `username` varchar(100) COLLATE utf8_turkish_ci NOT NULL,
  `password` varchar(100) COLLATE utf8_turkish_ci NOT NULL,
  `answer` varchar(100) COLLATE utf8_turkish_ci NOT NULL,
  `question` varchar(100) COLLATE utf8_turkish_ci NOT NULL,
  `stat` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `user`
--

INSERT INTO `user` (`id`, `name`, `phone`, `email`, `username`, `password`, `answer`, `question`, `stat`) VALUES
(3, 'user', '5436327690', 'user@user.com', 'user', 'user', 'user', 'Annenizin kızlık soyadı nedir?', 0),
(4, 'guest', '6648484548', 'guest@guest.com', 'guest', 'guest', 'guest', 'Annenizin kızlık soyadı nedir?', 2),
(6, 'admin', '(0545) - 553 - 23 - 79', 'admin@admin.com', 'admin', 'admin', 'admin', 'Annenizin kızlık soyadı nedir?', 1);

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `bus`
--
ALTER TABLE `bus`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `ticket`
--
ALTER TABLE `ticket`
  ADD PRIMARY KEY (`id`),
  ADD KEY `bus` (`bus`,`seat`,`stat`);

--
-- Tablo için indeksler `travel`
--
ALTER TABLE `travel`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `bus`
--
ALTER TABLE `bus`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Tablo için AUTO_INCREMENT değeri `ticket`
--
ALTER TABLE `ticket`
  MODIFY `id` int(25) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Tablo için AUTO_INCREMENT değeri `travel`
--
ALTER TABLE `travel`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- Tablo için AUTO_INCREMENT değeri `user`
--
ALTER TABLE `user`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
