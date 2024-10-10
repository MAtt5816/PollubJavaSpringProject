package pl.kwojcik.project_lab.products.productMappers;

public class ProductNoDescMapper extends ProductMapper {
    private final String NO_DESCRIPTION = "No description";

    @Override
    protected void mapDescription(String description) {
        // #Zadanie_3__9
        //start L3 wyeliminuj magiczne liczby
        /*
        super.entity.setDescription("No description");
        */
        super.entity.setDescription(NO_DESCRIPTION);
    }
}
