package edu.bsu.cs222;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class MainApplication {

    public String connectIngredientUrl(String userInput) throws IOException {
        UrlBuilder urlBuilder = new UrlBuilder();
        URL ingredientUrl = urlBuilder.buildIngredientUrl(userInput);
        UrlConnector connector = new UrlConnector();
        return connector.openConnection(ingredientUrl);
    }
    public String processRecipes(String userInput) throws IOException {
        String data = connectIngredientUrl(userInput);
        ArrayList<Recipe> recipeList = createRecipeList(data);
        OutputFormatter formatter = new OutputFormatter();
        return formatter.format(recipeList);
    }
    public String processNutrition(String userInput) throws IOException {
        String data = connectIngredientUrl(userInput);
        ArrayList<Recipe> recipeList = createRecipeList(data);
        OutputFormatter formatter = new OutputFormatter();
        return formatter.formatNutrition(recipeList);
    }
    public ArrayList<Recipe> createRecipeList(String data) throws IOException {
        RecipeResponse recipeResponse = new RecipeResponse();
        return recipeResponse.getRecipes(data);
    }
}
