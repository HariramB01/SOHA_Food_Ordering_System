package com.foodOrder.SohaFoods.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodOrder.SohaFoods.Model.Category;
import com.foodOrder.SohaFoods.Model.Restaurant;
import com.foodOrder.SohaFoods.Repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepo;
	
	@Autowired
	private RestaurantService restaurantService;

	@Override
	public Category createCategory(String name, Long userId) throws Exception {
		Restaurant restaurant = restaurantService.getRestaurantByUserId(userId);
		Category category = new Category();
		category.setName(name);
		category.setRestaurant(restaurant);
		return categoryRepo.save(category);
	}

	@Override
	public List<Category> findCategoryByRestaurantId(Long id) throws Exception {
		Restaurant restaurant = restaurantService.getRestaurantByUserId(id);
		return categoryRepo.findRestaurantById(restaurant.getId());
	}

	@Override
	public Category findCategoryById(Long id) throws Exception {
		Optional<Category> opt = categoryRepo.findById(id);
		if(opt.isEmpty()) {
			throw new Exception("category not found");
		}
		return opt.get();
	}

}
