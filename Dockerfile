FROM openjdk:15-jdk-alpine3.11
COPY build/libs/*.jar app.jar
CMD ["java", "-jar", "-Dspring.profiles.active=prod", "app.jar"]


