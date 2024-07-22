package com.foodOrder.SohaFoods.Model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne()
	private User customer;
	
	
	@JsonIgnore
	@ManyToOne
	private Restaurant restaurant;
	
	private Long totalAmount;
	
	private String orderStatus;
	
	private Date createdAt;
	
	@ManyToOne
	private Address deliveryAddress;
	
	@OneToMany
	private List<OrderItem> items;

//	private Payment payment;
	
	private int totalItems;
	
	private Long totalPrice;

	public Order() {
		super();
	}

	public Order(Long id, User customer, Restaurant restaurant, Long totalAmount, String orderStatus, Date createdAt,
			Address deliveryAddress, List<OrderItem> items, int totalItems, Long totalPrice) {
		super();
		this.id = id;
		this.customer = customer;
		this.restaurant = restaurant;
		this.totalAmount = totalAmount;
		this.orderStatus = orderStatus;
		this.createdAt = createdAt;
		this.deliveryAddress = deliveryAddress;
		this.items = items;
		this.totalItems = totalItems;
		this.totalPrice = totalPrice;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getCustomer() {
		return customer;
	}

	public void setCustomer(User customer) {
		this.customer = customer;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public Long getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Long totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Address getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(Address deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public void setItems(List<OrderItem> items) {
		this.items = items;
	}

	public int getTotalItems() {
		return totalItems;
	}

	public void setTotalItems(int totalItems) {
		this.totalItems = totalItems;
	}

	public Long getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Long totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", customer=" + customer + ", restaurant=" + restaurant + ", totalAmount="
				+ totalAmount + ", orderStatus=" + orderStatus + ", createdAt=" + createdAt + ", deliveryAddress="
				+ deliveryAddress + ", items=" + items + ", totalItems=" + totalItems + ", totalPrice=" + totalPrice
				+ "]";
	}
	
	
	
}
