package edu.bsu.cs222;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

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
        ArrayList<String> expectedList = new ArrayList<String>(Arrays.asList("1161746", "634921", "655241", "673425","655212"));
        String data = readFile(Thread.currentThread().getContextClassLoader().getResourceAsStream( "recipeIdTest.json" ));
        ArrayList<String> idList = parser.parseRecipeId(data);
        System.out.println(idList);
        Assertions.assertEquals(expectedList, idList);
    }

    @Test
    public void testParseTitle() throws IOException {
        ArrayList<String> expectedList = new ArrayList<String>(Arrays.asList("Peanut Butter Muffins", "Best Peanut Butter Cookies",
                "Peanut Butter Banana Muffins", "Peanut Butter and Jelly Granola Bars","Peanut Butter and Apple Oatmeal Breakfast Bars"));
        String data = readFile(Thread.currentThread().getContextClassLoader().getResourceAsStream( "recipeIdTest.json" ));
        ArrayList<String> titleList = parser.parseRecipeTitle(data);
        System.out.println(titleList);
        Assertions.assertEquals(expectedList, titleList);
    }
    @Test
    public void testParseSource() throws IOException {
        URL url = new URL("https://www.pinkwhen.com/peanut-butter-muffins/");
        String data = readFile(Thread.currentThread().getContextClassLoader().getResourceAsStream( "recipeSourceTest.json" ));
        URL source = parser.parseRecipeSource(data);
        Assertions.assertEquals(url, source);
    }

}
