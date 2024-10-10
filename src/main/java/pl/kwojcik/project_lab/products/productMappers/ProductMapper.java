package pl.kwojcik.project_lab.products.productMappers;

import pl.kwojcik.project_lab.gen.api.dto.ProductDTO;
import pl.kwojcik.project_lab.products.ProductEntity;

import java.math.BigDecimal;

// #Zadanie_2__9 Template
//start L2 Template
// #Zadanie_3__2
//start L3 Odwracania zależności
public abstract class ProductMapper {
    protected ProductEntity entity;

    public final ProductEntity map(ProductDTO dto) {
        this.entity = new ProductEntity();
        mapId(dto.getId());
        mapName(dto.getName());
        mapDescription(dto.getDescription());
        mapPrice(dto.getPrice());
        return entity;
    }

    protected final void mapId(Long id){
        entity.setId(id);
    }

    protected final void mapName(String name){
        entity.setName(name);
    }

    protected void mapDescription(String description){
        entity.setDescription(description);
    }

    protected final void mapPrice(BigDecimal price){
        entity.setPrice(price);
    }
}
