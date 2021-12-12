package edu.bsu.cs222.model;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class RecipeParser {

    private final ArrayList<String> idList = new ArrayList<>();
    private final ArrayList<String> titleList = new ArrayList<>();

    public ArrayList<String> parseRecipeTitle(String data) {
        for (int i = 0; i <= 4; i++) {
            JSONArray titles = JsonPath.read(data, "$..title");
            titleList.add(titles.get(i).toString());
        }
        return titleList;
    }

    public ArrayList<String> parseRecipeId(String data) {
        for (int i = 0; i <= 4; i++) {
            String jsonPath = String.format("$[%d].id", i);
            int id = JsonPath.read(data, jsonPath);
            String id2 = Integer.toString(id);
            idList.add(id2);
        }
        return idList;
    }

    public URL parseRecipeSource(String data) throws IOException {
        JSONArray sources = JsonPath.read(data, "$..sourceUrl");
        String recipeSource = sources.get(0).toString();
        return new URL(recipeSource);
    }

}
