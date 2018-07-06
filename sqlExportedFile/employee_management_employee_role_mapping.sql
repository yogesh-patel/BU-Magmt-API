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
-- Table structure for table `employee_role_mapping`
--

DROP TABLE IF EXISTS `employee_role_mapping`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee_role_mapping` (
  `erole_mapping_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `member` bigint(20) DEFAULT NULL,
  `manager_id` bigint(20) DEFAULT NULL,
  `role` bigint(20) DEFAULT NULL,
  `id` bigint(20) NOT NULL,
  `emp_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`erole_mapping_id`),
  KEY `FK3gi2qubdkbdimb46s26sjmrkp` (`member`),
  KEY `FK87k6qk1qlbjlh8a6gsign3j7w` (`manager_id`),
  KEY `FKluantfdn4aee7k45y9e9ipxnd` (`role`),
  KEY `FKmgrjpwiqbvtyks9r7vi4t507e` (`emp_id`),
  CONSTRAINT `FK3gi2qubdkbdimb46s26sjmrkp` FOREIGN KEY (`member`) REFERENCES `employees` (`emp_id`),
  CONSTRAINT `FK87k6qk1qlbjlh8a6gsign3j7w` FOREIGN KEY (`manager_id`) REFERENCES `employees` (`emp_id`),
  CONSTRAINT `FKluantfdn4aee7k45y9e9ipxnd` FOREIGN KEY (`role`) REFERENCES `roles` (`role_id`),
  CONSTRAINT `FKmgrjpwiqbvtyks9r7vi4t507e` FOREIGN KEY (`emp_id`) REFERENCES `employees` (`emp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_role_mapping`
--

LOCK TABLES `employee_role_mapping` WRITE;
/*!40000 ALTER TABLE `employee_role_mapping` DISABLE KEYS */;
INSERT INTO `employee_role_mapping` VALUES (1,102,105,6,0,NULL),(2,103,105,6,0,NULL),(3,101,104,1,0,NULL),(4,105,107,3,0,NULL),(5,104,107,3,0,NULL),(9,106,107,4,0,NULL),(10,107,NULL,8,0,NULL);
/*!40000 ALTER TABLE `employee_role_mapping` ENABLE KEYS */;
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
