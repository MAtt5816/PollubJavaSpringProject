package pl.kwojcik.project_lab.products;

import pl.kwojcik.project_lab.gen.api.dto.ProductDTO;

import java.util.List;
import java.util.Optional;

// #Zadanie_3__3
//start L3 Segregacja interfejsów

// !!! ProductInterface split to ProductService & ProductRepository interfaces

/*
public interface ProductInterface {
    //ProductService
    ProductDTO createProduct(ProductDTO productDTO);
    void deleteProduct(Long productId) ;
    ProductDTO getProduct(Long productId);
    List<ProductDTO> getProducts() ;
    ProductDTO updateProduct(ProductDTO productDTO);
    //ProductRepository
    Optional<ProductEntity> findById(Long productId);
    List<ProductEntity> findAll();
    void deleteById(Long productId);
    ProductEntity save(ProductEntity entity);
}
*/
