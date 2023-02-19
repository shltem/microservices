FROM openjdk:17-jdk-slim

WORKDIR /app

EXPOSE 8082

COPY target/feedback-sevice-0.0.1-SNAPSHOT.jar /app/feedback-sevice-0.0.1-SNAPSHOT.jar

CMD ["java", "-jar", "feedback-sevice-0.0.1-SNAPSHOT.jar"]
