# tutorial-kafka-streaming


## Setup

Obtain current IP address and set environement variable `` with it in `docker-compose.yml` file.
Next, just type:

```bash
docker-compose up
```

and Kafka should start.


## Testing

Create topic: 

```bash
./bin/kafka-topics.sh --create --topic topic --partitions 4 --zookeeper 192.168.1.6:2181 --replication-factor 1
```

Produce some data:

```bash
./bin/kafka-console-producer.sh --topic=topic1 --broker-list=192.168.1.6:9092
```

Consume data:

```bash
./bin/kafka-console-consumer.sh --topic=topic1 --zookeeper=192.168.1.6:2181 --from-beginning
```


## Credits

- https://hub.docker.com/r/wurstmeister/kafka/

