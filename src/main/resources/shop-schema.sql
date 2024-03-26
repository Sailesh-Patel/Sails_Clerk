DROP TABLE `item`;
DROP TABLE `basket`;
DROP TABLE `checkout`;

CREATE TABLE `basket` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(255)
);

CREATE TABLE `item` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(255),
	`quantity` INT,
	`price` DOUBLE,
	`basket_id` INT,
	`image` VARCHAR(255),
	`image_alt` VARCHAR(255),
	`bulk_size` VARCHAR(255),
	FOREIGN KEY (`basket_id`) REFERENCES `basket` (`id`)
);

CREATE TABLE `checkout` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`email` VARCHAR(255),
	`phone` VARCHAR(255)
);