# Stage 1: Build JAR
FROM gradle:8.8.0-jdk21 AS build
WORKDIR /app
COPY . .
RUN gradle clean build -x test

# Stage 2: Run JAR
FROM eclipse-temurin:21-jdk-jammy
WORKDIR /app
COPY --from=build /app/build/libs/CoffeeShopTelegram-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
