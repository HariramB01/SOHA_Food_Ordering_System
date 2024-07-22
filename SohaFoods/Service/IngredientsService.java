package com.foodOrder.SohaFoods.Service;

import java.util.List;

import com.foodOrder.SohaFoods.Model.IngredientCategory;
import com.foodOrder.SohaFoods.Model.IngredientItems;

public interface IngredientsService {
	
	public IngredientCategory createIngredientCategory(String name, Long restaurantId) throws Exception;
	
	public IngredientCategory findIngredientCategoryById(Long id) throws Exception;
	
	public List<IngredientCategory> findIngredientCategoryByRestaurantId(Long id) throws Exception;
	
	public IngredientItems createIngredientItem(Long restaurantId, String ingredientName, Long categoryId) throws Exception;
	
	public List<IngredientItems> findRestaurantsIngredients(Long restaurantId) throws Exception;
	
	public IngredientItems updateStock(Long id) throws Exception;
	
	
	
	
	

}
