package com.ust.tastyKitchens.controller;

import com.ust.tastyKitchens.dto.EachRestaurantCreateDTO;
import com.ust.tastyKitchens.dto.EachRestaurantDTO;
import com.ust.tastyKitchens.model.EachRestaurant;
import com.ust.tastyKitchens.service.EachRestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/each-restaurants")
@CrossOrigin(origins = "http://localhost:3000")
public class EachRestaurantController {

    @Autowired
    private EachRestaurantService eachRestaurantService;

    @GetMapping
    public List<EachRestaurantDTO> getAllRestaurants() {
        return eachRestaurantService.getAllRestaurants();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EachRestaurantDTO> getRestaurantById(@PathVariable Long id) {
        EachRestaurantDTO restaurant = eachRestaurantService.getEachRestaurantWithFoodItems(id);
        return ResponseEntity.ok(restaurant);
    }

    @PostMapping
    public List<EachRestaurantCreateDTO> createRestaurants(@RequestBody List<EachRestaurantCreateDTO> eachRestaurantCreateDTOs) {
        return eachRestaurantService.saveRestaurants(eachRestaurantCreateDTOs);
    }
}
