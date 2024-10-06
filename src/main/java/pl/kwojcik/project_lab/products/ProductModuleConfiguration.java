package pl.kwojcik.project_lab.products;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import pl.kwojcik.project_lab.products.dao.ProductRepositoryDB;

@Configuration
public class ProductModuleConfiguration {
    private final ProductServiceFactory productServiceFactory;


    public ProductModuleConfiguration(
            ProductRepositoryDB jpaProductRepository,
            PlatformTransactionManager txManger,
            @Value("${refactoring.variables.useTransactionsInProductService}") String useTransactionsInProductService
    ) {
        this.productServiceFactory = new ProductServiceFactory(jpaProductRepository,
                txManger,
                "true".equals(useTransactionsInProductService));
    }

    @Bean
    public ProductService productService() {
        return productServiceFactory.createProductService();
    }
}
