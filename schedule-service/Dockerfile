FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/schedule-service-1.0-SNAPSHOT.jar /app/schedule-service-1.0-SNAPSHOT.jar

EXPOSE 8081

CMD ["java", "-jar", "schedule-service-1.0-SNAPSHOT.jar"]
