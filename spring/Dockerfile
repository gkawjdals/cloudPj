
FROM gradle:7.6.1-jdk17 AS build
WORKDIR /app
COPY . .
RUN gradle build -x test

FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
