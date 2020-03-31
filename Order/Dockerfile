FROM openjdk:8-alpine
COPY target/Order-*.jar /order_service.jar
EXPOSE 7000
CMD ["java" , "-jar", "/order_service.jar"]