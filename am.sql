/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50536
Source Host           : 127.0.0.1:3306
Source Database       : am

Target Server Type    : MYSQL
Target Server Version : 50536
File Encoding         : 65001

Date: 2020-11-30 14:57:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for cardinfo
-- ----------------------------
DROP TABLE IF EXISTS `cardinfo`;
CREATE TABLE `cardinfo` (
  `C_CardId` int(64) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `C_CardNumber` varchar(64) NOT NULL COMMENT '卡号',
  `C_CardPassword` varchar(255) NOT NULL COMMENT '密码',
  `C_CardBalance` decimal(18,2) NOT NULL COMMENT '卡内金额',
  `C_TransactTime` date NOT NULL COMMENT '办卡时间',
  `C_Status` int(2) DEFAULT NULL COMMENT '卡状态：0正常1暂停使用2已注销使用',
  `C_bake1` int(1) DEFAULT NULL COMMENT '预留字段1',
  `C_bake2` varchar(60) DEFAULT NULL COMMENT '预留字段2',
  `C_bake3` varchar(60) DEFAULT NULL COMMENT '预留字段3',
  PRIMARY KEY (`C_CardId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for consumerinfo
-- ----------------------------
DROP TABLE IF EXISTS `consumerinfo`;
CREATE TABLE `consumerinfo` (
  `ConsumerId` int(64) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `C_CardNumber` varchar(64) NOT NULL COMMENT '卡号',
  `C_Phone` varchar(32) NOT NULL COMMENT '手机号',
  `C_name` varchar(60) NOT NULL COMMENT '用户名',
  `C_Creatime` varchar(24) NOT NULL COMMENT '创建时间',
  `C_bake1` varchar(60) DEFAULT NULL COMMENT '预备字段1',
  `C_bake2` varchar(60) DEFAULT NULL COMMENT '预备字段2',
  `C_bake3` varchar(60) DEFAULT NULL COMMENT '预备字段3',
  PRIMARY KEY (`ConsumerId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for discount
-- ----------------------------
DROP TABLE IF EXISTS `discount`;
CREATE TABLE `discount` (
  `id` int(64) DEFAULT NULL COMMENT '主键id',
  `discount` decimal(2,2) DEFAULT NULL COMMENT '折扣',
  `createtime` varchar(24) DEFAULT NULL COMMENT '创建时间',
  `dis_state1` varchar(50) DEFAULT NULL COMMENT '预留字段1',
  `dis_state2` varchar(50) DEFAULT NULL COMMENT '预留字段2',
  `dis_state3` int(1) DEFAULT NULL COMMENT '预留字段3'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` int(64) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `ordernum` varchar(32) NOT NULL COMMENT '订单编号',
  `C_CardNumber` varchar(64) NOT NULL COMMENT '卡号',
  `ConMoney` decimal(18,2) NOT NULL COMMENT '应付金额',
  `discount` decimal(18,2) DEFAULT NULL COMMENT '折扣',
  `actMoneystate` decimal(18,2) NOT NULL COMMENT '实际支付金额',
  `state` int(1) NOT NULL DEFAULT '1' COMMENT '状态：0充值1支出',
  `createtime` varchar(24) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `U_UserId` int(64) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `U_UserName` varchar(64) NOT NULL COMMENT '姓名',
  `U_UserPwd` varchar(64) NOT NULL COMMENT '密码',
  `U_Status` bit(2) DEFAULT NULL COMMENT '状态',
  `U_bake1` varchar(60) DEFAULT NULL,
  `U_bake2` varchar(60) DEFAULT NULL,
  `U_bake3` varchar(60) DEFAULT NULL COMMENT '预留字段3',
  PRIMARY KEY (`U_UserId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
