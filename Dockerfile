# Этап 1: Сборка приложения
FROM eclipse-temurin:21-jdk AS build
WORKDIR /app

# Копируем pom.xml и загружаем зависимости
COPY pom.xml .
COPY src ./src

# Устанавливаем Maven wrapper (если его нет)
RUN apt-get update && apt-get install -y maven

# Собираем приложение
RUN mvn clean package -DskipTests

# Этап 2: Запуск приложения
FROM eclipse-temurin:21-jre
WORKDIR /app

# Копируем собранный JAR из первого этапа
COPY --from=build /app/target/*.jar app.jar

# Открываем порт
EXPOSE 8080

# Запускаем приложение
ENTRYPOINT ["java", "-jar", "app.jar"]
