package se.magnus.microservices.core.product.domain;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;
import se.magnus.api.core.product.Product;
import se.magnus.api.core.product.ProductService;
import se.magnus.util.exceptions.InvalidInputException;
import se.magnus.util.http.ServiceUtil;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {


    public static final int MIN_PRODUCT_ID = 1;
    private final ServiceUtil serviceUtil;
    private final ProductMapper mapper;
    private final ProductRepository productRepository;

    @Override
    public Product getProduct(int productId) {
        log.debug("/product return the found product for productId={}", productId);

        if (productId < MIN_PRODUCT_ID) {
            throw new InvalidInputException("Invalid productId: " + productId);
        }

        return new Product(productId, "name-" + productId, 123, serviceUtil.getServiceAddress());
    }

    @Override
    public Product createProduct(final Product request) {
        ProductEntity entity = mapper.apiToEntity(request);
        ProductEntity newEntity = productRepository.save(entity);

        log.debug("createProduct: entity created for productId: {}", request.getProductId());
        return mapper.entityToApi(newEntity);
    }

    @Override
    public void deleteProduct(final Integer productId) {
        log.debug("deleteProduct: tries to delete an entity with productId: {}", productId);
        productRepository.findByProductId(productId).ifPresent(productRepository::delete);
    }
}
