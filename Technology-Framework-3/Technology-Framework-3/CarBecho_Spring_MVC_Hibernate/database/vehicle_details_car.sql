CREATE DATABASE  IF NOT EXISTS `vehicle_details` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `vehicle_details`;
-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: localhost    Database: vehicle_details
-- ------------------------------------------------------
-- Server version	5.5.23

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `car`
--

DROP TABLE IF EXISTS `car`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `car` (
  `CompanyName` varchar(30) NOT NULL DEFAULT '',
  `ModelName` varchar(30) NOT NULL DEFAULT '',
  `EngineInCC` decimal(6,2) DEFAULT NULL,
  `FuelCapacity` decimal(6,2) DEFAULT NULL,
  `Mileage` decimal(5,2) DEFAULT NULL,
  `Price` decimal(10,2) DEFAULT NULL,
  `RoadTax` decimal(4,2) DEFAULT NULL,
  `AC` varchar(5) DEFAULT NULL,
  `PowerSteering` varchar(5) DEFAULT NULL,
  `AccessoryKit` varchar(5) DEFAULT NULL,
  `OnRoadPrice` decimal(11,2) DEFAULT NULL,
  PRIMARY KEY (`CompanyName`,`ModelName`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `car`
--

LOCK TABLES `car` WRITE;
/*!40000 ALTER TABLE `car` DISABLE KEYS */;
INSERT INTO `car` VALUES ('Chevrolet','Beat',100.00,40.00,20.00,250000.00,2.00,'1','0','1',255000.00),('Maruti','abc',140.00,25.00,20.00,250000.00,4.00,'1','1','1',260000.00),('Maruti','Ninja',145.00,45.00,20.00,452000.00,4.00,'1','1','1',470080.00),('Maruti','Suzuki',145.00,23.00,20.00,125000.00,2.00,'0','1','1',127500.00),('Maruti','Swift',10.00,25.00,20.00,125000.00,2.00,'0','1','1',127500.00),('Toyota','Etios',118.00,35.00,22.00,340000.00,2.00,'1','1','0',346800.00);
/*!40000 ALTER TABLE `car` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-10-01 19:32:53
