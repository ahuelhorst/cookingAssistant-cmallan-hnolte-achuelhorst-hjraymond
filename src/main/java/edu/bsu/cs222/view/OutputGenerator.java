package edu.bsu.cs222.view;

import edu.bsu.cs222.model.Recipe;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class OutputGenerator {
    RecipeOutputGenerator recipeGenerator = new RecipeOutputGenerator();
    NutritionOutputGenerator nutritionGenerator = new NutritionOutputGenerator();

    public HBox createOutput(Recipe recipe){
        VBox recipeBox = recipeGenerator.createRecipeOutput(recipe);
        VBox nutritionBox = nutritionGenerator.createNutritionOutput(recipe);
        HBox outputBox = new HBox();
        outputBox.setStyle("-fx-border-width: 2;" + "-fx-border-color: black;");
        outputBox.setPrefSize(600, 200);
        outputBox.getChildren().addAll(recipeBox, nutritionBox);
        return outputBox;
    }
}
