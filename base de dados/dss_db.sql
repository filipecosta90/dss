-- MySQL dump 10.13  Distrib 5.7.10, for osx10.11 (x86_64)
--
-- Host: localhost    Database: dss
-- ------------------------------------------------------
-- Server version	5.7.9

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
-- Table structure for table `cidadao`
--

DROP TABLE IF EXISTS `cidadao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cidadao` (
  `cc` int(11) NOT NULL,
  `nome` varchar(80) NOT NULL,
  `password` varchar(80) NOT NULL,
  `permissaoAdmin` tinyint(1) DEFAULT '0',
  `permissaoRR` tinyint(1) DEFAULT '0',
  `permissaoVotoAntecipado` tinyint(1) DEFAULT '0',
  `jaVotou` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`cc`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cidadao`
--

LOCK TABLES `cidadao` WRITE;
/*!40000 ALTER TABLE `cidadao` DISABLE KEYS */;
INSERT INTO `cidadao` VALUES (6,'Filipe Oliveira','filipecosta',0,0,1,1),(73,'Daniela Silva','merkel',0,1,1,0),(77,'Fernanda Alves','nani',0,0,0,1),(92,'Bruno Henriques','bruno',1,0,1,1);
/*!40000 ALTER TABLE `cidadao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `eleicao`
--

DROP TABLE IF EXISTS `eleicao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `eleicao` (
  `tipo` varchar(80) DEFAULT NULL,
  `marcadaPorRR` int(11) DEFAULT NULL,
  `dataEleicao` date NOT NULL,
  `marcada` tinyint(1) DEFAULT '0',
  `iniciada` tinyint(1) DEFAULT '0',
  `terminada` tinyint(1) DEFAULT '0',
  `publicadoResultado` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`dataEleicao`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eleicao`
--

LOCK TABLES `eleicao` WRITE;
/*!40000 ALTER TABLE `eleicao` DISABLE KEYS */;
INSERT INTO `eleicao` VALUES ('Eleições Presidenciais',73,'2016-10-04',0,0,0,0);
/*!40000 ALTER TABLE `eleicao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lista`
--

DROP TABLE IF EXISTS `lista`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lista` (
  `partidoPolitico` varchar(80) NOT NULL,
  `candidatos` varchar(256) NOT NULL,
  `uninominal` tinyint(1) DEFAULT '0',
  `plurinominal` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`partidoPolitico`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lista`
--

LOCK TABLES `lista` WRITE;
/*!40000 ALTER TABLE `lista` DISABLE KEYS */;
INSERT INTO `lista` VALUES ('ps','92',0,1),('psd','123,6',0,1),('voto branco','',0,0);
/*!40000 ALTER TABLE `lista` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mapaVotos`
--

DROP TABLE IF EXISTS `mapaVotos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mapaVotos` (
  `partidoPolitico` varchar(80) NOT NULL,
  `totalVotos` int(11) DEFAULT '0',
  PRIMARY KEY (`partidoPolitico`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mapaVotos`
--

LOCK TABLES `mapaVotos` WRITE;
/*!40000 ALTER TABLE `mapaVotos` DISABLE KEYS */;
INSERT INTO `mapaVotos` VALUES ('ps',5),('psd',6),('voto branco',8);
/*!40000 ALTER TABLE `mapaVotos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-12-30 22:30:47
