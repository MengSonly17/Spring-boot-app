# Use official Java image
FROM openjdk:21-jdk-slim

# Set working directory
WORKDIR /app

# Copy the built jar file into the container
COPY build/libs/*.jar app.jar

# Expose port
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java","-jar","/app/app.jar"]
