FROM ubuntu/jre:21-24.04 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
COPY target/jfinder-*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
