# Android-CVE - Recherche de Vulnérabilités CVE

## 📌 Présentation

Android-CVE est une application permettant de rechercher des vulnérabilités issues de la base de données **MITRE CVE**. Ce projet a initialement été réalisé par **Hugo B., Irwin D.-B., Bastien L. et Mathis B.** Il est maintenant maintenu en solo.

L'application repose sur un système **client-serveur** avec :

- 🖥️ **Un backend en Java** qui récupère les données JSON de MITRE et les stocke dans une base de données.
- 🌐 **Une API en PHP** qui permet d'interroger la base de données selon les requêtes utilisateur.
- 📱 **Une application Android** développée sous Android Studio qui affiche les informations de vulnérabilités.

## 🎯 Objectif du projet

L'objectif principal est de fournir une application permettant aux utilisateurs de **rechercher des vulnérabilités** (également appelées **CVE**) enregistrées sur la base de données **MITRE**.

L'application permet :

- 🔍 La consultation des CVE par **identifiant, date ou mots-clés**.
- 🔗 L'association des versions d'Android des utilisateurs avec les **CVE correspondantes**.
- 📄 L'affichage d'**informations détaillées** sur chaque vulnérabilité.

## 🏗️ Architecture du projet

### 🛠️ 1. Extraction et traitement des données

- 📥 Récupération des données depuis **MITRE** sous format **JSON**.
- 🗄️ Stockage des informations dans une **base de données SQL**.
- 🔄 Traitement et structuration des données via un programme **Java**.

### 🌐 2. API PHP

- 📡 Fournit des **endpoints** permettant d'interroger la base de données.
- 🔄 Répond aux requêtes de l'application mobile.

### 📱 3. Application Android

- 📡 Effectue des **requêtes à l'API PHP**.
- 📊 Affiche les **résultats des recherches** à l'utilisateur.
- 🔗 Compare les **versions d'Android aux CVE correspondantes**.

## 🛠️ Technologies utilisées

- **Backend** : Java, JDBC pour la gestion de la base de données.
- **Base de données** : MySQL
- **API** : PHP, SQL
- **Frontend** : Java (Android Studio)

## 📂 Organisation du code

### 🔹 1. Backend Java

- `ReadJsonFile` : 📜 Traitement des fichiers JSON (**lecture et transformation** pour insertion en base).
- `Database` : 🗄️ Gestion des **connexions et stockage des données**.
- `Main` : 🚀 **Lancement principal** de l'application backend.

### 🔹 2. Base de données

- 📑 Schéma SQL disponible ici : [cve.sql](./cve.sql)

### 🔹 3. API PHP

- 📜 Code source disponible ici : [PHP](./php)

### 🔹 4. Informations CVE

- 📄 Exemple de schéma JSON pour une CVE : [Exemple CVE JSON](https://github.com/cveproject/cve-schema/blob/main/schema/docs/cnaContainer-basic-example.json)

## 🌍 Source des CVE

Les CVE sont disponibles à l'adresse suivante : [🔗 CVE MITRE](https://www.cve.org/downloads)

## 🚀 Statut d'avancement

- ✅ **Backend Java** : En cours de finalisation
- ✅ **Base de données** : Complète
- ✅ **API PHP** : Fonctionnelle
- 🔄 **Application Android** : En cours de développement

## 🔒 Accès distant (Virtuel)

*📌 Informations d'accès retirées pour raisons de sécurité.*

---

💡 Ce projet est toujours en cours d'amélioration. **N'hésitez pas à proposer des contributions ou à signaler des problèmes !** 🚀

