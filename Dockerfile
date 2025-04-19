# Use Maven to build the project
FROM maven:3.8.6-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean install -DskipTests

# Use JDK to run the built app
FROM openjdk:17
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 1301
ENTRYPOINT ["java", "-jar", "app.jar"]
