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
  CONSTRAINT `FK_booking_room_hotel_id` FOREIGN KEY (`hotel_id`) REFERENCES `hotel` (`id`),
  CONSTRAINT `FK_booking_room_booking_id` FOREIGN KEY (`booking_id`) REFERENCES `booking` (`id`),
  CONSTRAINT `FK_booking_room_room_id` FOREIGN KEY (`room_id`) REFERENCES `room` (`id`)
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
INSERT INTO `city` VALUES (1,'en','Lviv',245,13),(1,'ua','Львів',245,13),(2,'en','Truskavets',245,13),(2,'ua','Трускавець',245,13),(3,'en','Slavske',245,13),(3,'ua','Славське',245,9),(4,'en','Zhovkva',245,13),(4,'ua','Жовква',245,13),(5,'en','Bryukhovychi',245,13),(5,'ua','Брюховичі',245,13),(6,'en','Kyiv',245,9),(6,'ua','Київ',245,9),(7,'en','Boryspil',245,9),(7,'ua','Бориспіль',245,9),(8,'en','Brovary',245,9),(8,'ua','Бровари',245,9),(9,'en','Paris',83,31),(9,'ua','Париж',83,31),(10,'en','Nice',83,NULL),(10,'ua','Ніцца',83,NULL),(11,'en','Cannes',83,NULL),(11,'ua','Канни',83,NULL),(12,'en','Lyon',83,43),(12,'ua','Ліон',83,43),(13,'en','Annecy',83,43),(13,'ua','Аннесі',83,43);
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
INSERT INTO `country` VALUES (83,'en','France'),(83,'ua','Франція'),(245,'en','Ukraine'),(245,'ua','Україна');
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
  CONSTRAINT `FK_favorite_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FK_favorite_hotel_id` FOREIGN KEY (`hotel_id`) REFERENCES `hotel` (`id`)
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
  CONSTRAINT `FK_hotel_street_id` FOREIGN KEY (`street_id`) REFERENCES `street` (`id`),
  CONSTRAINT `FK_hotel_city_id` FOREIGN KEY (`city_id`) REFERENCES `city` (`id`),
  CONSTRAINT `FK_hotel_country_id` FOREIGN KEY (`country_id`) REFERENCES `country` (`id`),
  CONSTRAINT `FK_hotel_region_id` FOREIGN KEY (`region_id`) REFERENCES `region` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hotel`
--

LOCK TABLES `hotel` WRITE;
/*!40000 ALTER TABLE `hotel` DISABLE KEYS */;
INSERT INTO `hotel` VALUES (1,'11',NULL,2,83,3,3,1,NULL,NULL,'2014-03-20 20:58:55',NULL,NULL),(2,'2',NULL,4,83,6,4,1,NULL,NULL,'2014-03-20 20:59:33',NULL,NULL),(3,'70, 79056',NULL,NULL,245,13,1,2,NULL,NULL,'2014-03-19 04:11:32',NULL,NULL),(4,'4, 79008',NULL,NULL,245,13,1,3,NULL,NULL,'2014-03-19 04:30:14',NULL,NULL),(5,'1, 79000',NULL,NULL,245,13,1,4,NULL,NULL,'2014-03-19 04:39:25',NULL,NULL),(6,'43Б, 82660',NULL,NULL,245,13,4,5,NULL,NULL,'2014-03-19 04:49:29',NULL,NULL),(7,'43, 75009',NULL,NULL,83,31,10,6,NULL,NULL,'2014-03-19 05:04:53',NULL,NULL);
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
  `hotel_id` int(10) unsigned NOT NULL DEFAULT '0',
  `locale_id` varchar(3) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `short_info` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `extended_info` text CHARACTER SET utf8 COLLATE utf8_unicode_ci,
  PRIMARY KEY (`hotel_id`,`locale_id`),
  KEY `FK_hotel_info_locale_id` (`locale_id`),
  CONSTRAINT `FK_hotel_info_locale_id` FOREIGN KEY (`locale_id`) REFERENCES `locale` (`id`),
  CONSTRAINT `FK_hotel_info_hotel_id` FOREIGN KEY (`hotel_id`) REFERENCES `hotel` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hotel_info`
--

LOCK TABLES `hotel_info` WRITE;
/*!40000 ALTER TABLE `hotel_info` DISABLE KEYS */;
INSERT INTO `hotel_info` VALUES (1,'en','Nobelis','Little hotel in Brodu','extended info about hotel id=1'),(3,'en','Kavalier Boutique Hotel',NULL,'Offering a tennis court and a terrace, Boutique Hotel Kavalier offers elegant, soundproof rooms in Lviv, a 5-minute drive from the city centre. WiFi is free in all areas.\r\n\r\nThe rooms each come with heating, a satellite flat-screen TV, and private bathroom with bathrobes and free toiletries. They have luxurious décor, carpeted floors, and bright interiors.\r\n\r\nBuffet breakfast is served every morning, and the on-site restaurant serves European cuisine. Guests can enjoy green lawns encircling the hotel and beyond that are the parklands.\r\n\r\nRynok Square is 3 km from the property, and Opera Theatre is a 6-minute drive from Hotel Kavalier, while Lviv Airport is 10 km away.'),(3,'ua','Kavalier Boutique Hotel',NULL,'Бутик-готель Kavalier розміщений у Львові, за 5 хвилин їзди від центру міста. До послуг гостей тенісний корт, тераса, а також елегантні звуконепроникні номери. В усіх приміщеннях закладу безкоштовно надається Wi-Fi.\r\n\r\nКожен номер забезпечений опаленням, телевізором із плоским екраном і супутниковими каналами, а також окремою ванною кімнатою, укомплектованою халатами й безкоштовними туалетно-косметичними засобами. Вони вирізняються килимовим покриттям підлоги, розкішним оформленням та світлим інтер\'єром.\r\n\r\nЩоранку гостям подається сніданок \"шведський стіл\", а готельний ресторан спеціалізується на європейській кухні. Гості отримають можливість прогулятися на зеленій галявині навколо готелю та у лісі в межах паркової зони по сусідству.\r\n\r\nПлоща Ринок розташована за 3 км від готелю Kavalier, Оперний театр - за 6 хвилин їзди, а аеропорт Львова - за 10 км.'),(4,'en','Rudolfo',NULL,'Set in the heart of Lviv, just steps to the Opera Theatre and Ploshcha Rynok, Rudolfo offers elegant rooms with free Wi-Fi. It features a terrace with panoramic views of Lviv.\r\n\r\nThe comfortable rooms feature bright décor and modern furnishings. They offer a flat-screen satellite TV. The private bathrooms come with a bath or shower, hairdryer and free toiletries. Some rooms have a balcony.\r\n\r\nThe café at Rudolfo serves breakfast. Laundry and ironing services are available. The Church of Assumption is a 5-minute walk away.\r\n\r\nLviv Train Station is 3.5 km from the hotel, while Lviv Airport is 6.5 km away.'),(4,'ua','Рудольфо',NULL,'Готель \"Рудольфо\" розташований у самому центрі Львова, за декілька кроків від Оперного театру й Площі Ринок. До послуг гостей елегантні номери з безкоштовним Wi-Fi, а також тераса з панорамним видом на місто.\r\n\r\nКомфортабельні номери оформлені в світлих тонах й обставлені сучасними меблями. У кожному з них є телевізор із плоским екраном і супутниковим телебаченням та окрема ванна кімната з ванною або душем, феном і безкоштовними туалетно-косметичними засобами. Деякі номери мають балкон.\r\n\r\nСніданок подають у кав\'ярні готелю \"Рудольфо\". Гості можуть скористатися послугами пральні й прасування одягу. За 5 хвилин звідси можна дійти до церкви Успіння Пресвятої Богородиці.\r\n\r\nВідстань від готелю до залізничного вокзалу Львова становить 3,5 км. Аеропорт міста розміщений за 6,5 км.'),(5,'en','George Hotel',NULL,'George Hotel is situated in a grand building in Lviv, overlooking the Adam Mickiewicz Statue. The Opera House and City Hall Square are approximately a 2-minute walk from the hotel.\r\n\r\nThe ornate rooms at Hotel George have elegant, antique-style furnishings. Each is equipped with cable TV, free Wi-Fi and a private bathroom. Some rooms enjoy seating areas.\r\n\r\nThe in-house restaurant, with its high ceilings and ambient lighting, is an ideal place for enjoying lunch or dinner.\r\n\r\nThe George has a 24-hour reception and tour desk on site.'),(5,'ua','Готель Жорж',NULL,'Готель George розташований у Львові, у величній будівлі з видом на пам\'ятник Адаму Міцкевичу. Піша прогулянка від готелю до Оперного театру і Ратушної площі триватиме приблизно 2 хвилини.\r\n\r\nРозкішно оформлені номери готелю George обставлені вишуканими меблями у античному стилі. Кожний номер оснащений кабельним телебаченням, безкоштовним Wi-Fi і окремою ванною кімнатою. Деякі номери налічують зону відпочинку.\r\n\r\nРесторан готелю з високою стелею і чудовим освітленням буде найкращим місцем для обіду або вечері.\r\n\r\nВ готелі George працює цілодобова стійка реєстрації гостей і туристичне бюро.\r\n\r\nЗа запитом для гостей організовують трансфери до міжнародного аеропорту Львова.'),(6,'en','Perlyna Karpat',NULL,'Located 300 metres from the ski lifts of Slavske Ski Resort, this hotel offers a heated swimming pool and rooms with a TV. A sauna, free Wi-Fi and a Carpathian-style bar can be found on site.\r\n\r\nEvery room at Perlyna Karpat Hotel features a balcony overlooking the Skole Beskids range. Some rooms have exposed wooden beams, and all bathrooms include a hairdryer.\r\n\r\nPerlyna’s traditionally decorated restaurant with a summer terrace serves European and Ukrainian cuisine. Local drinks and international beverages are offered at Mlyn Bar.\r\n\r\nGuests of Perlyna Karpat Hotel can relax in the sauna, take a dip in the heated outdoor swimming pool, or play billiards in the games room. Ski facilities are also provided, and there is a children’s playground.\r\n\r\nSlavske Train Station, offering access to Lviv, is 20 minutes’ walk from Perlyna Karpat Hotel. Lviv International Airport is 2 hours’ drive away, and a transfer service is available.'),(6,'ua','Перлина Карпат',NULL,'Цей готель розташований за 300 метрів від підйомників гірськолижного курорту Славське. На його території є басейн з підігрівом, сауна і бар в карпатському стилі. До послуг гостей номери з телевізором і безкоштовний Wi-Fi.\r\n\r\nУ кожному номері готелю \"Перлина Карпат\" є балкон із видом на гірський масив Сколівські Бескиди. Деякі помешкання оформлені з використанням дерев\'яних балок. Усі ванні кімнати укомплектовано феном.\r\n\r\nУ традиційно декорованому ресторані готелю \"Перлина Карпат\" із літньою терасою подають страви європейської та української кухонь. Місцеві та імпортні напої можна придбати у барі \"Млин\".\r\n\r\nГості готелю \"Перлина Карпат\" матимуть нагоду відпочити в сауні, поплавати у відкритому басейні з підігрівом або пограти в більярд в ігровій кімнаті. До ваших послуг лижне спорядження, а також дитячий майданчик.\r\n\r\nЗа 20 хвилин ходьби від готелю \"Перлина Карпат\" розташований залізничний вокзал селища Славське, звідки можна доїхати до Львова. На поїздку до Міжнародного аеропорту \"Львів\" у вас піде 2 години. Гостям пропонуються послуги трансферу.'),(7,'en','Adagio Paris Opéra',NULL,'Adagio Paris Opéra is an apartment-style hotel located just steps from the Opera Garnier in Paris’s 9th arrondissement (district). It offers self-catering apartments for long or short stays.\r\n\r\nThe studio and 2-room apartments are fully furnished and equipped with a kitchenette with a microwave, refrigerator, hot plates, tea and coffee maker and a dishwasher. They also have flat-screen TV with international channels and a Wi-Fi internet connection.\r\n\r\nBreakfast is served daily in the breakfast room in the Adiago Paris Opera. Laundry service is available at an additional charge and there is also a dry cleaning service.\r\n\r\nThe reception at the Adiago is open 24 hours a day and can greet you in French or English.'),(7,'ua','Adagio Paris Opéra',NULL,'Апарт-готель Adagio Paris Opéra розташований у 9 окрузі Парижа, за кілька кроків від Опери Гарньє. До послуг гостей апартаменти із власною кухнею для тривалого або короткочасного перебування.\r\n\r\nНомери-студіо та двокімнатні апартаменти - повністю мебльовані та обладнані міні-кухнею з мікрохвильовою піччю, холодильником, плитою, засобами для приготування чаю та кави і посудомийною машиною. У номерах є телевізор із плоским екраном і міжнародними телеканалами, а також бездротовий доступ до Інтернету (Wi-Fi).\r\n\r\nУ залі для сніданків апарт-готелю Adiago Paris Opera щоранку подається сніданок. За додаткову оплату гості зможуть скористатися послугами пральні та хімчистки.\r\n\r\nПрацівники цілодобової стійки реєстрації гостей розмовляють французькою та англійською мовами.');
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
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`),
  KEY `manager_admin` (`admin_id`),
  CONSTRAINT `FK_manager_admin_id` FOREIGN KEY (`admin_id`) REFERENCES `admin` (`id`)
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
  `type` smallint(6) NOT NULL,
  `message` text CHARACTER SET latin1 NOT NULL,
  `status` smallint(6) NOT NULL,
  `last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `FK_manager_message_manager_id` (`manager_id`),
  CONSTRAINT `FK_manager_message_manager_id` FOREIGN KEY (`manager_id`) REFERENCES `manager` (`id`)
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
  CONSTRAINT `FK_rate_user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FK_rate_hotel_id` FOREIGN KEY (`hotel_id`) REFERENCES `hotel` (`id`)
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
INSERT INTO `region` VALUES (1,'en','Vinnytsia Oblast',245),(1,'ua','Вінницька область',245),(2,'en','Volyn Oblast',245),(2,'ua','Волинська область',245),(3,'en','Dnipropetrovsk Oblast',245),(3,'ua','Дніпропетровська область',245),(4,'en','Donetsk Oblast',245),(4,'ua','Донецька область',245),(5,'en','Zhytomyr Oblast',245),(5,'ua','Житомирська область',245),(6,'en','Zakarpattia Oblast',245),(6,'ua','Закарпатська область',245),(7,'en','Zaporizhia Oblast',245),(7,'ua','Запорізька область',245),(8,'en','Ivano-Frankivsk Oblast',245),(8,'ua','Івано-франківська область',245),(9,'en','Kyiv Oblast',245),(9,'ua','Київська область',245),(10,'en','Kirovohrad Oblast',245),(10,'ua','Кіровоградська область',245),(11,'en','Crimea',245),(11,'ua','Крим',245),(12,'en','Luhansk Oblast',245),(12,'ua','Луганська область',245),(13,'en','Lviv Oblast',245),(13,'ua','Львівська область',245),(14,'en','Mykolaiv Oblast',245),(14,'ua','Миколаївська область',245),(15,'en','Odessa Oblast',245),(15,'ua','Одеська область',245),(16,'en','Poltava Oblast',245),(16,'ua','Полтавська область',245),(17,'en','Rivne Oblast',245),(17,'ua','Рівненська область',245),(18,'en','Sumy Oblast',245),(18,'ua','Сумська область',245),(19,'en','Ternopil Oblast',245),(19,'ua','Тернопільска область',245),(20,'en','Kharkiv Oblast',245),(20,'ua','Харківська область',245),(21,'en','Kherson Oblast',245),(21,'ua','Херсонська область',245),(22,'en','Khmelnytskyi Oblast',245),(22,'ua','Хмельницька область',245),(23,'en','Cherkasy Oblast',245),(23,'ua','Черкаська область',245),(24,'en','Chernivtsi Oblast',245),(24,'ua','Чернівецька область',245),(25,'en','Chernihiv Oblast',245),(25,'ua','Чернігівська область',245),(31,'en','Ile de France',83),(31,'ua','Іль-де-Франс',83),(32,'en','Burgundy',83),(32,'ua','Бургундія',83),(33,'en','Upper Normandy',83),(33,'ua','Верхня Нормандія',83),(34,'en','Corsica',83),(34,'ua','Корсика',83),(35,'en','Languedoc-Roussillon',83),(35,'ua','Лангедок-Руссільйон',83),(36,'en','Lorraine',83),(36,'ua','Лотарингія',83),(37,'en','Lower Normandy',83),(37,'ua','Нижня Нормандія',83),(38,'en','Nord-Pas-de-Calais',83),(38,'ua','Нор-Па-де-Кале',83),(39,'en','Pays de la Loire',83),(39,'ua','Пеї-де-ла-Луар',83),(40,'en','Provence-Alpes-Côte d\'Azur',83),(40,'ua','Прованс-Альпи-Лазурний берег',83),(41,'en','Poitou-Charentes',83),(41,'ua','Пуату-Шарант',83),(42,'en','Midi-Pyrénées',83),(42,'ua','Південь-Піренеї',83),(43,'en','Rhône-Alps',83),(43,'ua','Рона-Альпи',83);
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
  `cost` int(10) unsigned NOT NULL,
  `number_of_rooms` tinyint(4) NOT NULL COMMENT 'Number of rooms in this room type',
  `number_of_people` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_room_hotel_id` (`hotel_id`),
  CONSTRAINT `FK_room_hotel_id` FOREIGN KEY (`hotel_id`) REFERENCES `hotel` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room`
--

LOCK TABLES `room` WRITE;
/*!40000 ALTER TABLE `room` DISABLE KEYS */;
INSERT INTO `room` VALUES (1,1,2000,3,NULL),(2,2,2100,5,NULL),(3,3,600,5,2),(4,3,950,3,3),(5,3,1200,1,2),(6,3,1600,1,2),(7,4,600,1,2),(8,4,700,1,2),(9,4,800,1,2),(10,4,900,1,2),(11,4,900,1,2),(12,4,1100,1,2),(13,5,350,3,2),(14,5,600,3,2),(15,5,650,3,2),(16,5,880,3,3),(17,5,1030,3,3),(18,6,330,5,2),(19,6,410,2,2),(20,6,450,3,2),(21,6,550,3,2),(22,7,2686,7,2),(23,7,3995,7,4);
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
INSERT INTO `room_info` VALUES (1,'en','plaza'),(2,'en','lux'),(3,'en','Standard Double or Twin Room'),(3,'ua','Стандартний двомісний номер/номер Твін'),(4,'en','Standard Triple Room '),(4,'ua','Стандартний тримісний номер '),(5,'en','Junior Suite '),(5,'ua','Напівлюкс '),(6,'en','Suite '),(6,'ua','Люкс'),(7,'en','Standard Double or Twin Room'),(7,'ua','Стандартний двомісний номер/номер Твін'),(8,'en','Comfort Double or Twin Room '),(8,'ua','Двомісний номер \"Комфорт\"/Номер Твін'),(9,'en','Studio'),(9,'ua','Номер-студіо '),(10,'en','Junior Suite'),(10,'ua','Напівлюкс'),(11,'en','Junior Suite with City View'),(11,'ua','Напівлюкс з видом на місто'),(12,'en',' Suite'),(12,'ua','Люкс'),(13,'en','Twin Room with Shared Bathroom '),(13,'ua','Номер Твін зі спільною ванною кімнатою '),(14,'en','Standard Double or Twin Room '),(14,'ua','Стандартний двомісний номер/номер Твін '),(15,'en','Superior Double or Twin Room'),(15,'ua','Покращений двомісний номер/номер Твін '),(16,'en','Family Room'),(16,'ua','Сімейний номер '),(17,'en','Superior Triple Room'),(17,'ua','Покращений тримісний номер '),(18,'en','Standard Twin Room '),(18,'ua','Стандартний номер Твін '),(19,'en','Junior Suite'),(19,'ua','Напівлюкс '),(20,'en','Family Junior Suite'),(20,'ua','Сімейний напівлюкс '),(21,'en','Suite'),(21,'ua','Люкс'),(22,'en','Studio (2 Adults) '),(22,'ua','Номер-студіо (для 2 дорослих) '),(23,'en','One-Bedroom Apartment (4 Adults)'),(23,'ua','Апартаменти з однією спальнею (4 дорослих) ');
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
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;
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
  PRIMARY KEY (`id`,`locale_id`),
  KEY `street_city` (`city_id`),
  KEY `FK_street_locale_id` (`locale_id`),
  CONSTRAINT `FK_street_city_id` FOREIGN KEY (`city_id`) REFERENCES `city` (`id`),
  CONSTRAINT `FK_street_locale_id` FOREIGN KEY (`locale_id`) REFERENCES `locale` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `street`
--

LOCK TABLES `street` WRITE;
/*!40000 ALTER TABLE `street` DISABLE KEYS */;
INSERT INTO `street` VALUES (1,'en','somestreet',1),(2,'en','Staroznesenska Street',1),(2,'ua','Вулиця Старознесенська',1),(3,'en','Virmenska Street',1),(3,'ua','Вулиця Вірменська',1),(4,'en','Pl.Mickiewich',1),(4,'ua','Пл. Міцкевича',1),(5,'en','Franka Street',4),(5,'ua','Вулиця Франка',4),(6,'en','Rue De Caumartin',10);
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

-- Dump completed on 2014-03-20 23:11:53
