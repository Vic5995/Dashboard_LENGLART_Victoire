#PROJET DASHBOARD COVID

Réalisé par **Victoire LENGLART**, FIL A1.
Rendu 25/11/2020, version console.

##Ressources utilisées

 * Java 15
 * JBDC : sqlite

##Mode d'emploi

Lors de l'ouverture de l'application côté client, la console propose 3 options :
1. le profil *étudiant* avec la saisie du formulaire ;
2. le profil *professeur* avec l'affichage des différentes statistiques sur les présences ;
3. la possibilité de quitter l'application est aussi disponible.

###Saisie

Pour toute saisie nécessaire au cours de l'utilisation, cliquer sur la console et saisir l'information demandée.
Appuyer sur **Entrée** ensuite afin de valider la saisie.

 ###Formulaire

 1. Authentification : saisir le login et le mot de passe successivement. Pour chaque utilisateur le login
 est le prénom suivi directement du nom sans majuscule ni aucun accent ou caractère spécial.
 Par exemple, pour Victoire Lenglart, le login devient *victoirelenglart*. Pour le mot de passe,
 il s'agit du prénom sans majuscule ni aucun accent ou caractère spécial. Dans le même exemple, le mot de passe
 devient *victoire*.
 2. Ensuite plusieurs questions sont posées afin de mettre à jour le profil de l'étudiant connecté.
 3. Une fois la saisie terminée, la mise à jour est envoyée au serveur.
 4. Une fois l'enoi exécuté, un récapitulatif de l'état actuel est affiché.
 5. L'action de **Déconnexion** ramène l'utilisateur à l'écran d'accueil.

###Dashboard

Les seule saisies autorisées sont celles permettant la navigation entre les différents niveaux
de détails.
Du plus large au plus précis, on peut ainsi voir :
* L'état général de tous les étudiants inscrits ;
* L'état général de tous les étudiants inscrits avec plus de détails dans les types d'absences ;
* L'état général par formation (FIL, FIT et FISE) ;
* l'état général pour chaque année de chaque formation ;
* Une vue détaillée de chaque année de formation avec la liste nominative des étudiants.

##Remarques

* Les noms utilisés dans la base de données sont des listes générées aléatoirement, à part
pour les FIL A1, ces étudiants n'existent pas.
* Le script ayant généré la base de données fait partie des ressources, n'hésitez pas à le consulter
en cas de difficultés avec les données.

