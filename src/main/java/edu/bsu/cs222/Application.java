package edu.bsu.cs222;

import edu.bsu.cs222.model.Recipe;
import edu.bsu.cs222.model.RecipeResponse;
import edu.bsu.cs222.model.UrlBuilder;
import edu.bsu.cs222.model.UrlConnector;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;


public class Application {


    public String connectIngredientUrl(String userInput) throws IOException {
        UrlBuilder urlBuilder = new UrlBuilder();
        URL ingredientUrl = urlBuilder.buildIngredientUrl(userInput);
        UrlConnector connector = new UrlConnector();
        return connector.openConnection(ingredientUrl);
    }

    public ArrayList<Recipe> processRecipes(String userInput) throws IOException {
        String data = connectIngredientUrl(userInput);
        return createRecipeList(data);
    }

    public ArrayList<Recipe> createRecipeList(String data) throws IOException {
        RecipeResponse recipeResponse = new RecipeResponse();
        return recipeResponse.getRecipes(data);
    }
}
