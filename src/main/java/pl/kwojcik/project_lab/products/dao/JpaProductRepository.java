package pl.kwojcik.project_lab.products.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kwojcik.project_lab.products.ProductEntity;

@Repository
interface JpaProductRepository extends JpaRepository<ProductEntity, Long> {
}
