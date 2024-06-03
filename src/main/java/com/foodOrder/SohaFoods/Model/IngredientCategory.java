package com.foodOrder.SohaFoods.Model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;


@Entity
public class IngredientCategory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	@JsonIgnore
	@ManyToOne
	private Restaurant restaurant;
	
	//one category have many ingredients
	
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	private List<IngredientItems> ingredients = new ArrayList<>();

	public IngredientCategory() {
		super();
	}

	public IngredientCategory(Long id, String name, Restaurant restaurant, List<IngredientItems> ingredients) {
		super();
		this.id = id;
		this.name = name;
		this.restaurant = restaurant;
		this.ingredients = ingredients;
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

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public List<IngredientItems> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<IngredientItems> ingredients) {
		this.ingredients = ingredients;
	}

	@Override
	public String toString() {
		return "IngredientCategory [id=" + id + ", name=" + name + ", restaurant=" + restaurant + ", ingredients="
				+ ingredients + "]";
	}
	
	
	
	
}
