# potatoes [![Build Status](https://travis-ci.org/projetRecettesTests/potatoes.svg?branch=master)](https://travis-ci.org/projetRecettesTests/potatoes) [![codecov](https://codecov.io/gh/projetRecettesTests/potatoes/branch/master/graph/badge.svg)](https://codecov.io/gh/projetRecettesTests/potatoes)

Enoncé du projet

Langage au choix

Sujet "libre", avec contraintes :
 - beaucoup de tests (au moins 50 % de tests en volume de code)
 - analyse de la couverture de code
 - utiliser le système d'issue github
 - avoir 1 interface avec au moins 1 test de l'interface (simule des clics sur des boutons)
 - intégrer travis au projet
 - MVC, attends un code propre

Complexité, par ex :
 - Jeu de puissance 4 avec des règles additionnelle
(faut des fonctionnalités bizarres pour montrer qu'on les a bien testées)
 - Jeu de la vie++
 - Démineur...++

Présentation de 10 minutes
 - 5 minutes présentation du framework de test utilisé (comment on fait les fonctionnalistés principales ? Les features...)
 - 5 min présentation projet


Date butoire : dernière séance, présentation. Code à rendre le dimanche soir à la fin de la semaine


Le projet : Potatoes

Version de base :
- Grille remplie de patates saines + 1 patate contaminée positionnée aléatoirement
- Clic pour creuser et tenter d'isoler la patate contaminée pour l'empêcher de contaminer ses voisines
- A chaque clic de la souris : évolution des patates
- Après X minutes : "pleine lune", Apocalypse de patates, jugement dernier


Les 4 états des patates :
 - Saines
 - Contamin�es (porteur sain)
 - Contaminantes
 - Zone morte

Changement d'état patate
 - Patate contaminée -> contaminante : 3 clics
 - Patate contaminante -> zone morte : autant de fois que de patates à contaminer + x ?
 - (Signal) ?

Patate contaminante :
- toutes les voisines saines (= 8) : contamine 3 voisines aléatoirement
- 1 à 3 voisine contaminée/morte/creusée : contamine 2 autres voisines
- 4 à 6 voisines contaminée/morte/creusée : contamine 1 autre voisine
- 7 à 8 voisines contaminée/morte/creusée : contamine 0 voisines

Potatoes++ :
 - Gestion des niveaux (nombre de patates contaminées + temps avant la pleine lune)
 - Personnalisation (taille grille...)
 - Eau bénite placée aléatoirement : permet de ressusciter une patate contaimnée récoltée
 - 1 ligne horizontale creusée : super patate : transforme en patate saines une zone de zone morte
 - 1 ligne verticale creusée : rajoute x secondes avant pleine lune
 - Combo : 5 patates saines récoltées à la suite comptent pour 10
 - Quelque chose : Rends insensible à la morsure pendant x clics : permet de déterrer des patates contaminantes (comptent pour 0 )


Certificats de décès aléatoire: mort par morsure de patate...

Cahier de recette
Classes :
 - Grille
 - Cases (2 états : occupée ou creusée)
 - Patates (4 états)
 - Game
 - Joueur ?

Grille :
 - création de la grille
 - remplissage de la grille
 - accéder à une case
 - placement de la patate contaminée

Case :
-	création des cases ?
-	changement d'état (occupée / creusée)
	- creuser une case occupée
	- creuser une case déjà creusée

Un clic dans la grille doit :
 - creuser la bonne case
 - faire évoluer les patates (changement d'état + contamination)

Patates :
-	Changement d'état
-	Contamination (en fonction du nombre de voisines)
	- les différents cas « normaux » de contamination.
	- si toutes les patates sont contaminées ?
	- si plus de patates contaminantes ?
	- si que zone morte comme voisines ?

Creuser : réaction en fonction des états de la patate contenue
 - Case occupée :
	 - patate saine : + 1 dans notre camp
	 - contaminée : récolte une patate "morte" : compte pour 0, ou pour 1 si eau bénite (++)
	 - contaminante + signal : morsure par la patate, mort du joueur, game over
	 - zone morte : increusable
 - Case creusée : increusable

Pleine Lune :
 - Après X minutes : si plus de patatates saines : victoire
 - si plus de patates contaminées : mort
 - si 50/50 : fin alternative
Si plus possible de jouer avant la fin ?


TODO :
[x] Remplir la grille de patates
[x] Changer les patates d'état (pattern state ?)
[x] Placer la patate contaminée
[x] Contaminer !
[ ] Ajouter des tests
[ ] Ajouter des prompts
[ ] Afficher les stats du jeu (patates saines récoltées...)
[ ] Ajouter une classe joueur ?
[ ] Améliorer la contamination ?
 
