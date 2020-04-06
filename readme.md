eBibli-backend

Backend du système d'information des bibliothèques de la ville à destination des usagers et des bibliothécaires.
Les différents clients interrogent ce backend via les API Rest exposées.

Pré-requis technique

Version de Java : 1.8
 JDK : jdk1.8.0_202
 Maven 3.6.0

Base de données : PostgresSQL

Installation et déploiement:

Packaging
mvn clean package : le fichier ebibli-backend-1.0.war qui contient l'application est généré

Il est maintenant possible de lancer l'application directement dans votre IDE en exécutant le Main
ou en ligne de commande (application standalone intégrant un conteneur web grace à SpringBoot) : mvn clean install spring-boot:run
ou de déployer le war dans un tomcat.

Le port de l'Application est paramétré dans application.propertie : http://localhost:8081/

L'application est livrée avec 1 configuration
•dev et prod avec une base de données PostgreSQL peuplée avec le contenu du script src\resources\data.sql. 
La base sera créée automatiquement au premier lancement.
En prod, il faudra ensuite modifier le ddl-auto=update dans le fichier application.properties pour qu'elle ne se recrée pas à chaque démarrage.

Documentation : la javadoc peut être générée via la commande mvn javadoc:javadoc puis consultée à partir de la page \target\site\apidocs\index.html

Un projet postman pour tester les API est présent dans le répertoire resources/postman

Comptes utilisateurs en base :
user@oc.com / USER = compte utilisateur
membre@oc.com / MEMBRE = compte membre de l'association
admin@oc.com / ADMIN = compte administrateur
dupont@oc.com / DUPONT = utilisateur
dubois@oc.com / DUBOIS = utilisateur
smith@oc.com / SMITH = utilisateur

Sources disponibles sur : https://github.com/GLescroel/ebibli-backend
