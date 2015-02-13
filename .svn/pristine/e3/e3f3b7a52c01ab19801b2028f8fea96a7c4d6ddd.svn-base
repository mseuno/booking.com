CREATE DATABASE  IF NOT EXISTS `booking` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `booking`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: localhost    Database: booking
-- ------------------------------------------------------
-- Server version	5.6.16-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `first_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `e-mail` varchar(50) NOT NULL,
  `password` char(32) CHARACTER SET latin1 NOT NULL,
  `registration_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'Oleg','Bereza','bereza@gala.net','root','2014-12-12');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `black_list`
--

DROP TABLE IF EXISTS `black_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `black_list` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(10) unsigned NOT NULL,
  `hotel_id` int(10) unsigned NOT NULL,
  `date` date NOT NULL,
  `reason` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `black_list_user` (`user_id`),
  KEY `black_list_hotel` (`hotel_id`),
  CONSTRAINT `black_list_hotel` FOREIGN KEY (`hotel_id`) REFERENCES `hotel` (`id`),
  CONSTRAINT `black_list_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `black_list`
--

LOCK TABLES `black_list` WRITE;
/*!40000 ALTER TABLE `black_list` DISABLE KEYS */;
/*!40000 ALTER TABLE `black_list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `booking`
--

DROP TABLE IF EXISTS `booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `booking` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(10) unsigned NOT NULL,
  `hotel_id` int(10) unsigned NOT NULL,
  `begin_date` date NOT NULL,
  `end_date` date NOT NULL,
  `total_cost` int(10) unsigned NOT NULL,
  `status` tinyint(3) unsigned DEFAULT NULL,
  `last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `booking_user` (`user_id`),
  KEY `booking_hotel` (`hotel_id`),
  CONSTRAINT `booking_hotel` FOREIGN KEY (`hotel_id`) REFERENCES `hotel` (`id`),
  CONSTRAINT `booking_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking`
--

LOCK TABLES `booking` WRITE;
/*!40000 ALTER TABLE `booking` DISABLE KEYS */;
INSERT INTO `booking` VALUES (1,1,1,'2014-12-13','2014-12-15',2000,1,'2014-03-08 17:45:47');
/*!40000 ALTER TABLE `booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `booking_room`
--

DROP TABLE IF EXISTS `booking_room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `booking_room` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `booking_id` int(10) unsigned NOT NULL,
  `room_id` int(10) unsigned NOT NULL,
  `hotel_id` int(10) unsigned NOT NULL,
  `number_of_rooms` tinyint(3) unsigned NOT NULL,
  `cost` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `booking_room_room` (`room_id`),
  KEY `booking_room_hotel` (`hotel_id`),
  KEY `booking_room_booking` (`booking_id`),
  CONSTRAINT `booking_room_hotel` FOREIGN KEY (`hotel_id`) REFERENCES `hotel` (`id`),
  CONSTRAINT `booking_room_room` FOREIGN KEY (`room_id`) REFERENCES `room` (`id`),
  CONSTRAINT `booking_room_booking` FOREIGN KEY (`booking_id`) REFERENCES `booking` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking_room`
--

LOCK TABLES `booking_room` WRITE;
/*!40000 ALTER TABLE `booking_room` DISABLE KEYS */;
INSERT INTO `booking_room` VALUES (1,1,1,1,2,2000);
/*!40000 ALTER TABLE `booking_room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `city` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name_eng` varchar(100) DEFAULT NULL,
  `name_ukr` varchar(100) DEFAULT NULL,
  `country_id` int(10) unsigned NOT NULL,
  `region_id` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `city_country` (`country_id`),
  KEY `city_region` (`region_id`),
  CONSTRAINT `city_country` FOREIGN KEY (`country_id`) REFERENCES `country` (`id`),
  CONSTRAINT `city_region` FOREIGN KEY (`region_id`) REFERENCES `region` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` VALUES (1,'Lviv','Львів',245,13),(3,'Truskavets','Трускавець',245,13),(4,'Slavske','Славське',245,13),(5,'Zhovkva','Жовква',245,13),(6,'Bryukhovychi','Брюховичі',245,13),(7,'Kyiv','Київ',245,9),(8,'Boryspil','Бориспіль',245,9),(9,'Brovary','Бровари',245,9),(10,'Paris','Париж',83,31),(11,'Nice','Ніцца',83,NULL),(12,'Cannes','Канни',83,NULL),(13,'Lyon','Ліон',83,43),(14,'Annecy','Аннесі',83,43);
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `country`
--

DROP TABLE IF EXISTS `country`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `country` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name_eng` varchar(50) DEFAULT NULL,
  `name_ukr` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=260 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `country`
--

LOCK TABLES `country` WRITE;
/*!40000 ALTER TABLE `country` DISABLE KEYS */;
INSERT INTO `country` VALUES (1,'Afghanistan','Афганістан'),(2,'Aland Islands','Аландські острови'),(3,'Albania','Албанія'),(4,'Algeria','Алжир'),(5,'American Samoa','Американське Самоа'),(6,'Andorra','Андорра'),(7,'Angola','Ангола'),(8,'Anguilla','Ангілья'),(9,'Antarctica','Антарктида'),(10,'Antigua and Barbuda','Антигуа і Барбуда'),(11,'Argentina','Аргентина'),(12,'Armenia','Вірменія'),(13,'Aruba','Аруба'),(14,'Ascension Island','Острів Вознесіння'),(15,'Australia','Австралія'),(16,'Austria','Австрія'),(17,'Azerbaijan','Азербайджан'),(18,'Bahamas','Багами'),(19,'Bahrain','Бахрейн'),(20,'Bangladesh','Бангладеш'),(21,'Barbados','Барбадос'),(22,'Belarus','Білорусь'),(23,'Belgium','Бельгія'),(24,'Belize','Беліз'),(25,'Benin','Бенін'),(26,'Bermuda','Бермуди'),(27,'Bhutan','Бутан'),(28,'Bolivia','Болівія'),(29,'Bonaire, Sint Eustatius, and Saba',NULL),(30,'Bosnia and Herzegovina','Боснія і Герцоговина'),(31,'Botswana','Ботсвана'),(32,'Bouvet Island','Острів Буве'),(33,'Brazil','Бразилія'),(34,'British Indian Ocean Territory','Британські території Індійського океану'),(35,'British Virgin Islands','Віргінські острови Британії'),(36,'Brunei','Бруней'),(37,'Bulgaria','Болгарія'),(38,'Burkina Faso','Буркіна-Фасо'),(39,'Burundi','Бурунді'),(40,'Cambodia','Камбоджа'),(41,'Cameroon','Камерун'),(42,'Canada','Канада'),(43,'Canary Islands','Канарські острови'),(44,'Cape Verde','Кабо-Верде'),(45,'Cayman Islands','Кайманові острови'),(46,'Central African Republic','Центральноафриканська республіка'),(47,'Ceuta and Melilla','Сеута і Мелілья'),(48,'Chad','Чад'),(49,'Chile','Чілі'),(50,'China','Китай'),(51,'Christmas Island','Острів Різдва'),(52,'Clipperton Island','Острів Кліппертон'),(53,'Cocos [Keeling] Islands','Кокосові острови'),(54,'Colombia','Колумбія'),(55,'Comoros','Коморські острови'),(56,'Congo - Brazzaville','Конґо - Браззавіль'),(57,'Congo - Kinshasa','Конґо - Кіншаса'),(58,'Cook Islands','Острови Кука'),(59,'Costa Rica','Коста-Рика'),(60,'Côte d’Ivoire','Кот д\'Івуар'),(61,'Croatia','Хорватія'),(62,'Cuba','Куба'),(63,'Curaçao',NULL),(64,'Cyprus','Кіпр'),(65,'Czech Republic','Чеська республіка'),(66,'Denmark','Данія'),(67,'Diego Garcia','Дієґо-Ґарсія'),(68,'Djibouti','Джібуті'),(69,'Dominica','Домінік'),(70,'Dominican Republic','Домініканська Республіка'),(71,'Ecuador','Еквадор'),(72,'Egypt','Єгипет'),(73,'El Salvador','Сальвадор'),(74,'Equatorial Guinea','Екваторіальна Гвінея'),(75,'Eritrea','Еритрея'),(76,'Estonia','Естонія'),(77,'Ethiopia','Ефіопія'),(78,'European Union','Європейський Союз'),(79,'Falkland Islands','Фолклендські острови'),(80,'Faroe Islands','Фарерські острови'),(81,'Fiji','Фіджі'),(82,'Finland','Фінляндія'),(83,'France','Франція'),(84,'French Guiana','Французька Гвіана'),(85,'French Polynesia','Французька Полінезія'),(86,'French Southern Territories','Французькі Південні Території'),(87,'Gabon','Габон'),(88,'Gambia','Гамбія'),(89,'Georgia','Грузія'),(90,'Germany','Німеччина'),(91,'Ghana','Гана'),(92,'Gibraltar','Гібралтар'),(93,'Greece','Греція'),(94,'Greenland','Гренландія'),(95,'Grenada','Гренада'),(96,'Guadeloupe','Гваделупа'),(97,'Guam','Гуам'),(98,'Guatemala','Гватемала'),(99,'Guernsey','Гернсі'),(100,'Guinea','Гвінея'),(101,'Guinea-Bissau','Гвінея-Біссау'),(102,'Guyana','Гайана'),(103,'Haiti','Гаїті'),(104,'Heard Island and McDonald Islands','Острови Херд і Мак-Дональд'),(105,'Honduras','Гондурас'),(106,'Hong Kong SAR China','Гонконґ О.А.Р. Китаю'),(107,'Hungary','Угорщина'),(108,'Iceland','Ісландія'),(109,'India','Індія'),(110,'Indonesia','Індонезія'),(111,'Iran','Іран'),(112,'Iraq','Ірак'),(113,'Ireland','Ірландія'),(114,'Isle of Man','Острів Мен'),(115,'Israel','Ізраїль'),(116,'Italy','Італія'),(117,'Jamaica','Ямайка'),(118,'Japan','Японія'),(119,'Jersey','Джерсі'),(120,'Jordan','Йорданія'),(121,'Kazakhstan','Казахстан'),(122,'Kenya','Кенія'),(123,'Kiribati','Кірибаті'),(124,'Kuwait','Кувейт'),(125,'Kyrgyzstan','Киргизстан'),(126,'Laos','Лаос'),(127,'Latvia','Латвія'),(128,'Lebanon','Ліван'),(129,'Lesotho','Лесото'),(130,'Liberia','Ліберія'),(131,'Libya','Лівія'),(132,'Liechtenstein','Ліхтенштейн'),(133,'Lithuania','Литва'),(134,'Luxembourg','Люксембург'),(135,'Macau SAR China','Макао О.А.Р. Китаю'),(136,'Macedonia','Македонія'),(137,'Madagascar','Мадагаскар'),(138,'Malawi','Малаві'),(139,'Malaysia','Малайзія'),(140,'Maldives','Мальдіви'),(141,'Mali','Малі'),(142,'Malta','Мальта'),(143,'Marshall Islands','Маршаллові Острови'),(144,'Martinique','Мартиніка'),(145,'Mauritania','Мавританія'),(146,'Mauritius','Маврикій'),(147,'Mayotte','Майот'),(148,'Mexico','Мексика'),(149,'Micronesia','Мікронезія'),(150,'Moldova','Молдова'),(151,'Monaco','Монако'),(152,'Mongolia','Монголія'),(153,'Montenegro','Чорногорія'),(154,'Montserrat','Монсеррат'),(155,'Morocco','Марокко'),(156,'Mozambique','Мозамбік'),(157,'Myanmar [Burma]','М\'янма [Бірма]'),(158,'Namibia','Намібія'),(159,'Nauru','Науру'),(160,'Nepal','Непал'),(161,'Netherlands','Нідерланди'),(162,'Netherlands Antilles','Нідерландські Антильські Остови'),(163,'New Caledonia','Нова Каледонія'),(164,'New Zealand','Нова Зеландія'),(165,'Nicaragua','Нікарагуа'),(166,'Niger','Нігер'),(167,'Nigeria','Нігерія'),(168,'Niue','Нія'),(169,'Norfolk Island','Острів Норфолк'),(170,'North Korea','Північна Корея'),(171,'Northern Mariana Islands','Північні Маріанські Острови'),(172,'Norway','Норвегія'),(173,'Oman','Оман'),(174,'Outlying Oceania','Інша Океанія'),(175,'Pakistan','Пакистан'),(176,'Palau','Палау'),(177,'Palestinian Territories','Палестина'),(178,'Panama','Панама'),(179,'Papua New Guinea','Папуа Нова Гвінея'),(180,'Paraguay','Парагвай'),(181,'Peru','Перу'),(182,'Philippines','Філіппіни'),(183,'Pitcairn Islands','Острови Піткерн'),(184,'Poland','Польща'),(185,'Portugal','Португалія'),(186,'Puerto Rico','Пуерто-Ріко'),(187,'Qatar','Катар'),(188,'Réunion','Реюньйон'),(189,'Romania','Ромунія'),(190,'Russia','Росія'),(191,'Rwanda','Руанда'),(192,'Saint Barthélemy','Острів Святого Бартоломея'),(193,'Saint Helena','Острів Святої Єлени'),(194,'Saint Kitts and Nevis','Сент-Кітс і Невіс'),(195,'Saint Lucia','Сент-Люсія'),(196,'Saint Martin','Острів Святого Мартіна'),(197,'Saint Pierre and Miquelon','Сен-П\'єр і Мікелон'),(198,'Saint Vincent and the Grenadines','Сент-Вінсент і Гренадини'),(199,'Samoa','Самоа'),(200,'San Marino','Сан-Марино'),(201,'São Tomé and Príncipe','Сан-Томе і Прінсіпі'),(202,'Saudi Arabia','Саудівська Аравія'),(203,'Senegal','Сенегал'),(204,'Serbia','Сербія'),(205,'Serbia and Montenegro','Сербія та Чорногорія'),(206,'Seychelles','Сейшели'),(207,'Sierra Leone','Сьєрра-Леоне'),(208,'Singapore','Сінгапур'),(209,'Sint Maarten',NULL),(210,'Slovakia','Словаччина'),(211,'Slovenia','Словенія'),(212,'Solomon Islands','Соломонові Острови'),(213,'Somalia','Сомалі'),(214,'South Africa','ПАР'),(215,'South Georgia and the South Sandwich Islands','Південна Джорджія та Південні Сандвічеві Острови'),(216,'South Korea','Південна Корея'),(217,'South Sudan',NULL),(218,'Spain','Іспанія'),(219,'Sri Lanka','Шрі-Ланка'),(220,'Sudan','Судан'),(221,'Suriname','Суринам'),(222,'Svalbard and Jan Mayen','Острови Свальбард та Ян-Маєн'),(223,'Swaziland','Свазіленд'),(224,'Sweden','Швеція'),(225,'Switzerland','Швейцарія'),(226,'Syria','Сирія'),(227,'Taiwan','Тайвань'),(228,'Tajikistan','Таджикистан'),(229,'Tanzania','Танзанія'),(230,'Thailand','Таїланд'),(231,'Timor-Leste','Тімор-Лешті'),(232,'Togo','Того'),(233,'Tokelau','Токелау'),(234,'Tonga','Тонга'),(235,'Trinidad and Tobago','Тринідад і Тобаго'),(236,'Tristan da Cunha','Трістан-да-Кунья'),(237,'Tunisia','Туніс'),(238,'Turkey','Туреччина'),(239,'Turkmenistan','Туркменистан'),(240,'Turks and Caicos Islands','Теркс і Кайкос'),(241,'Tuvalu','Тувалу'),(242,'U.S. Minor Outlying Islands','Віддалені острови США'),(243,'U.S. Virgin Islands','Віргінські острови США'),(244,'Uganda','Уганда'),(245,'Ukraine','Україна'),(246,'United Arab Emirates','Об\'єднані Арабські Емірати'),(247,'United Kingdom','Великобританія'),(248,'United States','США'),(249,'Uruguay','Уругвай'),(250,'Uzbekistan','Узбекистан'),(251,'Vanuatu','Вануату'),(252,'Vatican City','Ватикан'),(253,'Venezuela','Венесуела'),(254,'Vietnam','В\'єтнам'),(255,'Wallis and Futuna','Уолліс і Футуна'),(256,'Western Sahara','Західна Сахара'),(257,'Yemen','Ємен'),(258,'Zambia','Замбія'),(259,'Zimbabwe','Зімбабве');
/*!40000 ALTER TABLE `country` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `favorite`
--

DROP TABLE IF EXISTS `favorite`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `favorite` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(10) unsigned NOT NULL,
  `hotel_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `favorite_hotel` (`hotel_id`),
  KEY `favorite_user` (`user_id`),
  CONSTRAINT `favorite_hotel` FOREIGN KEY (`hotel_id`) REFERENCES `hotel` (`id`),
  CONSTRAINT `favorite_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `favorite`
--

LOCK TABLES `favorite` WRITE;
/*!40000 ALTER TABLE `favorite` DISABLE KEYS */;
/*!40000 ALTER TABLE `favorite` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hotel`
--

DROP TABLE IF EXISTS `hotel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hotel` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `address` varchar(100) NOT NULL,
  `avg_rate` tinyint(4) DEFAULT NULL,
  `country_id` int(10) unsigned NOT NULL,
  `region_id` int(10) unsigned DEFAULT NULL,
  `city_id` int(10) unsigned NOT NULL,
  `blocked` bit(1) DEFAULT NULL,
  `last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `hotel_country` (`country_id`),
  KEY `hotel_region` (`region_id`),
  KEY `hotel_city` (`city_id`),
  CONSTRAINT `hotel_city` FOREIGN KEY (`city_id`) REFERENCES `city` (`id`),
  CONSTRAINT `hotel_country` FOREIGN KEY (`country_id`) REFERENCES `country` (`id`),
  CONSTRAINT `hotel_region` FOREIGN KEY (`region_id`) REFERENCES `region` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hotel`
--

LOCK TABLES `hotel` WRITE;
/*!40000 ALTER TABLE `hotel` DISABLE KEYS */;
INSERT INTO `hotel` VALUES (1,'Nobelis','Lustopadna 11',2,1,3,3,NULL,'2014-03-08 17:33:22'),(2,'Rias','Central Aveneu 2',4,2,6,4,NULL,'2014-03-08 17:33:56');
/*!40000 ALTER TABLE `hotel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hotel_info`
--

DROP TABLE IF EXISTS `hotel_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hotel_info` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `hotel_id` int(10) unsigned NOT NULL,
  `locale` varchar(5) NOT NULL,
  `short_info` varchar(255) DEFAULT NULL,
  `extended_info` text,
  PRIMARY KEY (`id`),
  CONSTRAINT `hotel_info_hotel` FOREIGN KEY (`id`) REFERENCES `hotel` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hotel_info`
--

LOCK TABLES `hotel_info` WRITE;
/*!40000 ALTER TABLE `hotel_info` DISABLE KEYS */;
INSERT INTO `hotel_info` VALUES (1,1,'ukr','Little hotel in Brodu','extended info about hotel id=1');
/*!40000 ALTER TABLE `hotel_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hotel_service`
--

DROP TABLE IF EXISTS `hotel_service`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hotel_service` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `hotel_id` int(10) unsigned NOT NULL,
  `service_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `hotel_service_hotel` (`hotel_id`),
  KEY `hotel_service_service` (`service_id`),
  CONSTRAINT `hotel_service_hotel` FOREIGN KEY (`hotel_id`) REFERENCES `hotel` (`id`),
  CONSTRAINT `hotel_service_service` FOREIGN KEY (`service_id`) REFERENCES `service` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hotel_service`
--

LOCK TABLES `hotel_service` WRITE;
/*!40000 ALTER TABLE `hotel_service` DISABLE KEYS */;
INSERT INTO `hotel_service` VALUES (1,1,2),(2,1,1),(3,1,3),(4,2,3),(5,2,1);
/*!40000 ALTER TABLE `hotel_service` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `manager`
--

DROP TABLE IF EXISTS `manager`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `manager` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `first_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `e-mail` varchar(50) NOT NULL,
  `admin_id` int(10) unsigned DEFAULT NULL,
  `last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `password` char(32) CHARACTER SET latin1 NOT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `registration_date` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `manager_admin` (`admin_id`),
  CONSTRAINT `manager_admin` FOREIGN KEY (`admin_id`) REFERENCES `admin` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manager`
--

LOCK TABLES `manager` WRITE;
/*!40000 ALTER TABLE `manager` DISABLE KEYS */;
INSERT INTO `manager` VALUES (1,'Ivan','Petrosjan','ivan@i.ua',1,'2014-12-10 20:00:00','root','0936938411','2014-12-10'),(2,'Karina','Bella','bela@yahoo.com',1,'2014-02-03 20:00:00','root','095933744','2014-02-01');
/*!40000 ALTER TABLE `manager` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `manager_hotel`
--

DROP TABLE IF EXISTS `manager_hotel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `manager_hotel` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `manager_id` int(10) unsigned NOT NULL,
  `hotel_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `manager_hotel_manager` (`manager_id`),
  KEY `manager_hotel_hotel` (`hotel_id`),
  CONSTRAINT `manager_hotel_hotel` FOREIGN KEY (`hotel_id`) REFERENCES `hotel` (`id`),
  CONSTRAINT `manager_hotel_manager` FOREIGN KEY (`manager_id`) REFERENCES `manager` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manager_hotel`
--

LOCK TABLES `manager_hotel` WRITE;
/*!40000 ALTER TABLE `manager_hotel` DISABLE KEYS */;
INSERT INTO `manager_hotel` VALUES (1,1,1),(2,2,2);
/*!40000 ALTER TABLE `manager_hotel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rate`
--

DROP TABLE IF EXISTS `rate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rate` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `hotel_id` int(10) unsigned NOT NULL,
  `user_id` int(10) unsigned NOT NULL,
  `rating` tinyint(4) NOT NULL,
  `response` text,
  PRIMARY KEY (`id`),
  KEY `rate_user` (`user_id`),
  KEY `rate_hotel` (`hotel_id`),
  CONSTRAINT `rate_hotel` FOREIGN KEY (`hotel_id`) REFERENCES `hotel` (`id`),
  CONSTRAINT `rate_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rate`
--

LOCK TABLES `rate` WRITE;
/*!40000 ALTER TABLE `rate` DISABLE KEYS */;
INSERT INTO `rate` VALUES (3,1,1,3,'not bad'),(4,2,2,5,'cool');
/*!40000 ALTER TABLE `rate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `region`
--

DROP TABLE IF EXISTS `region`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `region` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name_eng` varchar(100) DEFAULT NULL,
  `name_ukr` varchar(100) DEFAULT NULL,
  `country_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `country_region` (`country_id`),
  CONSTRAINT `country_region` FOREIGN KEY (`country_id`) REFERENCES `country` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `region`
--

LOCK TABLES `region` WRITE;
/*!40000 ALTER TABLE `region` DISABLE KEYS */;
INSERT INTO `region` VALUES (1,'Vinnytsia Oblast','Вінницька область',245),(2,'Volyn Oblast','Волинська область',245),(3,'Dnipropetrovsk Oblast','Дніпропетровська область',245),(4,'Donetsk Oblast','Донецька область',245),(5,'Zhytomyr Oblast','Житомирська область',245),(6,'Zakarpattia Oblast','Закарпатська область',245),(7,'Zaporizhia Oblast','Запорізька область',245),(8,'Ivano-Frankivsk Oblast','Івано-франківська область',245),(9,'Kyiv Oblast','Київська область',245),(10,'Kirovohrad Oblast','Кіровоградська область',245),(11,'Crimea','Крим',245),(12,'Luhansk Oblast','Луганська область',245),(13,'Lviv Oblast','Львівська область',245),(14,'Mykolaiv Oblast','Миколаївська область',245),(15,'Odessa Oblast','Одеська область',245),(16,'Poltava Oblast','Полтавська область',245),(17,'Rivne Oblast','Рівненська область',245),(18,'Sumy Oblast','Сумська область',245),(19,'Ternopil Oblast','Тернопільска область',245),(20,'Kharkiv Oblast','Харківська область',245),(21,'Kherson Oblast','Херсонська область',245),(22,'Khmelnytskyi Oblast','Хмельницька область',245),(23,'Cherkasy Oblast','Черкаська область',245),(24,'Chernivtsi Oblast','Чернівецька область',245),(25,'Chernihiv Oblast','Чернігівська область',245),(31,'Ile de France','Іль-де-Франс',83),(32,'Burgundy','Бургундія',83),(33,'Upper Normandy','Верхня Нормандія',83),(34,'Corsica','Корсика',83),(35,'Languedoc-Roussillon','Лангедок-Руссільйон',83),(36,'Lorraine','Лотарингія',83),(37,'Lower Normandy','Нижня Нормандія',83),(38,'Nord-Pas-de-Calais','Нор-Па-де-Кале',83),(39,'Pays de la Loire','Пеї-де-ла-Луар',83),(40,'Provence-Alpes-Côte d\'Azur','Прованс-Альпи-Лазурний берег',83),(41,'Poitou-Charentes','Пуату-Шарант',83),(42,'Midi-Pyrénées','Південь-Піренеї',83),(43,'Rhône-Alps','Рона-Альпи',83);
/*!40000 ALTER TABLE `region` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `room`
--

DROP TABLE IF EXISTS `room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `room` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `hotel_id` int(10) unsigned NOT NULL,
  `name` varchar(70) NOT NULL,
  `cost` int(10) unsigned NOT NULL,
  `number_of_rooms` tinyint(4) NOT NULL COMMENT 'Number of rooms in this room type',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room`
--

LOCK TABLES `room` WRITE;
/*!40000 ALTER TABLE `room` DISABLE KEYS */;
INSERT INTO `room` VALUES (1,1,'plaza',2000,3),(2,2,'lux',2100,5);
/*!40000 ALTER TABLE `room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `service`
--

DROP TABLE IF EXISTS `service`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `service` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name_eng` varchar(100) DEFAULT NULL,
  `name_ukr` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `service`
--

LOCK TABLES `service` WRITE;
/*!40000 ALTER TABLE `service` DISABLE KEYS */;
INSERT INTO `service` VALUES (1,'Facilities for Disabled Guests','Номери/зручності для осіб з обмеженими фізичними можливостями'),(2,'Restaurant','Ресторан'),(3,'Internet','Інтернет'),(4,'Non-smoking Rooms','Номери для некурців'),(5,'Fitness Center','Фітнес-центр'),(6,'Family Rooms','Сімейні номери'),(7,'Pet Friendly','Допускається розміщення з домашніми тваринами'),(8,'Parking','Автостоянка'),(9,'Spa','Оздоровчий спа-центр'),(10,'Wi-Fi','Wi-Fi'),(11,'Indoor Pool','Критий плавальний басейн'),(12,'Airport Shuttle','Трансфер до/з аеропорту'),(13,'Free Wi-Fi','Безкоштовний Wi-Fi'),(14,'Bar','Бар'),(15,'Baggage Storage','Камера зберігання багажу'),(16,'24-Hour Front Desk','Цілодобова стійка реєстрації гостей');
/*!40000 ALTER TABLE `service` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `first_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `e-mail` varchar(50) NOT NULL,
  `password` char(32) CHARACTER SET latin1 DEFAULT NULL,
  `registration_date` date NOT NULL,
  `registered` bit(1) DEFAULT NULL,
  `blocked` bit(1) DEFAULT NULL,
  `last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Ketrin','Bern','kb@hotmail.com','2d1026b5e8a5e64a61690793af2cb059','2012-11-12','','','2014-03-09 15:33:26'),(2,'Andrew','Kembl','anre@epam.com','50ed9a6238d7aa0c3844f4ab575e42b2','2013-11-13','',NULL,'2014-03-09 15:30:18');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-03-09 20:42:22
