package com.foodOrder.SohaFoods.Model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class CartItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	//whenever I fetch the cartItem i don't need the cart
	//many cartItems can have one cart
	@JsonIgnore
	@ManyToOne
	private Cart cart;
	
	//many cart Items can have one same food
	@ManyToOne
	private Food food;
	
	private int quantity;
	
	private List<String> ingredients;
	
	private long totalPrice;

	public CartItem() {
		super();
	}

	public CartItem(Long id, Cart cart, Food food, int quantity, List<String> ingredients, long totalPrice) {
		super();
		this.id = id;
		this.cart = cart;
		this.food = food;
		this.quantity = quantity;
		this.ingredients = ingredients;
		this.totalPrice = totalPrice;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public List<String> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<String> ingredients) {
		this.ingredients = ingredients;
	}

	public long getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(long totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "CartItem [id=" + id + ", cart=" + cart + ", food=" + food + ", quantity=" + quantity + ", ingredients="
				+ ingredients + ", totalPrice=" + totalPrice + "]";
	}
	
	
	

}
