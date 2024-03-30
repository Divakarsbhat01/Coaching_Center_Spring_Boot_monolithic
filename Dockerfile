FROM openjdk:8
EXPOSE 8080
WORKDIR /usr/src/app
COPY target/coacen_mono-0.0.1-SNAPSHOT.jar .
ENTRYPOINT ["java","-jar","/coacen_mono-0.0.1-SNAPSHOT.jar"]