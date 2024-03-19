FROM amazoncorretto:21-alpine3.19

WORKDIR /app

COPY target/upload-0.0.1-SNAPSHOT.jar .

EXPOSE 8090

CMD ["java", "-jar", "upload-0.0.1-SNAPSHOT.jar"]