package edu.bsu.cs222;

public class OutputFormatter {
    public String formatRecipe(Recipe recipe) {
        return (String.format("Recipe Title: %s\nRecipe Link: %s", recipe.getTitle(), recipe.getSource()));
    }

//    public String formatNutritionFacts(){
//        return (String.format("Calories: %s\nCarbohydrates: %s\nProtein: %s\nFat: %s", ));
//    }
}
