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
  `movieId` int(11) NOT NULL,
  `cinemaId` int(11) NOT NULL,
  `seatId` int(11) NOT NULL,
  `lang` text NOT NULL,
  `room` int(11) NOT NULL,
  `playDate` date NOT NULL,
  `beginTime` time NOT NULL,
  `endTime` time NOT NULL,
  `price` float NOT NULL,
  `isThreeD` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sessions`
--

LOCK TABLES `sessions` WRITE;
/*!40000 ALTER TABLE `sessions` DISABLE KEYS */;
INSERT INTO `sessions` VALUES (1,1,1,2,'Endglish',4,'2016-05-27','22:11:17','22:11:17',35.5,1),(2,1,1,3,'Endglish',4,'2016-05-28','22:11:27','22:11:27',35.5,0),(3,1,2,1,'Endglish',4,'2016-05-29','22:11:30','22:11:30',35.5,1),(4,1,2,3,'Endglish',3,'2016-05-30','22:11:41','22:11:41',35.5,1),(5,2,2,1,'Endglish',3,'2016-05-31','22:11:44','22:11:44',35.5,1),(6,1,1,2,'Endglish',3,'2016-06-01','19:40:56','19:40:56',35.5,1),(7,1,1,3,'Endglish',3,'2016-06-02','19:41:02','19:41:02',35.5,0),(8,1,1,1,'Endglish',3,'2016-06-03','14:00:29','14:00:29',35.5,1),(9,1,1,1,'Endglish',3,'2016-06-04','14:00:31','14:00:31',35.5,1),(10,1,1,2,'Endglish',4,'2016-06-05','14:04:55','14:04:55',35.5,1),(11,1,1,2,'Endglish',4,'2016-06-06','14:06:59','14:06:59',35.5,0),(12,1,1,1,'Endglish',4,'2016-06-07','14:07:07','14:07:07',75.5,0),(13,1,1,1,'Endglish',4,'2016-06-08','14:07:16','14:07:16',75.5,0),(14,1,1,2,'Endglish',4,'2016-06-09','14:07:34','14:07:34',95.5,1),(15,1,1,3,'Endglish',4,'2016-06-10','17:16:22','17:16:22',95.5,1),(16,1,1,1,'Endglish',4,'2016-06-11','17:21:54','17:21:54',95.5,1),(17,1,1,1,'Endglish',4,'2016-06-12','17:22:59','17:22:59',95.5,1),(18,1,1,1,'Endglish',4,'2016-06-13','17:25:14','17:25:14',95.5,1),(19,1,1,1,'Endglish',4,'2016-06-14','17:29:07','17:29:07',95.5,1),(20,1,1,1,'Endglish',4,'2016-06-15','17:31:19','17:31:19',95.5,1),(21,1,1,2,'Endglish',4,'2016-06-16','10:01:20','10:01:20',95.5,1),(22,1,1,3,'Endglish',4,'2016-06-17','13:33:00','13:33:00',95.5,1),(23,1,1,1,'Endglish',4,'2016-06-18','18:48:46','18:48:46',95.5,1),(24,1,1,1,'Endglish',4,'2016-06-19','18:48:49','18:48:49',95.5,1),(25,1,1,1,'Endglish',4,'2016-06-20','18:48:50','18:48:50',95.5,1),(26,1,1,2,'Endglish',4,'2016-06-21','19:32:45','19:32:45',95.5,1),(27,1,1,3,'Endglish',4,'2016-06-22','19:56:03','19:56:03',95.5,1),(28,1,1,1,'Endglish',4,'2016-06-23','19:56:54','19:56:54',95.5,1),(29,1,1,2,'Endglish',4,'2016-06-24','22:56:34','22:56:34',95.5,1),(30,1,1,3,'Endglish',4,'2016-06-25','22:57:34','22:57:34',95.5,1),(31,1,1,1,'Endglish',4,'2016-06-26','22:58:38','22:58:38',95.5,1);
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

-- Dump completed on 2016-06-13 22:31:18
