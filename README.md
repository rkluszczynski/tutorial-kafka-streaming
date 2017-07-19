# tutorial-kafka-streaming


## Setup

Obtain current IP address and set environment variable `KAFKA_ADVERTISED_HOST_NAME` with it in `docker-compose.yml` file.
Next, just type:

```bash
docker-compose up
```

and Kafka should start.


## Testing

Create topic: 

```bash
./bin/kafka-topics.sh --create --partitions 1 --replication-factor 1 --topic topic1 --zookeeper localhost:2181
```

Produce some data:

```bash
./bin/kafka-console-producer.sh --topic=topic1 --broker-list=localhost:9092
```

Consume data:

```bash
./bin/kafka-console-consumer.sh --from-beginning --topic=topic1 --bootstrap-server=localhost:9092
```

Describe topic metadata:

```bash
./bin/kafka-topics.sh --describe --topic=topic1 --zookeeper=localhost:2181
```


## Links 

- http://blog.coffeeandcode.com/cleanup-docker-images-and-exited-containers/


## Credits

- https://hub.docker.com/r/wurstmeister/kafka/

