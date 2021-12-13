FROM openjdk:8-jdk-alpine
ADD target/tipo-cambio-service.jar tipo-cambio-service.jar
CMD ["java","-jar", "tipo-cambio-service.jar"]