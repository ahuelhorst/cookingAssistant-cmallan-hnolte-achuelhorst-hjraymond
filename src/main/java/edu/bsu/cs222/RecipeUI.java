package edu.bsu.cs222;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class RecipeUI extends Application {
    private final Executor executor = Executors.newSingleThreadExecutor();
    private final Runnable recipeTask = new RecipeTask();

    private final Label inputInfo = new Label();
    private final Label outputInfo = new Label();
    private final TextField userInput;
    private final TextArea output;
    private final Button retrieveButton;

    public RecipeUI() {
        inputInfo.setText("Enter Ingredients: ");
        userInput = new TextField();
        retrieveButton = new Button("Get Recipe");
        outputInfo.setText("Recipe Found: ");
        output = new TextArea();
        output.setEditable(false);
        output.setPrefHeight(500);
        retrieveButton.setOnAction(event -> executor.execute(recipeTask));
    }
    public Parent createCookingUI() {

        VBox vbox = new VBox();
        vbox.setPrefSize(950, 600);
        vbox.getChildren().add(inputInfo);
        vbox.getChildren().add(userInput);
        vbox.getChildren().add(retrieveButton);
        vbox.getChildren().add(outputInfo);
        vbox.getChildren().add(output);
        return vbox;
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
            disableInput();
            String recipes = null;
            try {
                recipes = Main.process(userInput.getText());
            } catch (IOException e) {
                e.printStackTrace();
            }
            output.setText(recipes);
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
