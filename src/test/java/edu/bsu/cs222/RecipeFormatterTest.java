package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class RecipeFormatterTest {
    URL source = new URL("https://www.pinkwhen.com/peanut-butter-muffins/");
    String title = "Peanut Butter Muffins";
    String id = "1161746";
    private RecipeFormatter formatter = new RecipeFormatter();
    Recipe recipe = new Recipe.Builder().withTitle(title).andId(id).andSource(source);

    public RecipeFormatterTest() throws MalformedURLException {
    }

    @Test
    public void testFormatRecipe(){
        String formattedRecipe = String.format("Recipe Title: %s\nRecipe Link: %s", title, source);
        String actualFormattedRecipe = formatter.formatResponse(recipe);
        Assertions.assertEquals(formattedRecipe, actualFormattedRecipe);
    }
}
