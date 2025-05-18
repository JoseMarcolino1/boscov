# Usa uma imagem com JDK 17 (ou a que você estiver usando)
FROM eclipse-temurin:17-jdk-alpine

# Define diretório de trabalho no container
WORKDIR /app

# Copia o jar gerado (supondo que você usou `mvn clean package`)
COPY target/avaliadorFilmes-0.0.1-SNAPSHOT.jar app.jar

# Expõe a porta que sua aplicação usa (geralmente 8080)
EXPOSE 8080

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
