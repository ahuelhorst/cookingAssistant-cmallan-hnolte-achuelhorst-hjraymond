package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class RecipeTest {
    private final String title = "Peanut Butter Muffins";
    private final String id = "1161746";
    private final String calorie = "300";
    private final String fat = "10 g";
    private final String protein = "13 g";
    private final String carb = "14 g";
    private final URL source = new URL("https://www.pinkwhen.com/peanut-butter-muffins/");

    public RecipeTest() throws MalformedURLException {
    }
    @Test
    public void testEquals_identityEquality(){
        Recipe recipe = new Recipe.Builder().withTitle(title).andId(id).andCalorie(calorie).andCarb(carb).andFat(fat).andProtein(protein).andSource(source);
        Assertions.assertEquals(recipe, recipe);
        System.out.println(recipe);
    }
}
