FROM openjdk:8-jdk-alpine
ADD target/hello-app-java-0.0.1-SNAPSHOT.jar target/hello-app-java.jar
ENV JAVA_OPTS=""
EXPOSE 8080
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-jar","target/hello-app-java.jar"]