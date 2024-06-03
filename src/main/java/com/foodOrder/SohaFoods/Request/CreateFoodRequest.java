package com.foodOrder.SohaFoods.Request;

import java.util.List;

import com.foodOrder.SohaFoods.Model.Category;
import com.foodOrder.SohaFoods.Model.IngredientItems;

public class CreateFoodRequest {
	
	private String name;
	private String description;
	
	private Long price;
	private Category category;
	private List<String> images;
	private Long restaurantId;
	private boolean vegetarian;
	private boolean seasonal;
	private List<IngredientItems> ingredients;
	public CreateFoodRequest() {
		super();
	}
	public CreateFoodRequest(String name, String description, Long price, Category category, List<String> images,
			Long restaurantId, boolean vegetarian, boolean seasonal, List<IngredientItems> ingredients) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.category = category;
		this.images = images;
		this.restaurantId = restaurantId;
		this.vegetarian = vegetarian;
		this.seasonal = seasonal;
		this.ingredients = ingredients;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public List<String> getImages() {
		return images;
	}
	public void setImages(List<String> images) {
		this.images = images;
	}
	public Long getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(Long restaurantId) {
		this.restaurantId = restaurantId;
	}
	public boolean isVegetarian() {
		return vegetarian;
	}
	public void setVegetarian(boolean vegetarian) {
		this.vegetarian = vegetarian;
	}
	public boolean isSeasonal() {
		return seasonal;
	}
	public void setSeasonal(boolean seasonal) {
		this.seasonal = seasonal;
	}
	public List<IngredientItems> getIngredients() {
		return ingredients;
	}
	public void setIngredients(List<IngredientItems> ingredients) {
		this.ingredients = ingredients;
	}
	
	
	
}
