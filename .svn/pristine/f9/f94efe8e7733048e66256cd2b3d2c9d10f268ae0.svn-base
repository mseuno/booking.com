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
  `local_id` int(10) unsigned NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `country_id` int(10) unsigned NOT NULL,
  `region_id` int(10) unsigned DEFAULT NULL,
  `name_en` varchar(100) DEFAULT NULL,
  `name_ua` varchar(100) DEFAULT NULL,
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
INSERT INTO `city` VALUES (1,0,NULL,245,13,'Lviv','Львів'),(3,0,NULL,245,13,'Truskavets','Трускавець'),(4,0,NULL,245,13,'Slavske','Славське'),(5,0,NULL,245,13,'Zhovkva','Жовква'),(6,0,NULL,245,13,'Bryukhovychi','Брюховичі'),(7,0,NULL,245,9,'Kyiv','Київ'),(8,0,NULL,245,9,'Boryspil','Бориспіль'),(9,0,NULL,245,9,'Brovary','Бровари'),(10,0,NULL,83,31,'Paris','Париж'),(11,0,NULL,83,NULL,'Nice','Ніцца'),(12,0,NULL,83,NULL,'Cannes','Канни'),(13,0,NULL,83,43,'Lyon','Ліон'),(14,0,NULL,83,43,'Annecy','Аннесі');
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
  `local_id` int(10) unsigned NOT NULL,
  `name` varchar(50) DEFAULT NULL,
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
INSERT INTO `country` VALUES (1,0,NULL,'Afghanista','Афганістан'),(2,0,NULL,'Aland Islands','Аландські острови'),(3,0,NULL,'Albania','Албанія'),(4,0,NULL,'Algeria','Алжир'),(5,0,NULL,'American Samoa','Американське Самоа'),(6,0,NULL,'Andorra','Андорра'),(7,0,NULL,'Angola','Ангола'),(8,0,NULL,'Anguilla','Ангілья'),(9,0,NULL,'Antarctica','Антарктида'),(10,0,NULL,'Antigua and Barbuda','Антигуа і Барбуда'),(11,0,NULL,'Argentina','Аргентина'),(12,0,NULL,'Armenia','Вірменія'),(13,0,NULL,'Aruba','Аруба'),(14,0,NULL,'Ascension Island','Острів Вознесіння'),(15,0,NULL,'Australia','Австралія'),(16,0,NULL,'Austria','Австрія'),(17,0,NULL,'Azerbaijan','Азербайджан'),(18,0,NULL,'Bahamas','Багами'),(19,0,NULL,'Bahrain','Бахрейн'),(20,0,NULL,'Bangladesh','Бангладеш'),(21,0,NULL,'Barbados','Барбадос'),(22,0,NULL,'Belarus','Білорусь'),(23,0,NULL,'Belgium','Бельгія'),(24,0,NULL,'Belize','Беліз'),(25,0,NULL,'Benin','Бенін'),(26,0,NULL,'Bermuda','Бермуди'),(27,0,NULL,'Bhutan','Бутан'),(28,0,NULL,'Bolivia','Болівія'),(29,0,NULL,'Bonaire, Sint Eustatius, and Saba',NULL),(30,0,NULL,'Bosnia and Herzegovina','Боснія і Герцоговина'),(31,0,NULL,'Botswana','Ботсвана'),(32,0,NULL,'Bouvet Island','Острів Буве'),(33,0,NULL,'Brazil','Бразилія'),(34,0,NULL,'British Indian Ocean Territory','Британські території Індійського океану'),(35,0,NULL,'British Virgin Islands','Віргінські острови Британії'),(36,0,NULL,'Brunei','Бруней'),(37,0,NULL,'Bulgaria','Болгарія'),(38,0,NULL,'Burkina Faso','Буркіна-Фасо'),(39,0,NULL,'Burundi','Бурунді'),(40,0,NULL,'Cambodia','Камбоджа'),(41,0,NULL,'Cameroon','Камерун'),(42,0,NULL,'Canada','Канада'),(43,0,NULL,'Canary Islands','Канарські острови'),(44,0,NULL,'Cape Verde','Кабо-Верде'),(45,0,NULL,'Cayman Islands','Кайманові острови'),(46,0,NULL,'Central African Republic','Центральноафриканська республіка'),(47,0,NULL,'Ceuta and Melilla','Сеута і Мелілья'),(48,0,NULL,'Chad','Чад'),(49,0,NULL,'Chile','Чілі'),(50,0,NULL,'China','Китай'),(51,0,NULL,'Christmas Island','Острів Різдва'),(52,0,NULL,'Clipperton Island','Острів Кліппертон'),(53,0,NULL,'Cocos [Keeling] Islands','Кокосові острови'),(54,0,NULL,'Colombia','Колумбія'),(55,0,NULL,'Comoros','Коморські острови'),(56,0,NULL,'Congo - Brazzaville','Конґо - Браззавіль'),(57,0,NULL,'Congo - Kinshasa','Конґо - Кіншаса'),(58,0,NULL,'Cook Islands','Острови Кука'),(59,0,NULL,'Costa Rica','Коста-Рика'),(60,0,NULL,'Côte d’Ivoire','Кот д\'Івуар'),(61,0,NULL,'Croatia','Хорватія'),(62,0,NULL,'Cuba','Куба'),(63,0,NULL,'Curaçao',NULL),(64,0,NULL,'Cyprus','Кіпр'),(65,0,NULL,'Czech Republic','Чеська республіка'),(66,0,NULL,'Denmark','Данія'),(67,0,NULL,'Diego Garcia','Дієґо-Ґарсія'),(68,0,NULL,'Djibouti','Джібуті'),(69,0,NULL,'Dominica','Домінік'),(70,0,NULL,'Dominican Republic','Домініканська Республіка'),(71,0,NULL,'Ecuador','Еквадор'),(72,0,NULL,'Egypt','Єгипет'),(73,0,NULL,'El Salvador','Сальвадор'),(74,0,NULL,'Equatorial Guinea','Екваторіальна Гвінея'),(75,0,NULL,'Eritrea','Еритрея'),(76,0,NULL,'Estonia','Естонія'),(77,0,NULL,'Ethiopia','Ефіопія'),(78,0,NULL,'European Union','Європейський Союз'),(79,0,NULL,'Falkland Islands','Фолклендські острови'),(80,0,NULL,'Faroe Islands','Фарерські острови'),(81,0,NULL,'Fiji','Фіджі'),(82,0,NULL,'Finland','Фінляндія'),(83,0,NULL,'France','Франція'),(84,0,NULL,'French Guiana','Французька Гвіана'),(85,0,NULL,'French Polynesia','Французька Полінезія'),(86,0,NULL,'French Southern Territories','Французькі Південні Території'),(87,0,NULL,'Gabon','Габон'),(88,0,NULL,'Gambia','Гамбія'),(89,0,NULL,'Georgia','Грузія'),(90,0,NULL,'Germany','Німеччина'),(91,0,NULL,'Ghana','Гана'),(92,0,NULL,'Gibraltar','Гібралтар'),(93,0,NULL,'Greece','Греція'),(94,0,NULL,'Greenland','Гренландія'),(95,0,NULL,'Grenada','Гренада'),(96,0,NULL,'Guadeloupe','Гваделупа'),(97,0,NULL,'Guam','Гуам'),(98,0,NULL,'Guatemala','Гватемала'),(99,0,NULL,'Guernsey','Гернсі'),(100,0,NULL,'Guinea','Гвінея'),(101,0,NULL,'Guinea-Bissau','Гвінея-Біссау'),(102,0,NULL,'Guyana','Гайана'),(103,0,NULL,'Haiti','Гаїті'),(104,0,NULL,'Heard Island and McDonald Islands','Острови Херд і Мак-Дональд'),(105,0,NULL,'Honduras','Гондурас'),(106,0,NULL,'Hong Kong SAR China','Гонконґ О.А.Р. Китаю'),(107,0,NULL,'Hungary','Угорщина'),(108,0,NULL,'Iceland','Ісландія'),(109,0,NULL,'India','Індія'),(110,0,NULL,'Indonesia','Індонезія'),(111,0,NULL,'Iran','Іран'),(112,0,NULL,'Iraq','Ірак'),(113,0,NULL,'Ireland','Ірландія'),(114,0,NULL,'Isle of Man','Острів Мен'),(115,0,NULL,'Israel','Ізраїль'),(116,0,NULL,'Italy','Італія'),(117,0,NULL,'Jamaica','Ямайка'),(118,0,NULL,'Japan','Японія'),(119,0,NULL,'Jersey','Джерсі'),(120,0,NULL,'Jordan','Йорданія'),(121,0,NULL,'Kazakhstan','Казахстан'),(122,0,NULL,'Kenya','Кенія'),(123,0,NULL,'Kiribati','Кірибаті'),(124,0,NULL,'Kuwait','Кувейт'),(125,0,NULL,'Kyrgyzstan','Киргизстан'),(126,0,NULL,'Laos','Лаос'),(127,0,NULL,'Latvia','Латвія'),(128,0,NULL,'Lebanon','Ліван'),(129,0,NULL,'Lesotho','Лесото'),(130,0,NULL,'Liberia','Ліберія'),(131,0,NULL,'Libya','Лівія'),(132,0,NULL,'Liechtenstein','Ліхтенштейн'),(133,0,NULL,'Lithuania','Литва'),(134,0,NULL,'Luxembourg','Люксембург'),(135,0,NULL,'Macau SAR China','Макао О.А.Р. Китаю'),(136,0,NULL,'Macedonia','Македонія'),(137,0,NULL,'Madagascar','Мадагаскар'),(138,0,NULL,'Malawi','Малаві'),(139,0,NULL,'Malaysia','Малайзія'),(140,0,NULL,'Maldives','Мальдіви'),(141,0,NULL,'Mali','Малі'),(142,0,NULL,'Malta','Мальта'),(143,0,NULL,'Marshall Islands','Маршаллові Острови'),(144,0,NULL,'Martinique','Мартиніка'),(145,0,NULL,'Mauritania','Мавританія'),(146,0,NULL,'Mauritius','Маврикій'),(147,0,NULL,'Mayotte','Майот'),(148,0,NULL,'Mexico','Мексика'),(149,0,NULL,'Micronesia','Мікронезія'),(150,0,NULL,'Moldova','Молдова'),(151,0,NULL,'Monaco','Монако'),(152,0,NULL,'Mongolia','Монголія'),(153,0,NULL,'Montenegro','Чорногорія'),(154,0,NULL,'Montserrat','Монсеррат'),(155,0,NULL,'Morocco','Марокко'),(156,0,NULL,'Mozambique','Мозамбік'),(157,0,NULL,'Myanmar [Burma]','М\'янма [Бірма]'),(158,0,NULL,'Namibia','Намібія'),(159,0,NULL,'Nauru','Науру'),(160,0,NULL,'Nepal','Непал'),(161,0,NULL,'Netherlands','Нідерланди'),(162,0,NULL,'Netherlands Antilles','Нідерландські Антильські Остови'),(163,0,NULL,'New Caledonia','Нова Каледонія'),(164,0,NULL,'New Zealand','Нова Зеландія'),(165,0,NULL,'Nicaragua','Нікарагуа'),(166,0,NULL,'Niger','Нігер'),(167,0,NULL,'Nigeria','Нігерія'),(168,0,NULL,'Niue','Нія'),(169,0,NULL,'Norfolk Island','Острів Норфолк'),(170,0,NULL,'North Korea','Північна Корея'),(171,0,NULL,'Northern Mariana Islands','Північні Маріанські Острови'),(172,0,NULL,'Norway','Норвегія'),(173,0,NULL,'Oman','Оман'),(174,0,NULL,'Outlying Oceania','Інша Океанія'),(175,0,NULL,'Pakistan','Пакистан'),(176,0,NULL,'Palau','Палау'),(177,0,NULL,'Palestinian Territories','Палестина'),(178,0,NULL,'Panama','Панама'),(179,0,NULL,'Papua New Guinea','Папуа Нова Гвінея'),(180,0,NULL,'Paraguay','Парагвай'),(181,0,NULL,'Peru','Перу'),(182,0,NULL,'Philippines','Філіппіни'),(183,0,NULL,'Pitcairn Islands','Острови Піткерн'),(184,0,NULL,'Poland','Польща'),(185,0,NULL,'Portugal','Португалія'),(186,0,NULL,'Puerto Rico','Пуерто-Ріко'),(187,0,NULL,'Qatar','Катар'),(188,0,NULL,'Réunion','Реюньйон'),(189,0,NULL,'Romania','Ромунія'),(190,0,NULL,'Russia','Росія'),(191,0,NULL,'Rwanda','Руанда'),(192,0,NULL,'Saint Barthélemy','Острів Святого Бартоломея'),(193,0,NULL,'Saint Helena','Острів Святої Єлени'),(194,0,NULL,'Saint Kitts and Nevis','Сент-Кітс і Невіс'),(195,0,NULL,'Saint Lucia','Сент-Люсія'),(196,0,NULL,'Saint Martin','Острів Святого Мартіна'),(197,0,NULL,'Saint Pierre and Miquelon','Сен-П\'єр і Мікелон'),(198,0,NULL,'Saint Vincent and the Grenadines','Сент-Вінсент і Гренадини'),(199,0,NULL,'Samoa','Самоа'),(200,0,NULL,'San Marino','Сан-Марино'),(201,0,NULL,'São Tomé and Príncipe','Сан-Томе і Прінсіпі'),(202,0,NULL,'Saudi Arabia','Саудівська Аравія'),(203,0,NULL,'Senegal','Сенегал'),(204,0,NULL,'Serbia','Сербія'),(205,0,NULL,'Serbia and Montenegro','Сербія та Чорногорія'),(206,0,NULL,'Seychelles','Сейшели'),(207,0,NULL,'Sierra Leone','Сьєрра-Леоне'),(208,0,NULL,'Singapore','Сінгапур'),(209,0,NULL,'Sint Maarten',NULL),(210,0,NULL,'Slovakia','Словаччина'),(211,0,NULL,'Slovenia','Словенія'),(212,0,NULL,'Solomon Islands','Соломонові Острови'),(213,0,NULL,'Somalia','Сомалі'),(214,0,NULL,'South Africa','ПАР'),(215,0,NULL,'South Georgia and the South Sandwich Islands','Південна Джорджія та Південні Сандвічеві Острови'),(216,0,NULL,'South Korea','Південна Корея'),(217,0,NULL,'South Sudan',NULL),(218,0,NULL,'Spain','Іспанія'),(219,0,NULL,'Sri Lanka','Шрі-Ланка'),(220,0,NULL,'Sudan','Судан'),(221,0,NULL,'Suriname','Суринам'),(222,0,NULL,'Svalbard and Jan Mayen','Острови Свальбард та Ян-Маєн'),(223,0,NULL,'Swaziland','Свазіленд'),(224,0,NULL,'Sweden','Швеція'),(225,0,NULL,'Switzerland','Швейцарія'),(226,0,NULL,'Syria','Сирія'),(227,0,NULL,'Taiwan','Тайвань'),(228,0,NULL,'Tajikistan','Таджикистан'),(229,0,NULL,'Tanzania','Танзанія'),(230,0,NULL,'Thailand','Таїланд'),(231,0,NULL,'Timor-Leste','Тімор-Лешті'),(232,0,NULL,'Togo','Того'),(233,0,NULL,'Tokelau','Токелау'),(234,0,NULL,'Tonga','Тонга'),(235,0,NULL,'Trinidad and Tobago','Тринідад і Тобаго'),(236,0,NULL,'Tristan da Cunha','Трістан-да-Кунья'),(237,0,NULL,'Tunisia','Туніс'),(238,0,NULL,'Turkey','Туреччина'),(239,0,NULL,'Turkmenistan','Туркменистан'),(240,0,NULL,'Turks and Caicos Islands','Теркс і Кайкос'),(241,0,NULL,'Tuvalu','Тувалу'),(242,0,NULL,'U.S. Minor Outlying Islands','Віддалені острови США'),(243,0,NULL,'U.S. Virgin Islands','Віргінські острови США'),(244,0,NULL,'Uganda','Уганда'),(245,0,NULL,'Ukraine','Україна'),(246,0,NULL,'United Arab Emirates','Об\'єднані Арабські Емірати'),(247,0,NULL,'United Kingdom','Великобританія'),(248,0,NULL,'United States','США'),(249,0,NULL,'Uruguay','Уругвай'),(250,0,NULL,'Uzbekistan','Узбекистан'),(251,0,NULL,'Vanuatu','Вануату'),(252,0,NULL,'Vatican City','Ватикан'),(253,0,NULL,'Venezuela','Венесуела'),(254,0,NULL,'Vietnam','В\'єтнам'),(255,0,NULL,'Wallis and Futuna','Уолліс і Футуна'),(256,0,NULL,'Western Sahara','Західна Сахара'),(257,0,NULL,'Yemen','Ємен'),(258,0,NULL,'Zambia','Замбія'),(259,0,NULL,'Zimbabwe','Зімбабве');
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
  `local_id` int(10) DEFAULT NULL,
  `short_info_en` varchar(255) DEFAULT NULL,
  `short_info_ua` varchar(255) DEFAULT NULL,
  `extended_info_en` text CHARACTER SET utf8 COLLATE utf8_unicode_ci,
  `extended_info_ua` text CHARACTER SET utf8 COLLATE utf8_unicode_ci,
  `name` varchar(100) DEFAULT NULL,
  `short_info` varchar(255) DEFAULT NULL,
  `extended_info` text CHARACTER SET latin1,
  PRIMARY KEY (`id`),
  CONSTRAINT `hotel_info_hotel` FOREIGN KEY (`id`) REFERENCES `hotel` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hotel_info`
--

LOCK TABLES `hotel_info` WRITE;
/*!40000 ALTER TABLE `hotel_info` DISABLE KEYS */;
INSERT INTO `hotel_info` VALUES (1,1,NULL,'Little hotel in Brodu',NULL,'extended info about hotel id=1',NULL,NULL,NULL,NULL),(2,3,NULL,NULL,NULL,'Offering a tennis court and a terrace, Boutique Hotel Kavalier offers elegant, soundproof rooms in Lviv, a 5-minute drive from the city centre. WiFi is free in all areas.\r\n\r\nThe rooms each come with heating, a satellite flat-screen TV, and private bathroom with bathrobes and free toiletries. They have luxurious décor, carpeted floors, and bright interiors.\r\n\r\nBuffet breakfast is served every morning, and the on-site restaurant serves European cuisine. Guests can enjoy green lawns encircling the hotel and beyond that are the parklands.\r\n\r\nRynok Square is 3 km from the property, and Opera Theatre is a 6-minute drive from Hotel Kavalier, while Lviv Airport is 10 km away.','Бутик-готель Kavalier розміщений у Львові, за 5 хвилин їзди від центру міста. До послуг гостей тенісний корт, тераса, а також елегантні звуконепроникні номери. В усіх приміщеннях закладу безкоштовно надається Wi-Fi.\r\n\r\nКожен номер забезпечений опаленням, телевізором із плоским екраном і супутниковими каналами, а також окремою ванною кімнатою, укомплектованою халатами й безкоштовними туалетно-косметичними засобами. Вони вирізняються килимовим покриттям підлоги, розкішним оформленням та світлим інтер\'єром.\r\n\r\nЩоранку гостям подається сніданок \"шведський стіл\", а готельний ресторан спеціалізується на європейській кухні. Гості отримають можливість прогулятися на зеленій галявині навколо готелю та у лісі в межах паркової зони по сусідству.\r\n\r\nПлоща Ринок розташована за 3 км від готелю Kavalier, Оперний театр - за 6 хвилин їзди, а аеропорт Львова - за 10 км.',NULL,NULL,NULL),(3,4,NULL,NULL,NULL,'Set in the heart of Lviv, just steps to the Opera Theatre and Ploshcha Rynok, Rudolfo offers elegant rooms with free Wi-Fi. It features a terrace with panoramic views of Lviv.\r\n\r\nThe comfortable rooms feature bright décor and modern furnishings. They offer a flat-screen satellite TV. The private bathrooms come with a bath or shower, hairdryer and free toiletries. Some rooms have a balcony.\r\n\r\nThe café at Rudolfo serves breakfast. Laundry and ironing services are available. The Church of Assumption is a 5-minute walk away.\r\n\r\nLviv Train Station is 3.5 km from the hotel, while Lviv Airport is 6.5 km away.','Готель \"Рудольфо\" розташований у самому центрі Львова, за декілька кроків від Оперного театру й Площі Ринок. До послуг гостей елегантні номери з безкоштовним Wi-Fi, а також тераса з панорамним видом на місто.\r\n\r\nКомфортабельні номери оформлені в світлих тонах й обставлені сучасними меблями. У кожному з них є телевізор із плоским екраном і супутниковим телебаченням та окрема ванна кімната з ванною або душем, феном і безкоштовними туалетно-косметичними засобами. Деякі номери мають балкон.\r\n\r\nСніданок подають у кав\'ярні готелю \"Рудольфо\". Гості можуть скористатися послугами пральні й прасування одягу. За 5 хвилин звідси можна дійти до церкви Успіння Пресвятої Богородиці.\r\n\r\nВідстань від готелю до залізничного вокзалу Львова становить 3,5 км. Аеропорт міста розміщений за 6,5 км.',NULL,NULL,NULL),(4,5,NULL,NULL,NULL,'George Hotel is situated in a grand building in Lviv, overlooking the Adam Mickiewicz Statue. The Opera House and City Hall Square are approximately a 2-minute walk from the hotel.\r\n\r\nThe ornate rooms at Hotel George have elegant, antique-style furnishings. Each is equipped with cable TV, free Wi-Fi and a private bathroom. Some rooms enjoy seating areas.\r\n\r\nThe in-house restaurant, with its high ceilings and ambient lighting, is an ideal place for enjoying lunch or dinner.\r\n\r\nThe George has a 24-hour reception and tour desk on site.','Готель George розташований у Львові, у величній будівлі з видом на пам\'ятник Адаму Міцкевичу. Піша прогулянка від готелю до Оперного театру і Ратушної площі триватиме приблизно 2 хвилини.\r\n\r\nРозкішно оформлені номери готелю George обставлені вишуканими меблями у античному стилі. Кожний номер оснащений кабельним телебаченням, безкоштовним Wi-Fi і окремою ванною кімнатою. Деякі номери налічують зону відпочинку.\r\n\r\nРесторан готелю з високою стелею і чудовим освітленням буде найкращим місцем для обіду або вечері.\r\n\r\nВ готелі George працює цілодобова стійка реєстрації гостей і туристичне бюро.\r\n\r\nЗа запитом для гостей організовують трансфери до міжнародного аеропорту Львова.',NULL,NULL,NULL),(5,6,NULL,NULL,NULL,'Located 300 metres from the ski lifts of Slavske Ski Resort, this hotel offers a heated swimming pool and rooms with a TV. A sauna, free Wi-Fi and a Carpathian-style bar can be found on site.\r\n\r\nEvery room at Perlyna Karpat Hotel features a balcony overlooking the Skole Beskids range. Some rooms have exposed wooden beams, and all bathrooms include a hairdryer.\r\n\r\nPerlyna’s traditionally decorated restaurant with a summer terrace serves European and Ukrainian cuisine. Local drinks and international beverages are offered at Mlyn Bar.\r\n\r\nGuests of Perlyna Karpat Hotel can relax in the sauna, take a dip in the heated outdoor swimming pool, or play billiards in the games room. Ski facilities are also provided, and there is a children’s playground.\r\n\r\nSlavske Train Station, offering access to Lviv, is 20 minutes’ walk from Perlyna Karpat Hotel. Lviv International Airport is 2 hours’ drive away, and a transfer service is available.','Цей готель розташований за 300 метрів від підйомників гірськолижного курорту Славське. На його території є басейн з підігрівом, сауна і бар в карпатському стилі. До послуг гостей номери з телевізором і безкоштовний Wi-Fi.\r\n\r\nУ кожному номері готелю \"Перлина Карпат\" є балкон із видом на гірський масив Сколівські Бескиди. Деякі помешкання оформлені з використанням дерев\'яних балок. Усі ванні кімнати укомплектовано феном.\r\n\r\nУ традиційно декорованому ресторані готелю \"Перлина Карпат\" із літньою терасою подають страви європейської та української кухонь. Місцеві та імпортні напої можна придбати у барі \"Млин\".\r\n\r\nГості готелю \"Перлина Карпат\" матимуть нагоду відпочити в сауні, поплавати у відкритому басейні з підігрівом або пограти в більярд в ігровій кімнаті. До ваших послуг лижне спорядження, а також дитячий майданчик.\r\n\r\nЗа 20 хвилин ходьби від готелю \"Перлина Карпат\" розташований залізничний вокзал селища Славське, звідки можна доїхати до Львова. На поїздку до Міжнародного аеропорту \"Львів\" у вас піде 2 години. Гостям пропонуються послуги трансферу.',NULL,NULL,NULL),(6,7,NULL,NULL,NULL,'Adagio Paris Opéra is an apartment-style hotel located just steps from the Opera Garnier in Paris’s 9th arrondissement (district). It offers self-catering apartments for long or short stays.\r\n\r\nThe studio and 2-room apartments are fully furnished and equipped with a kitchenette with a microwave, refrigerator, hot plates, tea and coffee maker and a dishwasher. They also have flat-screen TV with international channels and a Wi-Fi internet connection.\r\n\r\nBreakfast is served daily in the breakfast room in the Adiago Paris Opera. Laundry service is available at an additional charge and there is also a dry cleaning service.\r\n\r\nThe reception at the Adiago is open 24 hours a day and can greet you in French or English.','Апарт-готель Adagio Paris Opéra розташований у 9 окрузі Парижа, за кілька кроків від Опери Гарньє. До послуг гостей апартаменти із власною кухнею для тривалого або короткочасного перебування.\r\n\r\nНомери-студіо та двокімнатні апартаменти - повністю мебльовані та обладнані міні-кухнею з мікрохвильовою піччю, холодильником, плитою, засобами для приготування чаю та кави і посудомийною машиною. У номерах є телевізор із плоским екраном і міжнародними телеканалами, а також бездротовий доступ до Інтернету (Wi-Fi).\r\n\r\nУ залі для сніданків апарт-готелю Adiago Paris Opera щоранку подається сніданок. За додаткову оплату гості зможуть скористатися послугами пральні та хімчистки.\r\n\r\nПрацівники цілодобової стійки реєстрації гостей розмовляють французькою та англійською мовами.',NULL,NULL,NULL);
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
-- Table structure for table `locale`
--

DROP TABLE IF EXISTS `locale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `locale` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `local` varchar(3) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `locale`
--

LOCK TABLES `locale` WRITE;
/*!40000 ALTER TABLE `locale` DISABLE KEYS */;
INSERT INTO `locale` VALUES (1,'en'),(2,'ua');
/*!40000 ALTER TABLE `locale` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manager`
--

LOCK TABLES `manager` WRITE;
/*!40000 ALTER TABLE `manager` DISABLE KEYS */;
INSERT INTO `manager` VALUES (2,'Karina','Bella','bela@yahoo.com',1,'2014-03-10 13:39:11','02a679774c0158d5a6efd9f07b9ad76d','095933744','2014-02-01'),(15,'Oleksandr','Kolchenko','ol_kol@ukr.net',NULL,'2014-03-19 09:26:19','1e47a90fcc9c5b35508a4cda5900b081','','2014-03-19'),(16,'Anton','Davydjuk','davydjuk@gmail.com',1,'2014-03-19 09:33:00','1e27af962f610ccd0f97161e72c6c2a4','','2014-03-19'),(17,'Maks','Ivschyn','ivschyn@ukr.net',1,'2014-03-19 09:33:05','21dc62ca4082398be2331da5640913be','','2014-03-19'),(18,'Mykola','Trush','trusch@gmail.com',NULL,'2014-03-19 09:30:14','a9f47c4c9f1a31b868c48e44b1c5548c','','2014-03-19'),(19,'ÐÐ»ÐµÐºÑÐ°','Ð¡ÐºÐ¾ÑÐ¾ÑÐ¾Ð´Ð°','oollld@ukr.net',NULL,'2014-03-19 16:54:01','5aa5acc0b4ec0c24e4b863b5c91b4c61','','2014-03-19'),(20,'ÑÐ²ÑÑÐ²ÑÐ²','ÑÑÐ²ÑÑÐ²','babax@abbax.zxcx',NULL,'2014-03-19 16:57:45','95b60fc507f202249164cff479be1a7f','ÑÐ²Ð°ÑÐ²Ð°Ñ','2014-03-19');
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
  `local_id` int(10) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
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
INSERT INTO `region` VALUES (1,'Vinnytsia Oblast','Вінницька область',245,NULL,NULL),(2,'Volyn Oblast','Волинська область',245,NULL,NULL),(3,'Dnipropetrovsk Oblast','Дніпропетровська область',245,NULL,NULL),(4,'Donetsk Oblast','Донецька область',245,NULL,NULL),(5,'Zhytomyr Oblast','Житомирська область',245,NULL,NULL),(6,'Zakarpattia Oblast','Закарпатська область',245,NULL,NULL),(7,'Zaporizhia Oblast','Запорізька область',245,NULL,NULL),(8,'Ivano-Frankivsk Oblast','Івано-франківська область',245,NULL,NULL),(9,'Kyiv Oblast','Київська область',245,NULL,NULL),(10,'Kirovohrad Oblast','Кіровоградська область',245,NULL,NULL),(11,'Crimea','Крим',245,NULL,NULL),(12,'Luhansk Oblast','Луганська область',245,NULL,NULL),(13,'Lviv Oblast','Львівська область',245,NULL,NULL),(14,'Mykolaiv Oblast','Миколаївська область',245,NULL,NULL),(15,'Odessa Oblast','Одеська область',245,NULL,NULL),(16,'Poltava Oblast','Полтавська область',245,NULL,NULL),(17,'Rivne Oblast','Рівненська область',245,NULL,NULL),(18,'Sumy Oblast','Сумська область',245,NULL,NULL),(19,'Ternopil Oblast','Тернопільска область',245,NULL,NULL),(20,'Kharkiv Oblast','Харківська область',245,NULL,NULL),(21,'Kherson Oblast','Херсонська область',245,NULL,NULL),(22,'Khmelnytskyi Oblast','Хмельницька область',245,NULL,NULL),(23,'Cherkasy Oblast','Черкаська область',245,NULL,NULL),(24,'Chernivtsi Oblast','Чернівецька область',245,NULL,NULL),(25,'Chernihiv Oblast','Чернігівська область',245,NULL,NULL),(31,'Ile de France','Іль-де-Франс',83,NULL,NULL),(32,'Burgundy','Бургундія',83,NULL,NULL),(33,'Upper Normandy','Верхня Нормандія',83,NULL,NULL),(34,'Corsica','Корсика',83,NULL,NULL),(35,'Languedoc-Roussillon','Лангедок-Руссільйон',83,NULL,NULL),(36,'Lorraine','Лотарингія',83,NULL,NULL),(37,'Lower Normandy','Нижня Нормандія',83,NULL,NULL),(38,'Nord-Pas-de-Calais','Нор-Па-де-Кале',83,NULL,NULL),(39,'Pays de la Loire','Пеї-де-ла-Луар',83,NULL,NULL),(40,'Provence-Alpes-Côte d\'Azur','Прованс-Альпи-Лазурний берег',83,NULL,NULL),(41,'Poitou-Charentes','Пуату-Шарант',83,NULL,NULL),(42,'Midi-Pyrénées','Південь-Піренеї',83,NULL,NULL),(43,'Rhône-Alps','Рона-Альпи',83,NULL,NULL);
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
-- Table structure for table `room_info`
--

DROP TABLE IF EXISTS `room_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `room_info` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `local_id` int(10) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room_info`
--

LOCK TABLES `room_info` WRITE;
/*!40000 ALTER TABLE `room_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `room_info` ENABLE KEYS */;
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
  `local_id` int(10) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `service`
--

LOCK TABLES `service` WRITE;
/*!40000 ALTER TABLE `service` DISABLE KEYS */;
INSERT INTO `service` VALUES (1,'Facilities for Disabled Guests','Номери/зручності для осіб з обмеженими фізичними можливостями',NULL,NULL),(2,'Restaurant','Ресторан',NULL,NULL),(3,'Internet','Інтернет',NULL,NULL),(4,'Non-smoking Rooms','Номери для некурців',NULL,NULL),(5,'Fitness Center','Фітнес-центр',NULL,NULL),(6,'Family Rooms','Сімейні номери',NULL,NULL),(7,'Pet Friendly','Допускається розміщення з домашніми тваринами',NULL,NULL),(8,'Parking','Автостоянка',NULL,NULL),(9,'Spa','Оздоровчий спа-центр',NULL,NULL),(10,'Wi-Fi','Wi-Fi',NULL,NULL),(11,'Indoor Pool','Критий плавальний басейн',NULL,NULL),(12,'Airport Shuttle','Трансфер до/з аеропорту',NULL,NULL),(13,'Free Wi-Fi','Безкоштовний Wi-Fi',NULL,NULL),(14,'Bar','Бар',NULL,NULL),(15,'Baggage Storage','Камера зберігання багажу',NULL,NULL),(16,'24-Hour Front Desk','Цілодобова стійка реєстрації гостей',NULL,NULL);
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
  `name` varchar(50) DEFAULT NULL,
  `local_id` int(10) DEFAULT NULL,
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
INSERT INTO `street` VALUES (1,'somestreet',NULL,1,NULL,NULL),(2,'Staroznesenska Street','Вулиця Старознесенська',1,NULL,NULL),(3,'Virmenska Street','Вулиця Вірменська',1,NULL,NULL),(4,'Pl.Mickiewich','Пл. Міцкевича',1,NULL,NULL),(5,'Franka Street','Вулиця Франка',4,NULL,NULL),(6,'Rue De Caumartin',NULL,10,NULL,NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Ketrin','Bern','kb@hotmail.com','c4053b7f78bb53d5ab11f528ed4b69f2',NULL,'2012-11-12','','','2014-03-10 11:12:46'),(2,'Andrew','Kembl','anre@epam.com','ddf91a5f7aa8f2b1a85568450fd28e88',NULL,'2013-11-13','',NULL,'2014-03-10 11:16:05'),(8,'Oleksa','Skorokhoda','oleksa-sow@ukr.net','21a7ae279180072f3c9501aa863d4ebc',NULL,'2014-03-11','',NULL,'2014-03-11 10:17:15'),(9,'New','User','newuser@yahoo.com','5222049f01cedc7786b13642826cae99',NULL,'2014-03-11','',NULL,'2014-03-11 10:21:44'),(10,'ÐÐ»ÐµÐºÑÐ°','Ð¡ÐºÐ¾ÑÐ¾ÑÐ¾Ð´Ð°','oooo@oo.oo','86b46f78461526ec739e3a6d4d972dc3',NULL,'2014-03-19','',NULL,'2014-03-19 18:05:00');
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

-- Dump completed on 2014-03-19 20:34:11
