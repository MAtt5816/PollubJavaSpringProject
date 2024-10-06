package pl.kwojcik.project_lab.products.dao;

import org.springframework.stereotype.Component;
import pl.kwojcik.project_lab.products.ProductEntity;

import java.util.List;
import java.util.Optional;

// #Zadanie_1_10 proxy
//start L1 Proxy
@Component
public class ProductRepositoryDB implements ProductRepository {
    private final JpaProductRepository jpaProductRepository;

    public ProductRepositoryDB(JpaProductRepository jpaProductRepository) {
        this.jpaProductRepository = jpaProductRepository;
    }

    @Override
    public Optional<ProductEntity> findById(Long productId) {
        return jpaProductRepository.findById(productId);
    }

    @Override
    public List<ProductEntity> findAll() {
        return jpaProductRepository.findAll();
    }

    @Override
    public void deleteById(Long productId) {
        jpaProductRepository.deleteById(productId);
    }

    @Override
    public ProductEntity save(ProductEntity entity) {
        return jpaProductRepository.save(entity);
    }
}
