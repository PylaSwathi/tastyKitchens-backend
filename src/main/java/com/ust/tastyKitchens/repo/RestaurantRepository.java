package com.ust.tastyKitchens.repo;

import com.ust.tastyKitchens.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



public interface RestaurantRepository extends JpaRepository<Restaurant,Long> {
}
