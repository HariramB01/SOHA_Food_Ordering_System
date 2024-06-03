package com.foodOrder.SohaFoods.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodOrder.SohaFoods.Model.CartItem;


@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {

}
