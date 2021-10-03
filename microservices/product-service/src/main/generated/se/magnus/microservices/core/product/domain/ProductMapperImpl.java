package se.magnus.microservices.core.product.domain;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import se.magnus.api.core.product.Product;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-10-03T23:09:43+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.12 (Amazon.com Inc.)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public Product entityToApi(ProductEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Product product = new Product();

        return product;
    }

    @Override
    public ProductEntity apiToEntity(Product api) {
        if ( api == null ) {
            return null;
        }

        String name = null;
        int productId = 0;
        int weight = 0;

        name = api.getName();
        productId = api.getProductId();
        weight = api.getWeight();

        ProductEntity productEntity = new ProductEntity( productId, name, weight );

        return productEntity;
    }
}
