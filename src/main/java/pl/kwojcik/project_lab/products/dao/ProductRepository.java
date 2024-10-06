package pl.kwojcik.project_lab.products.dao;

import pl.kwojcik.project_lab.products.ProductEntity;

import java.util.List;
import java.util.Optional;


public interface ProductRepository  {

    Optional<ProductEntity> findById(Long productId);

    List<ProductEntity> findAll();

    void deleteById(Long productId);

    ProductEntity save(ProductEntity entity);
}
