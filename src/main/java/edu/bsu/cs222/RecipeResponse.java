package edu.bsu.cs222;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class RecipeResponse {

    RecipeParser parser = new RecipeParser();
    NutritionParser nutritionParser = new NutritionParser();
    ArrayList<Recipe> recipeArrayList = new ArrayList<>();

    public ArrayList<Recipe> getRecipes(String data) throws IOException {

        ArrayList<String> titles = parser.parseRecipeTitle(data);
        ArrayList<String> ids = parser.parseRecipeId(data);
        for (int i = 0; i <= 4; i++) {
            String title = titles.get(i);
            String id = ids.get(i);
            URL sourceUrl = getSource(id);
            String calories = getCalories(id);
            Recipe recipe = new Recipe.Builder().withTitle(title).andId(id).andCalories(calories).andSource(sourceUrl);
            recipeArrayList.add(recipe);
        }
        return recipeArrayList;
    }

    public URL getSource(String id) throws IOException {
        UrlBuilder urlBuilder = new UrlBuilder();
        UrlConnector connector = new UrlConnector();
        URL sourceUrl = urlBuilder.buildRecipeUrl(id);
        String data = connector.openConnection(sourceUrl);
        return parser.parseRecipeSource(data);
    }

    public String getCalories(String id) throws IOException {
        UrlBuilder urlBuilder = new UrlBuilder();
        UrlConnector connector = new UrlConnector();
        URL nutritionUrl = urlBuilder.buildNutritionUrl(id);
        String data = connector.openConnection(nutritionUrl);
        return nutritionParser.parseCalories(data);
    }
}
