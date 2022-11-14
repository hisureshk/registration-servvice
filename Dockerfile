
FROM openjdk:11-jdk-alpine
COPY ./target/registration-service--0.0.1-SNAPSHOT.jar /usr/apps/services/
WORKDIR /usr/apps/services
EXPOSE 8080
CMD ["java", "-jar", "registration-service-0.0.1-SNAPSHOT.jar"]