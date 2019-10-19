package com.blake.health.julio.model;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class FoodService
{
    @Value("${food.service.api.key}")
    String apiKey;

    private RestTemplate restTemplate;

    @Autowired
    public FoodService(final RestTemplate restTemplate)
    {
        this.restTemplate = restTemplate;
    }

    public FoodsResponse search(String food) throws RestClientException
    {
        FoodSearchParameters foodSearchParameters = new FoodSearchParameters(food);
        URI url = URI.create("https://api.nal.usda.gov/fdc/v1/search?api_key=" + apiKey);

        return restTemplate.postForObject(url, foodSearchParameters, FoodsResponse.class);
    }

    public NutrientsResponse getNutrients(final int fdcId) throws RestClientException
    {
        URI uri = URI.create("https://api.nal.usda.gov/fdc/v1/" + fdcId + "?api_key=" + apiKey);
        return restTemplate.getForObject(uri, NutrientsResponse.class);
    }
}
