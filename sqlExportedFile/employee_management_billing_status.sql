-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: employee_management
-- ------------------------------------------------------
-- Server version	5.7.22-log

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
-- Table structure for table `billing_status`
--

DROP TABLE IF EXISTS `billing_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `billing_status` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `billable_status` varchar(255) DEFAULT NULL,
  `billing` varchar(255) DEFAULT NULL,
  `involvement` float DEFAULT NULL,
  `emp_id` bigint(20) DEFAULT NULL,
  `project_id` bigint(20) DEFAULT NULL,
  `status_project_id` bigint(20) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKqxlbjv100rh0fjy53mmtfy3hr` (`emp_id`),
  KEY `FKj17j1lgrqrps8dbqlkaq7f5w1` (`project_id`),
  KEY `FK5pi1ls07xhk07asr0hoj2p9kq` (`status_project_id`),
  CONSTRAINT `FK5pi1ls07xhk07asr0hoj2p9kq` FOREIGN KEY (`status_project_id`) REFERENCES `project` (`project_id`),
  CONSTRAINT `FKj17j1lgrqrps8dbqlkaq7f5w1` FOREIGN KEY (`project_id`) REFERENCES `project` (`project_id`),
  CONSTRAINT `FKqxlbjv100rh0fjy53mmtfy3hr` FOREIGN KEY (`emp_id`) REFERENCES `employees` (`emp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `billing_status`
--

LOCK TABLES `billing_status` WRITE;
/*!40000 ALTER TABLE `billing_status` DISABLE KEYS */;
INSERT INTO `billing_status` VALUES (1,'bench',NULL,NULL,101,NULL,NULL,NULL),(2,'billable','3',50,104,1,NULL,NULL),(3,'billable','5',75,105,1,NULL,NULL),(4,'billable','7',100,106,1,NULL,NULL),(5,'shadow',NULL,25,103,3,NULL,NULL),(6,'shadow',NULL,40,102,4,NULL,NULL);
/*!40000 ALTER TABLE `billing_status` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-07-06 16:57:34
