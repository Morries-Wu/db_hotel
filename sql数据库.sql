/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 8.0.20 : Database - db_hotel
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_hotel` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `db_hotel`;

/*Table structure for table `sys_dept` */

DROP TABLE IF EXISTS `sys_dept`;

CREATE TABLE `sys_dept` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '部门编号',
  `deptname` varchar(50) DEFAULT NULL COMMENT '部门名称',
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `createDate` datetime DEFAULT NULL COMMENT '创建时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

/*Data for the table `sys_dept` */

insert  into `sys_dept`(`id`,`deptname`,`address`,`createDate`,`remark`) values (1,'管理部门','广东','2022-02-11 19:32:05','摸鱼部门'),(22,'测试部门','广东省广州市华南理工大学广州学院研发测试部','2022-03-01 16:10:21','                      ');

/*Table structure for table `sys_employee` */

DROP TABLE IF EXISTS `sys_employee`;

CREATE TABLE `sys_employee` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '员工编号',
  `loginname` varchar(50) DEFAULT NULL COMMENT '登录账号',
  `loginpwd` varchar(200) DEFAULT NULL COMMENT '登录密码',
  `name` varchar(50) DEFAULT NULL COMMENT '真实姓名',
  `sex` int DEFAULT NULL COMMENT '性别（1-男 2-女）',
  `deptId` int DEFAULT NULL COMMENT '部门编号',
  `hiredate` datetime DEFAULT NULL COMMENT '入职日期',
  `salt` varchar(100) DEFAULT NULL COMMENT '加密盐值',
  `createdBy` int DEFAULT NULL COMMENT '创建人',
  `createDate` datetime DEFAULT NULL COMMENT '创建时间',
  `modifyBy` int DEFAULT NULL COMMENT '修改人',
  `modifyDate` datetime DEFAULT NULL COMMENT '修改时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `sys_employee` */

insert  into `sys_employee`(`id`,`loginname`,`loginpwd`,`name`,`sex`,`deptId`,`hiredate`,`salt`,`createdBy`,`createDate`,`modifyBy`,`modifyDate`,`remark`) values (4,'333','ec2d54efa4a991539e18a240afc6c929','老六',1,22,'2022-03-05 00:00:00','5dcc8b16-5743-48ea-909b-00876de697a9',1,'2022-03-05 09:53:06',1,'2022-03-05 09:59:08',''),(6,'admin','4e4a213cd571f0f192ffd59a48ed9c66','Morries_Wu',1,1,'2022-03-01 00:00:00','4f729019-f28d-4ec8-b60f-bb7644eae3fa',5,'2022-03-05 11:14:26',NULL,NULL,''),(7,'lihua','f9ac943f1de86b47fe2cfef139ae9614','胡彦兵',1,1,'2022-06-09 00:00:00','7d9b644e-12d3-4a0c-be59-2448a272b198',6,'2022-05-30 16:24:26',6,'2022-06-09 09:22:14','');

/*Table structure for table `sys_menu` */

DROP TABLE IF EXISTS `sys_menu`;

CREATE TABLE `sys_menu` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '菜单编号',
  `pid` int DEFAULT NULL COMMENT '所属父级菜单编号',
  `title` varchar(255) DEFAULT NULL COMMENT '菜单名称',
  `href` varchar(255) DEFAULT NULL COMMENT '打开链接地址',
  `spread` int DEFAULT NULL COMMENT '是否展开(0-否，1-是)',
  `target` varchar(50) DEFAULT NULL COMMENT '打开方式',
  `icon` varchar(255) DEFAULT NULL COMMENT '菜单图标样式',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

/*Data for the table `sys_menu` */

insert  into `sys_menu`(`id`,`pid`,`title`,`href`,`spread`,`target`,`icon`) values (1,0,'系统管理','',1,'_self','fa fa-users'),(2,0,'客房管理','',1,'_self','fa fa-users'),(3,1,'员工管理','/db_hotel/admin/toEmployeeManager',0,NULL,'fa fa-users'),(4,1,'部门管理','/db_hotel/admin/toDeptManager',0,'','fa fa-users'),(5,2,'房型管理','/db_hotel/admin/toRoomTypeManager',0,NULL,'fa fa-users'),(6,2,'房间管理','/db_hotel/admin/toRoomManager',NULL,NULL,'fa fa-users'),(7,1,'角色管理','/db_hotel/admin/toRoleManager',NULL,NULL,'fa fa-users'),(8,1,'菜单管理','/db_hotel/admin/toMenuManager',NULL,NULL,'fa fa-users'),(9,2,'楼层管理','/db_hotel/admin/toFloorManager',NULL,'_self','fa fa-users'),(10,0,'报表管理','',1,'_self',''),(11,0,'订单管理','',1,'_self',''),(12,11,'预定管理','/db_hotel/admin/toOrdersManager',0,'_self','fa fa-align-center'),(13,11,'入住管理','/db_hotel/admin/toCheckinManager',0,'_self','fa fa-address-book-o'),(14,10,'年营业额报表分析','/db_hotel/admin/toYearTotalPriceManager',0,'_self','fa fa-area-chart'),(15,10,'月营业额','/db_hotel/admin/toYearOfMonthCharts',0,'_self',''),(16,2,'退款管理','/db_hotel/admin/toOutMoneyManage',0,'_self','');

/*Table structure for table `sys_role` */

DROP TABLE IF EXISTS `sys_role`;

CREATE TABLE `sys_role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `rolename` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `roledesc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `sys_role` */

insert  into `sys_role`(`id`,`rolename`,`roledesc`) values (1,'超级管理员','拥有所有操作权限'),(2,'系统管理员','拥有系统管理操作权限'),(6,'普通管理员','');

/*Table structure for table `sys_role_employee` */

DROP TABLE IF EXISTS `sys_role_employee`;

CREATE TABLE `sys_role_employee` (
  `eid` int NOT NULL COMMENT '员工编号',
  `rid` int NOT NULL COMMENT '角色编号'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_role_employee` */

insert  into `sys_role_employee`(`eid`,`rid`) values (4,7),(6,1),(7,2),(7,6);

/*Table structure for table `sys_role_menu` */

DROP TABLE IF EXISTS `sys_role_menu`;

CREATE TABLE `sys_role_menu` (
  `mid` int NOT NULL COMMENT '菜单编号',
  `rid` int NOT NULL COMMENT '角色编号'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_role_menu` */

insert  into `sys_role_menu`(`mid`,`rid`) values (1,2),(3,2),(4,2),(7,2),(8,2),(2,2),(5,2),(6,2),(9,2),(16,2),(2,6),(5,6),(6,6),(9,6),(16,6),(10,6),(14,6),(15,6),(11,6),(12,6),(13,6),(1,1),(3,1),(4,1),(7,1),(8,1),(2,1),(5,1),(6,1),(9,1),(10,1),(14,1),(11,1),(12,1),(13,1);

/*Table structure for table `t_checkin` */

DROP TABLE IF EXISTS `t_checkin`;

CREATE TABLE `t_checkin` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
  `roomTypeId` int DEFAULT NULL COMMENT '所属房型',
  `roomId` bigint DEFAULT NULL COMMENT '所属房间',
  `customerName` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '入住人姓名',
  `idCard` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '入住人身份证号',
  `phone` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '手机号',
  `arriveDate` date DEFAULT NULL COMMENT '入住日期',
  `leaveDate` date DEFAULT NULL COMMENT '离店日期',
  `payPrice` decimal(10,2) NOT NULL COMMENT '实付金额',
  `ordersId` bigint DEFAULT NULL COMMENT '关联预订订单ID',
  `status` int unsigned DEFAULT NULL COMMENT '状态',
  `createDate` datetime DEFAULT NULL COMMENT '创建时间',
  `createdBy` int DEFAULT NULL COMMENT '创建人',
  `modifyDate` datetime DEFAULT NULL COMMENT '修改时间',
  `modifyBy` int DEFAULT NULL COMMENT '修改人',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  `outPrice` decimal(10,2) DEFAULT NULL COMMENT '退款金额',
  PRIMARY KEY (`id`,`payPrice`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

/*Data for the table `t_checkin` */

insert  into `t_checkin`(`id`,`roomTypeId`,`roomId`,`customerName`,`idCard`,`phone`,`arriveDate`,`leaveDate`,`payPrice`,`ordersId`,`status`,`createDate`,`createdBy`,`modifyDate`,`modifyBy`,`remark`,`outPrice`) values (14,2,1,'李嘉诚','440811199808082690','19860780674','2022-06-16','2022-06-18','2700.00',12,2,'2022-06-14 13:42:35',6,NULL,NULL,'','0.00'),(15,2,1,'tom','312321321321321','211231312312','2022-06-17','2022-06-22','1500.00',13,1,'2022-06-17 10:00:49',6,NULL,NULL,NULL,NULL),(16,2,1,'tom','31231241','321321321321','2022-06-21','2022-06-23','900.00',14,2,'2022-06-21 10:32:11',6,NULL,NULL,NULL,'300.00');

/*Table structure for table `t_checkout` */

DROP TABLE IF EXISTS `t_checkout`;

CREATE TABLE `t_checkout` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
  `checkOutNumber` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '退房记录编号',
  `consumePrice` decimal(10,2) DEFAULT NULL COMMENT '消费金额',
  `createDate` datetime DEFAULT NULL COMMENT '创建时间',
  `createdBy` int DEFAULT NULL COMMENT '操作人',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  `checkInId` bigint DEFAULT NULL COMMENT '入住编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_checkout` */

insert  into `t_checkout`(`id`,`checkOutNumber`,`consumePrice`,`createDate`,`createdBy`,`remark`,`checkInId`) values (29,'8c86a81b-4fa7-42e5-b7a8-a780a7af8e34',NULL,'2022-06-16 20:55:59',NULL,NULL,NULL),(30,'92c7bbf5-412b-4a18-b90b-7643abc0b637',NULL,'2022-06-16 21:02:40',NULL,NULL,NULL),(31,'4d029f28-bbdc-4136-a272-2ad4cfb27911',NULL,'2022-06-16 21:07:45',NULL,NULL,NULL),(32,'44c7289e-9378-43a4-a623-d6b9982f0dd4',NULL,'2022-06-20 22:35:48',NULL,NULL,NULL),(33,'a6399d09-ac1d-458e-a53e-978f195928f6',NULL,'2022-06-21 10:37:18',NULL,NULL,NULL);

/*Table structure for table `t_floor` */

DROP TABLE IF EXISTS `t_floor`;

CREATE TABLE `t_floor` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '楼层名称',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_floor` */

insert  into `t_floor`(`id`,`name`,`remark`) values (1,'1楼','酒店1楼'),(3,'2楼',NULL),(4,'3楼','111'),(5,'4楼','231312');

/*Table structure for table `t_orders` */

DROP TABLE IF EXISTS `t_orders`;

CREATE TABLE `t_orders` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '预订编号',
  `ordersNo` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '预订单号',
  `accountId` bigint DEFAULT NULL COMMENT '预订人账号ID',
  `roomTypeId` int DEFAULT NULL COMMENT '房型编号',
  `roomId` bigint DEFAULT NULL COMMENT '房间ID',
  `reservationName` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '预订人姓名',
  `idCard` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '身份证号码',
  `phone` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '电话号码',
  `status` int DEFAULT NULL COMMENT '状态1-待确认  2-已确认',
  `reserveDate` datetime DEFAULT NULL COMMENT '预定时间',
  `arriveDate` date DEFAULT NULL COMMENT '到店时间',
  `leaveDate` date DEFAULT NULL COMMENT '离店时间',
  `reservePrice` decimal(10,2) DEFAULT NULL COMMENT '预订价格',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

/*Data for the table `t_orders` */

insert  into `t_orders`(`id`,`ordersNo`,`accountId`,`roomTypeId`,`roomId`,`reservationName`,`idCard`,`phone`,`status`,`reserveDate`,`arriveDate`,`leaveDate`,`reservePrice`,`remark`) values (12,'52cccbca-4a43-4019-9084-0e2abca84713',3,2,1,'李嘉诚','440811199808082690','19860780674',4,'2022-06-14 13:42:17','2022-06-16','2022-06-25','2700.00',''),(13,'ce2f0b17-02fd-4183-b477-cd9a9b30e177',3,2,1,'tom','312321321321321','211231312312',3,'2022-06-17 09:51:08','2022-06-17','2022-06-22','1500.00',''),(14,'7294d4fd-1e83-48f2-b3a0-ef8a96570a54',3,2,1,'tom','31231241','321321321321',4,'2022-06-21 10:29:37','2022-06-21','2022-06-24','900.00','');

/*Table structure for table `t_out_money` */

DROP TABLE IF EXISTS `t_out_money`;

CREATE TABLE `t_out_money` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '退款Id',
  `outPrice` decimal(10,2) DEFAULT NULL COMMENT '退款金额',
  `createDate` datetime DEFAULT NULL COMMENT '创建时间',
  `outId` bigint DEFAULT NULL COMMENT '退房编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

/*Data for the table `t_out_money` */

/*Table structure for table `t_room` */

DROP TABLE IF EXISTS `t_room`;

CREATE TABLE `t_room` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '编号',
  `photo` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '房间图片',
  `roomNum` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '房间编号',
  `roomTypeId` int DEFAULT NULL COMMENT '房型编号',
  `floorId` int DEFAULT NULL COMMENT '所属楼层',
  `status` int DEFAULT NULL COMMENT '状态',
  `roomDesc` text CHARACTER SET utf8 COLLATE utf8_bin COMMENT '房间描述',
  `roomRequirement` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '要求',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_room` */

insert  into `t_room`(`id`,`photo`,`roomNum`,`roomTypeId`,`floorId`,`status`,`roomDesc`,`roomRequirement`,`remark`) values (1,'2022-04-11/6af841bb-085d-480c-9989-60cead477ec3.jpg','1',2,1,3,NULL,NULL,NULL),(2,'2022-04-11/b9d649e9-651a-4fb8-9b5c-e387b12f4275.webp','101',2,1,1,'',NULL,'1'),(3,'2022-04-11/87556319-fdd6-4c15-8cbf-9440ebeef3a2.jpg','1011',2,3,1,'',NULL,'1'),(4,'2022-04-11/4927247c-6391-449a-8687-4fcec872e9b3.jpg','202',5,3,3,'特别豪华','没有摄像头','豪华哦'),(5,'2022-04-11/25ce301d-333e-4664-854b-1bdede607fd6.jpg','20',2,1,1,'<img src=\"/hotel/show/2022-04-09/92db3888-06ff-4c83-8988-501e8eb47747.png\" alt=\"undefined\"><img src=\"/hotel/show/2022-04-09/b8e1e9c2-d4ad-4bb5-af25-c5bc2b7d132d.png\" alt=\"undefined\"><img src=\"/hotel/show/2022-04-09/2043ea42-eac5-4c99-9e6e-5fbcac189342.jpg\" alt=\"undefined\"><img src=\"/hotel/show/2022-04-09/3d8df62b-5baa-4a37-8eed-fd5d5797bb19.jpg\" alt=\"undefined\">','211','1211');

/*Table structure for table `t_room_type` */

DROP TABLE IF EXISTS `t_room_type`;

CREATE TABLE `t_room_type` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '房型编号',
  `typeName` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '房型名称',
  `photo` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '房型图片',
  `price` decimal(8,2) DEFAULT NULL COMMENT '参考价格',
  `liveNum` int DEFAULT NULL COMMENT '可入住人数',
  `bedNum` int DEFAULT NULL COMMENT '床位数',
  `roomNum` int DEFAULT NULL COMMENT '房间数量',
  `reservedNum` int DEFAULT NULL COMMENT '已预定数量',
  `avilableNum` int DEFAULT NULL COMMENT '可住房间数',
  `livedNum` int DEFAULT NULL COMMENT '已入住数量',
  `status` int DEFAULT NULL COMMENT '房型状态',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `t_room_type` */

insert  into `t_room_type`(`id`,`typeName`,`photo`,`price`,`liveNum`,`bedNum`,`roomNum`,`reservedNum`,`avilableNum`,`livedNum`,`status`,`remark`) values (1,'单人间','2022-04-11/4977b4d5-458d-4fb4-952a-bee5fe4cbb9d.jpg','200.00',2,1,20,0,20,0,1,'无'),(2,'双人间','images/defaultimg.jpg','300.00',2,2,20,10,37,-17,1,'收破烂'),(3,'标准间','images/defaultimg.jpg','300.00',2,1,20,0,20,0,1,'2'),(4,'商务间','2022-04-06/0981bb2d-be36-4684-afa8-78f9668d57d1.webp','400.00',2,1,20,0,20,0,1,'22'),(5,'总统套房','2022-04-06/99900037-f3a7-488f-b77c-9f06d4be8c3d.jpg','5000.00',2,1,20,3,24,-4,1,'111');

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `loginName` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '登录账号',
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '登录密码',
  `realName` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '真实姓名',
  `idCard` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '身份证号码',
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '电话号码',
  `email` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '邮箱',
  `status` int DEFAULT NULL COMMENT '状态1-可用 0-异常',
  `createDate` datetime DEFAULT NULL COMMENT '注册时间',
  `salt` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '盐值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `t_user` */

insert  into `t_user`(`id`,`loginName`,`password`,`realName`,`idCard`,`phone`,`email`,`status`,`createDate`,`salt`) values (3,'tom','c3551b59ada633606ed209b3a4813d10',NULL,NULL,'19860780674',NULL,NULL,NULL,'15260531-e2a7-475e-99aa-55c17952aec3'),(4,'jojo','d07786408e70c571cb6dcca572d92972',NULL,NULL,'13659740231',NULL,NULL,NULL,'75f7f90f-cea3-4c8f-ab00-25de004f6ef3'),(5,'李嘉诚','1412801391cec89f711145bca2d879aa',NULL,NULL,'11012011918',NULL,NULL,NULL,'cde2b7db-0e3a-4ded-8730-34c54f85959f');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
