#!/usr/bin/env groovy

docker-compose -f compose.yaml up -d --build --detach
echo "Success"