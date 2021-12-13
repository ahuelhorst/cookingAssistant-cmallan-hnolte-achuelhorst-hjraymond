package edu.bsu.cs222.model;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class RecipeResponse {

    RecipeParser parser = new RecipeParser();
    NutritionParser nutritionParser = new NutritionParser();
    ArrayList<Recipe> recipeArrayList = new ArrayList<>();
    ArrayList<String> titles = new ArrayList<>();
    ArrayList<String> ids = new ArrayList<>();

    public ArrayList<Recipe> getRecipes(String data) throws IOException {
        titles = parser.parseRecipeTitle(data);
        ids = parser.parseRecipeId(data);
        for (int i = 0; i <= 4; i++) {
            String title = titles.get(i);
            String id = ids.get(i);
            URL sourceUrl = getSource(id);
            String calories = getCalories(id);
            String fat = getFat(id);
            String protein = getProtein(id);
            Recipe recipe = new Recipe.Builder().withTitle(title).andId(id).andCalories(calories).andFat(fat).andProtein(protein).andSource(sourceUrl);
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
    public String getFat(String id) throws IOException {
        UrlBuilder urlBuilder = new UrlBuilder();
        UrlConnector connector = new UrlConnector();
        URL nutritionUrl = urlBuilder.buildNutritionUrl(id);
        String data = connector.openConnection(nutritionUrl);
        return nutritionParser.parseFat(data);
    }
    public String getProtein(String id) throws IOException {
        UrlBuilder urlBuilder = new UrlBuilder();
        UrlConnector connector = new UrlConnector();
        URL nutritionUrl = urlBuilder.buildNutritionUrl(id);
        String data = connector.openConnection(nutritionUrl);
        return nutritionParser.parseProtein(data);
    }
}
