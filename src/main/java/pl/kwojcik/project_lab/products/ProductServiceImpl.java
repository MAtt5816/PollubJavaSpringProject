package pl.kwojcik.project_lab.products;

import pl.kwojcik.project_lab.gen.api.dto.ProductDTO;
import pl.kwojcik.project_lab.products.dao.ProductRepository;
import pl.kwojcik.project_lab.products.productMappers.ProductNoDescMapper;
import pl.kwojcik.project_lab.products.productMappers.ProductWithDescMapper;

import java.util.List;

// #Zadanie__1_5 Adapter
//start L1 Adapter
class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
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
        if (dto.getDescription().isEmpty()) {
            return new ProductNoDescMapper().map(dto);
        }
        else {
            return new ProductWithDescMapper().map(dto);
        }
    }
}
