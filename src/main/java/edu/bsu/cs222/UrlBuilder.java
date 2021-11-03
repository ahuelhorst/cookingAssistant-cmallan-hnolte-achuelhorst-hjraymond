package edu.bsu.cs222;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;


public class UrlBuilder {

    BufferedReader br = new BufferedReader(new InputStreamReader((Thread.currentThread().getContextClassLoader().getResourceAsStream( "key.txt" ))));
    String key = (br.readLine());
    public UrlBuilder() throws IOException {
    }

    public URL buildIngredientUrl(String ingredients) throws MalformedURLException, UnsupportedEncodingException {
        String queryString = encodeIngredientString(ingredients);
        String urlString = String.format("https://api.spoonacular.com/recipes/findByIngredients?" +
                "apiKey=%s&ingredients=%s&number=1", key, queryString);
        return new URL(urlString);
    }
    public URL buildRecipeUrl(String recipeId) throws MalformedURLException, UnsupportedEncodingException {
        String queryString = encodeIngredientString(recipeId);
        String urlString = String.format("https://api.spoonacular.com/recipes/%s/information?" +
                "apiKey=%s&number=1",queryString, key);
        return new URL(urlString);
    }

    public String encodeIngredientString(String query) throws UnsupportedEncodingException {
        return URLEncoder.encode(query, StandardCharsets.UTF_8.toString());
    }
}
