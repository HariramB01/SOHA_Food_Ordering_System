package com.foodOrder.SohaFoods.Request;

public class UpdateCartItemRequest {
	
	private Long cartItemId;
	private int quantity;
	public UpdateCartItemRequest(Long cartItemId, int quantity) {
		super();
		this.cartItemId = cartItemId;
		this.quantity = quantity;
	}
	public Long getCartItemId() {
		return cartItemId;
	}
	public void setCartItemId(Long cartItemId) {
		this.cartItemId = cartItemId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	

}
