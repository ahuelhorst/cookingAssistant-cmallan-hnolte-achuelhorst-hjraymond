package edu.bsu.cs222.view;

import edu.bsu.cs222.Application;
import edu.bsu.cs222.model.ApiKey;
import edu.bsu.cs222.model.Recipe;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class RecipeUI extends javafx.application.Application {
    private final OutputGenerator generator = new OutputGenerator();
    private final Label inputInfo = new Label();
    private TextField userInput;
    private final Button retrieveButton = new Button("Get Recipes");
    ApiKey apiKeyTest = new ApiKey();
    boolean value = apiKeyTest.checkFileLocation();
    private final Scene scene = createCookingUI();


    public TextField createUserInput() {
        userInput = new TextField();
        userInput.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                retrieveButton.fire();
            }
        });
        return userInput;
    }

    public Label userInfoLabel() {
        inputInfo.setText("Enter Ingredients: ");
        inputInfo.setFont(Font.font("Times New Roman", FontWeight.BOLD, 19));
        return inputInfo;
    }

    public Label createTitleLabel() {
        Label titleLabel = new Label();
        titleLabel.setPrefSize(950, 20);
        titleLabel.setText("Cooking Assistant");
        titleLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD, 24));
        titleLabel.setAlignment(Pos.CENTER);
        return titleLabel;
    }

    public Scene createCookingUI() {
        if (!value) {
            TextArea textArea = new TextArea("API KEY REQUIRED");
            textArea.setPrefSize(200, 100);
            textArea.setFont(Font.font(20));
            return new Scene(textArea);
        }
        Label titleLabel = createTitleLabel();
        VBox container = new VBox();
        container.setPrefSize(950, 800);
        container.setSpacing(20);
        container.getChildren().addAll(titleLabel, userInfoLabel(), createUserInput(), retrieveButton);
        retrieveButton.setOnAction(event -> {
            try {
                container.getChildren().add(retrieveRecipeOutput());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        return new Scene(container);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public GridPane retrieveRecipeOutput() throws IOException {
        return run();
    }

    private void disableInput() {
        userInput.setDisable(true);
        retrieveButton.setDisable(true);
    }

    public GridPane run() {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(12);
        grid.setPrefSize(950, 600);
        Application mainApplication = new Application();
        disableInput();
        ArrayList<Recipe> list = null;
        try {
            list = mainApplication.processRecipes(userInput.getText());
            disableInput();
        } catch (IOException e) {
            e.printStackTrace();
        }
        enableInput();
        for (int i = 0; i <= 4; i++) {
            assert list != null;
            HBox hBox = generator.createOutput(list.get(i));
            grid.add(hBox, 7, i);
        }
        return grid;
    }


    private void enableInput() {
        userInput.setDisable(false);
        retrieveButton.setDisable(false);
    }

}


