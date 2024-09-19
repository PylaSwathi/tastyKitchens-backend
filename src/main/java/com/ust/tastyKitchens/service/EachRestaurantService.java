package com.ust.tastyKitchens.service;

import com.ust.tastyKitchens.dto.EachRestaurantCreateDTO;
import com.ust.tastyKitchens.dto.EachRestaurantDTO;
import com.ust.tastyKitchens.dto.FoodItemDTO;
import com.ust.tastyKitchens.model.EachRestaurant;
import com.ust.tastyKitchens.model.FoodItem;
import com.ust.tastyKitchens.repo.EachRestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EachRestaurantService {

    @Autowired
    private EachRestaurantRepository eachRestaurantRepository;

    // Get all restaurants without food items
    public List<EachRestaurantDTO> getAllRestaurants() {
        return eachRestaurantRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    // Get a specific restaurant with its associated food items
    public EachRestaurantDTO getEachRestaurantWithFoodItems(Long id) {
        EachRestaurant eachRestaurant = eachRestaurantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));

        return convertToDto(eachRestaurant);
    }

    // Save a list of restaurants
    public List<EachRestaurantCreateDTO> saveRestaurants(List<EachRestaurantCreateDTO> eachRestaurantCreateDTOs) {
        List<EachRestaurant> eachRestaurants = eachRestaurantCreateDTOs.stream()
                .map(this::convertToEntity)
                .collect(Collectors.toList());

        List<EachRestaurant> savedRestaurants = eachRestaurantRepository.saveAll(eachRestaurants);

        return savedRestaurants.stream()
                .map(this::convertToCreateDto)  // Converts to EachRestaurantCreateDTO
                .collect(Collectors.toList());
    }

    // Converts EachRestaurantCreateDTO to EachRestaurant entity
    private EachRestaurant convertToEntity(EachRestaurantCreateDTO eachRestaurantCreateDTO) {

        EachRestaurant eachRestaurant = new EachRestaurant();
        eachRestaurant.setId(eachRestaurantCreateDTO.getId());
        eachRestaurant.setName(eachRestaurantCreateDTO.getName());
        eachRestaurant.setLocation(eachRestaurantCreateDTO.getLocation());
        eachRestaurant.setImageUrl(eachRestaurantCreateDTO.getImageUrl());
        eachRestaurant.setCostForTwo(eachRestaurantCreateDTO.getCostForTwo());
        eachRestaurant.setCuisine(eachRestaurantCreateDTO.getCuisine());
        eachRestaurant.setOpensAt(eachRestaurantCreateDTO.getOpensAt());
        eachRestaurant.setRating(eachRestaurantCreateDTO.getRating());
        eachRestaurant.setReviewsCount(eachRestaurantCreateDTO.getReviewsCount());
        eachRestaurant.setItemsCount(eachRestaurantCreateDTO.getItemsCount());
        return eachRestaurant;
    }

    // Converts EachRestaurant entity to EachRestaurantCreateDTO
    private EachRestaurantCreateDTO convertToCreateDto(EachRestaurant eachRestaurant) {
        EachRestaurantCreateDTO eachRestaurantCreateDTO = new EachRestaurantCreateDTO();
        eachRestaurantCreateDTO.setId(eachRestaurant.getId());
        eachRestaurantCreateDTO.setName(eachRestaurant.getName());
        eachRestaurantCreateDTO.setLocation(eachRestaurant.getLocation());
        eachRestaurantCreateDTO.setImageUrl(eachRestaurant.getImageUrl());
        eachRestaurantCreateDTO.setCostForTwo(eachRestaurant.getCostForTwo());
        eachRestaurantCreateDTO.setCuisine(eachRestaurant.getCuisine());
        eachRestaurantCreateDTO.setOpensAt(eachRestaurant.getOpensAt());
        eachRestaurantCreateDTO.setRating(eachRestaurant.getRating());
        eachRestaurantCreateDTO.setReviewsCount(eachRestaurant.getReviewsCount());
        eachRestaurantCreateDTO.setItemsCount(eachRestaurant.getItemsCount());
        return eachRestaurantCreateDTO;
    }

    // Converts EachRestaurant entity to EachRestaurantDTO
    private EachRestaurantDTO convertToDto(EachRestaurant eachRestaurant) {
        EachRestaurantDTO eachRestaurantDTO = new EachRestaurantDTO();
        eachRestaurantDTO.setId(eachRestaurant.getId());
        eachRestaurantDTO.setName(eachRestaurant.getName());
        eachRestaurantDTO.setLocation(eachRestaurant.getLocation());
        eachRestaurantDTO.setImageUrl(eachRestaurant.getImageUrl());
        eachRestaurantDTO.setCostForTwo(eachRestaurant.getCostForTwo());
        eachRestaurantDTO.setCuisine(eachRestaurant.getCuisine());
        eachRestaurantDTO.setOpensAt(eachRestaurant.getOpensAt());
        eachRestaurantDTO.setRating(eachRestaurant.getRating());
        eachRestaurantDTO.setReviewsCount(eachRestaurant.getReviewsCount());
        eachRestaurantDTO.setItemsCount(eachRestaurant.getItemsCount());
        eachRestaurantDTO.setFoodItems(
                eachRestaurant.getFoodItems().stream()
                        .map(this::convertToFoodItemDto)
                        .collect(Collectors.toList())
        );
        return eachRestaurantDTO;
    }

    // Converts FoodItem entity to FoodItemDTO
    private FoodItemDTO convertToFoodItemDto(FoodItem foodItem) {
        FoodItemDTO foodItemDTO = new FoodItemDTO();
        foodItemDTO.setId(foodItem.getId());
        foodItemDTO.setName(foodItem.getName());
        foodItemDTO.setCost(foodItem.getCost());
        foodItemDTO.setFoodType(foodItem.getFoodType());
        foodItemDTO.setImageUrl(foodItem.getImageUrl());
        foodItemDTO.setRating(foodItem.getRating());
        foodItemDTO.setEachRestaurantId(foodItem.getEachRestaurant().getId());
        return foodItemDTO;
    }
}