FROM openjdk:21-jdk-alpine
COPY . /app
WORKDIR /app
RUN ./mvnw clean install
CMD ["java", "-jar", "target/product-service.jar"]
