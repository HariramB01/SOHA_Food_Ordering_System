package com.foodOrder.SohaFoods.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodOrder.SohaFoods.Model.Food;
import com.foodOrder.SohaFoods.Model.Restaurant;
import com.foodOrder.SohaFoods.Model.User;
import com.foodOrder.SohaFoods.Request.CreateFoodRequest;
import com.foodOrder.SohaFoods.Response.MessageResponse;
import com.foodOrder.SohaFoods.Service.FoodService;
import com.foodOrder.SohaFoods.Service.RestaurantService;
import com.foodOrder.SohaFoods.Service.UserService;




@CrossOrigin
@RestController
@RequestMapping("/api/admin/food")
public class AdminFoodController {
	
	@Autowired
	private FoodService foodService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RestaurantService restaurantService;
	
	
	@PostMapping
	public ResponseEntity<Food> createFood(@RequestBody CreateFoodRequest req, @RequestHeader("Authorization") String jwt)throws Exception{
		User user = userService.findUserByJwtToken(jwt);
		Restaurant restaurant = restaurantService.findRestaurantById(req.getRestaurantId());
		Food food = foodService.createFood(req,req.getCategory(),restaurant);
		return new ResponseEntity<Food>(food,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<MessageResponse> deleteFood(@PathVariable Long id, @RequestHeader("Authorization") String jwt)throws Exception{
		User user = userService.findUserByJwtToken(jwt);
		foodService.deleteFood(id);
		MessageResponse response = new MessageResponse();
		response.setMessage("food deleted Successfully");
		return new ResponseEntity<MessageResponse>(response,HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Food> updateFoodAvailabilityStatus(@PathVariable Long id, @RequestHeader("Authorization") String jwt)throws Exception{
		User user = userService.findUserByJwtToken(jwt);
		Food food = foodService.updateAvailabilityStatus(id);
		return new ResponseEntity<Food>(food,HttpStatus.CREATED);
	}

}
