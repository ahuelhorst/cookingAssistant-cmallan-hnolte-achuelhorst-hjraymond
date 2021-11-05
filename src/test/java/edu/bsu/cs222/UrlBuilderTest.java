package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;
import java.util.Scanner;

public class UrlBuilderTest {
    BufferedReader br = new BufferedReader(new InputStreamReader((Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResourceAsStream("key.txt")))));
    String key = (br.readLine());

    private final UrlBuilder urlBuilder = new UrlBuilder();

    public UrlBuilderTest() throws IOException {
    }
    @Test
    public void testIngredientUrlBuilder() throws MalformedURLException, UnsupportedEncodingException {
        String urlString = String.format("https://api.spoonacular.com/recipes/findByIngredients?" +
                "apiKey=%s&ingredients=peanut+butter,+flour,+sugar&number=1", key);
        URL ingredientUrl = new URL(urlString);
        URL actualUrl = urlBuilder.buildIngredientUrl("peanut butter, flour, sugar");
        Assertions.assertEquals(ingredientUrl, actualUrl);
    }
    @Test
    public void testRecipeUrlBuilder() throws MalformedURLException, UnsupportedEncodingException {
        String urlString = String.format("https://api.spoonacular.com/recipes/1161746/information?apiKey=%s&number=1", key);
        URL recipeUrl = new URL(urlString);
        URL actualUrl = urlBuilder.buildRecipeUrl("1161746");
        Assertions.assertEquals(recipeUrl, actualUrl);
    }

    @Test
    public void testNutritionUrlBuilder() throws MalformedURLException, UnsupportedEncodingException {
        String urlString = String.format("https://api.spoonacular.com/recipes/1161746/nutritionWidget.json/apiKey=%s", key);
        URL recipeUrl = new URL(urlString);
        URL actualUrl = urlBuilder.buildNutritionUrl("1161746");
        Assertions.assertEquals(recipeUrl, actualUrl);
    }
}
