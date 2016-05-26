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
  `releaseTime` date NOT NULL,
  `timeLength` int(11) NOT NULL,
  `doctors` text NOT NULL,
  `actors` text NOT NULL,
  `movieTypes` text NOT NULL,
  `cinemaList` text NOT NULL,
  `detail` text NOT NULL,
  `lowCost` float NOT NULL,
  `score` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movies`
--

LOCK TABLES `movies` WRITE;
/*!40000 ALTER TABLE `movies` DISABLE KEYS */;
INSERT INTO `movies` VALUES (1,'The Huntsman1','2016-01-15',90,'Doctor Miao','Miaoxingren,Wangxingren,Tiger','action,comedy','1,7,8','Cats love sleeping on your laptop (especially while you’re using it), so why not let them geek out with their own cardboard computer perfect for tearing up the Internet?',77.5,7.5),(2,'The Huntsman2','2016-02-15',190,'Doctor win7','Miaoxingren,Wangxingren,Tiger','action,comedy','2,7','Cats love sleeping on your laptop (especially while you’re using it), so why not let them geek out with their own cardboard computer perfect for tearing up the Internet?',32.5,5.5),(3,'The Huntsman3','2016-03-15',80,'Doctor qiming','Miaoxingren,Wangxingren,Tiger','action,comedy','3,8','Cats love sleeping on your laptop (especially while you’re using it), so why not let them geek out with their own cardboard computer perfect for tearing up the Internet?',34.5,7.5),(4,'The Huntsman4','2016-04-15',95,'Doctor qiming','Miaoxingren,Wangxingren,Tiger','action,comedy','1,2,3,7','Pet owners wanting to keep their kitties happy with a techie theme might want to consider getting them a personal Cat Scratch Laptop made of cardboard.',34.5,5.5),(5,'The Huntsman5','2016-05-15',40,'Doctor Miao','Miaoxingren,Wangxingren,Tiger','action,comedy','1,4,7,8','While the mock laptop doesn’t actually connect to the Internet, your cat will be so excited that you’re not yelling at him for blocking the screen he’ll never know the difference between the printed-out desktop wallpaper and the real deal. (You can slide in new pictures to keep the look fresh.)',87.5,7.5),(6,'The Huntsman6','2016-06-15',91,'Doctor win7','Miaoxingren,Wangxingren,Tiger','action,comedy','7','Measuring 13 inches wide and 11 inches high (330 millimeters by 270 millimeters), it’s big enough for a cat to sprawl over, but there’s a little more to it than that. Instead of the clickety-clack of keys being pushed by a budding blogger, your cat can scratch up a storm on the panel of corrugated cardboard. Plus the laptop comes with a fuzzy mouse toy plugged in by the tail as a nod to the classic computer mouse.',39.5,5.5),(7,'The Huntsman7','2016-07-15',93,'Doctor qiming','Miaoxingren,Wangxingren,Tiger','action,comedy','7,8','The Cat Scratch Laptop, made from partially or fully recycled paper and cardboard by Cat Playhouse, is a lot cheaper than an electronic version, coming in at $35 from the retailer Suck UK. If you’re ordering from the US, it’ll cost you an extra $22 shipping and handling.',57.5,7.5),(8,'The Huntsman8','2016-08-15',100,'Doctor win7','Miaoxingren,Wangxingren,Tiger','action,comedy','2,4','But think of all the furniture and real laptops you’ll be saving from getting clawed up by bored cats，wondering when you’re going to get off of Twitter and give them treats.',37,5.5);
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

-- Dump completed on 2016-05-26 23:33:43
