package com.ust.tastyKitchens.service;

import com.ust.tastyKitchens.model.Restaurant;
import com.ust.tastyKitchens.repo.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    // Create or Update a Restaurant
    public Restaurant saveRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    // Create or Update multiple Restaurants
    public List<Restaurant> saveRestaurants(List<Restaurant> restaurants) {
        return restaurantRepository.saveAll(restaurants);
    }

    // Read a Restaurant by ID
    public Optional<Restaurant> getRestaurantById(Long id) {
        return restaurantRepository.findById(id);
    }

    // Read All Restaurants
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    public List<Restaurant> getRestaurants(int offset, int limit, String sortOrder) {
        Sort sort = sortOrder.equalsIgnoreCase("Lowest") ? Sort.by("rating").ascending() : Sort.by("rating").descending();
        Pageable pageable = PageRequest.of(offset / limit, limit, sort);

        return restaurantRepository.findAll(pageable).getContent();
    }


}