
-- -----------------------------------------------------
-- Schema agenda_db
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `agenda_db` ;

-- -----------------------------------------------------
-- Schema agenda_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `agenda_db` DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci ;
USE `agenda_db` ;

-- -----------------------------------------------------
-- Table `contactos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `contactos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `telefono` INT NOT NULL,
  `correo` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

INSERT INTO `contactos` (`id`, `nombre`, `telefono`, `correo`) VALUES
(NULL, 'Tamara Berrocal', '123456789', 'tamara@me.com'),
(NULL, 'Juan Padilla', '987654321', 'juanito@gmail.com'),
(NULL, 'Toni Moya', '123456789', 'tonitomate@me.com'),
(NULL, 'Pablo Morgade', '987654321', 'ptoon@gmail.com'),
(NULL, 'Alfonso Grande', '123456789', 'flappy@me.com'),
(NULL, 'Jesus Rufian', '987654321', 'juanito@gmail.com'),
(NULL, 'Cristina Lopez', '123456789', 'cris@me.com'),
(NULL, 'Pedro Lopez', '987654321', 'plopez@gmail.com'),
(NULL, 'Justino Fernandez', '123456789', 'justiPaLosColegas@me.com'),
(NULL, 'Maximiliano Rodriguez', '987654321', 'noMaxNoParty@gmail.com');


