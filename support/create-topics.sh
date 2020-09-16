#!/usr/bin/env bash
kafka-topics --bootstrap-server localhost:9092 --create --partitions 4 --replication-factor 1 --topic webui
kafka-topics --bootstrap-server localhost:9092 --create --partitions 4 --replication-factor 1 --topic orders
kafka-topics --bootstrap-server localhost:9092 --create --partitions 4 --replication-factor 1 --topic barista-in
kafka-topics --bootstrap-server localhost:9092 --create --partitions 4 --replication-factor 1 --topic kitchen-in
kafka-topics --bootstrap-server localhost:9092 --create --partitions 4 --replication-factor 1 --topic inventory
kafka-topics --bootstrap-server localhost:9092 --create --partitions 4 --replication-factor 1 --topic web-in
kafka-topics --bootstrap-server localhost:9092 --create --partitions 4 --replication-factor 1 --topic web-updates
kafka-topics --bootstrap-server localhost:9092 --list

