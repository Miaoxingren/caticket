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
  `post` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movies`
--

LOCK TABLES `movies` WRITE;
/*!40000 ALTER TABLE `movies` DISABLE KEYS */;
INSERT INTO `movies` VALUES (1,'魔兽 Warcraft','2016-06-08',124,'邓肯·琼斯','崔维斯·费米尔,托比·凯贝尔,宝拉·巴顿,本·施耐泽','动作,冒险,奇幻','1,7,8','艾泽拉斯与德拉诺本是两颗祥和安宁的星球，人类在艾泽拉斯大陆上世代繁衍生息，兽人则在德拉诺的土地上辛勤耕耘。直到兽人古尔丹的出现，打破了两个星球的和平。邪恶的古尔丹为了一己私利，使用恶魔能量打开了一扇传送门——黑暗之门，并残忍的破坏兽人的家园，将原本爱好和平的兽人变成一个个野蛮残暴的战士，迫使他们穿过黑暗之门到达人类的领地作恶。霜狼氏族的酋长杜隆坦虽然发现了古尔丹的阴谋却为时已晚，不得不带领着自己的族人离开支离破碎的德拉诺，在举步维艰的艾泽拉斯大陆上寻找着庇护所。面临家园危机的人类在领袖洛萨的带领下一边痛击着野蛮的入侵者，一边苦苦寻求着战争之外的解救方法。两个种族面临着同样的危机，他们能够顺利的渡过这场灾难吗？',77.5,7.5,'1.jpg'),(2,'X战警：天启','2016-02-15',190,'邓肯·琼斯','崔维斯·费米尔,托比·凯贝尔,宝拉·巴顿,本·施耐泽','动作,冒险,奇幻','2,7','漫威X战警世界里，能力最强大并且是史上首位变种人，自人类文明开始以来，便为世人当作天神来膜拜，他汲取多位变种人的超能力，演变成一位永生不死且无人能敌的超级变种人，历经数千年后，他再度觉醒，集结了多位强大的变种人意欲毁灭一切，重建世界秩序，当中包含失志的万磁王（迈克尔法斯宾德 饰）。当地球面临未知的巨大危机之际，瑞雯（詹妮弗劳伦斯 饰）在X教授（詹姆斯麦卡沃伊 饰）的协助之下，必须领导年轻的X战警们力抗这史上最强大的敌人，并扭转人类命运。',32.5,5.5,'2.jpg'),(3,'爱丽丝梦游仙境2：镜中奇遇记','2016-03-15',80,'邓肯·琼斯','崔维斯·费米尔,托比·凯贝尔,宝拉·巴顿,本·施耐泽','动作,冒险,奇幻','3,8','爱丽丝（米娅·华希科沃斯卡 饰）在过去的几年里跟随父亲去海上航行，返回伦敦后她遇到了一面神奇的镜子，穿过镜子她再一次回到了奇幻仙境，并且遇到了昔日的朋友白兔、毛毛虫、疯帽匠（约翰尼·德普 饰）等，但此时疯帽匠已不是原来的他了，白皇后（安妮·海瑟薇 饰）帮助爱丽丝通过大时钟内部的时空传送仪回到过去，在不同的点她遇到了之前的朋友和敌人，在那里她必须与时间对抗，在时间耗尽之前拯救疯帽匠。而此前海报中每位主演手中都有的闪闪发光的神秘球体便是帮助爱丽丝回到过去的关键所在。',34.5,7.5,'3.jpg'),(4,'愤怒的小鸟','2016-04-15',95,'邓肯·琼斯','崔维斯·费米尔,托比·凯贝尔,宝拉·巴顿,本·施耐泽','动作,冒险,奇幻','1,2,3,7','一群不会飞的小鸟，挤在一座热带小岛上，和睦宁静。游戏中的几个经典形象成了影片的主角，分别是易怒的小鸟大红（杰森·苏戴奇斯配音），速度小鸟恰克（乔什·盖德配音）、炸弹（丹尼·麦克布耐德配音）。当神秘的绿色小猪登陆岛屿时，小鸟们平静的生活被打破了。',34.5,5.5,'4.jpg'),(5,'泰迪熊之玩具大战 ','2016-05-15',40,'邓肯·琼斯','崔维斯·费米尔,托比·凯贝尔,宝拉·巴顿,本·施耐泽','动作,冒险,奇幻','1,4,7,8','邪恶科学家巫博士为了让自己发明的高科技VR玩具垄断所有孩子的童年，制定了毁灭所有传统毛绒和机甲玩具的阴谋。泰迪熊本不想参与此事，但在机甲战士小飞的劝说下，泰迪熊加入了冒险之旅。为了阻止了巫博士的阴谋，泰迪熊和小飞经历了重重考验和阻碍，在关键时刻，泰迪熊运用自己的电脑技术突破难关，最终拯救了整个玩具世界。',87.5,7.5,'5.jpg'),(6,'北京遇上西雅图之不二情书 ','2016-06-15',91,'邓肯·琼斯','崔维斯·费米尔,托比·凯贝尔,宝拉·巴顿,本·施耐泽','动作,冒险,奇幻','7','姣爷（汤唯饰）15岁就随父亲移民到澳门，从此在赌城安家，并成为赌场公关。Daniel（吴秀波饰）则生活在洛杉矶，是一位房地产经纪人。正像千百次错过，终遇上一见钟情所说，两人最终携手漫步在伦敦街头，演绎一段澳门遇上洛杉矶的跨国爱情故事。姣爷分别与学霸（陆毅饰）、富豪（王志文饰）和诗人（祖峰饰）开展一段无果的感情。Daniel则与两名外国女子谈情，并惨遭抛弃。最后这对“绝配”终于奇妙遇上。',39.5,5.5,'6.jpg'),(7,'百鸟朝凤','2016-07-15',93,'邓肯·琼斯','崔维斯·费米尔,托比·凯贝尔,宝拉·巴顿,本·施耐泽','动作,冒险,奇幻','7,8','老一代唢呐艺人焦三爷是个外冷内热的老人，看起来严肃古板，其实心怀热血。影片表现了在社会变革、民心浮躁的年代里，新老两代唢呐艺人为了信念的坚守所产生的真挚的师徒情、父子情、兄弟情。',57.5,7.5,'7.jpg'),(8,'分歧者3：忠诚世界','2016-08-15',100,'邓肯·琼斯','崔维斯·费米尔,托比·凯贝尔,宝拉·巴顿,本·施耐泽','动作,冒险,奇幻','2,4','在推翻了派系制度之后，翠丝与老四带领众人翻越了芝加哥的围墙来到全新世界。然而看似美好的新世界却隐藏着更大的杀机，翠丝与老四之间的信任也遭受到前所未有的考验。二人能否从阴谋中脱身并守住彼此？',37,5.5,'8.jpg');
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

-- Dump completed on 2016-06-13 22:31:18
