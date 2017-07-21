#!/bin/sh

scriptDir="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
ipAddress="$( ipconfig getifaddr en0 )"

sourceDockerConfig=${scriptDir}/../docker-compose.yml
targetDockerConfig=${scriptDir}/docker-compose.yml

if [ "${1}" == "clean" ]
then
	for name in $(grep container_name ${sourceDockerConfig} | cut -d':' -f2) 
	do
		docker-compose rm -f ${name}
	done
fi

sed "s/KAFKA_ADVERTISED_HOST_NAME:.*/KAFKA_ADVERTISED_HOST_NAME: ${ipAddress}/" ${sourceDockerConfig} > ${targetDockerConfig}

cat ${targetDockerConfig}
sleep 2 && read -p "Press enter to continue..."

( cd ${scriptDir}  &&  docker-compose build --no-cache  &&  docker-compose up --force-recreate )
rm ${targetDockerConfig}

