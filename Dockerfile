FROM maven:3.8-openjdk-8 AS build

WORKDIR /build

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src/ src/
RUN mvn clean package -DskipTests

FROM eclipse-temurin:8-jre
WORKDIR /app

COPY --from=build /build/target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]