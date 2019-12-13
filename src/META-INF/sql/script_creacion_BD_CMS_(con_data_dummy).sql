CREATE DATABASE  IF NOT EXISTS `CardManagementSystem` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_danish_ci */;
USE `CardManagementSystem`;
-- MySQL dump 10.13  Distrib 5.5.62, for debian-linux-gnu (x86_64)
--
-- Host: 192.168.3.34    Database: CardManagementSystem
-- ------------------------------------------------------
-- Server version 5.5.62-0ubuntu0.14.04.1

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
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `edificationTypeId` int(11) NOT NULL,
  `nameEdification` varchar(50) DEFAULT NULL,
  `tower` varchar(40) DEFAULT NULL,
  `floor` int(11) DEFAULT NULL,
  `streetTypeId` int(11) NOT NULL,
  `nameStreet` varchar(40) DEFAULT NULL,
  `urbanization` varchar(50) DEFAULT NULL,
  `cityId` int(11) NOT NULL,
  `zipZoneId` int(11) NOT NULL,
  `countryId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_address_edificationType1_idx` (`edificationTypeId`),
  KEY `fk_address_streetType1_idx` (`streetTypeId`),
  KEY `fk_address_cities1_idx` (`cityId`),
  KEY `fk_address_zipZone1_idx` (`zipZoneId`),
  KEY `fk_address_country1_idx` (`countryId`),
  CONSTRAINT `fk_address_cities1` FOREIGN KEY (`cityId`) REFERENCES `city` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_address_country1` FOREIGN KEY (`countryId`) REFERENCES `country` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_address_edificationType1` FOREIGN KEY (`edificationTypeId`) REFERENCES `edificationType` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_address_streetType1` FOREIGN KEY (`streetTypeId`) REFERENCES `streetType` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_address_zipZone1` FOREIGN KEY (`zipZoneId`) REFERENCES `zipZone` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `allowedChannels`
--

DROP TABLE IF EXISTS `allowedChannels`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `allowedChannels` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `channel_id` int(11) NOT NULL,
  `product_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `product_id` (`product_id`),
  KEY `fk_allowedChannels_channel1_idx` (`channel_id`),
  KEY `fk_allowedChannels_product1_idx` (`product_id`),
  CONSTRAINT `fk_allowedChannels_channel1` FOREIGN KEY (`channel_id`) REFERENCES `channel` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_allowedChannels_product1` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_danish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `allowedChannels`
--

LOCK TABLES `allowedChannels` WRITE;
/*!40000 ALTER TABLE `allowedChannels` DISABLE KEYS */;
/*!40000 ALTER TABLE `allowedChannels` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `applicantNaturalPerson`
--

DROP TABLE IF EXISTS `applicantNaturalPerson`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `applicantNaturalPerson` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `personId` bigint(20) NOT NULL,
  `identificationNumber` varchar(40) COLLATE utf8_danish_ci NOT NULL,
  `dueDateDocumentIdentification` date DEFAULT NULL,
  `identificationNumberOld` varchar(40) COLLATE utf8_danish_ci DEFAULT NULL,
  `firstNames` varchar(40) COLLATE utf8_danish_ci NOT NULL,
  `lastNames` varchar(40) COLLATE utf8_danish_ci NOT NULL,
  `marriedLastName` varchar(40) COLLATE utf8_danish_ci DEFAULT NULL,
  `gender` varchar(1) COLLATE utf8_danish_ci NOT NULL,
  `placeBirth` varchar(45) COLLATE utf8_danish_ci NOT NULL,
  `dateBirth` date NOT NULL,
  `familyResponsibilities` int(11) DEFAULT NULL,
  `civilStatusId` int(11) NOT NULL,
  `professionId` int(11) NOT NULL,
  `createDate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updateDate` timestamp NULL DEFAULT NULL,
  `applicantParentId` bigint(20) DEFAULT NULL,
  `kinShipApplicantId` int(11) DEFAULT NULL,
  `documentsPersonTypeId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `fk_naturalPerson_civilStatus1_idx` (`civilStatusId`),
  KEY `fk_naturalPerson_professions1_idx` (`professionId`),
  KEY `fk_naturalPerson_person1_idx` (`personId`),
  KEY `fk_applicant_applicant1_idx` (`applicantParentId`),
  KEY `fk_applicant_kinShipApplicant1_idx` (`kinShipApplicantId`),
  KEY `personId` (`personId`),
  KEY `fk_applicantNaturalPerson_documentsPersonType1` (`documentsPersonTypeId`),
  CONSTRAINT `fk_applicant_applicant1` FOREIGN KEY (`applicantParentId`) REFERENCES `applicantNaturalPerson` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_applicant_kinShipApplicant1` FOREIGN KEY (`kinShipApplicantId`) REFERENCES `kinShipApplicant` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_naturalPerson_civilStatus10` FOREIGN KEY (`civilStatusId`) REFERENCES `civilStatus` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_naturalPerson_person10` FOREIGN KEY (`personId`) REFERENCES `person` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_naturalPerson_professions10` FOREIGN KEY (`professionId`) REFERENCES `profession` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_danish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `applicantNaturalPerson`
--

LOCK TABLES `applicantNaturalPerson` WRITE;
/*!40000 ALTER TABLE `applicantNaturalPerson` DISABLE KEYS */;
INSERT INTO `applicantNaturalPerson` VALUES (1,1,'9489777','2019-10-20','','Pedro','Gómez','','M','Caracas','2019-11-11',4,1,1,'0000-00-00 00:00:00','0000-00-00 00:00:00',NULL,0,1),(8,2,'10125896','2019-10-20','','Juan','Gómez','','M','Caracas','2019-09-02',0,1,0,'0000-00-00 00:00:00','0000-00-00 00:00:00',1,3,1);
/*!40000 ALTER TABLE `applicantNaturalPerson` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `applicantType`
--

DROP TABLE IF EXISTS `applicantType`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `applicantType` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(40) COLLATE utf8_danish_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_danish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `applicantType`
--

LOCK TABLES `applicantType` WRITE;
/*!40000 ALTER TABLE `applicantType` DISABLE KEYS */;
/*!40000 ALTER TABLE `applicantType` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `averageCargeUsage`
--

DROP TABLE IF EXISTS `averageCargeUsage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `averageCargeUsage` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `year` int(11) DEFAULT NULL,
  `averageSpendMonth` float DEFAULT NULL,
  `averageLoadMonth` float DEFAULT NULL,
  `programId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_averageCargeUsage_program1_idx` (`programId`),
  CONSTRAINT `fk_averageCargeUsage_program1` FOREIGN KEY (`programId`) REFERENCES `program` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_danish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `averageCargeUsage`
--

LOCK TABLES `averageCargeUsage` WRITE;
/*!40000 ALTER TABLE `averageCargeUsage` DISABLE KEYS */;
/*!40000 ALTER TABLE `averageCargeUsage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `binSponsor`
--

DROP TABLE IF EXISTS `binSponsor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `binSponsor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(25) COLLATE utf8_danish_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_danish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `binSponsor`
--

LOCK TABLES `binSponsor` WRITE;
/*!40000 ALTER TABLE `binSponsor` DISABLE KEYS */;
INSERT INTO `binSponsor` VALUES (1,'VISA'),(2,'MASTER CARD'),(3,'DINNERS'),(4,'AMEX'),(5,'DISCOVER'),(6,'CABAL');
/*!40000 ALTER TABLE `binSponsor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cardIssuanceType`
--

DROP TABLE IF EXISTS `cardIssuanceType`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cardIssuanceType` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(40) COLLATE utf8_danish_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_danish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cardIssuanceType`
--

LOCK TABLES `cardIssuanceType` WRITE;
/*!40000 ALTER TABLE `cardIssuanceType` DISABLE KEYS */;
INSERT INTO `cardIssuanceType` VALUES (1,'Emisión Instantánea Solamente'),(2,'Emisión Instantánea seguida de Personali'),(3,'Personalizada Solamente');
/*!40000 ALTER TABLE `cardIssuanceType` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cardRequest`
--

DROP TABLE IF EXISTS `cardRequest`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cardRequest` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `request_id` bigint(20) NOT NULL,
  `product_id` bigint(20) NOT NULL,
  `cardStatus_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `product_id` (`product_id`),
  KEY `fk_cardRequest_request1_idx` (`request_id`),
  KEY `fk_cardRequest_product2_idx` (`product_id`),
  KEY `fk_cardRequest_cardStatus1_idx` (`cardStatus_id`),
  CONSTRAINT `fk_cardRequest_cardStatus1` FOREIGN KEY (`cardStatus_id`) REFERENCES `cardStatus` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_cardRequest_product2` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_cardRequest_request1` FOREIGN KEY (`request_id`) REFERENCES `request` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_danish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cardRequest`
--

LOCK TABLES `cardRequest` WRITE;
/*!40000 ALTER TABLE `cardRequest` DISABLE KEYS */;
/*!40000 ALTER TABLE `cardRequest` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cardRequestNaturalPerson`
--

DROP TABLE IF EXISTS `cardRequestNaturalPerson`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cardRequestNaturalPerson` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `person_id` bigint(20) NOT NULL,
  `legalPerson_id` bigint(20) NOT NULL,
  `firstNames` varchar(40) COLLATE utf8_danish_ci DEFAULT NULL,
  `lastNames` varchar(40) COLLATE utf8_danish_ci DEFAULT NULL,
  `identificationNumber` varchar(40) COLLATE utf8_danish_ci DEFAULT NULL,
  `positionEnterprise` varchar(50) COLLATE utf8_danish_ci DEFAULT NULL,
  `proposedLimit` float DEFAULT NULL,
  `documentsPersonTypeId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_cardRequestNaturalPerson_person1_idx` (`person_id`),
  KEY `fk_cardRequestNaturalPerson_legalPerson1_idx` (`legalPerson_id`),
  KEY `fk_cardRequestNaturalPerson_documentsPersonType1` (`documentsPersonTypeId`),
  KEY `person_id` (`person_id`),
  CONSTRAINT `fk_cardRequestNaturalPerson_documentsPersonType1` FOREIGN KEY (`documentsPersonTypeId`) REFERENCES `documentsPersonType` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_cardRequestNaturalPerson_legalPerson1` FOREIGN KEY (`legalPerson_id`) REFERENCES `legalPerson` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_cardRequestNaturalPerson_person1` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_danish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cardRequestNaturalPerson`
--

LOCK TABLES `cardRequestNaturalPerson` WRITE;
/*!40000 ALTER TABLE `cardRequestNaturalPerson` DISABLE KEYS */;
/*!40000 ALTER TABLE `cardRequestNaturalPerson` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cardStatus`
--

DROP TABLE IF EXISTS `cardStatus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cardStatus` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(45) COLLATE utf8_danish_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_danish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cardStatus`
--

LOCK TABLES `cardStatus` WRITE;
/*!40000 ALTER TABLE `cardStatus` DISABLE KEYS */;
/*!40000 ALTER TABLE `cardStatus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cardType`
--

DROP TABLE IF EXISTS `cardType`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cardType` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(45) COLLATE utf8_danish_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_danish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cardType`
--

LOCK TABLES `cardType` WRITE;
/*!40000 ALTER TABLE `cardType` DISABLE KEYS */;
/*!40000 ALTER TABLE `cardType` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `channel`
--

DROP TABLE IF EXISTS `channel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `channel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) COLLATE utf8_danish_ci DEFAULT NULL,
  `description` varchar(160) COLLATE utf8_danish_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_danish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `channel`
--

LOCK TABLES `channel` WRITE;
/*!40000 ALTER TABLE `channel` DISABLE KEYS */;
/*!40000 ALTER TABLE `channel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `city` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `stateId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_cities_states1_idx` (`stateId`),
  CONSTRAINT `fk_cities_states1` FOREIGN KEY (`stateId`) REFERENCES `state` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` VALUES (1,'ACANAÑA',1),(2,'MACURUCU',1),(3,'ATAPIRIRE',2),(4,'CANTAURA',2),(5,'ALABASTER',3),(6,'ALBERTVILLE',3);
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `civilStatus`
--

DROP TABLE IF EXISTS `civilStatus`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `civilStatus` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(45) COLLATE utf8_danish_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_danish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `civilStatus`
--

LOCK TABLES `civilStatus` WRITE;
/*!40000 ALTER TABLE `civilStatus` DISABLE KEYS */;
INSERT INTO `civilStatus` VALUES (1,'Soltero'),(2,'Casado'),(3,'Divorciado'),(4,'Viudo');
/*!40000 ALTER TABLE `civilStatus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `collectionsRequest`
--

DROP TABLE IF EXISTS `collectionsRequest`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `collectionsRequest` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) COLLATE utf8_danish_ci DEFAULT NULL,
  `countryId` int(11) NOT NULL,
  `productTypeId` int(11) NOT NULL,
  `programId` bigint(20) NOT NULL,
  `personTypeId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_collectionsRequest_country1_idx` (`countryId`),
  KEY `fk_collectionsRequest_productType1_idx` (`productTypeId`),
  KEY `fk_collectionsRequest_program1_idx` (`programId`),
  KEY `fk_collectionsRequest_personType1_idx` (`personTypeId`),
  CONSTRAINT `fk_collectionsRequest_country1` FOREIGN KEY (`countryId`) REFERENCES `country` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_collectionsRequest_personType1` FOREIGN KEY (`personTypeId`) REFERENCES `personType` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_collectionsRequest_productType1` FOREIGN KEY (`productTypeId`) REFERENCES `productType` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_collectionsRequest_program1` FOREIGN KEY (`programId`) REFERENCES `program` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_danish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `collectionsRequest`
--

LOCK TABLES `collectionsRequest` WRITE;
/*!40000 ALTER TABLE `collectionsRequest` DISABLE KEYS */;
/*!40000 ALTER TABLE `collectionsRequest` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `commerceCategory`
--

DROP TABLE IF EXISTS `commerceCategory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `commerceCategory` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mccCode` varchar(4) COLLATE utf8_danish_ci DEFAULT NULL,
  `countryId` int(11) NOT NULL,
  `segmentId` int(11) NOT NULL,
  `economicActivityId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_commerceCategory_country1_idx` (`countryId`),
  KEY `fk_commerceCategory_segment1_idx` (`segmentId`),
  KEY `fk_commerceCategory_economicActivity1_idx` (`economicActivityId`),
  CONSTRAINT `fk_commerceCategory_country1` FOREIGN KEY (`countryId`) REFERENCES `country` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_commerceCategory_economicActivity1` FOREIGN KEY (`economicActivityId`) REFERENCES `economicActivity` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_commerceCategory_segment1` FOREIGN KEY (`segmentId`) REFERENCES `segment` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_danish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commerceCategory`
--

LOCK TABLES `commerceCategory` WRITE;
/*!40000 ALTER TABLE `commerceCategory` DISABLE KEYS */;
/*!40000 ALTER TABLE `commerceCategory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `country`
--

DROP TABLE IF EXISTS `country`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `country` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(3) COLLATE utf8_danish_ci DEFAULT NULL,
  `code_iso2` varchar(2) COLLATE utf8_danish_ci DEFAULT NULL,
  `code_iso3` varchar(3) COLLATE utf8_danish_ci DEFAULT NULL,
  `name` varchar(60) COLLATE utf8_danish_ci DEFAULT NULL,
  `currency_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_country_currency1_idx` (`currency_id`),
  CONSTRAINT `fk_country_currency1` FOREIGN KEY (`currency_id`) REFERENCES `currency` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=167 DEFAULT CHARSET=utf8 COLLATE=utf8_danish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `country`
--

LOCK TABLES `country` WRITE;
/*!40000 ALTER TABLE `country` DISABLE KEYS */;
INSERT INTO `country` VALUES (1,'58','VE','VEN','VENEZUELA',1),(2,'1','US','USA','ESTADOS UNIDOS',2),(3,'93','AF','AFG','AFGANISTÁN',2),(4,'355','AL','ALB','ALBANIA',2),(5,'49','DE','DEU','ALEMANIA',2),(6,'376','AD','AND','ANDORRA',2),(7,'244','AO','AGO','ANGOLA',2),(8,'126','AI','AIA','ANGUILA',2),(9,'126','AG','ATG','ANTIGUA',2),(10,'599','AN','ANT','ANTILLAS HOLANDESAS',2),(11,'672','','','ANTÁRTICA',2),(12,'966','SA','SAU','ARABIA SAUDITA',2),(13,'21','DZ','DZA','ARGELIA',2),(14,'374','AM','ARM','ARMENIA',2),(15,'297','AW','ABW','ARUBA',2),(16,'61','AU','AUS','AUSTRALIA',2),(17,'43','AT','AUT','AUSTRIA',2),(18,'994','AZ','AZE','AZERBAIJAN',2),(19,'124','BS','BHS','BAHAMAS',2),(20,'973','BH','BHR','BAHRAIN',2),(21,'880','BD','BGD','BANGLADESH',2),(22,'124','BB','BRB','BARBADOS',2),(23,'501','BZ','BLZ','BELICE',2),(24,'809','BM','BMU','BERMUDA',2),(25,'591','BO','BOL','BOLIVIA',2),(26,'55','BR','BRA','BRASIL',2),(27,'359','BG','BGR','BULGARIA',2),(28,'226','BF','BFA','BURKINA FASO',2),(29,'32','BE','BEL','BÉLGICA',2),(30,'855','KH','KHM','CAMBOYA',2),(31,'1','CA','CAF','CANADÁ',2),(32,'56','CL','CHL','CHILE',2),(33,'86','CN','CHN','CHINA',2),(34,'357','CY','CYP','CHIPRE',2),(35,'82','KO','KOR','COREA',2),(36,'506','CR','CRC','COSTA RICA',2),(37,'385','HR','HRV','CROACIA',2),(38,'53','CU','CUB','CUBA',2),(39,'45','DK','DNK','DINAMARCA',2),(40,'767','DM','DOM','DOMINICA',2),(41,'20','EG','EGY','EGIPTO',2),(42,'503','SV','SLV','EL SALVADOR',2),(43,'971','AE','ARE','EMIRATOS ÁRABES UNIDOS',2),(44,'34','ES','ESP','ESPAÑA',2),(45,'372','EE','EST','ESTONIA',2),(46,'358','FI','FIN','FINLANDIA',2),(47,'33','FR','FRA','FRANCIA',2),(48,'241','GA','GAB','GABÓN',2),(49,'30','GR','GRC','GRECIA',2),(50,'590','GP','GLP','GUADALUPE',2),(51,'502','GT','GTM','GUATEMALA',2),(52,'592','GY','GUY','GUYANA',2),(53,'594','GU','GUF','GUYANA FRANCESA',2),(54,'509','HT','HTI','HAITÍ',2),(55,'31','NL','NLD','HOLANDA',2),(56,'504','HN','HND','HONDURAS',2),(57,'852','HK','HKG','HONG KONG',2),(58,'36','HU','HUN','HUNGRÍA',2),(59,'91','IN','IND','INDIA',2),(60,'246','','','INDIAS BRITÁNICAS',2),(61,'62','ID','IDN','INDONESIA',2),(62,'44','','','INGLATERRA',2),(63,'964','IQ','IRQ','IRAK',2),(64,'353','IE','IRL','IRLANDA',2),(65,'354','IS','ISL','ISLANDIA',2),(66,'1','KY','KYM','ISLAS CAIMÁN',2),(67,'1','','','ISLAS PERIFÉRICAS DE LOS E.U.A',2),(68,'1','VI','VIR','ISLAS VÍRGENES',2),(69,'1','VG','VGB','ISLAS VÍRGENES BRITÁNICAS',2),(70,'972','IL','ISR','ISRAEL',2),(71,'39','IT','ITA','ITALIA',2),(72,'1','JM','JAM','JAMAICA',2),(73,'81','JP','JPN','JAPÓN',2),(74,'962','JO','JOR','JORDANIA',2),(75,'254','KE','KEN','KENYA',2),(76,'371','LV','LVA','LETONIA',2),(77,'352','LU','LUX','LUXEMBURGO',2),(78,'961','LB','LBN','LÍBANO',2),(79,'60','MY','MYS','MALASIA',2),(80,'212','MA','MAR','MARRUECOS',2),(81,'691','FM','FSM','MICRONESIA',2),(82,'52','MX','MEX','MÉXICO',2),(83,'377','MC','MCO','MÓNACO',2),(84,'505','NI','NIC','NICARAGUA',2),(85,'234','NG','NGA','NIGERIA',2),(86,'47','NO','NOR','NORUEGA',2),(87,'64','NZ','NZL','NUEVA ZELANDA',2),(88,'968','OM','OMN','OMÁN',2),(89,'92','PK','PAK','PAKISTÁN',2),(90,'507','PA','PAN','PANAMÁ',2),(91,'675','PG','PNG','PAPÚA/NUEVA GUINEA',2),(92,'595','PY','PRY','PARAGUAY',2),(93,'51','PE','PER','PERÚ',2),(94,'48','PL','POL','POLONIA',2),(95,'351','PT','PRT','PORTUGAL',2),(96,'178','PR','PRI','PUERTO RICO',2),(97,'44','GB','GBR','REINO UNIDO',2),(98,'420','CZ','CZE','REPÚBLICA CHECA',2),(99,'1','DO','DOM','REPÚBLICA DOMINICANA',2),(100,'40','RO','ROU','RUMANIA',2),(101,'7','RU','RUS','RUSIA',2),(102,'685','WS','WSM','SAMOA',2),(103,'684','AS','ASM','SAMOA AMERICANA',2),(104,'784','VC','VCT','SAN VICENTE Y LAS GRANADINAS',2),(105,'65','SG','SGP','SINGAPUR',2),(106,'27','ZA','ZAF','SUDÁFRICA',2),(107,'46','SE','SWE','SUECIA',2),(108,'41','CH','CHE','SUIZA',2),(109,'597','SR','SUR','SURINAM',2),(110,'66','TH','THA','TAILANDIA',2),(111,'886','TW','TWN','TAIWÁN',2),(112,'868','TT','TTO','TRINIDAD Y TOBAGO',2),(113,'90','TR','TUR','TURQUÍA',2),(114,'380','UA','UKR','UCRANIA',2),(115,'256','UG','UGA','UGANDA',2),(116,'598','UY','URY','URUGUAY',2),(117,'678','VU','VUT','VANUATU',2),(118,'396','VA','VAT','VATICANO',2),(119,'84','VN','VNM','VIETNAM',2),(120,'263','ZW','ZWE','ZIMBABWE',2),(121,'242','CO','COD','CONGO',2),(122,'63','PH','PHL','FILIPINAS',2),(123,'233','GH','GHA','GHANA',2),(124,'224','GN','GIN','GUINEA',2),(125,'245','GN','GNB','GUINEA BISSAU',2),(126,'240','GQ','GNQ','GUINEA ECUATORIAL',2),(127,'856','LO','LAO','LAOS',2),(128,'231','LR','LBR','LIBERIA',2),(129,'261','MG','MDG','MADAGASCAR',2),(130,'223','ML','MLI','MALI',2),(131,'258','MZ','MOZ','MOZAMBIQUE',2),(132,'227','NE','NER','NIGER',2),(133,'930','PS','PSE','PALESTINA',2),(134,'236','CF','CAF','REPUBLICA CENTROAFRICANA',2),(135,'243','CD','COD','REPUBLICA DEMOCRATICA DEL CONGO',2),(136,'221','SN','SEN','SENEGAL',2),(137,'963','SY','SYR','SIRIA',2),(138,'249','SD','SDN','SUDAN',2),(139,'216','TN','TUN','TUNEZ',2),(140,'967','YE','YEM','YEMEN',2),(141,'257','BI','BDI','BURUNDI',2),(142,'237','CM','CMR','CAMEROON',2),(143,'679','FJ','FJI','FIJI',2),(144,'1','GD','GRD','GRENADA',2),(145,'225','CI','CIV','COSTA DE MARFIL',2),(146,'7','KA','KAZ','KAZAKHSTAN',2),(147,'664','MS','MSR','MONTSERRAT',2),(148,'977','NP','NPL','NEPAL',2),(149,'250','RW','RWA','RWANDA',2),(150,'252','SO','SOM','SOMALIA',2),(151,'94','LK','LKA','SRI LANKA',2),(152,'1','KN','KNA','SAINT KITTS AND NEVIS',2),(153,'1','LC','LCA','SAINT LUCIA',2),(154,'255','TZ','TZA','TANZANIA',2),(155,'164','TC','TCA','TURKS AND CAICOS',2),(156,'260','ZM','ZMB','ZAMBIA',2),(157,'229','BE','BEN','BENIN',2),(158,'220','GM','GMB','GAMBIA',2),(159,'228','TG','TGO','TOGO',2),(160,'268','SZ','SWZ','SWAZILAND',2),(161,'599','CB','CUW','CURACAO',2),(162,'965','KW','KWT','KUWAIT',2),(163,'373','MD','MDA','MOLDOVA',2),(164,'674','NR','NRU','NAURU',2),(165,'232','SL','SLE','SIERRA LEONE',2),(166,'676','TO','TON','TONGA',2);
/*!40000 ALTER TABLE `country` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `currency`
--

DROP TABLE IF EXISTS `currency`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `currency` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8_danish_ci DEFAULT NULL,
  `symbol` varchar(45) COLLATE utf8_danish_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_danish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `currency`
--

LOCK TABLES `currency` WRITE;
/*!40000 ALTER TABLE `currency` DISABLE KEYS */;
INSERT INTO `currency` VALUES (1,'Bolívar','Bs.'),(2,'Dolar','USD'),(3,'Dolar','USD'),(4,'Euros','€');
/*!40000 ALTER TABLE `currency` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `documentType`
--

DROP TABLE IF EXISTS `documentType`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `documentType` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) COLLATE utf8_danish_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_danish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `documentType`
--

LOCK TABLES `documentType` WRITE;
/*!40000 ALTER TABLE `documentType` DISABLE KEYS */;
INSERT INTO `documentType` VALUES (1,'REQUEST');
/*!40000 ALTER TABLE `documentType` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `documentsPersonType`
--

DROP TABLE IF EXISTS `documentsPersonType`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `documentsPersonType` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(80) COLLATE utf8_danish_ci DEFAULT NULL,
  `personTypeId` int(11) NOT NULL,
  `codeIdentificationNumber` varchar(10) COLLATE utf8_danish_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_subPersonType_personType1_idx` (`personTypeId`),
  CONSTRAINT `fk_subPersonType_personType1` FOREIGN KEY (`personTypeId`) REFERENCES `personType` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_danish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `documentsPersonType`
--

LOCK TABLES `documentsPersonType` WRITE;
/*!40000 ALTER TABLE `documentsPersonType` DISABLE KEYS */;
INSERT INTO `documentsPersonType` VALUES (1,'Venezolano',1,'V'),(2,'Extranjero',1,NULL),(3,'Capital Asociado',2,NULL),(4,'Sociedad Anónima',2,NULL),(5,'Fundación',2,NULL),(6,'Cédula de Identidad',1,NULL),(7,'Pasaporte',1,NULL),(8,'Registro de Información Fiscal',2,'J');
/*!40000 ALTER TABLE `documentsPersonType` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `economicActivity`
--

DROP TABLE IF EXISTS `economicActivity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `economicActivity` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(10) COLLATE utf8_danish_ci DEFAULT NULL,
  `description` varchar(45) COLLATE utf8_danish_ci DEFAULT NULL,
  `countryId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_economicActivity_country1_idx` (`countryId`),
  CONSTRAINT `fk_economicActivity_country1` FOREIGN KEY (`countryId`) REFERENCES `country` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_danish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `economicActivity`
--

LOCK TABLES `economicActivity` WRITE;
/*!40000 ALTER TABLE `economicActivity` DISABLE KEYS */;
/*!40000 ALTER TABLE `economicActivity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `edificationType`
--

DROP TABLE IF EXISTS `edificationType`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `edificationType` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(40) COLLATE utf8_danish_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_danish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `edificationType`
--

LOCK TABLES `edificationType` WRITE;
/*!40000 ALTER TABLE `edificationType` DISABLE KEYS */;
INSERT INTO `edificationType` VALUES (1,'Casa'),(2,'Quinta'),(3,'Edificio'),(4,'Residencia'),(5,'Villa'),(6,'Chalet'),(7,'Duplex');
/*!40000 ALTER TABLE `edificationType` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `familyReferences`
--

DROP TABLE IF EXISTS `familyReferences`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `familyReferences` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `firstNames` varchar(40) COLLATE utf8_danish_ci DEFAULT NULL,
  `applicantNaturalPersonId` bigint(20) NOT NULL,
  `city` varchar(50) COLLATE utf8_danish_ci DEFAULT NULL,
  `localPhone` varchar(30) COLLATE utf8_danish_ci DEFAULT NULL,
  `cellPhone` varchar(30) COLLATE utf8_danish_ci DEFAULT NULL,
  `lastNames` varchar(40) COLLATE utf8_danish_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_familyReferences_applicantNaturalPerson1` (`applicantNaturalPersonId`),
  CONSTRAINT `fk_familyReferences_applicantNaturalPerson1` FOREIGN KEY (`applicantNaturalPersonId`) REFERENCES `applicantNaturalPerson` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_danish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `familyReferences`
--

LOCK TABLES `familyReferences` WRITE;
/*!40000 ALTER TABLE `familyReferences` DISABLE KEYS */;
/*!40000 ALTER TABLE `familyReferences` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `issuer`
--

DROP TABLE IF EXISTS `issuer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `issuer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `countryId` int(11) NOT NULL,
  `name` varchar(100) COLLATE utf8_danish_ci DEFAULT NULL,
  `issuerTypeId` bigint(20) NOT NULL,
  `documentIdentification` varchar(40) COLLATE utf8_danish_ci DEFAULT NULL,
  `binNumber` int(11) DEFAULT NULL,
  `swiftCode` varchar(20) COLLATE utf8_danish_ci DEFAULT NULL,
  `abaCode` varchar(20) COLLATE utf8_danish_ci DEFAULT NULL,
  `contractNumber` varchar(40) COLLATE utf8_danish_ci DEFAULT NULL,
  `contactPersonId` bigint(20) NOT NULL,
  `statusActive` tinyint(4) DEFAULT NULL,
  `issuerPersonId` bigint(20) NOT NULL,
  `webSite` varchar(80) COLLATE utf8_danish_ci DEFAULT NULL,
  `faxNumber` varchar(40) COLLATE utf8_danish_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `contactPersonId` (`contactPersonId`),
  UNIQUE KEY `issuerPersonId` (`issuerPersonId`),
  KEY `fk_issuer_country1_idx` (`countryId`),
  KEY `fk_Issuer_Issuer_Type1_idx` (`issuerTypeId`),
  KEY `fk_issuer_person1_idx` (`issuerPersonId`),
  KEY `fk_issuer_person2_idx` (`contactPersonId`),
  CONSTRAINT `fk_issuer_country1` FOREIGN KEY (`countryId`) REFERENCES `country` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Issuer_Issuer_Type1` FOREIGN KEY (`issuerTypeId`) REFERENCES `issuerType` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_issuer_person1` FOREIGN KEY (`issuerPersonId`) REFERENCES `person` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_issuer_person2` FOREIGN KEY (`contactPersonId`) REFERENCES `person` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_danish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `issuer`
--

LOCK TABLES `issuer` WRITE;
/*!40000 ALTER TABLE `issuer` DISABLE KEYS */;
INSERT INTO `issuer` VALUES (1,1,'Banco Mercantil',1,NULL,NULL,NULL,NULL,NULL,2,NULL,1,NULL,NULL);
/*!40000 ALTER TABLE `issuer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `issuerType`
--

DROP TABLE IF EXISTS `issuerType`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `issuerType` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(40) COLLATE utf8_danish_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_danish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `issuerType`
--

LOCK TABLES `issuerType` WRITE;
/*!40000 ALTER TABLE `issuerType` DISABLE KEYS */;
INSERT INTO `issuerType` VALUES (1,'Entidad Bancaria'),(2,'Persona Jurídica');
/*!40000 ALTER TABLE `issuerType` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kinShipApplicant`
--

DROP TABLE IF EXISTS `kinShipApplicant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kinShipApplicant` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(20) COLLATE utf8_danish_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_danish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kinShipApplicant`
--

LOCK TABLES `kinShipApplicant` WRITE;
/*!40000 ALTER TABLE `kinShipApplicant` DISABLE KEYS */;
INSERT INTO `kinShipApplicant` VALUES (1,'Hijo'),(2,'Padre'),(3,'Madre'),(4,'Abuelo'),(5,'Abuela');
/*!40000 ALTER TABLE `kinShipApplicant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kindCard`
--

DROP TABLE IF EXISTS `kindCard`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kindCard` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(20) COLLATE utf8_danish_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_danish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kindCard`
--

LOCK TABLES `kindCard` WRITE;
/*!40000 ALTER TABLE `kindCard` DISABLE KEYS */;
/*!40000 ALTER TABLE `kindCard` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `legalPerson`
--

DROP TABLE IF EXISTS `legalPerson`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `legalPerson` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `personId` bigint(20) NOT NULL,
  `tradeName` varchar(60) COLLATE utf8_danish_ci DEFAULT NULL,
  `enterpriseName` varchar(45) COLLATE utf8_danish_ci DEFAULT NULL,
  `dateInscriptionRegister` date DEFAULT NULL,
  `registerNumber` varchar(45) COLLATE utf8_danish_ci DEFAULT NULL,
  `payedCapital` float DEFAULT NULL,
  `enterprisePhone` varchar(30) COLLATE utf8_danish_ci DEFAULT NULL,
  `webSite` varchar(45) COLLATE utf8_danish_ci DEFAULT NULL,
  `economicActivityId` int(11) NOT NULL,
  `documentsPersonTypeId` int(11) NOT NULL,
  `identificationNumber` varchar(40) COLLATE utf8_danish_ci NOT NULL,
  `codeIdentificationNumber` varchar(10) COLLATE utf8_danish_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `personId` (`personId`),
  KEY `fk_legalPerson_person1_idx` (`personId`),
  KEY `fk_enterpriseProgramaOwner_economicActivity1_idx` (`economicActivityId`),
  KEY `fk_legalPerson_documentsPersonType1` (`documentsPersonTypeId`),
  CONSTRAINT `fk_enterpriseProgramaOwner_economicActivity1` FOREIGN KEY (`economicActivityId`) REFERENCES `economicActivity` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_legalPerson_documentsPersonType1` FOREIGN KEY (`documentsPersonTypeId`) REFERENCES `documentsPersonType` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_legalPerson_person1` FOREIGN KEY (`personId`) REFERENCES `person` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_danish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `legalPerson`
--

LOCK TABLES `legalPerson` WRITE;
/*!40000 ALTER TABLE `legalPerson` DISABLE KEYS */;
/*!40000 ALTER TABLE `legalPerson` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `legalPersonHasLegalRepresentatives`
--

DROP TABLE IF EXISTS `legalPersonHasLegalRepresentatives`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `legalPersonHasLegalRepresentatives` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `legalPersonId` bigint(20) NOT NULL,
  `legalRepresentatives_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_legalRepresentativesProgramaOwner_enterpriseProgramaOwne_idx` (`legalPersonId`),
  KEY `fk_legalRepresentativesProgramaOwner_legalRepresentatives1_idx` (`legalRepresentatives_id`),
  CONSTRAINT `fk_legalRepresentativesProgramaOwner_enterpriseProgramaOwner1` FOREIGN KEY (`legalPersonId`) REFERENCES `legalPerson` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_legalRepresentativesProgramaOwner_legalRepresentatives1` FOREIGN KEY (`legalRepresentatives_id`) REFERENCES `legalRepresentatives` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_danish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `legalPersonHasLegalRepresentatives`
--

LOCK TABLES `legalPersonHasLegalRepresentatives` WRITE;
/*!40000 ALTER TABLE `legalPersonHasLegalRepresentatives` DISABLE KEYS */;
/*!40000 ALTER TABLE `legalPersonHasLegalRepresentatives` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `legalRepresentatives`
--

DROP TABLE IF EXISTS `legalRepresentatives`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `legalRepresentatives` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `personId` bigint(20) NOT NULL,
  `firstNames` varchar(40) COLLATE utf8_danish_ci DEFAULT NULL,
  `lastNames` varchar(40) COLLATE utf8_danish_ci DEFAULT NULL,
  `identificationNumber` varchar(40) COLLATE utf8_danish_ci DEFAULT NULL,
  `identificationNumberOld` varchar(40) COLLATE utf8_danish_ci DEFAULT NULL,
  `dueDateDocumentIdentification` date DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `gender` varchar(1) COLLATE utf8_danish_ci DEFAULT NULL,
  `placeBirth` varchar(45) COLLATE utf8_danish_ci DEFAULT NULL,
  `dateBirth` date DEFAULT NULL,
  `codeIdentificationNumber` varchar(10) COLLATE utf8_danish_ci DEFAULT NULL,
  `documentsPersonTypeId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_legalRepresentatives_persons1_idx` (`personId`),
  KEY `fk_legalRepresentatives_documentsPersonType1` (`documentsPersonTypeId`),
  KEY `personsId` (`personId`),
  CONSTRAINT `fk_legalRepresentatives_persons1` FOREIGN KEY (`personId`) REFERENCES `person` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_legalRepresentatives_documentsPersonType1` FOREIGN KEY (`documentsPersonTypeId`) REFERENCES `documentsPersonType` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_danish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `legalRepresentatives`
--

LOCK TABLES `legalRepresentatives` WRITE;
/*!40000 ALTER TABLE `legalRepresentatives` DISABLE KEYS */;
/*!40000 ALTER TABLE `legalRepresentatives` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `levelProduct`
--

DROP TABLE IF EXISTS `levelProduct`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `levelProduct` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(45) COLLATE utf8_danish_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_danish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `levelProduct`
--

LOCK TABLES `levelProduct` WRITE;
/*!40000 ALTER TABLE `levelProduct` DISABLE KEYS */;
/*!40000 ALTER TABLE `levelProduct` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `naturalPerson`
--

DROP TABLE IF EXISTS `naturalPerson`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `naturalPerson` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `personId` bigint(20) NOT NULL,
  `identificationNumber` varchar(40) COLLATE utf8_danish_ci DEFAULT NULL,
  `dueDateDocumentIdentification` date DEFAULT NULL,
  `identificationNumberOld` varchar(40) COLLATE utf8_danish_ci DEFAULT NULL,
  `firstNames` varchar(40) COLLATE utf8_danish_ci DEFAULT NULL,
  `lastNames` varchar(40) COLLATE utf8_danish_ci DEFAULT NULL,
  `marriedLastName` varchar(40) COLLATE utf8_danish_ci DEFAULT NULL,
  `gender` varchar(1) COLLATE utf8_danish_ci DEFAULT NULL,
  `placeBirth` varchar(45) COLLATE utf8_danish_ci DEFAULT NULL,
  `dateBirth` date DEFAULT NULL,
  `familyResponsibilities` int(11) DEFAULT NULL,
  `civilStatusId` int(11) NOT NULL,
  `professionId` int(11) NOT NULL,
  `createDate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updateDate` timestamp NULL DEFAULT NULL,
  `documentsPersonTypeId` int(11) NOT NULL,
  `codeIdentificationNumber` varchar(10) COLLATE utf8_danish_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `personId` (`personId`),
  KEY `fk_naturalPerson_civilStatus1_idx` (`civilStatusId`),
  KEY `fk_naturalPerson_professions1_idx` (`professionId`),
  KEY `fk_naturalPerson_person1_idx` (`personId`),
  KEY `fk_naturalPerson_documentsPersonType1` (`documentsPersonTypeId`),
  CONSTRAINT `fk_naturalPerson_civilStatus1` FOREIGN KEY (`civilStatusId`) REFERENCES `civilStatus` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_naturalPerson_documentsPersonType1` FOREIGN KEY (`documentsPersonTypeId`) REFERENCES `documentsPersonType` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_naturalPerson_person1` FOREIGN KEY (`personId`) REFERENCES `person` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_naturalPerson_professions1` FOREIGN KEY (`professionId`) REFERENCES `profession` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_danish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `naturalPerson`
--

LOCK TABLES `naturalPerson` WRITE;
/*!40000 ALTER TABLE `naturalPerson` DISABLE KEYS */;
/*!40000 ALTER TABLE `naturalPerson` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `network`
--

DROP TABLE IF EXISTS `network`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `network` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8_danish_ci DEFAULT NULL,
  `countryId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_network_country1_idx` (`countryId`),
  CONSTRAINT `fk_network_country1` FOREIGN KEY (`countryId`) REFERENCES `country` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_danish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `network`
--

LOCK TABLES `network` WRITE;
/*!40000 ALTER TABLE `network` DISABLE KEYS */;
/*!40000 ALTER TABLE `network` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `originApplication`
--

DROP TABLE IF EXISTS `originApplication`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `originApplication` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8_danish_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_danish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `originApplication`
--

LOCK TABLES `originApplication` WRITE;
/*!40000 ALTER TABLE `originApplication` DISABLE KEYS */;
INSERT INTO `originApplication` VALUES (1,'Card Management System'),(2,'Wallet APP');
/*!40000 ALTER TABLE `originApplication` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `person` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `countryId` int(11) NOT NULL,
  `email` varchar(60) COLLATE utf8_danish_ci DEFAULT NULL,
  `createDate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updateDate` timestamp NULL DEFAULT NULL,
  `personClassificationId` int(11) NOT NULL,
  `personTypeId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `fk_programOwner_country1_idx` (`countryId`),
  KEY `fk_person_personClassification1_idx` (`personClassificationId`),
  KEY `fk_person_personType1` (`personTypeId`),
  CONSTRAINT `fk_person_personClassification1` FOREIGN KEY (`personClassificationId`) REFERENCES `personClassification` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_person_personType1` FOREIGN KEY (`personTypeId`) REFERENCES `personType` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_programOwner_country1` FOREIGN KEY (`countryId`) REFERENCES `country` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_danish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES (1,1,NULL,'2019-11-18 20:56:55',NULL,1,2),(2,1,NULL,'2019-11-18 20:56:55',NULL,6,1),(3,1,NULL,'2019-11-18 20:56:55',NULL,3,1),(4,1,NULL,'2019-11-18 20:56:55',NULL,2,1);
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personClassification`
--

DROP TABLE IF EXISTS `personClassification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `personClassification` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(40) COLLATE utf8_danish_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_danish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personClassification`
--

LOCK TABLES `personClassification` WRITE;
/*!40000 ALTER TABLE `personClassification` DISABLE KEYS */;
INSERT INTO `personClassification` VALUES (1,'Issuer'),(2,'Card Manager Program'),(3,'Program Owner'),(4,'Applicant'),(5,'Legal Representatives'),(6,'Persona Contacto Emisor'),(8,'Persona Natural Tarjetas Complementarias');
/*!40000 ALTER TABLE `personClassification` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personHasAddress`
--

DROP TABLE IF EXISTS `personHasAddress`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `personHasAddress` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `addressId` int(11) NOT NULL,
  `personId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `person_id` (`personId`),
  KEY `fk_personAddress_address1_idx` (`addressId`),
  KEY `fk_personAddress_person1_idx` (`personId`),
  CONSTRAINT `fk_personAddress_address1` FOREIGN KEY (`addressId`) REFERENCES `address` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_personAddress_person1` FOREIGN KEY (`personId`) REFERENCES `person` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personHasAddress`
--

LOCK TABLES `personHasAddress` WRITE;
/*!40000 ALTER TABLE `personHasAddress` DISABLE KEYS */;
/*!40000 ALTER TABLE `personHasAddress` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personType`
--

DROP TABLE IF EXISTS `personType`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `personType` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(45) COLLATE utf8_danish_ci DEFAULT NULL,
  `countryId` int(11) NOT NULL,
  `originApplicationId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_personType_country1` (`countryId`),
  KEY `fk_personType_originApplication1` (`originApplicationId`),
  CONSTRAINT `fk_personType_country1` FOREIGN KEY (`countryId`) REFERENCES `country` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_personType_originApplication1` FOREIGN KEY (`originApplicationId`) REFERENCES `originApplication` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_danish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personType`
--

LOCK TABLES `personType` WRITE;
/*!40000 ALTER TABLE `personType` DISABLE KEYS */;
INSERT INTO `personType` VALUES (1,'Persona Natural',1,1),(2,'Persona Jurídica',1,1),(3,'Persona Natural',1,2),(4,'Natural Person',2,2);
/*!40000 ALTER TABLE `personType` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phonePerson`
--

DROP TABLE IF EXISTS `phonePerson`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `phonePerson` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `numberPhone` varchar(30) COLLATE utf8_danish_ci DEFAULT NULL,
  `personId` bigint(20) NOT NULL,
  `phoneTypeId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_phonePerson_person1_idx` (`personId`),
  KEY `fk_phonePerson_phoneType1_idx` (`phoneTypeId`),
  KEY `personId` (`personId`),
  CONSTRAINT `fk_phonePerson_person1` FOREIGN KEY (`personId`) REFERENCES `person` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_phonePerson_phoneType1` FOREIGN KEY (`phoneTypeId`) REFERENCES `phoneType` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_danish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phonePerson`
--

LOCK TABLES `phonePerson` WRITE;
/*!40000 ALTER TABLE `phonePerson` DISABLE KEYS */;
/*!40000 ALTER TABLE `phonePerson` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phoneType`
--

DROP TABLE IF EXISTS `phoneType`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `phoneType` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(40) COLLATE utf8_danish_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_danish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phoneType`
--

LOCK TABLES `phoneType` WRITE;
/*!40000 ALTER TABLE `phoneType` DISABLE KEYS */;
INSERT INTO `phoneType` VALUES (1,'MOBILE'),(2,'ROOM'),(3,'OFFICE');
/*!40000 ALTER TABLE `phoneType` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `createDate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updatedate` timestamp NULL DEFAULT NULL,
  `name` varchar(45) COLLATE utf8_danish_ci DEFAULT NULL,
  `issuerId` int(11) NOT NULL,
  `countryId` int(11) NOT NULL,
  `cardTypeId` int(11) NOT NULL,
  `kindCardId` int(11) NOT NULL,
  `programTypeId` int(11) NOT NULL,
  `binSponsorId` int(11) NOT NULL,
  `levelProductId` int(11) NOT NULL,
  `binNumber` varchar(15) COLLATE utf8_danish_ci DEFAULT NULL,
  `productUseId` int(11) NOT NULL,
  `domesticCurrencyId` int(11) NOT NULL,
  `internationalCurrencyId` int(11) NOT NULL,
  `validityYears` int(11) DEFAULT NULL,
  `storageMedio_id` int(11) NOT NULL,
  `daysBeforeExpiration` int(11) DEFAULT NULL,
  `daysToInactivate` int(11) DEFAULT NULL,
  `daysToActivate` int(11) DEFAULT NULL,
  `daysToUse` int(11) DEFAULT NULL,
  `daysToWithdrawCard` int(11) DEFAULT NULL,
  `beginDateValidity` date DEFAULT NULL,
  `endDateValidity` date DEFAULT NULL,
  `segment_id` int(11) NOT NULL,
  `program_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `fk_products_issuer1_idx` (`issuerId`),
  KEY `fk_products_country1_idx` (`countryId`),
  KEY `fk_products_cardType1_idx` (`cardTypeId`),
  KEY `fk_products_kindCard1_idx` (`kindCardId`),
  KEY `fk_products_programType1_idx` (`programTypeId`),
  KEY `fk_products_binSponsor1_idx` (`binSponsorId`),
  KEY `fk_product_levelProduct1_idx` (`levelProductId`),
  KEY `fk_product_productUse1_idx` (`productUseId`),
  KEY `fk_product_currency1_idx` (`domesticCurrencyId`),
  KEY `fk_product_currency2_idx` (`internationalCurrencyId`),
  KEY `fk_product_storageMedio1_idx` (`storageMedio_id`),
  KEY `fk_product_segment1_idx` (`segment_id`),
  KEY `fk_product_program1_idx` (`program_id`),
  CONSTRAINT `fk_products_binSponsor1` FOREIGN KEY (`binSponsorId`) REFERENCES `binSponsor` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_products_cardType1` FOREIGN KEY (`cardTypeId`) REFERENCES `cardType` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_products_country1` FOREIGN KEY (`countryId`) REFERENCES `country` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_products_issuer1` FOREIGN KEY (`issuerId`) REFERENCES `issuer` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_products_kindCard1` FOREIGN KEY (`kindCardId`) REFERENCES `kindCard` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_products_programType1` FOREIGN KEY (`programTypeId`) REFERENCES `programType` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_product_currency1` FOREIGN KEY (`domesticCurrencyId`) REFERENCES `currency` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_product_currency2` FOREIGN KEY (`internationalCurrencyId`) REFERENCES `currency` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_product_levelProduct1` FOREIGN KEY (`levelProductId`) REFERENCES `levelProduct` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_product_productUse1` FOREIGN KEY (`productUseId`) REFERENCES `productUse` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_product_program1` FOREIGN KEY (`program_id`) REFERENCES `program` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_product_segment1` FOREIGN KEY (`segment_id`) REFERENCES `segment` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_product_storageMedio1` FOREIGN KEY (`storageMedio_id`) REFERENCES `storageMedio` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_danish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productHasCommerceCategory`
--

DROP TABLE IF EXISTS `productHasCommerceCategory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `productHasCommerceCategory` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `commerceClassificationId` int(11) NOT NULL,
  `productId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `productId` (`productId`),
  KEY `fk_productCommerceClassification_commerceClassification1_idx` (`commerceClassificationId`),
  KEY `fk_productCommerceClassification_product1_idx` (`productId`),
  CONSTRAINT `fk_productCommerceClassification_commerceClassification1` FOREIGN KEY (`commerceClassificationId`) REFERENCES `commerceCategory` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_productCommerceClassification_product1` FOREIGN KEY (`productId`) REFERENCES `product` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_danish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productHasCommerceCategory`
--

LOCK TABLES `productHasCommerceCategory` WRITE;
/*!40000 ALTER TABLE `productHasCommerceCategory` DISABLE KEYS */;
/*!40000 ALTER TABLE `productHasCommerceCategory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productType`
--

DROP TABLE IF EXISTS `productType`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `productType` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(80) COLLATE utf8_danish_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_danish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productType`
--

LOCK TABLES `productType` WRITE;
/*!40000 ALTER TABLE `productType` DISABLE KEYS */;
INSERT INTO `productType` VALUES (1,'Tarjeta Prepagada'),(2,'Tarjeta  de Débito'),(3,'Tarjeta de Regalo'),(4,'Tarjeta de Crédito');
/*!40000 ALTER TABLE `productType` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productUse`
--

DROP TABLE IF EXISTS `productUse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `productUse` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(45) COLLATE utf8_danish_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_danish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productUse`
--

LOCK TABLES `productUse` WRITE;
/*!40000 ALTER TABLE `productUse` DISABLE KEYS */;
/*!40000 ALTER TABLE `productUse` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profession`
--

DROP TABLE IF EXISTS `profession`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `profession` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8_danish_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_danish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profession`
--

LOCK TABLES `profession` WRITE;
/*!40000 ALTER TABLE `profession` DISABLE KEYS */;
INSERT INTO `profession` VALUES (1,'Ingeniero de Sistemas'),(2,'Abogado'),(3,'Licenciado en Comunicación Social'),(4,'Mecánico'),(5,'Músico');
/*!40000 ALTER TABLE `profession` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `program`
--

DROP TABLE IF EXISTS `program`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `program` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_danish_ci NOT NULL,
  `description` varchar(2000) COLLATE utf8_danish_ci DEFAULT NULL,
  `contractDate` date DEFAULT NULL,
  `ProgramTypeId` int(11) NOT NULL,
  `productTypeId` int(11) NOT NULL,
  `IssuerId` int(11) NOT NULL,
  `programOwnerId` bigint(20) NOT NULL,
  `cardProgramManagerId` bigint(20) NOT NULL,
  `BinSponsorId` int(11) NOT NULL,
  `expectedLaunchDate` date DEFAULT NULL,
  `cardIssuanceTypeId` int(11) NOT NULL,
  `reloadable` tinyint(4) DEFAULT NULL,
  `sourceFundsId` int(11) NOT NULL,
  `otherSourceFunds` varchar(255) COLLATE utf8_danish_ci DEFAULT NULL,
  `sharedBrand` tinyint(4) DEFAULT NULL,
  `webSite` varchar(50) COLLATE utf8_danish_ci DEFAULT NULL,
  `cashAccess` tinyint(4) DEFAULT NULL,
  `biniinNumber` varchar(15) COLLATE utf8_danish_ci DEFAULT NULL,
  `currencyId` int(11) NOT NULL,
  `useInternational` tinyint(4) DEFAULT NULL,
  `createDate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updateDate` timestamp NULL DEFAULT NULL,
  `responsibleNetworkReportingId` int(11) NOT NULL,
  `otherResponsibleNetworkReporting` varchar(50) COLLATE utf8_danish_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Program_Program_Type_idx` (`ProgramTypeId`),
  KEY `fk_Program_Product_Type1_idx` (`productTypeId`),
  KEY `fk_program_Issuer1_idx` (`IssuerId`),
  KEY `fk_program_person1_idx` (`programOwnerId`),
  KEY `fk_program_BinSponsor1_idx` (`BinSponsorId`),
  KEY `fk_program_person2_idx` (`cardProgramManagerId`),
  KEY `fk_program_cardIssuanceType1_idx` (`cardIssuanceTypeId`),
  KEY `fk_program_sourceFunds1_idx` (`sourceFundsId`),
  KEY `fk_program_currency1_idx` (`currencyId`),
  KEY `fk_program_responsibleNetworkReporting1_idx` (`responsibleNetworkReportingId`),
  KEY `programOwnerId` (`programOwnerId`),
  KEY `cardProgramManagerId` (`cardProgramManagerId`),
  CONSTRAINT `fk_program_BinSponsor1` FOREIGN KEY (`BinSponsorId`) REFERENCES `binSponsor` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_program_cardIssuanceType1` FOREIGN KEY (`cardIssuanceTypeId`) REFERENCES `cardIssuanceType` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_program_currency1` FOREIGN KEY (`currencyId`) REFERENCES `currency` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_program_Issuer1` FOREIGN KEY (`IssuerId`) REFERENCES `issuer` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_program_person1` FOREIGN KEY (`programOwnerId`) REFERENCES `person` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_program_person2` FOREIGN KEY (`cardProgramManagerId`) REFERENCES `person` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Program_Product_Type1` FOREIGN KEY (`productTypeId`) REFERENCES `productType` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Program_Program_Type` FOREIGN KEY (`ProgramTypeId`) REFERENCES `programType` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_program_responsibleNetworkReporting1` FOREIGN KEY (`responsibleNetworkReportingId`) REFERENCES `responsibleNetworkReporting` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_program_sourceFunds1` FOREIGN KEY (`sourceFundsId`) REFERENCES `sourceFunds` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_danish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `program`
--

LOCK TABLES `program` WRITE;
/*!40000 ALTER TABLE `program` DISABLE KEYS */;
INSERT INTO `program` VALUES (1,'Tarjeta prepagada Estudiantes','LOREM IPSU LOREM IPSU LOREM IPSU LOREM IPSU','2019-06-12',1,1,1,3,4,1,NULL,2,NULL,1,NULL,NULL,NULL,NULL,NULL,1,NULL,'2019-11-19 12:24:45',NULL,1,NULL),(4,'Tarjeta prepagada Tercera Edad','LOREM IPSU LOREM IPSU LOREM IPSU LOREM IPSU','2019-06-12',1,1,1,3,4,1,NULL,2,NULL,1,NULL,NULL,NULL,NULL,NULL,1,NULL,'2019-11-19 13:21:01',NULL,1,NULL);
/*!40000 ALTER TABLE `program` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `programHasNetwork`
--

DROP TABLE IF EXISTS `programHasNetwork`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `programHasNetwork` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `programId` bigint(20) NOT NULL,
  `networkId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_programHasNetwork_program1_idx` (`programId`),
  KEY `fk_programHasNetwork_network1_idx` (`networkId`),
  CONSTRAINT `fk_programHasNetwork_network1` FOREIGN KEY (`networkId`) REFERENCES `network` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_programHasNetwork_program1` FOREIGN KEY (`programId`) REFERENCES `program` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_danish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `programHasNetwork`
--

LOCK TABLES `programHasNetwork` WRITE;
/*!40000 ALTER TABLE `programHasNetwork` DISABLE KEYS */;
/*!40000 ALTER TABLE `programHasNetwork` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `programType`
--

DROP TABLE IF EXISTS `programType`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `programType` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) COLLATE utf8_danish_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_danish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `programType`
--

LOCK TABLES `programType` WRITE;
/*!40000 ALTER TABLE `programType` DISABLE KEYS */;
INSERT INTO `programType` VALUES (1,'Franquicia'),(2,'Privado');
/*!40000 ALTER TABLE `programType` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `projectAnnualVolume`
--

DROP TABLE IF EXISTS `projectAnnualVolume`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `projectAnnualVolume` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `year` int(11) DEFAULT NULL,
  `accountsNumber` int(11) DEFAULT NULL,
  `activeCardNumber` int(11) DEFAULT NULL,
  `averageLoad` float DEFAULT NULL,
  `averageCardBalance` float DEFAULT NULL,
  `programId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_projectAnnualVolume_program1_idx` (`programId`),
  CONSTRAINT `fk_projectAnnualVolume_program1` FOREIGN KEY (`programId`) REFERENCES `program` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_danish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `projectAnnualVolume`
--

LOCK TABLES `projectAnnualVolume` WRITE;
/*!40000 ALTER TABLE `projectAnnualVolume` DISABLE KEYS */;
/*!40000 ALTER TABLE `projectAnnualVolume` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `request`
--

DROP TABLE IF EXISTS `request`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `request` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `requestNumber` varchar(20) COLLATE utf8_danish_ci DEFAULT NULL,
  `requestDate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `statusRequestId` int(11) NOT NULL,
  `personId` bigint(20) NOT NULL,
  `requestTypeId` int(11) NOT NULL,
  `programId` bigint(20) NOT NULL,
  `productTypeId` int(11) NOT NULL,
  `countryId` int(11) NOT NULL,
  `personTypeId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `person_id` (`personId`),
  KEY `fk_cardRequest_statusRequest1_idx` (`statusRequestId`),
  KEY `fk_request_person1_idx` (`personId`),
  KEY `fk_request_requestType1_idx` (`requestTypeId`),
  KEY `fk_request_program1` (`programId`),
  KEY `fk_request_productType1` (`productTypeId`),
  KEY `fk_request_country1` (`countryId`),
  KEY `fk_request_personType1` (`personTypeId`),
  CONSTRAINT `fk_cardRequest_statusRequest1` FOREIGN KEY (`statusRequestId`) REFERENCES `statusRequest` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_request_country1` FOREIGN KEY (`countryId`) REFERENCES `country` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_request_person1` FOREIGN KEY (`personId`) REFERENCES `person` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_request_personType1` FOREIGN KEY (`personTypeId`) REFERENCES `personType` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_request_productType1` FOREIGN KEY (`productTypeId`) REFERENCES `productType` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_request_program1` FOREIGN KEY (`programId`) REFERENCES `program` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_request_requestType1` FOREIGN KEY (`requestTypeId`) REFERENCES `requestType` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_danish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `request`
--

LOCK TABLES `request` WRITE;
/*!40000 ALTER TABLE `request` DISABLE KEYS */;
/*!40000 ALTER TABLE `request` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `requestHasCollectionsRequest`
--

DROP TABLE IF EXISTS `requestHasCollectionsRequest`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `requestHasCollectionsRequest` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `collectionsRequest_id` int(11) NOT NULL,
  `request_id` bigint(20) NOT NULL,
  `indApproved` tinyint(4) DEFAULT NULL,
  `observations` varchar(1500) COLLATE utf8_danish_ci DEFAULT NULL,
  `urlImageFile` varchar(250) COLLATE utf8_danish_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_requestHasCollectionsRequest_collectionsRequest1_idx` (`collectionsRequest_id`),
  KEY `fk_requestHasCollectionsRequest_request1_idx` (`request_id`),
  CONSTRAINT `fk_requestHasCollectionsRequest_collectionsRequest1` FOREIGN KEY (`collectionsRequest_id`) REFERENCES `collectionsRequest` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_requestHasCollectionsRequest_request1` FOREIGN KEY (`request_id`) REFERENCES `request` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_danish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `requestHasCollectionsRequest`
--

LOCK TABLES `requestHasCollectionsRequest` WRITE;
/*!40000 ALTER TABLE `requestHasCollectionsRequest` DISABLE KEYS */;
/*!40000 ALTER TABLE `requestHasCollectionsRequest` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `requestType`
--

DROP TABLE IF EXISTS `requestType`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `requestType` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(10) COLLATE utf8_danish_ci DEFAULT NULL,
  `description` varchar(50) COLLATE utf8_danish_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COLLATE=utf8_danish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `requestType`
--

LOCK TABLES `requestType` WRITE;
/*!40000 ALTER TABLE `requestType` DISABLE KEYS */;
INSERT INTO `requestType` VALUES (5,'IPER','Individual Personalizada'),(6,'MPER','Masiva personalizada'),(7,'MNPE','Masiva No Personalizada'),(14,'1','test 1');
/*!40000 ALTER TABLE `requestType` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `responsibleNetworkReporting`
--

DROP TABLE IF EXISTS `responsibleNetworkReporting`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `responsibleNetworkReporting` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(45) COLLATE utf8_danish_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_danish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `responsibleNetworkReporting`
--

LOCK TABLES `responsibleNetworkReporting` WRITE;
/*!40000 ALTER TABLE `responsibleNetworkReporting` DISABLE KEYS */;
INSERT INTO `responsibleNetworkReporting` VALUES (1,'Program Manager'),(2,'Procesador'),(3,'Otros');
/*!40000 ALTER TABLE `responsibleNetworkReporting` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `segment`
--

DROP TABLE IF EXISTS `segment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `segment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8_danish_ci DEFAULT NULL,
  `description` varchar(45) COLLATE utf8_danish_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_danish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `segment`
--

LOCK TABLES `segment` WRITE;
/*!40000 ALTER TABLE `segment` DISABLE KEYS */;
/*!40000 ALTER TABLE `segment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sequences`
--

DROP TABLE IF EXISTS `sequences`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sequences` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `initialValue` int(11) DEFAULT NULL,
  `currentValue` int(11) DEFAULT NULL,
  `documentType_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_sequences_documentType1_idx` (`documentType_id`),
  CONSTRAINT `fk_sequences_documentType1` FOREIGN KEY (`documentType_id`) REFERENCES `documentType` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_danish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sequences`
--

LOCK TABLES `sequences` WRITE;
/*!40000 ALTER TABLE `sequences` DISABLE KEYS */;
INSERT INTO `sequences` VALUES (1,1,1,1);
/*!40000 ALTER TABLE `sequences` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sourceFunds`
--

DROP TABLE IF EXISTS `sourceFunds`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sourceFunds` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(40) COLLATE utf8_danish_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_danish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sourceFunds`
--

LOCK TABLES `sourceFunds` WRITE;
/*!40000 ALTER TABLE `sourceFunds` DISABLE KEYS */;
INSERT INTO `sourceFunds` VALUES (1,'Cliente'),(2,'Empleadora'),(3,'Corporación'),(4,'Gobierno'),(5,'Otros');
/*!40000 ALTER TABLE `sourceFunds` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `state`
--

DROP TABLE IF EXISTS `state`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `state` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `countryId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_state_country1_idx` (`countryId`),
  CONSTRAINT `fk_state_country1` FOREIGN KEY (`countryId`) REFERENCES `country` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `state`
--

LOCK TABLES `state` WRITE;
/*!40000 ALTER TABLE `state` DISABLE KEYS */;
INSERT INTO `state` VALUES (1,'AMAZONAS',1),(2,'ANZOATEGUI',1),(3,'ALABAMA',2),(4,'ALASKA',2);
/*!40000 ALTER TABLE `state` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `statusRequest`
--

DROP TABLE IF EXISTS `statusRequest`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `statusRequest` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(45) COLLATE utf8_danish_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_danish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `statusRequest`
--

LOCK TABLES `statusRequest` WRITE;
/*!40000 ALTER TABLE `statusRequest` DISABLE KEYS */;
INSERT INTO `statusRequest` VALUES (1,'IN PROCESS');
/*!40000 ALTER TABLE `statusRequest` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `storageMedio`
--

DROP TABLE IF EXISTS `storageMedio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `storageMedio` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(45) COLLATE utf8_danish_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_danish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `storageMedio`
--

LOCK TABLES `storageMedio` WRITE;
/*!40000 ALTER TABLE `storageMedio` DISABLE KEYS */;
/*!40000 ALTER TABLE `storageMedio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `streetType`
--

DROP TABLE IF EXISTS `streetType`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `streetType` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `streetType`
--

LOCK TABLES `streetType` WRITE;
/*!40000 ALTER TABLE `streetType` DISABLE KEYS */;
INSERT INTO `streetType` VALUES (1,'Calle'),(2,'Avenida'),(3,'Vereda'),(4,'Redoma'),(5,'Autopista'),(6,'Bulevar'),(7,'Callejón'),(8,'Carretera');
/*!40000 ALTER TABLE `streetType` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `login` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `firstName` varchar(45) NOT NULL,
  `lastName` varchar(45) NOT NULL,
  `creationDate` datetime NOT NULL,
  `email` varchar(255) NOT NULL,
  `phoneNumber` varchar(45) DEFAULT NULL,
  `receiveTopUpNotification` tinyint(1) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `login` (`login`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (6,'kgomez','123456','gomez','gomez','2019-01-11 00:00:00','kerwin2821@gmail.com','584241934005',0,1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zipZone`
--

DROP TABLE IF EXISTS `zipZone`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `zipZone` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(60) DEFAULT NULL,
  `code` varchar(45) DEFAULT NULL,
  `cityId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_zipZone_cities1_idx` (`cityId`),
  CONSTRAINT `fk_zipZone_cities1` FOREIGN KEY (`cityId`) REFERENCES `city` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zipZone`
--

LOCK TABLES `zipZone` WRITE;
/*!40000 ALTER TABLE `zipZone` DISABLE KEYS */;
INSERT INTO `zipZone` VALUES (1,'Parroquia Huachamacare, Acanaña - Amazonas','7101',1),(2,'Macuruco, Amazonas','7101',2),(3,'Atapirire, Anzoátegui','6052',3),(4,'Cantaura, Anzoátegui','6007',4),(5,'Ciudad de Alabaster','35007',5),(6,'Albertville, ZIP 7209','359717209',6);
/*!40000 ALTER TABLE `zipZone` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-12-13  9:42:07
