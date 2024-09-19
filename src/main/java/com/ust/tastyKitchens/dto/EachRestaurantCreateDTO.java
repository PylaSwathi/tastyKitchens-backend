package com.ust.tastyKitchens.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EachRestaurantCreateDTO {
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

}
