package com.foodOrder.SohaFoods.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodOrder.SohaFoods.Model.Address;
import com.foodOrder.SohaFoods.Model.Cart;
import com.foodOrder.SohaFoods.Model.CartItem;
import com.foodOrder.SohaFoods.Model.Order;
import com.foodOrder.SohaFoods.Model.OrderItem;
import com.foodOrder.SohaFoods.Model.Restaurant;
import com.foodOrder.SohaFoods.Model.User;
import com.foodOrder.SohaFoods.Repository.AddressRepository;
import com.foodOrder.SohaFoods.Repository.OrderItemRepository;
import com.foodOrder.SohaFoods.Repository.OrderRepository;
import com.foodOrder.SohaFoods.Repository.UserRepository;
import com.foodOrder.SohaFoods.Request.OrderRequest;


@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepository orderRepo;
	
	@Autowired
	private OrderItemRepository orderItemRepo;
	
	@Autowired
	private AddressRepository addressRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private RestaurantService restaurantService;
	
	@Autowired
	private CartService cartService;

	@Override
	public Order createOrder(OrderRequest order, User user) throws Exception {
		
		Address shipAddress = order.getDeliveryAddress();
		Address saveAddress = addressRepo.save(shipAddress);
		
		if(!user.getAddresses().contains(saveAddress)) {
			user.getAddresses().add(saveAddress);
			userRepo.save(user);
		}
		Restaurant restaurant = restaurantService.findRestaurantById(order.getRestaurantId());
		
		Order createOrder = new Order();
		createOrder.setCustomer(user);
		createOrder.setCreatedAt(new Date());
		createOrder.setOrderStatus("Pending");
		createOrder.setDeliveryAddress(saveAddress);
		createOrder.setRestaurant(restaurant);
		
		Cart cart = cartService.findCartByUserId(user.getId());
		
		List<OrderItem> orderItems = new ArrayList<>();
		for(CartItem cartItem : cart.getItem()) {
			OrderItem orderItem = new OrderItem();
			orderItem.setFood(cartItem.getFood());
			orderItem.setIngredients(cartItem.getIngredients());
			orderItem.setQuantity(cartItem.getQuantity());
			orderItem.setTotalPrice(cartItem.getTotalPrice());
			
			OrderItem savedOrderItem = orderItemRepo.save(orderItem);
			orderItems.add(savedOrderItem);
		}
		
		Long totalPrice = cartService.calculateCartTotals(cart);
		
		createOrder.setItems(orderItems);
		createOrder.setTotalPrice(totalPrice);
		
		Order savedOrder = orderRepo.save(createOrder);
		restaurant.getOrder().add(savedOrder);
		
		
		return createOrder;
	}

	@Override
	public Order updateOrder(Long orderId, String orderStatus) throws Exception {
		Order order = findOrderById(orderId);
		if(orderStatus.equals("OUT_FOR_DELIVERY")
				|| orderStatus.equals("DELIVERED")
				||orderStatus.equals("COMPLETED")
				||orderStatus.equals("PENDING")) {
			order.setOrderStatus(orderStatus);
			return orderRepo.save(order);
		}
		throw new Exception("Please select a valid order status");
	}

	@Override
	public void cancelOrder(Long orderId) throws Exception {
		
		Order order = findOrderById(orderId);
		orderRepo.deleteById(orderId);

	}

	@Override
	public List<Order> getUsersOrder(Long userId) throws Exception {
		return orderRepo.findByCustomerId(userId);
	}

	@Override
	public List<Order> getRestaurantsOrder(Long restaurantId, String orderStatus) throws Exception {
		List<Order> orders = orderRepo.findByRestaurantId(restaurantId);
		if(orderStatus!=null) {
			orders = orders.stream().filter(order -> 
			order.getOrderStatus().equals(orderStatus)).collect(Collectors.toList());
		}
		return null;
	}

	@Override
	public Order findOrderById(Long userId) throws Exception {
		Optional<Order> optionalOrder = orderRepo.findById(userId);
		if(optionalOrder.isEmpty()) {
			throw new Exception("Order not found");
		}
		return optionalOrder.get();
	}

}
