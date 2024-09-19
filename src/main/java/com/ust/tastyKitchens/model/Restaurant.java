package com.ust.tastyKitchens.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="restaurant")
public class Restaurant {
    @Id
    private Long id;
    private String name;
    private String imageUrl;
    private String menuType;
    private double rating;
    private int totalReviews;

}
