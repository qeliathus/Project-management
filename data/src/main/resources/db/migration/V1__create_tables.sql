CREATE TABLE IF NOT EXISTS `project_management_db`.`project` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(60) NOT NULL,
  `description` VARCHAR(150) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `project_management_db`.`employee` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `last_name` VARCHAR(40) NOT NULL,
  `first_name` VARCHAR(20) NOT NULL,
  `surname` VARCHAR(40) NOT NULL,
  `email` VARCHAR(50) NOT NULL UNIQUE,
  `position` VARCHAR(40) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `project_management_db`.`employee_project` (
  `employee_id` BIGINT NOT NULL,
  `project_id` BIGINT NOT NULL,
  PRIMARY KEY (`employee_id`, `project_id`),
  FOREIGN KEY (`employee_id`) REFERENCES `employee`(`id`) ON DELETE CASCADE,
  FOREIGN KEY (`project_id`) REFERENCES `project`(`id`) ON DELETE CASCADE
);