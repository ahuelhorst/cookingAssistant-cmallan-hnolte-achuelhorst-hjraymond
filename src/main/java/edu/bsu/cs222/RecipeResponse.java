package edu.bsu.cs222;

import java.io.IOException;
import java.net.URL;

public class RecipeResponse {

    RecipeParser parser = new RecipeParser();
    NutritionParser nutritionParser = new NutritionParser();

    public Recipe getResponse(String data) throws IOException {
        String title = parser.parseRecipeTitle(data);
        URL source = parser.parseRecipeSource(data);
        String calorie = nutritionParser.parseCalories(data);
        String fat = nutritionParser.parseFat(data);
        String carb = nutritionParser.parseCarbs(data);
        String protein = nutritionParser.parseProtein(data);
        return new Recipe.Builder().withTitle(title).andSource(source);
    }
}
