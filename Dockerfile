# Etapa 1: Compilar la aplicación con Maven y JDK
FROM maven:3.9.4-eclipse-temurin-17 AS build

# Directorio de trabajo para el build
WORKDIR /testService-api

# Copiamos los archivos del proyecto al contenedor
COPY pom.xml .
COPY src ./src

# Ejecutamos el build para generar el .jar
RUN mvn clean package -DskipTests

# Etapa 2: Imagen liviana para correr la app (solo JRE)
FROM eclipse-temurin:17-jre-alpine

# Directorio de trabajo en el contenedor final
WORKDIR /testService-api

# Copiamos el jar desde la etapa anterior
COPY --from=build /testService-api/target/*.jar testService-api.jar

# Exponemos el puerto en el que se ejecutará la app
EXPOSE 8080

# Comando que ejecuta la aplicación
ENTRYPOINT ["java", "-jar", "testService-api.jar"]
