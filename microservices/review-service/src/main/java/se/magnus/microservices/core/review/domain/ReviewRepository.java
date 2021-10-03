package se.magnus.microservices.core.review.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<ReviewEntity, Integer> {

}
