package pl.kwojcik.project_lab.products;

import org.springframework.transaction.PlatformTransactionManager;
import pl.kwojcik.project_lab.products.dao.ProductRepositoryDB;

// #Zadanie__1_1 factory
//start L1 Factory
public class ProductServiceFactory {
    private final ProductRepositoryDB productRepository;
    private final boolean useTransactionsInProductService;
    private final PlatformTransactionManager txMngr;

    public ProductServiceFactory(
            ProductRepositoryDB productRepository,
            PlatformTransactionManager txMngr,
            boolean useTransactionsInProductService
    ) {
        this.productRepository = productRepository;
        this.useTransactionsInProductService = useTransactionsInProductService;
        this.txMngr = txMngr;
    }

    public ProductService createProductService() {
        if (useTransactionsInProductService) {
            return new ProductServiceTxDecorator(new ProductServiceImpl(productRepository), txMngr);
        } else {
            return new ProductServiceImpl(productRepository);
        }
    }
}
