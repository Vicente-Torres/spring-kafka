FROM openjdk:17.0.2-oracle
ARG JAR_FILE=target/spring-consumer-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]