Angular Frontend

Spring Backend

Cassandra DB in Docker container

------

docker run --name dev-cassandra -d -p 9042:9042 cassandra:latest

docker exec -it dev-cassandra bash



CREATE KEYSPACE cars WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 1 } AND DURABLE_WRITES = false;
   
CREATE TABLE car(
   id uuid PRIMARY KEY,
   make text,
   model text
);
   
insert into cars (id, make, model) values (1, 'Tesla', 'Model S');

insert into cars (id, make, model) values (2, 'Ferrari', 'Enzo');

insert into car (id, make, model) values (ab314499-ec4c-4fd2-9a0b-b985899cb4d4, 'Ferrari', 'Enzo');

--- 
spring.data.cassandra.keyspace-name=cars

spring.data.cassandra.contact-points=127.0.0.1

spring.data.cassandra.port=9042

spring.data.cassandra.local-datacenter=datacenter1
