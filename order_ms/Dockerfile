FROM maven:3.9.9 AS build
LABEL authors="ProxiDev"

WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline -B
COPY src ./src

RUN mvn clean package -DskipTests

FROM openjdk:23-slim

WORKDIR /app

COPY --from=build /app/target/order_ms-0.0.1-SNAPSHOT.jar ./order-service.jar

EXPOSE 9502

ENTRYPOINT ["java", "-jar", "order-service.jar"]