### Apache Kafka
- Kafka is a transportation mechanism.
- Kafka as a distributed, fault-tolerant, publish/subscribe system. 
- It records messages organized into topics. Applications can produce or consume messages from topics. All messages are stored as logs to persistent filesystems.
- Kafka is a write-ahead logging (WAL) system that writes all published messages to log files before making it available for consumer applications
- Subscribers/consumers can read these written messages as required in an appropriate time-frame

----------------Producers----------------------------------------->Kafka-------------------------------->Consumers

----------------Inserting recordsinto these tables---------------->Database Tables---------------------->Reading data

#### Zookeeper 
- It is an important component of a Kafka cluster. It manages and coordinates Kafka brokers and consumers.
- Zookeeper keeps track of any new broker additions or any existing broker failures in the Kafka cluster.
- Accordingly, it will notify the producer or consumers of Kafka queues about the cluster state
- This helps both producers and consumers in coordinating work with active brokers.
- Zookeeper also records which broker is the leader for which topic partition and passes on this information to the producer or consumer to read and write the messages
- The consumer offset value is maintained by Zookeeper

#### Terminology
**Topic**
- A particular stream of data(Similar to a table in databases )
- Topics are split into **Partitions**
	-	Each partition is ordered
	-	Each message within parition gets incremental id, called **offset** 

**Broker** 
- Broker = Server.
- 
- Contains certain Topic Partitions
- Kafka brokers are stateless. However, they use Zookeeper to maintain their states


#### AVRO
AVRO Converter used for Schema registry. It is industry format serialization system. schema in Json format. Language Independent

#### Commands

