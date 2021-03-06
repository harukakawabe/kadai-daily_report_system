-- MySQL dump 10.13  Distrib 5.7.31, for macos10.14 (x86_64)
--
-- Host: localhost    Database: daily_report_system
-- ------------------------------------------------------
-- Server version	5.7.31

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
-- Table structure for table `employees`
--

DROP TABLE IF EXISTS `employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employees` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_flag` int(11) NOT NULL,
  `code` varchar(255) NOT NULL,
  `created_at` datetime NOT NULL,
  `delete_flag` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `password` varchar(64) NOT NULL,
  `updated_at` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_3um79qgwg340lpaw7phtwudtc` (`code`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employees`
--

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` VALUES (1,0,'a100001','2020-11-02 01:49:09',0,'煌木　太郎','EF356838DB5E67E62448F69D31D6E4B822AA13915B872B957276BEB85F2096C1','2020-11-02 01:49:09'),(2,0,'b200002','2020-11-02 01:49:40',0,'佐藤　一郎','6D103BBBC824445552E1AEEED41CC13EC16DB424DB6D6EC80AC50DD8DF4256CA','2020-11-02 01:49:40'),(3,0,'b200003','2020-11-02 01:50:19',0,'谷本　良尚','B022A9E4E37DC4260D228B6B5CB9EFAA31FB96159761106874F8D8EDECE5E7B3','2020-11-02 01:50:19'),(4,0,'b20004','2020-11-02 01:50:41',0,'中本　真理子','05F484FDDF3BDE4F0DE80BF59609417B121F38E55F19974E2C335C75BC6635E5','2020-11-02 01:50:41'),(5,0,'b200005','2020-11-02 01:51:11',0,'菊池　直武','26845C895F6982768177EB3890993CC85D96B18B65F25F1ADC68B87D33A7A70D','2020-11-02 01:51:11'),(6,0,'b20007','2020-11-02 01:51:42',1,'栗原　カメオ','1E0622B5E3522479CC5D7E97ECEB70AC3A9CA68040F0BC5D97C070611AB64CAB','2020-11-02 02:09:58'),(7,1,'1218','2020-11-02 02:19:06',0,'川邊','A8444E0672ABF17ECED99E00FB4E202A08E54DBF4F607A3E1E784E8E070F5F8B','2020-11-02 02:19:06');
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reports`
--

DROP TABLE IF EXISTS `reports`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reports` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` longtext NOT NULL,
  `created_at` datetime NOT NULL,
  `report_date` date NOT NULL,
  `title` varchar(255) NOT NULL,
  `updated_at` datetime NOT NULL,
  `employee_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK7m58c0h3phjcm6bco7aqikfen` (`employee_id`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reports`
--

LOCK TABLES `reports` WRITE;
/*!40000 ALTER TABLE `reports` DISABLE KEYS */;
INSERT INTO `reports` VALUES (1,'11/4の日報です。','2020-11-04 15:37:01','2020-11-04','11/4の日報','2020-11-04 15:37:01',7),(2,'本日の日報です。','2020-11-04 15:37:35','2020-11-04','本日の日報','2020-11-04 15:37:35',7),(3,'11/3の日報です。\r\n','2020-11-04 15:38:12','2020-11-03','11/3の日報','2020-11-04 15:38:12',7),(4,'本日の日報です。','2020-11-04 15:39:47','2020-11-04','日報（菊池）','2020-11-04 15:39:47',5),(5,'11/4、本日の日報です。\r\n懸案だった案件は一通り進めることができました。\r\nまた明日から頑張ります。','2020-11-04 16:22:28','2020-11-04','11/4の日報（２）','2020-11-04 16:22:28',7),(6,'本日の日報です。\r\n\r\n','2020-11-04 17:45:23','2020-11-04','本日の日報','2020-11-04 17:45:23',7),(7,'今日の日報です。','2020-11-07 23:41:15','2020-11-07','今日の日報','2020-11-08 00:42:27',7),(8,'日報です。','2020-11-08 01:45:00','2020-11-08','日報','2020-11-08 01:45:32',7);
/*!40000 ALTER TABLE `reports` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-11-09 17:09:44
