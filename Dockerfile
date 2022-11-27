FROM maven:3.8.6-openjdk-18-slim AS builder
COPY . .
#COPY pom.xml pet-clinic-v2/
#COPY petclinicv2-web/pom.xml pet-clinic-v2/petclinicv2-web/
#COPY petclinicv2-data/pom.xml pet-clinic-v2/petclinicv2-data/
RUN mvn -f ./pom.xml clean package -DskipTests
#RUN mvn -f pet-clinic-v2/pom.xml clean package -DskipTests

##FROM openjdk:17.0.1-jdk-slim
##COPY --from=builder /target/pet-clinic-v2-0.0.1-SNAPSHOT.jar pet-clinic-v2.jar
##EXPOSE 8080
##ENTRYPOINT ["java", "-jar", "pet-clinic-v2.jar"]
