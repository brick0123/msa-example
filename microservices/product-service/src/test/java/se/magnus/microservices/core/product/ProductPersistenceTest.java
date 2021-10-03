package se.magnus.microservices.core.product;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import se.magnus.microservices.core.product.domain.ProductEntity;
import se.magnus.microservices.core.product.domain.ProductRepository;

@DataMongoTest
public class ProductPersistenceTest {

    @Autowired
    ProductRepository productRepository;
    ProductEntity productEntity;

    @AfterEach
    void setup() {
        productRepository.deleteAll();
    }

    @Test
    void create() {
        final ProductEntity entity = new ProductEntity(1, "n", 2);
        productRepository.save(entity);

        final ProductEntity findProduct = productRepository.findById(entity.getId()).get();

        assertThat(entity).isEqualTo(findProduct);
        assertThat(productRepository.count()).isEqualTo(1);
    }

    @Test
    void update() {
        final ProductEntity entity = new ProductEntity(1, "n", 2);
        productRepository.save(entity);

        entity.setName("n2");
        productRepository.save(entity);

        final ProductEntity findProduct = productRepository.findById(entity.getId()).get();
        assertThat(findProduct.getName()).isEqualTo(entity.getName());
    }
}
