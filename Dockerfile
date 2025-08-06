FROM openjdk:17-jdk-slim
WORKDIR /app
COPY eDreamz_project_jar.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
