# Use OpenJDK 21 base image
FROM eclipse-temurin:21-jdk-jammy

# Set the working directory
WORKDIR /app

# Copy Maven/Gradle build jar into the container
COPY target/*.jar app.jar

# Expose the port Spring Boot will run on
EXPOSE 8080

# Command to run the jar
ENTRYPOINT ["java","-jar","app.jar"]
