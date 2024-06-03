package com.foodOrder.SohaFoods.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodOrder.SohaFoods.Model.Category;
import com.foodOrder.SohaFoods.Model.Food;
import com.foodOrder.SohaFoods.Model.Restaurant;
import com.foodOrder.SohaFoods.Repository.FoodRepository;
import com.foodOrder.SohaFoods.Request.CreateFoodRequest;

@Service
public class FoodServiceImpl implements FoodService{
	
	@Autowired
	private FoodRepository foodRepo;

	@Override
	public Food createFood(CreateFoodRequest req, Category category, Restaurant restaurant) {
		Food food = new Food();
		food.setFoodCategory(category);
		food.setRestaurant(restaurant);
		food.setDescription(req.getDescription());
		food.setImages(req.getImages());
		food.setName(req.getName());
		food.setPrice(req.getPrice());
		food.setIngredients(req.getIngredients());
		food.setSeasonal(req.isSeasonal());
		food.setVegetable(req.isVegetarian());
		
		Food saveFood = foodRepo.save(food);
		restaurant.getFood().add(saveFood);
		return saveFood;
	}

	@Override
	public void deleteFood(Long foodId) throws Exception {
		Food food = findFoodById(foodId);
		food.setRestaurant(null);
		foodRepo.save(food);
	}

	@Override
	public List<Food> getRestaurantsFood(Long restaurantId, 
			boolean vegetarian, 
			boolean isNonVeg, 
			boolean seasonal,
			String foodCategory) {
		List<Food> foods = foodRepo.findByRestaurantId(restaurantId);
		if(vegetarian) {
			foods =filterByVegetarian(foods, vegetarian);
		}
		if(isNonVeg) {
			foods = filterByNonVeg(foods,isNonVeg);
		}
		if(seasonal) {
			foods = filterBySeasonal(foods, seasonal);
		}
		if(foodCategory!=null && !foodCategory.equals("")) {
			foods = filterByCategory(foods,foodCategory);
		}
		return foods;
	}
	

	private List<Food> filterByCategory(List<Food> foods, String foodCategory) {
		return foods.stream().filter(food->{
			if(food.getFoodCategory()!=null) {
				return food.getFoodCategory().getName().equals(foodCategory);
			}
			return false;
		}).collect(Collectors.toList());
	}

	private List<Food> filterBySeasonal(List<Food> foods, boolean seasonal) {
		return foods.stream().filter(food->food.isSeasonal()==seasonal).collect(Collectors.toList());
	}

	private List<Food> filterByNonVeg(List<Food> foods, boolean isNonVeg) {
		return foods.stream().filter(food->food.isVegetable()==false).collect(Collectors.toList());
	}

	private List<Food> filterByVegetarian(List<Food> foods, boolean vegetarian) {
		return foods.stream().filter(food->food.isVegetable()==vegetarian).collect(Collectors.toList());
	}

	@Override
	public List<Food> searchFood(String keyword) {
		return foodRepo.searchFood(keyword);
	}

	@Override
	public Food findFoodById(Long foodId) throws Exception {
		Optional<Food> optionalFood = foodRepo.findById(foodId);
		if(optionalFood.isEmpty()) {
			throw new Exception("food not exist");
		}
		return optionalFood.get();
	}

	@Override
	public Food updateAvailabilityStatus(Long foodId) throws Exception {
		Food food = findFoodById(foodId);
		food.setAvailable(!food.isAvailable());
		return foodRepo.save(food);
	}

}
