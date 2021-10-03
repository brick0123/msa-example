package se.magnus.api.core.review;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface ReviewService {

    @GetMapping("/review")
    List<Review> getReviews(@RequestParam(value = "productId") int productId);

    @PostMapping("/review")
    Review createReview(@RequestBody Review body);

    @DeleteMapping(value = "/review")
    void deleteReviews(@RequestParam(value = "productId", required = true)  int productId);
}
