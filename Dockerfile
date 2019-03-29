FROM openjdk:11.0.2-jre-slim

RUN java -version

COPY target/simple-crud-0.0.1-SNAPSHOT.jar /simple-crud.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "simple-crud.jar", "graceful"]