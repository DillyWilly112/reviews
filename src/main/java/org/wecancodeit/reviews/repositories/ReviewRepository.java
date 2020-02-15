package org.wecancodeit.reviews.repositories;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.wecancodeit.reviews.models.Review;

@Repository
public class ReviewRepository {

	private Map<Long, Review> reviewList = new HashMap<>();
	private Review dogs = new Review(1L, "Dogs", "As a furry pup lover, there is no doubt in my mind that having a dog brings many upsides to my life. I mean, how can I NOT live happily waking up to a smiley face and wagging tail? For those of you who do not yet have a furry friend, or who are planning on adding one to your family, you’ll be glad to hear that there are scientifically proven benefits that dogs bring to each of our lives! So if you’re looking for reasons to get a dog, here’s 17!\r\n" + 
			"Table of Contents\r\n" + 
			"\r\n" + 
			"1. Dogs increase your mood dramatically!\r\n" + 
			"2. Having a dog may help reduce the risk of cardiovascular disease.\r\n" + 
			"3. Step aside, kitties! Dogs protect children from skin conditions and allergies.\r\n" + 
			"4. Having a dog improves your physical wellbeing and encourages a healthy fitness routine.\r\n" + 
			"5. Humans with dogs recover more quickly from illnesses.\r\n" + 
			"6. Dogs make excellent service and alert animals.\r\n" + 
			"7. Children with dogs in their household miss less school.\r\n" + 
			"8. But wait, there’s more (for your kids)!\r\n" + 
			"9. Simply put, they are a human’s best friend.\r\n" + 
			"10. They will go to great lengths–2,800 miles to be exact–to find their humans.\r\n" + 
			"11. They make excellent watchdogs.\r\n" + 
			"12. Dogs help increase social interactions.\r\n" + 
			"13. There’s never a dull or boring moment.\r\n" + 
			"14. Dogs may save your life.\r\n" + 
			"15. Stressed at work? Let me prescribe you one adorable puppy.\r\n" + 
			"16. Having a dog makes YOU more awesome!\r\n" + 
			"17. Need I say more?");
	private Review cats = new Review(2L, "Cats", "Studies have shown that just watching cat videos on the internet can boost a person's energy and create positive "
			+ "emotions—so it's no surprise that actual cat ownership has a number of benefits. Here are a few."
			+ "1. Owning a cat is better for the environment.\r\n"
			+ "2. They'll help you cope.\r\n"
			+ "3. And they'll help you find a significant other.\r\n"
			+ "4. Cat owners are smart.\r\n"
			+ "5. You'll have a healthier heart.\r\n"
			+ "6. They fulfill your need for companionship.\r\n"
			+ "7. They can tell you (and others) a lot about your personality.\r\n"
			+ "8. You'll sleep better.\r\n"
			+ "9. Cat ownership means fewer allergies.\r\n"
			+ "10.They can quite literally save your life.\r\n");
	
	public ReviewRepository() {
		reviewList.put(dogs.getId(), dogs);
		reviewList.put(cats.getId(), cats);
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
