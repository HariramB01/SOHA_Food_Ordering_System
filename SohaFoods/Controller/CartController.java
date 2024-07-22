package com.foodOrder.SohaFoods.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodOrder.SohaFoods.Model.Cart;
import com.foodOrder.SohaFoods.Model.CartItem;
import com.foodOrder.SohaFoods.Model.User;
import com.foodOrder.SohaFoods.Request.AddCartItemRequest;
import com.foodOrder.SohaFoods.Request.UpdateCartItemRequest;
import com.foodOrder.SohaFoods.Service.CartService;
import com.foodOrder.SohaFoods.Service.UserService;



@CrossOrigin
@RestController
@RequestMapping("/api")
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/cart/add")
	public ResponseEntity<CartItem> addItemToCart(@RequestBody AddCartItemRequest req,
			@RequestHeader("Authorization") String jwt) throws Exception{
		CartItem cartItem = cartService.addItemToCart(req, jwt);
		return new ResponseEntity<CartItem>(cartItem,HttpStatus.OK);
	}
	
	@PutMapping("/cart-item/update")
	public ResponseEntity<CartItem> updateItemQuantity(@RequestBody UpdateCartItemRequest req,
			@RequestHeader("Authorization") String jwt) throws Exception{
		CartItem cartItem = cartService.updateCartItemQuantity(req.getCartItemId(), req.getQuantity());
		return new ResponseEntity<CartItem>(cartItem,HttpStatus.OK);
	}
	
	
	@DeleteMapping("/cart-item/{id}/remove")
	public ResponseEntity<Cart> removeCartItem(@PathVariable Long id,
			@RequestHeader("Authorization") String jwt) throws Exception{
		Cart cart = cartService.removeItemFromCart(id,jwt);
		return new ResponseEntity<Cart>(cart,HttpStatus.OK);
	}
	
	
	@PutMapping("/cart/clear")
	public ResponseEntity<Cart> clearCart(
			@RequestHeader("Authorization") String jwt) throws Exception{
		User user = userService.findUserByJwtToken(jwt);
		Cart cartItem = cartService.clearCart(user.getId());
		return new ResponseEntity<>(cartItem,HttpStatus.OK);
	}
	
	@GetMapping("/cart")
	public ResponseEntity<Cart> findUserCart(
			@RequestHeader("Authorization") String jwt) throws Exception{
		User user = userService.findUserByJwtToken(jwt);
		Cart cart = cartService.findCartByUserId(user.getId());
		return new ResponseEntity<>(cart,HttpStatus.OK);
	}
	
}
