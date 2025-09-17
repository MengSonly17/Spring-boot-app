# Use OpenJDK 21
FROM eclipse-temurin:21-jdk-jammy

# Set working directory
WORKDIR /app

# Copy the JAR file into the container
COPY build/libs/CoffeeShopTelegram-0.0.1-SNAPSHOT.jar app.jar

# Expose port (Render uses $PORT)
EXPOSE 8080

# Set the entrypoint to run the JAR
ENTRYPOINT ["java", "-jar", "app.jar"]

