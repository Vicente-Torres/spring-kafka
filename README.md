# spring-kafka
## Project
### Overview

This project initially was created with the aim of sharing knowledge with a development team. Basically was created a 
docker-compose for creating and up the kafka brokers and the kafka consumers. The kafka-consumers are made using Spring.
To producer messages was used the Jmeter, but you can produce using another tool as the Magic Kafka.

### How to run?
To run and see the project working you need to fallow some steps:
* [Build and create the consumer image used by docker service;](#consumerImage)
* [Up the docker services;](#upCompose)
* [Watching the logs of docker consumers containers;](#logs)
* [Producing messages;](#producing)
#### <a name="consumerImage"></a>Creating consumer image for docker
You will need create the docker image use by kafka consumers services. The image is generated based on a simple Spring
application. To generate the image, follow these the steps:
* Into 'spring-consumer' directory run './mvnw clean package install';
* Then, in the same directory, execute 'docker build -t springio/spring-consumer . '.
#### <a name="upCompose"></a>Up docker-compose
Change to 'compose' directory and run 'docker-compose up -d'. All services in the docker-compose file will be start. If 
for any reason the kafka brokers is down after this, you can just run 'docker start <service-name>'. </br>
In the tests you can stop and restart the spring-consumer's or kafka's container to see the rebalancing going on.
#### <a name="logs"></a>Watching the logs
##### <a name="producing"></a>Producing messages
To see all the magic happening you need send messages to the kafka topic. For do that the [Jmeter](#jmeter) could be the best option.
But you can do using another toll as Magic Kafka. However, the last one is not free but has a demo license with
time expiration.
#### <a name="jmeter"></a>Jmeter
#### <a name="magicKafka"></a>Magic Kafka
