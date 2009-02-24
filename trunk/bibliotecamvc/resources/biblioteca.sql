-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.51b-community-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema biblioteca
--

CREATE DATABASE IF NOT EXISTS biblioteca;
USE biblioteca;

--
-- Definition of table `autor`
--

DROP TABLE IF EXISTS `autor`;
CREATE TABLE `autor` (
  `nombre_autor` varchar(50) NOT NULL,
  PRIMARY KEY  (`nombre_autor`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `autor`
--

/*!40000 ALTER TABLE `autor` DISABLE KEYS */;
/*!40000 ALTER TABLE `autor` ENABLE KEYS */;


--
-- Definition of table `genero`
--

DROP TABLE IF EXISTS `genero`;
CREATE TABLE `genero` (
  `nombre_genero` varchar(50) NOT NULL,
  PRIMARY KEY  (`nombre_genero`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `genero`
--

/*!40000 ALTER TABLE `genero` DISABLE KEYS */;
/*!40000 ALTER TABLE `genero` ENABLE KEYS */;


--
-- Definition of table `libro`
--

DROP TABLE IF EXISTS `libro`;
CREATE TABLE `libro` (
  `fecha_publicacion` date NOT NULL,
  `prestado` tinyint(1) NOT NULL,
  `autor` varchar(50) NOT NULL,
  `genero` varchar(50) NOT NULL,
  `titulo` varchar(45) NOT NULL,
  `referencia` varchar(45) NOT NULL,
  PRIMARY KEY  USING BTREE (`referencia`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `libro`
--

/*!40000 ALTER TABLE `libro` DISABLE KEYS */;
/*!40000 ALTER TABLE `libro` ENABLE KEYS */;


--
-- Definition of table `prestamos`
--

DROP TABLE IF EXISTS `prestamos`;
CREATE TABLE `prestamos` (
  `referencia` varchar(50) NOT NULL,
  `mail` varchar(45) NOT NULL,
  `fechaInicio` date NOT NULL,
  `fechaFin` date NOT NULL,
  PRIMARY KEY  (`referencia`,`mail`,`fechaInicio`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `prestamos`
--

/*!40000 ALTER TABLE `prestamos` DISABLE KEYS */;
/*!40000 ALTER TABLE `prestamos` ENABLE KEYS */;


--
-- Definition of table `solicitudes`
--

DROP TABLE IF EXISTS `solicitudes`;
CREATE TABLE `solicitudes` (
  `mail` varchar(45) NOT NULL,
  `aceptada` tinyint(1) NOT NULL,
  PRIMARY KEY  (`mail`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `solicitudes`
--

/*!40000 ALTER TABLE `solicitudes` DISABLE KEYS */;
/*!40000 ALTER TABLE `solicitudes` ENABLE KEYS */;


--
-- Definition of table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE `usuarios` (
  `nombre` varchar(50) NOT NULL,
  `mail` varchar(45) NOT NULL,
  `clave` varchar(45) NOT NULL,
  `numPrestamos` tinyint(1) unsigned NOT NULL,
  `esRegistrado` tinyint(1) NOT NULL,
  `esAdministrador` tinyint(1) NOT NULL,
  PRIMARY KEY  (`mail`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `usuarios`
--

/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
