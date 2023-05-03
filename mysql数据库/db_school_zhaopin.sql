/*
 Navicat Premium Data Transfer

 Source Server         : mysql5.6
 Source Server Type    : MySQL
 Source Server Version : 50620
 Source Host           : localhost:3306
 Source Schema         : db_school_zhaopin

 Target Server Type    : MySQL
 Target Server Version : 50620
 File Encoding         : 65001

 Date: 21/09/2021 19:03:18
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for chat
-- ----------------------------
DROP TABLE IF EXISTS `chat`;
CREATE TABLE `chat`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sid` int(11) NULL DEFAULT NULL,
  `gid` int(11) NULL DEFAULT NULL,
  `sname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `simg` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gimg` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `time` varchar(111) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sessionid` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 39 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of chat
-- ----------------------------
INSERT INTO `chat` VALUES (35, 2, 6, '小李子', '北京百度科技', 'http://192.168.1.5:8080/16183873434378.jpg', 'http://192.168.1.5:8080/1584408680482870.jpg', '2021-09-21 18:09:20', '你好，我想应聘安卓工程师', 5);
INSERT INTO `chat` VALUES (36, 2, 6, '小李子', '北京百度科技', 'http://192.168.1.5:8080/16183873434378.jpg', 'http://192.168.1.5:8080/1584408680482870.jpg', '2021-09-21 18:09:28', '我已经投递了简历了', 5);
INSERT INTO `chat` VALUES (37, 6, 6, '王迪', '北京百度科技', 'http://192.168.1.5:8080/1618388326923624.jpg', 'http://192.168.1.5:8080/1584408680482870.jpg', '2021-09-21 18:34:03', '我也想来应聘这个', 7);
INSERT INTO `chat` VALUES (38, 6, 2, '北京百度科技', '小李子', 'http://192.168.1.5:8080/1584408680482870.jpg', 'http://192.168.1.5:8080/16183873434378.jpg', '2021-09-21 18:36:02', '我的，我一会就去看看', 5);

-- ----------------------------
-- Table structure for company
-- ----------------------------
DROP TABLE IF EXISTS `company`;
CREATE TABLE `company`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `guimo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `boss` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `neturl` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `account` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `jianjie` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of company
-- ----------------------------
INSERT INTO `company` VALUES (3, '上海嘟嘟科技', '100', '码云', '上海浦东', '20934005', 'http://192.168.1.5:8080/1618316668631802.jpg', 'www.sss.ocm', 'qwer', '123', 'sadas');
INSERT INTO `company` VALUES (5, '哈哈科技', '200', '哈哈', '郑州高新区', '2940022', 'http://192.168.1.5:8080/1587872872137762.jpg', 'www.sina.com.cn', 'dasad', 'as', 'asdas');
INSERT INTO `company` VALUES (6, '北京百度科技', '20000', '李彦宏', '北京百度大厦', '0394-299455', 'http://192.168.1.5:8080/1584408680482870.jpg', 'www.baidu.com', 'baidu', '123456', '专业科技公司');
INSERT INTO `company` VALUES (7, '新浪科技', '10000人', '马云', '中国河南郑州', '0291-293456', 'http://192.168.1.5:8080/sina.jpg', 'www.sina.com', 'xinlang', '123456', 'asda');
INSERT INTO `company` VALUES (8, '淘宝网', '20000人', '马云', '中国杭州', '0299-293456', 'http://192.168.1.5:8080/taobao.jpg', 'www.taobao.com', 'taobao', '123456', 'asdas');
INSERT INTO `company` VALUES (12, '阿尔法科技公司', '300人', '阿尔法', '北京西二旗望京大厦309', '400333999', 'http://192.168.1.5:8080/alpha.jpg', 'www.aerfa.com', '132132', '123456', '好公司');

-- ----------------------------
-- Table structure for jianli
-- ----------------------------
DROP TABLE IF EXISTS `jianli`;
CREATE TABLE `jianli`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` int(11) NULL DEFAULT NULL,
  `xueli` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `school` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `jingyan` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `position` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `jingli` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `moeny` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pingjia` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `uid` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of jianli
-- ----------------------------
INSERT INTO `jianli` VALUES (1, 'http://192.168.1.5:8080/16183873434378.jpg', '小王', '男', 18, '本科', '郑大', '3年', '156797979797', '郑州东站', 'ios工程师', '老婆破rosy在真肉在说切也', '8000', 'http://192.168.1.5:8080/VID_1632221933530.mp4', 2);
INSERT INTO `jianli` VALUES (2, 'http://192.168.1.5:8080/9.jpg', '小王', '男', 18, '本科', '郑大', '2年', '156797979797', '郑州东站', 'java工程师', '老婆破rosy在真肉在说切也', '3456', 'http://192.168.1.5:8080/VID_1632221933530.mp4', 2);
INSERT INTO `jianli` VALUES (3, 'http://192.168.1.6:8080/1587878771709243.jpg', '王小二', '男', 20, '大专', '哈哈大学', '2年', '1587676644', '北京三里屯', '美工', 'HK积极horn哦哦婆婆婆婆哦婆婆婆婆', '5000', 'http://192.168.1.5:8080/VID_1632221933530.mp4', 4);
INSERT INTO `jianli` VALUES (4, 'http://192.168.1.5:8080/16183873434378.jpg', '小李子', '男', 34, '硕士', '大连海事大学', '4年', '1678299394', '大连', 'java', 'i的撒视频加哦就哦啊时间倒排静安寺破卡【SD卡', '18000', 'http://192.168.1.5:8080/VID_1632221933530.mp4', 2);
INSERT INTO `jianli` VALUES (5, 'http://192.168.2.103:8080/1618388352313697.jpg', '王迪', '男', 9, '本科', '东北大学', '3年工作经验', '1674885896', '西二旗303号', 'java工程师', '大飒飒Pi大赛【打开i【啊【破【撒【大【 【【萨达', '15000', 'http://192.168.1.5:8080/VID_1632221933530.mp4', 6);
INSERT INTO `jianli` VALUES (6, 'http://192.168.1.5:8080/1632221954840106.jpg', '11', '男', 22, '大专', '33', '44', '13512343934', '6677', '999', '发发发', '888', 'http://192.168.1.5:8080/VID_1632221933530.mp4', 2);

-- ----------------------------
-- Table structure for luntan
-- ----------------------------
DROP TABLE IF EXISTS `luntan`;
CREATE TABLE `luntan`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NULL DEFAULT NULL,
  `uimg` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `uname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of luntan
-- ----------------------------
INSERT INTO `luntan` VALUES (2, 6, 'http://192.168.1.6:8080/1587872872137762.jpg', 'dasdasdasd', '2020-04-24 15:42', 'sdadas', 'dassa');
INSERT INTO `luntan` VALUES (3, 6, 'http://localhost:8080/1584408680482870.jpg', 'asddas', '2020-04-26 12:43', 'dsadasas', 'dassa');
INSERT INTO `luntan` VALUES (4, 3, 'http://192.168.1.6:8080/1587872806840421.jpg', 'T恤无图', '2020-04-26 12:47', '萝莉控', 'qwer');
INSERT INTO `luntan` VALUES (5, 7, 'http://localhost:8080/1584408680482870.jpg', '会计职位有兴趣拨打电话0371-2934005', '2020-04-26 13:14', '招聘会计', '新浪科技');
INSERT INTO `luntan` VALUES (6, 0, 'http://localhost:8080/logo.jpg', '热烈上线了', '2020-04-26 13:16', '官网推荐', '官网认证');
INSERT INTO `luntan` VALUES (7, 8, 'http://192.168.1.6:8080/wx9f82e62b0aacbc95.o6zAJs18tWL9ppkyvI7_l9LBnH6Y.AHFMsBJd4LwG6d50b1330c3f02bc523a87efb1c66729.png', '招聘各种职位，赶紧电话联系吧0298-0930456', '2020-04-26 13:22', '淘宝网成立了', '淘宝网');
INSERT INTO `luntan` VALUES (8, 0, 'http://192.168.1.6:8080/logo.jpg', '系统用户突破2000了', '2020-04-26 13:23', '招聘网', '官网认证');
INSERT INTO `luntan` VALUES (10, 2, 'http://192.168.2.103:8080/16183873434378.jpg', '阿三大苏打', '2021-04-14 16:06', '阿斯顿撒', '123');
INSERT INTO `luntan` VALUES (12, 6, 'http://192.168.2.103:8080/1618388326923624.jpg', '啊实打实大苏打【审批单【看怕【撒打算', '2021-04-14 16:21', '啊实打实', '158158');

-- ----------------------------
-- Table structure for position
-- ----------------------------
DROP TABLE IF EXISTS `position`;
CREATE TABLE `position`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cid` int(11) NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `money` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `dec` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `jianjie` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of position
-- ----------------------------
INSERT INTO `position` VALUES (1, 6, 'java工程师', '9000', '3年工作经验', '2021-04-12 16:05', 'dsas');
INSERT INTO `position` VALUES (2, 6, 'android工程师', '12000', '4年工作经验', '2021-04-12 17:05', 'asdas');
INSERT INTO `position` VALUES (3, 6, '财务', '7000', '8年工作经验', '2021-04-12 18:05', 'asda');
INSERT INTO `position` VALUES (4, 7, '会计', '3000', '2年工作经验', '2021-04-11 13:14', 'asda');
INSERT INTO `position` VALUES (5, 8, '美工', '4000', '2年工作经验。。。。', '2021-04-26 13:21', '撒打算萨达');
INSERT INTO `position` VALUES (6, 3, 'JA', '9000', '10年经验第三方', '2021-04-13 23:16', '撒打算【看看【喀什频道卡【 ');
INSERT INTO `position` VALUES (8, 12, 'java工程师', '19000', '4年工作经验', '2021-04-14 16:17', '熟悉ssm框架 ，银行支付系统，人工智能算法打撒十大计算机破解爬升阶段怕就送配件偶就扫平的骄傲');

-- ----------------------------
-- Table structure for session
-- ----------------------------
DROP TABLE IF EXISTS `session`;
CREATE TABLE `session`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `did` int(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of session
-- ----------------------------
INSERT INTO `session` VALUES (3, 2, 3);
INSERT INTO `session` VALUES (4, 5, 3);
INSERT INTO `session` VALUES (5, 2, 6);
INSERT INTO `session` VALUES (6, 6, 12);
INSERT INTO `session` VALUES (7, 6, 6);

-- ----------------------------
-- Table structure for store
-- ----------------------------
DROP TABLE IF EXISTS `store`;
CREATE TABLE `store`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NULL DEFAULT NULL,
  `pid` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of store
-- ----------------------------
INSERT INTO `store` VALUES (1, 2, 2);
INSERT INTO `store` VALUES (2, 2, 1);
INSERT INTO `store` VALUES (3, 6, 8);

-- ----------------------------
-- Table structure for toudi
-- ----------------------------
DROP TABLE IF EXISTS `toudi`;
CREATE TABLE `toudi`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `jid` int(11) NULL DEFAULT NULL,
  `uid` int(11) NULL DEFAULT NULL,
  `pid` int(11) NULL DEFAULT NULL,
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of toudi
-- ----------------------------
INSERT INTO `toudi` VALUES (3, 1, 1, 1, '已拒绝');
INSERT INTO `toudi` VALUES (4, 2, 3, 1, '已拒绝');
INSERT INTO `toudi` VALUES (5, 2, 2, 1, '待处理');
INSERT INTO `toudi` VALUES (7, 3, 4, 5, '已邀请');
INSERT INTO `toudi` VALUES (10, 4, 2, 1, '待处理');
INSERT INTO `toudi` VALUES (11, 5, 6, 8, '已邀请');
INSERT INTO `toudi` VALUES (13, 4, 2, 2, '已邀请');
INSERT INTO `toudi` VALUES (14, 5, 6, 2, '已邀请');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (2, '123', '123', '小李子', 'http://192.168.1.5:8080/16183873434378.jpg');
INSERT INTO `user` VALUES (6, '158158', '123456', '王迪', 'http://192.168.1.5:8080/1618388326923624.jpg');

SET FOREIGN_KEY_CHECKS = 1;
