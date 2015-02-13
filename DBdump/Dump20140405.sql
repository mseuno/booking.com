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
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
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
  CONSTRAINT `FK_black_list_hotel_id` FOREIGN KEY (`hotel_id`) REFERENCES `hotel` (`id`),
  CONSTRAINT `FK_black_list_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
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
  CONSTRAINT `FK_booking_hotel_id` FOREIGN KEY (`hotel_id`) REFERENCES `hotel` (`id`),
  CONSTRAINT `FK_booking_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking`
--

LOCK TABLES `booking` WRITE;
/*!40000 ALTER TABLE `booking` DISABLE KEYS */;
INSERT INTO `booking` VALUES (1,1,1,'2014-12-13','2014-12-15',2000,1,'2014-03-08 17:45:47'),(2,1,3,'2014-04-03','2014-04-09',19600,1,'2014-03-23 17:09:34'),(3,2,3,'2014-04-15','2014-04-16',1200,0,'2014-04-04 02:03:23'),(4,1,3,'2014-04-15','2014-04-19',7750,1,'2014-03-23 17:09:59'),(8,2,7,'2014-04-05','2014-04-06',18802,0,'2014-04-04 03:08:35'),(9,2,6,'2014-04-05','2014-04-06',1650,0,'2014-04-04 04:45:33');
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
  `cost` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `booking_room_room` (`room_id`),
  KEY `booking_room_hotel` (`hotel_id`),
  KEY `booking_room_booking` (`booking_id`),
  CONSTRAINT `FK_booking_room_booking_id` FOREIGN KEY (`booking_id`) REFERENCES `booking` (`id`),
  CONSTRAINT `FK_booking_room_hotel_id` FOREIGN KEY (`hotel_id`) REFERENCES `hotel` (`id`),
  CONSTRAINT `FK_booking_room_room_id` FOREIGN KEY (`room_id`) REFERENCES `room` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking_room`
--

LOCK TABLES `booking_room` WRITE;
/*!40000 ALTER TABLE `booking_room` DISABLE KEYS */;
INSERT INTO `booking_room` VALUES (1,1,1,1,2,2000),(2,2,5,3,1,8400),(3,2,6,3,1,11200),(4,3,3,3,1,1200),(5,4,3,3,1,3000),(6,4,4,3,1,4750),(7,8,22,7,7,2686),(8,9,18,6,5,330);
/*!40000 ALTER TABLE `booking_room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `city` (
  `id` int(10) unsigned NOT NULL,
  `locale_id` varchar(3) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `country_id` int(10) unsigned NOT NULL,
  `region_id` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`,`locale_id`),
  KEY `city_country` (`country_id`),
  KEY `city_region` (`region_id`),
  KEY `FK_city_locale_id` (`locale_id`),
  CONSTRAINT `FK_city_country_id` FOREIGN KEY (`country_id`) REFERENCES `country` (`id`),
  CONSTRAINT `FK_city_locale_id` FOREIGN KEY (`locale_id`) REFERENCES `locale` (`id`),
  CONSTRAINT `FK_city_region_id` FOREIGN KEY (`region_id`) REFERENCES `region` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` VALUES (1,'en','Lviv',245,13),(1,'ua','Львів',245,13),(2,'en','Truskavets',245,13),(2,'ua','Трускавець',245,13),(3,'en','Slavske',245,13),(3,'ua','Славське',245,13),(4,'en','Zhovkva',245,13),(4,'ua','Жовква',245,13),(5,'en','Bryukhovychi',245,13),(5,'ua','Брюховичі',245,13),(6,'en','Kyiv',245,9),(6,'ua','Київ',245,9),(7,'en','Boryspil',245,9),(7,'ua','Бориспіль',245,9),(8,'en','Brovary',245,9),(8,'ua','Бровари',245,9),(9,'en','Paris',83,31),(9,'ua','Париж',83,31),(10,'en','Nice',83,31),(10,'ua','Ніцца',83,31),(11,'en','Cannes',83,31),(11,'ua','Канни',83,31),(12,'en','Lyon',83,43),(12,'ua','Ліон',83,43),(13,'en','Annecy',83,43),(13,'ua','Аннесі',83,43),(14,'en','faka',246,44),(14,'ua','фака',246,44);
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `country`
--

DROP TABLE IF EXISTS `country`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `country` (
  `id` int(10) unsigned NOT NULL,
  `locale_id` varchar(3) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`,`locale_id`),
  KEY `FK_country_locale_id` (`locale_id`),
  CONSTRAINT `FK_country_locale_id` FOREIGN KEY (`locale_id`) REFERENCES `locale` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `country`
--

LOCK TABLES `country` WRITE;
/*!40000 ALTER TABLE `country` DISABLE KEYS */;
INSERT INTO `country` VALUES (83,'en','France'),(83,'ua','Франція'),(245,'en','Ukraine'),(245,'ua','Україна'),(246,'en','faka'),(246,'ua','фака');
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
  CONSTRAINT `FK_favorite_hotel_id` FOREIGN KEY (`hotel_id`) REFERENCES `hotel` (`id`),
  CONSTRAINT `FK_favorite_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `favorite`
--

LOCK TABLES `favorite` WRITE;
/*!40000 ALTER TABLE `favorite` DISABLE KEYS */;
INSERT INTO `favorite` VALUES (1,2,4);
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
  `address` varchar(20) DEFAULT NULL,
  `contact_information` text,
  `avg_rate` tinyint(4) DEFAULT '0',
  `country_id` int(10) unsigned DEFAULT NULL,
  `region_id` int(10) unsigned DEFAULT NULL,
  `city_id` int(10) unsigned DEFAULT NULL,
  `street_id` int(10) unsigned DEFAULT NULL,
  `blocked` bit(1) DEFAULT b'0',
  `logo` varchar(50) DEFAULT NULL,
  `last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `longitude` varchar(50) DEFAULT NULL,
  `latitude` varchar(50) DEFAULT NULL,
  `stars` smallint(6) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `hotel_country` (`country_id`),
  KEY `hotel_region` (`region_id`),
  KEY `hotel_city` (`city_id`),
  KEY `hotel_street` (`street_id`),
  CONSTRAINT `FK_hotel_city_id` FOREIGN KEY (`city_id`) REFERENCES `city` (`id`),
  CONSTRAINT `FK_hotel_country_id` FOREIGN KEY (`country_id`) REFERENCES `country` (`id`),
  CONSTRAINT `FK_hotel_region_id` FOREIGN KEY (`region_id`) REFERENCES `region` (`id`),
  CONSTRAINT `FK_hotel_street_id` FOREIGN KEY (`street_id`) REFERENCES `street` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hotel`
--

LOCK TABLES `hotel` WRITE;
/*!40000 ALTER TABLE `hotel` DISABLE KEYS */;
INSERT INTO `hotel` VALUES (1,'11',NULL,2,83,13,3,1,'\0',NULL,'2014-03-31 10:24:26',NULL,NULL,0),(2,'2',NULL,4,83,6,4,1,'\0',NULL,'2014-04-03 13:44:27',NULL,NULL,0),(3,'70, 79056','україна',NULL,245,13,1,2,'\0',NULL,'2014-04-03 13:57:55',NULL,NULL,0),(4,'4, 79008',NULL,NULL,245,13,1,3,'\0',NULL,'2014-04-03 13:44:30',NULL,NULL,0),(5,'1, 79000',NULL,NULL,245,13,1,4,'\0',NULL,'2014-04-03 13:44:31',NULL,NULL,0),(6,'43Б, 82660',NULL,NULL,245,13,3,5,'\0',NULL,'2014-04-03 13:44:32',NULL,NULL,0),(7,'43, 75009','null',NULL,83,31,10,6,'\0',NULL,'2014-04-04 09:26:34',NULL,NULL,0),(8,'3, 79000',NULL,3,245,13,1,2,'\0',NULL,'2014-04-04 07:49:57',NULL,NULL,0),(9,'2, 79000',NULL,2,245,13,1,5,'\0',NULL,'2014-04-04 07:50:30',NULL,NULL,0),(10,NULL,NULL,4,245,13,1,6,'\0',NULL,'2014-04-04 07:52:46',NULL,NULL,0),(11,NULL,NULL,3,245,13,1,6,'\0',NULL,'2014-04-04 07:54:44',NULL,NULL,0),(12,'6, 79000',NULL,5,245,13,1,8,'',NULL,'2014-04-04 08:04:24',NULL,NULL,0),(13,NULL,NULL,4,245,13,1,4,'\0',NULL,'2014-04-04 08:04:24',NULL,NULL,0),(14,NULL,NULL,2,245,13,1,5,'\0',NULL,'2014-04-04 08:05:01',NULL,NULL,0),(15,NULL,NULL,5,245,13,3,3,'\0',NULL,'2014-04-04 08:07:23',NULL,NULL,0),(16,NULL,'',NULL,NULL,NULL,NULL,NULL,'\0',NULL,'2014-04-04 09:33:47',NULL,NULL,0);
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
  CONSTRAINT `FK_hotel_gallery_hotel_id` FOREIGN KEY (`hotel_id`) REFERENCES `hotel` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hotel_gallery`
--

LOCK TABLES `hotel_gallery` WRITE;
/*!40000 ALTER TABLE `hotel_gallery` DISABLE KEYS */;
INSERT INTO `hotel_gallery` VALUES (1,3,'/bookingData/3_Kavalier Boutique Hotel/gallery/Thumb/gallery1396516632896.jpeg','/bookingData/3_Kavalier Boutique Hotel/gallery/gallery1396516632896.jpeg'),(2,3,'/bookingData/3_Kavalier Boutique Hotel/gallery/Thumb/gallery1396516634230.jpeg','/bookingData/3_Kavalier Boutique Hotel/gallery/gallery1396516634230.jpeg');
/*!40000 ALTER TABLE `hotel_gallery` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hotel_info`
--

DROP TABLE IF EXISTS `hotel_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hotel_info` (
  `hotel_id` int(10) unsigned NOT NULL DEFAULT '0',
  `locale_id` varchar(3) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `short_info` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `extended_info` text CHARACTER SET utf8 COLLATE utf8_unicode_ci,
  PRIMARY KEY (`hotel_id`,`locale_id`),
  KEY `FK_hotel_info_locale_id` (`locale_id`),
  CONSTRAINT `FK_hotel_info_hotel_id` FOREIGN KEY (`hotel_id`) REFERENCES `hotel` (`id`),
  CONSTRAINT `FK_hotel_info_locale_id` FOREIGN KEY (`locale_id`) REFERENCES `locale` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hotel_info`
--

LOCK TABLES `hotel_info` WRITE;
/*!40000 ALTER TABLE `hotel_info` DISABLE KEYS */;
INSERT INTO `hotel_info` VALUES (1,'en','Nobelis','Little hotel in Brodu','extended info about hotel id=1'),(2,'en','Ім\'я','Коротка інформація','Розширена інформація'),(3,'en','Kavalier Boutique Hotel','Short info about Kavalier Boutique Hotel oO','Offering a tennis court and a terrace, Boutique Hotel Kavalier offers elegant, soundproof rooms in Lviv, a 5-minute drive from the city centre. WiFi is free in all areas.\r\n\r\nThe rooms each come with heating, a satellite flat-screen TV, and private bathroom with bathrobes and free toiletries. They have luxurious décor, carpeted floors, and bright interiors.\r\n\r\nBuffet breakfast is served every morning, and the on-site restaurant serves European cuisine. Guests can enjoy green lawns encircling the hotel and beyond that are the parklands.\r\n\r\nRynok Square is 3 km from the property, and Opera Theatre is a 6-minute drive from Hotel Kavalier, while Lviv Airport is 10 km away.'),(3,'ua','Kavalier Boutique Hotel','Коротка інформація про Kavalier Boutique Hotel - update','Бутик-готель Kavalier розміщений у Львові, за 5 хвилин їзди від центру міста. До послуг гостей тенісний корт, тераса, а також елегантні звуконепроникні номери. В усіх приміщеннях закладу безкоштовно надається Wi-Fi.\r\n\r\nКожен номер забезпечений опаленням, телевізором із плоским екраном і супутниковими каналами, а також окремою ванною кімнатою, укомплектованою халатами й безкоштовними туалетно-косметичними засобами. Вони вирізняються килимовим покриттям підлоги, розкішним оформленням та світлим інтер\'єром.\r\n\r\nЩоранку гостям подається сніданок \"шведський стіл\", а готельний ресторан спеціалізується на європейській кухні. Гості отримають можливість прогулятися на зеленій галявині навколо готелю та у лісі в межах паркової зони по сусідству.\r\n\r\nПлоща Ринок розташована за 3 км від готелю Kavalier, Оперний театр - за 6 хвилин їзди, а аеропорт Львова - за 10 км.'),(4,'en','Rudolfo','Short info about Rudolfo','Set in the heart of Lviv, just steps to the Opera Theatre and Ploshcha Rynok, Rudolfo offers elegant rooms with free Wi-Fi. It features a terrace with panoramic views of Lviv.\r\n\r\nThe comfortable rooms feature bright décor and modern furnishings. They offer a flat-screen satellite TV. The private bathrooms come with a bath or shower, hairdryer and free toiletries. Some rooms have a balcony.\r\n\r\nThe café at Rudolfo serves breakfast. Laundry and ironing services are available. The Church of Assumption is a 5-minute walk away.\r\n\r\nLviv Train Station is 3.5 km from the hotel, while Lviv Airport is 6.5 km away.'),(4,'ua','Рудольфо','Коротка інформація про Рудольфо','Готель \"Рудольфо\" розташований у самому центрі Львова, за декілька кроків від Оперного театру й Площі Ринок. До послуг гостей елегантні номери з безкоштовним Wi-Fi, а також тераса з панорамним видом на місто.\r\n\r\nКомфортабельні номери оформлені в світлих тонах й обставлені сучасними меблями. У кожному з них є телевізор із плоским екраном і супутниковим телебаченням та окрема ванна кімната з ванною або душем, феном і безкоштовними туалетно-косметичними засобами. Деякі номери мають балкон.\r\n\r\nСніданок подають у кав\'ярні готелю \"Рудольфо\". Гості можуть скористатися послугами пральні й прасування одягу. За 5 хвилин звідси можна дійти до церкви Успіння Пресвятої Богородиці.\r\n\r\nВідстань від готелю до залізничного вокзалу Львова становить 3,5 км. Аеропорт міста розміщений за 6,5 км.'),(5,'en','George Hotel','Short info about George Hotel','George Hotel is situated in a grand building in Lviv, overlooking the Adam Mickiewicz Statue. The Opera House and City Hall Square are approximately a 2-minute walk from the hotel.\r\n\r\nThe ornate rooms at Hotel George have elegant, antique-style furnishings. Each is equipped with cable TV, free Wi-Fi and a private bathroom. Some rooms enjoy seating areas.\r\n\r\nThe in-house restaurant, with its high ceilings and ambient lighting, is an ideal place for enjoying lunch or dinner.\r\n\r\nThe George has a 24-hour reception and tour desk on site.'),(5,'ua','Готель Жорж','Коротка інформація про готель Джордж','Готель George розташований у Львові, у величній будівлі з видом на пам\'ятник Адаму Міцкевичу. Піша прогулянка від готелю до Оперного театру і Ратушної площі триватиме приблизно 2 хвилини.\r\n\r\nРозкішно оформлені номери готелю George обставлені вишуканими меблями у античному стилі. Кожний номер оснащений кабельним телебаченням, безкоштовним Wi-Fi і окремою ванною кімнатою. Деякі номери налічують зону відпочинку.\r\n\r\nРесторан готелю з високою стелею і чудовим освітленням буде найкращим місцем для обіду або вечері.\r\n\r\nВ готелі George працює цілодобова стійка реєстрації гостей і туристичне бюро.\r\n\r\nЗа запитом для гостей організовують трансфери до міжнародного аеропорту Львова.'),(6,'en','Perlyna Karpat','Short info about Perlyna Karpat','Located 300 metres from the ski lifts of Slavske Ski Resort, this hotel offers a heated swimming pool and rooms with a TV. A sauna, free Wi-Fi and a Carpathian-style bar can be found on site.\r\n\r\nEvery room at Perlyna Karpat Hotel features a balcony overlooking the Skole Beskids range. Some rooms have exposed wooden beams, and all bathrooms include a hairdryer.\r\n\r\nPerlyna’s traditionally decorated restaurant with a summer terrace serves European and Ukrainian cuisine. Local drinks and international beverages are offered at Mlyn Bar.\r\n\r\nGuests of Perlyna Karpat Hotel can relax in the sauna, take a dip in the heated outdoor swimming pool, or play billiards in the games room. Ski facilities are also provided, and there is a children’s playground.\r\n\r\nSlavske Train Station, offering access to Lviv, is 20 minutes’ walk from Perlyna Karpat Hotel. Lviv International Airport is 2 hours’ drive away, and a transfer service is available.'),(6,'ua','Перлина Карпат','Коротка інформація про \"Перлину Карпат\"','Цей готель розташований за 300 метрів від підйомників гірськолижного курорту Славське. На його території є басейн з підігрівом, сауна і бар в карпатському стилі. До послуг гостей номери з телевізором і безкоштовний Wi-Fi.\r\n\r\nУ кожному номері готелю \"Перлина Карпат\" є балкон із видом на гірський масив Сколівські Бескиди. Деякі помешкання оформлені з використанням дерев\'яних балок. Усі ванні кімнати укомплектовано феном.\r\n\r\nУ традиційно декорованому ресторані готелю \"Перлина Карпат\" із літньою терасою подають страви європейської та української кухонь. Місцеві та імпортні напої можна придбати у барі \"Млин\".\r\n\r\nГості готелю \"Перлина Карпат\" матимуть нагоду відпочити в сауні, поплавати у відкритому басейні з підігрівом або пограти в більярд в ігровій кімнаті. До ваших послуг лижне спорядження, а також дитячий майданчик.\r\n\r\nЗа 20 хвилин ходьби від готелю \"Перлина Карпат\" розташований залізничний вокзал селища Славське, звідки можна доїхати до Львова. На поїздку до Міжнародного аеропорту \"Львів\" у вас піде 2 години. Гостям пропонуються послуги трансферу.'),(7,'en','Adagio Paris Opéra','Short info about Adagio Paris Opéra','Adagio Paris Opéra is an apartment-style hotel located just steps from the Opera Garnier in Paris’s 9th arrondissement (district). It offers self-catering apartments for long or short stays.\r\n\r\nThe studio and 2-room apartments are fully furnished and equipped with a kitchenette with a microwave, refrigerator, hot plates, tea and coffee maker and a dishwasher. They also have flat-screen TV with international channels and a Wi-Fi internet connection.\r\n\r\nBreakfast is served daily in the breakfast room in the Adiago Paris Opera. Laundry service is available at an additional charge and there is also a dry cleaning service.\r\n\r\nThe reception at the Adiago is open 24 hours a day and can greet you in French or English.'),(7,'ua','Adagio Paris Opéra','Коротка інформація про Adagio Paris Opéra','Апарт-готель Adagio Paris Opéra розташований у 9 окрузі Парижа, за кілька кроків від Опери Гарньє. До послуг гостей апартаменти із власною кухнею для тривалого або короткочасного перебування.\r\n\r\nНомери-студіо та двокімнатні апартаменти - повністю мебльовані та обладнані міні-кухнею з мікрохвильовою піччю, холодильником, плитою, засобами для приготування чаю та кави і посудомийною машиною. У номерах є телевізор із плоским екраном і міжнародними телеканалами, а також бездротовий доступ до Інтернету (Wi-Fi).\r\n\r\nУ залі для сніданків апарт-готелю Adiago Paris Opera щоранку подається сніданок. За додаткову оплату гості зможуть скористатися послугами пральні та хімчистки.\r\n\r\nПрацівники цілодобової стійки реєстрації гостей розмовляють французькою та англійською мовами.'),(8,'en','Chopin','Chopin - beautiful hotel in city center','Offering a restaurant with live piano music, soundproofed rooms with flat-screen TV, and free Wi-Fi, this classical-style hotel is 1000 ft from the Lviv City Hall and elegant Rynok Square.'),(8,'ua','Шопен','Шопен - чарівний готель в центрі міста','До послуг гостей ресторан з живою фортепіанною музикою, звуконепроникні номери з телевізором з плоским екраном і безкоштовним Wi-Fi, цей готель в класичному стилі в 1000 футів від мерії Львова та елегантної Ринкової площі. '),(9,'en','Delice','Delice - hotel in Striysky Park','Located in Lviv’s famous Striysky Park and just a 5-minute walk from the Yunist Stadium, Delice offers a French restaurant, summer terrace and free Wi-Fi. Free on-site parking is provided.'),(9,'ua','Delice','Delice - ревеликий готель в Стрийському парку','Розташований в знаменитому Стрийському парку Львова, всього в 5 хвилинах ходьби від стадіону Юність, Delice пропонує ресторан французької кухні, літня тераса та безкоштовний Wi-Fi. На території є безкоштовна парковка. '),(10,'en','Plazma','Plazma hotel is set in the heart of Lviv’s UNESCO Old Town','This hotel is set in the heart of Lviv’s UNESCO Old Town, only 300 metres from Rynok Square. Rooms with free Wi-Fi and a flat-screen TV are featured at Hotel Plazma.'),(10,'ua','Plazma','Цей готель розташований в самому серці історичного центру Львова ЮНЕСКО','Цей готель розташований в самому серці історичного центру Львова ЮНЕСКО, всього в 300 метрах від площі Ринок. Номери з безкоштовним бездротовим доступом в Інтернет і телевізором з плоским екраном, які описані в готелі Plazma. '),(11,'en','Villa Arefyevykh','Villa Arefyevykh - hotel in Slavske','Located Slavske Ski Resort, a 3-minute walk from Politekh ski lift, and 1.5 km from Slavske Train Station, Villa Arefyevykh features a sauna, an outdoor pool, a shared kitchen, and free private parking.'),(11,'ua','Вілла Арефаєвих','Вілла Арефаєвих - готель в Славському','Розташований Гірськолижний курорт Славське, в 3 хвилинах ходьби від Політех підйомника і в 1,5 км від залізничного вокзалу Славське, Вілла Arefyevykh є сауна, відкритий басейн, загальна кухня і безкоштовна приватна парковка. '),(12,'en','Casa del Pozitiff','Casa del Pozitiff* is located in the resort town of Slavske','Offering outdoor pool, Casa del Pozitiff* is located in the resort town of Slavske. Free Wi-Fi access is available and there is a balcony in every room.'),(12,'ua','Casa del Pozitiff','Casa del Pozitiff* розташований в курортному місті Славське','Пропонуючи відкритий басейн, Каса-дель-Позитифф * розташований в курортному місті Славське. Безкоштовний бездротовий доступ в Інтернет доступний і є балкон у кожній кімнаті. '),(13,'en','Laguna','Laguna offers guests a relaxing stay with an outdoor pool','Located near the foothills of the Carpathian Mountains in Slavske, Laguna offers guests a relaxing stay with an outdoor pool, a sauna, an on-site restaurant serving Ukrainian and European cuisine, free Wi-Fi and free private parking.'),(13,'ua','Лагуна','Лагуна пропонує своїм гостям спокійний відпочинок з відкритим басейном','Знаходиться недалеко від підніжжя Карпатських гір в Славське, Лагуна пропонує своїм гостям спокійний відпочинок з відкритим басейном, сауною, ресторан на території готелю з стравами української та європейської кухні, безкоштовний Wi-Fi і безкоштовна приватна парковка. '),(14,'en','Karpatska Hatyna','Karpatska Hatyna','Located in the Carpathian Mountains in Slavske, a 5-minute walk to the nearest ski lift, Karpatska hatyna offers self-catering accommodation with free Wi-Fi and ski storage.'),(14,'ua','Карпатська Хатина','Карпатська Хатина','Розташований в Карпатах в Славське, в 5 хвилинах ходьби від найближчого підйомника, Карпатська hatyna пропонує апартаменти з самообслуговуванням з безкоштовним Wi-Fi і приміщення для зберігання лиж. '),(15,'en','On The Square Guesthouse','On The Square Guesthouse','Located directly on Market Square, this modern hotel is set in the heart of Lviv’s Old Town. It offers a 24-hour reception and spacious rooms with free Wi-Fi and private bathroom with free toiletries.'),(15,'ua','Гостьовий Готель','Гостьовий Готель в парку','Розташований прямо на ринковій площі, це сучасний готель розташований у самому серці історичного центру Львова. До послуг гостей 24-годинний прийом і просторі номери з безкоштовним Wi-Fi і власною ванною кімнатою з безкоштовними туалетним приладдям. '),(16,'en','Rebecca','Rebecca Hotel','Offering outdoor pool is located in the resort town of Lviv. Free Wi-Fi access is available and there is a balcony in every room.\r\n\r\nRooms here will provide you with a TV with satellite channels. Featuring a shower, the private bathrooms also come with a hairdryer and towels.\r\n\r\nyou will find a 24-hour front desk, a garden and a terrace. Other facilities offered include meeting facilities, shared lounge and ski storage.\r\n\r\nGuests enjoy skiing in winter and hiking in the warmer months.\r\n\r\n');
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
  CONSTRAINT `FK_hotel_service_hotel_id` FOREIGN KEY (`hotel_id`) REFERENCES `hotel` (`id`),
  CONSTRAINT `FK_hotel_service_service_id` FOREIGN KEY (`service_id`) REFERENCES `service` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hotel_service`
--

LOCK TABLES `hotel_service` WRITE;
/*!40000 ALTER TABLE `hotel_service` DISABLE KEYS */;
INSERT INTO `hotel_service` VALUES (1,1,2),(2,1,1),(3,1,3),(4,2,3),(5,2,1),(6,3,9),(7,8,1),(8,8,2),(9,8,9),(10,9,1),(11,9,3),(12,9,2),(13,10,1),(14,10,6),(15,10,5),(16,11,4),(17,11,5),(18,11,7),(19,12,5),(20,12,4),(21,12,7),(22,13,5),(23,13,2),(24,13,7),(39,7,1),(40,7,3),(41,7,5),(42,16,2),(43,16,6),(44,16,13);
/*!40000 ALTER TABLE `hotel_service` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `locale`
--

DROP TABLE IF EXISTS `locale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `locale` (
  `id` varchar(3) NOT NULL,
  `locale` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `locale`
--

LOCK TABLES `locale` WRITE;
/*!40000 ALTER TABLE `locale` DISABLE KEYS */;
INSERT INTO `locale` VALUES ('en','English'),('ua','Українська');
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
  `hotel_id` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`),
  KEY `manager_admin` (`admin_id`),
  KEY `FK_manager_hotel` (`hotel_id`),
  CONSTRAINT `FK_manager_admin_id` FOREIGN KEY (`admin_id`) REFERENCES `admin` (`id`),
  CONSTRAINT `FK_manager_hotel` FOREIGN KEY (`hotel_id`) REFERENCES `hotel` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manager`
--

LOCK TABLES `manager` WRITE;
/*!40000 ALTER TABLE `manager` DISABLE KEYS */;
INSERT INTO `manager` VALUES (2,'Karina','Bella','bela@yahoo.com',NULL,'2014-04-04 05:47:25','02a679774c0158d5a6efd9f07b9ad76d','095933744','2014-02-01',3),(15,'Oleksandr','Kolchenko','ol_kol@ukr.net',NULL,'2014-04-04 09:33:15','1e47a90fcc9c5b35508a4cda5900b081','234567','2014-03-19',4),(16,'Anton','Davydjuk','davydjuk@gmail.com',NULL,'2014-04-04 09:33:15','1e27af962f610ccd0f97161e72c6c2a4','234567','2014-03-19',5),(17,'Maks','Ivschyn','ivschyn@ukr.net',NULL,'2014-04-04 09:33:15','21dc62ca4082398be2331da5640913be','234557','2014-03-19',6),(18,'Mykola','Trush','trusch@gmail.com',NULL,'2014-04-04 09:33:15','a9f47c4c9f1a31b868c48e44b1c5548c','345678','2014-03-19',7),(19,'Rene','Kembl','gghhdd@ukr.net',NULL,'2014-04-04 09:15:56','6ea0ee2308c4a05c25f20e03a794b893','987654','2014-04-04',8),(20,'German','Vouk','ole@olo.net',NULL,'2014-04-04 09:15:56','ec1a021693538176f8b17b591c7e8056','123456','2014-04-04',9),(21,'','','karen@gala.net',NULL,'2014-04-04 09:32:08','bcf831b25f16df78454a47ea56f989ea','931021','2014-04-04',10),(22,'','','bea@gala.net',NULL,'2014-04-04 09:33:15','925d53ca9fba03ac2761fd5469f56295','345678','2014-04-04',11),(23,'Ola','Kanonjere','ola@gala.net',NULL,'2014-04-04 09:15:56','3756dbf664808d3fbcbdd3a82657b3e0','123456','2014-04-04',12),(25,'','','mika@gala.net',NULL,'2014-04-04 09:33:48','22302d6f3411cd5e5b769257e6146743','','2014-04-04',16);
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
  CONSTRAINT `FK_manager_hotel_hotel_id` FOREIGN KEY (`hotel_id`) REFERENCES `hotel` (`id`),
  CONSTRAINT `FK_manager_hotel_manager_id` FOREIGN KEY (`manager_id`) REFERENCES `manager` (`id`)
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
  `type` tinyint(4) unsigned NOT NULL COMMENT 'Type of message: add new country, add new city, request etc.',
  `message` text CHARACTER SET latin1 NOT NULL,
  `status` tinyint(4) NOT NULL COMMENT 'Status of message: approved, denied etc.',
  `last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `FK_manager_message_manager_id` (`manager_id`),
  CONSTRAINT `FK_manager_message_manager_id` FOREIGN KEY (`manager_id`) REFERENCES `manager` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manager_message`
--

LOCK TABLES `manager_message` WRITE;
/*!40000 ALTER TABLE `manager_message` DISABLE KEYS */;
INSERT INTO `manager_message` VALUES (1,2,0,'please ctreate',0,'2014-04-03 09:36:39'),(2,25,0,'qwertyuiop[zxcvbnm\r\n',0,'2014-04-04 09:38:24');
/*!40000 ALTER TABLE `manager_message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `region`
--

DROP TABLE IF EXISTS `region`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `region` (
  `id` int(10) unsigned NOT NULL,
  `locale_id` varchar(3) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `country_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`,`locale_id`),
  KEY `country_region` (`country_id`),
  KEY `FK_region_locale_id` (`locale_id`),
  CONSTRAINT `FK_region_country_id` FOREIGN KEY (`country_id`) REFERENCES `country` (`id`),
  CONSTRAINT `FK_region_locale_id` FOREIGN KEY (`locale_id`) REFERENCES `locale` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `region`
--

LOCK TABLES `region` WRITE;
/*!40000 ALTER TABLE `region` DISABLE KEYS */;
INSERT INTO `region` VALUES (1,'en','Vinnytsia Oblast',245),(1,'ua','Вінницька область',245),(2,'en','Volyn Oblast',245),(2,'ua','Волинська область',245),(3,'en','Dnipropetrovsk Oblast',245),(3,'ua','Дніпропетровська область',245),(4,'en','Donetsk Oblast',245),(4,'ua','Донецька область',245),(5,'en','Zhytomyr Oblast',245),(5,'ua','Житомирська область',245),(6,'en','Zakarpattia Oblast',245),(6,'ua','Закарпатська область',245),(7,'en','Zaporizhia Oblast',245),(7,'ua','Запорізька область',245),(8,'en','Ivano-Frankivsk Oblast',245),(8,'ua','Івано-франківська область',245),(9,'en','Kyiv Oblast',245),(9,'ua','Київська область',245),(10,'en','Kirovohrad Oblast',245),(10,'ua','Кіровоградська область',245),(11,'en','Crimea',245),(11,'ua','Крим',245),(12,'en','Luhansk Oblast',245),(12,'ua','Луганська область',245),(13,'en','Lviv Oblast',245),(13,'ua','Львівська область',245),(14,'en','Mykolaiv Oblast',245),(14,'ua','Миколаївська область',245),(15,'en','Odessa Oblast',245),(15,'ua','Одеська область',245),(16,'en','Poltava Oblast',245),(16,'ua','Полтавська область',245),(17,'en','Rivne Oblast',245),(17,'ua','Рівненська область',245),(18,'en','Sumy Oblast',245),(18,'ua','Сумська область',245),(19,'en','Ternopil Oblast',245),(19,'ua','Тернопільска область',245),(20,'en','Kharkiv Oblast',245),(20,'ua','Харківська область',245),(21,'en','Kherson Oblast',245),(21,'ua','Херсонська область',245),(22,'en','Khmelnytskyi Oblast',245),(22,'ua','Хмельницька область',245),(23,'en','Cherkasy Oblast',245),(23,'ua','Черкаська область',245),(24,'en','Chernivtsi Oblast',245),(24,'ua','Чернівецька область',245),(25,'en','Chernihiv Oblast',245),(25,'ua','Чернігівська область',245),(31,'en','Ile de France',83),(31,'ua','Іль-де-Франс',83),(32,'en','Burgundy',83),(32,'ua','Бургундія',83),(33,'en','Upper Normandy',83),(33,'ua','Верхня Нормандія',83),(34,'en','Corsica',83),(34,'ua','Корсика',83),(35,'en','Languedoc-Roussillon',83),(35,'ua','Лангедок-Руссільйон',83),(36,'en','Lorraine',83),(36,'ua','Лотарингія',83),(37,'en','Lower Normandy',83),(37,'ua','Нижня Нормандія',83),(38,'en','Nord-Pas-de-Calais',83),(38,'ua','Нор-Па-де-Кале',83),(39,'en','Pays de la Loire',83),(39,'ua','Пеї-де-ла-Луар',83),(40,'en','Provence-Alpes-Côte d\'Azur',83),(40,'ua','Прованс-Альпи-Лазурний берег',83),(41,'en','Poitou-Charentes',83),(41,'ua','Пуату-Шарант',83),(42,'en','Midi-Pyrénées',83),(42,'ua','Південь-Піренеї',83),(43,'en','Rhône-Alps',83),(43,'ua','Рона-Альпи',83),(44,'en','facka',246),(44,'ua','фака',246);
/*!40000 ALTER TABLE `region` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `review`
--

DROP TABLE IF EXISTS `review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `review` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `hotel_id` int(10) unsigned NOT NULL,
  `user_id` int(10) unsigned NOT NULL,
  `rating` tinyint(4) NOT NULL,
  `review` text,
  PRIMARY KEY (`id`),
  KEY `rate_user` (`user_id`),
  KEY `rate_hotel` (`hotel_id`),
  CONSTRAINT `FK_rate_hotel_id` FOREIGN KEY (`hotel_id`) REFERENCES `hotel` (`id`),
  CONSTRAINT `FK_rate_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `review`
--

LOCK TABLES `review` WRITE;
/*!40000 ALTER TABLE `review` DISABLE KEYS */;
INSERT INTO `review` VALUES (3,1,1,3,'not bad'),(4,6,2,4,'Мені готель сподобався, але могло б бути краще.'),(5,6,8,5,'Найкращий готель з тих, де мені вдалося побувати');
/*!40000 ALTER TABLE `review` ENABLE KEYS */;
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
  `cost` int(10) unsigned NOT NULL,
  `number_of_rooms` tinyint(4) NOT NULL COMMENT 'Number of rooms in this room type',
  `number_of_people` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_room_hotel_id` (`hotel_id`),
  CONSTRAINT `FK_room_hotel_id` FOREIGN KEY (`hotel_id`) REFERENCES `hotel` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room`
--

LOCK TABLES `room` WRITE;
/*!40000 ALTER TABLE `room` DISABLE KEYS */;
INSERT INTO `room` VALUES (1,1,20,3,2),(2,2,21,5,2),(3,3,60,5,2),(4,3,95,3,3),(5,3,120,1,2),(6,3,16,1,2),(7,4,60,1,2),(8,4,70,1,2),(9,4,80,1,2),(10,4,90,1,2),(11,4,90,1,2),(12,4,110,1,2),(13,5,35,3,2),(14,5,60,3,2),(15,5,65,3,2),(16,5,88,3,3),(17,5,103,3,3),(18,6,30,5,2),(19,6,41,2,2),(20,6,45,3,2),(21,6,55,3,2),(22,7,26,7,2),(23,7,19,7,4),(24,8,10,1,2),(25,8,15,2,3),(26,8,20,3,3),(27,8,24,4,5),(28,9,12,2,2),(29,9,20,4,3),(30,9,24,5,2),(31,9,40,6,5),(32,10,20,1,1),(33,10,20,2,2),(34,10,25,3,3),(35,10,26,4,4),(36,11,30,5,2),(37,11,35,3,3),(38,11,40,4,6),(39,12,15,5,2),(40,12,15,3,2),(41,12,25,4,6),(42,12,40,5,2),(43,13,9,1,1),(44,13,9,2,2),(45,13,10,3,2),(46,13,20,4,4),(47,14,15,1,2),(48,14,20,2,2),(49,14,25,3,3),(50,14,30,3,3),(51,15,10,2,4);
/*!40000 ALTER TABLE `room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `room_info`
--

DROP TABLE IF EXISTS `room_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `room_info` (
  `room_id` int(10) unsigned NOT NULL,
  `locale_id` varchar(3) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`room_id`,`locale_id`),
  KEY `FK_room_info_locale_id` (`locale_id`),
  CONSTRAINT `FK_room_info_locale_id` FOREIGN KEY (`locale_id`) REFERENCES `locale` (`id`),
  CONSTRAINT `FK_room_info_room_id` FOREIGN KEY (`room_id`) REFERENCES `room` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room_info`
--

LOCK TABLES `room_info` WRITE;
/*!40000 ALTER TABLE `room_info` DISABLE KEYS */;
INSERT INTO `room_info` VALUES (1,'en','plaza'),(2,'en','lux'),(3,'en','Standard Double or Twin Room'),(3,'ua','Стандартний двомісний номер/номер Твін'),(4,'en','Standard Triple Room '),(4,'ua','Стандартний тримісний номер '),(5,'en','Junior Suite '),(5,'ua','Напівлюкс '),(6,'en','Suite '),(6,'ua','Люкс'),(7,'en','Standard Double or Twin Room'),(7,'ua','Стандартний двомісний номер/номер Твін'),(8,'en','Comfort Double or Twin Room '),(8,'ua','Двомісний номер \"Комфорт\"/Номер Твін'),(9,'en','Studio'),(9,'ua','Номер-студіо '),(10,'en','Junior Suite'),(10,'ua','Напівлюкс'),(11,'en','Junior Suite with City View'),(11,'ua','Напівлюкс з видом на місто'),(12,'en',' Suite'),(12,'ua','Люкс'),(13,'en','Twin Room with Shared Bathroom '),(13,'ua','Номер Твін зі спільною ванною кімнатою '),(14,'en','Standard Double or Twin Room '),(14,'ua','Стандартний двомісний номер/номер Твін '),(15,'en','Superior Double or Twin Room'),(15,'ua','Покращений двомісний номер/номер Твін '),(16,'en','Family Room'),(16,'ua','Сімейний номер '),(17,'en','Superior Triple Room'),(17,'ua','Покращений тримісний номер '),(18,'en','Standard Twin Room '),(18,'ua','Стандартний номер Твін '),(19,'en','Junior Suite'),(19,'ua','Напівлюкс '),(20,'en','Family Junior Suite'),(20,'ua','Сімейний напівлюкс '),(21,'en','Suite'),(21,'ua','Люкс'),(22,'en','Studio (2 Adults) '),(22,'ua','Номер-студіо (для 2 дорослих) '),(23,'en','One-Bedroom Apartment (4 Adults)'),(23,'ua','Апартаменти з однією спальнею (4 дорослих) '),(24,'en','Standard Twin Room'),(24,'ua','Стандартна кімната на двох'),(25,'en','Junior Suite with Balcony'),(25,'ua','Сьют з балконом'),(26,'en','Junior Suite with Fireplace'),(26,'ua','Сьют з каміном'),(27,'en','Suite '),(27,'ua','Сьют'),(28,'en ','Standard Family Room'),(28,'ua','Стандартна Сімейна кімната'),(29,'en','Standard Family Room'),(29,'ua','Стандартна Сімейна кімната'),(30,'en','Suite '),(30,'ua','Сьют'),(31,'en','Standard Family Room'),(31,'ua','Стандартна Сімейна кімната'),(32,'en','Studio'),(32,'ua','Номер-студіо '),(33,'en','Junior Suite with Fireplace'),(33,'ua','Сьют з каміном'),(34,'en','Standard Family Room'),(34,'ua','Стандартна Сімейна кімната'),(35,'en','Lux'),(35,'ua','Люкс'),(36,'en','Lux'),(36,'ua','Люкс'),(37,'en','Standard Triple Room'),(37,'ua','Стандартна кімната на 3-х осіб'),(38,'en','Standard Family Room'),(38,'ua','Стандартна Сімейна кімната'),(39,'en','Standard Family Room'),(39,'ua','Стандартна Сімейна кімната'),(40,'en','Studio'),(40,'ua','Студія'),(41,'en','Lux'),(41,'ua','Люкс'),(42,'en','Standart Twin Room'),(42,'ua','Кімната на двох осіб'),(43,'en','Studio'),(43,'ua','Студія'),(44,'en','Standart Twin Room'),(44,'ua','Кімната на двох осіб'),(45,'en','Standart Twin Room'),(45,'ua','Кімната на двох осіб'),(46,'en','Lux'),(46,'ua','Люкс'),(47,'en','Standart Twin Room'),(47,'ua','Кімната на двох осіб'),(48,'en','Standart Twin Room'),(48,'ua','Кімната на двох осіб'),(49,'en','Standart Triple Room'),(49,'ua','Кімната на 3-х осіб'),(50,'en','Standart Family Room'),(50,'ua','Сімейний номер'),(51,'en','Lux'),(51,'ua','Люкс');
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
  `locale_id` varchar(3) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`,`locale_id`),
  KEY `FK_service_locale_id` (`locale_id`),
  CONSTRAINT `FK_service_locale_id` FOREIGN KEY (`locale_id`) REFERENCES `locale` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `service`
--

LOCK TABLES `service` WRITE;
/*!40000 ALTER TABLE `service` DISABLE KEYS */;
INSERT INTO `service` VALUES (1,'en','Facilities for Disabled Guests'),(1,'ua','Номери/зручності для осіб з обмеженими фізичними можливостями'),(2,'en','Restaurant'),(2,'ua','Ресторан'),(3,'en','Internet'),(3,'ua','Інтернет'),(4,'en','Non-smoking Rooms'),(4,'ua','Номери для некурців'),(5,'en','Fitness Center'),(5,'ua','Фітнес-центр'),(6,'en','Family Rooms'),(6,'ua','Сімейні номери'),(7,'en','Pet Friendly'),(7,'ua','Допускається розміщення з домашніми тваринами'),(8,'en','Parking'),(8,'ua','Автостоянка'),(9,'en','Spa'),(9,'ua','Оздоровчий спа-центр'),(10,'en','Wi-Fi'),(10,'ua','Wi-Fi'),(11,'en','Indoor Pool'),(11,'ua','Критий плавальний басейн'),(12,'en','Airport Shuttle'),(12,'ua','Трансфер до/з аеропорту'),(13,'en','Free Wi-Fi'),(13,'ua','Безкоштовний Wi-Fi'),(14,'en','Bar'),(14,'ua','Бар'),(15,'en','Baggage Storage'),(15,'ua','Камера зберігання багажу'),(16,'en','24-Hour Front Desk'),(16,'ua','Цілодобова стійка реєстрації гостей');
/*!40000 ALTER TABLE `service` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `street`
--

DROP TABLE IF EXISTS `street`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `street` (
  `id` int(10) unsigned NOT NULL,
  `locale_id` varchar(3) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `city_id` int(10) unsigned NOT NULL,
  `region_id` int(10) unsigned NOT NULL,
  `country_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`,`locale_id`),
  KEY `street_city` (`city_id`),
  KEY `FK_street_locale_id` (`locale_id`),
  KEY `FK_street_region_id_idx` (`region_id`),
  KEY `FK_street_country_id_idx` (`country_id`),
  CONSTRAINT `FK_street_city_id` FOREIGN KEY (`city_id`) REFERENCES `city` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `street`
--

LOCK TABLES `street` WRITE;
/*!40000 ALTER TABLE `street` DISABLE KEYS */;
INSERT INTO `street` VALUES (1,'en','somestreet',1,13,245),(2,'en','Staroznesenska Street',1,13,245),(2,'ua','Вулиця Старознесенська',1,13,245),(3,'en','Virmenska Street',1,13,245),(3,'ua','Вулиця Вірменська',1,13,245),(4,'en','Pl.Mickiewich',1,13,245),(4,'ua','Пл. Міцкевича',1,13,245),(5,'en','Franka Street',4,13,245),(5,'ua','Вулиця Франка',4,13,245),(6,'en','Rue De Caumartin',10,13,245),(7,'en','faka',14,44,246),(7,'ua','фака',14,44,246),(8,'en','dekbn',1,13,245),(8,'ua','дека',1,13,245);
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
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Ketrin','Bern','kb@hotmail.com','c4053b7f78bb53d5ab11f528ed4b69f2',NULL,'2012-11-12','','','2014-03-10 11:12:46'),(2,'Andrew','Kembl','anre@epam.com','ddf91a5f7aa8f2b1a85568450fd28e88',NULL,'2013-11-13','',NULL,'2014-03-10 11:16:05'),(8,'Oleksa','Skorokhoda','oleksa-sow@ukr.net','21a7ae279180072f3c9501aa863d4ebc',NULL,'2014-03-11','',NULL,'2014-03-11 10:17:15'),(9,'Максим','Берн','aaaa@aaaa.aaa','8900c0641a0ec8a9bdd4fa4192ec0a5b',NULL,'2014-04-03','','\0','2014-04-04 07:40:48'),(10,'Богдан','Живаго','gghh@ukr.net','e8ededfca3a10b0eb8addb6b8fc40fb6',NULL,'2014-04-04','','\0','2014-04-04 07:40:48');
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

-- Dump completed on 2014-04-05  7:28:06
