FROM openjdk:8-jdk-alpine
ADD target/spring-boot-docker-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=container", "app.jar"]