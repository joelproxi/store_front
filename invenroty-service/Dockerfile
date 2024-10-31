FROM maven:3.9.9 AS build
LABEL authors="ProxiDev"

WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline -B
COPY src ./src

RUN mvn clean package -DskipTests

FROM openjdk:23-slim

WORKDIR /app

COPY --from=build /app/target/invenroty-service-0.0.1-SNAPSHOT.jar ./invenroty-service.jar

EXPOSE 9501

ENTRYPOINT ["java", "-jar", "invenroty-service.jar"]