-- phpMyAdmin SQL Dump
-- version 5.1.2
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost:3306
-- Généré le : mar. 07 jan. 2025 à 17:41
-- Version du serveur : 5.7.24
-- Version de PHP : 8.3.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `cve`
--

-- --------------------------------------------------------

--
-- Structure de la table `cve`
--

CREATE TABLE `cve` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cveID` text,
  `state` text,
  `datePublished` date DEFAULT NULL,
  `dateUpdated` date DEFAULT NULL,
  `title` text,
  `vendor` text,
  `product` text,
  `version_product` text,
  `status_product` text,
  `descriptions` text,
  `cvss_baseScore` float DEFAULT NULL,
  `technical-description` text,
  `exploit` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `cve`
--

INSERT INTO `cve` (`id`, `cveID`, `state`, `datePublished`, `dateUpdated`, `title`, `vendor`, `product`, `version_product`, `status_product`, `descriptions`, `cvss_baseScore`, `technical-description`, `exploit`) VALUES
(1, 'CVE-2024-1002', 'PUBLISHED', '2024-01-29', '2023-08-01', 'Totolink N200RE cstecgi.cgi setIpPortFilterRules stack-based overflow', 'Totolink', 'N200RE', '9.3.5u.6139_B20201216', 'affected', 'A vulnerability classified as critical was found in Totolink N200RE 9.3.5u.6139_B20201216. Affected by this vulnerability is the function setIpPortFilterRules of the file /cgi-bin/cstecgi.cgi. The manipulation of the argument ePort leads to stack-based buffer overflow. The attack can be launched remotely. The exploit has been disclosed to the public and may be used. The associated identifier of this vulnerability is VDB-252271. NOTE: The vendor was contacted early about this disclosure but did not respond in any way.', 7.2, 'https://vuldb.com/?id.252271', 'https://jylsec.notion.site/TOTOLINK-N200RE-has-stack-buffer-overflow-vulnerability-in-setIpPortFilterRules-71c3f0a947e14b7f95fa19b7d6676994?pvs=4');
INSERT INTO `cve` (`id`, `cveID`, `state`, `datePublished`, `dateUpdated`, `title`, `vendor`, `product`, `version_product`, `status_product`, `descriptions`, `cvss_baseScore`, `technical-description`, `exploit`) VALUES 
(2, 'CVE-2024-7000', 'PUBLISHED', '2024-08-06', '2024-08-07', 'CISA ADP Vulnrichment', 'google', 'chrome', '127.0.6533.72', 'affected', 'Use after free in CSS in Google Chrome prior to 127.0.6533.72 allowed a remote attacker who convinced a user to engage in specific UI gestures to potentially exploit heap corruption via a crafted HTML page. (Chromium security severity: Medium)', '8.8', NULL, NULL);
INSERT INTO `cve` (`id`, `cveID`, `state`, `datePublished`, `dateUpdated`, `title`, `vendor`, `product`, `version_product`, `status_product`, `descriptions`, `cvss_baseScore`, `technical-description`, `exploit`) VALUES 
(3, 'CVE-2024-7000', 'DOWN', '2024-08-06', '2024-08-07', 'CISA ADP Vulnrichment', 'google', 'chrome', '127.0.6533.72', 'affected', 'Use after free in CSS in Google Chrome prior to 127.0.6533.72 allowed a remote attacker who convinced a user to engage in specific UI gestures to potentially exploit heap corruption via a crafted HTML page. (Chromium security severity: Medium)', '8.8', NULL, NULL);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `cve`
--
ALTER TABLE `cve`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `cve`
--
ALTER TABLE `cve`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
