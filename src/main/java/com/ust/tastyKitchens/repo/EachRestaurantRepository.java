package com.ust.tastyKitchens.repo;

import com.ust.tastyKitchens.model.EachRestaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EachRestaurantRepository extends JpaRepository<EachRestaurant,Long> {
}
