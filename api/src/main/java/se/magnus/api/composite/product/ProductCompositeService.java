package se.magnus.api.composite.product;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface ProductCompositeService {

    @GetMapping("/product-composite/{productId}")
    ProductAggregate getProduct(@PathVariable int productId);

    @PostMapping("/product-composite")
    void createCompositeProduct(@RequestBody ProductAggregate body);

    @DeleteMapping(value = "/product-composite/{productId}")
    void deleteCompositeProduct(@PathVariable int productId);
}
