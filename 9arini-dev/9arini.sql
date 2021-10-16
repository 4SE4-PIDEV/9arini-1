-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : sam. 16 oct. 2021 à 02:21
-- Version du serveur :  5.7.31
-- Version de PHP : 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `9arini`
--

-- --------------------------------------------------------

--
-- Structure de la table `chapitre`
--

DROP TABLE IF EXISTS `chapitre`;
CREATE TABLE IF NOT EXISTS `chapitre` (
  `chapitreID` int(30) NOT NULL AUTO_INCREMENT,
  `coursID` int(11) NOT NULL,
  `videoChapitre` varchar(100) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`chapitreID`),
  KEY `FK_CoursId` (`coursID`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `chapitre`
--

INSERT INTO `chapitre` (`chapitreID`, `coursID`, `videoChapitre`) VALUES
(1, 2, 'video3'),
(2, 3, 'video1'),
(3, 3, 'video1'),
(4, 3, 'video1'),
(5, 3, 'video1'),
(6, 3, 'video1'),
(7, 3, 'video1');

-- --------------------------------------------------------

--
-- Structure de la table `commande`
--

DROP TABLE IF EXISTS `commande`;
CREATE TABLE IF NOT EXISTS `commande` (
  `COL 1` varchar(10) DEFAULT NULL,
  `COL 2` varchar(8) DEFAULT NULL,
  `COL 3` varchar(7) DEFAULT NULL,
  `COL 4` varchar(11) DEFAULT NULL,
  `COL 5` varchar(12) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `commande`
--

INSERT INTO `commande` (`COL 1`, `COL 2`, `COL 3`, `COL 4`, `COL 5`) VALUES
('commandeID', 'panierID', 'coursID', 'formationID', 'prixCommande');

-- --------------------------------------------------------

--
-- Structure de la table `cours`
--

DROP TABLE IF EXISTS `cours`;
CREATE TABLE IF NOT EXISTS `cours` (
  `coursID` int(100) NOT NULL AUTO_INCREMENT,
  `utilisateurID` int(4) NOT NULL,
  `nomCours` varchar(50) COLLATE utf8_bin NOT NULL,
  `nbrChapitres` int(100) NOT NULL,
  PRIMARY KEY (`coursID`),
  KEY `FK_UserId` (`utilisateurID`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `cours`
--

INSERT INTO `cours` (`coursID`, `utilisateurID`, `nomCours`, `nbrChapitres`) VALUES
(1, 1, 'Java', 5),
(7, 1, 'SGBD', 5),
(4, 1, 'SOA', 5),
(5, 1, 'Java', 5);

-- --------------------------------------------------------

--
-- Structure de la table `formation`
--

DROP TABLE IF EXISTS `formation`;
CREATE TABLE IF NOT EXISTS `formation` (
  `formationID` int(100) NOT NULL AUTO_INCREMENT,
  `utilisateurID` int(11) NOT NULL,
  `nomFormation` varchar(100) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`formationID`),
  KEY `FK_UserId` (`utilisateurID`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `formation`
--

INSERT INTO `formation` (`formationID`, `utilisateurID`, `nomFormation`) VALUES
(1, 1, 'Php'),
(2, 1, 'symfony'),
(3, 1, 'symfony');

-- --------------------------------------------------------

--
-- Structure de la table `forum`
--

DROP TABLE IF EXISTS `forum`;
CREATE TABLE IF NOT EXISTS `forum` (
  `forumid` int(11) NOT NULL AUTO_INCREMENT,
  `utilisateurid` int(11) NOT NULL,
  `like` int(11) NOT NULL,
  `dislike` int(11) NOT NULL,
  `comment` varchar(255) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`forumid`)
) ENGINE=MyISAM AUTO_INCREMENT=38 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `forum`
--

INSERT INTO `forum` (`forumid`, `utilisateurid`, `like`, `dislike`, `comment`) VALUES
(33, 7, 9, 7, 'idk'),
(34, 7, 9, 7, 'idk'),
(30, 7, 9, 7, 'update forum works'),
(28, 7, 9, 7, 'idk'),
(32, 7, 9, 7, 'idk'),
(26, 7, 9, 7, 'idk'),
(35, 7, 9, 7, 'idk'),
(36, 7, 9, 7, 'idk'),
(37, 7, 9, 7, 'idk');

-- --------------------------------------------------------

--
-- Structure de la table `panier`
--

DROP TABLE IF EXISTS `panier`;
CREATE TABLE IF NOT EXISTS `panier` (
  `COL 1` varchar(8) DEFAULT NULL,
  `COL 2` varchar(13) DEFAULT NULL,
  `COL 3` varchar(10) DEFAULT NULL,
  `COL 4` varchar(10) DEFAULT NULL,
  `COL 5` varchar(10) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `panier`
--

INSERT INTO `panier` (`COL 1`, `COL 2`, `COL 3`, `COL 4`, `COL 5`) VALUES
('panierID', 'utilisateurID', 'datePanier', 'etatPanier', 'prixPanier'),
('13', '0', '2021-10-15', 'En cours', '200');

-- --------------------------------------------------------

--
-- Structure de la table `publicité`
--

DROP TABLE IF EXISTS `publicité`;
CREATE TABLE IF NOT EXISTS `publicité` (
  `publiciteID` int(10) NOT NULL AUTO_INCREMENT,
  `videoPublicite` varchar(1000) NOT NULL,
  `genre` varchar(5) NOT NULL DEFAULT 'Tous',
  `ageMax` int(3) NOT NULL,
  `ageMin` int(2) NOT NULL,
  `utilisateurID` int(11) NOT NULL,
  `dateFinPublicite` date NOT NULL,
  `dateDebutPublicite` date NOT NULL,
  `lienPublicite` varchar(1000) NOT NULL,
  `nbrClick` int(5) NOT NULL,
  `nbrAffichage` int(5) NOT NULL,
  `imagePublicite` varchar(1000) NOT NULL,
  PRIMARY KEY (`publiciteID`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `publicité`
--

INSERT INTO `publicité` (`publiciteID`, `videoPublicite`, `genre`, `ageMax`, `ageMin`, `utilisateurID`, `dateFinPublicite`, `dateDebutPublicite`, `lienPublicite`, `nbrClick`, `nbrAffichage`, `imagePublicite`) VALUES
(2, 'v', 'H', 30, 18, 1, '2000-07-10', '2000-07-10', 'www.google.com', 25, 5, 'i'),
(3, 'v', 'H', 30, 18, 1, '2000-07-10', '2000-07-10', 'www.google.com', 25, 5, 'i');

-- --------------------------------------------------------

--
-- Structure de la table `reclamation`
--

DROP TABLE IF EXISTS `reclamation`;
CREATE TABLE IF NOT EXISTS `reclamation` (
  `reclamationid` int(11) NOT NULL AUTO_INCREMENT,
  `coursid` int(11) NOT NULL,
  `utilisateurid` int(11) NOT NULL,
  `formateurid` int(11) NOT NULL,
  `formationid` int(11) NOT NULL,
  `etat` varchar(100) COLLATE utf8_bin NOT NULL,
  `message` varchar(255) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`reclamationid`)
) ENGINE=MyISAM AUTO_INCREMENT=37 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `reclamation`
--

INSERT INTO `reclamation` (`reclamationid`, `coursid`, `utilisateurid`, `formateurid`, `formationid`, `etat`, `message`) VALUES
(33, 0, 34, 0, 1, 'en cour', 'cour js not found'),
(32, 0, 34, 0, 1, 'en cour', 'cour js not found'),
(31, 0, 34, 0, 1, 'en cour', 'cour js not found'),
(30, 0, 34, 0, 1, 'en cour', 'update reclamation works'),
(29, 0, 34, 0, 1, 'en cour', 'cour js not found'),
(28, 0, 34, 0, 1, 'en cour', 'cour js not found'),
(27, 0, 34, 0, 1, 'en cour', 'update works'),
(26, 0, 34, 0, 1, 'en cour', 'cour js not found'),
(34, 0, 34, 0, 1, 'en cour', 'cour js not found'),
(35, 0, 34, 0, 1, 'en cour', 'cour js not found'),
(36, 0, 34, 0, 1, 'en cour', 'cour js not found');

-- --------------------------------------------------------

--
-- Structure de la table `ressource`
--

DROP TABLE IF EXISTS `ressource`;
CREATE TABLE IF NOT EXISTS `ressource` (
  `ressourceID` int(100) NOT NULL AUTO_INCREMENT,
  `chapitreID` int(200) NOT NULL,
  PRIMARY KEY (`ressourceID`),
  KEY `FK_ChapitreId` (`chapitreID`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `ressource`
--

INSERT INTO `ressource` (`ressourceID`, `chapitreID`) VALUES
(1, 2),
(3, 2),
(4, 2),
(5, 2),
(6, 2);

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
CREATE TABLE IF NOT EXISTS `utilisateur` (
  `utilisateurID` int(4) NOT NULL AUTO_INCREMENT,
  `utilisateurPDP` text COLLATE utf8_bin NOT NULL,
  `utilisateurPrenom` varchar(20) COLLATE utf8_bin NOT NULL,
  `utilisateurNom` varchar(20) COLLATE utf8_bin NOT NULL,
  `utilisateurGenre` varchar(100) COLLATE utf8_bin NOT NULL,
  `utilisateurDDN` date NOT NULL,
  `utilisateurAdresse` varchar(60) COLLATE utf8_bin NOT NULL,
  `utilisateurPays` varchar(10) COLLATE utf8_bin NOT NULL,
  `utilisateurphone` int(100) NOT NULL,
  `utilisateurFonction` varchar(20) COLLATE utf8_bin NOT NULL,
  `utilisateurOrganisme` varchar(20) COLLATE utf8_bin NOT NULL,
  `utilisateurSavoirEtre` text COLLATE utf8_bin NOT NULL,
  `utilisateurAdresseEmail` varchar(60) COLLATE utf8_bin NOT NULL,
  `utilisateurMDP` varchar(5000) COLLATE utf8_bin NOT NULL,
  `utilisateurRole` varchar(10) COLLATE utf8_bin NOT NULL,
  `nomEntreprise` varchar(20) COLLATE utf8_bin NOT NULL,
  `EntrepreneurSiteWeb` varchar(60) COLLATE utf8_bin NOT NULL,
  `EntrepreneurUsage` text COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`utilisateurID`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`utilisateurID`, `utilisateurPDP`, `utilisateurPrenom`, `utilisateurNom`, `utilisateurGenre`, `utilisateurDDN`, `utilisateurAdresse`, `utilisateurPays`, `utilisateurphone`, `utilisateurFonction`, `utilisateurOrganisme`, `utilisateurSavoirEtre`, `utilisateurAdresseEmail`, `utilisateurMDP`, `utilisateurRole`, `nomEntreprise`, `EntrepreneurSiteWeb`, `EntrepreneurUsage`) VALUES
(6, 'ali', ' Ben Ali', ' Ben Ali', ' Ben Ali', '2021-10-14', ' Ben Ali', ' Ben Ali', 0, ' Ben Ali', ' Ben Ali', ' Ben Ali', ' Ben Ali', ' Ben Ali', ' Ben Ali', ' Ben Ali', ' Ben Ali', ' Ben Ali'),
(7, 'ali', ' Ben Ali', ' Ben Ali', ' Ben Ali', '1970-01-01', ' Ben Ali', ' Ben Ali', 0, ' Ben Ali', ' Ben Ali', ' Ben Ali', ' Ben Ali', ' Ben Ali', ' Ben Ali', ' Ben Ali', ' Ben Ali', ' Ben Ali'),
(8, 'ali', ' Ben Ali', ' Ben Ali', ' Ben Ali', '1970-01-01', ' Ben Ali', ' Ben Ali', 0, ' Ben Ali', ' Ben Ali', ' Ben Ali', ' Ben Ali', ' Ben Ali', ' Ben Ali', ' Ben Ali', ' Ben Ali', ' Ben Ali'),
(9, 'ali', ' Ben Ali', ' Ben Ali', ' Ben Ali', '2021-10-14', ' Ben Ali', ' Ben Ali', 0, ' Ben Ali', ' Ben Ali', ' Ben Ali', ' Ben Ali', ' Ben Ali', ' Ben Ali', ' Ben Ali', ' Ben Ali', ' Ben Ali'),
(10, 'ali', ' Ben Ali', ' Ben Ali', ' Ben Ali', '2021-10-14', ' Ben Ali', ' Ben Ali', 0, ' Ben Ali', ' Ben Ali', ' Ben Ali', ' Ben Ali', ' Ben Ali', ' Ben Ali', ' Ben Ali', ' Ben Ali', ' Ben Ali'),
(11, 'ali', ' Ben Ali', ' Ben Ali', ' Ben Ali', '1970-01-01', ' Ben Ali', ' Ben Ali', 0, ' Ben Ali', ' Ben Ali', ' Ben Ali', ' Ben Ali', ' Ben Ali', ' Ben Ali', ' Ben Ali', ' Ben Ali', ' Ben Ali'),
(12, 'mmmm', ' Ben Ali', ' Ben Ali', ' Ben Ali', '1970-01-01', ' Ben Ali', ' Ben Ali', 0, ' Ben Ali', ' Ben Ali', ' Ben Ali', ' Ben Ali', ' Ben Ali', ' Ben Ali', ' Ben Ali', ' Ben Ali', ' Ben Ali'),
(13, 'ali', ' Ben Ali', ' Ben Ali', ' Ben Ali', '1970-01-01', ' Ben Ali', ' Ben Ali', 0, ' Ben Ali', ' Ben Ali', ' Ben Ali', ' Ben Ali', ' Ben Ali', ' Ben Ali', ' Ben Ali', ' Ben Ali', ' Ben Ali'),
(14, 'mmmmmm', ' Ben Ali', ' Ben Ali', ' Ben Ali', '2021-10-14', ' Ben Ali', ' Ben Ali', 0, ' Ben Ali', ' Ben Ali', ' Ben Ali', ' Ben Ali', ' Ben Ali', ' Ben Ali', ' Ben Ali', ' Ben Ali', ' Ben Ali'),
(15, 'mmmmmm', ' Ben Ali', ' Ben Ali', ' Ben Ali', '1970-01-01', ' Ben Ali', ' Ben Ali', 0, ' Ben Ali', ' Ben Ali', ' Ben Ali', ' Ben Ali', ' Ben Ali', ' Ben Ali', ' Ben Ali', ' Ben Ali', ' Ben Ali'),
(16, 'mmmmmm', ' Ben Ali', ' Ben Ali', ' Ben Ali', '3900-11-10', ' Ben Ali', ' Ben Ali', 0, ' Ben Ali', ' Ben Ali', ' Ben Ali', ' Ben Ali', ' Ben Ali', ' Ben Ali', ' Ben Ali', ' Ben Ali', ' Ben Ali'),
(17, 'mmmmmm', ' Ben Ali', ' Ben Ali', ' Ben Ali', '1970-01-01', ' Ben Ali', ' Ben Ali', 0, ' Ben Ali', ' Ben Ali', ' Ben Ali', ' Ben Ali', ' Ben Ali', ' Ben Ali', ' Ben Ali', ' Ben Ali', ' Ben Ali'),
(18, 'mmmmmm', ' Ben Ali', ' Ben Ali', ' Ben Ali', '1916-04-22', ' Ben Ali', ' Ben Ali', 0, ' Ben Ali', ' Ben Ali', ' Ben Ali', ' Ben Ali', ' Ben Ali', ' Ben Ali', ' Ben Ali', ' Ben Ali', ' Ben Ali'),
(19, 'mmmmmm', ' Ben Ali', ' Ben Ali', ' Ben Ali', '3900-11-10', ' Ben Ali', ' Ben Ali', 0, ' Ben Ali', ' Ben Ali', ' Ben Ali', ' Ben Ali', ' Ben Ali', ' Ben Ali', ' Ben Ali', ' Ben Ali', ' Ben Ali'),
(20, 'mmmmmm', ' Ben Ali', ' Ben Ali', ' Ben Ali', '2000-11-10', ' Ben Ali', ' Ben Ali', 0, ' Ben Ali', ' Ben Ali', ' Ben Ali', ' Ben Ali', ' Ben Ali', ' Ben Ali', ' Ben Ali', ' Ben Ali', ' Ben Ali'),
(21, 'mmmmmm', ' Ben Ali', ' Ben Ali', ' Ben Ali', '2000-11-10', ' Ben Ali', ' Ben Ali', 0, ' Ben Ali', ' Ben Ali', ' Ben Ali', ' Ben Ali', ' Ben Ali', ' Ben Ali', ' Ben Ali', ' Ben Ali', ' Ben Ali'),
(22, 'mmmmmm', ' Ben Ali', ' Ben Ali', ' Ben Ali', '2000-11-10', ' Ben Ali', ' Ben Ali', 0, ' Ben Ali', ' Ben Ali', ' Ben Ali', ' Ben Ali', '558b905d0f2f2300eb08b0b745cfdc46a798fdcaa67d87461cc8b5dc13404b9c', ' Ben Ali', ' Ben Ali', ' Ben Ali', ' Ben Ali'),
(23, 'mmmmmm', ' Ben Ali', ' Ben Ali', ' Ben Ali', '2000-07-10', ' Ben Ali', ' Ben Ali', 217335, ' Ben Ali', ' Ben Ali', ' Ben Ali', ' Ben Ali', '558b905d0f2f2300eb08b0b745cfdc46a798fdcaa67d87461cc8b5dc13404b9c', ' Ben Ali', ' Ben Ali', ' Ben Ali', ' Ben Ali'),
(24, 'cccc', ' Ben Ali', ' Ben Ali', ' Ben Ali', '2000-07-10', ' Ben Ali', ' Ben Ali', 217335, ' Ben Ali', ' Ben Ali', 'null', ' Ben Ali', '558b905d0f2f2300eb08b0b745cfdc46a798fdcaa67d87461cc8b5dc13404b9c', ' Ben Ali', 'null', 'null', 'null'),
(25, 'cccc', ' Ben Ali', ' Ben Ali', ' Ben Ali', '2000-07-10', ' Ben Ali', ' Ben Ali', 217335, ' Ben Ali', ' Ben Ali', 'null', ' Ben Ali', '558b905d0f2f2300eb08b0b745cfdc46a798fdcaa67d87461cc8b5dc13404b9c', ' Ben Ali', 'null', 'null', 'null'),
(26, 'cccc', ' Ben Ali', ' Ben Ali', ' Ben Ali', '2000-07-10', ' Ben Ali', ' Ben Ali', 217335, ' Ben Ali', ' Ben Ali', 'null', ' Ben Ali', '558b905d0f2f2300eb08b0b745cfdc46a798fdcaa67d87461cc8b5dc13404b9c', ' Ben Ali', 'null', 'null', 'null');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
