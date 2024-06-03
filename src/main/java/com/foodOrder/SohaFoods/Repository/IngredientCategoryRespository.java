package com.foodOrder.SohaFoods.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodOrder.SohaFoods.Model.IngredientCategory;


@Repository
public interface IngredientCategoryRespository extends JpaRepository<IngredientCategory, Long> {
	
	List<IngredientCategory> findByRestaurantId(Long id);

}
