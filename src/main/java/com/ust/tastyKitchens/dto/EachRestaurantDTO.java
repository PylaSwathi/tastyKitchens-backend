package com.ust.tastyKitchens.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EachRestaurantDTO {
    private Long id;
    private String name;
    private String location;
    private String imageUrl;
    private int costForTwo;
    private String cuisine;
    private String opensAt;
    private double rating;
    private int reviewsCount;
    private int itemsCount;
    private List<FoodItemDTO> foodItems; // List of associated FoodItems
}
