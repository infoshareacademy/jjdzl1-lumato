-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 20, 2019 at 01:29 AM
-- Server version: 10.1.37-MariaDB
-- PHP Version: 7.3.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `lumato`
--

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `user_id` int(11) NOT NULL,
  `user_login` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `user_password` char(167) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `user_email` varchar(40) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `user_last_login` datetime DEFAULT NULL,
  `user_blocked` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_id`, `user_login`, `user_password`, `user_email`, `user_last_login`, `user_blocked`) VALUES
(1, 'Anna', 'password', 'anna@wanna.pl', '2019-01-22 00:00:00', 0),
(2, 'admin', 'admin', 'admin@admin.pl', '2018-10-20 00:00:00', 0),
(3, 'kasia', 'kasia', 'kasia@kasia.pl', '2019-01-01 04:22:06', 0),
(4, 'marek', 'marek', 'marek@owczarek.de', NULL, 0),
(5, 'kakofonista', 'glosnoznaczygit', 'kakofonia@sax.lbn', NULL, 0),
(6, 'johnnybravo', 'lubieplacki', NULL, NULL, 0),
(7, 'aladyn', 'jintogej', 'aladyn@akrabar.ar', '2019-01-19 00:00:00', 0),
(8, 'maroCzarodziej', 'hokuspokus', 'czary@mary.hg', NULL, 0),
(9, 'januszex', 'dupa88', NULL, NULL, 0),
(10, 'lubieplacki', 'jacek', NULL, NULL, 0),
(11, 'StefanoItaliano', 'macaronibueno', NULL, NULL, 0),
(12, 'Wonsz_rzeczny', 'jestem_niebezpieczny', NULL, NULL, 0),
(13, 'Kozak', 'grzybobranie', 'muchomorek@grzyby.pl', NULL, 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
