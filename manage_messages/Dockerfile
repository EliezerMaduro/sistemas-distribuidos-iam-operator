FROM amazoncorretto:21-alpine3.19

WORKDIR /app

COPY target/manage_messages-0.0.1-SNAPSHOT.jar .

EXPOSE 8081

CMD ["java", "-jar", "login-0.0.2-SNAPSHOT.jar"]