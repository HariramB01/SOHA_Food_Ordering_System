package com.foodOrder.SohaFoods.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodOrder.SohaFoods.Model.Category;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
	
	public List<Category> findRestaurantById(Long id);

}
