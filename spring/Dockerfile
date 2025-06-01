# 1단계: 빌드용 (멀티스테이지 - 빌드 도구 포함된 이미지)
FROM gradle:7.6.1-jdk17 AS build
WORKDIR /app
COPY . .
RUN gradle build -x test

# 2단계: 실행용 (가벼운 Java 이미지)
FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
