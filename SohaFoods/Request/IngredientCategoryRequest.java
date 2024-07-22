package com.foodOrder.SohaFoods.Request;



public class IngredientCategoryRequest {
	
	private String name;
	private Long restaurantId;
	public IngredientCategoryRequest() {
		super();
	}
	public IngredientCategoryRequest(String name, Long restaurantId) {
		super();
		this.name = name;
		this.restaurantId = restaurantId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(Long restaurantId) {
		this.restaurantId = restaurantId;
	}
	
	

}
