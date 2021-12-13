package edu.bsu.cs222.view;

import edu.bsu.cs222.model.Recipe;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;


public class NutritionOutputGenerator {

    public VBox createNutritionOutput(Recipe recipe) {
        VBox nutritionOutputBox = new VBox();
        nutritionOutputBox.setSpacing(5);
        nutritionOutputBox.setBackground(new Background(new BackgroundFill(Color.LIGHTSTEELBLUE, null, null)));
        nutritionOutputBox.setPadding(new Insets(0, 5, 0, 0));
        nutritionOutputBox.setPrefSize(300, 200);
        nutritionOutputBox.getChildren().add(createLabelBox(recipe));
        return nutritionOutputBox;
    }

    public Label createNutritionLabel() {
        return new Label("Nutrition Info:");
    }

    public Label createCalorieLabel(Recipe recipe) {
        Label calorieLabel = new Label();
        calorieLabel.setText("Calories: " + recipe.getCalories());
        return calorieLabel;
    }

    public Label createFatLabel(Recipe recipe) {
        Label fatLabel = new Label();
        fatLabel.setText("Fat: " + recipe.getFat());
        return fatLabel;
    }

    public Label createProteinLabel(Recipe recipe) {
        Label proteinLabel = new Label();
        proteinLabel.setText("Protein: " + recipe.getProtein());
        return proteinLabel;
    }

    public VBox createLabelBox(Recipe recipe) {
        VBox labelBox = new VBox();
        labelBox.getChildren().addAll(createNutritionLabel(), createCalorieLabel(recipe), createFatLabel(recipe), createProteinLabel(recipe));
        return labelBox;
    }

}
