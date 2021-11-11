package edu.bsu.cs222;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ingredients: ");
        String ingredients = scanner.nextLine();
        UrlBuilder urlBuilder = new UrlBuilder();

        URL ingredientUrl = urlBuilder.buildIngredientUrl(ingredients);
        UrlConnector connector = new UrlConnector();

        String ingredientData = connector.openConnection(ingredientUrl);

        RecipeResponse recipeResponse = new RecipeResponse();
        ArrayList<Recipe> recipeList = recipeResponse.getRecipes(ingredientData);

        OutputFormatter formatter = new OutputFormatter();

        System.out.println(formatter.format(recipeList));

    }
}
