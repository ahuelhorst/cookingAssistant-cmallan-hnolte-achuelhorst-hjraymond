package edu.bsu.cs222;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class RecipeUI extends Application {
    private final Executor executor = Executors.newSingleThreadExecutor();
    private final Runnable recipeTask = new RecipeTask();
    private final Label inputInfo = new Label();
    private final Label outputInfo = new Label();
    private TextField userInput;
    private TextArea recipeOutput;
    private Button retrieveButton;
    public TextField createUserInput() {
        userInput = new TextField();
        userInput.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)){
                retrieveButton.fire();
            }
        });
        return userInput;
    }
    public Label outputInfoLabel(){
        outputInfo.setText("Recipes & information Found: ");
        outputInfo.setFont(Font.font("Times New Roman", 15));
        return outputInfo;
    }
    public Label userInfoLabel(){
        inputInfo.setText("Enter Ingredients: ");
        inputInfo.setFont(Font.font("Times New Roman",FontWeight.BOLD, 19));
        return inputInfo;
    }
    public Button createRetrieveButton(){
        retrieveButton = new Button("Get Recipes");
        retrieveButton.setOnAction(event -> executor.execute(recipeTask));
        return retrieveButton;
    }
    public TextArea createRecipeOutput(){
        recipeOutput = new TextArea();
        recipeOutput.setEditable(false);
        recipeOutput.setPrefHeight(500);
        return recipeOutput;
    }
    public Parent createCookingUI() {
        HBox buttonBox = new HBox();
        HBox labelBox = new HBox();
        VBox container = new VBox();
        container.setPrefSize(950, 600);
        labelBox.getChildren().addAll(outputInfoLabel());
        buttonBox.getChildren().add(createRetrieveButton());
        container.getChildren().addAll(userInfoLabel(),createUserInput(),buttonBox,labelBox, new HBox(createRecipeOutput()));
        labelBox.setSpacing(375);
        return container;
    }
    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(createCookingUI());
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private final class RecipeTask implements Runnable {
        @Override
        public void run() {
            MainApplication mainApplication = new MainApplication();
            disableInput();
            String recipes = null;
            String nutrition = null;
            try {
                recipes = mainApplication.processRecipes(userInput.getText());
                nutrition = mainApplication.processNutrition(userInput.getText());
            } catch (IOException e) {
                e.printStackTrace();
            }
            recipeOutput.setText(recipes);
            recipeOutput.setText(nutrition);
            enableInput();
        }
        private void enableInput() {
            userInput.setDisable(false);
            retrieveButton.setDisable(false);
        }
        private void disableInput() {
            userInput.setDisable(true);
            retrieveButton.setDisable(true);
        }
    }
}

