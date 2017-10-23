package org.testprojects.ignite.ignte_cassandra_client;

import java.util.HashMap;
import java.util.Map;
import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;

/**
 * Created by Alexander Fedotov.
 */
public class IgniteServerRunner {
    public static void main(String[] args) throws Exception {
        runServer();
    }

    private static void runServer() throws Exception {
        System.setProperty("IGNITE_QUIET", "false");

        Ignite ignite = Ignition.start(IgniteConfig.getIgniteConfig(false));

        IgniteCache<Long, EntityWithMapField> cache = ignite.getOrCreateCache(IgniteConfig.CACHE_NAME);

        Map<String, String> attrs = new HashMap<>(2);

        attrs.put("1", "one");
        attrs.put("2", "two");

        cache.put(1L, new EntityWithMapField(attrs));

        System.out.println(cache.get(1L));
    }
}
