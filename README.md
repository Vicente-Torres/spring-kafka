# spring-kafka
## Project
### Overview

This project initially was created with the aim of sharing knowledge with a development team. Basically was created a 
docker-compose for creating and up the kafka brokers and the kafka consumers. The kafka-consumers are made using Spring.
To producer messages was used the Jmeter, but you can produce using another tool as the Magic Kafka.

### How to run?
To run and see the project working you need to fallow some steps:
* [Build and create the consumer image used by docker service;](#consumerimage)
* [Up the docker services;](#upcompose)
* [Producing messages;](#producing)
* [Some test ideas;](#tests)

### <a name="consumerimage"></a>Creating consumer image for docker
You will need create the docker image use by kafka consumers services. The image is generated based on a simple Spring
application. To generate the image, follow these the steps:
* Into 'spring-consumer' directory run './mvnw clean package install';
* Then, in the same directory, execute 'docker build -t springio/spring-consumer . '.

### <a name="upcompose"></a>Up docker-compose
Change to 'compose' directory and run 'docker-compose up -d'. All services in the docker-compose file will be start. If 
for any reason the kafka brokers is down after this, you can just run 'docker start <service-name>'. </br>
In the tests you can stop and restart the spring-consumer's or kafka's container to see the rebalancing going on.

### <a name="producing"></a>Producing messages
To see all the magic happening you need send messages to the kafka topic. For do that the [Jmeter](#jmeter) could be the best option.
But you can do using another toll as Magic Kafka. However, the last one is not free but has a demo license with
time expiration.

#### <a name="jmeter"></a>Jmeter
The Apache Jmeter should be installed. After this, also install the [pepper-box lib](https://github.com/GSLabDev/pepper-box). 
Then go to File>Open and select the "kafka-producer-jmeter-profile.jmx" file, available in this repository. Has used the 
version 5.5 of Jmeter.</br>In the Message section hve the message to be sent to kafka topic. This message use a custom 
function from pepper-box lib. The function has created only with the goal to get the current time. You can use on this 
way or change the custom function to a fixed value. </br> To use the custom function you should create it in the 
[CustomFunctions class](https://github.com/GSLabDev/pepper-box/blob/master/src/main/java/com/gslab/pepper/input/CustomFunctions.java)

### <a name="tests"></a>Some test ideas
 * You can see the spring-consumer containers logs and observes how they behave when the message throughput is increase;
 * Can observe how another consumers behave when some consumers and/or kafka brokers are stopped;
 * Can use some commands into kafka broker to understand the kafka cluster better. Some usefully commands:
   * docker exec -id <container_name> bash -> access the bash of kafka container;
   * kafka-topics --create --topic=example --bootstrap-server=localhost:9092 --partitions=3 -> create a topic;
   * kafka-topics --list --bootstrap-server=localhost:9092 -> list all topics;
   * kafka-console-producer --topic=example --bootstrap-server=localhost:9092 -> get in on console to producer messages;
   * kafka-console-consumer --topic=example --bootstrap-server=localhost:9092 -> get in on console to consumer messages;
   * kafka-topics --describe --bootstrap-server=localhost:9092 --topic=example -> show the details of the topic;
   * kafka-consumer-groups --group test --describe --bootstrap-serve localhost:19092 -> describe the consumers of the group;

