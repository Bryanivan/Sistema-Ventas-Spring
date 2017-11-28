-- MySQL dump 10.13  Distrib 5.7.18, for Win64 (x86_64)
--
-- Host: localhost    Database: cyg
-- ------------------------------------------------------
-- Server version	5.7.18-log

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
-- Table structure for table `almacen`
--

DROP TABLE IF EXISTS `almacen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `almacen` (
  `idalmacen` int(11) NOT NULL AUTO_INCREMENT,
  `nombrealma` varchar(45) NOT NULL,
  `direccionalma` varchar(45) NOT NULL,
  `telefonoalma` varchar(12) NOT NULL,
  PRIMARY KEY (`idalmacen`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `almacen`
--

LOCK TABLES `almacen` WRITE;
/*!40000 ALTER TABLE `almacen` DISABLE KEYS */;
/*!40000 ALTER TABLE `almacen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clientes` (
  `idclie` int(11) NOT NULL AUTO_INCREMENT,
  `rucdniclie` char(11) NOT NULL,
  `fullnameclie` varchar(100) NOT NULL,
  `direccionfiscalclie` varchar(60) DEFAULT NULL,
  `direccionentregaclie` varchar(60) NOT NULL,
  `telefonoclie` varchar(12) NOT NULL,
  `emailclie` varchar(60) DEFAULT NULL,
  `estadostablas_idestadostabla` int(11) DEFAULT NULL,
  PRIMARY KEY (`idclie`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (1,'76935184','Carlos Chavez Laguna','por ahí','por aca','948110940','carloscl94r@gmail.com',7),(2,'123456','Jair Tarazona','aquí','debajo de mi pantalón','3252562','tarazona.jair@cucardas.com',6);
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `descripcionestados`
--

DROP TABLE IF EXISTS `descripcionestados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `descripcionestados` (
  `iddescripcionestados` int(11) NOT NULL AUTO_INCREMENT,
  `descripciondese` varchar(45) NOT NULL,
  PRIMARY KEY (`iddescripcionestados`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `descripcionestados`
--

LOCK TABLES `descripcionestados` WRITE;
/*!40000 ALTER TABLE `descripcionestados` DISABLE KEYS */;
INSERT INTO `descripcionestados` VALUES (1,'habilitado'),(2,'deshabilitado'),(3,'operativo'),(4,'en reparación'),(5,'malogrado'),(6,'generada'),(7,'cancelada'),(8,'anulada');
/*!40000 ALTER TABLE `descripcionestados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detallefactura`
--

DROP TABLE IF EXISTS `detallefactura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detallefactura` (
  `productos_idprod` int(11) NOT NULL,
  `cantidaddetf` varchar(45) DEFAULT NULL,
  `descuentodetf` varchar(45) DEFAULT NULL,
  `importedetf` varchar(45) DEFAULT NULL,
  `notaventas_idnotadeventa` int(11) DEFAULT NULL,
  `factura_idfactura` int(11) DEFAULT NULL,
  PRIMARY KEY (`productos_idprod`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detallefactura`
--

LOCK TABLES `detallefactura` WRITE;
/*!40000 ALTER TABLE `detallefactura` DISABLE KEYS */;
/*!40000 ALTER TABLE `detallefactura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalleordencompras`
--

DROP TABLE IF EXISTS `detalleordencompras`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detalleordencompras` (
  `productos_idprod` int(11) NOT NULL,
  `ordencompras_idordendecompra` int(11) NOT NULL,
  `cantidaddeoc` varchar(45) NOT NULL,
  `preciocompradeoc` varchar(45) NOT NULL,
  PRIMARY KEY (`productos_idprod`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalleordencompras`
--

LOCK TABLES `detalleordencompras` WRITE;
/*!40000 ALTER TABLE `detalleordencompras` DISABLE KEYS */;
/*!40000 ALTER TABLE `detalleordencompras` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleados`
--

DROP TABLE IF EXISTS `empleados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `empleados` (
  `idempl` int(11) NOT NULL AUTO_INCREMENT,
  `nombreempl` varchar(60) NOT NULL,
  `apellidopaternoempl` varchar(45) NOT NULL,
  `apellidomaternoempl` varchar(45) DEFAULT NULL,
  `dniempl` char(8) NOT NULL,
  `sueldoempl` decimal(10,2) DEFAULT NULL,
  `telefonoempl` varchar(45) DEFAULT NULL,
  `tipoempleados_idtipe` int(11) NOT NULL,
  `user_iduser` int(11) NOT NULL,
  `estadostablas_idestadostabla` int(11) NOT NULL,
  PRIMARY KEY (`idempl`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleados`
--

LOCK TABLES `empleados` WRITE;
/*!40000 ALTER TABLE `empleados` DISABLE KEYS */;
/*!40000 ALTER TABLE `empleados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estadostablas`
--

DROP TABLE IF EXISTS `estadostablas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estadostablas` (
  `idestadostabla` int(11) NOT NULL AUTO_INCREMENT,
  `nametabla` varchar(45) DEFAULT NULL,
  `descripcionestados_iddescripcionestados` int(11) NOT NULL,
  PRIMARY KEY (`idestadostabla`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estadostablas`
--

LOCK TABLES `estadostablas` WRITE;
/*!40000 ALTER TABLE `estadostablas` DISABLE KEYS */;
INSERT INTO `estadostablas` VALUES (1,'proveedor',1),(2,'proveedor',2),(3,'producto',3),(4,'producto',4),(5,'producto',5),(6,'cliente',1),(7,'cliente',2),(8,'empleado',1),(9,'empleado',2),(10,'factura',6),(11,'factura',7),(12,'factura',8),(13,'notaventa',6),(14,'notaventa',7),(15,'notaventa',8);
/*!40000 ALTER TABLE `estadostablas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `factura`
--

DROP TABLE IF EXISTS `factura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `factura` (
  `idfactura` int(11) NOT NULL,
  `numerofact` char(11) NOT NULL,
  `fechaemisionfact` datetime NOT NULL,
  `fechavencimientofact` datetime DEFAULT NULL,
  `subtotal` decimal(10,2) DEFAULT NULL,
  `descuento` decimal(10,2) DEFAULT NULL,
  `igv` decimal(10,2) DEFAULT NULL,
  `total` decimal(10,2) DEFAULT NULL,
  `empleados_idempl` int(11) NOT NULL,
  `plazopago_idplazopago` int(11) NOT NULL,
  `guiaremicion_idguiaremicion` int(11) DEFAULT NULL,
  `estadostablas_idestadostabla` int(11) NOT NULL,
  `clientes_idclie` int(11) NOT NULL,
  PRIMARY KEY (`idfactura`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `factura`
--

LOCK TABLES `factura` WRITE;
/*!40000 ALTER TABLE `factura` DISABLE KEYS */;
/*!40000 ALTER TABLE `factura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `guiaremicion`
--

DROP TABLE IF EXISTS `guiaremicion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `guiaremicion` (
  `idguiaremicion` int(11) NOT NULL,
  `conductorguir` varchar(45) DEFAULT NULL,
  `tipomovilidad_idtipomovilidad` int(11) NOT NULL,
  `movilidad_idmovilidad` int(11) DEFAULT NULL,
  `almacen_idalmacen` int(11) NOT NULL,
  `clientes_idclie` int(11) NOT NULL,
  PRIMARY KEY (`idguiaremicion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `guiaremicion`
--

LOCK TABLES `guiaremicion` WRITE;
/*!40000 ALTER TABLE `guiaremicion` DISABLE KEYS */;
/*!40000 ALTER TABLE `guiaremicion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `logusuario`
--

DROP TABLE IF EXISTS `logusuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `logusuario` (
  `timekeeplogu` datetime NOT NULL,
  `tablaslogu` varchar(45) DEFAULT NULL,
  `tipohistorialuser_idtipohistorialuser` int(11) NOT NULL,
  `sesiones_idsesiones` int(11) NOT NULL,
  PRIMARY KEY (`tipohistorialuser_idtipohistorialuser`,`sesiones_idsesiones`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `logusuario`
--

LOCK TABLES `logusuario` WRITE;
/*!40000 ALTER TABLE `logusuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `logusuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movilidad`
--

DROP TABLE IF EXISTS `movilidad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `movilidad` (
  `idmovilidad` int(11) NOT NULL AUTO_INCREMENT,
  `placamovi` varchar(45) DEFAULT NULL,
  `descripcionmovi` varchar(45) DEFAULT NULL,
  `marca` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idmovilidad`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movilidad`
--

LOCK TABLES `movilidad` WRITE;
/*!40000 ALTER TABLE `movilidad` DISABLE KEYS */;
/*!40000 ALTER TABLE `movilidad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notaventas`
--

DROP TABLE IF EXISTS `notaventas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `notaventas` (
  `idnotadeventa` int(11) NOT NULL AUTO_INCREMENT,
  `fechaemisionnotv` datetime DEFAULT NULL,
  `subtotalnotv` decimal(10,2) DEFAULT NULL,
  `descuentonotv` decimal(10,2) DEFAULT NULL,
  `igvnotv` decimal(10,2) DEFAULT NULL,
  `totalnotv` decimal(10,2) DEFAULT NULL,
  `plazopago_idplazopago` int(11) NOT NULL,
  `clientes_idclie` int(11) NOT NULL,
  PRIMARY KEY (`idnotadeventa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notaventas`
--

LOCK TABLES `notaventas` WRITE;
/*!40000 ALTER TABLE `notaventas` DISABLE KEYS */;
/*!40000 ALTER TABLE `notaventas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ordencompras`
--

DROP TABLE IF EXISTS `ordencompras`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ordencompras` (
  `idordendecompra` int(11) NOT NULL AUTO_INCREMENT,
  `numeroguiaordc` varchar(45) NOT NULL,
  `proveedor_idprov` int(11) NOT NULL,
  `subtotalordc` decimal(10,2) NOT NULL,
  `igvordc` decimal(10,2) NOT NULL,
  `totalordc` decimal(10,2) NOT NULL,
  `fechaordc` datetime NOT NULL,
  PRIMARY KEY (`idordendecompra`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordencompras`
--

LOCK TABLES `ordencompras` WRITE;
/*!40000 ALTER TABLE `ordencompras` DISABLE KEYS */;
/*!40000 ALTER TABLE `ordencompras` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `plazopago`
--

DROP TABLE IF EXISTS `plazopago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `plazopago` (
  `idplazopago` int(11) NOT NULL AUTO_INCREMENT,
  `descripcionplap` varchar(45) NOT NULL,
  PRIMARY KEY (`idplazopago`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plazopago`
--

LOCK TABLES `plazopago` WRITE;
/*!40000 ALTER TABLE `plazopago` DISABLE KEYS */;
INSERT INTO `plazopago` VALUES (1,'Al contado'),(2,'Siete'),(3,'Quince');
/*!40000 ALTER TABLE `plazopago` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productos`
--

DROP TABLE IF EXISTS `productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `productos` (
  `idprod` int(11) NOT NULL AUTO_INCREMENT,
  `descripcionprod` varchar(45) DEFAULT NULL,
  `preciocompraprod` decimal(10,2) NOT NULL,
  `precioventacontadoprod` decimal(10,2) DEFAULT NULL,
  `precioventasieteprod` decimal(10,2) DEFAULT NULL,
  `precioventaquinceprod` decimal(10,2) DEFAULT NULL,
  `stockprod` int(11) NOT NULL,
  `estadostablas_idestadostabla` int(11) DEFAULT NULL,
  `proveedor_idprov` int(11) DEFAULT NULL,
  PRIMARY KEY (`idprod`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` VALUES (1,'comida de perro dog chow',550.00,60.55,600.00,1000.00,300,3,NULL),(2,'Detergente',1.50,2.50,20.00,30.00,100,3,NULL),(3,'Cerveza pilsen callao',1.50,55.00,20.00,300.00,1000,5,NULL),(4,'arduino',20.00,45.00,150.00,300.00,200,3,NULL),(5,'chinuino',20.00,30.00,60.00,120.00,1,3,NULL);
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedor`
--

DROP TABLE IF EXISTS `proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `proveedor` (
  `idprov` int(11) NOT NULL AUTO_INCREMENT,
  `razonsocialprov` varchar(100) NOT NULL,
  `rucprov` char(11) NOT NULL,
  `emailprov` varchar(45) DEFAULT NULL,
  `telefonoprov` varchar(12) DEFAULT NULL,
  `estadostablas_idestadostabla` int(11) DEFAULT NULL,
  PRIMARY KEY (`idprov`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedor`
--

LOCK TABLES `proveedor` WRITE;
/*!40000 ALTER TABLE `proveedor` DISABLE KEYS */;
INSERT INTO `proveedor` VALUES (1,'Pet Society','123454321','contacto@petsociety.com','95112399',1),(2,'Cucardas','98875123','contacto@cucardas.com','91231239',1);
/*!40000 ALTER TABLE `proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `roles` (
  `idroles` int(11) NOT NULL AUTO_INCREMENT,
  `descripcionrole` varchar(45) NOT NULL,
  `pesta├▒asrole` text,
  PRIMARY KEY (`idroles`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sesiones`
--

DROP TABLE IF EXISTS `sesiones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sesiones` (
  `idsesiones` int(11) NOT NULL AUTO_INCREMENT,
  `timeinitsesi` datetime DEFAULT NULL,
  `descripcionsesi` text,
  `iduser` int(11) DEFAULT NULL,
  `timefinishses` datetime DEFAULT NULL,
  PRIMARY KEY (`idsesiones`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sesiones`
--

LOCK TABLES `sesiones` WRITE;
/*!40000 ALTER TABLE `sesiones` DISABLE KEYS */;
/*!40000 ALTER TABLE `sesiones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipoempleados`
--

DROP TABLE IF EXISTS `tipoempleados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipoempleados` (
  `idtipe` int(11) NOT NULL AUTO_INCREMENT,
  `descripciontipe` varchar(45) NOT NULL,
  PRIMARY KEY (`idtipe`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipoempleados`
--

LOCK TABLES `tipoempleados` WRITE;
/*!40000 ALTER TABLE `tipoempleados` DISABLE KEYS */;
INSERT INTO `tipoempleados` VALUES (1,'administrador'),(2,'vendedor'),(3,'supervisor'),(4,'almacenero');
/*!40000 ALTER TABLE `tipoempleados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipohistorialuser`
--

DROP TABLE IF EXISTS `tipohistorialuser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipohistorialuser` (
  `idtipohistorialuser` int(11) NOT NULL AUTO_INCREMENT,
  `descripciontihu` varchar(100) NOT NULL,
  PRIMARY KEY (`idtipohistorialuser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipohistorialuser`
--

LOCK TABLES `tipohistorialuser` WRITE;
/*!40000 ALTER TABLE `tipohistorialuser` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipohistorialuser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipomovilidad`
--

DROP TABLE IF EXISTS `tipomovilidad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipomovilidad` (
  `idtipomovilidad` int(11) NOT NULL AUTO_INCREMENT,
  `descripiontipm` varchar(45) NOT NULL,
  PRIMARY KEY (`idtipomovilidad`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipomovilidad`
--

LOCK TABLES `tipomovilidad` WRITE;
/*!40000 ALTER TABLE `tipomovilidad` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipomovilidad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `iduser` int(11) NOT NULL AUTO_INCREMENT,
  `usuariouser` varchar(45) NOT NULL,
  `passworduser` varchar(45) NOT NULL,
  `roles_idroles` int(11) DEFAULT NULL,
  `auth_token` varchar(128) DEFAULT NULL,
  `remember_token` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`iduser`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (2,'admin','admin',NULL,NULL,NULL),(3,'carlos','12345',NULL,NULL,NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-11-28 13:03:05
