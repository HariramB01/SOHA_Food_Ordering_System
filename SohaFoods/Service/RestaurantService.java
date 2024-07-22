package com.foodOrder.SohaFoods.Service;

import java.util.List;

import com.foodOrder.SohaFoods.Model.Restaurant;
import com.foodOrder.SohaFoods.Model.User;
import com.foodOrder.SohaFoods.Request.createRestaurantRequest;
import com.foodOrder.SohaFoods.dto.RestaurantDto;

public interface RestaurantService {
	
	public Restaurant createRestaurant(createRestaurantRequest req, User user);
	
	public Restaurant updateRestaurant(Long restaurantId, createRestaurantRequest updatedRestaurant) throws Exception;
	
	public void deleteRestaurant(Long restaurantId) throws Exception;
	
	public List<Restaurant> getAllRestaurant();
	
	public List<Restaurant> searchRestaurant(String keyword);
	
	public Restaurant findRestaurantById(Long id) throws Exception;
	
	public Restaurant getRestaurantByUserId(Long userId) throws Exception;

	public RestaurantDto addToFavourites(Long restaurantId, User user) throws Exception;
	
	public Restaurant updateRestaurantStatus(Long id) throws Exception;

	
}
