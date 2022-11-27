FROM maven:3.8.6-openjdk-18-slim AS builder
COPY pom.xml petclinicv2-data/
COPY src petclinicv2-data/src/
RUN mvn -f petclinicv2-data/pom.xml clean package -DskipTests
RUN #--mount=type=cache,target=/root/.m2 mvn -f petclinicv2-data/pom.xml clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim
COPY --from=builder /target/petclinicv2-data-0.0.1-SNAPSHOT.jar petclinicv2-data.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "petclinicv2-data.jar"]
