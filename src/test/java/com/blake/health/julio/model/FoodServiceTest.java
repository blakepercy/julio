package com.blake.health.julio.model;

import java.io.File;
import java.net.URI;

import com.blake.health.julio.model.util.JsonUtils;

import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@Slf4j
public class FoodServiceTest
{
    @Test
    public void canSearchForCheese()
    {
        RestTemplate restTemplate = mock(RestTemplate.class);
        FoodsResponse mockedFoodsResponse = JsonUtils
            .deserialise(FoodsResponse.class, new File("src/test/resources/FoodsResponseExample.json"));

        when(restTemplate.postForObject(any(URI.class), any(FoodSearchParameters.class), any())).thenReturn(mockedFoodsResponse);
        FoodService foodService = new FoodService(restTemplate);
        FoodsResponse foodsResponse = foodService.search("cheese");

        float totalHits = foodsResponse.getTotalHits();
        log.info("Found {} results", totalHits);
        verify(restTemplate).postForObject(any(URI.class), any(FoodSearchParameters.class), any());
        assertThat(totalHits).isGreaterThan(1);
    }

    @Test
    public void canGetTheNutrientsForCheese()
    {
        final int fdcId = 336711;
        RestTemplate restTemplate = mock(RestTemplate.class);
        NutrientsResponse mockedNutrientsResponse = JsonUtils
            .deserialise(NutrientsResponse.class, new File("src/test/resources/NutrientsResponseExample.json"));

        when(restTemplate.getForObject(any(URI.class), any())).thenReturn(mockedNutrientsResponse);
        FoodService foodService = new FoodService(restTemplate);
        NutrientsResponse nutrientsResponse = foodService.getNutrients(fdcId);

        verify(restTemplate).getForObject(any(URI.class), any());
        assertThat(nutrientsResponse.getFdcId()).isEqualTo(fdcId);
    }
}
