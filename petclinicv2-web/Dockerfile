FROM maven:3.8.6-openjdk-18-slim AS builder
COPY pom.xml petclinicv2-web/
COPY src petclinicv2-web/src/
RUN mvn -f petclinicv2-web/pom.xml clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim
COPY --from=builder /target/petclinicv2-web-0.0.1-SNAPSHOT.jar petclinicv2-web.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "petclinicv2-web.jar"]
