-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 09-11-2017 a las 16:17:58
-- Versión del servidor: 10.1.25-MariaDB
-- Versión de PHP: 7.1.7
-- use mysql;

-- Abner 13
-- update user set password='root' where User='root';
flush privileges;

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
SELECT a.ID_DEPARTAMENTO, a.COD_DEPARTAMENTO, a.DEPARTAMENTO, a.ID_EMPRESA, b.nombre EMPRESA FROM t_departamento a join empresa b on a.ID_EMPRESA=b.id WHERE a.DEPARTAMENTO LIKE parametro OR a.COD_DEPARTAMENTO LIKE parametro$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_departamento` (IN `SID_DEPARTAMENTO` INT(10), IN `SCOD_DEPARTAMENTO` CHAR(8), IN `SDEPARTAMENTO` VARCHAR(100), IN `SID_EMPRESA` VARCHAR(50))  NO SQL
BEGIN

INSERT INTO t_departamento ( COD_DEPARTAMENTO,DEPARTAMENTO,ID_EMPRESA) VALUES( SCOD_DEPARTAMENTO,SDEPARTAMENTO,SID_EMPRESA);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `lista_departamento` ()  NO SQL
SELECT a.ID_DEPARTAMENTO, a.COD_DEPARTAMENTO, a.DEPARTAMENTO, b.id id_empresa, b.nombre EMPRESA FROM t_departamento a join empresa b on a.ID_EMPRESA=b.id$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empresa`
--

CREATE TABLE `Empresa` (
  Id int(10) NOT NULL auto_increment,
  nombre VARCHAR(25),
  PRIMARY KEY(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

-- ---------------TABLA EMPLEADO  -------------------------

CREATE TABLE `t_empleado` (
  `DNI_EMP` char(8) COLLATE utf8_spanish_ci NOT NULL,				-- DNI_DOC  
  `ID_DEPARTAMENTO` int(10) NOT NULL,   							-- ID_ESTAB --! Tabla establecimiento / departamento
  `SALARIO` char(8) COLLATE utf8_spanish_ci DEFAULT NULL,			-- COD_MOD
  `PUESTO` varchar(10) COLLATE utf8_spanish_ci DEFAULT NULL,			-- TIPO
  `CUENTA_BANCARIA` char(12) COLLATE utf8_spanish_ci DEFAULT NULL,
  `NOMBRE` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `PRIMER_APE` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `SEGUNDO_APE` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `t_empleado`
--

INSERT INTO `t_empleado` 
-- (`DNI_DOC`, `ID_ESTAB`, `COD_MOD`, `TIPO`, `CUENTA_BANCARIA`, `NOMBRE`, `AP_PATERNO`, `AP_MATERNO`) VALUES
(`DNI_EMP`, `ID_DEPARTAMENTO`, `SALARIO`, `PUESTO`, `CUENTA_BANCARIA`, `NOMBRE`, `PRIMER_APE`, `SEGUNDO_APE`) VALUES
('41223245', 1, '5000', 'A', 'Jefe', 'Cristian', 'Cueva', 'aladino'),
('4312434', 1, '3000', 'A', 'Asistente', 'Edison', 'Florez', 'Orejas'),
('44231255', 1, '3000', 'A', 'Asistente', 'Raul', 'Sarmiento', 'Perez');

ALTER TABLE `t_empleado`
  ADD PRIMARY KEY (`DNI_EMP`),
  ADD KEY `ID_DEPARTAMENTO` (`ID_DEPARTAMENTO`);
-- FIN TABLA EMPLEADO ----------------------
--
-- Estructura de tabla para la tabla `t_departamento`
--

CREATE TABLE `t_departamento` (
  `ID_DEPARTAMENTO` int(10) NOT NULL,
  `COD_DEPARTAMENTO` char(8) COLLATE utf8_spanish_ci DEFAULT NULL,
  `DEPARTAMENTO` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  `ID_EMPRESA` int(10) NOT NULL,
  FOREIGN KEY (ID_EMPRESA) REFERENCES empresa(id),
  PRIMARY KEY (ID_DEPARTAMENTO)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

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
-- PROCEDIMIENTOS ALMACENADOS
DELIMITER $$
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

DELIMITER ;

-- FIN DE PROCEDIMIENTOS ALMACENADOS -- 
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
-- Restricciones para tablas volcadas
--


-- ------------------------------------- NUEVA VERSION


-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 09-11-2017 a las 16:17:58
-- Versión del servidor: 10.1.25-MariaDB
-- Versión de PHP: 7.1.7
-- use mysql;

-- Abner 13
--

DELIMITER $$
--
-- Procedimientos
--

-- Procedimientos para tabla Departamento
CREATE DEFINER=`root`@`localhost` PROCEDURE `departamento_buscar` (IN `parametro` VARCHAR(50))  NO SQL
SELECT a.ID_DEPARTAMENTO, a.COD_DEPARTAMENTO, a.DEPARTAMENTO FROM t_departamento a WHERE a.DEPARTAMENTO LIKE parametro OR a.COD_DEPARTAMENTO LIKE parametro$$

-- procedimiento cambiado 
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
-- Estructura de tabla para la tabla `t_departamento`
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


select * from nominat_departamento.t_departamento;
select * from nomina.t_planilla;



