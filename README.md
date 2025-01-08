# Présentation

Nous vous présentons notre projet de recherche de cve basé sur une base de donnée. Projet réaliser par Hugo Bossou, Irwin Duprez-Bourgneuf, Bastien Losco, Mathis Boschian

# Suivi

JAVA -> database NON
database OUI
php OUI
android studio NON

# Android-CVE

Les CVE (Common Vulnerabilities and Exposures) regroupent des défaillances et des vulnérabilités identifiables grâce à un identifiant unique, une version, un titre et une description pour chaque type de défaillance. 

L'objectif de notre projet est de créer une application Android permettant aux utilisateurs de rechercher une faille spécifique. Cette application disposera d'une base de données contenant toutes les défaillances recensées provenant du sit : https://cve.mitre.org/

Chaque CVE correspond à une défaillance spécifique, classée selon plusieurs échelles. La base de données inclut toutes les CVE publiées uniquement pour l’année 2024.
Un fichier (JSON) contient la liste de toutes les CVE et sera lisible par l'application.  Ces données seront ensuite transmises à une base de données qui communiquera avec l'application.
L'application associera les versions d'Android des utilisateurs aux types de CVE correspondants. Une base de données contenant les versions permettra de comparer les recherches des utilisateurs avec les données disponibles. Ainsi, lorsqu'un utilisateur effectue une recherche en fonction de  la date, l’application une comparaison sera effectuée avec les mots-clés enregistrés dans la base de données.
Plan d'action :
Fichier source : Préparer un fichier contenant toutes les CVE (plus de 1000 entrées).
Traitement des données : Un programme Java récupérera les données et les transmettra à une base de données.
Mise à disposition : La base de données renvoie ces informations disponibles via un site web, au format JSON.
Application Android : L'application récupérera les données depuis le site web et les affichera à l'utilisateur.

# Fichier source
lien : https://www.cve.org/downloads

# Virtuel

mathis :
"C:\Program Files\VirtViewer v11.0-256\bin\remote-viewer.exe" --spice-ca-file=C:\Users\bosch\OneDrive\Documents\Cours\2eme\cacert.pem spice://10.3.100.11:24912?tls-port=24913

mdp: e4FJWmcYnGrT8Tt

Irwin:

"C:\Program Files\VirtViewer v11.0-256\bin\remote-viewer.exe" --spice-ca-file=C:\Users\irwin\Documents\Irwin\cacert.pem spice://10.3.100.11:24912?tls-port=24913

mdp: e4FJWmcYnGrT8Tt

Hugo:


Bastien:
"C:\Program Files\VirtViewer v11.0-256\bin\remote-viewer.exe" --spice-ca-file=C:\Users\phcol\Documents\cacert.pem spice://10.3.100.11:24912?tls-port=24913

mdp: e4FJWmcYnGrT8Tt

# les class en java -> les fonctions

Readjsonfile -> readfile, readjson, Transformfordatabase
Database -> Connecttodatabase, savetoDatabase
Main 

# DATABASE

[cve.sql](./cve.sql)

# SITE WEB (PHP)

[PHP](./php)

# Info CVE
"cveMetadata": {
    "cveId": "CVE-2024-1002",
        "state": "PUBLISHED",
        "datePublished": "2024-01-29T14:00:06.271Z",
        "dateUpdated": "2024-08-01T18:26:30.487Z"
    },
    "containers": {
        "cna": {
            "title": "Totolink N200RE cstecgi.cgi setIpPortFilterRules stack-based overflow",
            "affected": [
                {
                    "vendor": "Totolink",
                    "product": "N200RE",
                    "versions": [
                        {
                            "version": "9.3.5u.6139_B20201216",
                            "status": "affected"
                        }
                    ]
                }
            ],
            "descriptions": [
                {
                    "lang": "en",
                    "value": "A vulnerability classified as critical was found in Totolink N200RE 9.3.5u.6139_B20201216. Affected by this vulnerability is the function setIpPortFilterRules of the file /cgi-bin/cstecgi.cgi. The manipulation of the argument ePort leads to stack-based buffer overflow. The attack can be launched remotely. The exploit has been disclosed to the public and may be used. The associated identifier of this vulnerability is VDB-252271. NOTE: The vendor was contacted early about this disclosure but did not respond in any way."
                },
            ],
            "metrics": [
                {
                    "cvssV3_1": {
                        "version": "3.1",
                        "baseScore": 7.2,
                    }
                },
                {
                    "cvssV3_0": {
                        "version": "3.0",
                        "baseScore": 7.2,
                    }
                },
                {
                    "cvssV2_0": {
                        "version": "2.0",
                        "baseScore": 8.3,
                    }
                }
            ],
            "references": [
                {
                    "url": "https://vuldb.com/?id.252271",
                    "tags": [
                        "vdb-entry",
                        "technical-description"
                    ]
                },
                {
                    "url": "https://jylsec.notion.site/TOTOLINK-N200RE-has-stack-buffer-overflow-vulnerability-in-setIpPortFilterRules-71c3f0a947e14b7f95fa19b7d6676994?pvs=4",
                    "tags": [
                        "exploit"
                    ]
                }
            ]
        },
    }
