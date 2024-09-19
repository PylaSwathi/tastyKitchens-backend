package com.ust.tastyKitchens.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodItemDTO {
    private Long id;
    private String name;
    private int cost;
    private String foodType;
    private String imageUrl;
    private double rating;
    private Long eachRestaurantId; // Only the ID is needed
}
