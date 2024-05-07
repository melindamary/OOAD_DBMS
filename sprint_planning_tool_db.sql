CREATE DATABASE  IF NOT EXISTS `sprint_planning_tool_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `sprint_planning_tool_db`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: sprint_planning_tool_db
-- ------------------------------------------------------
-- Server version	8.0.35

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `backlog`
--

DROP TABLE IF EXISTS `backlog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `backlog` (
  `backlog_id` int NOT NULL AUTO_INCREMENT,
  `project_id` int NOT NULL,
  `created_by` int DEFAULT NULL,
  `created_date` date DEFAULT NULL,
  `updated_by` int DEFAULT NULL,
  `updated_date` date DEFAULT NULL,
  `description` text,
  PRIMARY KEY (`backlog_id`),
  KEY `project_id` (`project_id`),
  KEY `created_by` (`created_by`),
  KEY `updated_by` (`updated_by`),
  CONSTRAINT `backlog_ibfk_1` FOREIGN KEY (`project_id`) REFERENCES `project` (`project_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `backlog_ibfk_2` FOREIGN KEY (`created_by`) REFERENCES `employee` (`employee_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `backlog_ibfk_3` FOREIGN KEY (`updated_by`) REFERENCES `employee` (`employee_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `backlog`
--

LOCK TABLES `backlog` WRITE;
/*!40000 ALTER TABLE `backlog` DISABLE KEYS */;
INSERT INTO `backlog` VALUES (1,1,1,'2024-04-15',1,'2024-04-15','Research current website design trends.'),(2,2,2,'2024-04-20',1,'2024-04-20','Design UI/UX wireframes for mobile app.'),(3,3,3,'2024-04-25',1,'2024-04-25','Identify CRM software options for integration.'),(4,4,4,'2024-05-01',1,'2024-05-01','Gather requirements for e-commerce platform upgrade.'),(5,5,5,'2024-05-05',1,'2024-05-05','Define key performance indicators for data analytics dashboard.'),(6,6,NULL,'2024-05-03',NULL,NULL,NULL);
/*!40000 ALTER TABLE `backlog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `employee_id` int NOT NULL AUTO_INCREMENT,
  `employee_firstname` varchar(30) NOT NULL,
  `employee_lastname` varchar(30) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(20) NOT NULL,
  `created_by` int DEFAULT NULL,
  `created_date` date DEFAULT NULL,
  `updated_by` int DEFAULT NULL,
  `updated_date` date DEFAULT NULL,
  PRIMARY KEY (`employee_id`),
  KEY `created_by` (`created_by`),
  KEY `updated_by` (`updated_by`),
  CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`created_by`) REFERENCES `employee` (`employee_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `employee_ibfk_2` FOREIGN KEY (`updated_by`) REFERENCES `employee` (`employee_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'John','Doe','john.doe@example.com','pass@123',1,'2024-05-03',1,'2024-05-03'),(2,'Alice','Smith','alice.smith@example.com','al!ce#123',1,'2024-05-03',1,'2024-05-03'),(3,'Bob','Johnson','bob.johnson@example.com','b0b!456',1,'2024-05-03',1,'2024-05-03'),(4,'Emma','Brown','emma.brown@example.com','emma@789',1,'2024-05-03',1,'2024-05-03'),(5,'Michael','Wilson','michael.wilson@example.com','m!ch@3l',1,'2024-05-03',1,'2024-05-03');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `epic`
--

DROP TABLE IF EXISTS `epic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `epic` (
  `epic_id` int NOT NULL AUTO_INCREMENT,
  `backlog_id` int NOT NULL,
  `epic_name` varchar(30) NOT NULL,
  `created_by` int DEFAULT NULL,
  `created_date` date DEFAULT NULL,
  `updated_by` int DEFAULT NULL,
  `updated_date` date DEFAULT NULL,
  `description` text,
  PRIMARY KEY (`epic_id`),
  KEY `backlog_id` (`backlog_id`),
  KEY `created_by` (`created_by`),
  KEY `updated_by` (`updated_by`),
  CONSTRAINT `epic_ibfk_1` FOREIGN KEY (`backlog_id`) REFERENCES `backlog` (`backlog_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `epic_ibfk_2` FOREIGN KEY (`created_by`) REFERENCES `employee` (`employee_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `epic_ibfk_3` FOREIGN KEY (`updated_by`) REFERENCES `employee` (`employee_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `epic`
--

LOCK TABLES `epic` WRITE;
/*!40000 ALTER TABLE `epic` DISABLE KEYS */;
INSERT INTO `epic` VALUES (1,1,'Revamp Homepage',1,'2024-04-15',1,'2024-04-15','Redesign the homepage to improve user engagement.'),(2,2,'User Registration',2,'2024-04-20',1,'2024-04-20','Implement user registration functionality in the app.'),(3,3,'Customer Data Integration',3,'2024-04-25',1,'2024-04-25','Integrate customer data from CRM into the system.'),(4,4,'Payment Gateway Upgrade',4,'2024-05-01',1,'2024-05-01','Upgrade payment gateway for better security and functionality.'),(5,5,'Real-time Data Visualization',5,'2024-05-05',1,'2024-05-05','Develop real-time data visualization features for the dashboard.');
/*!40000 ALTER TABLE `epic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project`
--

DROP TABLE IF EXISTS `project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `project` (
  `project_id` int NOT NULL AUTO_INCREMENT,
  `project_name` varchar(30) NOT NULL,
  `created_by` int DEFAULT NULL,
  `created_date` date DEFAULT NULL,
  `updated_by` int DEFAULT NULL,
  `updated_date` date DEFAULT NULL,
  `description` text,
  PRIMARY KEY (`project_id`),
  KEY `created_by` (`created_by`),
  KEY `updated_by` (`updated_by`),
  CONSTRAINT `project_ibfk_1` FOREIGN KEY (`created_by`) REFERENCES `employee` (`employee_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `project_ibfk_2` FOREIGN KEY (`updated_by`) REFERENCES `employee` (`employee_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project`
--

LOCK TABLES `project` WRITE;
/*!40000 ALTER TABLE `project` DISABLE KEYS */;
INSERT INTO `project` VALUES (1,'Website Redesign',1,'2024-04-15',1,'2024-04-20','Redesigning the company website for better user experience.'),(2,'Mobile App Development',2,'2024-04-20',1,'2024-04-25','Developing a new mobile app for iOS and Android platforms.'),(3,'CRM Integration',3,'2024-04-25',1,'2024-04-30','Integrating customer relationship management software.'),(4,'E-commerce Platform Upgrade',4,'2024-05-01',1,'2024-05-05','Upgrading the existing e-commerce platform with new features.'),(5,'Data Analytics Dashboard',5,'2024-05-05',1,'2024-05-10','Building a dashboard for data analytics and visualization.'),(6,'Healthcare App',1,'2024-05-03',1,'2024-05-03','Health care app for hospital');
/*!40000 ALTER TABLE `project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sprint`
--

DROP TABLE IF EXISTS `sprint`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sprint` (
  `sprint_id` int NOT NULL AUTO_INCREMENT,
  `project_id` int NOT NULL,
  `start_date` date NOT NULL,
  `end_date` date NOT NULL,
  `goal` text,
  `created_by` int DEFAULT NULL,
  `created_date` date DEFAULT NULL,
  `updated_by` int DEFAULT NULL,
  `updated_date` date DEFAULT NULL,
  PRIMARY KEY (`sprint_id`),
  KEY `project_id` (`project_id`),
  KEY `created_by` (`created_by`),
  KEY `updated_by` (`updated_by`),
  CONSTRAINT `sprint_ibfk_1` FOREIGN KEY (`project_id`) REFERENCES `project` (`project_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `sprint_ibfk_2` FOREIGN KEY (`created_by`) REFERENCES `employee` (`employee_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `sprint_ibfk_3` FOREIGN KEY (`updated_by`) REFERENCES `employee` (`employee_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sprint`
--

LOCK TABLES `sprint` WRITE;
/*!40000 ALTER TABLE `sprint` DISABLE KEYS */;
INSERT INTO `sprint` VALUES (1,1,'2024-04-15','2024-04-30','Complete wireframes and design mockups',1,'2024-04-15',1,'2024-04-15'),(2,2,'2024-04-20','2024-05-05','Develop user registration functionality',2,'2024-04-20',1,'2024-04-20'),(3,3,'2024-04-25','2024-05-10','Integrate CRM data into the system',3,'2024-04-25',1,'2024-04-25'),(4,4,'2024-05-01','2024-05-15','Upgrade payment gateway and test transactions',4,'2024-05-01',1,'2024-05-01'),(5,5,'2024-05-05','2024-05-20','Implement real-time data visualization features',5,'2024-05-05',1,'2024-05-05'),(6,1,'2024-05-10','2024-05-30','Complete remaining modules',NULL,'2024-05-03',NULL,NULL);
/*!40000 ALTER TABLE `sprint` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_story`
--

DROP TABLE IF EXISTS `user_story`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_story` (
  `story_id` int NOT NULL AUTO_INCREMENT,
  `epic_id` int NOT NULL,
  `sprint_id` int DEFAULT NULL,
  `assignee_id` int DEFAULT NULL,
  `description` text NOT NULL,
  `story_points` int DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  `created_by` int DEFAULT NULL,
  `created_date` date DEFAULT NULL,
  `updated_by` int DEFAULT NULL,
  `updated_date` date DEFAULT NULL,
  PRIMARY KEY (`story_id`),
  KEY `epic_id` (`epic_id`),
  KEY `sprint_id` (`sprint_id`),
  KEY `assignee_id` (`assignee_id`),
  KEY `created_by` (`created_by`),
  KEY `updated_by` (`updated_by`),
  CONSTRAINT `user_story_ibfk_1` FOREIGN KEY (`epic_id`) REFERENCES `epic` (`epic_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user_story_ibfk_2` FOREIGN KEY (`sprint_id`) REFERENCES `sprint` (`sprint_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user_story_ibfk_3` FOREIGN KEY (`assignee_id`) REFERENCES `employee` (`employee_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user_story_ibfk_4` FOREIGN KEY (`created_by`) REFERENCES `employee` (`employee_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user_story_ibfk_5` FOREIGN KEY (`updated_by`) REFERENCES `employee` (`employee_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_story`
--

LOCK TABLES `user_story` WRITE;
/*!40000 ALTER TABLE `user_story` DISABLE KEYS */;
INSERT INTO `user_story` VALUES (1,1,6,1,'Design new layout and structure for homepage',8,'To Do',1,'2024-04-15',1,'2024-04-15'),(2,2,1,2,'Implement user registration form with validation',5,'In Progress',2,'2024-04-20',1,'2024-04-20'),(3,3,2,3,'Fetch customer data from CRM API',13,'Done',3,'2024-04-25',1,'2024-04-25'),(4,4,2,4,'Upgrade payment gateway to support new features',8,'In Progress',4,'2024-05-01',1,'2024-05-01'),(5,5,3,5,'Implement real-time data visualization charts',13,'To Do',5,'2024-05-05',1,'2024-05-05'),(6,1,NULL,1,'Redesign the layout',NULL,NULL,NULL,'2024-05-03',NULL,NULL);
/*!40000 ALTER TABLE `user_story` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-07 11:48:02
