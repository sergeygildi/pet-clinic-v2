FROM maven:3.8.6-openjdk-18-slim AS builder
COPY . .
RUN --mount=type=cache,target=/root/.m2 mvn -f ./pom.xml clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim
COPY ./target/pet-clinic-v2-0.0.1-SNAPSHOT.jar .
CMD java -Xmx400m -Xms400m -jar pet-clinic-v2-0.0.1-SNAPSHOT.jar
EXPOSE 8080
