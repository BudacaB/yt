CQL="DROP keyspace cars;
CREATE KEYSPACE cars WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 1 } AND DURABLE_WRITES = false;
CREATE TABLE cars.car (id uuid PRIMARY KEY, make text, model text);"

until echo $CQL | cqlsh; do
  echo "cqlsh: Cassandra is unavailable to initialize - will retry later"
  sleep 2
done &

exec /docker-entrypoint.sh "$@"
