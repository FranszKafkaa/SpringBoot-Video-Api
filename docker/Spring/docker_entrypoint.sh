#!/bin/bash
echo "Waiting for mysql and kafka to be up"
sleep 10
java -jar ./target/pomme-0.0.1-SNAPSHOT.jar