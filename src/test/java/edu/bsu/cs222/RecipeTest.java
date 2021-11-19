package edu.bsu.cs222;

import edu.bsu.cs222.model.Recipe;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class RecipeTest {

    @Test
    public void testEquals_identityEquality() throws MalformedURLException {
        URL source = new URL("https://www.pinkwhen.com/peanut-butter-muffins/");
        String title = "Peanut Butter Muffins";
        String id = "1161746";
        Recipe recipe = new Recipe.Builder().withTitle(title).andId(id).andSource(source);
        Assertions.assertEquals(recipe, recipe);
        System.out.println(recipe);
    }
}
