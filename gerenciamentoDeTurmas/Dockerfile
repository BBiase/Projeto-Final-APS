# Use a imagem base do Maven para construir a aplicação
FROM maven:3.8.4-openjdk-17 AS build

# Define o diretório de trabalho dentro do container
WORKDIR /app

# Copia o arquivo pom.xml e outros arquivos necessários
COPY pom.xml .

# Baixa todas as dependências para o diretório do cache
RUN mvn dependency:go-offline -B

# Copia todo o conteúdo do projeto para o diretório de trabalho
COPY . .

# Compila a aplicação
RUN mvn clean package -DskipTests

# Use uma imagem base do OpenJDK para o runtime
FROM openjdk:17-jdk-slim

# Define o diretório de trabalho dentro do container
WORKDIR /app

# Copia o arquivo JAR da fase de build para o diretório de trabalho
COPY --from=build /app/target/gerenciamentoDeTurmas-0.0.1-SNAPSHOT.jar app.jar

# Exponha a porta 8080
EXPOSE 8080

# Define o comando padrão para executar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
