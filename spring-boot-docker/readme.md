mvn clean package
docker build -f Dockerfile -t hello-docker .
docker container run -p 8081:8080 hello-docker
