# Use the official Java 17 runtime base image to create a runtime image
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY build/libs/*.jar app.jar
CMD ["java", "-jar", "app.jar"]