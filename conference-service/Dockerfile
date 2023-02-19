FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/conference-service-1.0-SNAPSHOT.jar /app/conference-service-1.0-SNAPSHOT.jar

EXPOSE 8080

CMD ["java", "-jar", "conference-service-1.0-SNAPSHOT.jar"]

