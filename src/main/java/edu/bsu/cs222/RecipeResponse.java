package edu.bsu.cs222;

import java.io.IOException;
import java.net.URL;

public class RecipeResponse {
    RecipeParser parser = new RecipeParser();
    public Recipe getResponse(String data) throws IOException {
        String title = parser.parseRecipeTitle(data);
        URL source = parser.parseRecipeSource(data);
        return new Recipe.Builder().withTitle(title).andSource(source);
    }
}
