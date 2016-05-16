-- MySQL dump 10.13  Distrib 5.6.24, for Win64 (x86_64)
--
-- Host: localhost    Database: caticket
-- ------------------------------------------------------
-- Server version	5.6.26-log

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
-- Table structure for table `sessions`
--

DROP TABLE IF EXISTS `sessions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sessions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `movieName` text NOT NULL,
  `cinemaName` text NOT NULL,
  `lang` text NOT NULL,
  `room` int(11) NOT NULL,
  `playDate` date NOT NULL,
  `beginTime` datetime NOT NULL,
  `endTime` datetime NOT NULL,
  `price` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sessions`
--

LOCK TABLES `sessions` WRITE;
/*!40000 ALTER TABLE `sessions` DISABLE KEYS */;
INSERT INTO `sessions` VALUES (1,'The Huntsman','Guangzhou Central Cinema','Endglish 3D',1,'2016-04-15','2016-04-15 09:00:00','2016-04-15 11:00:00',35.5),(2,'The Huntsman','Guangzhou Central Cinema','Endglish 3D',1,'2016-04-15','2016-04-15 09:00:00','2016-04-15 11:00:00',35.5),(3,'The Huntsman','Guangzhou Central Cinema','Endglish 3D',2,'2016-04-15','2016-04-15 11:00:00','2016-04-15 13:00:00',35.5),(4,'The Huntsman','Guangzhou Central Cinema','Endglish 3D',2,'2016-04-15','2016-04-15 11:00:00','2016-04-15 13:00:00',35.5),(5,'The Huntsman','Guangzhou Central Cinema','Endglish 3D',3,'2016-04-15','2016-04-15 11:00:00','2016-04-15 13:00:00',35.5),(6,'The Huntsman','Guangzhou Central Cinema','Endglish 3D',3,'2016-04-15','2016-04-15 11:00:00','2016-04-15 13:00:00',35.5),(7,'The Huntsman','Guangzhou Central Cinema','Endglish 3D',4,'2016-04-15','2016-04-15 15:00:00','2016-04-15 17:00:00',35.5),(8,'The Huntsman','Guangzhou Central Cinema','Endglish 3D',4,'2016-04-15','2016-04-15 15:00:00','2016-04-15 17:00:00',35.5);
/*!40000 ALTER TABLE `sessions` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-05-16 21:03:56
