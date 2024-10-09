package pl.kwojcik.project_lab.products.productMappers;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import pl.kwojcik.project_lab.gen.api.dto.ProductDTO;
import pl.kwojcik.project_lab.products.ProductEntity;

public class ProductNoDescMapper extends ProductMapper {
    @Override
    protected void mapDescription(String description) {
        super.entity.setDescription("No description");
    }
}
