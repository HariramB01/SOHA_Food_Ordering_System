package com.foodOrder.SohaFoods.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodOrder.SohaFoods.Model.OrderItem;


@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
