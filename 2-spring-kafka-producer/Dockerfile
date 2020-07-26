FROM openjdk:8
VOLUME /tmp
ADD target/spring-kafka-producer.jar spring-kafka-producer.jar
EXPOSE 8882
ENTRYPOINT ["java","-jar","spring-kafka-producer.jar"]