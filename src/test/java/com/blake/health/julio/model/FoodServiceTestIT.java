package com.blake.health.julio.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestClientException;

import lombok.extern.slf4j.Slf4j;
import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@SpringBootTest
public class FoodServiceTestIT
{
    @Autowired
    FoodService foodService;

    @Test
    public void canSearchForCheese()
    {
        FoodsResponse foodsResponse = foodService.search("cheese");

        float totalHits = foodsResponse.getTotalHits();
        log.info("Found {} results", totalHits);
        assertThat(totalHits).isGreaterThan(1);
    }

    @Test
    public void searchingForNullReturnsEverything()
    {
        FoodsResponse foodsResponse = foodService.search(null);

        float totalHits = foodsResponse.getTotalHits();
        log.info("Found {} results", totalHits);
        assertThat(totalHits).isGreaterThan(1);
    }

    @Test
    public void searchForNonsenseFindsNothing()
    {
        FoodsResponse foodsResponse = foodService.search("asdfankasubd");

        float totalHits = foodsResponse.getTotalHits();
        log.info("Found {} results", totalHits);
        assertThat(totalHits).isEqualTo(0.0f);
    }

    @Test
    public void canGetTheNutrientsForCheese()
    {
        final int fdcId = 336711;

        NutrientsResponse nutrientsResponse = foodService.getNutrients(fdcId);

        assertThat(nutrientsResponse.getFdcId()).isEqualTo(fdcId);
    }

    @Test
    public void gettingNutrientsForNonFoundItemThrowsRestClientException()
    {
        final int fdcId = 0;

        RestClientException e = Assertions.assertThrows(RestClientException.class, () -> foodService.getNutrients(fdcId));

        assertThat(e.getMessage()).contains("404 Not Found");
    }
}
