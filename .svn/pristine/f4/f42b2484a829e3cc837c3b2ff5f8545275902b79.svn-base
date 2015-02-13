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
  `email` varchar(50) NOT NULL,
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
INSERT INTO `admin` VALUES (1,'Oleg','Bereza','bereza@gala.net','ebb6c69a7b209cfe5cca7532401a6ad3','2014-12-12');
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
  CONSTRAINT `booking_room_booking` FOREIGN KEY (`booking_id`) REFERENCES `booking` (`id`),
  CONSTRAINT `booking_room_hotel` FOREIGN KEY (`hotel_id`) REFERENCES `hotel` (`id`),
  CONSTRAINT `booking_room_room` FOREIGN KEY (`room_id`) REFERENCES `room` (`id`)
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
  `name_en` varchar(100) DEFAULT NULL,
  `name_ua` varchar(100) DEFAULT NULL,
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
  `name_en` varchar(50) DEFAULT NULL,
  `name_ua` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=260 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `country`
--

LOCK TABLES `country` WRITE;
/*!40000 ALTER TABLE `country` DISABLE KEYS */;
INSERT INTO `country` VALUES (1,'Afghanista','Афганістан'),(2,'Aland Islands','Аландські острови'),(3,'Albania','Албанія'),(4,'Algeria','Алжир'),(5,'American Samoa','Американське Самоа'),(6,'Andorra','Андорра'),(7,'Angola','Ангола'),(8,'Anguilla','Ангілья'),(9,'Antarctica','Антарктида'),(10,'Antigua and Barbuda','Антигуа і Барбуда'),(11,'Argentina','Аргентина'),(12,'Armenia','Вірменія'),(13,'Aruba','Аруба'),(14,'Ascension Island','Острів Вознесіння'),(15,'Australia','Австралія'),(16,'Austria','Австрія'),(17,'Azerbaijan','Азербайджан'),(18,'Bahamas','Багами'),(19,'Bahrain','Бахрейн'),(20,'Bangladesh','Бангладеш'),(21,'Barbados','Барбадос'),(22,'Belarus','Білорусь'),(23,'Belgium','Бельгія'),(24,'Belize','Беліз'),(25,'Benin','Бенін'),(26,'Bermuda','Бермуди'),(27,'Bhutan','Бутан'),(28,'Bolivia','Болівія'),(29,'Bonaire, Sint Eustatius, and Saba',NULL),(30,'Bosnia and Herzegovina','Боснія і Герцоговина'),(31,'Botswana','Ботсвана'),(32,'Bouvet Island','Острів Буве'),(33,'Brazil','Бразилія'),(34,'British Indian Ocean Territory','Британські території Індійського океану'),(35,'British Virgin Islands','Віргінські острови Британії'),(36,'Brunei','Бруней'),(37,'Bulgaria','Болгарія'),(38,'Burkina Faso','Буркіна-Фасо'),(39,'Burundi','Бурунді'),(40,'Cambodia','Камбоджа'),(41,'Cameroon','Камерун'),(42,'Canada','Канада'),(43,'Canary Islands','Канарські острови'),(44,'Cape Verde','Кабо-Верде'),(45,'Cayman Islands','Кайманові острови'),(46,'Central African Republic','Центральноафриканська республіка'),(47,'Ceuta and Melilla','Сеута і Мелілья'),(48,'Chad','Чад'),(49,'Chile','Чілі'),(50,'China','Китай'),(51,'Christmas Island','Острів Різдва'),(52,'Clipperton Island','Острів Кліппертон'),(53,'Cocos [Keeling] Islands','Кокосові острови'),(54,'Colombia','Колумбія'),(55,'Comoros','Коморські острови'),(56,'Congo - Brazzaville','Конґо - Браззавіль'),(57,'Congo - Kinshasa','Конґо - Кіншаса'),(58,'Cook Islands','Острови Кука'),(59,'Costa Rica','Коста-Рика'),(60,'Côte d’Ivoire','Кот д\'Івуар'),(61,'Croatia','Хорватія'),(62,'Cuba','Куба'),(63,'Curaçao',NULL),(64,'Cyprus','Кіпр'),(65,'Czech Republic','Чеська республіка'),(66,'Denmark','Данія'),(67,'Diego Garcia','Дієґо-Ґарсія'),(68,'Djibouti','Джібуті'),(69,'Dominica','Домінік'),(70,'Dominican Republic','Домініканська Республіка'),(71,'Ecuador','Еквадор'),(72,'Egypt','Єгипет'),(73,'El Salvador','Сальвадор'),(74,'Equatorial Guinea','Екваторіальна Гвінея'),(75,'Eritrea','Еритрея'),(76,'Estonia','Естонія'),(77,'Ethiopia','Ефіопія'),(78,'European Union','Європейський Союз'),(79,'Falkland Islands','Фолклендські острови'),(80,'Faroe Islands','Фарерські острови'),(81,'Fiji','Фіджі'),(82,'Finland','Фінляндія'),(83,'France','Франція'),(84,'French Guiana','Французька Гвіана'),(85,'French Polynesia','Французька Полінезія'),(86,'French Southern Territories','Французькі Південні Території'),(87,'Gabon','Габон'),(88,'Gambia','Гамбія'),(89,'Georgia','Грузія'),(90,'Germany','Німеччина'),(91,'Ghana','Гана'),(92,'Gibraltar','Гібралтар'),(93,'Greece','Греція'),(94,'Greenland','Гренландія'),(95,'Grenada','Гренада'),(96,'Guadeloupe','Гваделупа'),(97,'Guam','Гуам'),(98,'Guatemala','Гватемала'),(99,'Guernsey','Гернсі'),(100,'Guinea','Гвінея'),(101,'Guinea-Bissau','Гвінея-Біссау'),(102,'Guyana','Гайана'),(103,'Haiti','Гаїті'),(104,'Heard Island and McDonald Islands','Острови Херд і Мак-Дональд'),(105,'Honduras','Гондурас'),(106,'Hong Kong SAR China','Гонконґ О.А.Р. Китаю'),(107,'Hungary','Угорщина'),(108,'Iceland','Ісландія'),(109,'India','Індія'),(110,'Indonesia','Індонезія'),(111,'Iran','Іран'),(112,'Iraq','Ірак'),(113,'Ireland','Ірландія'),(114,'Isle of Man','Острів Мен'),(115,'Israel','Ізраїль'),(116,'Italy','Італія'),(117,'Jamaica','Ямайка'),(118,'Japan','Японія'),(119,'Jersey','Джерсі'),(120,'Jordan','Йорданія'),(121,'Kazakhstan','Казахстан'),(122,'Kenya','Кенія'),(123,'Kiribati','Кірибаті'),(124,'Kuwait','Кувейт'),(125,'Kyrgyzstan','Киргизстан'),(126,'Laos','Лаос'),(127,'Latvia','Латвія'),(128,'Lebanon','Ліван'),(129,'Lesotho','Лесото'),(130,'Liberia','Ліберія'),(131,'Libya','Лівія'),(132,'Liechtenstein','Ліхтенштейн'),(133,'Lithuania','Литва'),(134,'Luxembourg','Люксембург'),(135,'Macau SAR China','Макао О.А.Р. Китаю'),(136,'Macedonia','Македонія'),(137,'Madagascar','Мадагаскар'),(138,'Malawi','Малаві'),(139,'Malaysia','Малайзія'),(140,'Maldives','Мальдіви'),(141,'Mali','Малі'),(142,'Malta','Мальта'),(143,'Marshall Islands','Маршаллові Острови'),(144,'Martinique','Мартиніка'),(145,'Mauritania','Мавританія'),(146,'Mauritius','Маврикій'),(147,'Mayotte','Майот'),(148,'Mexico','Мексика'),(149,'Micronesia','Мікронезія'),(150,'Moldova','Молдова'),(151,'Monaco','Монако'),(152,'Mongolia','Монголія'),(153,'Montenegro','Чорногорія'),(154,'Montserrat','Монсеррат'),(155,'Morocco','Марокко'),(156,'Mozambique','Мозамбік'),(157,'Myanmar [Burma]','М\'янма [Бірма]'),(158,'Namibia','Намібія'),(159,'Nauru','Науру'),(160,'Nepal','Непал'),(161,'Netherlands','Нідерланди'),(162,'Netherlands Antilles','Нідерландські Антильські Остови'),(163,'New Caledonia','Нова Каледонія'),(164,'New Zealand','Нова Зеландія'),(165,'Nicaragua','Нікарагуа'),(166,'Niger','Нігер'),(167,'Nigeria','Нігерія'),(168,'Niue','Нія'),(169,'Norfolk Island','Острів Норфолк'),(170,'North Korea','Північна Корея'),(171,'Northern Mariana Islands','Північні Маріанські Острови'),(172,'Norway','Норвегія'),(173,'Oman','Оман'),(174,'Outlying Oceania','Інша Океанія'),(175,'Pakistan','Пакистан'),(176,'Palau','Палау'),(177,'Palestinian Territories','Палестина'),(178,'Panama','Панама'),(179,'Papua New Guinea','Папуа Нова Гвінея'),(180,'Paraguay','Парагвай'),(181,'Peru','Перу'),(182,'Philippines','Філіппіни'),(183,'Pitcairn Islands','Острови Піткерн'),(184,'Poland','Польща'),(185,'Portugal','Португалія'),(186,'Puerto Rico','Пуерто-Ріко'),(187,'Qatar','Катар'),(188,'Réunion','Реюньйон'),(189,'Romania','Ромунія'),(190,'Russia','Росія'),(191,'Rwanda','Руанда'),(192,'Saint Barthélemy','Острів Святого Бартоломея'),(193,'Saint Helena','Острів Святої Єлени'),(194,'Saint Kitts and Nevis','Сент-Кітс і Невіс'),(195,'Saint Lucia','Сент-Люсія'),(196,'Saint Martin','Острів Святого Мартіна'),(197,'Saint Pierre and Miquelon','Сен-П\'єр і Мікелон'),(198,'Saint Vincent and the Grenadines','Сент-Вінсент і Гренадини'),(199,'Samoa','Самоа'),(200,'San Marino','Сан-Марино'),(201,'São Tomé and Príncipe','Сан-Томе і Прінсіпі'),(202,'Saudi Arabia','Саудівська Аравія'),(203,'Senegal','Сенегал'),(204,'Serbia','Сербія'),(205,'Serbia and Montenegro','Сербія та Чорногорія'),(206,'Seychelles','Сейшели'),(207,'Sierra Leone','Сьєрра-Леоне'),(208,'Singapore','Сінгапур'),(209,'Sint Maarten',NULL),(210,'Slovakia','Словаччина'),(211,'Slovenia','Словенія'),(212,'Solomon Islands','Соломонові Острови'),(213,'Somalia','Сомалі'),(214,'South Africa','ПАР'),(215,'South Georgia and the South Sandwich Islands','Південна Джорджія та Південні Сандвічеві Острови'),(216,'South Korea','Південна Корея'),(217,'South Sudan',NULL),(218,'Spain','Іспанія'),(219,'Sri Lanka','Шрі-Ланка'),(220,'Sudan','Судан'),(221,'Suriname','Суринам'),(222,'Svalbard and Jan Mayen','Острови Свальбард та Ян-Маєн'),(223,'Swaziland','Свазіленд'),(224,'Sweden','Швеція'),(225,'Switzerland','Швейцарія'),(226,'Syria','Сирія'),(227,'Taiwan','Тайвань'),(228,'Tajikistan','Таджикистан'),(229,'Tanzania','Танзанія'),(230,'Thailand','Таїланд'),(231,'Timor-Leste','Тімор-Лешті'),(232,'Togo','Того'),(233,'Tokelau','Токелау'),(234,'Tonga','Тонга'),(235,'Trinidad and Tobago','Тринідад і Тобаго'),(236,'Tristan da Cunha','Трістан-да-Кунья'),(237,'Tunisia','Туніс'),(238,'Turkey','Туреччина'),(239,'Turkmenistan','Туркменистан'),(240,'Turks and Caicos Islands','Теркс і Кайкос'),(241,'Tuvalu','Тувалу'),(242,'U.S. Minor Outlying Islands','Віддалені острови США'),(243,'U.S. Virgin Islands','Віргінські острови США'),(244,'Uganda','Уганда'),(245,'Ukraine','Україна'),(246,'United Arab Emirates','Об\'єднані Арабські Емірати'),(247,'United Kingdom','Великобританія'),(248,'United States','США'),(249,'Uruguay','Уругвай'),(250,'Uzbekistan','Узбекистан'),(251,'Vanuatu','Вануату'),(252,'Vatican City','Ватикан'),(253,'Venezuela','Венесуела'),(254,'Vietnam','В\'єтнам'),(255,'Wallis and Futuna','Уолліс і Футуна'),(256,'Western Sahara','Західна Сахара'),(257,'Yemen','Ємен'),(258,'Zambia','Замбія'),(259,'Zimbabwe','Зімбабве');
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
  `name_en` varchar(50) NOT NULL,
  `name_ua` varchar(50) NOT NULL,
  `address` varchar(20) NOT NULL,
  `contact_information` text,
  `avg_rate` tinyint(4) DEFAULT NULL,
  `country_id` int(10) unsigned NOT NULL,
  `region_id` int(10) unsigned DEFAULT NULL,
  `city_id` int(10) unsigned NOT NULL,
  `street_id` int(10) unsigned NOT NULL,
  `blocked` bit(1) DEFAULT NULL,
  `logo` varchar(50) DEFAULT NULL,
  `last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `longitude` varchar(50) DEFAULT NULL,
  `latitude` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `hotel_country` (`country_id`),
  KEY `hotel_region` (`region_id`),
  KEY `hotel_city` (`city_id`),
  KEY `hotel_street` (`street_id`),
  CONSTRAINT `hotel_city` FOREIGN KEY (`city_id`) REFERENCES `city` (`id`),
  CONSTRAINT `hotel_country` FOREIGN KEY (`country_id`) REFERENCES `country` (`id`),
  CONSTRAINT `hotel_region` FOREIGN KEY (`region_id`) REFERENCES `region` (`id`),
  CONSTRAINT `hotel_street` FOREIGN KEY (`street_id`) REFERENCES `street` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hotel`
--

LOCK TABLES `hotel` WRITE;
/*!40000 ALTER TABLE `hotel` DISABLE KEYS */;
INSERT INTO `hotel` VALUES (1,'Nobelis','','11',NULL,2,1,3,3,1,NULL,NULL,'2014-03-10 16:22:12',NULL,NULL),(2,'Rias','','2',NULL,4,2,6,4,1,NULL,NULL,'2014-03-10 16:22:55',NULL,NULL),(3,'Kavalier Boutique Hotel','Kavalier Boutique Hotel','70, 79056',NULL,NULL,245,13,1,2,NULL,NULL,'2014-03-19 04:11:32',NULL,NULL),(4,'Rudolfo','Рудольфо','4, 79008',NULL,NULL,245,13,1,3,NULL,NULL,'2014-03-19 04:30:14',NULL,NULL),(5,'George Hotel','Готель Жорж','1, 79000',NULL,NULL,245,13,1,4,NULL,NULL,'2014-03-19 04:39:25',NULL,NULL),(6,'Perlyna Karpat','Перлина Карпат','43Б, 82660',NULL,NULL,245,13,4,5,NULL,NULL,'2014-03-19 04:49:29',NULL,NULL),(7,'Adagio Paris Opéra','Adagio Paris Opéra','43, 75009',NULL,NULL,83,31,10,6,NULL,NULL,'2014-03-19 05:04:53',NULL,NULL);
/*!40000 ALTER TABLE `hotel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hotel_gallery`
--

DROP TABLE IF EXISTS `hotel_gallery`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hotel_gallery` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `hotel_id` int(11) unsigned NOT NULL DEFAULT '0',
  `thumb` varchar(255) DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `hotel_id` (`hotel_id`),
  CONSTRAINT `hotel_gallery_ibfk_1` FOREIGN KEY (`hotel_id`) REFERENCES `hotel` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hotel_gallery`
--

LOCK TABLES `hotel_gallery` WRITE;
/*!40000 ALTER TABLE `hotel_gallery` DISABLE KEYS */;
/*!40000 ALTER TABLE `hotel_gallery` ENABLE KEYS */;
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
  `short_info_en` varchar(255) DEFAULT NULL,
  `short_info_ua` varchar(255) DEFAULT NULL,
  `extended_info_en` text CHARACTER SET utf8 COLLATE utf8_unicode_ci,
  `extended_info_ua` text CHARACTER SET utf8 COLLATE utf8_unicode_ci,
  PRIMARY KEY (`id`),
  CONSTRAINT `hotel_info_hotel` FOREIGN KEY (`id`) REFERENCES `hotel` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hotel_info`
--

LOCK TABLES `hotel_info` WRITE;
/*!40000 ALTER TABLE `hotel_info` DISABLE KEYS */;
INSERT INTO `hotel_info` VALUES (1,1,'Little hotel in Brodu',NULL,'extended info about hotel id=1',NULL),(2,3,NULL,NULL,'Offering a tennis court and a terrace, Boutique Hotel Kavalier offers elegant, soundproof rooms in Lviv, a 5-minute drive from the city centre. WiFi is free in all areas.\r\n\r\nThe rooms each come with heating, a satellite flat-screen TV, and private bathroom with bathrobes and free toiletries. They have luxurious décor, carpeted floors, and bright interiors.\r\n\r\nBuffet breakfast is served every morning, and the on-site restaurant serves European cuisine. Guests can enjoy green lawns encircling the hotel and beyond that are the parklands.\r\n\r\nRynok Square is 3 km from the property, and Opera Theatre is a 6-minute drive from Hotel Kavalier, while Lviv Airport is 10 km away.','Бутик-готель Kavalier розміщений у Львові, за 5 хвилин їзди від центру міста. До послуг гостей тенісний корт, тераса, а також елегантні звуконепроникні номери. В усіх приміщеннях закладу безкоштовно надається Wi-Fi.\r\n\r\nКожен номер забезпечений опаленням, телевізором із плоским екраном і супутниковими каналами, а також окремою ванною кімнатою, укомплектованою халатами й безкоштовними туалетно-косметичними засобами. Вони вирізняються килимовим покриттям підлоги, розкішним оформленням та світлим інтер\'єром.\r\n\r\nЩоранку гостям подається сніданок \"шведський стіл\", а готельний ресторан спеціалізується на європейській кухні. Гості отримають можливість прогулятися на зеленій галявині навколо готелю та у лісі в межах паркової зони по сусідству.\r\n\r\nПлоща Ринок розташована за 3 км від готелю Kavalier, Оперний театр - за 6 хвилин їзди, а аеропорт Львова - за 10 км.'),(3,4,NULL,NULL,'Set in the heart of Lviv, just steps to the Opera Theatre and Ploshcha Rynok, Rudolfo offers elegant rooms with free Wi-Fi. It features a terrace with panoramic views of Lviv.\r\n\r\nThe comfortable rooms feature bright décor and modern furnishings. They offer a flat-screen satellite TV. The private bathrooms come with a bath or shower, hairdryer and free toiletries. Some rooms have a balcony.\r\n\r\nThe café at Rudolfo serves breakfast. Laundry and ironing services are available. The Church of Assumption is a 5-minute walk away.\r\n\r\nLviv Train Station is 3.5 km from the hotel, while Lviv Airport is 6.5 km away.','Готель \"Рудольфо\" розташований у самому центрі Львова, за декілька кроків від Оперного театру й Площі Ринок. До послуг гостей елегантні номери з безкоштовним Wi-Fi, а також тераса з панорамним видом на місто.\r\n\r\nКомфортабельні номери оформлені в світлих тонах й обставлені сучасними меблями. У кожному з них є телевізор із плоским екраном і супутниковим телебаченням та окрема ванна кімната з ванною або душем, феном і безкоштовними туалетно-косметичними засобами. Деякі номери мають балкон.\r\n\r\nСніданок подають у кав\'ярні готелю \"Рудольфо\". Гості можуть скористатися послугами пральні й прасування одягу. За 5 хвилин звідси можна дійти до церкви Успіння Пресвятої Богородиці.\r\n\r\nВідстань від готелю до залізничного вокзалу Львова становить 3,5 км. Аеропорт міста розміщений за 6,5 км.'),(4,5,NULL,NULL,'George Hotel is situated in a grand building in Lviv, overlooking the Adam Mickiewicz Statue. The Opera House and City Hall Square are approximately a 2-minute walk from the hotel.\r\n\r\nThe ornate rooms at Hotel George have elegant, antique-style furnishings. Each is equipped with cable TV, free Wi-Fi and a private bathroom. Some rooms enjoy seating areas.\r\n\r\nThe in-house restaurant, with its high ceilings and ambient lighting, is an ideal place for enjoying lunch or dinner.\r\n\r\nThe George has a 24-hour reception and tour desk on site.','Готель George розташований у Львові, у величній будівлі з видом на пам\'ятник Адаму Міцкевичу. Піша прогулянка від готелю до Оперного театру і Ратушної площі триватиме приблизно 2 хвилини.\r\n\r\nРозкішно оформлені номери готелю George обставлені вишуканими меблями у античному стилі. Кожний номер оснащений кабельним телебаченням, безкоштовним Wi-Fi і окремою ванною кімнатою. Деякі номери налічують зону відпочинку.\r\n\r\nРесторан готелю з високою стелею і чудовим освітленням буде найкращим місцем для обіду або вечері.\r\n\r\nВ готелі George працює цілодобова стійка реєстрації гостей і туристичне бюро.\r\n\r\nЗа запитом для гостей організовують трансфери до міжнародного аеропорту Львова.'),(5,6,NULL,NULL,'Located 300 metres from the ski lifts of Slavske Ski Resort, this hotel offers a heated swimming pool and rooms with a TV. A sauna, free Wi-Fi and a Carpathian-style bar can be found on site.\r\n\r\nEvery room at Perlyna Karpat Hotel features a balcony overlooking the Skole Beskids range. Some rooms have exposed wooden beams, and all bathrooms include a hairdryer.\r\n\r\nPerlyna’s traditionally decorated restaurant with a summer terrace serves European and Ukrainian cuisine. Local drinks and international beverages are offered at Mlyn Bar.\r\n\r\nGuests of Perlyna Karpat Hotel can relax in the sauna, take a dip in the heated outdoor swimming pool, or play billiards in the games room. Ski facilities are also provided, and there is a children’s playground.\r\n\r\nSlavske Train Station, offering access to Lviv, is 20 minutes’ walk from Perlyna Karpat Hotel. Lviv International Airport is 2 hours’ drive away, and a transfer service is available.','Цей готель розташований за 300 метрів від підйомників гірськолижного курорту Славське. На його території є басейн з підігрівом, сауна і бар в карпатському стилі. До послуг гостей номери з телевізором і безкоштовний Wi-Fi.\r\n\r\nУ кожному номері готелю \"Перлина Карпат\" є балкон із видом на гірський масив Сколівські Бескиди. Деякі помешкання оформлені з використанням дерев\'яних балок. Усі ванні кімнати укомплектовано феном.\r\n\r\nУ традиційно декорованому ресторані готелю \"Перлина Карпат\" із літньою терасою подають страви європейської та української кухонь. Місцеві та імпортні напої можна придбати у барі \"Млин\".\r\n\r\nГості готелю \"Перлина Карпат\" матимуть нагоду відпочити в сауні, поплавати у відкритому басейні з підігрівом або пограти в більярд в ігровій кімнаті. До ваших послуг лижне спорядження, а також дитячий майданчик.\r\n\r\nЗа 20 хвилин ходьби від готелю \"Перлина Карпат\" розташований залізничний вокзал селища Славське, звідки можна доїхати до Львова. На поїздку до Міжнародного аеропорту \"Львів\" у вас піде 2 години. Гостям пропонуються послуги трансферу.'),(6,7,NULL,NULL,'Adagio Paris Opéra is an apartment-style hotel located just steps from the Opera Garnier in Paris’s 9th arrondissement (district). It offers self-catering apartments for long or short stays.\r\n\r\nThe studio and 2-room apartments are fully furnished and equipped with a kitchenette with a microwave, refrigerator, hot plates, tea and coffee maker and a dishwasher. They also have flat-screen TV with international channels and a Wi-Fi internet connection.\r\n\r\nBreakfast is served daily in the breakfast room in the Adiago Paris Opera. Laundry service is available at an additional charge and there is also a dry cleaning service.\r\n\r\nThe reception at the Adiago is open 24 hours a day and can greet you in French or English.','Апарт-готель Adagio Paris Opéra розташований у 9 окрузі Парижа, за кілька кроків від Опери Гарньє. До послуг гостей апартаменти із власною кухнею для тривалого або короткочасного перебування.\r\n\r\nНомери-студіо та двокімнатні апартаменти - повністю мебльовані та обладнані міні-кухнею з мікрохвильовою піччю, холодильником, плитою, засобами для приготування чаю та кави і посудомийною машиною. У номерах є телевізор із плоским екраном і міжнародними телеканалами, а також бездротовий доступ до Інтернету (Wi-Fi).\r\n\r\nУ залі для сніданків апарт-готелю Adiago Paris Opera щоранку подається сніданок. За додаткову оплату гості зможуть скористатися послугами пральні та хімчистки.\r\n\r\nПрацівники цілодобової стійки реєстрації гостей розмовляють французькою та англійською мовами.');
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
  `email` varchar(50) NOT NULL,
  `admin_id` int(10) unsigned DEFAULT NULL,
  `last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `password` char(32) CHARACTER SET latin1 NOT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `registration_date` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `manager_admin` (`admin_id`),
  CONSTRAINT `manager_admin` FOREIGN KEY (`admin_id`) REFERENCES `admin` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manager`
--

LOCK TABLES `manager` WRITE;
/*!40000 ALTER TABLE `manager` DISABLE KEYS */;
INSERT INTO `manager` VALUES (2,'Karina','Bella','bela@yahoo.com',1,'2014-03-10 13:39:11','02a679774c0158d5a6efd9f07b9ad76d','095933744','2014-02-01'),(15,'Oleksandr','Kolchenko','ol_kol@ukr.net',NULL,'2014-03-19 09:26:19','1e47a90fcc9c5b35508a4cda5900b081','','2014-03-19'),(16,'Anton','Davydjuk','davydjuk@gmail.com',1,'2014-03-19 09:33:00','1e27af962f610ccd0f97161e72c6c2a4','','2014-03-19'),(17,'Maks','Ivschyn','ivschyn@ukr.net',1,'2014-03-19 09:33:05','21dc62ca4082398be2331da5640913be','','2014-03-19'),(18,'Mykola','Trush','trusch@gmail.com',NULL,'2014-03-19 09:30:14','a9f47c4c9f1a31b868c48e44b1c5548c','','2014-03-19');
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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manager_hotel`
--

LOCK TABLES `manager_hotel` WRITE;
/*!40000 ALTER TABLE `manager_hotel` DISABLE KEYS */;
INSERT INTO `manager_hotel` VALUES (3,2,3),(4,15,4),(5,16,5),(6,17,6),(7,18,7);
/*!40000 ALTER TABLE `manager_hotel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `manager_message`
--

DROP TABLE IF EXISTS `manager_message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `manager_message` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `manager_id` int(10) unsigned NOT NULL,
  `type` smallint(6) NOT NULL,
  `message` text CHARACTER SET latin1 NOT NULL,
  `status` smallint(6) NOT NULL,
  `last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `manager_message_manager` (`manager_id`),
  CONSTRAINT `manager_message_manager` FOREIGN KEY (`manager_id`) REFERENCES `manager` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manager_message`
--

LOCK TABLES `manager_message` WRITE;
/*!40000 ALTER TABLE `manager_message` DISABLE KEYS */;
/*!40000 ALTER TABLE `manager_message` ENABLE KEYS */;
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
  `name_en` varchar(100) DEFAULT NULL,
  `name_ua` varchar(100) DEFAULT NULL,
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
  `name_en` varchar(70) NOT NULL,
  `name_ua` varchar(50) DEFAULT NULL,
  `cost` int(10) unsigned NOT NULL,
  `number_of_rooms` tinyint(4) NOT NULL COMMENT 'Number of rooms in this room type',
  `number_of_people` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `room_hotel` (`hotel_id`),
  CONSTRAINT `room_hotel` FOREIGN KEY (`hotel_id`) REFERENCES `hotel` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room`
--

LOCK TABLES `room` WRITE;
/*!40000 ALTER TABLE `room` DISABLE KEYS */;
INSERT INTO `room` VALUES (1,1,'plaza',NULL,2000,3,NULL),(2,2,'lux',NULL,2100,5,NULL),(3,3,'Standard Double or Twin Room','Стандартний двомісний номер/номер Твін',600,5,2),(4,3,'Standard Triple Room ','Стандартний тримісний номер ',950,3,3),(5,3,'Junior Suite ','Напівлюкс ',1200,1,2),(6,3,'Suite ','Люкс',1600,1,2),(7,4,'Standard Double or Twin Room','Стандартний двомісний номер/номер Твін',600,1,2),(8,4,'Comfort Double or Twin Room ','Двомісний номер \"Комфорт\"/Номер Твін',700,1,2),(9,4,'Studio','Номер-студіо ',800,1,2),(10,4,'Junior Suite','Напівлюкс',900,1,2),(11,4,'Junior Suite with City View','Напівлюкс з видом на місто',900,1,2),(12,4,' Suite','Люкс',1100,1,2),(13,5,'Twin Room with Shared Bathroom ','Номер Твін зі спільною ванною кімнатою ',350,3,2),(14,5,'Standard Double or Twin Room ','Стандартний двомісний номер/номер Твін ',600,3,2),(15,5,'Superior Double or Twin Room','Покращений двомісний номер/номер Твін ',650,3,2),(16,5,'Family Room','Сімейний номер ',880,3,3),(17,5,'Superior Triple Room','Покращений тримісний номер ',1030,3,3),(18,6,'Standard Twin Room ','Стандартний номер Твін ',330,5,2),(19,6,'Junior Suite','Напівлюкс ',410,2,2),(20,6,'Family Junior Suite','Сімейний напівлюкс ',450,3,2),(21,6,'Suite','Люкс',550,3,2),(22,7,'Studio (2 Adults) ','Номер-студіо (для 2 дорослих) ',2686,7,2),(23,7,'One-Bedroom Apartment (4 Adults)','Апартаменти з однією спальнею (4 дорослих) ',3995,7,4);
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
  `name_en` varchar(100) DEFAULT NULL,
  `name_ua` varchar(100) DEFAULT NULL,
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
-- Table structure for table `street`
--

DROP TABLE IF EXISTS `street`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `street` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name_en` varchar(50) DEFAULT NULL,
  `name_ua` varchar(50) DEFAULT NULL,
  `city_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `street_city` (`city_id`),
  CONSTRAINT `street_city` FOREIGN KEY (`city_id`) REFERENCES `city` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `street`
--

LOCK TABLES `street` WRITE;
/*!40000 ALTER TABLE `street` DISABLE KEYS */;
INSERT INTO `street` VALUES (1,'somestreet',NULL,1),(2,'Staroznesenska Street','Вулиця Старознесенська',1),(3,'Virmenska Street','Вулиця Вірменська',1),(4,'Pl.Mickiewich','Пл. Міцкевича',1),(5,'Franka Street','Вулиця Франка',4),(6,'Rue De Caumartin',NULL,10);
/*!40000 ALTER TABLE `street` ENABLE KEYS */;
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
  `email` varchar(50) NOT NULL,
  `password` char(32) CHARACTER SET latin1 NOT NULL,
  `phone` varchar(30) DEFAULT NULL,
  `registration_date` date NOT NULL,
  `registered` bit(1) DEFAULT NULL,
  `blocked` bit(1) DEFAULT NULL,
  `last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Ketrin','Bern','kb@hotmail.com','c4053b7f78bb53d5ab11f528ed4b69f2',NULL,'2012-11-12','','','2014-03-10 11:12:46'),(2,'Andrew','Kembl','anre@epam.com','ddf91a5f7aa8f2b1a85568450fd28e88',NULL,'2013-11-13','',NULL,'2014-03-10 11:16:05'),(8,'Oleksa','Skorokhoda','oleksa-sow@ukr.net','21a7ae279180072f3c9501aa863d4ebc',NULL,'2014-03-11','',NULL,'2014-03-11 10:17:15'),(9,'New','User','newuser@yahoo.com','5222049f01cedc7786b13642826cae99',NULL,'2014-03-11','',NULL,'2014-03-11 10:21:44');
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

-- Dump completed on 2014-03-19 12:22:48
