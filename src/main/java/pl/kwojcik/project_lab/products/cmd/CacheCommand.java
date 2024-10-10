package pl.kwojcik.project_lab.products.cmd;

import pl.kwojcik.project_lab.products.dao.ProductEntityCache;

// #Zadanie_2__1 Command
//start L2 Command
// #Zadanie_3__2
//start L3 Odwracania zależności
public abstract class CacheCommand implements Command {
    protected ProductEntityCache cache;

    public CacheCommand() {
        cache = ProductEntityCache.getInstance();
    }

    public abstract void undo();
    public abstract boolean execute();
}
