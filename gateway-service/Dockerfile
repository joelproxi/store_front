# Utilisation de l'image officielle Maven pour la compilation
FROM maven:3.9.4-eclipse-temurin-21 AS build


WORKDIR /app

# Copier le fichier pom.xml et télécharger les dépendances nécessaires
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copier le code source et construire le projet
COPY src ./src
RUN mvn clean package -DskipTests

# Utilisation de l'image OpenJDK pour exécuter l'application
FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app

# Copier le fichier JAR généré depuis l'étape précédente
COPY --from=build /app/target/gateway-service-0.0.1-SNAPSHOT.jar ./gateway-service.jar

# Exposer le port de l'application
EXPOSE 9000

# Commande pour démarrer l'application
ENTRYPOINT ["java", "-jar", "gateway-service.jar"]
