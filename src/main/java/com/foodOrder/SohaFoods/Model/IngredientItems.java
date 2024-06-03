package com.foodOrder.SohaFoods.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;


@Entity
public class IngredientItems {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	//many ingredients have same category
	@ManyToOne
	private IngredientCategory category;
	
	//one restaurant have many ingredients
	@JsonIgnore
	@ManyToOne
	private Restaurant restaurant;
	
	private boolean inStock=false;

	public IngredientItems() {
		super();
	}

	public IngredientItems(Long id, String name, IngredientCategory category, Restaurant restaurant, boolean inStock) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.restaurant = restaurant;
		this.inStock = inStock;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public IngredientCategory getCategory() {
		return category;
	}

	public void setCategory(IngredientCategory category) {
		this.category = category;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public boolean isInStock() {
		return inStock;
	}

	public void setInStock(boolean inStock) {
		this.inStock = inStock;
	}

	@Override
	public String toString() {
		return "IngredientItems [id=" + id + ", name=" + name + ", category=" + category + ", restaurant=" + restaurant
				+ ", inStock=" + inStock + "]";
	}
	
	
	

}
