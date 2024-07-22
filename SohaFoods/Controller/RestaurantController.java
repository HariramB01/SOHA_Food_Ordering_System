package com.foodOrder.SohaFoods.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.foodOrder.SohaFoods.Model.Restaurant;
import com.foodOrder.SohaFoods.Model.User;
import com.foodOrder.SohaFoods.Service.RestaurantService;
import com.foodOrder.SohaFoods.Service.UserService;
import com.foodOrder.SohaFoods.dto.RestaurantDto;



@CrossOrigin
@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {
	
	@Autowired
	private RestaurantService restaurantService;
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/search")
	public ResponseEntity<List<Restaurant>> searchRestaurant(
			@RequestHeader("Authorization") String jwt, @RequestParam String keyword) throws Exception{
		User user = userService.findUserByJwtToken(jwt);
		List<Restaurant> restaurant = restaurantService.searchRestaurant(keyword);
		
		return new ResponseEntity<List<Restaurant>>(restaurant,HttpStatus.OK);
	}
	
	@GetMapping()
	public ResponseEntity<List<Restaurant>> getAllRestaurant(
			@RequestHeader("Authorization") String jwt) throws Exception{
		User user = userService.findUserByJwtToken(jwt);
		List<Restaurant> restaurant = restaurantService.getAllRestaurant();
		
		return new ResponseEntity<List<Restaurant>>(restaurant,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Restaurant> findRestaurantById(
			@RequestHeader("Authorization") String jwt, @PathVariable Long id) throws Exception{
		User user = userService.findUserByJwtToken(jwt);
		Restaurant restaurant = restaurantService.findRestaurantById(id);
		
		return new ResponseEntity<Restaurant>(restaurant,HttpStatus.OK);
	}
	
	@PutMapping("/{id}/add-favourites")
	public ResponseEntity<RestaurantDto> addFavourites(
			@RequestHeader("Authorization") String jwt, @PathVariable Long id) throws Exception{
		User user = userService.findUserByJwtToken(jwt);
		RestaurantDto restaurant = restaurantService.addToFavourites(id,user);
		
		return new ResponseEntity<RestaurantDto>(restaurant,HttpStatus.OK);
	}

}
