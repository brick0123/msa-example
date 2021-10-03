package se.magnus.microservices.core.review.domain;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import se.magnus.api.core.review.Review;

@Mapper(componentModel = "spring")
public interface ReviewMapper {

    @Mappings({
        @Mapping(target = "serviceAddress", ignore = true)
    })
    Review entityToApi(ReviewEntity entity);

    @Mappings({
        @Mapping(target = "id", ignore = true)
    })
    ReviewEntity apiToEntity(Review api);
}
