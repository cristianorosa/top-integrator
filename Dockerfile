FROM openjdk:17-jdk-alpine

COPY target/*.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]

# docker build -t cristianorosa/top-integrator:1.0.0 .
# docker push cristianorosa/top-integrator:1.0.0
# docker run -p 8080:8080 -d --name top-integrator cristianorosa/top-integrator:1.0.0