package pl.kwojcik.project_lab.products;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;
import pl.kwojcik.project_lab.gen.api.dto.ProductDTO;

import java.util.List;

// #Zadanie_1__8 Decorator
//start L1 Decorator
public class ProductServiceTxDecorator implements ProductService {
    private final ProductService productService;
    private final TransactionTemplate txTemplate;

    public ProductServiceTxDecorator(ProductService productService, PlatformTransactionManager txMngr) {
        this.productService = productService;
        this.txTemplate = new TransactionTemplate(txMngr);
    }

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        return txTemplate.execute(tx -> {
            return productService.createProduct(productDTO);
        });
    }

    @Override
    public void deleteProduct(Long productId) {
        txTemplate.executeWithoutResult(tx -> {
             productService.deleteProduct(productId);
        });
    }

    @Override
    public ProductDTO getProduct(Long productId) {
        return txTemplate.execute(tx -> {
            return productService.getProduct(productId);
        });
    }

    @Override
    public List<ProductDTO> getProducts() {
        return txTemplate.execute(tx -> {
            return productService.getProducts();
        });
    }

    @Override
    public ProductDTO updateProduct(ProductDTO productDTO) {
        return txTemplate.execute(tx -> {
            return productService.updateProduct(productDTO);
        });
    }

}
