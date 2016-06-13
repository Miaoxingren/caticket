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
-- Table structure for table `cinemas`
--

DROP TABLE IF EXISTS `cinemas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cinemas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` text NOT NULL,
  `area` text NOT NULL,
  `location` text NOT NULL,
  `phone` text NOT NULL,
  `score` float NOT NULL,
  `movieList` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cinemas`
--

LOCK TABLES `cinemas` WRITE;
/*!40000 ALTER TABLE `cinemas` DISABLE KEYS */;
INSERT INTO `cinemas` VALUES (1,'哈艺时尚影城-白云YH城店','TianHe','广州市白云区鹤龙一路208号商业楼三层','18817425236',7.5,'1,2,3'),(2,'哈艺时尚影城（天河科韵店）','Aoshima','广州市天河区棠安路288-298号天盈建博汇建材市场1楼','18817423896',8.5,'4,6,7'),(3,'保利国际影城广州中环店','TianHe','广州市 越秀区 建设大马路 18号 中环广场南楼 五层','18814225896',7.5,'1,2,8'),(4,'五一影城广州四季天地店','Aoshima','广州市海珠区赤岗北路118号四季天地3楼','18817433896',4.5,'1,3,4'),(5,'华影星美国际影城','TianHe','广州市环市西路133号华南影都D区二楼','18817225896',7.5,'1,2,3,4,5'),(6,'广州万众国际影城（南沙店）','Aoshima','广州市南沙区进港大道华汇国际广场四楼','18817425896',3,'1,2,3,7'),(7,'广州星汇电影城','TianHe','广州市越秀区西湖路63号光明广场7楼（北京路广百南门对面）','18817225896',7.5,'7,8'),(8,'广州飞影电影城','Aoshima','广州市天河区东莞庄路富力院士庭广场2楼','18817425136',4,'7');
/*!40000 ALTER TABLE `cinemas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-06-13 22:31:19
