package com.foodOrder.SohaFoods.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodOrder.SohaFoods.Model.IngredientCategory;
import com.foodOrder.SohaFoods.Model.IngredientItems;
import com.foodOrder.SohaFoods.Model.Restaurant;
import com.foodOrder.SohaFoods.Repository.IngredientCategoryRespository;
import com.foodOrder.SohaFoods.Repository.IngredientItemRepository;

@Service
public class IngredientServiceImpl implements IngredientsService{
	
	
	@Autowired
	private IngredientCategoryRespository catRepo;
	
	@Autowired
	private IngredientItemRepository itemRepo;
	
	@Autowired
	private RestaurantService restaurantService;

	@Override
	public IngredientCategory createIngredientCategory(String name, Long restaurantId) throws Exception {
		Restaurant restaurant = restaurantService.findRestaurantById(restaurantId);
		
		IngredientCategory category = new IngredientCategory();
		category.setRestaurant(restaurant);
		category.setName(name);
		return catRepo.save(category);
	}

	@Override
	public IngredientCategory findIngredientCategoryById(Long id) throws Exception {
		Optional<IngredientCategory> opt = catRepo.findById(id);
		if(opt.isEmpty()) {
			throw new Exception("ingredient category not found");
		}
		return opt.get();
	}

	@Override
	public List<IngredientCategory> findIngredientCategoryByRestaurantId(Long id) throws Exception {
		restaurantService.findRestaurantById(id);
		return catRepo.findByRestaurantId(id);
	}

	@Override
	public IngredientItems createIngredientItem(Long restaurantId, String ingredientName, Long categoryId)
			throws Exception {
		Restaurant restaurant = restaurantService.findRestaurantById(restaurantId);
		IngredientCategory category = findIngredientCategoryById(categoryId);
		
		IngredientItems item = new IngredientItems();
		item.setName(ingredientName);
		item.setCategory(category);
		item.setRestaurant(restaurant);
		
		IngredientItems ingredient = itemRepo.save(item);
		category.getIngredients().add(ingredient);
		
		return ingredient;
	}

	@Override
	public List<IngredientItems> findRestaurantsIngredients(Long restaurantId) throws Exception {
		
		return itemRepo.findByRestaurantId(restaurantId);
	}

	@Override
	public IngredientItems updateStock(Long id) throws Exception {
		Optional<IngredientItems> opt = itemRepo.findById(id);
		if(opt.isEmpty()) {
			throw new Exception("ingredient not found");
		}
		IngredientItems items = opt.get();
		items.setInStock(!items.isInStock());
		return itemRepo.save(items);
	}

}
