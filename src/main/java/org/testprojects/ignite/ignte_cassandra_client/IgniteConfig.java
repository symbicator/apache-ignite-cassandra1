package org.testprojects.ignite.ignte_cassandra_client;

import java.util.Collections;
import org.apache.ignite.configuration.CacheConfiguration;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.apache.ignite.spi.discovery.tcp.TcpDiscoverySpi;
import org.apache.ignite.spi.discovery.tcp.ipfinder.vm.TcpDiscoveryVmIpFinder;

/**
 * Created by Alexander Fedotov.
 */
public class IgniteConfig {

    public static final String CACHE_NAME = "cassandraCache";

    public static IgniteConfiguration getIgniteConfig(boolean clientMode) throws Exception {
        IgniteConfiguration igniteConfig = new IgniteConfiguration();

        igniteConfig.setClientMode(clientMode);

        TcpDiscoveryVmIpFinder ipFinder = new TcpDiscoveryVmIpFinder(true);
        ipFinder.setAddresses(Collections.singletonList("localhost:47500..47509"));

        TcpDiscoverySpi tcpDiscoverySpi = new TcpDiscoverySpi();

        tcpDiscoverySpi.setIpFinder(ipFinder);
        igniteConfig.setDiscoverySpi(tcpDiscoverySpi);

        igniteConfig.setCacheConfiguration(cacheConfig());

        return igniteConfig;
    }

    public static CacheConfiguration cacheConfig() throws Exception {
        CacheConfiguration<Long, EntityWithMapField> cacheConfig = new CacheConfiguration<>(CACHE_NAME);

        cacheConfig
            .setReadThrough(true)
            .setWriteThrough(true)
            .setCacheStoreFactory(CassandraConfig.getCacheStoreFactory())
        ;

        return cacheConfig;
    }
}
