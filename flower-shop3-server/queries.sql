-- MySQL Workbench Forward Engineering

-- drop database flowershop;
-- SET FOREIGN_KEY_CHECKS=0

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema flowershop
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema flowershop
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `flowershop` DEFAULT CHARACTER SET utf8 ;
USE `flowershop` ;

-- -----------------------------------------------------
-- Table `flowershop`.`Role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `flowershop`.`Role` (
  `id_role` INT NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id_role`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `flowershop`.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `flowershop`.`User` (
  `email` VARCHAR(255) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `phone_number` VARCHAR(15) NOT NULL,
  `first_name` VARCHAR(255) NOT NULL,
  `last_name` VARCHAR(255) NOT NULL,
  `client_address` VARCHAR(255) CHARACTER SET 'dec8' NOT NULL,
  `Role_id_role` INT NOT NULL,
  PRIMARY KEY (`email`, `Role_id_role`),
  INDEX `fk_User_Role1_idx` (`Role_id_role` ASC),
  CONSTRAINT `fk_User_Role1`
    FOREIGN KEY (`Role_id_role`)
    REFERENCES `flowershop`.`Role` (`id_role`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `flowershop`.`Admin`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `flowershop`.`Admin` (
  `email` VARCHAR(255) NOT NULL,
  `firstName` VARCHAR(255) NOT NULL,
  `lastName` VARCHAR(255) NOT NULL,
  `storeAddress` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`email`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `flowershop`.`Product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `flowershop`.`Product` (
  `id_product` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `description` VARCHAR(255) NOT NULL,
  `price` FLOAT NOT NULL,
  `stock` INT NOT NULL,
  `image` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id_product`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `flowershop`.`Orders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `flowershop`.`Orders` (
  `id_order` INT NOT NULL AUTO_INCREMENT,
  `delivery_address` VARCHAR(255) NOT NULL,
  `creation_date` DATE NOT NULL,
  `delivery_date` DATE NOT NULL,
  `quantity` INT NOT NULL,
  `Product_id_product` INT NOT NULL,
  `Client_email` VARCHAR(255),
  PRIMARY KEY (`id_order`),
  INDEX `fk_Order_Product1_idx` (`Product_id_product` ASC),
  INDEX `fk_Order_Client1_idx` (`Client_email` ASC),
  CONSTRAINT `fk_Order_Product1`
    FOREIGN KEY (`Product_id_product`)
    REFERENCES `flowershop`.`Product` (`id_product`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Order_Client1`
    FOREIGN KEY (`Client_email`)
    REFERENCES `flowershop`.`User` (`email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `flowershop`.`Right`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `flowershop`.`Right` (
  `id_right` INT NOT NULL AUTO_INCREMENT,
  `right` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id_right`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `flowershop`.`RoleRight`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `flowershop`.`RoleRight` (
  `id_Role_Roght` INT NOT NULL AUTO_INCREMENT,
  `Role_id_role` INT NOT NULL,
  `Right_id_right` INT NOT NULL,
  PRIMARY KEY (`id_Role_Roght`),
  INDEX `fk_Role_has_Right_Right1_idx` (`Right_id_right` ASC),
  INDEX `fk_Role_has_Right_Role1_idx` (`Role_id_role` ASC),
  CONSTRAINT `fk_Role_has_Right_Role1`
    FOREIGN KEY (`Role_id_role`)
    REFERENCES `flowershop`.`Role` (`id_role`),
  CONSTRAINT `fk_Role_has_Right_Right1`
    FOREIGN KEY (`Right_id_right`)
    REFERENCES `flowershop`.`Right` (`id_right`))
ENGINE = InnoDB;