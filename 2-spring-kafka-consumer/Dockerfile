FROM openjdk:8
VOLUME /tmp
ADD target/spring-kafka-consumer.jar spring-kafka-consumer.jar
EXPOSE 8881
ENTRYPOINT ["java","-jar","spring-kafka-consumer.jar"]