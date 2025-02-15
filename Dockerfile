# Use official OpenJDK 17 base image
FROM openjdk:17-jdk-slim

# Set working directory inside container
WORKDIR /app

# Copy Maven wrapper and project files
COPY .mvn/ .mvn
COPY mvnw pom.xml ./

# Grant execute permission for Maven wrapper
RUN chmod +x mvnw

# Download dependencies (faster builds)
RUN ./mvnw dependency:go-offline

# Copy source code
COPY src ./src

# Build the application
RUN ./mvnw clean package -DskipTests

# Expose port 8080
EXPOSE 8080

# Run the JAR file
CMD ["java", "-jar", "target/demo-0.0.1-SNAPSHOT.jar"]
