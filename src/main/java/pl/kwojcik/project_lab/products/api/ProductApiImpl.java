package pl.kwojcik.project_lab.products.api;

import org.springframework.http.ResponseEntity;
import pl.kwojcik.project_lab.gen.api.ProductsApi;
import pl.kwojcik.project_lab.gen.api.dto.ProductDTO;

public class ProductApiImpl implements ProductsApi {
    @Override
    public ResponseEntity<ProductDTO> createProduct(ProductDTO productDTO) {
        return ProductsApi.super.createProduct(productDTO);
    }

    @Override
    public ResponseEntity<Void> deleteProduct(Long productId) {
        return ProductsApi.super.deleteProduct(productId);
    }

    @Override
    public ResponseEntity<ProductDTO> getProduct(Long productId) {
        return ProductsApi.super.getProduct(productId);
    }

    @Override
    public ResponseEntity<ProductDTO> getProducts() {
        return ProductsApi.super.getProducts();
    }

    @Override
    public ResponseEntity<ProductDTO> updateProduct(ProductDTO productDTO) {
        return ProductsApi.super.updateProduct(productDTO);
    }
}
