package com.foodOrder.SohaFoods.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodOrder.SohaFoods.Model.Address;
import com.foodOrder.SohaFoods.Model.Restaurant;
import com.foodOrder.SohaFoods.Model.User;
import com.foodOrder.SohaFoods.Repository.AddressRepository;
import com.foodOrder.SohaFoods.Repository.RestaurantRepository;
import com.foodOrder.SohaFoods.Repository.UserRepository;
import com.foodOrder.SohaFoods.Request.createRestaurantRequest;
import com.foodOrder.SohaFoods.dto.RestaurantDto;

@Service
public class RestaurantServiceImpl implements RestaurantService {
	
	@Autowired
	private RestaurantRepository restaurantRepo;
	
	@Autowired
	private AddressRepository addressRepo;
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public Restaurant createRestaurant(createRestaurantRequest req, User user) {
		Address address = addressRepo.save(req.getAddress());
		Restaurant restaurant = new Restaurant();
		restaurant.setAddress(address);
		restaurant.setContactInfo(req.getContactInfo());
		restaurant.setCuisineType(req.getCuisineType());
		restaurant.setDescription(req.getDescription());
		restaurant.setImages(req.getImages());
		restaurant.setName(req.getName());
		restaurant.setOpeningHours(req.getOpeningHours());
		restaurant.setOwner(user);
		restaurant.setRegistrationDate(LocalDateTime.now());
		
		return restaurantRepo.save(restaurant);
	}

	@Override
	public Restaurant updateRestaurant(Long restaurantId, createRestaurantRequest updatedRestaurant) throws Exception {
		Restaurant restaurant = findRestaurantById(restaurantId);
		if (updatedRestaurant.getCuisineType() != null) {
			restaurant.setCuisineType(updatedRestaurant.getCuisineType());
		}
		if (updatedRestaurant.getDescription() != null) {
			restaurant.setDescription(updatedRestaurant.getDescription());
		}
		if (updatedRestaurant.getName() != null) {
			restaurant.setName(updatedRestaurant.getName());
		}
		return restaurantRepo.save(restaurant);
	}

	@Override
	public void deleteRestaurant(Long restaurantId) throws Exception {
		Restaurant restaurant = findRestaurantById(restaurantId);
		restaurantRepo.delete(restaurant);
	}

	@Override
	public List<Restaurant> getAllRestaurant() {
		return restaurantRepo.findAll();
	}

	@Override
	public List<Restaurant> searchRestaurant(String keyword) {
		return restaurantRepo.findBySearchQuery(keyword);
	}

	@Override
	public Restaurant findRestaurantById(Long id) throws Exception {
		Optional<Restaurant> opt = restaurantRepo.findById(id);
		if (opt.isEmpty()) {
			throw new Exception("Restaurant not found with id " + id);
		}
		return opt.get();
	}

	@Override
	public Restaurant getRestaurantByUserId(Long userId) throws Exception {
		Restaurant restaurant = restaurantRepo.findOwnerById(userId);
		if (restaurant == null) {
			throw new Exception("Restaurant not found with owner id " + userId);
		}
		return restaurant;
	}

	@Override
	public RestaurantDto addToFavourites(Long restaurantId, User user) throws Exception {
		Restaurant restaurant = findRestaurantById(restaurantId);
		RestaurantDto dto = new RestaurantDto();
		dto.setDescription(restaurant.getDescription());
		dto.setImages(restaurant.getImages());
		dto.setTitle(restaurant.getName());
		dto.setId(restaurantId);
		
		boolean isFavourited = false;
		List<RestaurantDto> favourites = user.getFavourites();
		
		for(RestaurantDto favourite : favourites) {
			if(favourite.getId().equals(restaurantId)) {
				isFavourited = true;
				break;
			}
		}
		if(isFavourited) {
			favourites.removeIf(favourite->favourite.getId().equals(restaurantId));
		}
		else {
			favourites.add(dto);
		}
		userRepo.save(user);
		return dto;
	}

	@Override
	public Restaurant updateRestaurantStatus(Long id) throws Exception {
		Restaurant restaurant = findRestaurantById(id);
		restaurant.setOpen(!restaurant.isOpen());
		return restaurantRepo.save(restaurant);
	}
}
