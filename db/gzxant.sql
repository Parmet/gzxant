/*
SQLyog Professional v12.08 (64 bit)
MySQL - 5.6.25 : Database - gzxant
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`gzxant` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;
use gzxant;

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for shop_brand
-- ----------------------------
DROP TABLE IF EXISTS `shop_brand`;
CREATE TABLE `shop_brand` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_date` datetime DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `found_date` datetime DEFAULT NULL,
  `logo` varchar(255) DEFAULT NULL,
  `chinese_name` varchar(255) DEFAULT NULL,
  `english_name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `sequence` int(11) DEFAULT NULL,
  `mods` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for shop_catalog
-- ----------------------------
DROP TABLE IF EXISTS `shop_catalog`;
CREATE TABLE `shop_catalog` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_date` datetime DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `level` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `sequence` int(11) DEFAULT NULL,
  `children_catalogs` int(11) DEFAULT NULL,
  `products` int(11) DEFAULT NULL,
  `parent_catalog_id` bigint(20) DEFAULT NULL,
  `is_parent` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for shop_catalog_property
-- ----------------------------
DROP TABLE IF EXISTS `shop_catalog_property`;
CREATE TABLE `shop_catalog_property` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `catalog_id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `sequence` int(11) DEFAULT NULL,
  `type` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `catalog_id` (`catalog_id`),
  CONSTRAINT `shop_catalog_property_ibfk_1` FOREIGN KEY (`catalog_id`) REFERENCES `shop_catalog` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for shop_catalog_property_value
-- ----------------------------
DROP TABLE IF EXISTS `shop_catalog_property_value`;
CREATE TABLE `shop_catalog_property_value` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `catalog_property_id` bigint(20) NOT NULL,
  `value` varchar(255) DEFAULT NULL,
  `sequence` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `catalog_property_id` (`catalog_property_id`),
  CONSTRAINT `shop_catalog_property_value_ibfk_1` FOREIGN KEY (`catalog_property_id`) REFERENCES `shop_catalog_property` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for shop_order_action
-- ----------------------------
DROP TABLE IF EXISTS `shop_order_action`;
CREATE TABLE `shop_order_action` (
  `id` bigint(8) unsigned NOT NULL AUTO_INCREMENT,
  `order_id` bigint(8) unsigned NOT NULL DEFAULT '0',
  `action_user` varchar(30) NOT NULL DEFAULT '',
  `order_status` tinyint(2) unsigned NOT NULL DEFAULT '0',
  `shipping_status` tinyint(2) unsigned NOT NULL DEFAULT '0',
  `pay_status` tinyint(2) unsigned NOT NULL DEFAULT '0',
  `action_place` tinyint(2) unsigned NOT NULL DEFAULT '0',
  `action_note` varchar(255) NOT NULL DEFAULT '',
  `action_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `order_id` (`order_id`),
  CONSTRAINT `shop_order_action_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `shop_order_info` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for shop_order_info
-- ----------------------------
DROP TABLE IF EXISTS `shop_order_info`;
CREATE TABLE `shop_order_info` (
  `id` bigint(8) unsigned NOT NULL AUTO_INCREMENT,
  `order_sn` varchar(20) NOT NULL DEFAULT '',
  `user_id` bigint(8) unsigned NOT NULL DEFAULT '0',
  `order_status` tinyint(2) unsigned NOT NULL DEFAULT '0',
  `shipping_status` tinyint(2) unsigned NOT NULL DEFAULT '0',
  `pay_status` tinyint(2) unsigned NOT NULL DEFAULT '0',
  `consignee` varchar(60) DEFAULT '',
  `country` varchar(60) DEFAULT '',
  `province` varchar(60) DEFAULT '',
  `city` varchar(60) DEFAULT '',
  `district` varchar(60) DEFAULT '',
  `address` varchar(255) DEFAULT '',
  `zipcode` varchar(60) DEFAULT '',
  `mobile` varchar(60) DEFAULT '',
  `order_amount` decimal(10,2) DEFAULT '0.00',
  PRIMARY KEY (`id`),
  UNIQUE KEY `order_sn` (`order_sn`),
  KEY `user_id` (`user_id`),
  KEY `order_status` (`order_status`),
  KEY `shipping_status` (`shipping_status`),
  KEY `pay_status` (`pay_status`),
  CONSTRAINT `shop_order_info_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for shop_order_product
-- ----------------------------
DROP TABLE IF EXISTS `shop_order_product`;
CREATE TABLE `shop_order_product` (
  `id` bigint(8) unsigned NOT NULL AUTO_INCREMENT,
  `order_id` bigint(8) unsigned NOT NULL DEFAULT '0',
  `sku_id` bigint(20) unsigned NOT NULL DEFAULT '0',
  `product_name` varchar(120) NOT NULL DEFAULT '',
  `product_number` smallint(5) unsigned NOT NULL DEFAULT '1',
  `product_price` decimal(10,2) NOT NULL DEFAULT '0.00',
  `sku_attr` varchar(1000) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `order_id` (`order_id`),
  KEY `goods_id` (`sku_id`),
  CONSTRAINT `shop_order_product_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `shop_order_info` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for shop_product
-- ----------------------------
DROP TABLE IF EXISTS `shop_product`;
CREATE TABLE `shop_product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_date` datetime DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `catalog_id` bigint(20) DEFAULT NULL,
  `brand_id` bigint(20) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `keyword` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `market_price` decimal(18,2) DEFAULT NULL,
  `base_price` decimal(18,2) DEFAULT NULL,
  `mods` bigint(20) DEFAULT NULL,
  `impressions` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `catalog_id` (`catalog_id`),
  KEY `brand_id` (`brand_id`),
  CONSTRAINT `shop_product_ibfk_1` FOREIGN KEY (`catalog_id`) REFERENCES `shop_catalog` (`id`),
  CONSTRAINT `shop_product_ibfk_2` FOREIGN KEY (`brand_id`) REFERENCES `shop_brand` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for shop_product_catalog_property_value
-- ----------------------------
DROP TABLE IF EXISTS `shop_product_catalog_property_value`;
CREATE TABLE `shop_product_catalog_property_value` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_id` bigint(20) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `value` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `product_id` (`product_id`),
  CONSTRAINT `shop_product_catalog_property_value_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `shop_product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for shop_product_desc
-- ----------------------------
DROP TABLE IF EXISTS `shop_product_desc`;
CREATE TABLE `shop_product_desc` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `details` longtext NOT NULL,
  `product_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `product_id` (`product_id`),
  CONSTRAINT `shop_product_desc_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `shop_product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for shop_product_image
-- ----------------------------
DROP TABLE IF EXISTS `shop_product_image`;
CREATE TABLE `shop_product_image` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_id` bigint(20) DEFAULT NULL,
  `image_path` varchar(255) DEFAULT NULL,
  `sequence` int(11) DEFAULT NULL,
  `mods` bigint(20) DEFAULT NULL,
  `cover` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `product_id` (`product_id`),
  CONSTRAINT `shop_product_image_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `shop_product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for shop_product_sku
-- ----------------------------
DROP TABLE IF EXISTS `shop_product_sku`;
CREATE TABLE `shop_product_sku` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_id` bigint(20) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `price` decimal(18,2) DEFAULT NULL,
  `mods` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `product_id` (`product_id`),
  CONSTRAINT `shop_product_sku_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `shop_product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for shop_product_sku_property
-- ----------------------------
DROP TABLE IF EXISTS `shop_product_sku_property`;
CREATE TABLE `shop_product_sku_property` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_sku_id` bigint(20) DEFAULT NULL,
  `sku_property_id` bigint(20) DEFAULT NULL,
  `value` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `product_sku_id` (`product_sku_id`),
  KEY `sku_property_id` (`sku_property_id`),
  CONSTRAINT `shop_product_sku_property_ibfk_1` FOREIGN KEY (`product_sku_id`) REFERENCES `shop_product_sku` (`id`),
  CONSTRAINT `shop_product_sku_property_ibfk_2` FOREIGN KEY (`sku_property_id`) REFERENCES `shop_sku_property` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=124 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for shop_sku_property
-- ----------------------------
DROP TABLE IF EXISTS `shop_sku_property`;
CREATE TABLE `shop_sku_property` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `catalog_id` bigint(20) NOT NULL,
  `type` tinyint(4) NOT NULL,
  `sequence` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `catalog_id` (`catalog_id`),
  CONSTRAINT `shop_sku_property_ibfk_1` FOREIGN KEY (`catalog_id`) REFERENCES `shop_catalog` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for shop_sku_property_value
-- ----------------------------
DROP TABLE IF EXISTS `shop_sku_property_value`;
CREATE TABLE `shop_sku_property_value` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sku_property_id` bigint(20) NOT NULL,
  `value` varchar(255) NOT NULL,
  `sequence` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `sku_property_id` (`sku_property_id`),
  CONSTRAINT `shop_sku_property_value_ibfk_1` FOREIGN KEY (`sku_property_id`) REFERENCES `shop_sku_property` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
