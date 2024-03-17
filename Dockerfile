FROM eclipse-temurin:17-jdk-alpine AS build

WORKDIR /app
COPY mvnw .
COPY pom.xml .
COPY .mvn .mvn
RUN ./mvnw dependency:go-offline -B
COPY src src
RUN ./mvnw clean install
#    -DskipTests

FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar /app/*.jar
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/*.jar"]
