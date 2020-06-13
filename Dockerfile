FROM arm64v8/openjdk:8u171-jdk-alpine3.8

COPY target/*.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]