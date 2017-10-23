# How to run via Docker

1. Make sure you are in the `docker` group.  
Execute `sudo usermod -a -G docker $USER` and reboot.
2. From the root project directory execute  
`./gradlew build && docker-compose build --no-cache && docker-compose up -d cassandra-test && docker-compose up ignite-cassandra-client 
`  
That should build the project and create a corresponding 
image from that. Then a Cassandra instance should be started and
after that a client instance should be brought up.  
The client will try to connect to Cassandra and eventually
you should see that client has successfully put and gotten value from Cassandra
`org.testprojects.ignite.ignte_cassandra_client.EntityWithMapField{attrs={1=one, 2=two}}`

# How to run from host with a custom Cassandra installation

1. Add your Cassandra contact point if required in [CassandraConfig#getDataSource](src/main/java/org/testprojects/ignite/ignte_cassandra_client/CassandraConfig.java)
2. Run [IgniteServerRunner](src/main/java/org/testprojects/ignite/ignte_cassandra_client/IgniteServerRunner.java)
 

 

