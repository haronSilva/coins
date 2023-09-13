FROM openjdk:11
COPY target/financial-0.0.1-SNAPSHOT.jar financial-1.0.0.jar
ENTRYPOINT ["java","-jar","/financial-1.0.0.jar"]