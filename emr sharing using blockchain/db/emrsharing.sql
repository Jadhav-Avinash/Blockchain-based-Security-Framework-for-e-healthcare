-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.5.62 - MySQL Community Server (GPL)
-- Server OS:                    Win32
-- HeidiSQL Version:             10.3.0.5771
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for emrsharing
CREATE DATABASE IF NOT EXISTS `emrsharing` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `emrsharing`;

-- Dumping structure for table emrsharing.appointment
CREATE TABLE IF NOT EXISTS `appointment` (
  `aid` int(11) DEFAULT NULL,
  `did` int(11) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  `day` varchar(50) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table emrsharing.appointment: ~2 rows (approximately)
DELETE FROM `appointment`;
/*!40000 ALTER TABLE `appointment` DISABLE KEYS */;
INSERT INTO `appointment` (`aid`, `did`, `pid`, `day`, `status`) VALUES
	(1, 222, 111, 'Fri Mar 31 13:52:30 IST 2023', 'CLOSED'),
	(2, 222, 111, 'Tue Apr 04 14:27:09 IST 2023', 'PENDING');
/*!40000 ALTER TABLE `appointment` ENABLE KEYS */;

-- Dumping structure for table emrsharing.doctor
CREATE TABLE IF NOT EXISTS `doctor` (
  `did` int(11) DEFAULT NULL,
  `dname` varchar(50) DEFAULT NULL,
  `speciality` varchar(50) DEFAULT NULL,
  `contact` varchar(50) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `pass` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table emrsharing.doctor: ~1 rows (approximately)
DELETE FROM `doctor`;
/*!40000 ALTER TABLE `doctor` DISABLE KEYS */;
INSERT INTO `doctor` (`did`, `dname`, `speciality`, `contact`, `email`, `pass`) VALUES
	(222, 'bbb', 'physician', '1212321234', 'bbb@gmail.com', 'bbb');
/*!40000 ALTER TABLE `doctor` ENABLE KEYS */;

-- Dumping structure for table emrsharing.lab
CREATE TABLE IF NOT EXISTS `lab` (
  `uname` varchar(50) DEFAULT NULL,
  `pass` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table emrsharing.lab: ~1 rows (approximately)
DELETE FROM `lab`;
/*!40000 ALTER TABLE `lab` DISABLE KEYS */;
INSERT INTO `lab` (`uname`, `pass`) VALUES
	('lab', 'lab');
/*!40000 ALTER TABLE `lab` ENABLE KEYS */;

-- Dumping structure for table emrsharing.patient
CREATE TABLE IF NOT EXISTS `patient` (
  `pid` int(11) NOT NULL DEFAULT '0',
  `pass` varchar(50) DEFAULT NULL,
  `pname` varchar(50) DEFAULT NULL,
  `dob` varchar(50) DEFAULT NULL,
  `gender` varchar(50) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `contact` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table emrsharing.patient: ~1 rows (approximately)
DELETE FROM `patient`;
/*!40000 ALTER TABLE `patient` DISABLE KEYS */;
INSERT INTO `patient` (`pid`, `pass`, `pname`, `dob`, `gender`, `address`, `contact`, `email`) VALUES
	(111, 'aaa', 'aaa', 'MMM d, yyyy', 'Male', 'bng', '1234567890', 'aaa@gmail.com');
/*!40000 ALTER TABLE `patient` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
