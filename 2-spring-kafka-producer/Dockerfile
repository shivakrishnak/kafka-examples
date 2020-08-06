FROM openjdk:8-alpine
VOLUME /tmp
ADD target/spring-kafka-producer.jar spring-kafka-producer.jar
EXPOSE 8881
ENTRYPOINT ["java","-jar","spring-kafka-producer.jar"]