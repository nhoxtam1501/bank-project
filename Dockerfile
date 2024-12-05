# Stage 1: Build
FROM maven:3.9.5-amazoncorretto-21 AS build

WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Stage 2: Runtime
FROM amazoncorretto:21

EXPOSE 8080
WORKDIR /app

COPY --from=build /app/target/bank-project.jar bank-project.jar
ENTRYPOINT ["java", "-jar", "/bank-project.jar"]
