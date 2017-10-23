package org.testprojects.ignite.ignte_cassandra_client;

import com.datastax.driver.core.policies.LoadBalancingPolicy;
import com.datastax.driver.core.policies.RoundRobinPolicy;
import com.datastax.driver.core.policies.TokenAwarePolicy;
import java.nio.file.Paths;
import org.apache.ignite.cache.store.cassandra.CassandraCacheStoreFactory;
import org.apache.ignite.cache.store.cassandra.datasource.DataSource;
import org.apache.ignite.cache.store.cassandra.datasource.PlainCredentials;
import org.apache.ignite.cache.store.cassandra.persistence.KeyValuePersistenceSettings;
import org.springframework.core.io.ClassPathResource;

/**
 * Created by Alexander Fedotov.
 */
public class CassandraConfig {

    private CassandraConfig() {
        // No-op.
    }

    public static KeyValuePersistenceSettings getPersistenceSettings() throws Exception {
        KeyValuePersistenceSettings persistenceSettings =
            new KeyValuePersistenceSettings(new ClassPathResource("cassandra/persistence-settings.xml"));

        return persistenceSettings;
    }

    public static CassandraCacheStoreFactory<Long, EntityWithMapField> getCacheStoreFactory() throws Exception {
        CassandraCacheStoreFactory<Long, EntityWithMapField> factory = new CassandraCacheStoreFactory<>();

        factory.setPersistenceSettings(getPersistenceSettings());
        factory.setDataSource(getDataSource());

        return factory;
    }

    public static DataSource getDataSource() {
        DataSource ds = new DataSource();

        ds.setCredentials(new PlainCredentials("", ""));
        ds.setContactPoints("127.0.0.1", "cassandra-test");
        ds.setReadConsistency("ONE");
        ds.setWriteConsistency("ONE");
        ds.setLoadBalancingPolicy(getLoadBalancingPolicy());

        return ds;
    }

    public static LoadBalancingPolicy getLoadBalancingPolicy() {

        LoadBalancingPolicy loadBalancingPolicy = new TokenAwarePolicy(new RoundRobinPolicy());
        return loadBalancingPolicy;
    }
}
