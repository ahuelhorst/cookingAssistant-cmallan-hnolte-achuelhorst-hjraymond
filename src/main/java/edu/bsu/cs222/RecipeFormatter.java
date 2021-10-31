package edu.bsu.cs222;

public class RecipeFormatter {
    public String formatResponse(Recipe recipe) {
        return (String.format("Recipe Title: %s\nRecipe Link: %s", recipe.getTitle(), recipe.getSource()));
    }
}
