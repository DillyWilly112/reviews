package org.wecancodeit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;
import java.util.Collection;
import javax.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.wecancodeit.reviews.models.Review;
import org.wecancodeit.reviews.repositories.ReviewRepository;

public class ReviewRepositoryTest {

	@Resource
	private ReviewRepository underTest;
	
	private Review reviewOne = new Review(1L, "review name", "description");
	private Review reviewTwo = new Review(2L, "review name", "description");
	
	@Test
	public void ShouldFindReviewOneByID() {
		underTest = new ReviewRepository(reviewOne);
		Review foundReview = underTest.findOneReview(1L);
		assertThat(foundReview, is(reviewOne));
	}
	
	@Test
	public void ShouldFindReviewTwoByID() {
		underTest = new ReviewRepository(reviewTwo);
		Review foundReview = underTest.findOneReview(2L);
		assertThat(foundReview, is(reviewTwo));
	}
	
	@Test
	public void ShouldBeAbleToFindAllReviews() {
		underTest = new ReviewRepository(reviewOne, reviewTwo);
		Collection<Review> foundReviews = underTest.findAllReviews();
		assertThat(foundReviews, containsInAnyOrder(reviewOne, reviewTwo));
	}
}
