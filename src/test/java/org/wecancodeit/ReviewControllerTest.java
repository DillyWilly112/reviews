package org.wecancodeit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.wecancodeit.reviews.controller.ReviewController;
import org.wecancodeit.reviews.models.Review;
import org.wecancodeit.reviews.repositories.ReviewRepository;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.Arrays;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

@RunWith(SpringRunner.class)
@WebMvcTest(ReviewController.class)

public class ReviewControllerTest {

	
	@Autowired
	private MockMvc mockMvc;
	
	@Mock
	private Review reviewOne;
	
	@Mock
	private Review reviewTwo;
	
	@Mock
	private ReviewRepository reviewRepo;
	
	@Test
	public void ShouldGetStatusOfOkWhenNavigatingToAllReviews() throws Exception {
		this.mockMvc.perform(get("/show-reviews")).andExpect(status().isOk())
		.andExpect(view().name("reviews-template"));
	}
	
	@Test
	public void ShouldGetStatusOfOkWhenNavigatingToReviewOnePage() throws Exception {
		when(reviewRepo.findOneReview(1L)).thenReturn(reviewOne);
		this.mockMvc.perform(get("/show-single-review?id=1")).andExpect(status().isOk())
		.andExpect(view().name("review-template"));
}
	
	@Test
	public void ShouldAddAllReviewsToTheModel() throws Exception {
		when(reviewRepo.findAllReviews()).thenReturn(Arrays.asList(reviewOne, reviewTwo));
		this.mockMvc.perform(get("/show-reviews"))
		.andExpect(model().attribute("reviewsModel", hasSize(2)));
}
	@Test
	public void ShouldAddSingleReviewToTheModel() throws Exception {
		when(reviewRepo.findOneReview(1L)).thenReturn(reviewOne);
		this.mockMvc.perform(get("/show-single-review?id=1"))
		.andExpect(model().attribute("reviewModel", is(reviewOne)));
}
	
	@Test 
	public void ShouldReturnNotFoundIfBadRequest() throws Exception{
		Long badId = 5L;
		when(reviewRepo.findOneReview(badId)).thenReturn(null);
		this.mockMvc.perform(get("/show-single-review?id=5"))
		.andExpect(status().isNotFound());
	}
}
