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
-- Table structure for table `employee_skill_mapping`
--

DROP TABLE IF EXISTS `employee_skill_mapping`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee_skill_mapping` (
  `eskill_mapping_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `member` bigint(20) DEFAULT NULL,
  `skill` bigint(20) DEFAULT NULL,
  `id` bigint(20) NOT NULL,
  PRIMARY KEY (`eskill_mapping_id`),
  KEY `FKqxti9ghf22gukyilv5a9dt7t7` (`member`),
  KEY `FKdrq9g9xf4j2dd8cfnm453dl2l` (`skill`),
  CONSTRAINT `FKdrq9g9xf4j2dd8cfnm453dl2l` FOREIGN KEY (`skill`) REFERENCES `skills` (`skill_id`),
  CONSTRAINT `FKqxti9ghf22gukyilv5a9dt7t7` FOREIGN KEY (`member`) REFERENCES `employees` (`emp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_skill_mapping`
--

LOCK TABLES `employee_skill_mapping` WRITE;
/*!40000 ALTER TABLE `employee_skill_mapping` DISABLE KEYS */;
INSERT INTO `employee_skill_mapping` VALUES (1,101,1,0),(2,101,5,0),(3,102,4,0),(4,102,5,0),(5,101,6,0),(6,103,4,0),(7,104,3,0),(8,104,4,0),(9,104,5,0),(10,105,3,0),(11,105,4,0),(12,105,5,0),(13,105,8,0),(14,106,1,0),(15,106,9,0),(16,107,1,0),(17,107,6,0),(18,107,7,0),(21,107,8,0);
/*!40000 ALTER TABLE `employee_skill_mapping` ENABLE KEYS */;
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
