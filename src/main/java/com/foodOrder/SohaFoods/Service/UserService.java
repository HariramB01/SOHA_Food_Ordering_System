package com.foodOrder.SohaFoods.Service;

import com.foodOrder.SohaFoods.Model.User;

public interface UserService {
	
	
	public User findUserByJwtToken(String jwt) throws Exception;
	
	public User findUserByEmail(String email) throws Exception;
	
}
