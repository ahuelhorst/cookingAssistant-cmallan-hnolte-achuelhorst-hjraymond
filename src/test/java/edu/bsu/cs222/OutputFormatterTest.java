package edu.bsu.cs222;

import edu.bsu.cs222.model.Recipe;
import edu.bsu.cs222.view.OutputFormatter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class OutputFormatterTest {

    private final List<Recipe> testRecipeList = new ArrayList<>();
    private final OutputFormatter formatter = new OutputFormatter();

    @Test
    public void testFormatRecipe() throws MalformedURLException {
        URL url = new URL("https://www.pinkwhen.com/peanut-butter-muffins/");
        Recipe recipe = new Recipe.Builder().withTitle("Peanut Butter Muffins").andSource(url);
        testRecipeList.add(recipe);
        String expectedFormat = String.format("Title: %s\nSource: %s\n\n", recipe.getTitle(), recipe.getSource());
        String actualFormat = formatter.format((ArrayList<Recipe>) testRecipeList);
        Assertions.assertEquals(expectedFormat, actualFormat);
    }

}
