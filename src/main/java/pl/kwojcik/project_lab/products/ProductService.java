package pl.kwojcik.project_lab.products;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.kwojcik.project_lab.gen.api.ProductsApi;
import pl.kwojcik.project_lab.gen.api.dto.ProductDTO;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductDTO createProduct(ProductDTO productDTO) {
        var entity = mapProduct(productDTO);
        var createdEntity = productRepository.save(entity);
        return mapProduct(createdEntity);
    }


    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }


    public ProductDTO getProduct(Long productId) {
        var entity = productRepository.findById(productId).orElseThrow();
        return mapProduct(entity);
    }


    public List<ProductDTO> getProducts() {
        var products = productRepository.findAll();

        return products.stream().map(this::mapProduct).toList();
    }


    public ProductDTO updateProduct(ProductDTO productDTO) {
        var entity = mapProduct(productDTO);
        var updatedEntity = productRepository.save(entity);
        return mapProduct(updatedEntity);
    }

    private ProductDTO mapProduct(ProductEntity productEntity) {
        return new ProductDTO()
                .id(productEntity.getId())
                .name(productEntity.getName())
                .description(productEntity.getDescription())
                .price(productEntity.getPrice());
    }

    private ProductEntity mapProduct(ProductDTO dto) {
        var entity = new ProductEntity();

        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setPrice(dto.getPrice());
        return entity;
    }
}
