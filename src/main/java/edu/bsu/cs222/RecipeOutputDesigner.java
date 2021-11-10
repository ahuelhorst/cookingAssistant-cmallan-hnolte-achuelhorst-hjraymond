package edu.bsu.cs222;

import javafx.scene.control.TextArea;
import javafx.scene.text.Font;
import javafx.scene.control.Label;

public class RecipeOutputDesigner extends TextArea {

    private final Label outputInfo = new Label();
    public Label recipeInfoLabel(){
        outputInfo.setText("Recipes Found: ");
        outputInfo.setFont(Font.font("Times New Roman", 20));
        return outputInfo;
    }
    public TextArea createRecipeOutput(){
        TextArea textArea = new TextArea();
        textArea.setPrefSize(500, 400);
        textArea.setEditable(false);
        return textArea;
    }
}
