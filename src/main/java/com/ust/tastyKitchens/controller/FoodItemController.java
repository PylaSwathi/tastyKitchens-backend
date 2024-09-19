package com.ust.tastyKitchens.controller;

import com.ust.tastyKitchens.dto.FoodItemDTO;
import com.ust.tastyKitchens.model.FoodItem;
import com.ust.tastyKitchens.service.EachRestaurantService;
import com.ust.tastyKitchens.service.FoodItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/food-items")
@CrossOrigin(origins = "http://localhost:3000")
public class FoodItemController {

    @Autowired
    private FoodItemService foodItemService;

    @PostMapping
    public ResponseEntity<List<FoodItemDTO>> createFoodItems(@RequestBody List<FoodItemDTO> foodItemDTOs) {
        List<FoodItem> createdFoodItems = foodItemService.saveFoodItems(foodItemDTOs);
        List<FoodItemDTO> createdFoodItemDTOs = createdFoodItems.stream()
                .map(foodItem -> new FoodItemDTO(
                        foodItem.getId(),
                        foodItem.getName(),
                        foodItem.getCost(),
                        foodItem.getFoodType(),
                        foodItem.getImageUrl(),
                        foodItem.getRating(),
                        foodItem.getEachRestaurant().getId()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(createdFoodItemDTOs);
    }

    @GetMapping("/{restaurantId}")
    public ResponseEntity<List<FoodItemDTO>> getFoodItemsByRestaurantId(@PathVariable Long restaurantId) {
        List<FoodItemDTO> foodItems = foodItemService.getFoodItemsByRestaurantId(restaurantId);
        return ResponseEntity.ok(foodItems);
    }
}
