# 🔐 Collab Authentification

> Application desktop Java permettant l'inscription et la connexion d'utilisateurs, avec application des concepts de cybersécurité et de CI/CD.

---

## 📌 Description

**Collab Authentification** est une application desktop développée en **Java** dans un contexte collaboratif. Elle implémente un système d'authentification complet (login / sign up) en appliquant des concepts de **cybersécurité** pour sécuriser les données des utilisateurs. Le projet intègre également une pipeline **CI/CD** via **GitHub Actions** et une analyse de qualité du code avec **SonarQube**.

---

## 🎯 Fonctionnalités

- 📝 **Inscription** — Création d'un compte utilisateur
- 🔑 **Connexion** — Authentification sécurisée des utilisateurs
- 🛡️ **Cybersécurité** — Application de concepts de sécurité (hachage de mots de passe, protection des données)
- 🗄️ **Base de données SQLite** — Stockage local des utilisateurs via `users.db`
- ⚙️ **CI/CD** — Pipeline automatisée avec GitHub Actions
- 🔍 **SonarQube** — Analyse statique de la qualité et de la sécurité du code

---

## 🛠️ Technologies utilisées

| Technologie | Rôle |
|---|---|
| **Java** | Langage principal de l'application |
| **Javadoc** | Documentation du projet |
| **HTML / CSS / JavaScript** | Consulter la documentation génerée par Javadoc |
| **SQLite** | Base de données locale (`users.db`) |
| **GitHub Actions** | Pipeline CI/CD |
| **SonarQube** | Analyse de la qualité du code |

---

## 🚀 Installation

### Prérequis

- [JDK 11+](https://www.oracle.com/java/technologies/downloads/) installé
- Un IDE Java (Eclipse, IntelliJ IDEA, etc.)

### Étapes

```bash
# Cloner le dépôt
git clone https://github.com/AmbiNtsoah/Collab_Authentification.git

# Se déplacer dans le répertoire
cd Collab_Authentification
```

Ouvrir le projet dans votre IDE Java, puis compiler et exécuter la classe principale depuis le dossier `src/`.

---

## ⚙️ CI/CD

Le projet utilise **GitHub Actions** pour automatiser les étapes de build et de test à chaque push ou pull request. La configuration se trouve dans `.github/workflows/`.

L'intégration de **SonarQube** (configurée via `sonar-project.properties`) permet d'analyser la qualité et la sécurité du code de manière continue.

---

## 📁 Structure du projet

```
Collab_Authentification/
├── .github/workflows/       # Pipelines CI/CD GitHub Actions
├── src/                     # Code source Java
├── bin/                     # Fichiers compilés
├── users.db                 # Base de données SQLite
├── sonar-project.properties # Configuration SonarQube
└── .classpath / .project    # Configuration Eclipse
```

---

## 👤 Auteur

- [@AmbiNtsoah](https://github.com/AmbiNtsoah)
- [@MiSantatra](https://github.com/MiSantatra)
