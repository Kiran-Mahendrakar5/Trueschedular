# Step 1: Use Maven to build the project
FROM maven:3.9.6-eclipse-temurin-17 AS build

# Set the working directory for the build
WORKDIR /app

# Copy pom.xml and the source code into the container
COPY pom.xml .
COPY src ./src

# Run Maven to build the project and package it into a JAR file
RUN mvn clean package -DskipTests

# Step 2: Create the runtime image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the build image
COPY --from=build /app/target/FeedBack-0.0.1-SNAPSHOT.jar /app/FeedBack.jar

# Expose the port that the application uses
EXPOSE 8088

# Run the application
ENTRYPOINT ["java", "-jar", "/app/FeedBack.jar"]
