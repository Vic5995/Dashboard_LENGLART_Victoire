*English below*

# PROJET DASHBOARD COVID

Réalisé par **Victoire L**.
Rendu 25/11/2020, version console.

## Ressources utilisées

 * Java 15
 * JBDC : sqlite

## Mode d'emploi

Lors de l'ouverture de l'application côté client, la console propose 3 options :
1. le profil *étudiant* avec la saisie du formulaire ;
2. le profil *professeur* avec l'affichage des différentes statistiques sur les présences ;
3. la possibilité de quitter l'application est aussi disponible.

### Saisie

Pour toute saisie nécessaire au cours de l'utilisation, cliquer sur la console et saisir l'information demandée.
Appuyer sur **Entrée** ensuite afin de valider la saisie.

 ### Formulaire

 1. Authentification : saisir le login et le mot de passe successivement. Pour chaque utilisateur le login
 est le prénom suivi directement du nom sans majuscule ni aucun accent ou caractère spécial.
 Par exemple, pour Victoire Lenglart, le login devient *victoirelenglart*. Pour le mot de passe,
 il s'agit du prénom sans majuscule ni aucun accent ou caractère spécial. Dans le même exemple, le mot de passe
 devient *victoire*.
 2. Ensuite plusieurs questions sont posées afin de mettre à jour le profil de l'étudiant connecté.
 3. Une fois la saisie terminée, la mise à jour est envoyée au serveur.
 4. Une fois l'envoi exécuté, un récapitulatif de l'état actuel est affiché.
 5. L'action de **Déconnexion** ramène l'utilisateur à l'écran d'accueil.

### Dashboard

Les seule saisies autorisées sont celles permettant la navigation entre les différents niveaux
de détails.
Du plus large au plus précis, on peut ainsi voir :
* L'état général de tous les étudiants inscrits ;
* L'état général de tous les étudiants inscrits avec plus de détails dans les types d'absences ;
* L'état général par formation ;
* l'état général pour chaque année de chaque formation ;
* Une vue détaillée de chaque année de formation avec la liste nominative des étudiants.

## Remarques

* Les noms utilisés dans la base de données sont des listes générées aléatoirement, ces étudiants n'existent pas.
* Le script ayant généré la base de données fait partie des ressources, n'hésitez pas à le consulter
en cas de difficultés avec les données.


# 🇬🇧🇺🇸 COVID DASHBOARD PROJECT

Made by **Victoire L**.
Rendered 11/25/2020, console version.

## Resources used

* Java 15
* JBDC : sqlite

## How to use

When opening the client-side application, the console offers 3 options:
1. the *student* profile with the form entry ;
2. the *teacher* profile with the display of the various statistics on attendance;
3. the possibility to quit the application is also available.

### Input

For any input required during use, click on the console and enter the requested information.
Then press **Enter** to validate the entry.

### Form

1. Authentication: enter the login and the password successively. For each user the login
   is the first name followed directly by the last name without capital letters or any accent or special character.
   For example, for Victoire Lenglart, the login becomes *victoirelenglart*. For the password,
   it is the first name without capitalization or any accent or special character. In the same example, the password
   becomes *victoire*.
2. Then several questions are asked to update the profile of the connected student.
3. Once the input is complete, the update is sent to the server.
4. Once the upload is complete, a summary of the current status is displayed.
5. The **Logout** action returns the user to the home screen.

### Dashboard

The only entries allowed are those allowing navigation between the different levels of
levels of detail.
From the widest to the most precise, you can see :
* The general status of all registered students;
* The general status of all registered students with more details in the types of absences;
* The general status by course;
* The general status for each year of each formation;
* A detailed view of each year of training with the list of students by name.

## Remarks

* The names used in the database are randomly generated lists, these students do not exist.
* The script that generated the database is part of the resources, do not hesitate to consult it in case of difficulties with the data.

