package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class UrlBuilderTest {
    private File file = new File("/Users/abbyhuelhorst/Desktop/CS222/cookingAssistant/src/main/resources/key.txt");
    private Scanner scanner = new Scanner(file);
    private String key = scanner.nextLine();

    private UrlBuilder urlBuilder = new UrlBuilder();

    public UrlBuilderTest() throws FileNotFoundException {
    }
    @Test
    public void testIngredientUrlBuilder() throws MalformedURLException {
        String urlString = String.format("https://api.spoonacular.com/recipes/findByIngredients?" +
                "apiKey=%s&ingredients=peanut+butter,+flour,+sugar&number=1", key);
        URL ingredientUrl = new URL(urlString);
        URL actualUrl = urlBuilder.buildIngredientUrl("peanut butter, flour, sugar");
        Assertions.assertEquals(ingredientUrl, actualUrl);
    }
    @Test
    public void testRecipeUrlBuilder() throws MalformedURLException {
        String urlString = String.format("https://api.spoonacular.com/recipes/1161746/information?apiKey=%s&number=1", key);
        URL recipeUrl = new URL(urlString);
        URL actualUrl = urlBuilder.buildRecipeUrl("1161746");
        Assertions.assertEquals(recipeUrl, actualUrl);
    }
}
