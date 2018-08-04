/*
Navicat MySQL Data Transfer

Source Server         : 12
Source Server Version : 50558
Source Host           : 10.3.105.8:3306
Source Database       : lxy2018

Target Server Type    : MYSQL
Target Server Version : 50558
File Encoding         : 65001

Date: 2018-08-04 09:41:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for lxy2018_table
-- ----------------------------
DROP TABLE IF EXISTS `lxy2018_table`;
CREATE TABLE `lxy2018_table` (
  `id` int(3) NOT NULL,
  `name` char(255) DEFAULT NULL,
  `university` char(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lxy2018_table
-- ----------------------------
INSERT INTO `lxy2018_table` VALUES ('1', '李宇', '华北水电大学');
INSERT INTO `lxy2018_table` VALUES ('2', '张三', '郑州大学');
INSERT INTO `lxy2018_table` VALUES ('3', '李四', '武汉大学');
INSERT INTO `lxy2018_table` VALUES ('4', '似李', '南京大学');
