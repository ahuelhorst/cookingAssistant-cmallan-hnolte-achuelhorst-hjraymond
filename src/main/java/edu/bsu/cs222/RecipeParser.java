package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class RecipeParser {

    private final ArrayList<String> idList = new ArrayList<>();

    public ArrayList<String> parseRecipeId(String data) {
        for (int i = 0; i<=4; i++){
            String jsonPath = String.format("$[%d].id", i);
            System.out.println("ABBY ABBY ABBY ABBY" +  jsonPath);
            int id = JsonPath.read(data, jsonPath);
            System.out.println("WE ARE HERE " + id);
            String id2 = Integer.toString(id);
            idList.add(id2);
        }
        return idList;
    }
    public String parseRecipeTitle(String data) {
        JSONArray titles = JsonPath.read(data, "$..title");
        return titles.get(0).toString();
    }
    public URL parseRecipeSource(String data) throws IOException {
        JSONArray sources = JsonPath.read(data, "$..sourceUrl");
        String recipeSource = sources.get(0).toString();
        return new URL(recipeSource);
    }
}
