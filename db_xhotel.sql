/*
 Navicat Premium Data Transfer

 Source Server         : hyc
 Source Server Type    : MySQL
 Source Server Version : 80015
 Source Host           : localhost:3306
 Source Schema         : db_xhotel

 Target Server Type    : MySQL
 Target Server Version : 80015
 File Encoding         : 65001

 Date: 22/04/2019 01:09:18
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_hotel
-- ----------------------------
DROP TABLE IF EXISTS `t_hotel`;
CREATE TABLE `t_hotel`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `number` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '酒店编号',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '酒店名称',
  `site` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '酒店地点',
  `type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '酒店类型',
  `area` decimal(20, 0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '占地面积',
  `star` decimal(20, 0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '酒店星级',
  `score` decimal(20, 0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '酒店评分',
  `introduction` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '酒店介绍',
  `photo` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '酒店图片',
  `status` smallint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '酒店状态',
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_hotel
-- ----------------------------
INSERT INTO `t_hotel` VALUES ('0', '', 'xhotel', 'gdut', 'best', 1001, 5, 5, 'this is xhotel', 'no photo', 0, '2019-04-11 22:03:31', '2019-04-16 22:23:16');
INSERT INTO `t_hotel` VALUES ('007b530f46ab4e8385465f7cf4c2a595', '010208', '广州精品酒店第8号酒店', '', '', 118, 0, 0, '', '', 0, '2019-04-18 03:15:48', '2019-04-18 03:15:48');
INSERT INTO `t_hotel` VALUES ('03ef568a04e74ab886e5be6633aca141', '0102024', '广州精品酒店第24号酒店', '', '', 134, 0, 0, '', '', 0, '2019-04-18 03:18:36', '2019-04-18 03:18:36');
INSERT INTO `t_hotel` VALUES ('069129962e294ce58d51104d5807a9f5', '0102021', '广州精品酒店第21号酒店', '', '', 131, 0, 0, '', '', 0, '2019-04-18 03:18:36', '2019-04-18 03:18:36');
INSERT INTO `t_hotel` VALUES ('085016ef42c941efa70d1f89d969769a', '0102014', '广州精品酒店第14号酒店', '', '', 124, 0, 0, '', '', 0, '2019-04-18 03:19:55', '2019-04-18 03:19:55');
INSERT INTO `t_hotel` VALUES ('09e8e95416554e64a24a0de8585c0934', '0102010', '广州精品酒店第10号酒店', '', '', 120, 0, 0, '', '', 0, '2019-04-18 03:15:48', '2019-04-18 03:15:48');
INSERT INTO `t_hotel` VALUES ('0ba89fed5e7a4bc4ba59636cc26bc716', '0102014', '广州精品酒店第14号酒店', '', '', 124, 0, 0, '', '', 0, '2019-04-18 03:13:46', '2019-04-18 03:13:46');
INSERT INTO `t_hotel` VALUES ('12e42daeae4a40b5bf6abacb5282d145', '010207', '广州精品酒店第7号酒店', '', '', 117, 0, 0, '', '', 0, '2019-04-18 03:19:55', '2019-04-18 03:19:55');
INSERT INTO `t_hotel` VALUES ('15685346eac444c5940b51a815a781bd', '0102025', '广州精品酒店第25号酒店', '', '', 135, 0, 0, '', '', 0, '2019-04-18 03:13:46', '2019-04-18 03:13:46');
INSERT INTO `t_hotel` VALUES ('195628e1b25c4059979da1637428b04c', '010205', '广州精品酒店第5号酒店', '', '', 115, 0, 0, '', '', 0, '2019-04-18 03:19:55', '2019-04-18 03:19:55');
INSERT INTO `t_hotel` VALUES ('1b70c94ef3594962aa4693dbfe434122', '0102023', '广州精品酒店第23号酒店', '', '', 133, 0, 0, '', '', 0, '2019-04-18 03:19:55', '2019-04-18 03:19:55');
INSERT INTO `t_hotel` VALUES ('1c2ecdbeed8a4568b90351b9b19569e0', '0102018', '广州精品酒店第18号酒店', '', '', 128, 0, 0, '', '', 0, '2019-04-18 03:18:36', '2019-04-18 03:18:36');
INSERT INTO `t_hotel` VALUES ('1d45633718244e00bfe5f2a4f4bee0b9', '0102029', '广州精品酒店第29号酒店', '', '', 139, 0, 0, '', '', 0, '2019-04-18 03:13:46', '2019-04-18 03:13:46');
INSERT INTO `t_hotel` VALUES ('1f7dff2c9a7a4cecad9191d54029ce46', '0102013', '广州精品酒店第13号酒店', '', '', 123, 0, 0, '', '', 0, '2019-04-18 03:19:55', '2019-04-18 03:19:55');
INSERT INTO `t_hotel` VALUES ('212aed0bcff34928b3c542d166f76363', '0102011', '广州精品酒店第11号酒店', '', '', 121, 0, 0, '', '', 0, '2019-04-18 03:15:48', '2019-04-18 03:15:48');
INSERT INTO `t_hotel` VALUES ('2622e23d4fd54bf1a55ed0f654ddd185', '0102013', '广州精品酒店第13号酒店', '', '', 123, 0, 0, '', '', 0, '2019-04-18 03:18:36', '2019-04-18 03:18:36');
INSERT INTO `t_hotel` VALUES ('279bb990f7bb46a1b7e8665f15e4b0eb', '0102022', '广州精品酒店第22号酒店', '', '', 132, 0, 0, '', '', 0, '2019-04-18 03:13:46', '2019-04-18 03:13:46');
INSERT INTO `t_hotel` VALUES ('27badbfed36641deb388a723f13f8af8', '0102026', '广州精品酒店第26号酒店', '', '', 136, 0, 0, '', '', 0, '2019-04-18 03:13:46', '2019-04-18 03:13:46');
INSERT INTO `t_hotel` VALUES ('2bad3545d6694114b391332cda8366d8', '010203', '广州精品酒店第3号酒店', '', '', 113, 0, 0, '', '', 0, '2019-04-18 03:19:55', '2019-04-18 03:19:55');
INSERT INTO `t_hotel` VALUES ('2e925692e767416399e0a62c2749274b', '010201', '广州精品酒店第1号酒店', '', '', 111, 0, 0, '', '', 0, '2019-04-18 03:15:48', '2019-04-18 03:15:48');
INSERT INTO `t_hotel` VALUES ('340282baa3994872b88c970f58cf6001', '010206', '广州精品酒店第6号酒店', '', '', 116, 0, 0, '', '', 0, '2019-04-18 03:18:36', '2019-04-18 03:18:36');
INSERT INTO `t_hotel` VALUES ('38be850635a04912b7a52cca114b762d', '010209', '广州精品酒店第9号酒店', '', '', 119, 0, 0, '', '', 0, '2019-04-18 03:19:55', '2019-04-18 03:19:55');
INSERT INTO `t_hotel` VALUES ('3d006016d0974224a7399681fa7ec9ea', '010202', '广州精品酒店第2号酒店', '', '', 112, 0, 0, '', '', 0, '2019-04-18 03:19:55', '2019-04-18 03:19:55');
INSERT INTO `t_hotel` VALUES ('3f452448293d4f8fb5ce994f239c4123', '010203', '广州精品酒店第3号酒店', '', '', 113, 0, 0, '', '', 0, '2019-04-18 03:13:46', '2019-04-18 03:13:46');
INSERT INTO `t_hotel` VALUES ('40d56bf3a2d94e33a13f175bf6d86735', '0102025', '广州精品酒店第25号酒店', '', '', 135, 0, 0, '', '', 0, '2019-04-18 03:15:48', '2019-04-18 03:15:48');
INSERT INTO `t_hotel` VALUES ('414ee1ecbe704458b931654362f99b70', '0102014', '广州精品酒店第14号酒店', '', '', 124, 0, 0, '', '', 0, '2019-04-18 03:15:48', '2019-04-18 03:15:48');
INSERT INTO `t_hotel` VALUES ('4448573ff7c6476e990c3b4363941175', '0102026', '广州精品酒店第26号酒店', '', '', 136, 0, 0, '', '', 0, '2019-04-18 03:18:36', '2019-04-18 03:18:36');
INSERT INTO `t_hotel` VALUES ('4c779066791446d18535bb212e95382a', '010207', '广州精品酒店第7号酒店', '', '', 117, 0, 0, '', '', 0, '2019-04-18 03:13:46', '2019-04-18 03:13:46');
INSERT INTO `t_hotel` VALUES ('4e0ec025231444f89241f2c658356804', '0102022', '广州精品酒店第22号酒店', '', '', 132, 0, 0, '', '', 0, '2019-04-18 03:19:55', '2019-04-18 03:19:55');
INSERT INTO `t_hotel` VALUES ('4e1c1c85a6fb4c0cb406613d6782f0ec', '0102020', '广州精品酒店第20号酒店', '', '', 130, 0, 0, '', '', 0, '2019-04-18 03:19:55', '2019-04-18 03:19:55');
INSERT INTO `t_hotel` VALUES ('4e9fd404d42b4dc48d4dbe73dc1837d8', '0102016', '广州精品酒店第16号酒店', '', '', 126, 0, 0, '', '', 0, '2019-04-18 03:13:46', '2019-04-18 03:13:46');
INSERT INTO `t_hotel` VALUES ('525fbf75acf44ebdaf980ebb0449cddf', '0102015', '广州精品酒店第15号酒店', '', '', 125, 0, 0, '', '', 0, '2019-04-18 03:13:46', '2019-04-18 03:13:46');
INSERT INTO `t_hotel` VALUES ('52819461d802446789e942ab1c96c8da', '010206', '广州精品酒店第6号酒店', '', '', 116, 0, 0, '', '', 0, '2019-04-18 03:19:55', '2019-04-18 03:19:55');
INSERT INTO `t_hotel` VALUES ('52fa292e5e6f46a7802ce39163da8292', '010202', '广州精品酒店第2号酒店', '', '', 112, 0, 0, '', '', 0, '2019-04-18 03:18:36', '2019-04-18 03:18:36');
INSERT INTO `t_hotel` VALUES ('547151842bb84f8e83c244fc9fb35f82', '010205', '广州精品酒店第5号酒店', '', '', 115, 0, 0, '', '', 0, '2019-04-18 03:15:48', '2019-04-18 03:15:48');
INSERT INTO `t_hotel` VALUES ('574b664cb6de4ab2ad300d103afc0b34', '0102017', '广州精品酒店第17号酒店', '', '', 127, 0, 0, '', '', 0, '2019-04-18 03:19:55', '2019-04-18 03:19:55');
INSERT INTO `t_hotel` VALUES ('58a7c7e9dc344757a81c626f6be3cb68', '010200', '广州精品酒店第0号酒店', '', '', 110, 0, 0, '', '', 0, '2019-04-18 03:15:48', '2019-04-18 03:15:48');
INSERT INTO `t_hotel` VALUES ('5958b4e86ada4cb7ae34fe36488ea847', '0102015', '广州精品酒店第15号酒店', '', '', 125, 0, 0, '', '', 0, '2019-04-18 03:18:36', '2019-04-18 03:18:36');
INSERT INTO `t_hotel` VALUES ('5a65f9aaf6f243e5be182f9c550447af', '0102011', '广州精品酒店第11号酒店', '', '', 121, 0, 0, '', '', 0, '2019-04-18 03:18:36', '2019-04-18 03:18:36');
INSERT INTO `t_hotel` VALUES ('5b08ab03559d4586988ea96ae45edda6', '0102029', '广州精品酒店第29号酒店', '', '', 139, 0, 0, '', '', 0, '2019-04-18 03:18:36', '2019-04-18 03:18:36');
INSERT INTO `t_hotel` VALUES ('5c0eb271549549db9fdef3f90e9a8153', '0102010', '广州精品酒店第10号酒店', '', '', 120, 0, 0, '', '', 0, '2019-04-18 03:18:36', '2019-04-18 03:18:36');
INSERT INTO `t_hotel` VALUES ('5ddb5c0471a440c6830d3797029e9089', '0102021', '广州精品酒店第21号酒店', '', '', 131, 0, 0, '', '', 0, '2019-04-18 03:13:46', '2019-04-18 03:13:46');
INSERT INTO `t_hotel` VALUES ('60f6b95f27b44465b94e279f60db8c40', '0102016', '广州精品酒店第16号酒店', '', '', 126, 0, 0, '', '', 0, '2019-04-18 03:15:48', '2019-04-18 03:15:48');
INSERT INTO `t_hotel` VALUES ('631ec4e27566412a993cd8f84ba01bba', '0102020', '广州精品酒店第20号酒店', '', '', 130, 0, 0, '', '', 0, '2019-04-18 03:18:36', '2019-04-18 03:18:36');
INSERT INTO `t_hotel` VALUES ('661cfddc6da7469f8235d90ac1ea8702', '010207', '广州精品酒店第7号酒店', '', '', 117, 0, 0, '', '', 0, '2019-04-18 03:18:36', '2019-04-18 03:18:36');
INSERT INTO `t_hotel` VALUES ('671002977eaf48c0983182da9a3db108', '0102012', '广州精品酒店第12号酒店', '', '', 122, 0, 0, '', '', 0, '2019-04-18 03:13:46', '2019-04-18 03:13:46');
INSERT INTO `t_hotel` VALUES ('6ab1fbf8cc794ac3b6e91f41cb855314', '0102015', '广州精品酒店第15号酒店', '', '', 125, 0, 0, '', '', 0, '2019-04-18 03:19:55', '2019-04-18 03:19:55');
INSERT INTO `t_hotel` VALUES ('6d7d68937a6a4ee6b32106d8f508f48d', '0102028', '广州精品酒店第28号酒店', '', '', 138, 0, 0, '', '', 0, '2019-04-18 03:13:46', '2019-04-18 03:13:46');
INSERT INTO `t_hotel` VALUES ('6e8247b455a2485986501d9b7c543fe4', '010202', '广州精品酒店第2号酒店', '', '', 112, 0, 0, '', '', 0, '2019-04-18 03:15:48', '2019-04-18 03:15:48');
INSERT INTO `t_hotel` VALUES ('6f16309d5b504d4b941bf4afb3279696', '0102014', '广州精品酒店第14号酒店', '', '', 124, 0, 0, '', '', 0, '2019-04-18 03:18:36', '2019-04-18 03:18:36');
INSERT INTO `t_hotel` VALUES ('7207a97e45c7489f8e6c8550f29200cf', '0102019', '广州精品酒店第19号酒店', '', '', 129, 0, 0, '', '', 0, '2019-04-18 03:18:36', '2019-04-18 03:18:36');
INSERT INTO `t_hotel` VALUES ('739ffaa3457d485bbf0feb30e67f9dc9', '0102012', '广州精品酒店第12号酒店', '', '', 122, 0, 0, '', '', 0, '2019-04-18 03:19:55', '2019-04-18 03:19:55');
INSERT INTO `t_hotel` VALUES ('7e3aed9b2069497fb191ddad614a7caf', '010203', '广州精品酒店第3号酒店', '', '', 113, 0, 0, '', '', 0, '2019-04-18 03:18:36', '2019-04-18 03:18:36');
INSERT INTO `t_hotel` VALUES ('7fa63e4dc6b14324b1cdbb802687ea81', '0102021', '广州精品酒店第21号酒店', '', '', 131, 0, 0, '', '', 0, '2019-04-18 03:15:48', '2019-04-18 03:15:48');
INSERT INTO `t_hotel` VALUES ('8093d48f18c74327acb3b67b78a1bba5', '0102013', '广州精品酒店第13号酒店', '', '', 123, 0, 0, '', '', 0, '2019-04-18 03:15:48', '2019-04-18 03:15:48');
INSERT INTO `t_hotel` VALUES ('815ce0bc765e46fdbf73d556fc626b8f', '0102025', '广州精品酒店第25号酒店', '', '', 135, 0, 0, '', '', 0, '2019-04-18 03:18:36', '2019-04-18 03:18:36');
INSERT INTO `t_hotel` VALUES ('82e46ddde2c34ead9ef17e87d02cfd35', '010209', '广州精品酒店第9号酒店', '', '', 119, 0, 0, '', '', 0, '2019-04-18 03:15:48', '2019-04-18 03:15:48');
INSERT INTO `t_hotel` VALUES ('870808ca941442d8b5b7a4a30fd95100', '0102023', '广州精品酒店第23号酒店', '', '', 133, 0, 0, '', '', 0, '2019-04-18 03:18:36', '2019-04-18 03:18:36');
INSERT INTO `t_hotel` VALUES ('88f7f7c0a97c442ba5bee68a77bfac44', '0102020', '广州精品酒店第20号酒店', '', '', 130, 0, 0, '', '', 0, '2019-04-18 03:13:46', '2019-04-18 03:13:46');
INSERT INTO `t_hotel` VALUES ('89c068d94a064f158947a7f1dc30890c', '0102026', '广州精品酒店第26号酒店', '', '', 136, 0, 0, '', '', 0, '2019-04-18 03:15:48', '2019-04-18 03:15:48');
INSERT INTO `t_hotel` VALUES ('89e9c90753b8483cb793a102762f0db1', '010209', '广州精品酒店第9号酒店', '', '', 119, 0, 0, '', '', 0, '2019-04-18 03:13:46', '2019-04-18 03:13:46');
INSERT INTO `t_hotel` VALUES ('8cb482026eac4ab289e573ce196d3181', '010200', '广州精品酒店第0号酒店', '', '', 110, 0, 0, '', '', 0, '2019-04-18 03:19:55', '2019-04-18 03:19:55');
INSERT INTO `t_hotel` VALUES ('90f047753033448c88b999ef7df979e6', '0102019', '广州精品酒店第19号酒店', '', '', 129, 0, 0, '', '', 0, '2019-04-18 03:13:46', '2019-04-18 03:13:46');
INSERT INTO `t_hotel` VALUES ('9390dc8b677e4d3782857532c0094e65', '0102027', '广州精品酒店第27号酒店', '', '', 137, 0, 0, '', '', 0, '2019-04-18 03:19:55', '2019-04-18 03:19:55');
INSERT INTO `t_hotel` VALUES ('940478b774e541cb8f0ce483844a7d34', '010208', '广州精品酒店第8号酒店', '', '', 118, 0, 0, '', '', 0, '2019-04-18 03:18:36', '2019-04-18 03:18:36');
INSERT INTO `t_hotel` VALUES ('9414fec454034dbc81de6e9e1b5903a0', '010208', '广州精品酒店第8号酒店', '', '', 118, 0, 0, '', '', 0, '2019-04-18 03:13:46', '2019-04-18 03:13:46');
INSERT INTO `t_hotel` VALUES ('94f83adb35b549a2b8a451ceb6f069ab', '010205', '广州精品酒店第5号酒店', '', '', 115, 0, 0, '', '', 0, '2019-04-18 03:13:46', '2019-04-18 03:13:46');
INSERT INTO `t_hotel` VALUES ('960fc018c55d4503814664bdd681320c', '0102016', '广州精品酒店第16号酒店', '', '', 126, 0, 0, '', '', 0, '2019-04-18 03:19:55', '2019-04-18 03:19:55');
INSERT INTO `t_hotel` VALUES ('975bfe4d21b5483bb37650461bb12e8d', '0102027', '广州精品酒店第27号酒店', '', '', 137, 0, 0, '', '', 0, '2019-04-18 03:13:46', '2019-04-18 03:13:46');
INSERT INTO `t_hotel` VALUES ('9e759848f61343cca4eef9a7208fd0c8', '0102024', '广州精品酒店第24号酒店', '', '', 134, 0, 0, '', '', 0, '2019-04-18 03:19:55', '2019-04-18 03:19:55');
INSERT INTO `t_hotel` VALUES ('a22f67db55454449bd3093b3e154590f', '0102013', '广州精品酒店第13号酒店', '', '', 123, 0, 0, '', '', 0, '2019-04-18 03:13:46', '2019-04-18 03:13:46');
INSERT INTO `t_hotel` VALUES ('a2ac0009398a43888737871126ef14fb', '0102023', '广州精品酒店第23号酒店', '', '', 133, 0, 0, '', '', 0, '2019-04-18 03:13:46', '2019-04-18 03:13:46');
INSERT INTO `t_hotel` VALUES ('a457fe3613c24e3695ecfcc0e3c02f72', '0102010', '广州精品酒店第10号酒店', '', '', 120, 0, 0, '', '', 0, '2019-04-18 03:13:46', '2019-04-18 03:13:46');
INSERT INTO `t_hotel` VALUES ('a4fa3c7971fa45158e589c0e66d334a0', '0102016', '广州精品酒店第16号酒店', '', '', 126, 0, 0, '', '', 0, '2019-04-18 03:18:36', '2019-04-18 03:18:36');
INSERT INTO `t_hotel` VALUES ('a542d297c5024c65b10ebb3c128a83f9', '0102011', '广州精品酒店第11号酒店', '', '', 121, 0, 0, '', '', 0, '2019-04-18 03:19:55', '2019-04-18 03:19:55');
INSERT INTO `t_hotel` VALUES ('a5e4ff20febe47abb3a9c5092dbe1f79', '0102017', '广州精品酒店第17号酒店', '', '', 127, 0, 0, '', '', 0, '2019-04-18 03:13:46', '2019-04-18 03:13:46');
INSERT INTO `t_hotel` VALUES ('a6b89bebec7244878e7922c7bcfbbbf2', '010209', '广州精品酒店第9号酒店', '', '', 119, 0, 0, '', '', 0, '2019-04-18 03:18:36', '2019-04-18 03:18:36');
INSERT INTO `t_hotel` VALUES ('a8f1f867448c4c2f98df97332de5bedb', '010203', '广州精品酒店第3号酒店', '', '', 113, 0, 0, '', '', 0, '2019-04-18 03:15:48', '2019-04-18 03:15:48');
INSERT INTO `t_hotel` VALUES ('aa1e4ac882fb4c82bb6a3aba90ab85b3', '0102022', '广州精品酒店第22号酒店', '', '', 132, 0, 0, '', '', 0, '2019-04-18 03:15:48', '2019-04-18 03:15:48');
INSERT INTO `t_hotel` VALUES ('ac10b892465843bda47ed80ea9666f04', '0102027', '广州精品酒店第27号酒店', '', '', 137, 0, 0, '', '', 0, '2019-04-18 03:15:48', '2019-04-18 03:15:48');
INSERT INTO `t_hotel` VALUES ('b263b53e7db840d1a9b7a35d0acb5ea7', '0102023', '广州精品酒店第23号酒店', '', '', 133, 0, 0, '', '', 0, '2019-04-18 03:15:48', '2019-04-18 03:15:48');
INSERT INTO `t_hotel` VALUES ('b5b3bbcb2a3345dd818841510205053d', '0102028', '广州精品酒店第28号酒店', '', '', 138, 0, 0, '', '', 0, '2019-04-18 03:15:48', '2019-04-18 03:15:48');
INSERT INTO `t_hotel` VALUES ('b7172d6c5cf44249957f7ffefc1ab6ef', '0102026', '广州精品酒店第26号酒店', '', '', 136, 0, 0, '', '', 0, '2019-04-18 03:19:55', '2019-04-18 03:19:55');
INSERT INTO `t_hotel` VALUES ('bb09e383a64d4094808ba435e990ee74', '010200', '广州精品酒店第0号酒店', '', '', 110, 0, 0, '', '', 0, '2019-04-18 03:13:46', '2019-04-18 03:13:46');
INSERT INTO `t_hotel` VALUES ('bb0c519de85a45a78d77d4fdf8de7f72', '010201', '广州精品酒店第1号酒店', '', '', 111, 0, 0, '', '', 0, '2019-04-18 03:13:46', '2019-04-18 03:13:46');
INSERT INTO `t_hotel` VALUES ('bf681460cccb4809b3ebfc2ed46d96a1', '0102025', '广州精品酒店第25号酒店', '', '', 135, 0, 0, '', '', 0, '2019-04-18 03:19:55', '2019-04-18 03:19:55');
INSERT INTO `t_hotel` VALUES ('c175674678de49cfa89704940d7ea363', '0102018', '广州精品酒店第18号酒店', '', '', 128, 0, 0, '', '', 0, '2019-04-18 03:13:46', '2019-04-18 03:13:46');
INSERT INTO `t_hotel` VALUES ('c27e34c1306d45c784b3afbd0ce4c289', '0102029', '广州精品酒店第29号酒店', '', '', 139, 0, 0, '', '', 0, '2019-04-18 03:19:55', '2019-04-18 03:19:55');
INSERT INTO `t_hotel` VALUES ('c344f1f68e95449cb4bbf8927989c06f', '010201', '广州精品酒店第1号酒店', '', '', 111, 0, 0, '', '', 0, '2019-04-18 03:19:55', '2019-04-18 03:19:55');
INSERT INTO `t_hotel` VALUES ('c3999a712f8c487a88e0856430d8b65f', '0102012', '广州精品酒店第12号酒店', '', '', 122, 0, 0, '', '', 0, '2019-04-18 03:18:36', '2019-04-18 03:18:36');
INSERT INTO `t_hotel` VALUES ('c489cd0d83b24acaa48320866950e959', '010207', '广州精品酒店第7号酒店', '', '', 117, 0, 0, '', '', 0, '2019-04-18 03:15:48', '2019-04-18 03:15:48');
INSERT INTO `t_hotel` VALUES ('c79c31e54bcf4cbeb63581afb0d9a6cc', '0102019', '广州精品酒店第19号酒店', '', '', 129, 0, 0, '', '', 0, '2019-04-18 03:15:48', '2019-04-18 03:15:48');
INSERT INTO `t_hotel` VALUES ('c7ab7f35c3024fff85ac7fb702e7d8be', '010204', '广州精品酒店第4号酒店', '', '', 114, 0, 0, '', '', 0, '2019-04-18 03:18:36', '2019-04-18 03:18:36');
INSERT INTO `t_hotel` VALUES ('c8a0ba93d57c4c4d929425684778c23e', '0102024', '广州精品酒店第24号酒店', '', '', 134, 0, 0, '', '', 0, '2019-04-18 03:15:48', '2019-04-18 03:15:48');
INSERT INTO `t_hotel` VALUES ('cdb527a3aafa4b9ea4ea22791f79b11e', '0102018', '广州精品酒店第18号酒店', '', '', 128, 0, 0, '', '', 0, '2019-04-18 03:15:48', '2019-04-18 03:15:48');
INSERT INTO `t_hotel` VALUES ('d0bc6dbe766c4e89a005ca19b3cd3265', '010205', '广州精品酒店第5号酒店', '', '', 115, 0, 0, '', '', 0, '2019-04-18 03:18:36', '2019-04-18 03:18:36');
INSERT INTO `t_hotel` VALUES ('d3546fe17cd64b97ab0a8ffba1c9a439', '010200', '广州精品酒店第0号酒店', '', '', 110, 0, 0, '', '', 0, '2019-04-18 03:18:36', '2019-04-18 03:18:36');
INSERT INTO `t_hotel` VALUES ('d35e85bf2c6e48ff853ec85739e91b9c', '010204', '广州精品酒店第4号酒店', '', '', 114, 0, 0, '', '', 0, '2019-04-18 03:15:48', '2019-04-18 03:15:48');
INSERT INTO `t_hotel` VALUES ('d3b3c2db8e4842ed97b12df051010f52', '010201', '广州精品酒店第1号酒店', '', '', 111, 0, 0, '', '', 0, '2019-04-18 03:18:36', '2019-04-18 03:18:36');
INSERT INTO `t_hotel` VALUES ('d3dfab07b1b54b8fb7bb1a5094f70e81', '0102028', '广州精品酒店第28号酒店', '', '', 138, 0, 0, '', '', 0, '2019-04-18 03:18:36', '2019-04-18 03:18:36');
INSERT INTO `t_hotel` VALUES ('d65c4b29538a40bcb1be1cc8775ac280', '0102028', '广州精品酒店第28号酒店', '', '', 138, 0, 0, '', '', 0, '2019-04-18 03:19:55', '2019-04-18 03:19:55');
INSERT INTO `t_hotel` VALUES ('d731b549db0541dbbd9be40abe3a9a88', '0102029', '广州精品酒店第29号酒店', '', '', 139, 0, 0, '', '', 0, '2019-04-18 03:15:48', '2019-04-18 03:15:48');
INSERT INTO `t_hotel` VALUES ('dc8cbe4b171d41738e4be9461e213a7e', '010202', '广州精品酒店第2号酒店', '', '', 112, 0, 0, '', '', 0, '2019-04-18 03:13:46', '2019-04-18 03:13:46');
INSERT INTO `t_hotel` VALUES ('dc9b28c7c04240a0b6e848ec18300a94', '0102022', '广州精品酒店第22号酒店', '', '', 132, 0, 0, '', '', 0, '2019-04-18 03:18:36', '2019-04-18 03:18:36');
INSERT INTO `t_hotel` VALUES ('dd3a87afb8c345eab66abe478b1aefa1', '0102019', '广州精品酒店第19号酒店', '', '', 129, 0, 0, '', '', 0, '2019-04-18 03:19:55', '2019-04-18 03:19:55');
INSERT INTO `t_hotel` VALUES ('df1bf916b3c045cab5d1372030ce48c5', '0102015', '广州精品酒店第15号酒店', '', '', 125, 0, 0, '', '', 0, '2019-04-18 03:15:48', '2019-04-18 03:15:48');
INSERT INTO `t_hotel` VALUES ('e0854de92a9f4232b4e6e9bd06161956', '0102027', '广州精品酒店第27号酒店', '', '', 137, 0, 0, '', '', 0, '2019-04-18 03:18:36', '2019-04-18 03:18:36');
INSERT INTO `t_hotel` VALUES ('e09fe4e8858b4a8ab31f1cb86146d010', '010204', '广州精品酒店第4号酒店', '', '', 114, 0, 0, '', '', 0, '2019-04-18 03:13:46', '2019-04-18 03:13:46');
INSERT INTO `t_hotel` VALUES ('e1f5a98c1d1b4426a6aaabaeed67ce40', '010206', '广州精品酒店第6号酒店', '', '', 116, 0, 0, '', '', 0, '2019-04-18 03:13:46', '2019-04-18 03:13:46');
INSERT INTO `t_hotel` VALUES ('e316b76c2fa443d1a5f6aea32adc12a8', '0102018', '广州精品酒店第18号酒店', '', '', 128, 0, 0, '', '', 0, '2019-04-18 03:19:55', '2019-04-18 03:19:55');
INSERT INTO `t_hotel` VALUES ('e3ed7864ca5a4776879d00bd2231dd50', '0102024', '广州精品酒店第24号酒店', '', '', 134, 0, 0, '', '', 0, '2019-04-18 03:13:46', '2019-04-18 03:13:46');
INSERT INTO `t_hotel` VALUES ('e5b45f8d405a4bd0ab17c08e38bcb853', '0102020', '广州精品酒店第20号酒店', '', '', 130, 0, 0, '', '', 0, '2019-04-18 03:15:48', '2019-04-18 03:15:48');
INSERT INTO `t_hotel` VALUES ('e8834a5364e8493a914e8a5dacb39cbf', '0102017', '广州精品酒店第17号酒店', '', '', 127, 0, 0, '', '', 0, '2019-04-18 03:15:48', '2019-04-18 03:15:48');
INSERT INTO `t_hotel` VALUES ('ebc99f7d440f415b87a42f8635485bf7', '0102011', '广州精品酒店第11号酒店', '', '', 121, 0, 0, '', '', 0, '2019-04-18 03:13:46', '2019-04-18 03:13:46');
INSERT INTO `t_hotel` VALUES ('ebdc7a1d067044c78be0b8cfc68975e2', '0102021', '广州精品酒店第21号酒店', '', '', 131, 0, 0, '', '', 0, '2019-04-18 03:19:55', '2019-04-18 03:19:55');
INSERT INTO `t_hotel` VALUES ('ec2489895a4245d0abde526d4e92f559', '0102012', '广州精品酒店第12号酒店', '', '', 122, 0, 0, '', '', 0, '2019-04-18 03:15:48', '2019-04-18 03:15:48');
INSERT INTO `t_hotel` VALUES ('f0b187f3ac9f4dc9b44f008df4d5dc54', '0102017', '广州精品酒店第17号酒店', '', '', 127, 0, 0, '', '', 0, '2019-04-18 03:18:36', '2019-04-18 03:18:36');
INSERT INTO `t_hotel` VALUES ('f251929e713b4fa59056e3b70f3e2662', '0102010', '广州精品酒店第10号酒店', '', '', 120, 0, 0, '', '', 0, '2019-04-18 03:19:55', '2019-04-18 03:19:55');
INSERT INTO `t_hotel` VALUES ('f2b5737706774d1e986b5ba851306132', '010208', '广州精品酒店第8号酒店', '', '', 118, 0, 0, '', '', 0, '2019-04-18 03:19:55', '2019-04-18 03:19:55');
INSERT INTO `t_hotel` VALUES ('f6d0c52afac74aec96d28e1fa277f1b6', '010206', '广州精品酒店第6号酒店', '', '', 116, 0, 0, '', '', 0, '2019-04-18 03:15:48', '2019-04-18 03:15:48');
INSERT INTO `t_hotel` VALUES ('f79577892ed44aaea232419bcafe5921', '010204', '广州精品酒店第4号酒店', '', '', 114, 0, 0, '', '', 0, '2019-04-18 03:19:55', '2019-04-18 03:19:55');

-- ----------------------------
-- Table structure for t_order_room
-- ----------------------------
DROP TABLE IF EXISTS `t_order_room`;
CREATE TABLE `t_order_room`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '自增主键',
  `number` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '订单编号',
  `user_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0' COMMENT '用户id',
  `room_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0' COMMENT '房间id',
  `start_time` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '入住时间',
  `end_time` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '离开时间',
  `amount` decimal(20, 0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '交易金额',
  `remark` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '备注',
  `status` smallint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '订单状态',
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_order_room
-- ----------------------------
INSERT INTO `t_order_room` VALUES ('02362214982242e8adf167c41296d8cf', '9092776', '', '38ed6a1a562d4343954eb99756474f9c', '2019-04-21', '2019-04-27', 0, '反对撒', 0, '2019-04-21 21:46:29', '2019-04-21 21:46:29');
INSERT INTO `t_order_room` VALUES ('071322ea2f114bb1984541caddb4a66f', '9092776', '', '38ed6a1a562d4343954eb99756474f9c', '2019-04-04', '2019-04-21', 0, '', 0, '2019-04-21 22:02:24', '2019-04-21 22:02:24');
INSERT INTO `t_order_room` VALUES ('0c43ec8947a346b08bf2cdbfc9a90d65', '1020', 'dac00243234949e185370902c636f578', 'c020afd4659947d183c8129049e49f51', '2019-04-16', '2019-04-16', 100, '', 0, '2019-04-16 22:37:57', '2019-04-21 20:47:53');
INSERT INTO `t_order_room` VALUES ('0d27c365b8454531b7e8fb8c49dafc66', '90907668', '', '4403e023cf5a4379a1dadf58fe5da58a', '2019-04-13', '2019-04-21', 0, '反对撒', 0, '2019-04-21 21:53:07', '2019-04-21 21:53:07');
INSERT INTO `t_order_room` VALUES ('0d9ca8d329084933aeaec3d4552eaad6', '1020', '0', '0', '2019-04-16', '2019-04-16', 100, '', 0, '2019-04-16 22:31:39', '2019-04-16 22:31:39');
INSERT INTO `t_order_room` VALUES ('1329d102b5434f98a73336b02acce1c3', '1020', '0', '0', '2019-04-16', '2019-04-16', 100, '', 0, '2019-04-16 22:44:39', '2019-04-16 22:44:39');
INSERT INTO `t_order_room` VALUES ('1de2f5ff345846e6b85c13929dfff56b', '9092776', '', '38ed6a1a562d4343954eb99756474f9c', '2019-04-12', '2019-04-14', 0, '吧v', 0, '2019-04-21 21:56:55', '2019-04-21 21:56:55');
INSERT INTO `t_order_room` VALUES ('252612613c2042aa89148ebdb56e61ab', '9092776', '', '38ed6a1a562d4343954eb99756474f9c', '2019-04-21', '2019-04-26', 0, '反对撒', 0, '2019-04-21 21:43:59', '2019-04-21 21:43:59');
INSERT INTO `t_order_room` VALUES ('268d25375eda48b4a17870d588a3f683', '9092776', '', '38ed6a1a562d4343954eb99756474f9c', '2019-04-21', '2019-04-20', 0, '反对撒', 0, '2019-04-21 21:59:27', '2019-04-21 21:59:27');
INSERT INTO `t_order_room` VALUES ('2c0d6d298963478abadf5fdf835e59e5', '1020', '0', '0', '2019-04-16', '2019-04-16', 100, '', 0, '2019-04-16 22:30:51', '2019-04-16 22:30:51');
INSERT INTO `t_order_room` VALUES ('33bff4f173ee4981b25790df0314c8e6', '9096776', '', '38ed6a1a562d4343954eb99756474f9c', '2019-04-20', '2019-04-20', 0, '', 0, '2019-04-22 01:03:13', '2019-04-22 01:03:13');
INSERT INTO `t_order_room` VALUES ('52aae8fbc05a493492ab97eeddc12a82', '9092776', '', '38ed6a1a562d4343954eb99756474f9c', '2019-04-21', '2019-04-27', 0, '反对撒', 0, '2019-04-21 21:45:53', '2019-04-21 21:45:53');
INSERT INTO `t_order_room` VALUES ('78de6b5b3c0a46cd801e4eecd237b589', '9092776', '', '38ed6a1a562d4343954eb99756474f9c', '2019-04-27', '2019-04-28', 0, '反对撒', 0, '2019-04-21 22:00:40', '2019-04-21 22:00:40');
INSERT INTO `t_order_room` VALUES ('793f219dd27c4d50a5d8a35d722a703e', '9092776', '', '38ed6a1a562d4343954eb99756474f9c', '2019-04-12', '2019-04-14', 0, '吧v', 0, '2019-04-21 21:54:53', '2019-04-21 21:54:53');
INSERT INTO `t_order_room` VALUES ('7acb521630a246d5af363a3b23526d1e', '9092776', '', '38ed6a1a562d4343954eb99756474f9c', '2019-04-05', '2019-04-14', 0, '反对撒', 0, '2019-04-21 21:58:13', '2019-04-21 21:58:13');
INSERT INTO `t_order_room` VALUES ('7c9cee6b37374c33a0a051fb17961b34', '1020', '0', '0', '2019-04-16', '2019-04-16', 100, '', 0, '2019-04-16 22:42:27', '2019-04-16 22:42:27');
INSERT INTO `t_order_room` VALUES ('830bc8b34e1a43de9b8a155e4a1c21ac', '9092776', '', '38ed6a1a562d4343954eb99756474f9c', '2019-04-21', '2019-04-20', 0, '反对撒', 0, '2019-04-21 22:00:26', '2019-04-21 22:00:26');
INSERT INTO `t_order_room` VALUES ('8ee4ef0109df489194e4ce31d92e270f', '1020', '0', '0', '2019-04-16', '2019-04-16', 100, '', 0, '2019-04-16 22:28:02', '2019-04-16 22:28:02');
INSERT INTO `t_order_room` VALUES ('8fb6ddef5828455b84bbbd73ccd00e91', '9092776', '', '38ed6a1a562d4343954eb99756474f9c', '2019-04-21', '2019-04-26', 0, '反对撒', 0, '2019-04-21 21:43:56', '2019-04-21 21:43:56');
INSERT INTO `t_order_room` VALUES ('9a6e9ef68507418cb3365f2370a7785e', '9092776', '', '38ed6a1a562d4343954eb99756474f9c', '2019-04-13', '2019-04-21', 0, '吧v', 0, '2019-04-21 21:53:42', '2019-04-21 21:53:42');
INSERT INTO `t_order_room` VALUES ('9d8cee0d45444bfc89f2294bd1eb8fd9', '9092776', '', '38ed6a1a562d4343954eb99756474f9c', '2019-05-02', '2019-04-11', 0, '反对撒', 0, '2019-04-21 21:57:28', '2019-04-21 21:57:28');
INSERT INTO `t_order_room` VALUES ('a45c7f1f95bb4d988f4e79424e454e13', '1020', '0', '0', '2019-04-16', '2019-04-16', 100, '', 0, '2019-04-16 22:27:47', '2019-04-16 22:27:47');
INSERT INTO `t_order_room` VALUES ('a738ab42dfcc44759c7eaaff73950ed2', '1020', '0', '0', '2019-04-16', '2019-04-16', 100, '', 0, '2019-04-16 22:27:21', '2019-04-16 22:27:21');
INSERT INTO `t_order_room` VALUES ('a9f55e9afc024a3d9c806681ddb98d01', '1020', '0', '0', '2019-04-16', '2019-04-16', 100, '', 0, '2019-04-16 22:27:36', '2019-04-16 22:27:36');
INSERT INTO `t_order_room` VALUES ('b17c47884de84fd9b0ccb9cf8cce5f8d', '1020', '0', '0', '2019-04-16', '2019-04-16', 100, '', 0, '2019-04-16 22:31:02', '2019-04-16 22:31:02');
INSERT INTO `t_order_room` VALUES ('bb0b5763a73d4fd3acf018bee8bf60b3', '9092776', '', '38ed6a1a562d4343954eb99756474f9c', '2019-04-21', '2019-04-20', 0, '反对撒', 0, '2019-04-21 21:59:53', '2019-04-21 21:59:53');
INSERT INTO `t_order_room` VALUES ('be34ef9ec58b41d5b5ffa0fa4578c1b5', '1020', '0', '0', '2019-04-16', '2019-04-16', 100, '', 0, '2019-04-16 22:30:44', '2019-04-16 22:30:44');
INSERT INTO `t_order_room` VALUES ('c069cdb3a1b04386aac7f1c72536979f', '9092776', '', '38ed6a1a562d4343954eb99756474f9c', '2019-04-12', '2019-04-10', 0, '反对撒', 0, '2019-04-21 21:54:19', '2019-04-21 21:54:19');
INSERT INTO `t_order_room` VALUES ('c49dc44a007d4eb59236bf74bb47e89c', '9092776', '', '38ed6a1a562d4343954eb99756474f9c', '2019-04-27', '2019-04-21', 0, '', 0, '2019-04-21 23:13:00', '2019-04-21 23:13:00');
INSERT INTO `t_order_room` VALUES ('c528fa3bb15f456e89e5f47c19b60a3a', '9092776', '', '38ed6a1a562d4343954eb99756474f9c', '2019-04-21', '2019-04-27', 0, '反对撒', 0, '2019-04-21 21:44:19', '2019-04-21 21:44:19');
INSERT INTO `t_order_room` VALUES ('da1ecaf17d234715a07fc6b5c5699abc', '1020', '0', '0', '2019-04-16', '2019-04-16', 100, '', 0, '2019-04-16 22:29:39', '2019-04-16 22:29:39');
INSERT INTO `t_order_room` VALUES ('dda5af5dd8be42678b90660943d7ae67', '1020', '0', '0', '2019-04-16', '2019-04-16', 100, '', 0, '2019-04-16 22:26:36', '2019-04-16 22:26:36');
INSERT INTO `t_order_room` VALUES ('ed53f460da9f495e8e8577410cba27a2', '1020', '0', '0', '2019-04-16', '2019-04-16', 100, '', 0, '2019-04-16 22:08:59', '2019-04-16 22:08:59');
INSERT INTO `t_order_room` VALUES ('f5f9c83df44843a4a60bd8cb4824b6f6', '9092776', '', '38ed6a1a562d4343954eb99756474f9c', '2019-04-21', '2019-04-28', 0, '反对撒', 0, '2019-04-21 21:47:49', '2019-04-21 21:47:49');
INSERT INTO `t_order_room` VALUES ('fb302efc1c8d421aba7ee9ccafdd0f42', '9092776', '', '38ed6a1a562d4343954eb99756474f9c', '2019-04-21', '2019-04-26', 0, '反对撒', 0, '2019-04-21 21:42:13', '2019-04-21 21:42:13');

-- ----------------------------
-- Table structure for t_order_serv
-- ----------------------------
DROP TABLE IF EXISTS `t_order_serv`;
CREATE TABLE `t_order_serv`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `number` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '订单编号',
  `serv_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0' COMMENT '服务id',
  `user_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0' COMMENT '服务用户id',
  `room_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0' COMMENT '服务房间id',
  `start_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '服务开始时间',
  `end_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '服务结束时间',
  `status` smallint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '订单状态',
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `remark` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk`(`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_pictrue
-- ----------------------------
DROP TABLE IF EXISTS `t_pictrue`;
CREATE TABLE `t_pictrue`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `status` smallint(1) UNSIGNED NOT NULL COMMENT '状态',
  `pictrue` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `author_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_pictrue
-- ----------------------------
INSERT INTO `t_pictrue` VALUES ('1', 1, '', '', '2019-04-19 18:28:18', '2019-04-19 18:28:18');

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `status` smallint(1) UNSIGNED NOT NULL COMMENT '状态',
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_room
-- ----------------------------
DROP TABLE IF EXISTS `t_room`;
CREATE TABLE `t_room`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '房间名称',
  `number` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0' COMMENT '房间编号',
  `photo` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '房间照片',
  `type` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0' COMMENT '房间类型',
  `area` decimal(32, 0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '房间面积',
  `bed_width` decimal(32, 0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '床宽',
  `price` decimal(10, 0) UNSIGNED NOT NULL DEFAULT 0 COMMENT '房间价格',
  `book_status` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '00000000000000000000000000000' COMMENT '被订状态',
  `level` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0' COMMENT '房间等级',
  `score` decimal(20, 0) UNSIGNED NOT NULL DEFAULT 4 COMMENT '房间评分',
  `remark_num` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '评分数量',
  `hotel_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0' COMMENT '酒店id',
  `creator_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0' COMMENT '创建者id',
  `editor_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0' COMMENT '修改者id',
  `status` smallint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '房间状态(0可用）',
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '插入时间',
  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_editor_id`(`editor_id`) USING BTREE,
  INDEX `fk_creator_id`(`creator_id`) USING BTREE,
  INDEX `fk_hotel_id`(`hotel_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_room
-- ----------------------------
INSERT INTO `t_room` VALUES ('38ed6a1a562d4343954eb99756474f9c', '迪拜帆船酒店(Dubai Lugger Hotel)商务房间', '09090543', '9fe40472c541479591cbef965c2fd611.jpg', '双人', 70, 3, 4999, '空闲', '5', 0, 0, '0', '0', '0', 0, '2019-04-20 15:00:14', '2019-04-21 23:19:49');
INSERT INTO `t_room` VALUES ('4403e023cf5a4379a1dadf58fe5da58a', '广州珠江新城假日酒店休闲房间', '090905435', '4803463ce1034dc0a60673f8cf2e739d.jpg', '双人', 70, 3, 999, '空闲', '5', 0, 0, '0', '0', '0', 0, '2019-04-20 15:33:20', '2019-04-21 23:19:36');
INSERT INTO `t_room` VALUES ('56b6469756f04a65bffce24207101fe8', '好好', '0102023', '6052289076d140a4a3f0786620a89bc7.jpg', '0', 70, 3, 2899, '空闲', 'test', 0, 0, '0', '0', '0', 0, '2019-04-18 02:22:55', '2019-04-21 22:53:17');
INSERT INTO `t_room` VALUES ('717e7f6704994f1082c5ed7dd231404b', '广州精品酒店第17号房间', '0102017', 'b7fb2f8ad4df4440a762381ad8c56f0d.jpg', '0', 127, 3, 2299, '空闲', '0', 0, 0, '0', '0', '0', 0, '2019-04-18 02:22:55', '2019-04-21 22:53:17');
INSERT INTO `t_room` VALUES ('731be83025904467b22e18adb8eb3cb4', '广州精品酒店第16号房间', '0102016', '3154086e2a0d4dcaa01e37d4049bc855.jpg', '0', 126, 3, 2199, '空闲', '0', 0, 0, '0', '0', '0', 0, '2019-04-18 02:22:55', '2019-04-21 22:53:17');
INSERT INTO `t_room` VALUES ('7585b76aa993477fb884b01ca14cee85', '广州精品酒店第20号房间', '0102020', '', '0', 130, 3, 2599, '空闲', '0', 0, 0, '0', '0', '0', 0, '2019-04-18 02:24:09', '2019-04-21 22:53:17');
INSERT INTO `t_room` VALUES ('7ab6f494067a42fdb3ce2830677d52f9', '广州精品酒店第5号房间', '010205', '', '0', 115, 3, 1099, '空闲', '0', 0, 0, '0', '0', '0', 0, '2019-04-18 02:22:55', '2019-04-21 22:53:17');
INSERT INTO `t_room` VALUES ('80df8b13c82546388076ae029be23b1c', '广州精品酒店第0号房间', '010200', '', '0', 110, 3, 599, '空闲', '0', 0, 0, '0', '0', '0', 0, '2019-04-18 02:24:09', '2019-04-21 22:53:17');
INSERT INTO `t_room` VALUES ('835b4c2b02e548efb2e33414b5a49723', '广州精品酒店第5号房间', '010205', '', '0', 115, 3, 1099, '空闲', '0', 0, 0, '0', '0', '0', 0, '2019-04-18 02:24:09', '2019-04-21 22:53:17');
INSERT INTO `t_room` VALUES ('84c1eec4085e48f89fbf8b274f4a8219', '中文', '0102027', '', '0', 137, 3, 3299, '空闲', '0', 0, 0, '0', '0', '0', 0, '2019-04-18 02:24:09', '2019-04-21 22:53:17');
INSERT INTO `t_room` VALUES ('857aff5806c64308b6c174cd16ebcb18', '广州精品酒店第25号房间', '0102025', '', '0', 135, 3, 3099, '空闲', '0', 0, 0, '0', '0', '0', 0, '2019-04-18 02:24:09', '2019-04-21 22:53:17');
INSERT INTO `t_room` VALUES ('8771acf45cac409fb72dff1908259fbb', '中文', '0909054', '', '双人', 70, 3, 999, '空闲', '5', 0, 0, '0', '0', '0', 0, '2019-04-20 14:42:17', '2019-04-21 22:53:17');
INSERT INTO `t_room` VALUES ('8e99794961e5415dbc50feb6ab5dd1cf', '广州精品酒店第1号房间', '010201', '', '0', 111, 3, 699, '空闲', '0', 0, 0, '0', '0', '0', 0, '2019-04-18 02:22:55', '2019-04-21 22:53:17');
INSERT INTO `t_room` VALUES ('9608f01eceee444aadfdd015a5213a0d', 'å¹¿å·ç²¾åéåºç¬¬7å·æ¿é´', '010207', '', '0', 117, 3, 1299, '空闲', '0', 0, 0, '0', '0', '0', 0, '2019-04-18 02:22:55', '2019-04-21 22:53:17');
INSERT INTO `t_room` VALUES ('96ba455ca1af435889214d13dfc1d84a', '广州精品酒店第13号房间', '0102013', '', '0', 123, 3, 1899, '空闲', '0', 0, 0, '0', '0', '0', 0, '2019-04-18 02:24:09', '2019-04-21 22:53:17');
INSERT INTO `t_room` VALUES ('9dfbe68b28a244e28ad104b0e3365aab', '广州精品酒店第7号房间', '010207', '', '0', 117, 3, 1299, '空闲', '0', 0, 0, '0', '0', '0', 0, '2019-04-18 02:24:09', '2019-04-21 22:53:17');
INSERT INTO `t_room` VALUES ('9f005186874449f19889a881879c0273', '广州精品酒店第27号房间', '0102027', '', '0', 137, 3, 3299, '空闲', '0', 0, 0, '0', '0', '0', 0, '2019-04-18 02:22:55', '2019-04-21 22:53:17');
INSERT INTO `t_room` VALUES ('a20b81b3d177430b95ceef4112ac2ca5', '广州精品酒店第29号房间', '0102029', '', '0', 139, 3, 3499, '空闲', '0', 0, 0, '0', '0', '0', 0, '2019-04-18 02:22:55', '2019-04-21 22:53:17');
INSERT INTO `t_room` VALUES ('a52c5e7c61ed445bb3a69c3f15788052', '广州精品酒店第3号房间', '010203', '', '0', 113, 3, 899, '空闲', '0', 0, 0, '0', '0', '0', 0, '2019-04-18 02:22:55', '2019-04-21 22:53:17');
INSERT INTO `t_room` VALUES ('a736ca2969084b80add38964b0c5d1a2', '广州精品酒店第25号房间', '0102025', '', '0', 135, 3, 3099, '空闲', '0', 0, 0, '0', '0', '0', 0, '2019-04-18 02:22:55', '2019-04-21 22:53:17');
INSERT INTO `t_room` VALUES ('a810cd51a3534061b72cd66542fdf223', '广州精品酒店第6号房间', '010206', '', '0', 116, 3, 1199, '空闲', '0', 0, 0, '0', '0', '0', 0, '2019-04-18 02:24:09', '2019-04-21 22:53:17');
INSERT INTO `t_room` VALUES ('ac485f3f58e44535900e921cb9022d68', '广州精品酒店第13号房间', '0102013', '', '0', 123, 3, 1899, '空闲', '0', 0, 0, '0', '0', '0', 0, '2019-04-18 02:22:55', '2019-04-21 22:53:17');
INSERT INTO `t_room` VALUES ('adacfc071bd84c0e914e3aecc7c3dfa9', '中文 ', '090905433', '', '双人', 70, 3, 999, '空闲', '5', 0, 0, '0', '0', '0', 0, '2019-04-20 14:59:56', '2019-04-21 22:53:17');
INSERT INTO `t_room` VALUES ('b3783730b06546ed8c57554fd939eb7d', '广州精品酒店第12号房间', '0102012', '', '0', 122, 3, 1799, '空闲', '0', 0, 0, '0', '0', '0', 0, '2019-04-18 02:24:09', '2019-04-21 22:53:17');
INSERT INTO `t_room` VALUES ('b68bf756838f47658c0d914d7e13b972', '广州精品酒店第18号房间', '0102018', '', '0', 128, 3, 2399, '空闲', '0', 0, 0, '0', '0', '0', 0, '2019-04-18 02:24:09', '2019-04-21 22:53:17');
INSERT INTO `t_room` VALUES ('b77cdc3b64c04c21916ba89a3d0ab2ca', '广州精品酒店第8号房间', '010208', '', '0', 118, 3, 1399, '空闲', '0', 0, 0, '0', '0', '0', 0, '2019-04-18 02:24:09', '2019-04-21 22:53:17');
INSERT INTO `t_room` VALUES ('b7e2addd6ddb430894e828876c972f14', '广州精品酒店第16号房间', '0102016', '', '0', 126, 3, 2199, '空闲', '0', 0, 0, '0', '0', '0', 0, '2019-04-18 02:24:09', '2019-04-21 22:53:17');
INSERT INTO `t_room` VALUES ('bfc88e2284a74bc6873772559699c6c9', '添加的第一个房间', '09090543123', 'd75daa598de449159220f3a64d0dc447.jpg', '双人', 70, 3, 999, '空闲', '5', 0, 0, '0', '0', '0', 0, '2019-04-20 15:22:14', '2019-04-21 22:53:17');
INSERT INTO `t_room` VALUES ('c020afd4659947d183c8129049e49f51', 'test中文', '09090543214', '1e9e4239b13c4b62bfe2998eacccd162.jpg', '双人', 70, 3, 999, '空闲', '5', 0, 0, '0', '0', '0', 0, '2019-04-21 03:01:01', '2019-04-21 22:53:17');
INSERT INTO `t_room` VALUES ('c0575b9f36fa42ba91be20fba56d1d2c', '广州精品酒店第3号房间', '010203', '', '0', 113, 3, 899, '空闲', '0', 0, 0, '0', '0', '0', 0, '2019-04-18 02:24:09', '2019-04-21 22:53:17');
INSERT INTO `t_room` VALUES ('c4db3989a32543579930a212aa941799', '精品房间', '09090', '', '双人', 70, 3, 999, '空闲', '5', 0, 0, '0', '0', '0', 0, '2019-04-18 10:31:02', '2019-04-21 22:53:17');
INSERT INTO `t_room` VALUES ('cbe433a06a484933ad67033c8e575130', '广州精品酒店第28号房间', '0102028', '', '0', 138, 3, 3399, '空闲', '0', 0, 0, '0', '0', '0', 0, '2019-04-18 02:24:09', '2019-04-21 22:53:17');
INSERT INTO `t_room` VALUES ('cf1b0d1891fd4ed9a1cb548f542e127f', '广州精品酒店第19号房间', '0102019', '', '0', 129, 3, 2499, '空闲', '0', 0, 0, '0', '0', '0', 0, '2019-04-18 02:24:09', '2019-04-21 22:53:17');
INSERT INTO `t_room` VALUES ('d8f8fe668a634e718d819d30d6cf17f3', '广州精品酒店第2号房间', '010202', '', '0', 112, 3, 799, '空闲', '0', 0, 0, '0', '0', '0', 0, '2019-04-18 02:22:55', '2019-04-21 22:53:17');
INSERT INTO `t_room` VALUES ('dcbd8f0a72934585a4df88dc87e207b5', '广州精品酒店第1号房间', '010201', '', '0', 111, 3, 699, '空闲', '0', 0, 0, '0', '0', '0', 0, '2019-04-18 02:24:09', '2019-04-21 22:53:17');
INSERT INTO `t_room` VALUES ('de3f2462eda04cfcb6eb9b391c7ffc34', '广州精品酒店第10号房间', '0102010', '', '0', 120, 3, 1599, '空闲', '0', 0, 0, '0', '0', '0', 0, '2019-04-18 02:24:09', '2019-04-21 22:53:17');
INSERT INTO `t_room` VALUES ('df8d46dbe8554a62ab239fb32d92ccf3', '广州精品酒店第6号房间', '010206', '', '0', 116, 3, 1199, '空闲', '0', 0, 0, '0', '0', '0', 0, '2019-04-18 02:22:55', '2019-04-21 22:53:17');
INSERT INTO `t_room` VALUES ('e0b256ef6b974f63b95ae71e56e327fc', '广州精品酒店第17号房间', '0102017', '', '0', 127, 3, 2299, '空闲', '0', 0, 0, '0', '0', '0', 0, '2019-04-18 02:24:09', '2019-04-21 22:53:17');
INSERT INTO `t_room` VALUES ('e1ab678ddf7f427197843d22dcab811a', '广州精品酒店第14号房间', '0102014', '', '0', 124, 3, 1999, '空闲', '0', 0, 0, '0', '0', '0', 0, '2019-04-18 02:24:09', '2019-04-21 22:53:17');
INSERT INTO `t_room` VALUES ('e34aacc7cffd432cafa5c42a832a7e31', '广州精品酒店第15号房间', '0102015', '', '0', 125, 3, 2099, '空闲', '0', 0, 0, '0', '0', '0', 0, '2019-04-18 02:24:09', '2019-04-21 22:53:17');
INSERT INTO `t_room` VALUES ('eb189e4b3efe495fa72dfade7633a504', '广州精品酒店第8号房间', '010208', '', '0', 118, 3, 1399, '空闲', '0', 0, 0, '0', '0', '0', 0, '2019-04-18 02:22:55', '2019-04-21 22:53:17');
INSERT INTO `t_room` VALUES ('f87021354c8f457fb6afbd025b71deb9', '广州精品酒店第14号房间', '0102014', '', '0', 124, 3, 1999, '空闲', '0', 0, 0, '0', '0', '0', 0, '2019-04-18 02:22:55', '2019-04-21 22:53:17');

-- ----------------------------
-- Table structure for t_serv
-- ----------------------------
DROP TABLE IF EXISTS `t_serv`;
CREATE TABLE `t_serv`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `number` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '服务编号',
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '服务名称',
  `detail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '服务内容',
  `time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '服务时长',
  `status` smallint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '服务状态',
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '用户名',
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '1234' COMMENT '登陆密码',
  `type` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'USER' COMMENT '用户类型',
  `phone_number` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '手机号码',
  `id_number` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '身份证号',
  `nick_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '用户昵称',
  `photo` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '用户头像',
  `balance` decimal(32, 0) NOT NULL DEFAULT 0 COMMENT '账户余额',
  `pay_pwd` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '4QrcOUm6Wau+VuBX8g+IPg==' COMMENT '支付密码',
  `status` smallint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '账户状态',
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '插入时间',
  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('04c2501024ac4c9187f9aec9b7f65639', 'test17', 'gdyb21LQTcIANtvYMT7QVQ==', 'user', '15816019724', '440823199912202118', 'tom', '默认头像.jpg', 999170, '4QrcOUm6Wau+VuBX8g+IPg==', 0, '2019-04-20 20:20:38', '2019-04-20 20:20:38');
INSERT INTO `t_user` VALUES ('0ab4a07a8e754cf4b6ed4ba68cb31982', 'test2', '1234', 'user', '', '', '', 'test', 0, '4QrcOUm6Wau+VuBX8g+IPg==', 0, '2019-04-20 20:33:50', '2019-04-20 20:33:50');
INSERT INTO `t_user` VALUES ('0f5f1f0f69bf4ebf905832edf7d83831', 'test25', 'gdyb21LQTcIANtvYMT7QVQ==', 'user', '15816019724', '440823199912202118', 'tom', '默认头像.jpg', 999250, '4QrcOUm6Wau+VuBX8g+IPg==', 0, '2019-04-20 20:21:30', '2019-04-20 20:21:30');
INSERT INTO `t_user` VALUES ('10f2da64d1164912b2c378fcd12cdd85', 'test13', 'gdyb21LQTcIANtvYMT7QVQ==', 'user', '15816019724', '440823199912202118', 'tom', '默认头像.jpg', 999130, '4QrcOUm6Wau+VuBX8g+IPg==', 0, '2019-04-20 20:20:38', '2019-04-20 20:20:38');
INSERT INTO `t_user` VALUES ('15ba1147233b47d282524b03201e1b41', 'test2', '1234', 'user', '', '', '', 'test', 0, '4QrcOUm6Wau+VuBX8g+IPg==', 0, '2019-04-20 20:21:30', '2019-04-20 20:21:30');
INSERT INTO `t_user` VALUES ('186a3a21340a4525adbabce20d0ff307', 'test29', 'gdyb21LQTcIANtvYMT7QVQ==', 'user', '15816019724', '440823199912202118', 'tom', '默认头像.jpg', 999290, '4QrcOUm6Wau+VuBX8g+IPg==', 0, '2019-04-20 20:21:30', '2019-04-20 20:21:30');
INSERT INTO `t_user` VALUES ('21bac58f55f341e9b0e0badaf26394a2', '', 'test1111', 'USER', '15816019723', '440823199912202117', 'tssg134', '', 0, '4QrcOUm6Wau+VuBX8g+IPg==', 0, '2019-04-21 17:29:06', '2019-04-21 17:29:06');
INSERT INTO `t_user` VALUES ('2417679251d64ce995ea02ec2d2e738c', 'test27', 'gdyb21LQTcIANtvYMT7QVQ==', 'user', '15816019724', '440823199912202118', 'tom', '默认头像.jpg', 999270, '4QrcOUm6Wau+VuBX8g+IPg==', 0, '2019-04-20 20:20:38', '2019-04-20 20:20:38');
INSERT INTO `t_user` VALUES ('2b16b05326c1467894f070748635ebad', 'test11', 'gdyb21LQTcIANtvYMT7QVQ==', 'user', '15816019724', '440823199912202118', 'tom', '默认头像.jpg', 999110, '4QrcOUm6Wau+VuBX8g+IPg==', 0, '2019-04-20 20:20:37', '2019-04-20 20:20:37');
INSERT INTO `t_user` VALUES ('31d05dba2d764d74b32fe09a7c67912a', 'test24', 'gdyb21LQTcIANtvYMT7QVQ==', 'user', '15816019724', '440823199912202118', 'tom', '默认头像.jpg', 999240, '4QrcOUm6Wau+VuBX8g+IPg==', 0, '2019-04-20 20:20:38', '2019-04-20 20:20:38');
INSERT INTO `t_user` VALUES ('346d8802d4bc4c82bfc63a639573c83d', 'test0', 'gdyb21LQTcIANtvYMT7QVQ==', 'user', '15816019724', '440823199912202118', 'tom', '默认头像.jpg', 9990, '4QrcOUm6Wau+VuBX8g+IPg==', 0, '2019-04-20 20:21:30', '2019-04-20 20:21:30');
INSERT INTO `t_user` VALUES ('376e1bffba494804b57993f505cd1c22', 'test11', 'gdyb21LQTcIANtvYMT7QVQ==', 'user', '15816019724', '440823199912202118', 'tom', '默认头像.jpg', 999110, '4QrcOUm6Wau+VuBX8g+IPg==', 0, '2019-04-20 20:21:30', '2019-04-20 20:21:30');
INSERT INTO `t_user` VALUES ('38e654cd1227401fa5d52dac5411f313', 'test19', 'gdyb21LQTcIANtvYMT7QVQ==', 'user', '15816019724', '440823199912202118', 'tom', '默认头像.jpg', 999190, '4QrcOUm6Wau+VuBX8g+IPg==', 0, '2019-04-20 20:21:30', '2019-04-20 20:21:30');
INSERT INTO `t_user` VALUES ('3d51cae9985e418cb1935db832f5efee', 'test3', 'gdyb21LQTcIANtvYMT7QVQ==', 'user', '15816019724', '440823199912202118', 'tom', '默认头像.jpg', 99930, '4QrcOUm6Wau+VuBX8g+IPg==', 0, '2019-04-20 20:20:37', '2019-04-20 20:20:37');
INSERT INTO `t_user` VALUES ('3dac54027ceb4e6bb32d5509dfd8fa76', 'test28', 'gdyb21LQTcIANtvYMT7QVQ==', 'user', '15816019724', '440823199912202118', 'tom', '默认头像.jpg', 999280, '4QrcOUm6Wau+VuBX8g+IPg==', 0, '2019-04-20 20:20:38', '2019-04-20 20:20:38');
INSERT INTO `t_user` VALUES ('41798d7d039e4c37872b32de42f6194a', 'test14', 'gdyb21LQTcIANtvYMT7QVQ==', 'user', '15816019724', '440823199912202118', 'tom', '默认头像.jpg', 999140, '4QrcOUm6Wau+VuBX8g+IPg==', 0, '2019-04-20 20:21:30', '2019-04-20 20:21:30');
INSERT INTO `t_user` VALUES ('41df6d2f51724557989985afa2da40b7', 'test5', 'gdyb21LQTcIANtvYMT7QVQ==', 'user', '15816019724', '440823199912202118', 'tom', '默认头像.jpg', 99950, '4QrcOUm6Wau+VuBX8g+IPg==', 0, '2019-04-20 20:20:37', '2019-04-20 20:20:37');
INSERT INTO `t_user` VALUES ('4795e336285043f89a0d80338edd6dad', 'test6', 'gdyb21LQTcIANtvYMT7QVQ==', 'user', '15816019724', '440823199912202118', 'tom', '默认头像.jpg', 99960, '4QrcOUm6Wau+VuBX8g+IPg==', 0, '2019-04-20 20:21:30', '2019-04-20 20:21:30');
INSERT INTO `t_user` VALUES ('4c520fa91a8e4a99b15153f5e5c2a09c', 'test18', 'gdyb21LQTcIANtvYMT7QVQ==', 'user', '15816019724', '440823199912202118', 'tom', '默认头像.jpg', 999180, '4QrcOUm6Wau+VuBX8g+IPg==', 0, '2019-04-20 20:20:38', '2019-04-20 20:20:38');
INSERT INTO `t_user` VALUES ('4eb4f6a6410f4bb79326b83336b6f2b1', 'test1', 'gdyb21LQTcIANtvYMT7QVQ==', 'user', '15816019724', '440823199912202118', 'tom', '默认头像.jpg', 99910, '4QrcOUm6Wau+VuBX8g+IPg==', 0, '2019-04-20 20:20:37', '2019-04-20 20:20:37');
INSERT INTO `t_user` VALUES ('4f3a92eadd8e493bbaa1db2fd589be70', 'test16', 'gdyb21LQTcIANtvYMT7QVQ==', 'user', '15816019724', '440823199912202118', 'tom', '默认头像.jpg', 999160, '4QrcOUm6Wau+VuBX8g+IPg==', 0, '2019-04-20 20:20:38', '2019-04-20 20:20:38');
INSERT INTO `t_user` VALUES ('59b1655bb4464a39a2315aef90bf6877', 'test4', 'gdyb21LQTcIANtvYMT7QVQ==', 'user', '15816019724', '440823199912202118', 'tom', '默认头像.jpg', 99940, '4QrcOUm6Wau+VuBX8g+IPg==', 0, '2019-04-20 20:21:30', '2019-04-20 20:21:30');
INSERT INTO `t_user` VALUES ('59e145bd82f24de69a480fe39e17beb6', 'test29', 'gdyb21LQTcIANtvYMT7QVQ==', 'user', '15816019724', '440823199912202118', 'tom', '默认头像.jpg', 999290, '4QrcOUm6Wau+VuBX8g+IPg==', 0, '2019-04-20 20:20:38', '2019-04-20 20:20:38');
INSERT INTO `t_user` VALUES ('5be07df07fe34ff197995fe353154ff0', 'test1', 'gdyb21LQTcIANtvYMT7QVQ==', 'user', '15816019724', '440823199912202118', 'tom', '默认头像.jpg', 99910, '4QrcOUm6Wau+VuBX8g+IPg==', 0, '2019-04-20 20:21:30', '2019-04-20 20:21:30');
INSERT INTO `t_user` VALUES ('5bf689171bb547d19fbb1901e113e996', 'test7', 'gdyb21LQTcIANtvYMT7QVQ==', 'user', '15816019724', '440823199912202118', 'tom', '默认头像.jpg', 99970, '4QrcOUm6Wau+VuBX8g+IPg==', 0, '2019-04-20 20:21:30', '2019-04-20 20:21:30');
INSERT INTO `t_user` VALUES ('6d124f48c2a1420eaa55bbd139947b2a', 'test24', 'gdyb21LQTcIANtvYMT7QVQ==', 'user', '15816019724', '440823199912202118', 'tom', '默认头像.jpg', 999240, '4QrcOUm6Wau+VuBX8g+IPg==', 0, '2019-04-20 20:21:30', '2019-04-20 20:21:30');
INSERT INTO `t_user` VALUES ('727cee3b93b442d4b71e3d9e84e5ad25', 'test9', 'gdyb21LQTcIANtvYMT7QVQ==', 'user', '15816019724', '440823199912202118', 'tom', '默认头像.jpg', 99990, '4QrcOUm6Wau+VuBX8g+IPg==', 0, '2019-04-20 20:20:37', '2019-04-20 20:20:37');
INSERT INTO `t_user` VALUES ('7bed29c52d0a4412a2b8b8f3b1f22c19', 'test1111', 'test1111', 'USER', '15816019723', '440823199912202117', 'qqqasdf', '', 0, '4QrcOUm6Wau+VuBX8g+IPg==', 0, '2019-04-21 17:39:01', '2019-04-21 17:39:01');
INSERT INTO `t_user` VALUES ('7cab00de5e204ed5a79285c058d5c25c', 'test0', 'gdyb21LQTcIANtvYMT7QVQ==', 'user', '15816019724', '440823199912202118', 'tom', '默认头像.jpg', 9990, '4QrcOUm6Wau+VuBX8g+IPg==', 0, '2019-04-20 20:20:37', '2019-04-20 20:20:37');
INSERT INTO `t_user` VALUES ('847417e919d74d21a183b537962e0a9c', 'test19', 'gdyb21LQTcIANtvYMT7QVQ==', 'user', '15816019724', '440823199912202118', 'tom', '默认头像.jpg', 999190, '4QrcOUm6Wau+VuBX8g+IPg==', 0, '2019-04-20 20:20:38', '2019-04-20 20:20:38');
INSERT INTO `t_user` VALUES ('85a42b05bc9f4eaab8972f87df64a9c7', 'test14', 'gdyb21LQTcIANtvYMT7QVQ==', 'user', '15816019724', '440823199912202118', 'tom', '默认头像.jpg', 999140, '4QrcOUm6Wau+VuBX8g+IPg==', 0, '2019-04-20 20:20:38', '2019-04-20 20:20:38');
INSERT INTO `t_user` VALUES ('8a020caf8e3740dfa6ca6fb4a3432311', 'test6666', 'Tr86wFLHVKvnro7wV+kkvw==', 'USER', '13536372301', '440823199912202117', '12345678901234567890', '', 0, 'Ftek/KdELdo62TyacmWX5A==', 0, '2019-04-20 20:43:42', '2019-04-21 02:29:32');
INSERT INTO `t_user` VALUES ('8c7086c4f4694da8b0407b717188f0d4', 'test26', 'gdyb21LQTcIANtvYMT7QVQ==', 'user', '15816019724', '440823199912202118', 'tom', '默认头像.jpg', 999260, '4QrcOUm6Wau+VuBX8g+IPg==', 0, '2019-04-20 20:21:30', '2019-04-20 20:21:30');
INSERT INTO `t_user` VALUES ('8cab411a15d24fc3a58853eae402a0a0', 'test28', 'gdyb21LQTcIANtvYMT7QVQ==', 'user', '15816019724', '440823199912202118', 'tom', '默认头像.jpg', 999280, '4QrcOUm6Wau+VuBX8g+IPg==', 0, '2019-04-20 20:21:30', '2019-04-20 20:21:30');
INSERT INTO `t_user` VALUES ('906938fcf8b2404093b636e348de9d5e', 'test20', 'gdyb21LQTcIANtvYMT7QVQ==', 'user', '15816019724', '440823199912202118', 'tom', '默认头像.jpg', 999200, '4QrcOUm6Wau+VuBX8g+IPg==', 0, '2019-04-20 20:21:30', '2019-04-20 20:21:30');
INSERT INTO `t_user` VALUES ('91fdb6ad45a140ea8b70c63e862063af', 'test20', 'gdyb21LQTcIANtvYMT7QVQ==', 'user', '15816019724', '440823199912202118', 'tom', '默认头像.jpg', 999200, '4QrcOUm6Wau+VuBX8g+IPg==', 0, '2019-04-20 20:20:38', '2019-04-20 20:20:38');
INSERT INTO `t_user` VALUES ('948ea8f36bf142699a95702f32d36172', 'test7', 'gdyb21LQTcIANtvYMT7QVQ==', 'user', '15816019724', '440823199912202118', 'tom', '默认头像.jpg', 99970, '4QrcOUm6Wau+VuBX8g+IPg==', 0, '2019-04-20 20:20:37', '2019-04-20 20:20:37');
INSERT INTO `t_user` VALUES ('982d24deab6e4b54a0c89926c148aa56', 'test22', 'gdyb21LQTcIANtvYMT7QVQ==', 'user', '15816019724', '440823199912202118', 'tom', '默认头像.jpg', 999220, '4QrcOUm6Wau+VuBX8g+IPg==', 0, '2019-04-20 20:20:38', '2019-04-20 20:20:38');
INSERT INTO `t_user` VALUES ('99b867f28c014d2ca8f14ccac528b360', 'test2', '1234', 'user', '', '', '', 'test', 0, '4QrcOUm6Wau+VuBX8g+IPg==', 0, '2019-04-20 20:20:37', '2019-04-20 20:20:37');
INSERT INTO `t_user` VALUES ('9e78bcdf51d14d8cb623a437622f1dcb', 'test23', 'gdyb21LQTcIANtvYMT7QVQ==', 'user', '15816019724', '440823199912202118', 'tom', '默认头像.jpg', 999230, '4QrcOUm6Wau+VuBX8g+IPg==', 0, '2019-04-20 20:20:38', '2019-04-20 20:20:38');
INSERT INTO `t_user` VALUES ('a187278c81944233a86c7e2e725376c5', 'test26', 'gdyb21LQTcIANtvYMT7QVQ==', 'user', '15816019724', '440823199912202118', 'tom', '默认头像.jpg', 999260, '4QrcOUm6Wau+VuBX8g+IPg==', 0, '2019-04-20 20:20:38', '2019-04-20 20:20:38');
INSERT INTO `t_user` VALUES ('a92090e6c6e74ded80f765985b01d081', 'test10', 'gdyb21LQTcIANtvYMT7QVQ==', 'user', '15816019724', '440823199912202118', 'tom', '默认头像.jpg', 999100, '4QrcOUm6Wau+VuBX8g+IPg==', 0, '2019-04-20 20:20:37', '2019-04-20 20:20:37');
INSERT INTO `t_user` VALUES ('aa2e491f62e14597a6d44a80272c0d7a', 'test12', 'gdyb21LQTcIANtvYMT7QVQ==', 'user', '15816019724', '440823199912202118', 'tom', '默认头像.jpg', 999120, '4QrcOUm6Wau+VuBX8g+IPg==', 0, '2019-04-20 20:20:38', '2019-04-20 20:20:38');
INSERT INTO `t_user` VALUES ('ac1646f3765c48a88c036b3d068389c3', 'test8', 'gdyb21LQTcIANtvYMT7QVQ==', 'user', '15816019724', '440823199912202118', 'tom', '默认头像.jpg', 99980, '4QrcOUm6Wau+VuBX8g+IPg==', 0, '2019-04-20 20:20:37', '2019-04-20 20:20:37');
INSERT INTO `t_user` VALUES ('acf1ac1b1826489d92e613b81660374a', 'test27', 'gdyb21LQTcIANtvYMT7QVQ==', 'user', '15816019724', '440823199912202118', 'tom', '默认头像.jpg', 999270, '4QrcOUm6Wau+VuBX8g+IPg==', 0, '2019-04-20 20:21:30', '2019-04-20 20:21:30');
INSERT INTO `t_user` VALUES ('ad4adc60498e4bc0873220771db596f4', 'test3', 'gdyb21LQTcIANtvYMT7QVQ==', 'user', '15816019724', '440823199912202118', 'tom', '默认头像.jpg', 99930, '4QrcOUm6Wau+VuBX8g+IPg==', 0, '2019-04-20 20:21:30', '2019-04-20 20:21:30');
INSERT INTO `t_user` VALUES ('ae48795a3da942c2bd629ec8e33e12e4', 'test10', 'gdyb21LQTcIANtvYMT7QVQ==', 'user', '15816019724', '440823199912202118', 'tom', '默认头像.jpg', 999100, '4QrcOUm6Wau+VuBX8g+IPg==', 0, '2019-04-20 20:21:30', '2019-04-20 20:21:30');
INSERT INTO `t_user` VALUES ('b024d15bd93e4e99bac49bbf256c1f93', 'test13', 'gdyb21LQTcIANtvYMT7QVQ==', 'user', '15816019724', '440823199912202118', 'tom', '默认头像.jpg', 999130, '4QrcOUm6Wau+VuBX8g+IPg==', 0, '2019-04-20 20:21:30', '2019-04-20 20:21:30');
INSERT INTO `t_user` VALUES ('b0dc07bbd287444399ee100d35dc34f9', 'test9', 'gdyb21LQTcIANtvYMT7QVQ==', 'user', '15816019724', '440823199912202118', 'tom', '默认头像.jpg', 99990, '4QrcOUm6Wau+VuBX8g+IPg==', 0, '2019-04-20 20:21:30', '2019-04-20 20:21:30');
INSERT INTO `t_user` VALUES ('b4688bc8567f4b829419204cceeeba29', 'test17', 'gdyb21LQTcIANtvYMT7QVQ==', 'user', '15816019724', '440823199912202118', 'tom', '默认头像.jpg', 999170, '4QrcOUm6Wau+VuBX8g+IPg==', 0, '2019-04-20 20:21:30', '2019-04-20 20:21:30');
INSERT INTO `t_user` VALUES ('b720395217484fbf97d6fff071933811', 'test18', 'gdyb21LQTcIANtvYMT7QVQ==', 'user', '15816019724', '440823199912202118', 'tom', '默认头像.jpg', 999180, '4QrcOUm6Wau+VuBX8g+IPg==', 0, '2019-04-20 20:21:30', '2019-04-20 20:21:30');
INSERT INTO `t_user` VALUES ('b80c72cf9d7b43bbb0ded5cd20317353', 'test4', 'gdyb21LQTcIANtvYMT7QVQ==', 'user', '15816019724', '440823199912202118', 'tom', '默认头像.jpg', 99940, '4QrcOUm6Wau+VuBX8g+IPg==', 0, '2019-04-20 20:20:37', '2019-04-20 20:20:37');
INSERT INTO `t_user` VALUES ('c346ea3088ae4cf3934e59a531245af7', 'test2', 'gdyb21LQTcIANtvYMT7QVQ==', 'user', '15816019724', '440823199912202118', 'tom', '默认头像.jpg', 99920, '4QrcOUm6Wau+VuBX8g+IPg==', 0, '2019-04-20 20:21:30', '2019-04-20 20:21:30');
INSERT INTO `t_user` VALUES ('c6cd987782f64a589cc356b01fd0fa35', 'test12', 'gdyb21LQTcIANtvYMT7QVQ==', 'user', '15816019724', '440823199912202118', 'tom', '默认头像.jpg', 999120, '4QrcOUm6Wau+VuBX8g+IPg==', 0, '2019-04-20 20:21:30', '2019-04-20 20:21:30');
INSERT INTO `t_user` VALUES ('c809571f96744de9a10d91445645db3d', 'test21', 'gdyb21LQTcIANtvYMT7QVQ==', 'user', '15816019724', '440823199912202118', 'tom', '默认头像.jpg', 999210, '4QrcOUm6Wau+VuBX8g+IPg==', 0, '2019-04-20 20:21:30', '2019-04-20 20:21:30');
INSERT INTO `t_user` VALUES ('c85b599fa53a4590810c7e93147cfd74', 'test21', 'gdyb21LQTcIANtvYMT7QVQ==', 'user', '15816019724', '440823199912202118', 'tom', '默认头像.jpg', 999210, '4QrcOUm6Wau+VuBX8g+IPg==', 0, '2019-04-20 20:20:38', '2019-04-20 20:20:38');
INSERT INTO `t_user` VALUES ('cca5a7e9ab534317975b984bf78f0e54', 'test2222', 'iKx4AVsqegtTbH3WedYDLQ==', 'USER', '15816019723', '440823199912202117', 'qqqasdf', '', 0, '4QrcOUm6Wau+VuBX8g+IPg==', 0, '2019-04-21 17:43:15', '2019-04-21 17:43:15');
INSERT INTO `t_user` VALUES ('ceacd341135542218795450a946c22f0', 'test6', 'gdyb21LQTcIANtvYMT7QVQ==', 'user', '15816019724', '440823199912202118', 'tom', '默认头像.jpg', 99960, '4QrcOUm6Wau+VuBX8g+IPg==', 0, '2019-04-20 20:20:37', '2019-04-20 20:20:37');
INSERT INTO `t_user` VALUES ('cf0ca5fd92aa44028be6975001c2fd73', 'test15', 'gdyb21LQTcIANtvYMT7QVQ==', 'user', '15816019724', '440823199912202118', 'tom', '默认头像.jpg', 999150, '4QrcOUm6Wau+VuBX8g+IPg==', 0, '2019-04-20 20:21:30', '2019-04-20 20:21:30');
INSERT INTO `t_user` VALUES ('d132fc1ce4e24c5f8f4bfb54e77cdea5', 'test16', 'gdyb21LQTcIANtvYMT7QVQ==', 'user', '15816019724', '440823199912202118', 'tom', '默认头像.jpg', 999160, '4QrcOUm6Wau+VuBX8g+IPg==', 0, '2019-04-20 20:21:30', '2019-04-20 20:21:30');
INSERT INTO `t_user` VALUES ('d7cab5c9dfff40a1b53f5080d963a13d', 'test25', 'gdyb21LQTcIANtvYMT7QVQ==', 'user', '15816019724', '440823199912202118', 'tom', '默认头像.jpg', 999250, '4QrcOUm6Wau+VuBX8g+IPg==', 0, '2019-04-20 20:20:38', '2019-04-20 20:20:38');
INSERT INTO `t_user` VALUES ('dac00243234949e185370902c636f578', 'test8888', 'v9dL879MDsh9UbrTI0/MmQ==', 'ADMIN', '15816019723', '440823199912202117', '我叫蔡徐坤', 'd682b23c55854cc5874904b1715a0e6f.jpg', 0, '4QrcOUm6Wau+VuBX8g+IPg==', 0, '2019-04-21 02:33:37', '2019-04-21 22:44:30');
INSERT INTO `t_user` VALUES ('dee2ba0987af4028af7d6a6a35b6826b', 'test5', 'gdyb21LQTcIANtvYMT7QVQ==', 'user', '15816019724', '440823199912202118', 'tom', '默认头像.jpg', 99950, '4QrcOUm6Wau+VuBX8g+IPg==', 0, '2019-04-20 20:21:30', '2019-04-20 20:21:30');
INSERT INTO `t_user` VALUES ('dfdcab2a783246ae9e14d395caab2947', 'test2', 'gdyb21LQTcIANtvYMT7QVQ==', 'user', '15816019724', '440823199912202118', 'tom', '默认头像.jpg', 99920, '4QrcOUm6Wau+VuBX8g+IPg==', 0, '2019-04-20 20:20:37', '2019-04-20 20:20:37');
INSERT INTO `t_user` VALUES ('f36b16fe4dee4b38a510e6c4d5b389e4', 'test22', 'gdyb21LQTcIANtvYMT7QVQ==', 'user', '15816019724', '440823199912202118', 'tom', '默认头像.jpg', 999220, '4QrcOUm6Wau+VuBX8g+IPg==', 0, '2019-04-20 20:21:30', '2019-04-20 20:21:30');
INSERT INTO `t_user` VALUES ('f7af8e09806148e684e8707a8aa8ccb5', 'test8', 'gdyb21LQTcIANtvYMT7QVQ==', 'user', '15816019724', '440823199912202118', 'tom', '默认头像.jpg', 99980, '4QrcOUm6Wau+VuBX8g+IPg==', 0, '2019-04-20 20:21:30', '2019-04-20 20:21:30');
INSERT INTO `t_user` VALUES ('fd8f21ac4da14ee0924eba4faf8458c2', 'test23', 'gdyb21LQTcIANtvYMT7QVQ==', 'user', '15816019724', '440823199912202118', 'tom', '默认头像.jpg', 999230, '4QrcOUm6Wau+VuBX8g+IPg==', 0, '2019-04-20 20:21:30', '2019-04-20 20:21:30');
INSERT INTO `t_user` VALUES ('fed597e60a414793849e544e615fa71a', 'test15', 'gdyb21LQTcIANtvYMT7QVQ==', 'user', '15816019724', '440823199912202118', 'tom', '默认头像.jpg', 999150, '4QrcOUm6Wau+VuBX8g+IPg==', 0, '2019-04-20 20:20:38', '2019-04-20 20:20:38');

-- ----------------------------
-- Table structure for tb_base
-- ----------------------------
DROP TABLE IF EXISTS `tb_base`;
CREATE TABLE `tb_base`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键',
  `status` smallint(1) UNSIGNED NOT NULL COMMENT '状态',
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `gmt_modified` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
