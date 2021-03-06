/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : clothing

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-10-05 23:43:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for a_menu
-- ----------------------------
DROP TABLE IF EXISTS `a_menu`;
CREATE TABLE `a_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_id` int(11) NOT NULL DEFAULT '0',
  `name` varchar(100) NOT NULL,
  `icon` varchar(765) DEFAULT NULL,
  `url` varchar(765) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`,`create_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of a_menu
-- ----------------------------

-- ----------------------------
-- Table structure for a_param
-- ----------------------------
DROP TABLE IF EXISTS `a_param`;
CREATE TABLE `a_param` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '节点id,初始节点为0',
  `Before_node_id` int(11) DEFAULT NULL COMMENT '上一个节点的id,初始节点id为0',
  `param_name` varchar(25) CHARACTER SET utf8 NOT NULL COMMENT '参数名',
  `param` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '参数内容,如果为url并且超出50个字符的需要转短URL存入',
  `key` varchar(25) DEFAULT NULL COMMENT '用来获取param的秘钥',
  `describe` varchar(150) DEFAULT NULL COMMENT '节点信息描述',
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of a_param
-- ----------------------------

-- ----------------------------
-- Table structure for a_permission
-- ----------------------------
DROP TABLE IF EXISTS `a_permission`;
CREATE TABLE `a_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `permission_key` varchar(30) NOT NULL,
  `permission_name` varchar(50) NOT NULL,
  `describe` varchar(50) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_index_ids_permission_key` (`permission_key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of a_permission
-- ----------------------------

-- ----------------------------
-- Table structure for a_role
-- ----------------------------
DROP TABLE IF EXISTS `a_role`;
CREATE TABLE `a_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_key` varchar(20) NOT NULL,
  `role_name` varchar(20) NOT NULL,
  `describe` varchar(50) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_index_ids_role_key` (`role_key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of a_role
-- ----------------------------

-- ----------------------------
-- Table structure for a_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `a_role_menu`;
CREATE TABLE `a_role_menu` (
  `role_id` int(11) NOT NULL,
  `menu_id` int(11) NOT NULL,
  PRIMARY KEY (`role_id`,`menu_id`),
  KEY `menu_id` (`menu_id`),
  CONSTRAINT `a_role_menu_ibfk_1` FOREIGN KEY (`menu_id`) REFERENCES `a_menu` (`id`),
  CONSTRAINT `a_role_menu_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `a_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of a_role_menu
-- ----------------------------

-- ----------------------------
-- Table structure for a_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `a_role_permission`;
CREATE TABLE `a_role_permission` (
  `role_id` int(11) NOT NULL,
  `permission_id` int(11) NOT NULL,
  PRIMARY KEY (`role_id`,`permission_id`),
  KEY `a_role_permission_ibfk_1` (`permission_id`),
  CONSTRAINT `a_role_permission_ibfk_1` FOREIGN KEY (`permission_id`) REFERENCES `a_permission` (`id`),
  CONSTRAINT `a_role_permission_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `a_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of a_role_permission
-- ----------------------------

-- ----------------------------
-- Table structure for a_user
-- ----------------------------
DROP TABLE IF EXISTS `a_user`;
CREATE TABLE `a_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL COMMENT '用户名，登录使用',
  `nick_name` varchar(30) DEFAULT NULL COMMENT '昵称',
  `pass` varchar(50) NOT NULL COMMENT '登录密码',
  `phone` varchar(20) DEFAULT NULL COMMENT '手机号码',
  `weixin_token` varchar(50) DEFAULT NULL,
  `last_login_time` datetime DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `a_user_unique_index_name` (`name`),
  UNIQUE KEY `a_user_unique_index_phone` (`phone`),
  UNIQUE KEY `a_user_unique_index_weixin_token` (`weixin_token`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of a_user
-- ----------------------------

-- ----------------------------
-- Table structure for a_user_role
-- ----------------------------
DROP TABLE IF EXISTS `a_user_role`;
CREATE TABLE `a_user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `a_user_role_ibfk_1` (`role_id`),
  CONSTRAINT `a_user_role_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `a_role` (`id`),
  CONSTRAINT `a_user_role_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `a_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of a_user_role
-- ----------------------------

-- ----------------------------
-- Table structure for b_banner
-- ----------------------------
DROP TABLE IF EXISTS `b_banner`;
CREATE TABLE `b_banner` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `group_key` varchar(30) DEFAULT NULL COMMENT '分组标识',
  `name` varchar(50) NOT NULL COMMENT '名称',
  `sort` int(11) NOT NULL DEFAULT '999999' COMMENT '权重，多个轮播时越大越靠前',
  `des` varchar(200) DEFAULT NULL COMMENT '描述',
  `img_url` varchar(500) DEFAULT NULL COMMENT '图片地址',
  `click_url` varchar(500) DEFAULT NULL COMMENT '点击跳转地址',
  `status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '状态：0-不显示；1-展示',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间，每次更新需更新该字段',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='该表可存储所有banner推广数据，数据结构基本满足，如果数据量较大或者有其他特殊字段，则使用自己的业务表';

-- ----------------------------
-- Records of b_banner
-- ----------------------------
INSERT INTO `b_banner` VALUES ('1', 'GROUP_HOME', 'CLOTHING-BANANER', '999999', '精品', 'https://goss.veer.com/creative/vcg/veer/800water/veer-126165703.jpg', 'www.baidu.com', '1', '2018-09-29 14:57:08', '2018-09-29 14:57:10');
INSERT INTO `b_banner` VALUES ('2', 'GROUP_HOME', 'CLOTHING-BANNER-2', '999999', '优品', 'https://goss.veer.com/creative/vcg/veer/800water/veer-128721332.jpg', 'www.baidu.com', '1', '2018-09-29 14:57:52', '2018-09-29 14:57:54');
INSERT INTO `b_banner` VALUES ('3', 'GROUP_HOME', 'CLOTHING-BANNER', '999998', '贵品', 'https://goss.veer.com/creative/vcg/veer/800water/veer-129219979.jpg', 'www.baidu.com', '1', '2018-09-29 14:59:20', '2018-09-29 14:59:23');

-- ----------------------------
-- Table structure for b_cart_product
-- ----------------------------
DROP TABLE IF EXISTS `b_cart_product`;
CREATE TABLE `b_cart_product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `member_id` int(11) NOT NULL COMMENT '用户ID',
  `product_standard_id` int(11) NOT NULL COMMENT '商品规格ID',
  `buy_num` int(11) unsigned NOT NULL DEFAULT '1' COMMENT '购买数量',
  `remark` varchar(255) DEFAULT NULL COMMENT '商品备注',
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  `is_delete` int(2) DEFAULT '0' COMMENT '是否删除，0 - 否 1-是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=417 DEFAULT CHARSET=utf8 COMMENT='用户购物车商品';

-- ----------------------------
-- Records of b_cart_product
-- ----------------------------
INSERT INTO `b_cart_product` VALUES ('409', '1', '1', '1', '备注', '2018-10-05 21:32:04', '2018-10-05 21:32:04', '0');
INSERT INTO `b_cart_product` VALUES ('413', '1', '1', '1', '备注', '2018-10-05 21:33:11', '2018-10-05 21:33:11', '0');
INSERT INTO `b_cart_product` VALUES ('414', '1', '1', '1', '备注', '2018-10-05 21:33:12', '2018-10-05 21:33:12', '0');
INSERT INTO `b_cart_product` VALUES ('415', '1', '1', '1', '备注', '2018-10-05 21:33:12', '2018-10-05 21:33:12', '0');
INSERT INTO `b_cart_product` VALUES ('416', '1', '1', '1', '备注', '2018-10-05 21:33:12', '2018-10-05 21:33:12', '0');

-- ----------------------------
-- Table structure for b_delivery
-- ----------------------------
DROP TABLE IF EXISTS `b_delivery`;
CREATE TABLE `b_delivery` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '物流公司名称',
  `numbers` varchar(50) DEFAULT NULL COMMENT '物流单号',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='物流表';

-- ----------------------------
-- Records of b_delivery
-- ----------------------------

-- ----------------------------
-- Table structure for b_member
-- ----------------------------
DROP TABLE IF EXISTS `b_member`;
CREATE TABLE `b_member` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'PK',
  `OPENID` varchar(100) DEFAULT NULL COMMENT '外部标识ID号',
  `NICK_NAME` varchar(100) NOT NULL COMMENT '昵称',
  `HEAD_IMG` varchar(150) DEFAULT NULL COMMENT '头像路径',
  `M_TYPE` int(2) DEFAULT NULL COMMENT '用户类型:‘1’= 微信；‘2’=支付宝',
  `M_GROUP` int(2) DEFAULT '1' COMMENT '用户分组：‘1’= 普通用户；‘2’= 店铺管理；‘3’= 业务经理；‘4’= 区域代理；‘5’= 市级代理；‘6’= 省级代理；‘7’= 平台用户；',
  `ISRECEIVE` int(2) DEFAULT NULL COMMENT '是否接收模板消息:‘1’= 是；‘2’= 否；',
  `ISWITHDRAW` int(2) DEFAULT NULL COMMENT '是否允许提现:‘1’= 是；‘2’= 否；',
  `ISBLOCK` int(2) DEFAULT NULL COMMENT '是否停用账号:‘1’= 是；‘2’= 否；',
  `SEX` int(2) DEFAULT NULL COMMENT '性别:0=‘其他’；‘1’= 男；‘2’= 女；',
  `REGISTTIME` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '注册时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of b_member
-- ----------------------------

-- ----------------------------
-- Table structure for b_member_charging_record
-- ----------------------------
DROP TABLE IF EXISTS `b_member_charging_record`;
CREATE TABLE `b_member_charging_record` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'PK',
  `MID` int(11) NOT NULL COMMENT '用户ID',
  `NUMBERS` varchar(50) DEFAULT NULL COMMENT '系统单号',
  `ACCRUAL` double(5,1) DEFAULT NULL COMMENT '发生额',
  `ODD_NUMBERS` varchar(50) DEFAULT NULL COMMENT '交易单号',
  `TRADING_TYPE` int(2) DEFAULT NULL COMMENT '交易方式：‘1’= 微信；‘2’= 支付宝；',
  `TRADING_TIME` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '交易时间',
  `TALLY_TYPE` int(2) DEFAULT NULL COMMENT '记账方式',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户使用扣费记录表';

-- ----------------------------
-- Records of b_member_charging_record
-- ----------------------------

-- ----------------------------
-- Table structure for b_member_recharge_record
-- ----------------------------
DROP TABLE IF EXISTS `b_member_recharge_record`;
CREATE TABLE `b_member_recharge_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'PK',
  `MID` int(11) NOT NULL COMMENT '用户ID',
  `NUMBERS` varchar(50) DEFAULT NULL COMMENT '系统单号',
  `ACCRUAL` double(5,1) DEFAULT NULL COMMENT '发生额',
  `ODD_NUMBERS` varchar(50) DEFAULT NULL COMMENT '交易单号',
  `TRADING_TYPE` int(2) DEFAULT NULL COMMENT '交易方式:‘1’= 微信；‘2’= 支付宝；',
  `TRADING_TIME` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '交易时间',
  `PAY_STATUS` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户充值记录表';

-- ----------------------------
-- Records of b_member_recharge_record
-- ----------------------------

-- ----------------------------
-- Table structure for b_member_wallet
-- ----------------------------
DROP TABLE IF EXISTS `b_member_wallet`;
CREATE TABLE `b_member_wallet` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'PK',
  `MID` int(11) NOT NULL COMMENT '用户ID',
  `ACCRUAL` double(5,1) DEFAULT NULL COMMENT '钱包发生额',
  `CURRENT` double(5,1) DEFAULT NULL COMMENT '当前余额',
  `LAST_BALANCE` double(5,1) DEFAULT NULL COMMENT '最后余额',
  `CHANGE_TIME` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '钱包变化时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户钱包';

-- ----------------------------
-- Records of b_member_wallet
-- ----------------------------

-- ----------------------------
-- Table structure for b_order
-- ----------------------------
DROP TABLE IF EXISTS `b_order`;
CREATE TABLE `b_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(50) NOT NULL COMMENT '订单的id,orderId,也是支付id',
  `u_id` int(11) NOT NULL COMMENT '买家uid,和b_order-detailxiang',
  `order_status` tinyint(4) NOT NULL COMMENT '商品状态，0-未支付(已下单)；5-已付款（未发货）；10-运送中（发货中）；20-已收货（订单正常完成）；30-撤单申请中（撤单中）；40-已退款（订单完成）',
  `pay_status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '支付状态，0-未支付；5-已支付；10-已退款，状态变更时这里可能需要修改',
  `pay_need_money` decimal(8,2) NOT NULL COMMENT '需要支付的金额',
  `pay_total_money` decimal(8,2) NOT NULL COMMENT '已支付金额',
  `pay_callback` varchar(200) DEFAULT NULL COMMENT '支付回调信息记录用来确认支付订单在支付平台对应的订单状态',
  `pay_success` int(11) NOT NULL DEFAULT '0' COMMENT '支付成功 0未成功  1成功',
  `buy_uid` int(11) NOT NULL COMMENT '买家uid',
  `delivery_id` int(11) DEFAULT NULL COMMENT '物流信息,外键b_delivery 的id',
  `pay_time` datetime DEFAULT NULL COMMENT '支付时间',
  `refund_status` int(4) DEFAULT '0' COMMENT '退款状态 0.未退款 1.已退款',
  `delivery_time` datetime DEFAULT NULL COMMENT '配送时间',
  `refund_time` datetime DEFAULT NULL COMMENT '退款时间',
  `create_time` datetime NOT NULL COMMENT '订单创建时间',
  `update_time` datetime NOT NULL COMMENT '数据更新时间',
  `cancel_time` datetime DEFAULT NULL COMMENT '撤单时间',
  `cancel_reason` varchar(200) DEFAULT NULL COMMENT '撤单原因',
  PRIMARY KEY (`id`),
  UNIQUE KEY `code` (`code`) USING BTREE COMMENT '唯一,有序'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单表';

-- ----------------------------
-- Records of b_order
-- ----------------------------

-- ----------------------------
-- Table structure for b_order_detail
-- ----------------------------
DROP TABLE IF EXISTS `b_order_detail`;
CREATE TABLE `b_order_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(38) NOT NULL COMMENT '订单id',
  `product_id` int(11) NOT NULL COMMENT '商品ID',
  `product_standard_id` int(11) NOT NULL COMMENT '商品规格ID',
  `measure_unit` varchar(5) CHARACTER SET utf8 NOT NULL COMMENT '计量单位，对应于商品表里的该字段',
  `num` int(11) NOT NULL COMMENT '购买数量',
  `original_price` decimal(10,0) NOT NULL DEFAULT '0' COMMENT '单件原价',
  `sell_price` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '单件售价',
  `send_goods_pay` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '物流费',
  `total_pay` decimal(10,2) NOT NULL COMMENT '总支付价，并不一定等于sell_price*num，可能会有抵用券，抵用券需考虑退单时的返还，暂时不做抵用券逻辑，以后加的话，抵用券放到另一张表',
  `buy_remark` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '购买备注，如商品的颜色和尺寸等',
  `send_goods_time` datetime DEFAULT NULL COMMENT '发货时间',
  `take_goods_time` datetime DEFAULT NULL COMMENT '收货时间',
  `create_time` datetime NOT NULL COMMENT '订单创建时间',
  `update_time` datetime NOT NULL COMMENT '数据更新时间',
  PRIMARY KEY (`id`),
  KEY `code` (`code`) USING BTREE COMMENT '不唯一,有序'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of b_order_detail
-- ----------------------------

-- ----------------------------
-- Table structure for b_product
-- ----------------------------
DROP TABLE IF EXISTS `b_product`;
CREATE TABLE `b_product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL COMMENT '商品组名称',
  `type` varchar(20) DEFAULT NULL COMMENT '商品类型，服装衬衫，裤子',
  `area` int(11) DEFAULT NULL COMMENT '区域外键',
  `sort` int(10) unsigned NOT NULL DEFAULT '1' COMMENT '排序，越大越靠前',
  `brand` varchar(50) DEFAULT NULL COMMENT '品牌',
  `measure_unit` varchar(5) NOT NULL COMMENT '计量单位，如：箱',
  `status` int(2) NOT NULL DEFAULT '1' COMMENT '状态：1-上架；0-下架；-1-删除，当修改状态为下架时，需修改该商品下所有的规格为下架状态',
  `img` varchar(255) NOT NULL COMMENT '商品图片，使用轮播图的第一张',
  `des` varchar(255) DEFAULT NULL COMMENT '描述',
  `store_way` varchar(255) DEFAULT NULL COMMENT '存储方式描述',
  `total_sell_num` int(11) NOT NULL DEFAULT '0' COMMENT '总购买数量，使用本地事件更新，即订单成功后，加数量',
  `week_sell_num` int(11) NOT NULL DEFAULT '0' COMMENT '最近一周的购买数量，定期统计',
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='商品信息，不包含价格以及其他属性，类似于商品组概念';

-- ----------------------------
-- Records of b_product
-- ----------------------------
INSERT INTO `b_product` VALUES ('1', '2018春季时尚胖mm大码打底衫女装长袖网纱韩版小衫百搭上衣V领T恤', '1', '1', '1', '无', '件', '1', '//gaitaobao1.alicdn.com/tfscom/i4/2871754777/TB2kLxokmtYBeNjSspaXXaOOFXa_!!2871754777.jpg_300x300q90.jpg_.webp', '描述', '100', '4562', '0', '2018-10-01 03:12:17', '2018-10-01 03:12:21');
INSERT INTO `b_product` VALUES ('2', '蕾丝打底衫女长袖2018春秋新款立领韩版百搭镂空性感网纱T恤上衣', '1', '1', '1', '无', '件', '1', '//img.alicdn.com/bao/uploaded/i3/3265188276/TB2h0yTXG6qK1RjSZFmXXX0PFXa_!!3265188276-0-item_pic.jpg_300x300q90.jpg_.webp', '描述', '99', '2587', '0', '2018-10-01 03:13:07', '2018-10-01 03:13:09');
INSERT INTO `b_product` VALUES ('3', '蕾丝打底衫女秋冬洋气小衫2018新款长袖V领气质秋季百搭网纱上衣', '1', '1', '1', '无', '件', '1', '//img.alicdn.com/bao/uploaded/i1/2261750516/TB1JexcbXooBKNjSZPhXXc2CXXa_!!0-item_pic.jpg_300x300q90.jpg_.webp', '描述', '98', '1032', '0', '2018-10-01 03:13:52', '2018-10-01 03:13:56');
INSERT INTO `b_product` VALUES ('4', '2018秋季新款百搭修身打底衫长袖女上衣V领印花胖mm大码网纱t恤潮', '1', '1', '1', '无', '件', '1', '//img.alicdn.com/bao/uploaded/i2/2871754777/TB1J1U6bzTpK1RjSZKPXXa3UpXa_!!0-item_pic.jpg_300x300q90.jpg_.webp', '描述', '97', '230', '0', '2018-10-01 03:14:16', '2018-10-01 03:14:18');

-- ----------------------------
-- Table structure for b_product_img
-- ----------------------------
DROP TABLE IF EXISTS `b_product_img`;
CREATE TABLE `b_product_img` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) NOT NULL COMMENT '商品ID',
  `type` tinyint(4) NOT NULL COMMENT '商品图片类型',
  `sort` int(11) NOT NULL COMMENT '权重，越小越靠前',
  `img_url` varchar(500) NOT NULL COMMENT '图片地址',
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='商品图片，商品轮播图';

-- ----------------------------
-- Records of b_product_img
-- ----------------------------
INSERT INTO `b_product_img` VALUES ('1', '1', '1', '1', '//gaitaobao4.alicdn.com/tfscom/i4/2587521546/TB2vLGTdfImBKNjSZFlXXc43FXa_!!2587521546.jpg_300x300q90.jpg_.webp', '2018-10-01 04:12:57', '2018-10-01 04:12:59');
INSERT INTO `b_product_img` VALUES ('2', '1', '1', '2', '//img.alicdn.com/bao/uploaded/i2/382392422/O1CN011TlJiz7zTuHVih6_!!382392422.jpg_300x300q90.jpg_.webp', '2018-10-01 04:13:42', '2018-10-01 04:13:46');
INSERT INTO `b_product_img` VALUES ('3', '1', '1', '3', '//img.alicdn.com/bao/uploaded/i1/444095468/TB2TedaXjfguuRjSspkXXXchpXa_!!444095468.jpg_300x300q90.jpg_.webp', '2018-10-01 04:14:06', '2018-10-01 04:14:08');

-- ----------------------------
-- Table structure for b_product_keyword
-- ----------------------------
DROP TABLE IF EXISTS `b_product_keyword`;
CREATE TABLE `b_product_keyword` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) NOT NULL,
  `keyword` varchar(20) NOT NULL,
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `b_product_keyword_index_product_id-keyword` (`product_id`,`keyword`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品关键字';

-- ----------------------------
-- Records of b_product_keyword
-- ----------------------------

-- ----------------------------
-- Table structure for b_product_recommend
-- ----------------------------
DROP TABLE IF EXISTS `b_product_recommend`;
CREATE TABLE `b_product_recommend` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) NOT NULL COMMENT '商品ID',
  `type` tinyint(4) NOT NULL COMMENT '推广类型标识，如：秋季必买，夏季盛装',
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品推荐配置，用于微信前端主页的秋季必买，夏季盛装标签下的商品';

-- ----------------------------
-- Records of b_product_recommend
-- ----------------------------

-- ----------------------------
-- Table structure for b_product_standard
-- ----------------------------
DROP TABLE IF EXISTS `b_product_standard`;
CREATE TABLE `b_product_standard` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) NOT NULL COMMENT '商品组ID',
  `name` varchar(50) NOT NULL COMMENT '规格名，用于商品列表副标题展示',
  `sub_title` varchar(255) NOT NULL COMMENT '商品副标题，用于商品列表副标题展示',
  `original_price` decimal(10,2) NOT NULL COMMENT '原价',
  `sell_price` decimal(10,2) NOT NULL COMMENT '售价',
  `cost_price` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '进货价',
  `shipping_fee` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '基础运费',
  `carton_weight` double NOT NULL DEFAULT '0' COMMENT '装箱重量',
  `purchase_quantity_min` int(11) NOT NULL DEFAULT '1' COMMENT '最小采购数量',
  `purchase_quantity_max` int(11) NOT NULL DEFAULT '99999' COMMENT '最大采购数量',
  `buy_start_time` datetime DEFAULT NULL COMMENT '可购买开始时间，可为空，为空则不限制开始时间',
  `buy_end_time` datetime DEFAULT NULL COMMENT '可购买结束时间，可为空，为空则不限制结束时间',
  `sort_purchase` int(5) NOT NULL DEFAULT '1' COMMENT '采购单排序',
  `sort_sold_out` int(5) NOT NULL DEFAULT '1' COMMENT '出货单排序',
  `sort_split` int(5) NOT NULL DEFAULT '1' COMMENT '分拣单排序',
  `stock` int(11) NOT NULL DEFAULT '0' COMMENT '库存',
  `status` int(5) NOT NULL DEFAULT '1' COMMENT '状态，1-上架；0-下架；-1-删除，商品下架后该商品下的所有规格全下架（改状态为0）,下次上架时人为上架商品下的规格',
  `is_default` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否为商品默认规格0 - 否 ， 1 - 是',
  `purchaser_uid` int(11) NOT NULL COMMENT '采购员用户ID',
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL COMMENT '最近更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='商品规格，包含商品售价等等，一个商品会有多个规格，其中会有一个是默认规格';

-- ----------------------------
-- Records of b_product_standard
-- ----------------------------
INSERT INTO `b_product_standard` VALUES ('1', '1', '2018春季时尚胖mm大码打底衫女装长袖网纱韩版小衫百搭上衣V领T恤', '潮流女装', '500.00', '198.00', '100.00', '20.00', '0.5', '1', '999', '2018-10-01 03:41:47', '2018-10-01 03:41:49', '1', '1', '1', '0', '1', '1', '1', '2018-10-01 03:42:17', '2018-10-01 03:42:26');
INSERT INTO `b_product_standard` VALUES ('2', '2', '蕾丝打底衫女秋冬洋气小衫2018新款长袖V领气质秋季百搭网纱上衣', '杜蕾斯', '298.00', '98.00', '30.00', '10.00', '0.5', '1', '999', '2018-10-01 03:43:18', '2018-10-01 03:43:21', '1', '1', '1', '0', '1', '1', '1', '2018-10-01 03:43:28', '2018-10-01 03:43:31');
INSERT INTO `b_product_standard` VALUES ('3', '3', '2018秋季新款百搭修身打底衫长袖女上衣V领印花胖mm大码网纱t恤潮', '秋季时尚装', '198.00', '54.00', '30.00', '5.00', '0.5', '1', '999', '2018-10-01 03:44:33', '2018-10-01 03:44:35', '1', '1', '1', '0', '1', '1', '1', '2018-10-01 03:44:41', '2018-10-01 03:44:44');
INSERT INTO `b_product_standard` VALUES ('4', '4', '亮丝网纱打底衫2018秋季新款百搭v领纯色外穿上衣女长袖内搭T恤衫', '气质女装', '98.00', '38.00', '10.00', '5.00', '0', '1', '999', '2018-10-01 03:49:00', '2018-10-18 03:49:03', '1', '1', '1', '0', '1', '1', '1', '2018-10-01 03:49:14', '2018-10-01 03:49:17');

-- ----------------------------
-- Table structure for b_product_standard_param
-- ----------------------------
DROP TABLE IF EXISTS `b_product_standard_param`;
CREATE TABLE `b_product_standard_param` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_standard_id` int(11) NOT NULL COMMENT '商品规格ID',
  `standard_color_id` int(11) DEFAULT NULL COMMENT '商品规格颜色',
  `standard_size_id` int(11) DEFAULT NULL COMMENT '商品规格大小',
  `create_time` datetime DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of b_product_standard_param
-- ----------------------------
INSERT INTO `b_product_standard_param` VALUES ('1', '1', '1', '1', '2018-10-05 23:14:13', null);
INSERT INTO `b_product_standard_param` VALUES ('2', '1', '1', '2', '2018-10-05 23:14:24', null);
INSERT INTO `b_product_standard_param` VALUES ('3', '1', '1', '3', '2018-10-05 23:14:39', null);
INSERT INTO `b_product_standard_param` VALUES ('4', '1', '2', '1', '2018-10-05 23:14:53', null);
INSERT INTO `b_product_standard_param` VALUES ('5', '1', '2', '2', '2018-10-05 23:15:07', null);

-- ----------------------------
-- Table structure for b_standard_color
-- ----------------------------
DROP TABLE IF EXISTS `b_standard_color`;
CREATE TABLE `b_standard_color` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '规格颜色',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of b_standard_color
-- ----------------------------
INSERT INTO `b_standard_color` VALUES ('1', '白色', '2018-10-05 23:08:21');
INSERT INTO `b_standard_color` VALUES ('2', '红色', '2018-10-05 23:08:28');
INSERT INTO `b_standard_color` VALUES ('3', '黑色', '2018-10-05 23:08:34');
INSERT INTO `b_standard_color` VALUES ('4', '灰色', '2018-10-05 23:08:40');
INSERT INTO `b_standard_color` VALUES ('5', '绿色', '2018-10-05 23:08:46');
INSERT INTO `b_standard_color` VALUES ('6', '黄色', '2018-10-05 23:08:52');
INSERT INTO `b_standard_color` VALUES ('7', '黑色', '2018-10-05 23:08:57');

-- ----------------------------
-- Table structure for b_standard_size
-- ----------------------------
DROP TABLE IF EXISTS `b_standard_size`;
CREATE TABLE `b_standard_size` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `size` int(4) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL COMMENT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of b_standard_size
-- ----------------------------
INSERT INTO `b_standard_size` VALUES ('1', '小码', '31', '2018-10-05 23:09:08');
INSERT INTO `b_standard_size` VALUES ('2', '小码', '32', '2018-10-05 23:09:08');
INSERT INTO `b_standard_size` VALUES ('3', '小码', '33', '2018-10-05 23:09:08');
INSERT INTO `b_standard_size` VALUES ('4', '小码', '34', '2018-10-05 23:09:08');
INSERT INTO `b_standard_size` VALUES ('5', '中码', '35', '2018-10-05 23:09:08');
INSERT INTO `b_standard_size` VALUES ('6', '中码', '36', '2018-10-05 23:09:08');
INSERT INTO `b_standard_size` VALUES ('7', '中码', '37', '2018-10-05 23:09:08');
INSERT INTO `b_standard_size` VALUES ('8', '大码', '38', '2018-10-05 23:09:08');
INSERT INTO `b_standard_size` VALUES ('9', '大码', '39', '2018-10-05 23:09:08');
INSERT INTO `b_standard_size` VALUES ('10', '大码', '40', '2018-10-05 23:09:08');
INSERT INTO `b_standard_size` VALUES ('11', '大码', '41', '2018-10-05 23:09:08');

-- ----------------------------
-- Table structure for b_type
-- ----------------------------
DROP TABLE IF EXISTS `b_type`;
CREATE TABLE `b_type` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL COMMENT '分类名称',
  `sort` int(10) unsigned NOT NULL DEFAULT '1' COMMENT '排序，越大越靠前',
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '状态：0-禁用；1-启用',
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='商品类型';

-- ----------------------------
-- Records of b_type
-- ----------------------------
INSERT INTO `b_type` VALUES ('1', '保暖冬衣', '1', '0', '2018-10-01 03:06:07', '2018-10-01 03:06:10');
INSERT INTO `b_type` VALUES ('2', '韩版牛仔裤', '1', '0', '2018-10-01 03:06:32', '2018-10-01 03:06:35');
INSERT INTO `b_type` VALUES ('3', '潮流T恤', '1', '0', '2018-10-01 03:06:53', '2018-10-01 03:06:55');

-- ----------------------------
-- Table structure for c_area
-- ----------------------------
DROP TABLE IF EXISTS `c_area`;
CREATE TABLE `c_area` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `EN_NAME` varchar(80) DEFAULT NULL COMMENT '英文名称',
  `CN_NAME` varchar(80) DEFAULT NULL COMMENT '中文名称',
  `CITY` bigint(20) DEFAULT NULL COMMENT '所属城市，FK,CITY',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='区域表';

-- ----------------------------
-- Records of c_area
-- ----------------------------

-- ----------------------------
-- Table structure for c_city
-- ----------------------------
DROP TABLE IF EXISTS `c_city`;
CREATE TABLE `c_city` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `EN_NAME` varchar(80) DEFAULT NULL,
  `CN_NAME` varchar(80) DEFAULT NULL,
  `PROVINCE` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='城市表';

-- ----------------------------
-- Records of c_city
-- ----------------------------

-- ----------------------------
-- Table structure for c_country
-- ----------------------------
DROP TABLE IF EXISTS `c_country`;
CREATE TABLE `c_country` (
  `ID` int(20) NOT NULL AUTO_INCREMENT COMMENT 'PK',
  `EN_NAME` varchar(80) DEFAULT NULL COMMENT '英文名称',
  `CN_NAME` varchar(80) DEFAULT NULL COMMENT '中文名称',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='国家表';

-- ----------------------------
-- Records of c_country
-- ----------------------------

-- ----------------------------
-- Table structure for c_province
-- ----------------------------
DROP TABLE IF EXISTS `c_province`;
CREATE TABLE `c_province` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'PK',
  `EN_NAME` varchar(80) DEFAULT NULL COMMENT '英文名称',
  `CN_NAME` varchar(80) DEFAULT NULL COMMENT '中文名称',
  `COUNTRY` bigint(20) DEFAULT NULL COMMENT '所属国家',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='省会表';

-- ----------------------------
-- Records of c_province
-- ----------------------------
