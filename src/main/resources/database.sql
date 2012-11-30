-- MySQL dump 10.13  Distrib 5.5.15, for Win32 (x86)
--
-- Host: localhost    Database: mackenzie
-- ------------------------------------------------------
-- Server version	5.5.15

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
-- Table structure for table `cases`
--

DROP TABLE IF EXISTS `cases`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cases` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `subject` varchar(255) NOT NULL,
  `description` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cases`
--

LOCK TABLES `cases` WRITE;
/*!40000 ALTER TABLE `cases` DISABLE KEYS */;
INSERT INTO `cases` VALUES (1,'Yoky','Empresário do ramo alimentício foi friamente esquartejado em seu apartamento de luxo. Há suspeitas de crime passional, pois o empresário estava tendo um relacionamento extra conjugal e havia ameaçado sua esposa de tomar a guarda do filho do casal.'),(2,'Quem matou Max','O vilão e malandro da novela das oito: Max foi assassinado nas mediações de um Lixão. O corpo foi encontrado com ferimentos na cabeça. Existem vários suspeitos do assassinato já que Max possuía vários inimigos.'),(3,'Flamengo','Bruno jogador no flamengo é suspeito de ter matado sua namorada Elisa. Bruno possui antecedentes criminais e há suspeita de sua participação no tráfico de drogas. O corpo da moça está desaparecido.');
/*!40000 ALTER TABLE `cases` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `locations`
--

DROP TABLE IF EXISTS `locations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `locations` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `caseId` int(11) NOT NULL,
  `energy` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_location_case` (`caseId`),
  CONSTRAINT `fk_location_case` FOREIGN KEY (`caseId`) REFERENCES `cases` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `locations`
--

LOCK TABLES `locations` WRITE;
/*!40000 ALTER TABLE `locations` DISABLE KEYS */;
INSERT INTO `locations` VALUES (1,'Sala de Estar',1,29),(2,'Quarto',1,33),(3,'Cozinha',1,15),(4,'Lixão',2,56),(5,'Barraco',2,43),(6,'Varanda',3,47),(7,'Quintal',3,61);
/*!40000 ALTER TABLE `locations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `player`
--

DROP TABLE IF EXISTS `player`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `player` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(128) NOT NULL,
  `password` varchar(255) NOT NULL,
  `caseOpen` int(11) DEFAULT NULL,
  `xp` int(10) unsigned NOT NULL DEFAULT '0',
  `labProcessStart` datetime DEFAULT NULL,
  `labProcessEnd` datetime DEFAULT NULL,
  `energy` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_player_case` (`caseOpen`),
  CONSTRAINT `fk_player_case` FOREIGN KEY (`caseOpen`) REFERENCES `cases` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `player`
--

LOCK TABLES `player` WRITE;
/*!40000 ALTER TABLE `player` DISABLE KEYS */;
INSERT INTO `player` VALUES (1,'csi','a2a20311145545e816805093629f27c6',NULL,0,NULL,NULL,100);
/*!40000 ALTER TABLE `player` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `players`
--

DROP TABLE IF EXISTS `players`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `players` (
  `id` int(11) NOT NULL,
  `caseOpen` int(11) DEFAULT NULL,
  `labProcessEnd` date DEFAULT NULL,
  `labProcessStart` date DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `xp` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `players`
--

LOCK TABLES `players` WRITE;
/*!40000 ALTER TABLE `players` DISABLE KEYS */;
/*!40000 ALTER TABLE `players` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rplayercases`
--

DROP TABLE IF EXISTS `rplayercases`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rplayercases` (
  `player` int(11) NOT NULL,
  `case` int(11) NOT NULL,
  `solved` tinyint(1) NOT NULL,
  KEY `fk_player` (`player`),
  KEY `fk_case` (`case`),
  CONSTRAINT `fk_case` FOREIGN KEY (`case`) REFERENCES `cases` (`id`),
  CONSTRAINT `fk_player` FOREIGN KEY (`player`) REFERENCES `player` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rplayercases`
--

LOCK TABLES `rplayercases` WRITE;
/*!40000 ALTER TABLE `rplayercases` DISABLE KEYS */;
/*!40000 ALTER TABLE `rplayercases` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rplayertraces`
--

DROP TABLE IF EXISTS `rplayertraces`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rplayertraces` (
  `player` int(11) NOT NULL,
  `trace` int(11) NOT NULL,
  `processed` tinyint(1) NOT NULL,
  PRIMARY KEY (`player`,`trace`),
  KEY `fk_rpt_trace` (`trace`),
  CONSTRAINT `fk_rpt_player` FOREIGN KEY (`player`) REFERENCES `player` (`id`),
  CONSTRAINT `fk_rpt_trace` FOREIGN KEY (`trace`) REFERENCES `traces` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rplayertraces`
--

LOCK TABLES `rplayertraces` WRITE;
/*!40000 ALTER TABLE `rplayertraces` DISABLE KEYS */;
INSERT INTO `rplayertraces` VALUES (1,1,0),(1,2,0);
/*!40000 ALTER TABLE `rplayertraces` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `traces`
--

DROP TABLE IF EXISTS `traces`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `traces` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `caseId` int(11) NOT NULL,
  `locationId` int(11) NOT NULL,
  `name` varchar(128) NOT NULL,
  `xp` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `fk_trace_case` (`caseId`),
  KEY `fk_trace_location` (`locationId`),
  CONSTRAINT `fk_trace_case` FOREIGN KEY (`caseId`) REFERENCES `cases` (`id`),
  CONSTRAINT `fk_trace_location` FOREIGN KEY (`locationId`) REFERENCES `locations` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `traces`
--

LOCK TABLES `traces` WRITE;
/*!40000 ALTER TABLE `traces` DISABLE KEYS */;
INSERT INTO `traces` VALUES (1,1,1,'Revólver',10),(2,1,1,'Cartucho de Bala',5),(3,1,2,'Malas',15),(4,1,2,'Fitas de Video',17),(5,1,3,'Faca Guinso',8),(6,1,3,'Pipocas Yoki',11),(7,2,4,'Pedaço de madeira',7),(8,2,4,'Revólver',9),(9,2,5,'Faca',13),(10,2,5,'Batom Carmim',6),(11,3,6,'Rolo de Macarrão',10),(12,3,6,'Faca',7),(13,3,6,'Pacote de Cocaina',20),(14,3,7,'Cachorros Pit Bull',18),(15,3,7,'Pedaço de tecido',2);
/*!40000 ALTER TABLE `traces` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `ID` bigint(20) NOT NULL,
  `DATA_INSERCAO` date DEFAULT NULL,
  `LOGIN` varchar(255) DEFAULT NULL,
  `SENHA` varchar(255) DEFAULT NULL,
  `DATA_ATUALIZACAO` date DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,NULL,'admin','e10adc3949ba59abbe56e057f20f883e',NULL);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2012-11-30 17:10:51
