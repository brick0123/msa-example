package se.magnus.api.core.recommendation;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface RecommendationService {

    @GetMapping(value    = "/recommendation")
    List<Recommendation> getRecommendations(@RequestParam(value = "productId") int productId);

    @PostMapping("/recommendation")
    Recommendation createRecommendation(@RequestBody Recommendation body);

    @DeleteMapping(value = "/recommendation")
    void deleteRecommendations(@RequestParam(value = "productId")  int productId);
}
