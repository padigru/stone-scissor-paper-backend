FROM maven:3.8.5-openjdk-17 as maven
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

FROM openjdk:17.0.2-oracle
ENV TZ="Europe/Berlin"
ARG JAR_FILE=/home/app/target/*.jar
COPY --from=maven ${JAR_FILE} /app/app.jar
ENTRYPOINT ["java","-jar","/app/app.jar"]