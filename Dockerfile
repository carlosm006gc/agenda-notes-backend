FROM ubuntu:latest AS build

RUN apt-get update
RUN apt-get install openjdk-18-jdk -y
COPY . .

RUN apt-get install maven -y
RUN mvn clean install

FROM openjdk:18-jdk-slim

EXPOSE 8080

COPY --from=build /target/agenda-0.0.1-SNAPSHOT.jar agenda.jar

ENTRYPOINT [ "java", "-jar", "agenda.jar" ]