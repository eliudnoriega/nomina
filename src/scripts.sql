-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 09-11-2017 a las 16:17:58
-- Versión del servidor: 10.1.25-MariaDB
-- Versión de PHP: 7.1.7
-- use mysql;
update user set password='root' where User='root';
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

INSERT INTO t_departamento ( COD_DEPARTAMENTO,DEPARTAMENTO,ID_EMPRESA) VALUES( SCOD_DEPARTAMENTO,SDEPARTAMENTO,SID_EMPRESA);;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;;

-- --------------------------------------------------------

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
