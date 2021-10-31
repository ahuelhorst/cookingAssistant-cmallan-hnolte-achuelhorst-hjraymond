package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.io.IOException;
import java.net.URL;

public class RecipeParser {
    public String parseRecipeId(String data) throws IOException {
        JSONArray id = JsonPath.read(data, "$..id");
        return id.get(0).toString();
    }

    public String parseRecipeTitle(String data) throws IOException {
        JSONArray titles = JsonPath.read(data, "$..title");
        return titles.get(0).toString();
    }
    public URL parseRecipeSource(String data) throws IOException {
        JSONArray sources = JsonPath.read(data, "$..sourceUrl");
        String recipeSource = sources.get(0).toString();
        return new URL(recipeSource);
    }
}
