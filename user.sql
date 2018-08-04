/*
Navicat MySQL Data Transfer

Source Server         : 12
Source Server Version : 50558
Source Host           : 10.3.105.8:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50558
File Encoding         : 65001

Date: 2018-08-04 09:41:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(512) NOT NULL,
  `password` varchar(512) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1002 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', 'admin');
INSERT INTO `user` VALUES ('2', 'qwe1', 'qwer');
INSERT INTO `user` VALUES ('3', 'wo', 'xixi');
INSERT INTO `user` VALUES ('4', '李四2', 'lise');
