package pl.kwojcik.project_lab.products.dao;

import pl.kwojcik.project_lab.products.ProductEntity;
import pl.kwojcik.project_lab.utils.Memento;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// #Zadanie__1_2 Singleton
//start L1 Singleton
// #Zadanie_2__5 Memento
//start L2 Memento
public class ProductEntityCache {
    record CachedProductEntity(ProductEntity entity, Instant expresAt) {}

    private static ProductEntityCache INSTANCE;

    private final Stack<ProductEntityMemento> cache = new Stack<>();

    private ProductEntityCache() {
    }

    public static synchronized ProductEntityCache getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ProductEntityCache();
        }
        return INSTANCE;
    }

    public synchronized ProductEntityMemento undo() {
        return cache.pop();
    }

    public synchronized void put(Memento memento) {
        cache.push((ProductEntityMemento) memento);
    }
}
