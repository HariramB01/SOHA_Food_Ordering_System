package com.foodOrder.SohaFoods.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodOrder.SohaFoods.Exception.NotFoundException;
import com.foodOrder.SohaFoods.Model.User;
import com.foodOrder.SohaFoods.Repository.UserRepository;
import com.foodOrder.SohaFoods.config.JwtProvider;

@Service
public class UserServiceImpl implements UserService{
    
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private JwtProvider jwtProvider;
    
    @Override
    public User findUserByJwtToken(String jwt) throws Exception {
        String email = jwtProvider.getEmailFromJwtToken(jwt);
        User user = findUserByEmail(email);
        if(user == null) {
            throw new NotFoundException("User not found");
        }
        return user;
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepo.findByEmail(email);
    }
}
