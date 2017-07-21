spring-producer
===============

## Build

```bash
./gradlew bootRepackage
```

## Run

```bash
./build/libs/spring-producer.jar \
    --kafka.servers=localhost:9092 \
    --kafka.topic=topic1 \
    --kafka.message=TEST \
    --kafka.count=1
```
