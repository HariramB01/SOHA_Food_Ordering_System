package com.foodOrder.SohaFoods.Model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;


@Entity
public class Restaurant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	
	//one restaurant have only one owner
	@OneToOne
	private User owner;
	
	private String name;
	
	private String description;
	
	private String cuisineType;
	
	@OneToOne
	private Address address;
	
	
	@Embedded
	private ContactInformation contactInfo;
	
	private String openingHours;
	
	
	//one restaurant have many orders
	@OneToMany(cascade = CascadeType.ALL,orphanRemoval = true, mappedBy = "restaurant")
	private List<Order> order = new ArrayList<>();
	
	
	@ElementCollection
	@Column(length=1000)
	private List<String> images;
	
	private LocalDateTime registrationDate;
	
	private boolean open;
	
	
	//whenever i fetch the restaurant data object, I don't need the food list. 
	@JsonIgnore
	@OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Food> food = new ArrayList<>();


	public Restaurant() {
		super();
	}


	public Restaurant(Long id, User owner, String name, String description, String cuisineType, Address address,
			ContactInformation contactInfo, String openingHours, List<Order> order, List<String> images,
			LocalDateTime registrationDate, boolean open, List<Food> food) {
		super();
		this.id = id;
		this.owner = owner;
		this.name = name;
		this.description = description;
		this.cuisineType = cuisineType;
		this.address = address;
		this.contactInfo = contactInfo;
		this.openingHours = openingHours;
		this.order = order;
		this.images = images;
		this.registrationDate = registrationDate;
		this.open = open;
		this.food = food;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public User getOwner() {
		return owner;
	}


	public void setOwner(User owner) {
		this.owner = owner;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getCuisineType() {
		return cuisineType;
	}


	public void setCuisineType(String cuisineType) {
		this.cuisineType = cuisineType;
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	public ContactInformation getContactInfo() {
		return contactInfo;
	}


	public void setContactInfo(ContactInformation contactInfo) {
		this.contactInfo = contactInfo;
	}


	public String getOpeningHours() {
		return openingHours;
	}


	public void setOpeningHours(String openingHours) {
		this.openingHours = openingHours;
	}


	public List<Order> getOrder() {
		return order;
	}


	public void setOrder(List<Order> order) {
		this.order = order;
	}


	public List<String> getImages() {
		return images;
	}


	public void setImages(List<String> images) {
		this.images = images;
	}


	public LocalDateTime getRegistrationDate() {
		return registrationDate;
	}


	public void setRegistrationDate(LocalDateTime registrationDate) {
		this.registrationDate = registrationDate;
	}


	public boolean isOpen() {
		return open;
	}


	public void setOpen(boolean open) {
		this.open = open;
	}


	public List<Food> getFood() {
		return food;
	}


	public void setFood(List<Food> food) {
		this.food = food;
	}


	@Override
	public String toString() {
		return "Restaurant [id=" + id + ", owner=" + owner + ", name=" + name + ", description=" + description
				+ ", cuisineType=" + cuisineType + ", address=" + address + ", contactInfo=" + contactInfo
				+ ", openingHours=" + openingHours + ", order=" + order + ", images=" + images + ", registrationDate="
				+ registrationDate + ", open=" + open + ", food=" + food + "]";
	}
	
	
	
	

}
