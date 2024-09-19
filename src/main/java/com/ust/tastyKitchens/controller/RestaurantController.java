package com.ust.tastyKitchens.controller;


import com.ust.tastyKitchens.model.Restaurant;
import com.ust.tastyKitchens.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/restaurants")
@CrossOrigin(origins = "http://localhost:3000")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    // Create a new Restaurant
    @PostMapping("/create")
    public ResponseEntity<Restaurant> createRestaurant(@RequestBody Restaurant restaurant) {
        Restaurant savedRestaurant = restaurantService.saveRestaurant(restaurant);
        return ResponseEntity.ok(savedRestaurant);
    }



    // Create or Update a list of Restaurants
    @PostMapping("/bulk")
    public ResponseEntity<List<Restaurant>> createOrUpdateRestaurants(@RequestBody List<Restaurant> restaurants) {
        List<Restaurant> savedRestaurants = restaurantService.saveRestaurants(restaurants);
        return ResponseEntity.ok(savedRestaurants);
    }

    // Read a Restaurant by ID
    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> getRestaurantById(@PathVariable Long id) {
        Optional<Restaurant> restaurant = restaurantService.getRestaurantById(id);
        return restaurant.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Read All Restaurants
    @GetMapping
    public ResponseEntity<List<Restaurant>> getAllRestaurants() {
        List<Restaurant> restaurants = restaurantService.getAllRestaurants();
        return ResponseEntity.ok(restaurants);
    }

    @GetMapping("/restaurants-list")
    public ResponseEntity<List<Restaurant>> getRestaurants(
            @RequestParam int offset,
            @RequestParam int limit,
            @RequestParam String sortByRating

    ) {
        List<Restaurant> restaurants = restaurantService.getRestaurants(offset, limit, sortByRating);
        return ResponseEntity.ok(restaurants);
    }



}