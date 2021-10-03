package se.magnus.microservices.core.review.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(name = "reviews", indexes = { @Index(name = "reviews_unique_idx", unique = true, columnList = "productId,reviewId") })
public class ReviewEntity {

    @Id
    @GeneratedValue
    private int id;

    private int productId;

    private int reviewId;

    private String author;

    private String subject;

    private String content;

    public int getId() {
        return id;
    }

    public int getProductId() {
        return productId;
    }

    public int getReviewId() {
        return reviewId;
    }

    public String getAuthor() {
        return author;
    }

    public String getSubject() {
        return subject;
    }

    public String getContent() {
        return content;
    }
}
