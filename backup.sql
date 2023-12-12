-- MySQL dump 10.13  Distrib 8.0.35, for Linux (x86_64)
--
-- Host: localhost    Database: blog_spring_boot
-- ------------------------------------------------------
-- Server version	8.0.35-0ubuntu0.22.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categories` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` VALUES (1,'Backend');
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comments`
--

DROP TABLE IF EXISTS `comments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comments` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `publication_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKlpjwqhvr0p7e7x1u9efvaq6xe` (`publication_id`),
  CONSTRAINT `FKlpjwqhvr0p7e7x1u9efvaq6xe` FOREIGN KEY (`publication_id`) REFERENCES `publications` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comments`
--

LOCK TABLES `comments` WRITE;
/*!40000 ALTER TABLE `comments` DISABLE KEYS */;
/*!40000 ALTER TABLE `comments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `publications`
--

DROP TABLE IF EXISTS `publications`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `publications` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `content` text CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `created_at` date NOT NULL,
  `picture` varchar(255) DEFAULT NULL,
  `title` varchar(255) NOT NULL,
  `category_id` bigint NOT NULL,
  `user_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKsmhm05xkihi2tonhsl484x15m` (`title`),
  KEY `FK75xnhl48vv4ma0gh4e49es8ji` (`category_id`),
  KEY `FK2utvp9h7ybh77dgki0cfw52c1` (`user_id`),
  CONSTRAINT `FK2utvp9h7ybh77dgki0cfw52c1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `FK75xnhl48vv4ma0gh4e49es8ji` FOREIGN KEY (`category_id`) REFERENCES `categories` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `publications`
--

LOCK TABLES `publications` WRITE;
/*!40000 ALTER TABLE `publications` DISABLE KEYS */;
INSERT INTO `publications` VALUES (1,'why i have description and content? i think is for the title and subtitle','2023-10-10','','test de mi entrada',1,1),(2,'Wtf why i have comments?','2023-10-11','','The benefit of chat gpt',1,1),(4,'Wtf why i have comments?','2023-10-11','','The benefit of chat gpt 2',1,1),(5,'Wtf why i have comments?','2023-10-15','','The benefit of chat gpt 3',1,1),(6,'Wtf why i have comments?','2023-10-15','','The benefit of chat gpt 4',1,1),(7,'Wtf why i have comments?','2023-10-15','','The benefit of chat gpt 5',1,1),(8,'Wtf why i have comments?','2023-10-15','','The benefit of chat gpt 6',1,1),(9,'Wtf why i have comments?','2023-10-16','','The benblblblb',1,1),(10,'here my love just follow all the signs','2023-10-19','','baby i have to spend some time alone',1,1),(11,'here my love just follow all the signs','2023-10-19','','baby i have to ',1,1),(12,'Wtf why i have comments?','2023-10-19','','to the starts, runnig in circles chasing up tails',1,1),(13,'The SOLID principles are a set of design principles that help software developers create more maintainable, scalable, and flexible software systems. These principles were introduced by Robert C. Martin and are widely used in object-oriented programming. The SOLID acronym stands for:\n\nSingle Responsibility Principle (SRP):\n\nA class should have only one reason to change, meaning that it should have only one responsibility or job.\nThis principle encourages you to design classes that do one thing and do it well.\nOpen/Closed Principle (OCP):\n\nSoftware entities (classes, modules, functions, etc.) should be open for extension but closed for modification.\nYou should be able to add new functionality without altering existing code.\nLiskov Substitution Principle (LSP):\n\nObjects of a superclass should be replaceable with objects of a subclass without affecting the correctness of the program.\nThis principle ensures that a derived class can substitute its base class without any unexpected behavior.\nInterface Segregation Principle (ISP):\n\nA class should not be forced to implement interfaces it does not use.\nThis principle encourages the creation of specific, client-focused interfaces rather than general-purpose interfaces.\nDependency Inversion Principle (DIP):\n\nHigh-level modules should not depend on low-level modules. Both should depend on abstractions.\nAbstractions should not depend on details. Details should depend on abstractions.\nThis principle promotes the use of dependency injection and inversion of control to decouple components.','2023-10-20','','SOLID JAVA',1,1),(16,'The SOLID principles are a set of design principles that help software developers create more maintainable, scalable, and flexible software systems. These principles were introduced by Robert C. Martin and are widely used in object-oriented programming. The SOLID acronym stands for:\n\nSingle Responsibility Principle (SRP):\n\nA class should have only one reason to change, meaning that it should have only one responsibility or job.\nThis principle encourages you to design classes that do one thing and do it well.\nOpen/Closed Principle (OCP):\n\nSoftware entities (classes, modules, functions, etc.) should be open for extension but closed for modification.\nYou should be able to add new functionality without altering existing code.\nLiskov Substitution Principle (LSP):\n\nObjects of a superclass should be replaceable with objects of a subclass without affecting the correctness of the program.\nThis principle ensures that a derived class can substitute its base class without any unexpected behavior.\nInterface Segregation Principle (ISP):\n\nA class should not be forced to implement interfaces it does not use.\nThis principle encourages the creation of specific, client-focused interfaces rather than general-purpose interfaces.\nDependency Inversion Principle (DIP):\n\nHigh-level modules should not depend on low-level modules. Both should depend on abstractions.\nAbstractions should not depend on details. Details should depend on abstractions.\nThis principle promotes the use of dependency injection and inversion of control to decouple components.\n\nObjects of a superclass should be replaceable with objects of a subclass without affecting the correctness of the program.\nThis principle ensures that a derived class can substitute its base class without any unexpected behavior.\nInterface Segregation Principle (ISP):\n\nA class should not be forced to implement interfaces it does not use.\nThis principle encourages the creation of specific, client-focused interfaces rather than general-purpose interfaces.\nDependency Inversion Principle (DIP):\n\nHigh-level modules should not depend on low-level modules. Both should depend on abstractions.\nAbstractions should not depend on details. Details should depend on abstractions.\nThis principle promotes the use of dependency injection and inversion of control to decouple components.\nObjects of a superclass should be replaceable with objects of a subclass without affecting the correctness of the program.\nThis principle ensures that a derived class can substitute its base class without any unexpected behavior.\nInterface Segregation Principle (ISP):\n\nA class should not be forced to implement interfaces it does not use.\nThis principle encourages the creation of specific, client-focused interfaces rather than general-purpose interfaces.\nDependency Inversion Principle (DIP):\n\nHigh-level modules should not depend on low-level modules. Both should depend on abstractions.\nAbstractions should not depend on details. Details should depend on abstractions.\nThis principle promotes the use of dependency injection and inversion of control to decouple components.','2023-10-20','','SOLID JAVAsd',1,1),(17,'<p> fdf wewe<strong> dsdwe <em>ewewe <u>dsdsd</u></em></strong></p>','2023-11-09','','fucking partner',1,1),(18,'<p>rferertertert</p>','2023-11-13','','bvbvbvbvbvbvbvbvb',1,1),(19,'<p>jijja</p>','2023-11-13','','Hasta que me olvides',1,1),(20,'<p>ffeefefsdfsdf <strong> fsdfsdfsdfsdfsdfsdf <u>fsdfsdfsdfsdfdsfsdfsdfdsf</u></strong></p>','2023-11-13','','huevosputois',1,1),(21,'<p>ffeefefsdfsdf <strong> fsdfsdfsdfsdfsdfsdf <u>fsdfsdfsdfsdfdsfsdfsdfdsffdgdfgdfg</u></strong></p>','2023-11-13','','huevosputoisdfgfdgdfg',1,1),(22,'<p>why i do not care about ..........</p>','2023-11-13','','bla bla bla',1,1),(23,'<p>sdfsdfs5d56+fs565df65sd</p>','2023-11-13','','877897878789879',1,1),(24,'<p>vsdfsdfd45sfd456f</p>','2023-11-13','','frf9f8989fds',1,1),(25,'<p>gfgre8rg87gfd21g</p>','2023-11-13','','gsdf8dfs5f5dfds21f21d3s',1,1),(27,'Wtf why i have commentsgfdfsd?','2023-11-15','','to the starts, runnig in circles chasing ffefsdfsdfup tails',1,1),(28,'<p>ta ta tat at at at ta ta ta ta</p>','2023-12-01','','i did it with JWT',1,1);
/*!40000 ALTER TABLE `publications` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_rol`
--

DROP TABLE IF EXISTS `user_rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_rol` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `rol_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKfqs9ho7na1vm6kf9fkp712q6v` (`rol_id`),
  KEY `FK3xg2nuaohq3m1jidxctddln2j` (`user_id`),
  CONSTRAINT `FK3xg2nuaohq3m1jidxctddln2j` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `FKfqs9ho7na1vm6kf9fkp712q6v` FOREIGN KEY (`rol_id`) REFERENCES `roles` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_rol`
--

LOCK TABLES `user_rol` WRITE;
/*!40000 ALTER TABLE `user_rol` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `create_at` datetime DEFAULT NULL,
  `email` varchar(60) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_6dotkott2kjsp8vw4d0m25fb7` (`email`),
  UNIQUE KEY `UKr43af9ap4edm43mmtq01oddj6` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'2023-10-10 22:28:22','ferramirez@gmail.com','Ramirez','Fernando','2468',NULL,NULL),(2,'2023-11-15 21:00:28','ferenc@gmail.com','enca','fer',NULL,'huevos','ADMIN'),(6,'2023-11-15 21:02:29','ferendfc@gmail.com','enca','fer',NULL,'huevosdf','ADMIN'),(7,'2023-11-15 21:04:08','dafaq@gmail.com','dafaq','fer',NULL,'dafaq','ADMIN'),(8,'2023-11-15 21:05:17','sumadre@gmail.com','dafaq','fer',NULL,'PUTE','ADMIN'),(9,'2023-11-15 21:07:31','jejejeje@gmail.com','dafaq','fer','puto','jijijija','ADMIN'),(10,'2023-11-15 21:09:26','lastnamen@gmail.com','dafaq','fer','$2a$10$7hoHDU92q0Hhxg8jpQrERuWovNML58r85m.89GRWQaMV1F2SMg9Xq','lastnamen','ADMIN'),(11,'2023-11-15 21:16:05','fertrix@gmail.com','dafaq','fer','$2a$10$aQ0xWT0sz/sknvhXg2Lvn.XFeTnO/6n5X29wRjBXYdLXrr6YZ2.Ni','fertrix','ADMIN'),(12,'2023-11-15 21:39:55','fertrixx@gmail.com','dafaq','fer','$2a$10$HpJ7PxQY.INYMYP3DzlX2.84Q/EjLlfSQ70G3up5g6l.WPVu/ZtWK','fertrixx','ADMIN');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-11 21:49:10
