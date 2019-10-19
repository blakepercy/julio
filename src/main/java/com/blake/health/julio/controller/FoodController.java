package com.blake.health.julio.controller;

import java.util.List;

import com.blake.health.julio.model.Food;
import com.blake.health.julio.model.FoodNutrient;
import com.blake.health.julio.model.FoodService;
import com.blake.health.julio.model.FoodsResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FoodController
{
    private FoodService foodService;

    @Autowired
    public FoodController(FoodService foodService)
    {
        this.foodService = foodService;
    }

    @GetMapping(value = "/foods")
    public List<Food> searchForFoods(@RequestParam final String food)
    {
        FoodsResponse foodsResponse = foodService.search(food);
        return foodsResponse.getFoods();
    }

    @GetMapping(value = "/nutrients")
    public List<FoodNutrient> getNutrientsForFood(@RequestParam final String foodId)
    {
        return foodService.getNutrients(Integer.valueOf(foodId)).getFoodNutrients();
    }
}
