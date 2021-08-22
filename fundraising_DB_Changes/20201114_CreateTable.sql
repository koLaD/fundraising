CREATE TABLE `banbann`.`customer`(  
  `Id` BIGINT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(200),
  `Address` VARCHAR(2000),
  `PhoneNo` VARCHAR(50),
  `CreatedDate` DATETIME,
  `UpdatedDate` DATETIME,
  `CreatedUser_Id` BIGINT,
  `UpdatedUser_Id` BIGINT,
  PRIMARY KEY (`Id`)
);


CREATE TABLE `banbann`.`expense_type`(  
  `Id` BIGINT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(200),
  `Description` VARCHAR(1000),
  `CreatedDate` DATETIME,
  `UpdatedDate` DATETIME,
  `CreatedUser_Id` BIGINT,
  `UpdatedUser_Id` BIGINT,
  PRIMARY KEY (`Id`)
);


CREATE TABLE `banbann`.`expense`(  
  `Id` BIGINT NOT NULL AUTO_INCREMENT,
  `Amount` DECIMAL(15,2) DEFAULT 0.00,
  `Description` VARCHAR(1000),
  `ImagePath` VARCHAR(500),
  `CreatedDate` DATETIME,
  `UpdatedDate` DATETIME,
  `ExpenseType_Id` BIGINT,
  `CreatedUser_Id` BIGINT,
  `UpdatedUser_Id` BIGINT,
  PRIMARY KEY (`Id`),
  CONSTRAINT `idfk_ext` FOREIGN KEY (`ExpenseType_Id`) REFERENCES `banbann`.`expense_type`(`Id`)
);


CREATE TABLE `banbann`.`income_type`(  
  `Id` BIGINT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(200),
  `Description` VARCHAR(1000),
  `CreatedDate` DATETIME,
  `UpdatedDate` DATETIME,
  `CreatedUser_Id` BIGINT,
  `UpdatedUser_Id` BIGINT,
  PRIMARY KEY (`Id`)
);


CREATE TABLE `banbann`.`income`(  
  `Id` BIGINT NOT NULL AUTO_INCREMENT,
  `Amount` DECIMAL(15,2) DEFAULT 0.00,
  `Description` VARCHAR(2000),
  `CreatedDate` DATETIME,
  `UpdatedDate` DATETIME,
  `CreatedUser_Id` BIGINT,
  `UpdatedUser_Id` BIGINT,
  `IncomeType_Id` BIGINT,
  PRIMARY KEY (`Id`),
  CONSTRAINT `idfk_income1` FOREIGN KEY (`IncomeType_Id`) REFERENCES `banbann`.`income_type`(`Id`)
);

CREATE TABLE `banbann`.`item`(  
  `Id` BIGINT,
  `ItemCode` VARCHAR(30),
  `ItemLink` VARCHAR(2000),
  `ItemName` VARCHAR(200),
  `ImagePath` VARCHAR(200),
  `SellPrice` DECIMAL(15,2) DEFAULT 0.00,
  `OriginalPrice` DECIMAL(15,2) DEFAULT 0.00,
  `IsShoe` BOOLEAN,
  `CreatedDate` DATETIME,
  `UpdatedDate` DATETIME,
  `CreatedUser_Id` BIGINT,
  `UpdatedUser_Id` BIGINT
);

ALTER TABLE `banbann`.`item`   
  CHANGE `Id` `Id` BIGINT NOT NULL AUTO_INCREMENT, 
  ADD PRIMARY KEY (`Id`);



CREATE TABLE `banbann`.`item_size`(  
  `Id` BIGINT,
  `Name` VARCHAR(200),
  `ShoeStatus` BOOLEAN,
  `Description` VARCHAR(500),
  `CreatedDate` DATETIME,
  `UpdatedDate` DATETIME,
  `CreatedUser_Id` BIGINT,
  `UpdatedUser_Id` BIGINT
);

ALTER TABLE `banbann`.`item_size`   
  CHANGE `Id` `Id` BIGINT NOT NULL AUTO_INCREMENT, 
  ADD PRIMARY KEY (`Id`);


CREATE TABLE `banbann`.`order`(  
  `Id` BIGINT NOT NULL AUTO_INCREMENT,
  `OrderNo` VARCHAR(50),
  `TotalAmount` DECIMAL(15,2) DEFAULT 0.00,
  `OrderStatus` INT,
  `OrderedDate` DATETIME,
  `CreatedDate` DATETIME,
  `UpdateDate` DATETIME,
  `CreatedUser_Id` BIGINT,
  `UpdatedUser_Id` BIGINT,
  `Customer_Id` BIGINT,
  PRIMARY KEY (`Id`),
  CONSTRAINT `idfk_order1` FOREIGN KEY (`Customer_Id`) REFERENCES `banbann`.`customer`(`Id`)
);


CREATE TABLE `banbann`.`order_item`(  
  `Id` BIGINT NOT NULL AUTO_INCREMENT,
  `Quantity` INT,
  `TotalAmount` DECIMAL(15,2) DEFAULT 0.00,
  `CreatedDate` DATETIME,
  `UpdatedDate` DATETIME,
  `Item_Id` BIGINT,
  `ItemSize_Id` BIGINT,
  `CreatedUser_Id` BIGINT,
  `UpdatedUser_Id` BIGINT,
  `Order_Id` BIGINT,
  PRIMARY KEY (`Id`),
  CONSTRAINT `idfk_oi_1` FOREIGN KEY (`Item_Id`) REFERENCES `banbann`.`item`(`Id`),
  CONSTRAINT `idfk_oi_2` FOREIGN KEY (`ItemSize_Id`) REFERENCES `banbann`.`item_size`(`Id`),
  CONSTRAINT `idfk_oi_3` FOREIGN KEY (`Order_Id`) REFERENCES `banbann`.`order`(`Id`)
);


CREATE TABLE `banbann`.`user`(  
  `Id` BIGINT NOT NULL AUTO_INCREMENT,
  `LoginName` VARCHAR(100),
  `UserName` VARCHAR(200),
  `Password` VARCHAR(50),
  `UserStatus` INT,
  `CreatedDate` DATETIME,
  `UpdatedDate` DATETIME,
  `CreatedUser_Id` BIGINT,
  `UpdatedUser_Id` BIGINT,
  PRIMARY KEY (`Id`)
);

ALTER TABLE `banbann`.`user`   
  ADD COLUMN `PhoneNo` VARCHAR(100) NULL AFTER `Password`;


