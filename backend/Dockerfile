# Etapa 1: build usando Maven com JDK 17
FROM maven:3.9.6-eclipse-temurin-17-alpine AS build

WORKDIR /app

# Copia todo o projeto pro container
COPY . .

# Executa o build com Maven (gera o .jar)
RUN mvn clean package -DskipTests

# Etapa 2: imagem final leve com JDK 17
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Copia o .jar gerado na imagem anterior
COPY --from=build /app/target/avaliadorFilmes-0.0.1-SNAPSHOT.jar app.jar

# Expõe a porta padrão da aplicação
EXPOSE 8080

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
