package org.wecancodeit.reviews.repositories;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.wecancodeit.reviews.models.Review;

@Repository
public class ReviewRepository {

	private Map<Long, Review> reviewList = new HashMap<>();
	private Review dogBreed1 = new Review(1L, "DogBreed1", "Dog Breed Description");
	private Review dogBreed2 = new Review(2L, "DogBreed2", "Dog Breed Description");
	
	public ReviewRepository() {
		reviewList.put(dogBreed1.getId(), dogBreed1);
		reviewList.put(dogBreed2.getId(), dogBreed2);
	}
	
	// uses varargs for testing purposes to take on the necessary courses.
	public ReviewRepository(Review...reviews) {
		for(Review review: reviews) {
			reviewList.put(review.getId(), review);
		}
	}

	public Review findOneReview(long id) {
		return reviewList.get(id);
	}

	public Collection<Review> findAllReviews() {
		return reviewList.values();
	}
}
