DROP TABLE `item`;
DROP TABLE `basket`;
CREATE TABLE `basket` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR
);

CREATE TABLE `item` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR,
	`quantity` DOUBLE,
	`price` DOUBLE,
	`basket_id` INT,
	FOREIGN KEY (`basket_id`) REFERENCES `basket` (`id`)
);