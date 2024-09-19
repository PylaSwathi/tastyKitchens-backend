package com.ust.tastyKitchens.service;

import com.ust.tastyKitchens.dto.FoodItemDTO;
import com.ust.tastyKitchens.model.EachRestaurant;
import com.ust.tastyKitchens.model.FoodItem;
import com.ust.tastyKitchens.repo.EachRestaurantRepository;
import com.ust.tastyKitchens.repo.FoodItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FoodItemService {

    @Autowired
    private FoodItemRepository foodItemRepository;

    @Autowired
    private EachRestaurantRepository eachRestaurantRepository;

    public List<FoodItem> saveFoodItems(List<FoodItemDTO> foodItemDTOs) {
        List<FoodItem> foodItems = foodItemDTOs.stream()
                .map(this::convertToEntity)
                .collect(Collectors.toList());

        // Save the list of food items to the repository
        return foodItemRepository.saveAll(foodItems);
    }

    public List<FoodItemDTO> getFoodItemsByRestaurantId(Long restaurantId) {
        return foodItemRepository.findByEachRestaurantId(restaurantId).stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private FoodItem convertToEntity(FoodItemDTO dto) {
        EachRestaurant restaurant = eachRestaurantRepository.findById(dto.getEachRestaurantId())
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));

        return new FoodItem(
                dto.getId(),
                dto.getName(),
                dto.getCost(),
                dto.getFoodType(),
                dto.getImageUrl(),
                dto.getRating(),
                restaurant
        );
    }

    private FoodItemDTO convertToDto(FoodItem foodItem) {
        return new FoodItemDTO(
                foodItem.getId(),
                foodItem.getName(),
                foodItem.getCost(),
                foodItem.getFoodType(),
                foodItem.getImageUrl(),
                foodItem.getRating(),
                foodItem.getEachRestaurant().getId()
        );
    }
}

