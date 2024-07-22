package com.foodOrder.SohaFoods.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodOrder.SohaFoods.Model.IngredientCategory;
import com.foodOrder.SohaFoods.Model.IngredientItems;
import com.foodOrder.SohaFoods.Request.IngredientCategoryRequest;
import com.foodOrder.SohaFoods.Request.IngredientRequest;
import com.foodOrder.SohaFoods.Service.IngredientsService;



@CrossOrigin
@RestController
@RequestMapping("/api/admin/ingredients")
public class IngredientController {

	@Autowired
	private IngredientsService ingredientService;

	@PostMapping("/category")
	public ResponseEntity<IngredientCategory> createIngredientCategory(@RequestBody IngredientCategoryRequest req)
			throws Exception {
		IngredientCategory item = ingredientService.createIngredientCategory(req.getName(), req.getRestaurantId());
		return new ResponseEntity<IngredientCategory>(item, HttpStatus.CREATED);
	}

	@PostMapping()
	public ResponseEntity<IngredientItems> createIngredientItem(@RequestBody IngredientRequest req) throws Exception {
		IngredientItems item = ingredientService.createIngredientItem(req.getRestaurantId(), req.getName(),
				req.getCategoryId());
		return new ResponseEntity<IngredientItems>(item, HttpStatus.OK);
	}

	@PutMapping("/{id}/stoke")
	public ResponseEntity<IngredientItems> upgradeIngredientStock(@PathVariable Long id) throws Exception {
		IngredientItems items = ingredientService.updateStock(id);
		return new ResponseEntity<IngredientItems>(items, HttpStatus.OK);
	}

	@GetMapping("/restaurant/{id}")
	public ResponseEntity<List<IngredientItems>> getRestaurantIngredient(@PathVariable Long id) throws Exception {
		List<IngredientItems> items = ingredientService.findRestaurantsIngredients(id);
		return new ResponseEntity<>(items, HttpStatus.OK);
	}

	@GetMapping("/restaurant/{id}/category")
	public ResponseEntity<List<IngredientCategory>> getRestaurantIngredientCategory(@PathVariable Long id)
			throws Exception {
		List<IngredientCategory> items = ingredientService.findIngredientCategoryByRestaurantId(id);
		return new ResponseEntity<>(items, HttpStatus.OK);
	}

}
