package com.foodOrder.SohaFoods.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodOrder.SohaFoods.Model.Cart;


@Repository
public interface CartRepository extends JpaRepository<Cart, Long>{
	
	public Cart findByCustomerId(Long userId);

}
