package edu.bsu.cs222;

import java.io.IOException;
import java.net.URL;

public class Main {
    public static String process(String text) throws IOException {

        RecipeParser parser = new RecipeParser();
        UrlConnector connector = new UrlConnector();
        UrlBuilder urlBuilder = new UrlBuilder();
        URL ingredientUrl = urlBuilder.buildIngredientUrl(text);

        String data = connector.openConnection(ingredientUrl);
        String recipeId = parser.parseRecipeId(data);
        URL recipeUrl = urlBuilder.buildRecipeUrl(recipeId);
        String recipeData = connector.openConnection(recipeUrl);

        String title = parser.parseRecipeTitle(recipeData);
        URL source = parser.parseRecipeSource(recipeData);
        Recipe recipe = new Recipe.Builder().withTitle(title).andSource(source);

        RecipeFormatter formatter = new RecipeFormatter();
        return formatter.formatResponse(recipe);
    }
}
