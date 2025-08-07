# Use Java 17 base image
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy jar file (update name accordingly)
COPY target/TravelManagementSystem-0.0.1-SNAPSHOT.jar app.jar

# Expose port (important for Render)
EXPOSE 8080

# Run the jar
ENTRYPOINT ["java", "-jar", "app.jar"]
