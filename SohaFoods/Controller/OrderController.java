package com.foodOrder.SohaFoods.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodOrder.SohaFoods.Model.Order;
import com.foodOrder.SohaFoods.Model.User;
import com.foodOrder.SohaFoods.Request.OrderRequest;
import com.foodOrder.SohaFoods.Service.OrderService;
import com.foodOrder.SohaFoods.Service.UserService;



@CrossOrigin
@RestController
@RequestMapping("/api")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/order")
	public ResponseEntity<Order> createOrder(@RequestBody OrderRequest req, 
			@RequestHeader("Authorization") String jwt) throws Exception{
		User user = userService.findUserByJwtToken(jwt);
		Order order = orderService.createOrder(req,user);
		return new ResponseEntity<Order>(order,HttpStatus.CREATED);
	}
	
	@GetMapping("/order/user")
	public ResponseEntity<List<Order>> getOrderHistory(
			@RequestHeader("Authorization") String jwt) throws Exception{
		User user = userService.findUserByJwtToken(jwt);
		List<Order> orders = orderService.getUsersOrder(user.getId());
		return new ResponseEntity<>(orders,HttpStatus.OK);
	}

}
