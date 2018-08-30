FROM openjdk:8
ADD build/libs/hello-docker.jar hello-docker.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "hello-docker.jar"]