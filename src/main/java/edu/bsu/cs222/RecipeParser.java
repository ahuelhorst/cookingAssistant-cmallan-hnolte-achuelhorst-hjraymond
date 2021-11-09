package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class RecipeParser {

    private final ArrayList<String> idList = new ArrayList<>();

    public ArrayList<String> parseRecipeId(String data) {
        for (int i = 0; i<=5; i++){
            String jsonPath = String.format("$[%d].id", i);
            JSONArray id = JsonPath.read(data, jsonPath);
            idList.add(id.get(i).toString());
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
