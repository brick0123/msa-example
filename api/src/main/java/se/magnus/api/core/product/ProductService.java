package se.magnus.api.core.product;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface ProductService {

    @GetMapping("/product/{productId}")
    Product getProduct(@PathVariable int productId);

    @PostMapping("/product")
    Product createProduct(@RequestBody Product request);

    @DeleteMapping(value = "/product/{productId}")
    void deleteProduct(@PathVariable Integer productId);
}
