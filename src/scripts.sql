-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 09-11-2017 a las 16:17:58
-- Versión del servidor: 10.1.25-MariaDB
-- Versión de PHP: 7.1.7
-- use mysql;


CREATE DATABASE nomina;

use nomina;

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `tusolutionweb`
--

DELIMITER $$
--
-- Procedimientos
--

-- Procedimientos para tabla Departamento
CREATE DEFINER=`root`@`localhost` PROCEDURE `departamento_buscar` (IN `parametro` VARCHAR(50))  NO SQL
SELECT a.ID_DEPARTAMENTO, a.COD_DEPARTAMENTO, a.DEPARTAMENTO FROM t_departamento a WHERE a.DEPARTAMENTO LIKE parametro OR a.COD_DEPARTAMENTO LIKE parametro$$

-- PROCEDIMIENTO CAMBIADO DEPARTAMENTO
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_departamento`(IN `SID_DEPARTAMENTO` INT(10), IN `SCOD_DEPARTAMENTO` CHAR(8), IN `SDEPARTAMENTO` VARCHAR(100))
    NO SQL
BEGIN

INSERT INTO t_departamento ( ID_DEPARTAMENTO,COD_DEPARTAMENTO,DEPARTAMENTO ) VALUES( SID_DEPARTAMENTO,SCOD_DEPARTAMENTO,SDEPARTAMENTO );
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `lista_departamento` ()  NO SQL
SELECT a.ID_DEPARTAMENTO, a.COD_DEPARTAMENTO, a.DEPARTAMENTO FROM t_departamento a$$

-- Procedimientos para tabla Planilla
CREATE DEFINER=`root`@`localhost` PROCEDURE `planilla_buscar` (IN `parametro` VARCHAR(50))  NO SQL
SELECT a.ID_PLANILLA, a.COD_PLANILLA, a.FECHA_INICIO, a.FECHA_FIN FROM t_planilla a WHERE a.COD_PLANILLA LIKE parametro$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_planilla` (IN `SCOD_PLANILLA` CHAR(8), IN `SFECHA_INICIO` DATE, IN `SFECHA_FIN` DATE)  NO SQL
BEGIN

INSERT INTO t_planilla ( COD_PLANILLA,FECHA_INICIO,FECHA_FIN ) VALUES( SCOD_PLANILLA,SFECHA_INICIO,SFECHA_FIN );
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `lista_planilla` ()  NO SQL
SELECT a.ID_PLANILLA, a.COD_PLANILLA, a.FECHA_INICIO, a.FECHA_FIN FROM t_planilla a$$

-- Procedimientos para tabla empleado

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_empleado` (IN `SDNI_EMP` CHAR(8), IN `SID_DEPARTAMENTO` VARCHAR(50), IN `SSALARIO` CHAR(8), IN `SPUESTO` VARCHAR(50), IN `SCUENTA_BANCARIA` VARCHAR(12), IN `SNOMBRE` VARCHAR(50), IN `SPRIMER_APE` VARCHAR(50), IN `SSEGUNDO_APE` VARCHAR(50))  NO SQL
BEGIN

INSERT INTO t_empleado ( DNI_EMP,ID_DEPARTAMENTO,SALARIO,PUESTO,CUENTA_BANCARIA,NOMBRE,PRIMER_APE,SEGUNDO_APE) VALUES( SDNI_EMP,SID_DEPARTAMENTO,SSALARIO,SPUESTO,SCUENTA_BANCARIA,SNOMBRE,SPRIMER_APE,SSEGUNDO_APE);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `lista_empleado` ()  NO SQL
SELECT * FROM t_empleado$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `empleado_buscar` ()  NO SQL
SELECT * FROM t_empleado WHERE NOMBRE LIKE parametro OR PRIMER_APE LIKE parametro$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `empleado_buscar_dni` ()  NO SQL
SELECT * FROM t_empleado WHERE DNI_EMP = parametro$$

-- Procedimientos para la tabla haberes
CREATE DEFINER=`root`@`localhost` PROCEDURE `haberes_buscar` (IN `parametro` VARCHAR(50))  NO SQL
SELECT a.ID_HABER, a.NOMBRE_HABER FROM t_haberes a WHERE a.NOMBRE_HABER LIKE parametro$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_haberes` (IN `SNOMBRE_HABER` CHAR(20))  NO SQL
BEGIN

INSERT INTO t_haberes ( NOMBRE_HABER ) VALUES( SNOMBRE_HABER );
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `lista_haberes` ()  NO SQL
SELECT a.ID_HABER, a.NOMBRE_HABER FROM t_haberes a$$
-- ------------- PROCEDIMIENTO DE DESCUENTOS


CREATE DEFINER=`root`@`localhost` PROCEDURE `lista_descuentos` ()  NO SQL
SELECT * from t_descuentos$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_descuentos` (IN `SID_DES` INT(10), IN `SNOMBRE_DESC` VARCHAR(50))  NO SQL
BEGIN

INSERT INTO t_descuentos (ID_DES, NOMBRE_DESC) VALUES(SID_DES, SNOMBRE_DESC);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `lista_emp_des` ()  NO SQL
SELECT * FROM t_emp_desc$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_emp_descuento` (IN `SID_EMP_DESC` INT(10), IN `SDNI_EMP` CHAR(8), IN `SID_DES` INT(10), IN `SFECHA` VARCHAR(50), IN `SMONTO_DES` DECIMAL(8,2))  NO SQL
BEGIN

INSERT INTO t_emp_desc (ID_EMP_DESC, DNI_EMP,ID_DES,FECHA,MONTO_DES) VALUES(SID_EMP_DESC, SDNI_EMP,SID_DES,SFECHA,SMONTO_DES);
END$$

-- ------------- PROCEDIMIENTO DE TABLA EMPLEADO HABERES
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_emp_haberes` (IN `SID_EMP_HAB` INT(10), IN `SDNI_EMP` CHAR(8), IN `SID_HAB` INT(10), IN `SFECHA` VARCHAR(50), IN `SMONTO_HAB` DECIMAL(8,2))  NO SQL
BEGIN

INSERT INTO t_emp_hab (ID_EMP_HAB, DNI_EMP,ID_HAB,FECHA,MONTO_HAB) VALUES(SID_EMP_HAB, SDNI_EMP,SID_HAB,SFECHA,SMONTO_HAB);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `lista_emp_hab` ()  NO SQL
SELECT * FROM t_emp_hab$$

-- procesos para reportes

CREATE DEFINER=`root`@`localhost` PROCEDURE `reporte_buscar_hab` (IN `anio` VARCHAR(10), IN `mes` VARCHAR(10), IN `dni` VARCHAR(8))  NO SQL
SELECT t_haberes.ID_HABER,t_haberes.NOMBRE_HABER,t_emp_hab.MONTO_HAB,t_empleado.NOMBRE , t_empleado.PRIMER_APE,t_empleado.SEGUNDO_APE FROM t_haberes INNER JOIN t_emp_hab ON t_haberes.ID_HABER = t_emp_hab.ID_HAB INNER JOIN t_empleado ON t_emp_hab.DNI_EMP=t_empleado.DNI_EMP WHERE LEFT(RIGHT((t_emp_hab.FECHA),4),2)=mes
 AND LEFT((t_emp_hab.FECHA),4)=anio AND t_empleado.DNI_EMP=dni$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `reporte_buscar_descuento` (IN `anio` VARCHAR(10), IN `mes` VARCHAR(10), IN `dni` VARCHAR(8))  NO SQL
SELECT t_descuentos.ID_DES,t_descuentos.NOMBRE_DESC,t_emp_desc.MONTO_DES,t_empleado.NOMBRE , t_empleado.PRIMER_APE,t_empleado.SEGUNDO_APE FROM t_descuentos INNER JOIN t_emp_desc ON t_descuentos.ID_DES = t_emp_desc.ID_EMP_DESC INNER JOIN t_empleado ON t_emp_desc.DNI_EMP=t_empleado.DNI_EMP WHERE LEFT(RIGHT((t_emp_desc.FECHA),4),2)=mes AND LEFT((t_emp_desc.FECHA),4)=anio AND t_empleado.DNI_EMP=dni$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `t_departamento`
--

CREATE TABLE `t_departamento` (
  `ID_DEPARTAMENTO` int(10) NOT NULL,
  `COD_DEPARTAMENTO` char(8) COLLATE utf8_spanish_ci DEFAULT NULL,
  `DEPARTAMENTO` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (ID_DEPARTAMENTO)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `t_planilla`
--

CREATE TABLE `t_planilla` (
  `ID_PLANILLA` int(10) NOT NULL AUTO_INCREMENT,
  `COD_PLANILLA` char(8) COLLATE utf8_spanish_ci DEFAULT NULL,
  `FECHA_INICIO` DATE DEFAULT NULL,
  `FECHA_FIN` DATE DEFAULT NULL,
    PRIMARY KEY (ID_PLANILLA)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `t_planilla`
--

CREATE TABLE `t_haberes` (
  `ID_HABER` int(10) NOT NULL AUTO_INCREMENT,
  `NOMBRE_HABER` char(20) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (ID_HABER)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `t_emp_hab`
--
CREATE TABLE `t_emp_hab` (
  `ID_EMP_HAB` int(10) NOT NULL AUTO_INCREMENT,
  `DNI_EMP` char(8) COLLATE utf8_spanish_ci NOT NULL,
  `ID_HAB` int(10) NOT NULL,
  `FECHA` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `MONTO_HAB` decimal(8,2) DEFAULT NULL,
    PRIMARY KEY (ID_EMP_HAB)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;


-- -------------------------------------------------------
-- ------------------TABLA EMPLEADO---------------------- ABNER
CREATE TABLE `t_empleado` (
  `DNI_EMP` char(8) COLLATE utf8_spanish_ci NOT NULL,				
  `ID_DEPARTAMENTO` int(10) NOT NULL,   					
  `SALARIO` char(8) COLLATE utf8_spanish_ci DEFAULT NULL,			
  `PUESTO` varchar(10) COLLATE utf8_spanish_ci DEFAULT NULL,			
  `CUENTA_BANCARIA` char(12) COLLATE utf8_spanish_ci DEFAULT NULL,
  `NOMBRE` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `PRIMER_APE` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `SEGUNDO_APE` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

ALTER TABLE `t_empleado`
  ADD PRIMARY KEY (`DNI_EMP`),
  ADD KEY `ID_DEPARTAMENTO` (`ID_DEPARTAMENTO`);

-- --------------------------------------------------------
-- INICIO TABLA DESCUENTO 

 CREATE TABLE `t_descuentos` (
  `ID_DES` int(10) NOT NULL AUTO_INCREMENT,
  `NOMBRE_DESC` char(8) COLLATE utf8_spanish_ci NOT NULL,
    PRIMARY KEY (`ID_DES`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

 INSERT INTO `t_descuentos` (`ID_DES`, `NOMBRE_DESC`) VALUES
(1, 'N20530'),
(2, 'ONP'),
(3, 'IPssvida'),
(4, 'Admin'),
(5, 'Magist'),
(6, 'Varios'),
(7, 'Capyup'),
(8, 'Judicial'),
(9, 'DL26897'),
(10, 'Zapateri'),
(11, 'Responsa'),
(12, 'Sesdis'),
(13, 'Bazares'),
(14, 'Multas'),
(15, 'Bmater'),
(16, 'Derese'),
(17, 'Subcafae'),
(18, 'Dea'),
(19, 'Sanpedro'),
(20, 'Ancije'),
(21, 'Sutage'),
(22, 'Rimacse'),
(23, 'Editoria'),
(24, 'Aceade'),
(25, 'Cafaecus'),
(26, 'CMunAreq'),
(27, 'Credinka'),
(28, 'Cmunicip'),
(29, 'PagosInd'),
(30, 'Reintegr');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `t_emp_desc`
--

CREATE TABLE `t_emp_desc` (
  `ID_EMP_DESC` int(10) NOT NULL AUTO_INCREMENT,
  `DNI_EMP` char(8) COLLATE utf8_spanish_ci NOT NULL,
  `ID_DES` int(10) NOT NULL,
  `FECHA` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `MONTO_DES` decimal(8,2) DEFAULT NULL,
   PRIMARY KEY(`ID_EMP_DESC`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- ------ FIN DE TABLA DESCUENTO
--
-- Estructura de tabla para la tabla `t_usuario`
--

CREATE TABLE `t_usuario` (
  `id` int(10) NOT NULL,
  `usuario` varchar(50) NOT NULL,
  `pasword` varchar(50) NOT NULL,
  `tipo` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `t_usuario`
--

INSERT INTO `t_usuario` (`id`, `usuario`, `pasword`, `tipo`) VALUES
(1, 'admin', 'admin', 'Administrador'),
(2, 'user', '123456', 'Empleado');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `t_usuario`
--
ALTER TABLE `t_usuario`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de la tabla `t_usuario`
--
ALTER TABLE `t_usuario`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `t_usuario`
--
ALTER TABLE `t_departamento`
  MODIFY `ID_DEPARTAMENTO` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restricciones para tablas volcadas
--
