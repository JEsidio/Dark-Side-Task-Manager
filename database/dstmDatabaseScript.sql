-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema dstmdatabase
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema dstmdatabase
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `dstmdatabase` DEFAULT CHARACTER SET utf8 ;
USE `dstmdatabase` ;

-- -----------------------------------------------------
-- Table `dstmdatabase`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dstmdatabase`.`user` (
  `idUser` INT NOT NULL AUTO_INCREMENT COMMENT 'Identification of each user',
  `userName` VARCHAR(255) NOT NULL COMMENT 'User name to show on the home page of the dstm app',
  `userEmail` VARCHAR(250) NOT NULL COMMENT 'User e-mail for the login verification and possible password reset',
  `userPassword` VARCHAR(250) NOT NULL COMMENT 'User password for the login verification',
  PRIMARY KEY (`idUser`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dstmdatabase`.`task`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dstmdatabase`.`task` (
  `idTask` INT NOT NULL AUTO_INCREMENT COMMENT 'Identification of each task, showed as task number on the home page table',
  `task` VARCHAR(250) NOT NULL COMMENT 'Task itself',
  `taskEnd` DATE NOT NULL COMMENT 'Task deadline',
  `marker` VARCHAR(250) NULL COMMENT 'Marker to organize tasks based on user\'s need, for example: #school; #work; #home',
  `inFinished` INT NOT NULL COMMENT 'Status of the task if it was finished or not, 0 for unfinished and 1 for finished',
  `inStatus` INT NOT NULL COMMENT 'Status of the task if it was deleted or not, 0 for undeleted and 1 for deleted',
  `user_idUser` INT NOT NULL COMMENT 'Foreign key of idUser to safely save tasks of each user',
  PRIMARY KEY (`idTask`, `user_idUser`),
  INDEX `fk_task_user1_idx` (`user_idUser` ASC),
  CONSTRAINT `fk_task_user1`
    FOREIGN KEY (`user_idUser`)
    REFERENCES `dstmdatabase`.`user` (`idUser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dstmdatabase`.`logado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dstmdatabase`.`logado` (
  `idLogado` INT NOT NULL AUTO_INCREMENT COMMENT 'Id of the session',
  `idUsuarioLogado` VARCHAR(45) NOT NULL COMMENT 'Id of the user that is logging in\n',
  `user_idUser` INT NOT NULL,
  PRIMARY KEY (`idLogado`, `user_idUser`),
  INDEX `fk_logado_user1_idx` (`user_idUser` ASC),
  CONSTRAINT `fk_logado_user1`
    FOREIGN KEY (`user_idUser`)
    REFERENCES `dstmdatabase`.`user` (`idUser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
