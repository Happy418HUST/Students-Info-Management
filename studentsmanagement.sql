/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : studentsmanagement

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2018-11-30 14:31:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` tinyint(4) NOT NULL,
  `userName` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `realName` varchar(255) DEFAULT NULL,
  `age` tinyint(4) DEFAULT NULL,
  `phoneNumber` varchar(255) DEFAULT NULL,
  `headPicture` varchar(255) DEFAULT NULL,
  `addDate` date DEFAULT NULL,
  `updateDate` date DEFAULT NULL,
  `state` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'yuqiao', '1234', '1234', '1', '1234', null, null, null, '1');
INSERT INTO `admin` VALUES ('2', 'xg', 'ghk', 'fgj', '1', '12', null, null, null, '0');

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `major` varchar(255) DEFAULT NULL,
  `joinDate` date DEFAULT NULL,
  `state` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '1234', 'yuqiao', '10', 'software', '2018-11-30', '1');
INSERT INTO `student` VALUES ('2', '1234', '中文名', '10', 'digital', '2018-11-30', '1');
INSERT INTO `student` VALUES ('3', '141', '3', null, null, null, '1');
INSERT INTO `student` VALUES ('4', null, '4', null, null, null, '1');
INSERT INTO `student` VALUES ('5', null, '5', null, null, null, '1');
INSERT INTO `student` VALUES ('6', null, '6', null, null, null, '1');
