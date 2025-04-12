FROM openjdk
EXPOSE 8080
WORKDIR /usr/src/app
COPY target/coacen_mono-1.jar .
ENTRYPOINT ["java","-jar","coacen_mono-1.jar","--spring.profiles.active=prod"]