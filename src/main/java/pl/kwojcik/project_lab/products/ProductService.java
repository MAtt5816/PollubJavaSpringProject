package pl.kwojcik.project_lab.products;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.kwojcik.project_lab.gen.api.dto.ProductDTO;
import pl.kwojcik.project_lab.products.dao.ProductRepository;

import java.util.List;

public interface ProductService {

    ProductDTO createProduct(ProductDTO productDTO);
    void deleteProduct(Long productId) ;
    ProductDTO getProduct(Long productId);
    List<ProductDTO> getProducts() ;
    ProductDTO updateProduct(ProductDTO productDTO);
}
