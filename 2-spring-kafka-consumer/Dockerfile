FROM openjdk:8-alpine
VOLUME /tmp
ADD target/spring-kafka-consumer.jar spring-kafka-consumer.jar
EXPOSE 8882
ENTRYPOINT ["java","-jar","spring-kafka-consumer.jar"]