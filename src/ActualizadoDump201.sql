CREATE DATABASE  IF NOT EXISTS `nomina2` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `nomina2`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: nomina2
-- ------------------------------------------------------
-- Server version	5.7.21-log

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
-- Table structure for table `t_departamento`
--

DROP TABLE IF EXISTS `t_departamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_departamento` (
  `ID_DEPARTAMENTO` int(10) NOT NULL AUTO_INCREMENT,
  `COD_DEPARTAMENTO` char(8) COLLATE utf8_spanish_ci DEFAULT NULL,
  `DEPARTAMENTO` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`ID_DEPARTAMENTO`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_departamento`
--

LOCK TABLES `t_departamento` WRITE;
/*!40000 ALTER TABLE `t_departamento` DISABLE KEYS */;
INSERT INTO `t_departamento` VALUES (1,'001','informatica');
/*!40000 ALTER TABLE `t_departamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_descuentos`
--

DROP TABLE IF EXISTS `t_descuentos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_descuentos` (
  `ID_DES` int(10) NOT NULL AUTO_INCREMENT,
  `NOMBRE_DESC` char(8) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`ID_DES`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_descuentos`
--

LOCK TABLES `t_descuentos` WRITE;
/*!40000 ALTER TABLE `t_descuentos` DISABLE KEYS */;
INSERT INTO `t_descuentos` VALUES (1,'N20530'),(2,'ONP'),(3,'IPssvida'),(4,'Admin'),(5,'Magist'),(6,'Varios'),(7,'Capyup'),(8,'Judicial'),(9,'DL26897'),(10,'Zapateri'),(11,'Responsa'),(12,'Sesdis'),(13,'Bazares'),(14,'Multas'),(15,'Bmater'),(16,'Derese'),(17,'Subcafae'),(18,'Dea'),(19,'Sanpedro'),(20,'Ancije'),(21,'Sutage'),(22,'Rimacse'),(23,'Editoria'),(24,'Aceade'),(25,'Cafaecus'),(26,'CMunAreq'),(27,'Credinka'),(28,'Cmunicip'),(29,'PagosInd'),(30,'Reintegr'),(31,'Tiempo N'),(32,'Seguro S');
/*!40000 ALTER TABLE `t_descuentos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_emp_desc`
--

DROP TABLE IF EXISTS `t_emp_desc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_emp_desc` (
  `ID_EMP_DESC` int(10) NOT NULL AUTO_INCREMENT,
  `DNI_EMP` char(8) COLLATE utf8_spanish_ci NOT NULL,
  `ID_DES` int(10) NOT NULL,
  `FECHA` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `MONTO_DES` decimal(8,2) DEFAULT NULL,
  PRIMARY KEY (`ID_EMP_DESC`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_emp_desc`
--

LOCK TABLES `t_emp_desc` WRITE;
/*!40000 ALTER TABLE `t_emp_desc` DISABLE KEYS */;
INSERT INTO `t_emp_desc` VALUES (1,'15454548',32,'20190101',1200.00),(2,'15454548',3,'20190101',120.00);
/*!40000 ALTER TABLE `t_emp_desc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_emp_hab`
--

DROP TABLE IF EXISTS `t_emp_hab`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_emp_hab` (
  `ID_EMP_HAB` int(10) NOT NULL AUTO_INCREMENT,
  `DNI_EMP` char(8) COLLATE utf8_spanish_ci NOT NULL,
  `ID_HAB` int(10) NOT NULL,
  `FECHA` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `MONTO_HAB` decimal(8,2) DEFAULT NULL,
  PRIMARY KEY (`ID_EMP_HAB`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_emp_hab`
--

LOCK TABLES `t_emp_hab` WRITE;
/*!40000 ALTER TABLE `t_emp_hab` DISABLE KEYS */;
INSERT INTO `t_emp_hab` VALUES (1,'15454548',1,'20190101',25000.00),(2,'15454548',2,'20190103',250.00),(3,'15454548',3,'20190105',250.00);
/*!40000 ALTER TABLE `t_emp_hab` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_empleado`
--

DROP TABLE IF EXISTS `t_empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_empleado` (
  `DNI_EMP` char(8) COLLATE utf8_spanish_ci NOT NULL,
  `ID_DEPARTAMENTO` int(10) NOT NULL,
  `SALARIO` char(8) COLLATE utf8_spanish_ci DEFAULT NULL,
  `PUESTO` varchar(10) COLLATE utf8_spanish_ci DEFAULT NULL,
  `CUENTA_BANCARIA` char(12) COLLATE utf8_spanish_ci DEFAULT NULL,
  `NOMBRE` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `PRIMER_APE` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `SEGUNDO_APE` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`DNI_EMP`),
  KEY `ID_DEPARTAMENTO` (`ID_DEPARTAMENTO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_empleado`
--

LOCK TABLES `t_empleado` WRITE;
/*!40000 ALTER TABLE `t_empleado` DISABLE KEYS */;
INSERT INTO `t_empleado` VALUES ('15454548',1,'25000','gerente','45451515151','Juan','Perez','Lucas');
/*!40000 ALTER TABLE `t_empleado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_haberes`
--

DROP TABLE IF EXISTS `t_haberes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_haberes` (
  `ID_HABER` int(10) NOT NULL AUTO_INCREMENT,
  `NOMBRE_HABER` char(20) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`ID_HABER`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_haberes`
--

LOCK TABLES `t_haberes` WRITE;
/*!40000 ALTER TABLE `t_haberes` DISABLE KEYS */;
INSERT INTO `t_haberes` VALUES (1,'Salario'),(2,'Horas Extras'),(3,'Bonificacion');
/*!40000 ALTER TABLE `t_haberes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_planilla`
--

DROP TABLE IF EXISTS `t_planilla`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_planilla` (
  `ID_PLANILLA` int(10) NOT NULL AUTO_INCREMENT,
  `COD_PLANILLA` char(8) COLLATE utf8_spanish_ci DEFAULT NULL,
  `FECHA_INICIO` date DEFAULT NULL,
  `FECHA_FIN` date DEFAULT NULL,
  PRIMARY KEY (`ID_PLANILLA`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_planilla`
--

LOCK TABLES `t_planilla` WRITE;
/*!40000 ALTER TABLE `t_planilla` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_planilla` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_usuario`
--

DROP TABLE IF EXISTS `t_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_usuario` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `usuario` varchar(50) NOT NULL,
  `pasword` varchar(50) NOT NULL,
  `tipo` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_usuario`
--

LOCK TABLES `t_usuario` WRITE;
/*!40000 ALTER TABLE `t_usuario` DISABLE KEYS */;
INSERT INTO `t_usuario` VALUES (1,'admin','admin','Administrador'),(2,'user','123456','Empleado');
/*!40000 ALTER TABLE `t_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'nomina2'
--

--
-- Dumping routines for database 'nomina2'
--
/*!50003 DROP PROCEDURE IF EXISTS `departamento_buscar` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `departamento_buscar`(IN `parametro` VARCHAR(50))
    NO SQL
SELECT a.ID_DEPARTAMENTO, a.COD_DEPARTAMENTO, a.DEPARTAMENTO FROM t_departamento a WHERE a.DEPARTAMENTO LIKE parametro OR a.COD_DEPARTAMENTO LIKE parametro ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `empleado_buscar` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `empleado_buscar`()
    NO SQL
SELECT * FROM t_empleado WHERE NOMBRE LIKE parametro OR PRIMER_APE LIKE parametro ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `empleado_buscar_dni` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `empleado_buscar_dni`()
    NO SQL
SELECT * FROM t_empleado WHERE DNI_EMP = parametro ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `haberes_buscar` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `haberes_buscar`(IN `parametro` VARCHAR(50))
    NO SQL
SELECT a.ID_HABER, a.NOMBRE_HABER FROM t_haberes a WHERE a.NOMBRE_HABER LIKE parametro ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insertar_departamento` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_departamento`(IN `SID_DEPARTAMENTO` INT(10), IN `SCOD_DEPARTAMENTO` CHAR(8), IN `SDEPARTAMENTO` VARCHAR(100))
    NO SQL
BEGIN

INSERT INTO t_departamento ( ID_DEPARTAMENTO,COD_DEPARTAMENTO,DEPARTAMENTO ) VALUES( SID_DEPARTAMENTO,SCOD_DEPARTAMENTO,SDEPARTAMENTO );
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insertar_descuentos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_descuentos`(IN `SID_DES` INT(10), IN `SNOMBRE_DESC` VARCHAR(50))
    NO SQL
BEGIN

INSERT INTO t_descuentos (ID_DES, NOMBRE_DESC) VALUES(SID_DES, SNOMBRE_DESC);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insertar_empleado` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_empleado`(IN `SDNI_EMP` CHAR(8), IN `SID_DEPARTAMENTO` VARCHAR(50), IN `SSALARIO` CHAR(8), IN `SPUESTO` VARCHAR(50), IN `SCUENTA_BANCARIA` VARCHAR(12), IN `SNOMBRE` VARCHAR(50), IN `SPRIMER_APE` VARCHAR(50), IN `SSEGUNDO_APE` VARCHAR(50))
    NO SQL
BEGIN

INSERT INTO t_empleado ( DNI_EMP,ID_DEPARTAMENTO,SALARIO,PUESTO,CUENTA_BANCARIA,NOMBRE,PRIMER_APE,SEGUNDO_APE) VALUES( SDNI_EMP,SID_DEPARTAMENTO,SSALARIO,SPUESTO,SCUENTA_BANCARIA,SNOMBRE,SPRIMER_APE,SSEGUNDO_APE);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insertar_emp_descuento` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_emp_descuento`(IN `SID_EMP_DESC` INT(10), IN `SDNI_EMP` CHAR(8), IN `SID_DES` INT(10), IN `SFECHA` VARCHAR(50), IN `SMONTO_DES` DECIMAL(8,2))
    NO SQL
BEGIN

INSERT INTO t_emp_desc (ID_EMP_DESC, DNI_EMP,ID_DES,FECHA,MONTO_DES) VALUES(SID_EMP_DESC, SDNI_EMP,SID_DES,SFECHA,SMONTO_DES);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insertar_emp_haberes` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_emp_haberes`(IN `SID_EMP_HAB` INT(10), IN `SDNI_EMP` CHAR(8), IN `SID_HAB` INT(10), IN `SFECHA` VARCHAR(50), IN `SMONTO_HAB` DECIMAL(8,2))
    NO SQL
BEGIN

INSERT INTO t_emp_hab (ID_EMP_HAB, DNI_EMP,ID_HAB,FECHA,MONTO_HAB) VALUES(SID_EMP_HAB, SDNI_EMP,SID_HAB,SFECHA,SMONTO_HAB);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insertar_haberes` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_haberes`(IN `SNOMBRE_HABER` CHAR(20))
    NO SQL
BEGIN

INSERT INTO t_haberes ( NOMBRE_HABER ) VALUES( SNOMBRE_HABER );
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `insertar_planilla` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_planilla`(IN `SCOD_PLANILLA` CHAR(8), IN `SFECHA_INICIO` DATE, IN `SFECHA_FIN` DATE)
    NO SQL
BEGIN

INSERT INTO t_planilla ( COD_PLANILLA,FECHA_INICIO,FECHA_FIN ) VALUES( SCOD_PLANILLA,SFECHA_INICIO,SFECHA_FIN );
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `lista_departamento` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `lista_departamento`()
    NO SQL
SELECT a.ID_DEPARTAMENTO, a.COD_DEPARTAMENTO, a.DEPARTAMENTO FROM t_departamento a ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `lista_descuentos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `lista_descuentos`()
    NO SQL
SELECT * from t_descuentos ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `lista_empleado` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `lista_empleado`()
    NO SQL
SELECT * FROM t_empleado ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `lista_emp_des` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `lista_emp_des`()
    NO SQL
SELECT * FROM t_emp_desc ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `lista_emp_hab` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `lista_emp_hab`()
    NO SQL
SELECT * FROM t_emp_hab ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `lista_haberes` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `lista_haberes`()
    NO SQL
SELECT a.ID_HABER, a.NOMBRE_HABER FROM t_haberes a ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `lista_planilla` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `lista_planilla`()
    NO SQL
SELECT a.ID_PLANILLA, a.COD_PLANILLA, a.FECHA_INICIO, a.FECHA_FIN FROM t_planilla a ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `planilla_buscar` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `planilla_buscar`(IN `parametro` VARCHAR(50))
    NO SQL
SELECT a.ID_PLANILLA, a.COD_PLANILLA, a.FECHA_INICIO, a.FECHA_FIN FROM t_planilla a WHERE a.COD_PLANILLA LIKE parametro ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `reporte_buscar_descuento` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `reporte_buscar_descuento`(IN `anio` VARCHAR(10), IN `mes` VARCHAR(10), IN `dni` VARCHAR(8))
    NO SQL
SELECT t_descuentos.ID_DES,t_descuentos.NOMBRE_DESC,t_emp_desc.MONTO_DES,t_empleado.NOMBRE , t_empleado.PRIMER_APE,t_empleado.SEGUNDO_APE FROM t_descuentos INNER JOIN t_emp_desc ON t_descuentos.ID_DES = t_emp_desc.ID_EMP_DESC INNER JOIN t_empleado ON t_emp_desc.DNI_EMP=t_empleado.DNI_EMP WHERE LEFT(RIGHT((t_emp_desc.FECHA),4),2) COLLATE utf8_unicode_ci = mes AND LEFT((t_emp_desc.FECHA),4) COLLATE utf8_unicode_ci = anio AND t_empleado.DNI_EMP COLLATE utf8_unicode_ci = dni ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `reporte_buscar_hab` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `reporte_buscar_hab`(IN `anio` VARCHAR(10), IN `mes` VARCHAR(10), IN `dni` VARCHAR(8))
    NO SQL
SELECT t_haberes.ID_HABER,t_haberes.NOMBRE_HABER,t_emp_hab.MONTO_HAB,t_empleado.NOMBRE , t_empleado.PRIMER_APE,t_empleado.SEGUNDO_APE FROM t_haberes INNER JOIN t_emp_hab ON t_haberes.ID_HABER = t_emp_hab.ID_HAB INNER JOIN t_empleado ON t_emp_hab.DNI_EMP=t_empleado.DNI_EMP WHERE LEFT(RIGHT((t_emp_hab.FECHA),4),2) COLLATE utf8_unicode_ci =mes
 AND LEFT((t_emp_hab.FECHA),4) COLLATE utf8_unicode_ci =anio AND t_empleado.DNI_EMP COLLATE utf8_unicode_ci =dni ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-01 19:04:46
