package pl.kwojcik.project_lab.products.api;

import jakarta.annotation.security.RolesAllowed;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RestController;
import pl.kwojcik.project_lab.gen.api.ProductsApi;
import pl.kwojcik.project_lab.gen.api.dto.ProductDTO;
import pl.kwojcik.project_lab.products.ProductService;

import java.util.List;

@RestController
public class ProductApiImpl implements ProductsApi {
    private final ProductService productService;

    public ProductApiImpl(ProductService productService) {
        this.productService = productService;
    }

    @Override
    @RolesAllowed("ROLE_USER")
    public ResponseEntity<ProductDTO> createProduct(ProductDTO productDTO) {
        var dto = this.productService.createProduct(productDTO);
        return ResponseEntity.ok(dto);
    }

    @Override
    public ResponseEntity<Void> deleteProduct(Long productId) {
        this.productService.deleteProduct(productId);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<ProductDTO> getProduct(Long productId) {
        var dto = this.productService.getProduct(productId);
        return ResponseEntity.ok(dto);
    }

    @Override
    public ResponseEntity<List<ProductDTO>> getProducts() {
        var dto = this.productService.getProducts();
        return ResponseEntity.ok(dto);
    }

    @Override
    public ResponseEntity<ProductDTO> updateProduct(ProductDTO productDTO) {
        var dto = this.productService.updateProduct(productDTO);
        return ResponseEntity.ok(dto);
    }
}
