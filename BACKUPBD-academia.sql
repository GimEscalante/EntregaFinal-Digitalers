CREATE DATABASE  IF NOT EXISTS `academia` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `academia`; 
-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: academia
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.28-MariaDB

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
-- Table structure for table `contactos`
--

DROP TABLE IF EXISTS `contactos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contactos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ciudad` varchar(80) NOT NULL,
  `codigo_postal` varchar(255) NOT NULL,
  `direccion` varchar(80) DEFAULT NULL,
  `email` varchar(40) DEFAULT NULL,
  `provincia` varchar(80) DEFAULT NULL,
  `telefono` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contactos`
--

LOCK TABLES `contactos` WRITE;
/*!40000 ALTER TABLE `contactos` DISABLE KEYS */;
INSERT INTO `contactos` VALUES (1,'Santa Fe','3001','San Martín 1234','gimemail1@gmail.com','Santa Fe','03424356123'),(2,'Parana','3100','Rondeau 3421','marigon@gmail.com','Entre Ríos','03431234322'),(3,'Mendoza','5500','Bulevar Abierto 012','leorobl0@gmail.com','Mendoza','1145678901'),(4,'La plata','1900','Callejon cerrado 789','victord@gmail.com','Buenos Aires','1156789012'),(5,'Córdoba','5000','Avenida Siempreviva 456','bautimor@gmail.com','Córdoba','1134567890');
/*!40000 ALTER TABLE `contactos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cursos`
--

DROP TABLE IF EXISTS `cursos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cursos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(80) NOT NULL,
  `fk_instructor` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKeul64s9jkged9jvu46ie3aif8` (`fk_instructor`),
  CONSTRAINT `FKeul64s9jkged9jvu46ie3aif8` FOREIGN KEY (`fk_instructor`) REFERENCES `instructores` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cursos`
--

LOCK TABLES `cursos` WRITE;
/*!40000 ALTER TABLE `cursos` DISABLE KEYS */;
INSERT INTO `cursos` VALUES (1,'SQL Avanzado',1),(2,'HTML desde cero',2),(3,'CSS intermedio',4),(4,'REACT JS',3),(5,'JAVASCRIPT intermedio',5);
/*!40000 ALTER TABLE `cursos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estudiante_curso`
--

DROP TABLE IF EXISTS `estudiante_curso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estudiante_curso` (
  `fk_estudiante` int(11) DEFAULT NULL,
  `fk_curso` int(11) DEFAULT NULL,
  KEY `FKr7cg2ge4bjujqsc48thagca0f` (`fk_curso`),
  KEY `FKgfhn7v7t4y6xsat93rfi1d9oc` (`fk_estudiante`),
  CONSTRAINT `FKgfhn7v7t4y6xsat93rfi1d9oc` FOREIGN KEY (`fk_estudiante`) REFERENCES `estudiantes` (`id`),
  CONSTRAINT `FKr7cg2ge4bjujqsc48thagca0f` FOREIGN KEY (`fk_curso`) REFERENCES `cursos` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estudiante_curso`
--

LOCK TABLES `estudiante_curso` WRITE;
/*!40000 ALTER TABLE `estudiante_curso` DISABLE KEYS */;
INSERT INTO `estudiante_curso` VALUES (1,1),(2,2),(3,2),(4,3),(5,4);
/*!40000 ALTER TABLE `estudiante_curso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estudiantes`
--

DROP TABLE IF EXISTS `estudiantes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estudiantes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(25) NOT NULL,
  `apellido` varchar(25) NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `fk_contacto` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKdo84jxurkqtvreyfbuitir4ag` (`fk_contacto`),
  CONSTRAINT `FKdo84jxurkqtvreyfbuitir4ag` FOREIGN KEY (`fk_contacto`) REFERENCES `contactos` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estudiantes`
--

LOCK TABLES `estudiantes` WRITE;
/*!40000 ALTER TABLE `estudiantes` DISABLE KEYS */;
INSERT INTO `estudiantes` VALUES (1,'Gimena','Escalante','2000-08-30',1),(2,'Maria','Gonzalez','1968-12-15',2),(3,'Leonel','Robledo','2002-03-03',3),(4,'Victor','Diaz','1997-08-25',4),(5,'Bautista','Morel','2003-07-24',5);
/*!40000 ALTER TABLE `estudiantes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `instructores`
--

DROP TABLE IF EXISTS `instructores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `instructores` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `apellido` varchar(25) DEFAULT NULL,
  `nombre` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `instructores`
--

LOCK TABLES `instructores` WRITE;
/*!40000 ALTER TABLE `instructores` DISABLE KEYS */;
INSERT INTO `instructores` VALUES (1,'Zeballos','Francisco'),(2,'Gonzalez','Rodrigo'),(3,'Caceres','Martina'),(4,'Lopez','Raul'),(5,'Juarez','Luis');
/*!40000 ALTER TABLE `instructores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'academia'
--

--
-- Dumping routines for database 'academia'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-10-27 19:34:11
