# Store Front

Une application microservices de commerce électronique construite avec Spring Boot et Spring Cloud.

## Vue d'ensemble
Store Front est une application microservices qui gère un système de commerce électronique. L'application est composée de plusieurs services indépendants qui communiquent entre eux via une API Gateway.

## Architecture
Le projet est composé de 5 services principaux :
1. **Registry Service** (Port 8761) : Service de découverte Eureka
2. **Gateway Service** (Port 9000) : API Gateway
3. **Product Service** (Port 9500) : Gestion des produits
4. **Inventory Service** (Port 9501) : Gestion des stocks
5. **Order Service** (Port 9502) : Gestion des commandes

## Prérequis
- Java 21
- Maven
- Docker et Docker Compose
- PostgreSQL (si exécution locale)

## Configuration de la Base de Données
Chaque service utilise sa propre base de données PostgreSQL :

| Service | Base de données | Port |
|---------|----------------|------|
| Product | product_ms | 5435 |
| Inventory | inventory_ms | 5433 |
| Order | order_ms | 5434 |

Identifiants par défaut :
- Username : `proxi`
- Password : `123`

## Installation et Démarrage

### Option 1 : Démarrage avec Docker Compose

1. Cloner le repository :
```bash
git clone <repository-url>
cd store_front
```

2. Démarrer tous les services avec Docker Compose :
```bash
docker-compose up -d
```

### Option 2 : Démarrage Manuel

1. Démarrer les bases de données PostgreSQL :
```bash
# Pour chaque service, exécuter :
docker-compose -f <service-name>/compose.yaml up -d
```

2. Démarrer les services dans l'ordre suivant :
```bash
# 1. Registry Service
cd registry-service
mvn spring-boot:run

# 2. Gateway Service
cd gateway-service
mvn spring-boot:run

# 3. Product Service
cd product-service
mvn spring-boot:run

# 4. Inventory Service
cd invenroty-service
mvn spring-boot:run

# 5. Order Service
cd order_ms
mvn spring-boot:run
```

## Accès aux Services

### API Gateway
- URL : `http://localhost:9000`
- Documentation Swagger : `http://localhost:9000/swagger-ui.html`

### Services Individuels
Chaque service expose sa propre documentation Swagger :

| Service | URL Swagger |
|---------|-------------|
| Product | http://localhost:9500/api/v1/swagger-ui.html |
| Inventory | http://localhost:9501/api/v1/swagger-ui.html |
| Order | http://localhost:9502/api/v1/swagger-ui.html |

### Routes API Gateway
- Products : `http://localhost:9000/api/v1/products/**`
- Inventories : `http://localhost:9000/api/v1/inventories/**`
- Orders : `http://localhost:9000/api/v1/orders/**`

## Configuration des Services

### Variables d'Environnement
Chaque service peut être configuré via des variables d'environnement :

| Variable | Description | Valeur par défaut |
|----------|-------------|-------------------|
| DB_URL | URL de la base de données | jdbc:postgresql://localhost:5432/<service_db> |
| DB_USERNAME | Nom d'utilisateur DB | proxi |
| DB_PASSWORD | Mot de passe DB | 123 |
| REGISTRY_SERVICE | URL du service registry | http://localhost:8761/eureka |

### Configuration CORS
Tous les services sont configurés pour accepter les requêtes CORS depuis :
- `http://localhost:9000` (Gateway)

## Structure des Services

### Product Service
- Gestion des produits et catégories
- API REST pour CRUD des produits
- Communication avec Inventory Service via OpenFeign

### Inventory Service
- Gestion des stocks
- API REST pour la gestion des inventaires
- Synchronisation avec Product Service

### Order Service
- Gestion des commandes
- API REST pour CRUD des commandes
- Communication avec Inventory Service via OpenFeign

### Gateway Service
- Routage des requêtes
- Documentation Swagger unifiée
- Configuration CORS
- Gestion des erreurs

### Registry Service
- Service de découverte Eureka
- Gestion de la disponibilité des services

## Développement

### Technologies Utilisées
- Spring Boot 3.3.4/3.3.5
- Spring Cloud 2023.0.3
- Spring Data JPA
- PostgreSQL
- OpenFeign
- SpringDoc OpenAPI
- Lombok
- Maven

### Bonnes Pratiques
1. Toujours démarrer le Registry Service en premier
2. Vérifier la disponibilité des services via Eureka Dashboard (`http://localhost:8761`)
3. Utiliser l'API Gateway pour toutes les requêtes
4. Consulter la documentation Swagger pour les détails des API

## Dépannage

### Problèmes Courants
1. **Erreur de connexion à la base de données**
   - Vérifier que PostgreSQL est en cours d'exécution
   - Vérifier les identifiants dans application.yaml

2. **Service non disponible dans Eureka**
   - Vérifier que le Registry Service est en cours d'exécution
   - Vérifier les logs du service concerné

3. **Erreurs CORS**
   - Vérifier que les requêtes passent par la gateway
   - Vérifier la configuration CORS dans chaque service

### Logs
Les logs de chaque service sont disponibles dans :
- Console de démarrage
- Fichiers de logs Docker (si exécution avec Docker)

## Sécurité
- Les services sont configurés pour fonctionner en local
- En production, il est recommandé de :
  - Changer les mots de passe par défaut
  - Configurer HTTPS
  - Mettre en place une authentification
  - Restreindre les accès CORS

## Contribution
1. Fork le projet
2. Créer une branche pour votre fonctionnalité (`git checkout -b feature/AmazingFeature`)
3. Commit vos changements (`git commit -m 'Add some AmazingFeature'`)
4. Push vers la branche (`git push origin feature/AmazingFeature`)
5. Ouvrir une Pull Request

## Licence
Ce projet est sous licence MIT. Voir le fichier `LICENSE` pour plus de détails.

## Contact
Pour toute question ou suggestion, n'hésitez pas à ouvrir une issue dans le repository. 