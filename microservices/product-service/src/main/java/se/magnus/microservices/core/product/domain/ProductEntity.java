package se.magnus.microservices.core.product.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "products")
@Getter
@EqualsAndHashCode
public class ProductEntity {

    @Id
    private String id;

    @Indexed(unique = true)
    private int productId;

    private String name;

    private int weight;

    public ProductEntity(final int productId, final String name, final int weight) {
        this.productId = productId;
        this.name = name;
        this.weight = weight;
    }

    public void setName(final String name) {
        this.name = name;
    }
}
