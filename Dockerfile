# === Etapa 1: Build del proyecto (Java 21) ===
FROM gradle:8.6-jdk21 AS build
WORKDIR /app

COPY . .
RUN gradle build -x test

# === Etapa 2: Ejecutar el jar ya compilado (Java 21) ===
FROM eclipse-temurin:21-jdk

WORKDIR /app

# Copiar el JAR compilado
COPY --from=build /app/build/libs/*.jar app.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "app.jar"]