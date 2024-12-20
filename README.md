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