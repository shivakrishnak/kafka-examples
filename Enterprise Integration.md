### Enterprise Integration
- Enterprise Integration is to establish unification between separate applications to achieve a consolidated set of functionalities
- Discrete applications are built using different programming languages and platforms. To achieve any unified functionality, these applications need to share information among
themselves. This information exchange happens over a network in small packets using different protocols and utilities

**one of the common ways of establishing enterprise integration -> messaging systems**

### Messaging Systems
Messaging systems can be used as an integration channel for information exchange between different applications

### Important principles in application integration system design
loose coupling, common interface definitions, latency, and reliability
- **Loose coupling** between applications ensures minimal dependencies on each other. This ensures that any changes in one application do not affect other applications. Tightly coupled applications are coded as per predefined specifications of other applications. Any change in specification would break or change the functionality of other dependent applications
- **Common interface definitions** ensure a common agreed-upon data format for exchange between applications
- **Latency** is the time taken by messages to traverse between the sender and receiver. Most applications want to achieve low latency as a critical requirement. Even in an asynchronous mode of communication, high latency is not desirable as significant delay in receiving messages could cause significant loss to any organization
- **Reliability** ensures that temporary unavailability of applications does not affect dependent applications that need to exchange information. Reliable, asynchronous message communication ensures that the source
application continues its work and feels confident that the remote application will resume its task later

### Basic concepts of any messaging system
 - **Message queues:** You will sometimes find queues referred as channels as well. In a simple way, they are connectors between sending and receiving applications. Their core function is to receive message packets from the source application and send it to the receiver application in a timely and reliable manner
 - **Messages (data packets)** A message is an atomic data packet that gets transmitted over a network to a message queue
 - **Sender (producer)**: Sender or producer applications are the sources of data that needs to be sent to a certain destination. They establish connections to message queue endpoints and send data in smaller message packets adhering to common interface standards
 - **Receiver (consumer)**: Receiver or consumer applications are the receivers of messages sent by the sender application. They either pull data from message queues or they receive data from messages queues through a persistent connection. On receiving messages, they extract data from those message packets and use it for further processing.
 - **Data transmission protocols**: Data transmission protocols determine rules to govern message exchanges between applications. Different queuing systems use different data transmission protocols. It depends on the technical implementation of the messaging endpoints. Kafka uses binary protocols over TCP. The clientinitiates a socket connection with Kafka queues and then writes messages along with reading back the acknowledgment message. Some examples of such data transmission protocols are AMQP (Advance Message Queuing Protocol), STOMP (Streaming Text Oriented Message Protocol), MQTT (Message Queue Telemetry Protocol), and HTTP (Hypertext Transfer Protocol).
- **Transfer mode**: The transfer mode in a messaging system can be understood as the manner in which data is transferred from the source application to the receiver application. Examples of transfer modes are synchronous,     	asynchronous, and batch modes

#### Publish-subscribe messaging system
- In this model, subscriber registers its interest in a particular topic or event and is subsequently notified about the event asynchronously
- A Pub/Sub messaging model is used when you need to broadcast an event or message to many message consumers
- important aspects of Pub/Sub messaging models is that the topic abstraction is easy to understand and enforces platform interoperability
- Messages are shared through a channel called a topic. A topic is a centralized place where producers can publish, and subscribers can consume, messages
- Each message is delivered to one or more message consumers, called subscribers
- Messages are pushed to consumers, which means that messages are delivered to consumers without their having to request them.
- There is no coupling of the producers to the consumers. Subscribers and publishers can be added dynamically at runtime, which allows the system to grow or shrink in complexity over time

