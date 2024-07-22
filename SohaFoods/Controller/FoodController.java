package com.foodOrder.SohaFoods.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.foodOrder.SohaFoods.Model.Food;
import com.foodOrder.SohaFoods.Model.Restaurant;
import com.foodOrder.SohaFoods.Model.User;
import com.foodOrder.SohaFoods.Request.CreateFoodRequest;
import com.foodOrder.SohaFoods.Service.FoodService;
import com.foodOrder.SohaFoods.Service.RestaurantService;
import com.foodOrder.SohaFoods.Service.UserService;



@CrossOrigin
@RestController
@RequestMapping("/api/food")
public class FoodController {

	@Autowired
	private FoodService foodService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RestaurantService restaurantService;
	
	
	@GetMapping("/search")
	public ResponseEntity<List<Food>> searchFood(@RequestParam String keyword, @RequestHeader("Authorization") String jwt)throws Exception{
		User user = userService.findUserByJwtToken(jwt);
		List<Food> foods = foodService.searchFood(keyword);
		return new ResponseEntity<>(foods,HttpStatus.OK);
	}
	
	
	@GetMapping("/restaurant/{restaurantId}")
	public ResponseEntity<List<Food>> getRestaurantFood(
			@RequestParam boolean vegetarian, 
			@RequestParam boolean isNonVeg, 
			@RequestParam boolean seasonal,
			@RequestParam(required=false) String food_Category,
			@PathVariable Long restaurantId,
			@RequestHeader("Authorization") String jwt)throws Exception{
		User user = userService.findUserByJwtToken(jwt);
		List<Food> foods = foodService.getRestaurantsFood(restaurantId, vegetarian, isNonVeg, seasonal, food_Category);
		return new ResponseEntity<>(foods,HttpStatus.OK);
	}
	
}
