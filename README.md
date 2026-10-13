# Gestion Catalogue 5GLCD

Application backend Spring Boot pour la gestion d'un catalogue de produits et de catégories.

---

## 📌 Présentation du Projet

Ce projet est une API de gestion de catalogue développée avec **Spring Boot** et **Spring Data JPA**. Il gère la relation entre les catégories et les produits tout en appliquant les bonnes pratiques de découplage via le pattern **DTO (Data Transfer Object)** et le mapping d'entités.

---

## 🚀 Fonctionnalités Principales

- **Gestion des Produits (`Produit`)** :
  - Création, mise à jour, suppression et consultation par ID ou liste complète.
  - Recherche de produits filtrés par nom de catégorie (`recherecherParCategorie`).
- **Gestion des Catégories (`Categorie`)** :
  - Association 1-à-Plusieurs (`1:N`) entre catégories et produits.
- **Architecture en Couches & DTO** :
  - Utilisation de `ProduitDto` et `CategorieDto` avec `ProductMapper` pour séparer les modèles de persistance et de transfert.
  - Gestion centralisée des exceptions métier (ex: `ResourceNotFoundException`).
- **Initialisation automatique des données** :
  - `CommandLineRunner` pré-remplissant la base avec des catégories (`informatique`, `electonique`) et des produits de test (`pc`, `clavier`, `smartphone`).

---

## 🛠️ Technologies & Outils

- **Langage** : Java 17+
- **Framework** : Spring Boot 4.x
  - Spring Data JPA
  - Spring Web MVC
  - Spring Validation
- **Base de Données** :
  - MySQL (`gestion_produit_db`)
  - Support H2 Database (in-memory)
- **Outils & Librairies** :
  - Maven & Maven Wrapper (`mvnw`)
  - Lombok (génération automatique des getters/setters/builders)

---

## ⚙️ Configuration & Prérequis

### Prérequis
- **JDK 17** ou supérieur installé.
- **MySQL** actif sur le port 3306 (ou adapter `application.properties`).

### Configuration de la Base de Données (`src/main/resources/application.properties`)
```properties
spring.application.name=gestioncatalogue5GLCD
spring.datasource.url=jdbc:mysql://localhost:3306/gestion_produit_db?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
```

---

## 🏃 Lancement du Projet

### 1. Cloner ou ouvrir le projet
Ouvrez le dossier du projet dans votre IDE préféré (IntelliJ IDEA, VS Code, Eclipse).

### 2. Compiler le projet avec Maven
Sous Linux / macOS :
```bash
./mvnw clean install
```
Sous Windows :
```cmd
mvnw.cmd clean install
```

### 3. Exécuter l'application
```bash
./mvnw spring-boot:run
```
L'application démarre par défaut sur le port `8080` (ou le port configuré dans `application.properties`).

---

## 📂 Structure du Projet

```text
src/main/java/com/polytechnique/ds/gestioncatalogue5glcd/
├── entities/
│   ├── Produit.java                  # Entité JPA Produit
│   └── Categorie.java                # Entité JPA Categorie
├── dto/
│   ├── ProduitDto.java               # DTO pour Produit
│   ├── CategorieDto.java             # DTO pour Categorie
│   └── ProductMapper.java            # Convertisseur Entity <-> DTO
├── repository/
│   ├── ProduitRepository.java        # Repository JPA Produits
│   └── CategorieRepository.java      # Repository JPA Catégories
├── service/
│   ├── IServiceProduit.java          # Interface du service produit
│   └── ServiceProduit.java           # Implémentation de la logique métier
├── exceptions/
│   └── ResourceNotFoundException.java# Exception personnalisée
└── Gestioncatalogue5GlcdApplication.java # Classe principale & CommandLineRunner
```

