FROM openjdk:17-jdk-alpine
VOLUME /tmp
EXPOSE 9005
ARG JAR_FILE=target/notification-service-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]