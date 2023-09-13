# Use the official Java 17 runtime base image to create a runtime image
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY build/libs/*.jar app.jar
COPY src/main/resources/application.properties application.properties
CMD ["java", "-jar", "app.jar"]