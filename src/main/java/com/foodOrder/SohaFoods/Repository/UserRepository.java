package com.foodOrder.SohaFoods.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodOrder.SohaFoods.Model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String username);

}
