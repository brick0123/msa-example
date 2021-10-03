package se.magnus.microservices.core.recommendation.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="recommendations")
@CompoundIndex(name = "prod-rec-id", unique = true, def = "{'productId': 1, 'recommendationId' : 1}")
public class RecommendationEntity {

    @Id
    private String id;

    private int productId;

    private int recommendationId;

    private String author;

    private int rating;

    private String content;

    public String getId() {
        return id;
    }

    public int getProductId() {
        return productId;
    }

    public int getRecommendationId() {
        return recommendationId;
    }

    public String getAuthor() {
        return author;
    }

    public int getRating() {
        return rating;
    }

    public String getContent() {
        return content;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public void setProductId(final int productId) {
        this.productId = productId;
    }

    public void setRecommendationId(final int recommendationId) {
        this.recommendationId = recommendationId;
    }

    public void setAuthor(final String author) {
        this.author = author;
    }

    public void setRating(final int rating) {
        this.rating = rating;
    }

    public void setContent(final String content) {
        this.content = content;
    }
}
