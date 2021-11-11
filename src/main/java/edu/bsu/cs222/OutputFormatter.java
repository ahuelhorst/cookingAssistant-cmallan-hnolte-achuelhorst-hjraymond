package edu.bsu.cs222;

import java.util.ArrayList;

public class OutputFormatter {
    private final StringBuilder stringBuilder = new StringBuilder();

    public String format(ArrayList<Recipe> recipes){
        for (Recipe recipe : recipes){
            String title = String.format("Title: %s\nSource: %s\n\n", recipe.getTitle(), recipe.getSource());
            stringBuilder.append(title);
        }
        return stringBuilder.toString();
    }
    public String formatNutrition(ArrayList<Recipe> recipes){
        for (Recipe recipe : recipes){
            String calories = String.format("Calories: %s\n\n", recipe.getCalories());
            stringBuilder.append(calories);
        }
        return stringBuilder.toString();
    }
}
