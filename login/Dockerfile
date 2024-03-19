FROM amazoncorretto:21-alpine3.19

WORKDIR /app

COPY target/login-0.0.2-SNAPSHOT.jar .

EXPOSE 8080

CMD ["java", "-jar", "login-0.0.2-SNAPSHOT.jar"]