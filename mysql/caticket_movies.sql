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
-- Table structure for table `movies`
--

DROP TABLE IF EXISTS `movies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `movies` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` text NOT NULL,
  `detail` text NOT NULL,
  `actors` text NOT NULL,
  `doctors` text NOT NULL,
  `score` float NOT NULL,
  `movieTypes` text NOT NULL,
  `lowCost` text NOT NULL,
  `releaseTime` date NOT NULL,
  `timeLength` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movies`
--

LOCK TABLES `movies` WRITE;
/*!40000 ALTER TABLE `movies` DISABLE KEYS */;
INSERT INTO `movies` VALUES (1,'The Huntsman','But the number, ever since it was released, has seen the scientific community challenge the claim of the India government. No, environmentalists and conservationists are not challenging the number of tigers in India; instead, they are questioning the rate of increase in the number of tigers.The number of tigers across the globe (read Asia) is on the rise for the first time in a century. Tigers in the wild, according to the most recent data, number about 3,890, up from an estimated 3,200 in 2010. The increase, a report by the World Wide Fund for Nature says, can be attributed to improved surveys and strengthened protection of the iconic species in India, Russia, Nepal and Bhutan.','Miaoxingren,Wangxingren,Tiger','Doctor Miao',7.5,'action,comedy','35.5','2016-04-15',90),(2,'The Huntsman','But the number, ever since it was released, has seen the scientific community challenge the claim of the India government. No, environmentalists and conservationists are not challenging the number of tigers in India; instead, they are questioning the rate of increase in the number of tigers.The number of tigers across the globe (read Asia) is on the rise for the first time in a century. Tigers in the wild, according to the most recent data, number about 3,890, up from an estimated 3,200 in 2010. The increase, a report by the World Wide Fund for Nature says, can be attributed to improved surveys and strengthened protection of the iconic species in India, Russia, Nepal and Bhutan.','Miaoxingren,Wangxingren,Tiger','Doctor Miao',7.5,'action,comedy','35.5','2016-04-15',90),(3,'The Huntsman','But the number, ever since it was released, has seen the scientific community challenge the claim of the India government. No, environmentalists and conservationists are not challenging the number of tigers in India; instead, they are questioning the rate of increase in the number of tigers.The number of tigers across the globe (read Asia) is on the rise for the first time in a century. Tigers in the wild, according to the most recent data, number about 3,890, up from an estimated 3,200 in 2010. The increase, a report by the World Wide Fund for Nature says, can be attributed to improved surveys and strengthened protection of the iconic species in India, Russia, Nepal and Bhutan.','Miaoxingren,Wangxingren,Tiger','Doctor Miao',7.5,'action,comedy','35.5','2016-04-15',90),(4,'The Huntsman','But the number, ever since it was released, has seen the scientific community challenge the claim of the India government. No, environmentalists and conservationists are not challenging the number of tigers in India; instead, they are questioning the rate of increase in the number of tigers.The number of tigers across the globe (read Asia) is on the rise for the first time in a century. Tigers in the wild, according to the most recent data, number about 3,890, up from an estimated 3,200 in 2010. The increase, a report by the World Wide Fund for Nature says, can be attributed to improved surveys and strengthened protection of the iconic species in India, Russia, Nepal and Bhutan.','Miaoxingren,Wangxingren,Tiger','Doctor Miao',7.5,'action,comedy','35.5','2016-04-15',90),(5,'The Huntsman','But the number, ever since it was released, has seen the scientific community challenge the claim of the India government. No, environmentalists and conservationists are not challenging the number of tigers in India; instead, they are questioning the rate of increase in the number of tigers.The number of tigers across the globe (read Asia) is on the rise for the first time in a century. Tigers in the wild, according to the most recent data, number about 3,890, up from an estimated 3,200 in 2010. The increase, a report by the World Wide Fund for Nature says, can be attributed to improved surveys and strengthened protection of the iconic species in India, Russia, Nepal and Bhutan.','Miaoxingren,Wangxingren,Tiger','Doctor Miao',7.5,'action,comedy','35.5','2016-04-15',90),(6,'The Huntsman','But the number, ever since it was released, has seen the scientific community challenge the claim of the India government. No, environmentalists and conservationists are not challenging the number of tigers in India; instead, they are questioning the rate of increase in the number of tigers.The number of tigers across the globe (read Asia) is on the rise for the first time in a century. Tigers in the wild, according to the most recent data, number about 3,890, up from an estimated 3,200 in 2010. The increase, a report by the World Wide Fund for Nature says, can be attributed to improved surveys and strengthened protection of the iconic species in India, Russia, Nepal and Bhutan.','Miaoxingren,Wangxingren,Tiger','Doctor Miao',7.5,'action,comedy','35.5','2016-04-15',90),(7,'The Huntsman','But the number, ever since it was released, has seen the scientific community challenge the claim of the India government. No, environmentalists and conservationists are not challenging the number of tigers in India; instead, they are questioning the rate of increase in the number of tigers.The number of tigers across the globe (read Asia) is on the rise for the first time in a century. Tigers in the wild, according to the most recent data, number about 3,890, up from an estimated 3,200 in 2010. The increase, a report by the World Wide Fund for Nature says, can be attributed to improved surveys and strengthened protection of the iconic species in India, Russia, Nepal and Bhutan.','Miaoxingren,Wangxingren,Tiger','Doctor Miao',7.5,'action,comedy','35.5','2016-04-15',90);
/*!40000 ALTER TABLE `movies` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-05-16 21:03:55
