CREATE TABLE `secondHouse` (
  `uniqueId` varchar(30) NOT NULL,
  `recordId` varchar(30) NOT NULL,
  `postDate` varchar(30) NOT NULL,
  `division` varchar(10) NOT NULL,
  `houseCentificationId` varchar(30) NOT NULL,
  `proxy` varchar(100) NOT NULL,
  `houseName` varchar(30) DEFAULT NULL,
  `square` int(10) NOT NULL,
  `price` int(10) NOT NULL,
  PRIMARY KEY (`uniqueId`,`recordId`),
  KEY `ondate` (`postDate`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `soldOutHouse` (
  `id` varchar(30) NOT NULL,
  `name` varchar(300) NOT NULL,
  `soldOutDate` varchar(30) NOT NULL,
  `totalPrice` varchar(30) NOT NULL,
  `unitPrice` varchar(30) NOT NULL,
  `expectedPrice` varchar(30) NOT NULL,
  `layout` varchar(30) NOT NULL,
  `floor` varchar(30) NOT NULL,
  `square` varchar(30) NOT NULL,
  `structure` varchar(30) NOT NULL,
  `direction` varchar(10) NOT NULL,
  `age` varchar(10) DEFAULT NULL,
  `fixture` varchar(10) NOT NULL,
  `elevator` varchar(30) NOT NULL,
  `usageYear` varchar(10) NOT NULL,
  `hasElevator` varchar(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `ondate` (`soldOutDate`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;