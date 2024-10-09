package pl.kwojcik.project_lab.products.dao;

import lombok.Getter;
import pl.kwojcik.project_lab.products.ProductEntity;
import pl.kwojcik.project_lab.utils.Memento;

public class ProductEntityMemento extends Memento {
    @Getter
    public ProductEntity state;

    public ProductEntityMemento(ProductEntity state) {
        this.state = state;
    }
}
