package com.foodOrder.SohaFoods.Service;

import java.util.List;

import com.foodOrder.SohaFoods.Model.Order;
import com.foodOrder.SohaFoods.Model.User;
import com.foodOrder.SohaFoods.Request.OrderRequest;

public interface OrderService {
	
	
	public Order createOrder(OrderRequest order, User user) throws Exception;
	
	public Order updateOrder(Long orderId, String orderStatus) throws Exception;
	
	public void cancelOrder(Long orderId) throws Exception;
	
	public List<Order> getUsersOrder(Long userId) throws Exception;
	
	public List<Order> getRestaurantsOrder(Long restaurantId, String orderStatus) throws Exception;
	
	public Order findOrderById(Long userId) throws Exception;

}
