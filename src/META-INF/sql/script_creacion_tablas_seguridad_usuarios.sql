--
-- Table structure for table `profile`
--
CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`profile` (
  `id` bigint(3) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;

--
-- Table structure for table `permission_group`
--
CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`permission_group` (
  `id` bigint(3) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;

--
-- Table structure for table `permission`
--
CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`permission` (
  `id` bigint(3) NOT NULL AUTO_INCREMENT,
  `permissionGroupId` bigint(3) NOT NULL,
  `action` varchar(45) NOT NULL,
  `entity` varchar(45) DEFAULT NULL,
  `name` varchar(45) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_constraint_permission_permissionGroup1` (`permissionGroupId`),
  CONSTRAINT `fk_constraint_permission_permissionGroup1` FOREIGN KEY (`permissionGroupId`) REFERENCES `permission_group` (`id`)
) ENGINE=InnoDB;

--
-- Table structure for table `permission_has_profile`
--
CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`permission_has_profile` (
  `id` bigint(3) NOT NULL AUTO_INCREMENT,
  `permissionId` bigint(3) NOT NULL,
  `profileId` bigint(3) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_permission_has_profile_profile1` (`profileId`),
  KEY `fk_permission_has_profile_permission1` (`permissionId`),
  CONSTRAINT `fk_permission_has_profile_permission1` FOREIGN KEY (`permissionId`) REFERENCES `permission` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_permission_has_profile_profile1` FOREIGN KEY (`profileId`) REFERENCES `profile` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB;

--
-- Table structure for table `profile_has_profile`
--
CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`profile_has_profile` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `parentId` bigint(3) NOT NULL,
  `childId` bigint(3) NOT NULL,
  `beginningDate` datetime NOT NULL,
  `endingDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_profile_has_profile_profile2` (`childId`),
  KEY `fk_profile_has_profile_profile1` (`parentId`),
  CONSTRAINT `fk_profile_has_profile_profile1` FOREIGN KEY (`parentId`) REFERENCES `profile` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_profile_has_profile_profile2` FOREIGN KEY (`childId`) REFERENCES `profile` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB;

--
-- Table structure for table `language`
--
CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`language` (
  `id` bigint(3) NOT NULL AUTO_INCREMENT,
  `iso` varchar(3) NOT NULL,
  `description` varchar(45) DEFAULT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;

--
-- Table structure for table `permission_data`
--
CREATE TABLE IF NOT EXISTS `CardManagementSystem`.`permission_data` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `permissionId` bigint(3) NOT NULL,
  `languageId` bigint(3) NOT NULL,
  `alias` varchar(45) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_permission_data_permission1` (`permissionId`),
  KEY `fk_permission_data_language1` (`languageId`),
  CONSTRAINT `fk_permission_data_language1` FOREIGN KEY (`languageId`) REFERENCES `language` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_permission_data_permission1` FOREIGN KEY (`permissionId`) REFERENCES `permission` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB;

--
-- Table structure for table `permission_group_data`
--
CREATE TABLE `permission_group_data` (
  `id` bigint(3) NOT NULL AUTO_INCREMENT,
  `permissionGroupId` bigint(3) NOT NULL,
  `languageId` bigint(3) NOT NULL,
  `alias` varchar(45) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_permission_group_data_permission_group1` (`permissionGroupId`),
  KEY `fk_permission_group_data_language1` (`languageId`),
  CONSTRAINT `fk_permission_group_data_language1` FOREIGN KEY (`languageId`) REFERENCES `language` (`id`),
  CONSTRAINT `fk_permission_group_data_permission_group1` FOREIGN KEY (`permissionGroupId`) REFERENCES `permission_group` (`id`)
) ENGINE=InnoDB;


--
-- Table structure for table `profile_data`
--
CREATE TABLE `profile_data` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `profileId` bigint(3) NOT NULL,
  `languageId` bigint(3) NOT NULL,
  `alias` varchar(45) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_profile_data_profile1` (`profileId`),
  KEY `fk_profile_data_language1` (`languageId`),
  CONSTRAINT `fk_profile_data_language1` FOREIGN KEY (`languageId`) REFERENCES `language` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_profile_data_profile1` FOREIGN KEY (`profileId`) REFERENCES `profile` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB;