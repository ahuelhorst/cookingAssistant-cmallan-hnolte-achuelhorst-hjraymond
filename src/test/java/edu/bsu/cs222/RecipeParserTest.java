package edu.bsu.cs222;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.*;
import java.net.URL;

public class RecipeParserTest {

    private RecipeParser parser = new RecipeParser();

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
        String data = readFile(Thread.currentThread().getContextClassLoader().getResourceAsStream( "recipeIdTest.json" ));
        String id = parser.parseRecipeId(data);
        Assertions.assertEquals("1161746", id);
    }
   @Test
    public void testParseTitle() throws IOException {
        String data = readFile(Thread.currentThread().getContextClassLoader().getResourceAsStream( "recipeIdTest.json" ));
        String title = parser.parseRecipeTitle(data);
        Assertions.assertEquals("Peanut Butter Muffins", title);
    }
    @Test
    public void testParseSource() throws IOException {
        URL url = new URL("https://www.pinkwhen.com/peanut-butter-muffins/");
        String data = readFile(Thread.currentThread().getContextClassLoader().getResourceAsStream( "recipeSourceTest.json" ));
        URL source = parser.parseRecipeSource(data);
        Assertions.assertEquals(url, source);
    }
}
