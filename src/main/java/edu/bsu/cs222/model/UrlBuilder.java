package edu.bsu.cs222.model;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;


public class UrlBuilder {

    public URL buildIngredientUrl(String ingredients) throws MalformedURLException, UnsupportedEncodingException {
        String encodedString = encodeString(ingredients);
        String queryString = encodedString.replaceAll("%2C", ",");
        String urlString = String.format("https://api.spoonacular.com/recipes/findByIngredients?" +
                "ingredients=%s&number=5", queryString);
        return new URL(urlString);
    }

    public URL buildRecipeUrl(String recipeId) throws MalformedURLException, UnsupportedEncodingException {
        String queryString = encodeString(recipeId);
        String urlString = String.format("https://api.spoonacular.com/recipes/%s/information?" +
                "number=5", queryString);
        return new URL(urlString);
    }

    public URL buildNutritionUrl(String recipeId) throws UnsupportedEncodingException, MalformedURLException {
        String queryString = encodeString(recipeId);
        String urlString = String.format("https://api.spoonacular.com/recipes/%s/nutritionWidget.json?" +
                "number=5", queryString);
        return new URL(urlString);
    }

    public String encodeString(String query) throws UnsupportedEncodingException {
        return URLEncoder.encode(query, StandardCharsets.UTF_8.toString());
    }
}
