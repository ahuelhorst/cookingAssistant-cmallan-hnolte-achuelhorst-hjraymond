package edu.bsu.cs222;

import edu.bsu.cs222.model.UrlBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class UrlBuilderTest {

    private final UrlBuilder urlBuilder = new UrlBuilder();
    BufferedReader br = new BufferedReader(new InputStreamReader((Thread.currentThread().getContextClassLoader().getResourceAsStream("key.txt"))));
    String key = (br.readLine());

    public UrlBuilderTest() throws IOException {
    }

    @Test
    public void testIngredientUrlBuilder() throws MalformedURLException, UnsupportedEncodingException {
        String urlString = String.format("https://api.spoonacular.com/recipes/findByIngredients?" +
                "apiKey=%s&ingredients=peanut+butter%s+flour%s+sugar&number=5", key, "%2C", "%2C");
        URL ingredientUrl = new URL(urlString);
        URL actualUrl = urlBuilder.buildIngredientUrl("peanut butter, flour, sugar");
        Assertions.assertEquals(ingredientUrl, actualUrl);
    }

    @Test
    public void testRecipeUrlBuilder() throws MalformedURLException, UnsupportedEncodingException {
        String urlString = String.format("https://api.spoonacular.com/recipes/1161746/information?apiKey=%s&number=5", key);
        URL recipeUrl = new URL(urlString);
        URL actualUrl = urlBuilder.buildRecipeUrl("1161746");
        Assertions.assertEquals(recipeUrl, actualUrl);
    }
}
