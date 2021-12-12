package edu.bsu.cs222;

import edu.bsu.cs222.model.RecipeParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecipeParserTest {
    private final RecipeParser parser = new RecipeParser();

    private String readFile(InputStream pathName) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        BufferedReader br = new BufferedReader(new InputStreamReader(pathName));
        while ((line = br.readLine()) != null) {
            stringBuilder.append(line);
        }
        return stringBuilder.toString();
    }

    @Test
    public void testParseId() throws IOException {
        List<String> expectedList = Arrays.asList("1161746", "634921", "655241", "673425", "655212");
        String data = readFile(Thread.currentThread().getContextClassLoader().getResourceAsStream("recipeIdTest.json"));
        ArrayList<String> idList = parser.parseRecipeId(data);
        System.out.println(idList);
        Assertions.assertEquals(expectedList, idList);
    }

    @Test
    public void testParseTitle() throws IOException {
        List<String> expectedList = Arrays.asList("Peanut Butter Muffins", "Best Peanut Butter Cookies",
                "Peanut Butter Banana Muffins", "Peanut Butter and Jelly Granola Bars", "Peanut Butter and Apple Oatmeal Breakfast Bars");
        String data = readFile(Thread.currentThread().getContextClassLoader().getResourceAsStream("recipeIdTest.json"));
        ArrayList<String> titleList = parser.parseRecipeTitle(data);
        System.out.println(titleList);
        Assertions.assertEquals(expectedList, titleList);
    }

    @Test
    public void testParseSource() throws IOException {
        URL url = new URL("https://www.pinkwhen.com/peanut-butter-muffins/");
        String data = readFile(Thread.currentThread().getContextClassLoader().getResourceAsStream("recipeSourceTest.json"));
        URL source = parser.parseRecipeSource(data);
        Assertions.assertEquals(url, source);
    }

}
