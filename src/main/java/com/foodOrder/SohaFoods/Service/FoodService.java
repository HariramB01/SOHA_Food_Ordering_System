package com.foodOrder.SohaFoods.Service;

import java.util.List;

import com.foodOrder.SohaFoods.Model.Category;
import com.foodOrder.SohaFoods.Model.Food;
import com.foodOrder.SohaFoods.Model.Restaurant;
import com.foodOrder.SohaFoods.Request.CreateFoodRequest;

public interface FoodService {
	
	public Food createFood(CreateFoodRequest req, Category category, Restaurant restaurant);
	
	public void deleteFood(Long foodId) throws Exception;
	
	public List<Food> getRestaurantsFood(Long restaurantId,
			boolean vegetarian,
			boolean isNonVeg,
			boolean seasonal,
			String foodCategory
			);
	
	public List<Food> searchFood(String keyword);
	
	public Food findFoodById(Long foodId) throws Exception;
	
	public Food updateAvailabilityStatus(Long foodId) throws Exception;

}
