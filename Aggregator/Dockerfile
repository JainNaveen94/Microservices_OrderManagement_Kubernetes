FROM openjdk:8-alpine
COPY target/Aggregator-*.jar /Aggregator_service.jar
EXPOSE 8000
CMD ["java" , "-jar", "/Aggregator_service.jar"]