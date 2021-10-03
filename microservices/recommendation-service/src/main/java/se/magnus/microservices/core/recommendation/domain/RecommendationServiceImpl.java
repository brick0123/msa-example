package se.magnus.microservices.core.recommendation.domain;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;
import se.magnus.api.core.recommendation.Recommendation;
import se.magnus.api.core.recommendation.RecommendationService;
import se.magnus.util.exceptions.InvalidInputException;
import se.magnus.util.http.ServiceUtil;

@RestController
public class RecommendationServiceImpl implements RecommendationService {

    private static final Logger LOG = LoggerFactory.getLogger(RecommendationServiceImpl.class);

    private final RecommendationRepository recommendationRepository;
    private final RecommendationMapper mapper;
    private final ServiceUtil serviceUtil;

    public RecommendationServiceImpl(final RecommendationRepository recommendationRepository, final RecommendationMapper mapper, final ServiceUtil serviceUtil) {
        this.recommendationRepository = recommendationRepository;
        this.mapper = mapper;
        this.serviceUtil = serviceUtil;
    }

    @Override
    public List<Recommendation> getRecommendations(int productId) {

        if (productId < 1) throw new InvalidInputException("Invalid productId: " + productId);

        if (productId == 113) {
            LOG.debug("No recommendations found for productId: {}", productId);
            return  new ArrayList<>();
        }

        List<Recommendation> list = new ArrayList<>();
        list.add(new Recommendation(productId, 1, "Author 1", 1, "Content 1", serviceUtil.getServiceAddress()));
        list.add(new Recommendation(productId, 2, "Author 2", 2, "Content 2", serviceUtil.getServiceAddress()));
        list.add(new Recommendation(productId, 3, "Author 3", 3, "Content 3", serviceUtil.getServiceAddress()));

        LOG.debug("/recommendation response size: {}", list.size());

        return list;
    }

    @Override
    public Recommendation createRecommendation(final Recommendation body) {
        RecommendationEntity entity = mapper.apiToEntity(body);
        RecommendationEntity newEntity = recommendationRepository.save(entity);

        LOG.debug("createRecommendation: created a recommendation entity: {}/{}", body.getProductId(), body.getRecommendationId());
        return mapper.entityToApi(newEntity);    }

    @Override
    public void deleteRecommendations(final int productId) {
        recommendationRepository.deleteAll(recommendationRepository.findByProductId(productId));
    }
}
