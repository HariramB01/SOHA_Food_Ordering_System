package com.foodOrder.SohaFoods.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodOrder.SohaFoods.Model.IngredientItems;


@Repository
public interface IngredientItemRepository extends JpaRepository<IngredientItems, Long>{
	
	List<IngredientItems> findByRestaurantId(Long id);
	
}
