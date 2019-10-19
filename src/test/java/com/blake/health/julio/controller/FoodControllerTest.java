package com.blake.health.julio.controller;

import java.io.File;

import com.blake.health.julio.model.FoodService;
import com.blake.health.julio.model.FoodsResponse;
import com.blake.health.julio.model.NutrientsResponse;
import com.blake.health.julio.model.util.JsonUtils;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(FoodController.class)
public class FoodControllerTest
{
    @Autowired
    MockMvc mvc;

    @MockBean
    FoodService foodService;

    @Test
    public void canSearchForCheeseRestApi() throws Exception
    {
        FoodsResponse foodsResponse = JsonUtils.deserialise(FoodsResponse.class, new File("src/test/resources/FoodsResponseExample.json"));
        when(foodService.search("cheese"))
               .thenReturn(foodsResponse);

        mvc.perform(MockMvcRequestBuilders
                        .get("/foods")
                        .characterEncoding("UTF-8")
                        .param("food", "cheese")
                        .accept(MediaType.APPLICATION_JSON))
           .andExpect(status().isOk())
           .andExpect(MockMvcResultMatchers.jsonPath("$[0].fdcId").exists());

        verify(foodService).search("cheese");
    }

    @Test
    public void canGetNutrientsForCheeseRestApi() throws Exception
    {
        NutrientsResponse nutrientsResponse = JsonUtils
            .deserialise(NutrientsResponse.class, new File("src/test/resources/NutrientsResponseExample.json"));

        when(foodService.getNutrients(336711)).thenReturn(nutrientsResponse);

        mvc.perform(MockMvcRequestBuilders
                        .get("/nutrients")
                        .characterEncoding("UTF-8")
                        .param("foodId", "336711")
                        .accept(MediaType.APPLICATION_JSON))
           .andExpect(status().isOk())
           .andExpect(MockMvcResultMatchers.jsonPath("$[0].type").value("FoodNutrient"))
           .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(2329897));
    }

}
