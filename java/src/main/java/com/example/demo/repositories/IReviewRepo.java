package com.example.demo.repositories;

import java.util.List;
import com.example.demo.entities.Review;

public interface IReviewRepo {
    // Saves a new review to the repository
    Review save(Review review);
    // Retrieves all the reviews for a given restaurant in asc & desc order
    List<String> getAllReviewDesc(Long id);
    List<String> getAllReviewAsc(Long id);
    // Retrieves filtered reviews for a given restaurant in asc & desc order.
    List<String> filteredReviewsDsc(Long id, Integer low, Integer high);
    List<String> filteredReviewsAsc(Long id, Integer low, Integer high);
}
