package pl.kwojcik.project_lab.products.dao;

import pl.kwojcik.project_lab.products.ProductEntity;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

// #Zadanie__1_2 Singleton
//start L1 Singleton
public class ProductEntityCache {
    record CachedProductEntity(ProductEntity entity, Instant expresAt) {}

    private static ProductEntityCache INSTANCE;

    private final Map<Long, CachedProductEntity> cache = new HashMap<>();

    private ProductEntityCache() {
    }

    public synchronized ProductEntityCache getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ProductEntityCache();
        }
        return INSTANCE;
    }

    public synchronized ProductEntity get(long id) {
        var obj = cache.get(id);
        if (obj == null) {
            return null;
        }
        if (obj.expresAt.isAfter(Instant.now())) {
            cache.remove(id);
            return null;
        }
        return obj.entity;
    }

    public synchronized void put(ProductEntity entity) {
        cache.put(entity.getId(),
                new CachedProductEntity(entity.clone(), Instant.now().plus(30, ChronoUnit.SECONDS)));

    }
}
