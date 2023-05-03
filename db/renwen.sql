/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.22-log : Database - renwen
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`renwen` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `renwen`;

/*Table structure for table `jtjg` */

DROP TABLE IF EXISTS `jtjg`;

CREATE TABLE `jtjg` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `jiaotongleixing` varchar(255) DEFAULT NULL COMMENT '交通类型',
  `bianlidu` varchar(255) DEFAULT NULL COMMENT '交通便利度监管',
  `lumianzhuangkuang` varchar(255) DEFAULT NULL COMMENT '路面状况监管',
  `xuexiao` varchar(255) DEFAULT NULL COMMENT '学校',
  `yiliao` varchar(255) DEFAULT NULL COMMENT '医疗站',
  `shuili` varchar(255) DEFAULT NULL COMMENT '水利站',
  `dianzhan` varchar(255) DEFAULT NULL COMMENT '电站',
  `jinrongruwu` varchar(255) DEFAULT NULL COMMENT '金融服务',
  `gongjiaozhan` varchar(255) DEFAULT NULL COMMENT '公交站',
  `jianshenqicai` varchar(255) DEFAULT NULL COMMENT '健身器材',
  `wenhuazhongxin` varchar(255) DEFAULT NULL COMMENT '文化中心',
  `qita` varchar(255) DEFAULT NULL COMMENT '其他',
  `create_time` varchar(255) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='交通及周围设施监管';

/*Data for the table `jtjg` */

insert  into `jtjg`(`id`,`jiaotongleixing`,`bianlidu`,`lumianzhuangkuang`,`xuexiao`,`yiliao`,`shuili`,`dianzhan`,`jinrongruwu`,`gongjiaozhan`,`jianshenqicai`,`wenhuazhongxin`,`qita`,`create_time`) values (1,'周围设施监管','123123','123123123','2','2','2','2','2','2','3','2','2','2021-04-11 03:44:09');

/*Table structure for table `kqzljg` */

DROP TABLE IF EXISTS `kqzljg`;

CREATE TABLE `kqzljg` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `kongqileixing` varchar(255) DEFAULT NULL COMMENT '空气类型',
  `yangqi` varchar(255) DEFAULT NULL COMMENT '氧气',
  `eryanghuatan` varchar(255) DEFAULT NULL COMMENT '二氧化碳',
  `danqi` varchar(255) DEFAULT NULL COMMENT '氮气',
  `xiyouqiti` varchar(255) DEFAULT NULL COMMENT '稀有气体',
  `chouyang` varchar(255) DEFAULT NULL COMMENT '臭氧',
  `yiyanghuadan` varchar(255) DEFAULT NULL COMMENT '一氧化氮',
  `shuizhengqi` varchar(255) DEFAULT NULL COMMENT '水蒸气',
  `pm25` varchar(255) DEFAULT NULL COMMENT 'PM2.5值',
  `pm25_val` varchar(255) DEFAULT NULL COMMENT 'PM2.5等级',
  `pm10_year` varchar(255) DEFAULT NULL COMMENT 'PM10年平均',
  `pm10_hour` varchar(255) DEFAULT NULL COMMENT 'PM10 24小时',
  `xiyanliang` varchar(255) DEFAULT NULL COMMENT '吸烟量',
  `mei` varchar(255) DEFAULT NULL COMMENT '煤',
  `tianranqi` varchar(255) DEFAULT NULL COMMENT '天然气',
  `muchai` varchar(255) DEFAULT NULL COMMENT '木柴',
  `dian` varchar(255) DEFAULT NULL COMMENT '电',
  `qita` varchar(255) DEFAULT NULL COMMENT '其他',
  `create_time` varchar(255) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='空气质量监管';

/*Data for the table `kqzljg` */

insert  into `kqzljg`(`id`,`kongqileixing`,`yangqi`,`eryanghuatan`,`danqi`,`xiyouqiti`,`chouyang`,`yiyanghuadan`,`shuizhengqi`,`pm25`,`pm25_val`,`pm10_year`,`pm10_hour`,`xiyanliang`,`mei`,`tianranqi`,`muchai`,`dian`,`qita`,`create_time`) values (1,'室内空气质量监管','3','3','3','3','3','3','3','3','3','3','3','3','3','3','3','3','3','2021-04-11 02:34:25'),(2,'室内空气质量监管','3','3','3','3','3','3','3','65','3','3','3','3','3','3','3','3','3','2021-04-18 03:27:41');

/*Table structure for table `rwhjjd` */

DROP TABLE IF EXISTS `rwhjjd`;

CREATE TABLE `rwhjjd` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `rwleixing` varchar(255) DEFAULT NULL COMMENT '人文环境监管类型',
  `zhishilaiyuan` varchar(255) DEFAULT NULL COMMENT '知识来源',
  `ertong` varchar(255) DEFAULT NULL COMMENT '儿童',
  `qingshaonian` varchar(255) DEFAULT NULL COMMENT '青少年',
  `zhongnian` varchar(255) DEFAULT NULL COMMENT '中年',
  `laonian` varchar(255) DEFAULT NULL COMMENT '老年',
  `yijianfenlei` varchar(255) DEFAULT NULL COMMENT '意见分类',
  `yijianbiaoti` varchar(255) DEFAULT NULL COMMENT '意见标题',
  `yijianneirong` varchar(255) DEFAULT NULL COMMENT '意见内容',
  `chulizhuangtai` varchar(255) DEFAULT NULL COMMENT '处理意见',
  `xuanchuanbiaoti` varchar(255) DEFAULT NULL COMMENT '宣传标题',
  `xuanchuanshijian` varchar(255) DEFAULT NULL COMMENT '宣传时间',
  `xuanchuanneirong` varchar(255) DEFAULT NULL COMMENT '宣传内容',
  `fangshi` varchar(255) DEFAULT NULL COMMENT '方式',
  `create_time` varchar(255) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='人文环境监管';

/*Data for the table `rwhjjd` */

insert  into `rwhjjd`(`id`,`rwleixing`,`zhishilaiyuan`,`ertong`,`qingshaonian`,`zhongnian`,`laonian`,`yijianfenlei`,`yijianbiaoti`,`yijianneirong`,`chulizhuangtai`,`xuanchuanbiaoti`,`xuanchuanshijian`,`xuanchuanneirong`,`fangshi`,`create_time`) values (1,'环境保护宣传','网络','22','2','222','444','空气类','44','4444','444','44','44','44','短视频','2021-04-11 03:26:12');

/*Table structure for table `sys_department` */

DROP TABLE IF EXISTS `sys_department`;

CREATE TABLE `sys_department` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `department_name` varchar(32) DEFAULT NULL COMMENT '部门名称',
  `create_time` varchar(32) DEFAULT NULL COMMENT '创建时间',
  `update_time` varchar(32) DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='部门名称';

/*Data for the table `sys_department` */

insert  into `sys_department`(`id`,`department_name`,`create_time`,`update_time`) values (1,'开发部','2020-11-29 23:03:23',NULL),(2,'销售部','2020-11-29 23:03:39',NULL),(3,'IT管理部','2020-12-21 20:02:04','2020-12-21 20:02:10');

/*Table structure for table `sys_dict_data` */

DROP TABLE IF EXISTS `sys_dict_data`;

CREATE TABLE `sys_dict_data` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `pid` int(11) DEFAULT '0' COMMENT ' 父ID ',
  `data_type` varchar(50) DEFAULT NULL COMMENT ' 数据类别,首字母大写 ',
  `data_name` varchar(100) DEFAULT NULL COMMENT '字典名称key',
  `data_value` varchar(200) DEFAULT NULL COMMENT ' 数据名称/值 value',
  `sort_no` int(11) unsigned DEFAULT '1' COMMENT ' 顺序 ',
  `status` tinyint(2) DEFAULT '0' COMMENT '0正常,1删除',
  `data_desc` varchar(400) DEFAULT NULL COMMENT '数据描述',
  `create_time` varchar(200) DEFAULT NULL COMMENT '创建时间 ',
  PRIMARY KEY (`id`),
  UNIQUE KEY `sys_dict_data` (`id`),
  KEY `idx_dc_dt` (`data_type`,`data_name`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 COMMENT='系统字典表';

/*Data for the table `sys_dict_data` */

insert  into `sys_dict_data`(`id`,`pid`,`data_type`,`data_name`,`data_value`,`sort_no`,`status`,`data_desc`,`create_time`) values (1,0,'goods_type',NULL,NULL,1,0,'商品类型','2021-01-12 17:04:26'),(3,1,'goods_type','板子','1',1,0,'-','2021-01-15 17:08:25'),(4,1,'goods_type','主龙','2',2,0,'-','2021-01-15 18:01:13'),(5,0,'specification_unit',NULL,NULL,1,0,'商品规格单位','2021-02-18 23:53:18'),(6,5,'specification_unit','张','zhang',1,0,NULL,'2021-02-18 23:53:54'),(7,5,'specification_unit','箱','xiang',2,0,NULL,'2021-02-18 23:54:15'),(8,5,'specification_unit','根','gen',3,0,NULL,'2021-02-18 23:54:29'),(9,5,'specification_unit','只','zhi',4,0,NULL,'2021-02-18 23:54:43'),(10,1,'goods_type','负龙','3',3,0,NULL,'2021-02-18 23:57:18'),(11,1,'goods_type','吊筋','4',4,0,NULL,'2021-02-18 23:57:30'),(12,1,'goods_type','快吊','5',5,0,NULL,'2021-02-18 23:57:43'),(13,0,'customer_level',NULL,NULL,1,0,'意向客户等级','2021-03-01 23:19:59'),(14,13,'customer_level','一级','1',1,0,NULL,'2021-03-01 23:20:38'),(15,13,'customer_level','二级','2',2,0,NULL,'2021-03-01 23:21:01'),(16,13,'customer_level','三级','3',3,0,NULL,'2021-03-01 23:22:05'),(17,0,'supplier_level',NULL,NULL,1,0,'供应商等级','2021-03-01 23:51:47'),(18,17,'supplier_level','一级','1',1,0,NULL,'2021-03-01 23:52:03'),(19,17,'supplier_level','二级','2',2,0,NULL,'2021-03-01 23:52:13'),(20,17,'supplier_level','三级','3',3,0,NULL,'2021-03-01 23:52:22'),(21,0,'settlement_status',NULL,NULL,1,0,'入库管理---是否结算','2021-03-28 03:18:35'),(22,21,'settlement_status','是','y',1,0,NULL,'2021-03-28 03:20:12'),(23,21,'settlement_status','否','n',2,0,NULL,'2021-03-28 03:20:34'),(24,0,'top_area',NULL,NULL,1,0,'销售管理--吊顶区域','2021-03-28 23:38:38'),(25,24,'top_area','厨房','1',1,0,NULL,'2021-03-28 23:39:06'),(26,24,'top_area','卫生间','2',2,0,NULL,'2021-03-28 23:39:15'),(27,24,'top_area','阳台','3',3,0,NULL,'2021-03-28 23:39:25'),(29,1,'goods_type','电器类','6',6,0,NULL,'2021-04-03 11:40:21'),(30,1,'goods_type','晾衣架','7',7,0,NULL,'2021-04-03 11:40:54');

/*Table structure for table `sys_menu` */

DROP TABLE IF EXISTS `sys_menu`;

CREATE TABLE `sys_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `menu_name` varchar(15) DEFAULT NULL COMMENT '菜单名称',
  `url` varchar(2255) DEFAULT NULL COMMENT '路径',
  `icon` varchar(150) DEFAULT NULL COMMENT '图标',
  `pid` varchar(15) DEFAULT NULL COMMENT '父id',
  `type` varchar(15) DEFAULT NULL COMMENT '菜单类型（菜单，按钮）',
  `order_num` varchar(15) DEFAULT NULL COMMENT '排序',
  `create_time` varchar(32) DEFAULT NULL COMMENT '创建时间',
  `update_time` varchar(32) DEFAULT NULL COMMENT '修改时间',
  `remark` varchar(50) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COMMENT='菜单表';

/*Data for the table `sys_menu` */

insert  into `sys_menu`(`id`,`menu_name`,`url`,`icon`,`pid`,`type`,`order_num`,`create_time`,`update_time`,`remark`) values (1,'菜单树',NULL,NULL,'0','菜单',NULL,NULL,NULL,NULL),(2,'人员管理','/SysUser/SysUserHtml','/','1','菜单','1',NULL,'2020-12-14 23:38:33',NULL),(6,'基本管理','/','/','1','菜单','2',NULL,NULL,NULL),(7,'菜单管理','/SysMenu/SysMenuHtml','fa fa-list-alt','6','菜单','1',NULL,'2020-12-14 23:37:47',NULL),(9,'角色管理','/SysRole/SysRoleHtml','fa fa-list-alt','6','菜单','2','2020-12-14 23:23:28',NULL,NULL),(10,'部门管理','/SysDepartment/SysDepartmentHtml','fa fa-list-alt','6','菜单','3','2020-12-21 20:01:18',NULL,NULL),(11,'数据字典','/SysDictData/SysDictDataHtml','fa fa-list-alt','6','菜单','4','2021-01-09 22:16:58',NULL,NULL),(19,'土壤质量监管','/Trzljg/TrzljgHtml','fa fa-list-alt','1','菜单','3','2021-04-04 17:25:46',NULL,NULL),(20,'水质监管','/Szjg/SzjgHtml','fa fa-list-alt','1','菜单','4','2021-04-04 17:27:55',NULL,NULL),(21,'空气质量监管','/Kqzljg/KqzljgHtml','fa fa-list-alt','1','菜单','5','2021-04-08 15:59:31',NULL,NULL),(22,'卫生监管','/Wsjg/WsjgHtml','fa fa-list-alt','1','菜单','6','2021-04-08 16:00:10',NULL,NULL),(23,'人文环境监管','/Rwhjjd/RwhjjdHtml','fa fa-list-alt','1','菜单','7','2021-04-09 08:48:05',NULL,NULL),(24,'交通及周围设施监管','/Jtjg/JtjgHtml','fa fa-list-alt','1','菜单','8','2021-04-11 03:29:33',NULL,NULL),(25,'统计分析','/TLogin/statis','fa fa-list-alt','1','菜单',NULL,'2021-04-18 00:40:18',NULL,NULL);

/*Table structure for table `sys_role` */

DROP TABLE IF EXISTS `sys_role`;

CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_name` varchar(20) DEFAULT NULL COMMENT '角色名称',
  `role_code` varchar(50) DEFAULT NULL COMMENT '角色编码',
  `create_time` varchar(32) DEFAULT NULL COMMENT '创建时间',
  `update_time` varchar(32) DEFAULT NULL COMMENT '修改时间',
  `remark` varchar(50) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='角色表';

/*Data for the table `sys_role` */

insert  into `sys_role`(`id`,`role_name`,`role_code`,`create_time`,`update_time`,`remark`) values (1,'管理员',NULL,'2020-11-29 22:40:08',NULL,NULL),(2,'普通用户',NULL,'2020-11-29 22:40:16',NULL,NULL),(3,'部门领导',NULL,'2020-11-29 22:40:26',NULL,NULL);

/*Table structure for table `sys_role_menu` */

DROP TABLE IF EXISTS `sys_role_menu`;

CREATE TABLE `sys_role_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_id` int(11) NOT NULL COMMENT '角色id',
  `menu_id` int(11) NOT NULL COMMENT '用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=133 DEFAULT CHARSET=utf8 COMMENT='角色菜单表';

/*Data for the table `sys_role_menu` */

insert  into `sys_role_menu`(`id`,`role_id`,`menu_id`) values (20,3,2),(21,3,6),(22,3,7),(23,3,9),(24,3,10),(116,1,2),(117,1,6),(118,1,7),(119,1,9),(120,1,10),(121,1,11),(122,1,19),(123,1,20),(124,1,21),(125,1,22),(126,1,23),(127,1,24),(128,1,25),(129,2,2),(130,2,6),(131,2,7),(132,2,25);

/*Table structure for table `sys_serial_number` */

DROP TABLE IF EXISTS `sys_serial_number`;

CREATE TABLE `sys_serial_number` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `serial_type` varchar(128) DEFAULT NULL COMMENT '编号类型(1:入库  2：销售)',
  `code` varchar(128) DEFAULT NULL COMMENT '编号开头',
  `median` varchar(128) DEFAULT NULL COMMENT '编号中间',
  `num` varchar(128) DEFAULT NULL COMMENT '编号自增长',
  `serial_no` varchar(128) DEFAULT NULL COMMENT '编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='项目使用编号综合管理';

/*Data for the table `sys_serial_number` */

insert  into `sys_serial_number`(`id`,`serial_type`,`code`,`median`,`num`,`serial_no`) values (1,'sp','SP','20210219','001',NULL),(2,'sp','SP','20210219','002','SP_20210219_002'),(3,'sp','SP','20210219','003','SP_20210219_003'),(4,'rk','RK','20210328','001','RK_20210328_001'),(5,'mx','MX','20210328','001','MX_20210328_001');

/*Table structure for table `sys_user` */

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_no` varchar(40) DEFAULT NULL COMMENT '员工编号',
  `password` varchar(40) DEFAULT NULL COMMENT '用户密码',
  `name` varchar(20) DEFAULT NULL COMMENT '姓名',
  `department_id` int(11) DEFAULT NULL COMMENT '部门',
  `leave_office` int(11) DEFAULT NULL COMMENT '离职状态（1在职，2离职）',
  `create_time` varchar(32) DEFAULT NULL COMMENT '创建时间',
  `update_time` varchar(32) DEFAULT NULL COMMENT '修改时间',
  `remark` varchar(50) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='用户表';

/*Data for the table `sys_user` */

insert  into `sys_user`(`id`,`user_no`,`password`,`name`,`department_id`,`leave_office`,`create_time`,`update_time`,`remark`) values (1,'1','123456','张三',1,1,NULL,'2020-12-11 00:16:56',NULL),(2,'2','123456','李四',1,2,'2020-11-29 23:36:45',NULL,'1'),(3,'0','123456','admin',3,NULL,'2020-12-21 20:02:45',NULL,'我是管理员');

/*Table structure for table `sys_user_role` */

DROP TABLE IF EXISTS `sys_user_role`;

CREATE TABLE `sys_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_id` int(11) NOT NULL COMMENT '角色id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='用户角色表';

/*Data for the table `sys_user_role` */

insert  into `sys_user_role`(`id`,`role_id`,`user_id`) values (1,3,1),(2,2,2),(3,1,3);

/*Table structure for table `szjg` */

DROP TABLE IF EXISTS `szjg`;

CREATE TABLE `szjg` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `shuizhileixing` varchar(255) DEFAULT NULL COMMENT '水质类型',
  `shuizhidengji` varchar(255) DEFAULT NULL COMMENT '水质等级',
  `gutihanliang` varchar(255) DEFAULT NULL COMMENT '固体含量',
  `hunzhudu` varchar(255) DEFAULT NULL COMMENT '浑浊度',
  `toumingdu` varchar(255) DEFAULT NULL COMMENT '透明度',
  `wendu` varchar(255) DEFAULT NULL COMMENT '温度',
  `diandaolv` varchar(255) DEFAULT NULL COMMENT '电导率',
  `ph` varchar(255) DEFAULT NULL COMMENT 'pH值',
  `yingdu` varchar(255) DEFAULT NULL COMMENT '硬度',
  `youjiwu` varchar(255) DEFAULT NULL COMMENT '有机物',
  `weishifenbu` varchar(255) DEFAULT NULL COMMENT '包围式分布',
  `dianfenbu` varchar(255) DEFAULT NULL COMMENT '点分布',
  `pingjunfenbu` varchar(255) DEFAULT NULL COMMENT '平均分布',
  `jizhongfenbu` varchar(255) DEFAULT NULL COMMENT '集中分布和无',
  `renjunfenbuliang` varchar(255) DEFAULT NULL COMMENT '人均分布量',
  `ziliashui` varchar(255) DEFAULT NULL COMMENT '自来水',
  `jinshui` varchar(255) DEFAULT NULL COMMENT '井水',
  `yushui` varchar(255) DEFAULT NULL COMMENT '雨水',
  `huposhui` varchar(255) DEFAULT NULL COMMENT '湖泊水',
  `qita` varchar(255) DEFAULT NULL COMMENT '其他',
  `pingjunriyongshuiliang` varchar(255) DEFAULT NULL COMMENT '平均日用水量用水量',
  `renjunshuiliang` varchar(255) DEFAULT NULL COMMENT '人均水存储量',
  `zongcunchuliang` varchar(255) DEFAULT NULL COMMENT '总水存储量',
  `create_time` varchar(255) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='水质监管';

/*Data for the table `szjg` */

insert  into `szjg`(`id`,`shuizhileixing`,`shuizhidengji`,`gutihanliang`,`hunzhudu`,`toumingdu`,`wendu`,`diandaolv`,`ph`,`yingdu`,`youjiwu`,`weishifenbu`,`dianfenbu`,`pingjunfenbu`,`jizhongfenbu`,`renjunfenbuliang`,`ziliashui`,`jinshui`,`yushui`,`huposhui`,`qita`,`pingjunriyongshuiliang`,`renjunshuiliang`,`zongcunchuliang`,`create_time`) values (1,'农业用水水质监管','二级','123','1233123','12','12312','123123','123123','12312','3123','123','12312312','12','123','1','18','23','14','89','123','123','123','123','2021-04-04 18:32:43');

/*Table structure for table `trzljg` */

DROP TABLE IF EXISTS `trzljg`;

CREATE TABLE `trzljg` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tudileixing` varchar(255) DEFAULT NULL COMMENT '土壤类型',
  `tudidengji` varchar(255) DEFAULT NULL COMMENT '质量等级',
  `ph` varchar(255) DEFAULT NULL COMMENT 'PH',
  `shuifen` varchar(255) DEFAULT NULL COMMENT '水分',
  `yanglizi` varchar(255) DEFAULT NULL COMMENT '阳离子交换量',
  `suandu` varchar(255) DEFAULT NULL COMMENT '酸度',
  `rongzhong` varchar(255) DEFAULT NULL COMMENT '容重',
  `midu` varchar(255) DEFAULT NULL COMMENT '密度',
  `lidu` varchar(255) DEFAULT NULL COMMENT '粒度',
  `huifafen` varchar(255) DEFAULT NULL COMMENT '挥发酚',
  `fuhuawu` varchar(255) DEFAULT NULL COMMENT '氟化物',
  `qinghuawu` varchar(255) DEFAULT NULL COMMENT '氰化物',
  `andan` varchar(255) DEFAULT NULL COMMENT '氨氮',
  `quandan` varchar(255) DEFAULT NULL COMMENT '全氮',
  `quanlin` varchar(255) DEFAULT NULL COMMENT '全磷',
  `quanjia` varchar(255) DEFAULT NULL COMMENT '全钾',
  `xiaosuanyandan` varchar(255) DEFAULT NULL COMMENT '硝酸盐氮',
  `quanyanliang` varchar(255) DEFAULT NULL COMMENT '全盐量',
  `liusuangen` varchar(255) DEFAULT NULL COMMENT '硫酸根',
  `youxiaolin` varchar(255) DEFAULT NULL COMMENT '有效磷',
  `youxiaogui` varchar(255) DEFAULT NULL COMMENT '有效硅',
  `youxiaotie` varchar(255) DEFAULT NULL COMMENT '有效铁',
  `youxiaopeng` varchar(255) DEFAULT NULL COMMENT '有效硼',
  `suxiaojia` varchar(255) DEFAULT NULL COMMENT '速效钾',
  `youjizhi` varchar(255) DEFAULT NULL COMMENT '有机质',
  `qian` varchar(255) DEFAULT NULL COMMENT '铅',
  `ge` varchar(255) DEFAULT NULL COMMENT '镉',
  `gong` varchar(255) DEFAULT NULL COMMENT '汞',
  `luo` varchar(255) DEFAULT NULL COMMENT '铬',
  `ti` varchar(255) DEFAULT NULL COMMENT '锑',
  `pi` varchar(255) DEFAULT NULL COMMENT '铍',
  `shen` varchar(255) DEFAULT NULL COMMENT '硒',
  `tong` varchar(255) DEFAULT NULL COMMENT '铜',
  `ni` varchar(255) DEFAULT NULL COMMENT '镍',
  `yin` varchar(255) DEFAULT NULL COMMENT '银',
  `xin` varchar(255) DEFAULT NULL COMMENT '锌',
  `meng` varchar(255) DEFAULT NULL COMMENT '锰',
  `lv` varchar(255) DEFAULT NULL COMMENT '铝',
  `li` varchar(255) DEFAULT NULL COMMENT '锂',
  `ba` varchar(255) DEFAULT NULL COMMENT '钡',
  `tai` varchar(255) DEFAULT NULL COMMENT '钛',
  `xi` varchar(255) DEFAULT NULL COMMENT '锡',
  `peng` varchar(255) DEFAULT NULL COMMENT '硼',
  `si` varchar(255) DEFAULT NULL COMMENT '锶',
  `gu` varchar(255) DEFAULT NULL COMMENT '钴',
  `mu` varchar(255) DEFAULT NULL COMMENT '钼',
  `tu` varchar(255) DEFAULT NULL COMMENT '钍',
  `you` varchar(255) DEFAULT NULL COMMENT '铀',
  `gong2` varchar(255) DEFAULT NULL COMMENT '钒',
  `bi` varchar(255) DEFAULT NULL COMMENT '铋',
  `jia` varchar(255) DEFAULT NULL COMMENT '镓',
  `zhe` varchar(255) DEFAULT NULL COMMENT '锗',
  `di` varchar(255) DEFAULT NULL COMMENT '碲',
  `tuo` varchar(255) DEFAULT NULL COMMENT '铊',
  `ludaiting` varchar(255) DEFAULT NULL COMMENT '挥发性卤代烃',
  `huifayoujiwu` varchar(255) DEFAULT NULL COMMENT '挥发性有机物',
  `huifashiyou` varchar(255) DEFAULT NULL COMMENT '挥发性总石油类烃',
  `duolulianben` varchar(255) DEFAULT NULL COMMENT '多氯联苯',
  `duohuanfangting` varchar(255) DEFAULT NULL COMMENT '多环芳烃',
  `tiquluhuawu` varchar(255) DEFAULT NULL COMMENT '可提取有机卤化物',
  `banhuifayoujiwu` varchar(255) DEFAULT NULL COMMENT '半挥发性有机物',
  `youjilunongyao` varchar(255) DEFAULT NULL COMMENT '有机氯农药',
  `youjilinnongyao` varchar(255) DEFAULT NULL COMMENT '有机磷农药',
  `create_time` varchar(255) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='土壤质量监管';

/*Data for the table `trzljg` */

insert  into `trzljg`(`id`,`tudileixing`,`tudidengji`,`ph`,`shuifen`,`yanglizi`,`suandu`,`rongzhong`,`midu`,`lidu`,`huifafen`,`fuhuawu`,`qinghuawu`,`andan`,`quandan`,`quanlin`,`quanjia`,`xiaosuanyandan`,`quanyanliang`,`liusuangen`,`youxiaolin`,`youxiaogui`,`youxiaotie`,`youxiaopeng`,`suxiaojia`,`youjizhi`,`qian`,`ge`,`gong`,`luo`,`ti`,`pi`,`shen`,`tong`,`ni`,`yin`,`xin`,`meng`,`lv`,`li`,`ba`,`tai`,`xi`,`peng`,`si`,`gu`,`mu`,`tu`,`you`,`gong2`,`bi`,`jia`,`zhe`,`di`,`tuo`,`ludaiting`,`huifayoujiwu`,`huifashiyou`,`duolulianben`,`duohuanfangting`,`tiquluhuawu`,`banhuifayoujiwu`,`youjilunongyao`,`youjilinnongyao`,`create_time`) values (1,'耕地土壤质量监管','二级','22','22','22',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'22','22',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(2,'绿化地土壤质量监管','二级','22','22','44',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'55',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'55','66',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `wsjg` */

DROP TABLE IF EXISTS `wsjg`;

CREATE TABLE `wsjg` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `weishengleixing` varchar(255) DEFAULT NULL COMMENT '监管类型',
  `shenghuolaji` varchar(255) DEFAULT NULL COMMENT '生活垃圾',
  `gongyelaji` varchar(255) DEFAULT NULL COMMENT '工业垃圾',
  `jianzhulaji` varchar(255) DEFAULT NULL COMMENT '建筑垃圾',
  `qitalaji` varchar(255) DEFAULT NULL COMMENT '其他垃圾',
  `lajichuli` varchar(255) DEFAULT NULL COMMENT '垃圾处理',
  `shenghuowushui` varchar(255) DEFAULT NULL COMMENT '生活污水',
  `gongyewushui` varchar(255) DEFAULT NULL COMMENT '工业污水',
  `qitawushui` varchar(255) DEFAULT NULL COMMENT '其他污水',
  `wushuichuli` varchar(255) DEFAULT NULL COMMENT '污水处理',
  `create_time` varchar(255) DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='空气质量监管';

/*Data for the table `wsjg` */

insert  into `wsjg`(`id`,`weishengleixing`,`shenghuolaji`,`gongyelaji`,`jianzhulaji`,`qitalaji`,`lajichuli`,`shenghuowushui`,`gongyewushui`,`qitawushui`,`wushuichuli`,`create_time`) values (1,'室内空气质量监管','5','5','5','5','分类回收','5','5','5','污水净化','2021-04-11 02:59:23');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
