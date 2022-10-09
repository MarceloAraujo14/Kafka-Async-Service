### Kafka-Async-Service
Using Kafka and Spring Boot to communicate two applications throught kafka topic.

Feats: 

v1 : Send and receive String formatted messages.

v2 : Send and receive Objects messages. Implementing Avro Schema Registry

#### Producer:
- Create a application with the follow dependencies using spring initializer: 
  - spring-boot-starter-web
  - spring-boot-starter
  - spring-kafka 
  - avro
  - avro-serializer
