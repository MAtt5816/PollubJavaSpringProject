package pl.kwojcik.project_lab.products.cmd;

import lombok.Getter;
import lombok.Setter;
import pl.kwojcik.project_lab.products.ProductEntity;

public class CacheProduct extends CacheCommand {
    @Getter
    @Setter
    public ProductEntity product;

    @Override
    public void undo() {
        var memento = super.cache.undo();
        product.restore(memento);
    }

    @Override
    public boolean execute() {
        if (product != null) {
            var memento = product.cache();
            cache.put(memento);
            return true;
        }
        else return false;
    }
}
