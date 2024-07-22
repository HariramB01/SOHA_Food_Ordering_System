package com.foodOrder.SohaFoods.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodOrder.SohaFoods.Model.Address;


@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
