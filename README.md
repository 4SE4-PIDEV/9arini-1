# 9arini
9arini est une plate-forme d'apprentissage et d'enseignement en ligne  La mission de 9arini est de créer de nouvelles possibilités pour les personnes et les organisations de la Tunisie.  elle propose une vaste bibliothèque multilingue composée de milliers de cours enseignés par des formateurs confirmés.  Vous pouvez suivre des cours de diverses catégories, dont : affaires et entrepreneuriat, programmation, enseignement supérieur, arts, santé et fitness, langues, musique, et bien plus encore



1.Creation du projet
cd project/
git init                    
git add .                   
git commit  

2.Branching and Merging
 git branch                          show list of all branches (* is active)
git checkout -b linux-work           create a new branch named "linux-work"
git commit -a
git checkout master                  go back to master branch
git merge linux-work                merge changesets from linux-work (Git >= 1.5)
git pull . linux-work               merge changesets from linux-work (all Git versions)
git branch -m oldname newname   rename branch
git branch -m newname             rename current branch
  
  
3.configuration:
git config --global color.diff auto
git config --global color.status auto
git config --global color.branch auto
3.configurer votre nom (ou pseudo)
git config --global user.name "votre_pseudo"
git config --global user.email moi@email.com

4.Cloner un dépôt existant
git clone lien projet
5.Ajout des fichiers dans l’espace de travail collaboratif
cd bom_projet
touch main.c 
cd bom_projet
cd fonction.h
6.Modifier le code source
git add main.c
git add fonction.h
git commit 
git commit -m
git push
7.Récupérer les modifications
git pull origin master
10.Historique avec Git log 
git log




