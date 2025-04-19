# Use a valid Maven image with JDK 17
FROM maven:3.9.6-eclipse-temurin-17 AS build

WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Use a lightweight JDK base image to run the app
FROM openjdk:17-slim
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

EXPOSE 1301
CMD ["java", "-jar", "app.jar"]
