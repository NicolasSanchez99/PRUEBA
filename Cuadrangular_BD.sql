-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Cuadrangular_BD
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Cuadrangular_BD
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Cuadrangular_BD` DEFAULT CHARACTER SET utf8 ;
USE `Cuadrangular_BD` ;

-- -----------------------------------------------------
-- Table `Cuadrangular_BD`.`city`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Cuadrangular_BD`.`city` (
  `Id_city` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `stadium` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Id_city`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Cuadrangular_BD`.`team`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Cuadrangular_BD`.`team` (
  `name` VARCHAR(45) NOT NULL,
  `points` VARCHAR(45) NOT NULL,
  `Id_team` INT NOT NULL,
  `city_Id_city` INT NOT NULL,
  INDEX `fk_team_city_idx` (`city_Id_city` ) ,
  PRIMARY KEY (`Id_team`),
  CONSTRAINT `fk_team_city`
    FOREIGN KEY (`city_Id_city`)
    REFERENCES `Cuadrangular_BD`.`city` (`Id_city`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Cuadrangular_BD`.`match`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Cuadrangular_BD`.`match` (
  `Id_match` INT NOT NULL,
  `date` VARCHAR(45) NOT NULL,
  `referee` VARCHAR(45) NOT NULL,
  `goals` VARCHAR(45) NOT NULL,
  `winner` VARCHAR(45) NOT NULL,
  `F_score` VARCHAR(45) NOT NULL,
  `HOME` INT NOT NULL,
  `AWAY` INT NOT NULL,
  PRIMARY KEY (`Id_match`),
  INDEX `fk_match_team1_idx` (`HOME` ) ,
  INDEX `fk_match_team2_idx` (`AWAY` ) ,
  CONSTRAINT `fk_match_team1`
    FOREIGN KEY (`HOME`)
    REFERENCES `Cuadrangular_BD`.`team` (`Id_team`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_match_team2`
    FOREIGN KEY (`AWAY`)
    REFERENCES `Cuadrangular_BD`.`team` (`Id_team`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
