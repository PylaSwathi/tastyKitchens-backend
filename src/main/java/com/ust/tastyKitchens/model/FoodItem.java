package com.ust.tastyKitchens.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "food_item")
public class FoodItem {

    @Id
    private Long id;

    private String name;
    private int cost;
    private String foodType;
    private String imageUrl;
    private double rating;

    @ManyToOne
    @JoinColumn(name = "each_restaurant_id")
    @JsonBackReference
    private EachRestaurant eachRestaurant;
}