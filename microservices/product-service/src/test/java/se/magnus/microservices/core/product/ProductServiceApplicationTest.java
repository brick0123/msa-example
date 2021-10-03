package se.magnus.microservices.core.product;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.data.repository.core.support.RepositoryComposition.RepositoryFragments.just;
import static org.springframework.http.MediaType.APPLICATION_JSON;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import se.magnus.api.core.product.Product;
import se.magnus.microservices.core.product.domain.ProductRepository;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, properties = {"spring.data.mongodb.port: 0"})
class ProductServiceApplicationTest {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    WebTestClient client;

    @BeforeEach
    void setup() {
        productRepository.deleteAll();
    }

    @Test
    void duplicateError() {
        int productId = 1;
        postAndVerifyProduct(productId, HttpStatus.OK);

        assertThat(productRepository.findByProductId(productId).isPresent()).isTrue();
        postAndVerifyProduct(productId, HttpStatus.UNPROCESSABLE_ENTITY)
            .jsonPath("$.path").isEqualTo("/product")
            .jsonPath("$.message").isEqualTo("Duplicate key, Product Id: " + productId);
    }

    @Test
    void deleteProduct() {
        int productId = 1;
        postAndVerifyProduct(productId, HttpStatus.OK);
        assertThat(productRepository.findByProductId(productId).isPresent()).isTrue();

        deleteAndVerifyProduct(productId, HttpStatus.OK);

        assertThat(productRepository.findByProductId(productId).isPresent()).isFalse();

        deleteAndVerifyProduct(productId, HttpStatus.OK);
    }

    private WebTestClient.BodyContentSpec postAndVerifyProduct(int productId, HttpStatus expectedStatus) {
        Product product = new Product(productId, "Name " + productId, productId, "SA");
        return client.post()
            .uri("/product")
            .body(just(product), Product.class)
            .accept(APPLICATION_JSON)
            .exchange()
            .expectStatus().isEqualTo(expectedStatus)
            .expectHeader().contentType(APPLICATION_JSON)
            .expectBody();
    }

    private WebTestClient.BodyContentSpec deleteAndVerifyProduct(int productId, HttpStatus expectedStatus) {
        return client.delete()
            .uri("/product/" + productId)
            .accept(APPLICATION_JSON)
            .exchange()
            .expectStatus().isEqualTo(expectedStatus)
            .expectBody();
    }
}
