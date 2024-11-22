# Build aşaması için Maven kullanımı
FROM maven:3.8.5-openjdk-17-slim AS build
WORKDIR /app

# Proje dosyalarını kopyala
COPY pom.xml .
COPY src ./src
COPY mvnw .
COPY .mvn .mvn

# Maven ile projeyi build et
RUN ./mvnw clean package

# Çalıştırma aşaması için yalnızca gerekli dosyaları kopyala
FROM openjdk:17-jdk-slim
WORKDIR /app

# Jar dosyasını kopyala
COPY --from=build /app/target/*.jar app.jar

# Uygulamayı başlat
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]

