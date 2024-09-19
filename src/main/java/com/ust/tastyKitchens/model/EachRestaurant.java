package com.ust.tastyKitchens.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="each_restaurant")
public class EachRestaurant {
    @Id
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

    @OneToMany(mappedBy = "eachRestaurant", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<FoodItem> foodItems;
}
