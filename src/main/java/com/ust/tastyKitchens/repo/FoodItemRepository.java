package com.ust.tastyKitchens.repo;

import com.ust.tastyKitchens.model.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodItemRepository extends JpaRepository<FoodItem,Long> {
    List<FoodItem> findByEachRestaurantId(Long eachRestaurantId);
}
