package se.magnus.microservices.core.recommendation.domain;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import se.magnus.api.core.recommendation.Recommendation;

@Mapper(componentModel = "spring")
public interface RecommendationMapper {

    @Mappings({
        @Mapping(target = "rate", source="entity.rating"),
        @Mapping(target = "serviceAddress", ignore = true)
    })
    Recommendation entityToApi(RecommendationEntity entity);

    @Mappings({
        @Mapping(target = "rating", source="api.rate"),
        @Mapping(target = "id", ignore = true)
    })
    RecommendationEntity apiToEntity(Recommendation api);
}
