package edu.bsu.cs222.view;

import edu.bsu.cs222.model.Recipe;

import java.util.ArrayList;

public class OutputFormatter {

    private final StringBuilder stringBuilder = new StringBuilder();

    public String format(ArrayList<Recipe> recipes){
        for (Recipe recipe : recipes){
            String formattedRecipe = String.format("Title: %s\nSource: %s\n\n", recipe.getTitle(), recipe.getSource());
            stringBuilder.append(formattedRecipe);
        }
        return stringBuilder.toString();
    }
    public String formatNutrition(ArrayList<Recipe> recipes){
        for (Recipe recipe : recipes){
            String calories = String.format("Calories: %s\nFat: %s\n\n", recipe.getCalories(), recipe.getFat());
            stringBuilder.append(calories);
        }
        return stringBuilder.toString();
    }
}
