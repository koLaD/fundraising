CREATE TABLE `fundraising`.`user`(  
  `Id` BIGINT NOT NULL AUTO_INCREMENT,
  `LoginName` VARCHAR(100),
  `UserName` VARCHAR(200),
  `PhoneNo` VARCHAR(50),
  `Password` VARCHAR(100),
  `UserStatus` INT,
  `Image` VARCHAR(500),
  `CreatedDate` DATETIME,
  `UpdatedDate` DATETIME,
  `CreatedUser_Id` BIGINT,
  `UpdatedUser_Id` BIGINT,
  PRIMARY KEY (`Id`)
);
ALTER TABLE `fundraising`.`user`   
  ADD COLUMN `UserRole_Id` BIGINT NULL AFTER `UpdatedUser_Id`,
  ADD CONSTRAINT `idfk1_userrole` FOREIGN KEY (`UserRole_Id`) REFERENCES `fundraising`.`user_role`(`Id`);


CREATE TABLE `fundraising`.`user_role`(  
  `Id` BIGINT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(100),
  `Description` VARCHAR(200),
  `CreatedDate` DATETIME,
  `UpdatedDate` DATETIME,
  `CreatedUser_Id` BIGINT,
  `UpdatedUser_Id` BIGINT,
  PRIMARY KEY (`Id`)
);

CREATE TABLE `fundraising`.`fundraising_project`(  
  `Id` BIGINT NOT NULL AUTO_INCREMENT,
  `Title` VARCHAR(500),
  `ShortDescritpion` VARCHAR(2000),
  `Descritpion` VARCHAR(8000),
  `GoalAmount` DOUBLE,
  `Image` VARCHAR(500),
  `CreatedDate` DATETIME,
  `UpdatedDate` DATETIME,
  `CreatedUser_Id` BIGINT,
  `UpdatedUser_Id` BIGINT,
  PRIMARY KEY (`Id`)
);

ALTER TABLE `fundraising`.`fundraising_project`   
  ADD COLUMN `Category_Id` BIGINT NULL AFTER `UpdatedUser_Id`,
  ADD CONSTRAINT `idfk1_category` FOREIGN KEY (`Category_Id`) REFERENCES `fundraising`.`category`(`Id`);


CREATE TABLE `fundraising`.`fundraiser`(  
  `Id` BIGINT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(200),
  `PhoneNo` VARCHAR(100),
  `Email` VARCHAR(200),
  `Image` VARCHAR(500),
  `Address` VARCHAR(1000),
  `Amount` DOUBLE,
  `CreatedDate` DATETIME,
  `UpdatedDate` DATETIME,
  `CreatedUser_Id` BIGINT,
  `UpdatedUser_Id` BIGINT,
  `FundraisingProject_Id` BIGINT,
  PRIMARY KEY (`Id`),
  CONSTRAINT `idfk1_fundraisingPrj` FOREIGN KEY (`FundraisingProject_Id`) REFERENCES `fundraising`.`fundraising_project`(`Id`)
);

CREATE TABLE `fundraising`.`category`(  
  `Id` BIGINT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(300),
  `Description` VARCHAR(1000),
  `CreatedDate` DATETIME,
  `UpdatedDate` DATETIME,
  `CreatedUser_Id` BINARY,
  `UpdatedUser_Id` BIGINT,
  PRIMARY KEY (`Id`)
);

ALTER TABLE `fundraising`.`fundraising_project`   
  ADD COLUMN `Status` VARCHAR(20) NULL AFTER `Category_Id`;

CREATE TABLE `fundraising`.`menu`(  
  `Id` BIGINT NOT NULL AUTO_INCREMENT,
  `Code` VARCHAR(100),
  `Description` VARCHAR(200),
  `OrderNo` INT,
  `Image` VARCHAR(500),
  `CratedDate` DATETIME,
  `UpdatedDate` DATETIME,
  `CreatedUser_Id` BIGINT,
  `UpdatedUser_Id` BIGINT,
  PRIMARY KEY (`Id`)
);

CREATE TABLE `fundraising`.`sub_menu`(  
  `Id` BIGINT NOT NULL AUTO_INCREMENT,
  `Code` VARCHAR(100),
  `Description` VARCHAR(200),
  `OrderNo` INT,
  `Url` VARCHAR(100),
  `Menu_Id` BIGINT,
  PRIMARY KEY (`Id`),
  CONSTRAINT `idfk_submenu1` FOREIGN KEY (`Menu_Id`) REFERENCES `fundraising`.`menu`(`Id`)
);
ALTER TABLE `fundraising`.`menu`   
  CHANGE `CratedDate` `CreatedDate` DATETIME NULL;
  
  ALTER TABLE `fundraising`.`sub_menu`   
  ADD COLUMN `CreatedDate` DATETIME NULL AFTER `Menu_Id`,
  ADD COLUMN `UpdatedDate` DATETIME NULL AFTER `CreatedDate`,
  ADD COLUMN `CreatedUser_Id` BIGINT NULL AFTER `UpdatedDate`,
  ADD COLUMN `UpdatedUser_Id` BIGINT NULL AFTER `CreatedUser_Id`;
  
  ALTER TABLE `fundraising`.`fundraising_project`   
  CHANGE `ShortDescritpion` `ShortDescription` VARCHAR(2000) CHARSET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  CHANGE `Descritpion` `Description` VARCHAR(8000) CHARSET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL;

