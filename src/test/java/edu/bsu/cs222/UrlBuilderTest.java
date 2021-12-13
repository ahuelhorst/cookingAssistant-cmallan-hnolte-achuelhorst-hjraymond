package edu.bsu.cs222;

import edu.bsu.cs222.model.UrlBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;

public class UrlBuilderTest {

    private final UrlBuilder urlBuilder = new UrlBuilder();


    @Test
    public void testIngredientUrlBuilder() throws MalformedURLException, UnsupportedEncodingException {
        String urlString = "https://api.spoonacular.com/recipes/findByIngredients?" +
                "ingredients=peanut+butter,+flour,+sugar&number=5";
        URL ingredientUrl = new URL(urlString);
        URL actualUrl = urlBuilder.buildIngredientUrl("peanut butter, flour, sugar");
        Assertions.assertEquals(ingredientUrl, actualUrl);
    }

    @Test
    public void testRecipeUrlBuilder() throws MalformedURLException, UnsupportedEncodingException {
        String urlString = "https://api.spoonacular.com/recipes/1161746/information?number=5";
        URL recipeUrl = new URL(urlString);
        URL actualUrl = urlBuilder.buildRecipeUrl("1161746");
        Assertions.assertEquals(recipeUrl, actualUrl);
    }
}
