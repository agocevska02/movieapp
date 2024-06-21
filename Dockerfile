# Build stage
FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /app
COPY ./pom.xml /app
COPY ./src /app/src
RUN mvn clean package -Dmaven.test.skip=true

# Run stage
FROM openjdk:17-jdk-alpine
WORKDIR /app

# Install MySQL client
RUN apk update && apk add mysql-client

COPY --from=build /app/target/*.jar app.jar
COPY wait-for-mysql.sh /wait-for-mysql.sh
RUN chmod +x /wait-for-mysql.sh
EXPOSE 9091
ENTRYPOINT ["/wait-for-mysql.sh", "mysql-db", "java", "-jar", "app.jar"]
