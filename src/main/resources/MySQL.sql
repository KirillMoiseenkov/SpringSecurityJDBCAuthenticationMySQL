CREATE TABLE `user_roles` (
  `user_role_id` INT(11) NOT NULL AUTO_INCREMENT,
`username` VARCHAR(20)NOT NULL,
`role` VARCHAR(20)NOT NULL,
PRIMARY KEY(`user_role_id`),
UNIQUE KEY `uni_username_role`(`role`, `username`),
KEY `fk_username_idx`(`username`),
CONSTRAINT `fk_username` FOREIGN KEY(`username`)REFERENCES `users`(`username`)
)ENGINE = InnoDB AUTO_INCREMENT = 5 DEFAULT CHARSET = utf8;

CREATE TABLE `users` (
  `username` VARCHAR(20) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
`enabled` TINYINT(4)NOT NULL DEFAULT '1',
PRIMARY KEY(`username`)
)ENGINE = InnoDB DEFAULT CHARSET = utf8;
