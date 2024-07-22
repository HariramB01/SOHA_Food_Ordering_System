package com.foodOrder.SohaFoods.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodOrder.SohaFoods.Model.Category;
import com.foodOrder.SohaFoods.Model.User;
import com.foodOrder.SohaFoods.Service.CategoryService;
import com.foodOrder.SohaFoods.Service.UserService;




@CrossOrigin
@RestController
@RequestMapping("/api/admin/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping
	public ResponseEntity<Category> createCategory(@RequestBody Category category,
			@RequestHeader("Authorization") String jwt) throws Exception{
		User user = userService.findUserByJwtToken(jwt);
		Category createdCategory = categoryService.createCategory(category.getName(), user.getId());
		return new ResponseEntity<>(createdCategory,HttpStatus.CREATED);
	}
	
	@PostMapping("/category/restaurant")
	public ResponseEntity<List<Category>> getRestaurantByCategory(
			@RequestHeader("Authorization") String jwt) throws Exception{
		User user = userService.findUserByJwtToken(jwt);
		List<Category> categories = categoryService.findCategoryByRestaurantId(user.getId());
		return new ResponseEntity<>(categories,HttpStatus.CREATED);
	}

}
