FROM openjdk:8-jdk-alpine
RUN mkdir -p /build/
COPY build ./build
RUN ls /build
COPY build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]