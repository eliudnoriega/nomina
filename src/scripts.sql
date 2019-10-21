-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 09-11-2017 a las 16:17:58
-- Versión del servidor: 10.1.25-MariaDB
-- Versión de PHP: 7.1.7

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
CREATE DEFINER=`root`@`localhost` PROCEDURE `docente_buscar` ()  NO SQL
SELECT * FROM t_docente WHERE NOMBRE LIKE parametro OR AP_PATERNO LIKE parametro$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `docente_buscar_dni` ()  NO SQL
SELECT * FROM t_docente WHERE DNI_DOCENTE = parametro$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `establecimiento_buscar` (IN `parametro` VARCHAR(50))  NO SQL
SELECT * FROM t_establecimiento WHERE ESTABLECIMIENTO LIKE parametro OR COD_ESTABLECIMIENTO LIKE parametro$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_descuentos` (IN `SID_DES` INT(10), IN `SNOMBRE_DESC` VARCHAR(50))  NO SQL
BEGIN

INSERT INTO t_descuentos (ID_DES, NOMBRE_DESC) VALUES(SID_DES, SNOMBRE_DESC);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_docente` (IN `SDNI_DOCENTE` CHAR(8), IN `sid_e` VARCHAR(50), IN `SCOD_MOD` CHAR(8), IN `STIPO` VARCHAR(5), IN `SCUENTA_BANCARIA` VARCHAR(12), IN `SNOMBRE` VARCHAR(50), IN `SAP_PATERNO` VARCHAR(50), IN `SAP_MATERNO` VARCHAR(50))  NO SQL
BEGIN

INSERT INTO t_docente ( DNI_DOC,ID_ESTAB,COD_MOD,TIPO,CUENTA_BANCARIA,NOMBRE,AP_PATERNO,AP_MATERNO) VALUES( SDNI_DOCENTE,sid_e,SCOD_MOD,STIPO,SCUENTA_BANCARIA,SNOMBRE,SAP_PATERNO,SAP_MATERNO);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_doc_descuento` (IN `SID_DOC_DESC` INT(10), IN `SDNI_DOC` CHAR(8), IN `SID_DES` INT(10), IN `SFECHA` VARCHAR(50), IN `SMONTO_DES` DECIMAL(8,2))  NO SQL
BEGIN

INSERT INTO t_doc_desc (ID_DOC_DESC, DNI_DOC,ID_DES,FECHA,MONTO_DES) VALUES(SID_DOC_DESC, SDNI_DOC,SID_DES,SFECHA,SMONTO_DES);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_doc_haberes` (IN `SID_DOC_HAB` INT(10), IN `SDNI_DOC` CHAR(8), IN `SID_HAB` INT(10), IN `SFECHA` VARCHAR(50), IN `SMONTO_HAB` DECIMAL(8,2))  NO SQL
BEGIN

INSERT INTO t_doc_hab (ID_DOC_HAB, DNI_DOC,ID_HAB,FECHA,MONTO_HAB) VALUES(SID_DOC_HAB, SDNI_DOC,SID_HAB,SFECHA,SMONTO_HAB);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_establecimiento` (IN `SID_ESTABLECIMIENTO` INT(10), IN `SCOD_ESTABLECIMIENTO` CHAR(8), IN `SESTABLECIMIENTO` VARCHAR(100), IN `SSEDE_UGEL` VARCHAR(50))  NO SQL
BEGIN

INSERT INTO t_establecimiento (ID_ESTAB, COD_ESTABLECIMIENTO,ESTABLECIMIENTO,SEDE_UGEL) VALUES(SID_ESTABLECIMIENTO, SCOD_ESTABLECIMIENTO,SESTABLECIMIENTO,SSEDE_UGEL);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_haberes` (IN `SID_HABER` INT(10), IN `SNOMBRE_HABER` VARCHAR(50))  NO SQL
BEGIN

INSERT INTO t_haberes (ID_HAB, NOMBRE_HAB) VALUES(SID_HABER, SNOMBRE_HABER);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `lista_descuentos` ()  NO SQL
SELECT * from t_descuentos$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `lista_docente` ()  NO SQL
SELECT * FROM t_docente$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `lista_doc_des` ()  NO SQL
SELECT * FROM t_doc_desc$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `lista_doc_hab` ()  NO SQL
SELECT * FROM t_doc_hab$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `lista_establecimiento` ()  NO SQL
SELECT * FROM t_establecimiento$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `lista_haberes` ()  NO SQL
SELECT * from t_haberes$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `reporte_buscar_descuento` (IN `anio` VARCHAR(10), IN `mes` VARCHAR(10), IN `dni` VARCHAR(8))  NO SQL
SELECT t_descuentos.ID_DES,t_descuentos.NOMBRE_DESC,t_doc_desc.MONTO_DES,t_docente.NOMBRE , t_docente.AP_PATERNO,t_docente.AP_MATERNO FROM t_descuentos INNER JOIN t_doc_desc ON t_descuentos.ID_DES = t_doc_desc.ID_DOC_DESC INNER JOIN t_docente ON t_doc_desc.DNI_DOC=t_docente.DNI_DOC WHERE RIGHT((t_doc_desc.FECHA),2)=mes AND LEFT((t_doc_desc.FECHA),4)=anio AND t_docente.DNI_DOC=dni$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `reporte_buscar_hab` (IN `anio` VARCHAR(10), IN `mes` VARCHAR(10), IN `dni` VARCHAR(8))  NO SQL
SELECT t_haberes.ID_HAB,t_haberes.NOMBRE_HAB,t_doc_hab.MONTO_HAB,t_docente.NOMBRE , t_docente.AP_PATERNO,t_docente.AP_MATERNO FROM t_haberes INNER JOIN t_doc_hab ON t_haberes.ID_HAB = t_doc_hab.ID_HAB INNER JOIN t_docente ON t_doc_hab.DNI_DOC=t_docente.DNI_DOC WHERE RIGHT((t_doc_hab.FECHA),2)=mes
 AND LEFT((t_doc_hab.FECHA),4)=anio AND t_docente.DNI_DOC=dni$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `t_descuentos`
--

CREATE TABLE `t_descuentos` (
  `ID_DES` int(10) NOT NULL,
  `NOMBRE_DESC` char(8) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `t_descuentos`
--

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
-- Estructura de tabla para la tabla `t_docente`
--

CREATE TABLE `t_docente` (
  `DNI_DOC` char(8) COLLATE utf8_spanish_ci NOT NULL,
  `ID_ESTAB` int(10) NOT NULL,
  `COD_MOD` char(8) COLLATE utf8_spanish_ci DEFAULT NULL,
  `TIPO` varchar(5) COLLATE utf8_spanish_ci DEFAULT NULL,
  `CUENTA_BANCARIA` char(12) COLLATE utf8_spanish_ci DEFAULT NULL,
  `NOMBRE` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `AP_PATERNO` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `AP_MATERNO` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `t_docente`
--

INSERT INTO `t_docente` (`DNI_DOC`, `ID_ESTAB`, `COD_MOD`, `TIPO`, `CUENTA_BANCARIA`, `NOMBRE`, `AP_PATERNO`, `AP_MATERNO`) VALUES
('41223245', 1, '42424242', 'A', '0193313203', 'Cristian', 'Cueva', 'aladino'),
('4312434', 1, '21144444', 'A', '120102122315', 'Edison', 'Florez', 'Orejas'),
('44231255', 1, '00123222', 'A', '014121345612', 'Raul', 'Sarmiento', 'Perez');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `t_doc_desc`
--

CREATE TABLE `t_doc_desc` (
  `ID_DOC_DESC` int(10) NOT NULL,
  `DNI_DOC` char(8) COLLATE utf8_spanish_ci NOT NULL,
  `ID_DES` int(10) NOT NULL,
  `FECHA` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `MONTO_DES` decimal(8,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `t_doc_desc`
--

INSERT INTO `t_doc_desc` (`ID_DOC_DESC`, `DNI_DOC`, `ID_DES`, `FECHA`, `MONTO_DES`) VALUES
(1, '44231255', 1, '200302', '30.00'),
(2, '44231255', 2, '200302', '10.00'),
(3, '44231255', 3, '200302', '30.00'),
(4, '44231255', 4, '200302', '10.00'),
(5, '44231255', 5, '200302', '15.00'),
(6, '44231255', 6, '200302', '20.50'),
(7, '44231255', 7, '200302', '20.50'),
(8, '44231255', 8, '200302', '10.00'),
(9, '44231255', 11, '200302', '30.00'),
(10, '44231255', 13, '200302', '110.50'),
(11, '44231255', 19, '200302', '200.00'),
(12, '44231255', 22, '200302', '159.00'),
(13, '44231255', 30, '200302', '50.00'),
(14, '4312434', 1, '200301', '200.00'),
(15, '4312434', 2, '200301', '100.00'),
(16, '4312434', 8, '200301', '101.00'),
(17, '4312434', 27, '200301', '500.00'),
(18, '4312434', 2, '200312', '300.00'),
(19, '4312434', 13, '200312', '100.00'),
(20, '4312434', 14, '200312', '50.00'),
(21, '4312434', 24, '200312', '20.00'),
(22, '4312434', 26, '200312', '400.00'),
(23, '41223245', 19, '200301', '200.00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `t_doc_hab`
--

CREATE TABLE `t_doc_hab` (
  `ID_DOC_HAB` int(10) NOT NULL,
  `DNI_DOC` char(8) COLLATE utf8_spanish_ci NOT NULL,
  `ID_HAB` int(10) NOT NULL,
  `FECHA` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `MONTO_HAB` decimal(8,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `t_doc_hab`
--

INSERT INTO `t_doc_hab` (`ID_DOC_HAB`, `DNI_DOC`, `ID_HAB`, `FECHA`, `MONTO_HAB`) VALUES
(1, '44231255', 1, '200301', '50.00'),
(2, '44231255', 1, '200302', '1500.00'),
(3, '44231255', 2, '200302', '200.00'),
(4, '44231255', 3, '200302', '100.00'),
(5, '44231255', 6, '200302', '50.00'),
(6, '44231255', 8, '200302', '120.50'),
(7, '44231255', 12, '200302', '300.00'),
(8, '44231255', 27, '200302', '30.00'),
(9, '44231255', 29, '200302', '15.00'),
(10, '4312434', 1, '200301', '1500.00'),
(11, '4312434', 2, '200301', '300.00'),
(12, '4312434', 3, '200301', '100.00'),
(13, '4312434', 6, '200301', '50.00'),
(14, '4312434', 12, '200301', '200.00'),
(15, '4312434', 26, '200301', '100.00'),
(16, '4312434', 1, '200312', '1500.00'),
(17, '4312434', 6, '200312', '200.00'),
(18, '4312434', 9, '200312', '300.00'),
(19, '4312434', 12, '200312', '150.00'),
(20, '4312434', 25, '200312', '100.00'),
(21, '41223245', 1, '200301', '500.00'),
(22, '41223245', 2, '200301', '300.00'),
(23, '41223245', 24, '200301', '150.00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `t_establecimiento`
--

CREATE TABLE `t_establecimiento` (
  `ID_ESTAB` int(10) NOT NULL,
  `COD_ESTABLECIMIENTO` char(8) COLLATE utf8_spanish_ci DEFAULT NULL,
  `ESTABLECIMIENTO` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  `SEDE_UGEL` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `t_establecimiento`
--

INSERT INTO `t_establecimiento` (`ID_ESTAB`, `COD_ESTABLECIMIENTO`, `ESTABLECIMIENTO`, `SEDE_UGEL`) VALUES
(1, 'B0D12211', 'MIGUEL GRAU', 'Abancay');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `t_haberes`
--

CREATE TABLE `t_haberes` (
  `ID_HAB` int(10) NOT NULL,
  `NOMBRE_HAB` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `t_haberes`
--

INSERT INTO `t_haberes` (`ID_HAB`, `NOMBRE_HAB`) VALUES
(1, 'SueldoBase'),
(2, 'Bonifpersonal'),
(3, 'TPhomF'),
(4, 'TPhumL'),
(5, 'Diferenc'),
(6, 'Familiar'),
(7, 'Refmov'),
(8, 'Encargos'),
(9, 'Contrato'),
(10, 'Bondir'),
(11, 'Ds021'),
(12, 'Aguinaldo'),
(13, 'Bespecifico'),
(14, 'Reunific'),
(15, 'Igv'),
(16, 'CTsca'),
(17, 'N172567119'),
(18, 'PRjuco'),
(19, 'Palmaju'),
(20, 'Gults'),
(21, 'L26504'),
(22, 'Cdeveng'),
(23, 'DL25897'),
(24, 'Palmamas'),
(25, 'Direc'),
(26, 'DU9096'),
(27, 'DU7397'),
(28, 'DU1199'),
(29, 'DU10501');

-- --------------------------------------------------------

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
-- Indices de la tabla `t_descuentos`
--
ALTER TABLE `t_descuentos`
  ADD PRIMARY KEY (`ID_DES`);

--
-- Indices de la tabla `t_docente`
--
ALTER TABLE `t_docente`
  ADD PRIMARY KEY (`DNI_DOC`),
  ADD KEY `ID_ESTAB` (`ID_ESTAB`);

--
-- Indices de la tabla `t_doc_desc`
--
ALTER TABLE `t_doc_desc`
  ADD PRIMARY KEY (`ID_DOC_DESC`),
  ADD KEY `DNI_DOC` (`DNI_DOC`),
  ADD KEY `ID_DES` (`ID_DES`);

--
-- Indices de la tabla `t_doc_hab`
--
ALTER TABLE `t_doc_hab`
  ADD PRIMARY KEY (`ID_DOC_HAB`),
  ADD KEY `DNI_DOC` (`DNI_DOC`),
  ADD KEY `ID_HAB` (`ID_HAB`);

--
-- Indices de la tabla `t_establecimiento`
--
ALTER TABLE `t_establecimiento`
  ADD PRIMARY KEY (`ID_ESTAB`);

--
-- Indices de la tabla `t_haberes`
--
ALTER TABLE `t_haberes`
  ADD PRIMARY KEY (`ID_HAB`);

--
-- Indices de la tabla `t_usuario`
--
ALTER TABLE `t_usuario`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `t_descuentos`
--
ALTER TABLE `t_descuentos`
  MODIFY `ID_DES` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;
--
-- AUTO_INCREMENT de la tabla `t_doc_desc`
--
ALTER TABLE `t_doc_desc`
  MODIFY `ID_DOC_DESC` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;
--
-- AUTO_INCREMENT de la tabla `t_doc_hab`
--
ALTER TABLE `t_doc_hab`
  MODIFY `ID_DOC_HAB` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;
--
-- AUTO_INCREMENT de la tabla `t_establecimiento`
--
ALTER TABLE `t_establecimiento`
  MODIFY `ID_ESTAB` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `t_haberes`
--
ALTER TABLE `t_haberes`
  MODIFY `ID_HAB` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;
--
-- AUTO_INCREMENT de la tabla `t_usuario`
--
ALTER TABLE `t_usuario`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `t_docente`
--
ALTER TABLE `t_docente`
  ADD CONSTRAINT `t_docente_ibfk_1` FOREIGN KEY (`ID_ESTAB`) REFERENCES `t_establecimiento` (`ID_ESTAB`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `t_doc_desc`
--
ALTER TABLE `t_doc_desc`
  ADD CONSTRAINT `t_doc_desc_ibfk_1` FOREIGN KEY (`DNI_DOC`) REFERENCES `t_docente` (`DNI_DOC`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `t_doc_desc_ibfk_2` FOREIGN KEY (`ID_DES`) REFERENCES `t_descuentos` (`ID_DES`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `t_doc_hab`
--
ALTER TABLE `t_doc_hab`
  ADD CONSTRAINT `t_doc_hab_ibfk_1` FOREIGN KEY (`DNI_DOC`) REFERENCES `t_docente` (`DNI_DOC`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `t_doc_hab_ibfk_2` FOREIGN KEY (`ID_HAB`) REFERENCES `t_haberes` (`ID_HAB`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
