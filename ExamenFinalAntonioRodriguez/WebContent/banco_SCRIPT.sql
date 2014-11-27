DROP DATABASE IF EXISTS `banco`;
CREATE DATABASE IF NOT EXISTS `banco` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `banco`;

DROP TABLE IF EXISTS `TarjetaCredito``;
CREATE TABLE IF NOT EXISTS `vehiculo` (
  `id` int(4) NOT NULL auto_increment,
  `numero` char(12) NOT NULL,
  `cupoMaximo` int(15) NOT NULL,
  `cupoMinimo` int(4) NOT NULL,
  `tipo` varchar(10) NOT NULL,
  `numeroComprobacion` int(7) NOT NULL,
  `contrasenha` varchar(4) NOT NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `matricula` (`matricula`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
