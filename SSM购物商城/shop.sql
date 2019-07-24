/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50620
Source Host           : 127.0.0.1:3306
Source Database       : shop

Target Server Type    : MYSQL
Target Server Version : 50620
File Encoding         : 65001

Date: 2019-06-28 09:30:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for good
-- ----------------------------
DROP TABLE IF EXISTS `good`;
CREATE TABLE `good` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品id',
  `good_type_id` int(11) DEFAULT NULL COMMENT '商品类型id',
  `good_name` varchar(255) DEFAULT NULL COMMENT '商品名字',
  `good_content` varchar(255) DEFAULT NULL COMMENT '商品内容',
  `good_price` varchar(255) DEFAULT NULL COMMENT '商品价格',
  `good_image` varchar(255) DEFAULT NULL COMMENT '商品图片',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of good
-- ----------------------------
INSERT INTO `good` VALUES ('3', '2', '南极人男士短袖 2019新款潮流 纯棉宽松', '简介', '22', '/upload/7.jpg');
INSERT INTO `good` VALUES ('13', '3', '皮床 简约现代小户型双人床1.8M', '111', '1200', '/upload/10.jpg');
INSERT INTO `good` VALUES ('16', '3', '乐扣乐扣旗舰店保温杯 耐摔运动水杯', 'qqqqqq', '50', '/upload/11.jpg');
INSERT INTO `good` VALUES ('17', '1', '华为P30 Pro曲面屏超感光 徕卡四摄变焦 双景录像980 智能手机p30', '1111', '5488', '/upload/12.jpg');
INSERT INTO `good` VALUES ('18', '2', 'Technica/铁三角ATH-S200BT 头戴式无线蓝牙耳机音乐耳麦', null, '1999', '/upload/13.jpg');
INSERT INTO `good` VALUES ('19', '3', 'Vero Moda春季甜美风印花系带中长款A摆 连衣裙|31837A513', null, '314', '/upload/14.jpg');
INSERT INTO `good` VALUES ('34', '3', 'Vero Moda春季甜美风印花系带中长款A摆 连衣裙|31837A513', 'Vero Moda春季甜美风印花系带中长款A摆 连衣裙|31837A513', '222', '/upload/6.jpg');

-- ----------------------------
-- Table structure for goodtype
-- ----------------------------
DROP TABLE IF EXISTS `goodtype`;
CREATE TABLE `goodtype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `good_type_name` varchar(255) DEFAULT NULL COMMENT '商品类型名字',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goodtype
-- ----------------------------
INSERT INTO `goodtype` VALUES ('1', '游戏');
INSERT INTO `goodtype` VALUES ('2', '食物');
INSERT INTO `goodtype` VALUES ('3', '服装');

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `good_name` varchar(255) DEFAULT NULL,
  `good_price` varchar(255) DEFAULT NULL,
  `good_image` varchar(255) DEFAULT NULL,
  `user_account` varchar(255) DEFAULT NULL COMMENT '用户账号',
  `good_number` int(11) DEFAULT NULL COMMENT '数量',
  `good_total_price` int(11) DEFAULT NULL COMMENT '总价',
  `order_type_id` int(11) DEFAULT NULL COMMENT '订单状态id',
  `evaluated` varchar(255) DEFAULT NULL COMMENT '评价',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES ('1', '男鞋休闲用 月销过万 夏季透气男士休闲板鞋', '323', '/upload/2.jpg', 'yonghu', '1', '323', '2', '1111');
INSERT INTO `order` VALUES ('2', '南极人男士短袖 2019新款潮流 纯棉宽松', '445', '/upload/7.jpg', 'yonghu', '1', '445', '2', null);
INSERT INTO `order` VALUES ('3', 'Bershka女士 2019夏季新款', '720', '/upload/6.jpg', 'yonghu', '1', '720', '5', 'qqq');
INSERT INTO `order` VALUES ('4', '零食超大 月销过万 大礼包组合整箱 混装', '70', '/upload/3.jpg', 'yonghu', '2', '70', '4', 'sadasdasda');
INSERT INTO `order` VALUES ('5', '欧米茄OMEGA手表海马系列机械男表', '998', '/upload/5.jpg', 'yonghu', '1', '998', '1', 'pingjiachenggong');
INSERT INTO `order` VALUES ('6', '皮床 简约现代小户型双人床1.8M', '1200', '/upload/10.jpg', 'yonghu', '1', '1200', '2', null);
INSERT INTO `order` VALUES ('8', 'Kuegou 男士短袖T恤 夏季圆领修身男装衣服 潮流字母半袖', '99', '/upload/8.jpg', 'yonghu', '1', '99', '4', null);
INSERT INTO `order` VALUES ('9', '优衣库男士运动短裤 夏季吸汗速干 跑步5分裤', '88', '/upload/9.jpg', 'yonghu', '1', '88', '5', '');
INSERT INTO `order` VALUES ('10', '乐扣乐扣旗舰店保温杯 耐摔运动水杯', '50', '/upload/11.jpg', 'yonghu', '1', '50', '2', null);
INSERT INTO `order` VALUES ('11', '华为P30 Pro曲面屏超感光 徕卡四摄变焦 双景录像980 智能手机p30', '5488', '/upload/12.jpg', 'yonghu', '1', '5488', '2', null);
INSERT INTO `order` VALUES ('12', 'Technica/铁三角ATH-S200BT 头戴式无线蓝牙耳机音乐耳麦', '1999', '/upload/13.jpg', 'yonghu', '1', '1999', '5', 'sdadsadsa');
INSERT INTO `order` VALUES ('13', 'Vero Moda春季甜美风印花系带中长款A摆 连衣裙|31837A513', '314', '/upload/14.jpg', 'yonghu', '1', '314', '4', '');
INSERT INTO `order` VALUES ('23', '南极人男士短袖 2019新款潮流 纯棉宽松', '445', '/upload/7.jpg', 'yonghu', '1', '445', '2', null);
INSERT INTO `order` VALUES ('24', '男鞋休闲用 月销过万 夏季透气男士休闲板鞋', '323', '/upload/2.jpg', 'yonghu', '1', '323', '2', null);
INSERT INTO `order` VALUES ('25', '南极人男士短袖 2019新款潮流 纯棉宽松', '445', '/upload/7.jpg', 'yonghu', '1', '445', '2', null);
INSERT INTO `order` VALUES ('26', '华为P30 Pro曲面屏超感光 徕卡四摄变焦 双景录像980 智能手机p30', '5488', '/upload/12.jpg', 'yonghu', '1', '5488', '2', null);
INSERT INTO `order` VALUES ('27', '刺客信条', '123', '/upload/timg.jpg', 'yonghu', '1', '123', '2', null);
INSERT INTO `order` VALUES ('28', '男鞋休闲用 月销过万 夏季透气男士休闲板鞋', '323', '/upload/2.jpg', 'yonghu', '1', '323', '2', null);
INSERT INTO `order` VALUES ('29', '皮床 简约现代小户型双人床1.8M', '1200', '/upload/10.jpg', 'yonghu7', '1', '1200', '2', null);
INSERT INTO `order` VALUES ('30', '皮床 简约现代小户型双人床1.8M', '1200', '/upload/10.jpg', 'yonghu7', '1', '1200', '2', null);

-- ----------------------------
-- Table structure for ordertype
-- ----------------------------
DROP TABLE IF EXISTS `ordertype`;
CREATE TABLE `ordertype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_status_name` varchar(255) DEFAULT NULL COMMENT '订单状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ordertype
-- ----------------------------
INSERT INTO `ordertype` VALUES ('1', '待付款');
INSERT INTO `ordertype` VALUES ('2', '待发货');
INSERT INTO `ordertype` VALUES ('3', '待收货');
INSERT INTO `ordertype` VALUES ('4', '待评价');

-- ----------------------------
-- Table structure for shop
-- ----------------------------
DROP TABLE IF EXISTS `shop`;
CREATE TABLE `shop` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `good_name` varchar(255) DEFAULT NULL COMMENT '商品名字',
  `good_price` varchar(255) DEFAULT NULL COMMENT '商品价格',
  `good_content` varchar(255) DEFAULT NULL COMMENT '商品内容',
  `good_image` varchar(255) DEFAULT NULL COMMENT '商品图片',
  `user_account` varchar(255) DEFAULT NULL COMMENT '用户的账号',
  `number` int(11) DEFAULT NULL COMMENT '数量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shop
-- ----------------------------
INSERT INTO `shop` VALUES ('26', '男鞋休闲用 月销过万 夏季透气男士休闲板鞋', '323', '简介', '/upload/2.jpg', 'yonghu', '1');
INSERT INTO `shop` VALUES ('30', '华为P30 Pro曲面屏超感光 徕卡四摄变焦 双景录像980 智能手机p30', '5488', '1111', '/upload/12.jpg', 'yonghu', '1');
INSERT INTO `shop` VALUES ('33', '皮床 简约现代小户型双人床1.8M', '1200', '111', '/upload/10.jpg', 'yonghu7', '1');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `account` varchar(255) NOT NULL COMMENT '账号',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `username` varchar(255) DEFAULT NULL COMMENT '用户名',
  `sex` varchar(255) DEFAULT NULL COMMENT '性别',
  `phone` varchar(12) DEFAULT NULL COMMENT '电话',
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `head_image` varchar(255) DEFAULT NULL COMMENT '头像',
  `user_type_id` int(11) DEFAULT NULL COMMENT '用户类型id',
  PRIMARY KEY (`id`,`account`),
  UNIQUE KEY `zhanghao` (`account`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'yonghu', '123456', 'yonghu123', 'nan', '10085', 'guangzhoudaxuesongtianxueyuan', '/image/touxiang.jpg', '1');
INSERT INTO `user` VALUES ('2', 'shangjia', '123456', '商家88号', 'nan', '66666666', '广州大学松田学院', '/upload/touxiang_two.jpg', '2');
INSERT INTO `user` VALUES ('3', 'yonghutwo', '123456', '用户2号', '男', '10088', '广州大学松田学院', '/image/touxiang.jpg', '1');
INSERT INTO `user` VALUES ('8', 'yonghu3', '123456', '用户3号', '男', '10089', '广州大学松田学院', null, '1');
INSERT INTO `user` VALUES ('9', 'shangjia2', '123456', '商家2号', '女', '10090', '广州大学松田学院', '/upload/14.jpg', '2');
INSERT INTO `user` VALUES ('10', 'shangjia3', '123456', '商家3号', '男', '10086', '广州大学松田学院', '/upload/14.jpg', '1');
INSERT INTO `user` VALUES ('11', 'shangjia4', '123456', '商家4号', '男', '10086', '广州大学松田学院', '/upload/14.jpg', '2');
INSERT INTO `user` VALUES ('12', 'yonghu4', '123456', '用户4号', '女', '10091', '广州大学松田学院', null, '1');
INSERT INTO `user` VALUES ('13', 'yonghu5', 'yonghu5', '123', '男', '10086', 'guangzhou', null, '1');
INSERT INTO `user` VALUES ('14', 'yonghu6', '123456', 'yonghu6', '女', '10085', 'ssadas', null, '1');
INSERT INTO `user` VALUES ('15', 'yonghu7', '123456', 'yonghu7', '男', '10080', 'guangzhoudaxuesongtianxueyuan', null, '1');
INSERT INTO `user` VALUES ('16', 'yonghu8', '123456', 'yonghu7', '男', '10080', 'guangzhoudaxuesongtianxueyuan', null, '1');
INSERT INTO `user` VALUES ('17', 'aaa', '123456', 'xiaoming', '男', '123456', 'guaungdong', null, '1');
INSERT INTO `user` VALUES ('18', 'yonghu9', '123456', 'yonghu9', '男', '10080', 'guangdasongtian', null, '1');

-- ----------------------------
-- Table structure for usertype
-- ----------------------------
DROP TABLE IF EXISTS `usertype`;
CREATE TABLE `usertype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_type_name` varchar(255) DEFAULT NULL COMMENT '用户类型名字',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of usertype
-- ----------------------------
INSERT INTO `usertype` VALUES ('1', '用户');
INSERT INTO `usertype` VALUES ('2', '商家');
