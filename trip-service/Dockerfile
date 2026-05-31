FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY target/trip-service.jar app.jar

EXPOSE 8085

ENTRYPOINT ["java","-jar","app.jar"]