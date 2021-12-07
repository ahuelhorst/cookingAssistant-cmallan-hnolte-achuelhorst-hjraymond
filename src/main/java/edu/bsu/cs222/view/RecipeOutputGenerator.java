package edu.bsu.cs222.view;

import edu.bsu.cs222.model.Recipe;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class RecipeOutputGenerator {
    public VBox createRecipeOutput(Recipe recipe){
        Label title = new Label();
        Hyperlink link = new Hyperlink("Recipe Link");
        link.setOnAction(event -> {
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)){
                try {
                    Desktop.getDesktop().browse(new URI(recipe.getSource().toString()));
                    link.isVisited();
                } catch (IOException | URISyntaxException e) {
                    e.printStackTrace();
                }
            }
        });
        title.setText(recipe.getTitle());
        VBox recipeOutput = new VBox();
        recipeOutput.setSpacing(5);
        recipeOutput.setBackground(new Background(new BackgroundFill(Color.LAVENDER, null, null)));
        recipeOutput.setPrefSize(300, 200);
        recipeOutput.getChildren().add(title);
        recipeOutput.getChildren().add(link);
        return recipeOutput;
    }
}
