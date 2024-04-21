# Используйте базовый образ с Java
FROM gradle:latest AS build



# Установите рабочую директорию в контейнере
WORKDIR /app

# Скопируйте gradle файлы для кэширования слоев
COPY gradlew .
COPY gradle gradle
COPY build.gradle.kts .
COPY settings.gradle.kts .

# Скопируйте все файлы проекта
COPY . .

# Соберите приложение
RUN gradle build --no-daemon

# Запуск приложения
FROM  openjdk:17
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
