-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         5.6.13 - MySQL Community Server (GPL)
-- SO del servidor:              Win64
-- HeidiSQL Versión:             8.0.0.4396
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Volcando estructura de base de datos para banco
DROP DATABASE IF EXISTS `banco`;
CREATE DATABASE IF NOT EXISTS `banco` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `banco`;


-- Volcando estructura para tabla banco.cuentabancaria
DROP TABLE IF EXISTS `cuentabancaria`;
CREATE TABLE IF NOT EXISTS `cuentabancaria` (
  `idCuentaBancaria` int(10) NOT NULL,
  `sucursalBancaria` varchar(50) DEFAULT NULL,
  `numeroCuenta` varchar(50) DEFAULT NULL,
  `dc` varchar(50) DEFAULT NULL,
  `saldo` bigint(20) DEFAULT NULL,
  `cif` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idCuentaBancaria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla banco.cuentabancaria: ~1 rows (aproximadamente)
DELETE FROM `cuentabancaria`;
/*!40000 ALTER TABLE `cuentabancaria` DISABLE KEYS */;
INSERT INTO `cuentabancaria` (`idCuentaBancaria`, `sucursalBancaria`, `numeroCuenta`, `dc`, `saldo`, `cif`) VALUES
	(1, '1', '1', '1', 20, '1\r\n');
/*!40000 ALTER TABLE `cuentabancaria` ENABLE KEYS */;


-- Volcando estructura para tabla banco.entidadbancaria
DROP TABLE IF EXISTS `entidadbancaria`;
CREATE TABLE IF NOT EXISTS `entidadbancaria` (
  `idEntidad` int(11) NOT NULL AUTO_INCREMENT,
  `codigoEntidad` varchar(50) DEFAULT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `cif` varchar(50) DEFAULT NULL,
  `tipoEntidadBancaria` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idEntidad`),
  UNIQUE KEY `codigoEntidad` (`codigoEntidad`)
) ENGINE=InnoDB AUTO_INCREMENT=11874 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla banco.entidadbancaria: ~11 rows (aproximadamente)
DELETE FROM `entidadbancaria`;
/*!40000 ALTER TABLE `entidadbancaria` DISABLE KEYS */;
INSERT INTO `entidadbancaria` (`idEntidad`, `codigoEntidad`, `nombre`, `cif`, `tipoEntidadBancaria`) VALUES
	(1, '2222', 'banesto', '13131', 'Caja'),
	(2, '5555', 'CaixaGalicia', '33363', 'Banco'),
	(9, '7777', 'Deutche Bank', '55555', 'Banco'),
	(13, '5252', 'CaixaGalicia', '31363', 'Banco'),
	(14, '1522', 'PostABank', '31373', 'Caja'),
	(15, '4141', 'Caja Sol', '68726', 'Banco'),
	(19, '2212', 'banesto', '13131', 'Caja'),
	(83, '9898', 'Caja Cajona', '73277', 'Caja'),
	(267, '7979', 'LorenBank', '35578', 'Caja'),
	(3813, '5835', 'Bankia', '84123', 'Caja'),
	(11873, '8282', 'KikeBank', '98381', 'Banco');
/*!40000 ALTER TABLE `entidadbancaria` ENABLE KEYS */;


-- Volcando estructura para tabla banco.movimientobancario
DROP TABLE IF EXISTS `movimientobancario`;
CREATE TABLE IF NOT EXISTS `movimientobancario` (
  `idMovimientoBancario` int(10) NOT NULL,
  `tipoMovimientoBancario` int(10) DEFAULT NULL,
  `importe` int(10) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `saldoTotal` int(10) DEFAULT NULL,
  `concepto` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idMovimientoBancario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla banco.movimientobancario: ~0 rows (aproximadamente)
DELETE FROM `movimientobancario`;
/*!40000 ALTER TABLE `movimientobancario` DISABLE KEYS */;
/*!40000 ALTER TABLE `movimientobancario` ENABLE KEYS */;


-- Volcando estructura para tabla banco.sucursalbancaria
DROP TABLE IF EXISTS `sucursalbancaria`;
CREATE TABLE IF NOT EXISTS `sucursalbancaria` (
  `idSucursalBancaria` int(10) NOT NULL,
  `entidadBancaria` varchar(50) DEFAULT NULL,
  `codigoSucursal` int(10) DEFAULT NULL,
  `nombre` int(10) DEFAULT NULL,
  PRIMARY KEY (`idSucursalBancaria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla banco.sucursalbancaria: ~0 rows (aproximadamente)
DELETE FROM `sucursalbancaria`;
/*!40000 ALTER TABLE `sucursalbancaria` DISABLE KEYS */;
/*!40000 ALTER TABLE `sucursalbancaria` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
