FROM openjdk:15-jdk-alpine3.11
COPY build/libs/*.jar app.jar
RUN apk add --no-cache bash
COPY ./wait-for-it.sh wait-for-it.sh
CMD ["java", "-jar", "-Dspring.profiles.active=prod", "app.jar"]


