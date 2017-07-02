#!/bin/sh

scriptDir="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
ipAddress="$( ipconfig getifaddr en0 )"

sourceDockerConfig=${scriptDir}/../docker-compose.yml
targetDockerConfig=${scriptDir}/docker-compose.yml

sed "s/KAFKA_ADVERTISED_HOST_NAME:.*/KAFKA_ADVERTISED_HOST_NAME: ${ipAddress}/" ${sourceDockerConfig} > ${targetDockerConfig}

cat ${targetDockerConfig}
sleep 3

( cd ${scriptDir}  &&  docker-compose up )
rm ${targetDockerConfig}

