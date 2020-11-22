-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           10.4.13-MariaDB - mariadb.org binary distribution
-- OS do Servidor:               Win64
-- HeidiSQL Versão:              11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Copiando estrutura do banco de dados para db_hdb
CREATE DATABASE IF NOT EXISTS `db_hdb` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `db_hdb`;

-- Copiando estrutura para tabela db_hdb.pacientes
CREATE TABLE IF NOT EXISTS `pacientes` (
  `cpf` int(11) NOT NULL,
  `nome` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`cpf`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Copiando dados para a tabela db_hdb.pacientes: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `pacientes` DISABLE KEYS */;
/*!40000 ALTER TABLE `pacientes` ENABLE KEYS */;

-- Copiando estrutura para tabela db_hdb.prontuarios
CREATE TABLE IF NOT EXISTS `prontuarios` (
  `Cod_Prontuario` int(11) NOT NULL AUTO_INCREMENT,
  `Num_Prontuario` int(11) DEFAULT 0,
  `DataAbertura_Prontuario` varchar(50) DEFAULT NULL,
  `NomePaciente_Prontuario` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Cod_Prontuario`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

-- Copiando dados para a tabela db_hdb.prontuarios: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `prontuarios` DISABLE KEYS */;
INSERT IGNORE INTO `prontuarios` (`Cod_Prontuario`, `Num_Prontuario`, `DataAbertura_Prontuario`, `NomePaciente_Prontuario`) VALUES
	(1, 1, '01/11/2020', 'Igor'),
	(2, 2, '01/11/2020', 'Sara'),
	(3, 3, '01/11/2020', 'Hellen'),
	(4, 4, '22/11/2020', 'Miguel');
/*!40000 ALTER TABLE `prontuarios` ENABLE KEYS */;

-- Copiando estrutura para tabela db_hdb.sql_sequence
CREATE TABLE IF NOT EXISTS `sql_sequence` (
  `name` varchar(50) DEFAULT NULL,
  `seq` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Copiando dados para a tabela db_hdb.sql_sequence: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `sql_sequence` DISABLE KEYS */;
/*!40000 ALTER TABLE `sql_sequence` ENABLE KEYS */;

-- Copiando estrutura para tabela db_hdb.usuarios
CREATE TABLE IF NOT EXISTS `usuarios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `usuario` varchar(50) NOT NULL DEFAULT '0',
  `nome` varchar(50) DEFAULT NULL,
  `senha` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- Copiando dados para a tabela db_hdb.usuarios: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT IGNORE INTO `usuarios` (`id`, `usuario`, `nome`, `senha`) VALUES
	(1, 'igor', 'Igor Oliveira', '123');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
