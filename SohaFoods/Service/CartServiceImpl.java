package com.foodOrder.SohaFoods.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodOrder.SohaFoods.Model.Cart;
import com.foodOrder.SohaFoods.Model.CartItem;
import com.foodOrder.SohaFoods.Model.Food;
import com.foodOrder.SohaFoods.Model.User;
import com.foodOrder.SohaFoods.Repository.CartItemRepository;
import com.foodOrder.SohaFoods.Repository.CartRepository;
import com.foodOrder.SohaFoods.Repository.FoodRepository;
import com.foodOrder.SohaFoods.Request.AddCartItemRequest;


@Service
public class CartServiceImpl implements CartService {
	

	@Autowired
	private CartRepository cartRepo;

	@Autowired
	private CartItemRepository cartItemRepo;

	@Autowired
	private FoodRepository foodRepo;

	@Autowired
	private UserService userService;

	@Autowired
	private FoodService foodService;

	@Override
	public CartItem addItemToCart(AddCartItemRequest req, String jwt) throws Exception {
		User user = userService.findUserByJwtToken(jwt);
		
		Food food = foodService.findFoodById(req.getFoodId());
		
		Cart cart = cartRepo.findByCustomerId(user.getId());
		
		for(CartItem cartItem : cart.getItem()) {
			if(cartItem.getFood().equals(food)) {
				int newQuantity = cartItem.getQuantity() + req.getQuantity();
				return updateCartItemQuantity(cartItem.getId(),newQuantity);
			}
		}
		
		CartItem newCartItem = new CartItem();
		newCartItem.setFood(food);
		newCartItem.setCart(cart);
		newCartItem.setQuantity(req.getQuantity());
		newCartItem.setIngredients(req.getIngredients());
		newCartItem.setTotalPrice(req.getQuantity()*food.getPrice());
		
		CartItem savedCartItem = cartItemRepo.save(newCartItem);
		
		cart.getItem().add(savedCartItem);
		return savedCartItem;
	}

	@Override
	public CartItem updateCartItemQuantity(Long cartItemId, int quantity) throws Exception {
		
		Optional<CartItem> cartItemOptional = cartItemRepo.findById(cartItemId);
		if(cartItemOptional.isEmpty()) {
			throw new Exception("Cart item not found");
		}
		CartItem item = cartItemOptional.get();
		item.setQuantity(quantity);
		
		
		item.setTotalPrice(item.getFood().getPrice()* quantity);
		return cartItemRepo.save(item);
	}

	@Override
	public Cart removeItemFromCart(Long cartItemId, String jwt) throws Exception {
		
		
		User user = userService.findUserByJwtToken(jwt);
		
		Cart cart = cartRepo.findByCustomerId(user.getId());
		
		Optional<CartItem> cartItemOptional = cartItemRepo.findById(cartItemId);
		if(cartItemOptional.isEmpty()) {
			throw new Exception("Cart item not found");
		}
		CartItem item = cartItemOptional.get();
		cart.getItem().remove(item);
		return cart;
	}

	@Override
	public Long calculateCartTotals(Cart cart) throws Exception {
		
		Long total = 0L;
		for(CartItem cartItem : cart.getItem()) {
			total+=cartItem.getFood().getPrice()*cartItem.getQuantity();
		}
		return total;
	}

	@Override
	public Cart findCartById(Long id) throws Exception {
		Optional<Cart> cartOptional = cartRepo.findById(id);
		if(cartOptional.isEmpty()) {
			throw new Exception("Cart not found with id "+id);
		}
		return cartOptional.get();
	}

	@Override
	public Cart findCartByUserId(Long userId) throws Exception {
//		User user = userService.findUserByJwtToken(jwt);
		Cart cart = cartRepo.findByCustomerId(userId);
		cart.setTotal(calculateCartTotals(cart));
		return cart;
	}

	@Override
	public Cart clearCart(Long userId) throws Exception {
//		User user = userService.findUserByJwtToken(jwt);
		Cart cart = findCartByUserId(userId);
		cart.getItem().clear();
		return cartRepo.save(cart);
	}

}
