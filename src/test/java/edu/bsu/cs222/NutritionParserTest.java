package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class NutritionParserTest {
    NutritionParser parser = new NutritionParser();

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
    public void testCalorieInfo() throws IOException {
        String data = readFile(Thread.currentThread().getContextClassLoader().getResourceAsStream("nutritionInfoTest.json"));
        String nutrition = parser.parseCalories(data);
        Assertions.assertEquals("316", nutrition);
    }
    @Test
    public void testCarbInfo() throws IOException {
        String data = readFile(Thread.currentThread().getContextClassLoader().getResourceAsStream("nutritionInfoTest.json"));
        String nutrition = parser.parseCarbs(data);
        Assertions.assertEquals("49g", nutrition);
    }
    @Test
    public void testFatInfo() throws IOException {
        String data = readFile(Thread.currentThread().getContextClassLoader().getResourceAsStream("nutritionInfoTest.json"));
        String nutrition = parser.parseFat(data);
        Assertions.assertEquals("12g", nutrition);
    }
    @Test
    public void testProteinInfo() throws IOException {
        String data = readFile(Thread.currentThread().getContextClassLoader().getResourceAsStream("nutritionInfoTest.json"));
        String nutrition = parser.parseProtein(data);
        Assertions.assertEquals("3g", nutrition);
    }
}
