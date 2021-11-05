package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;


public class NutritionParser {
    public String parseCalories(String data) {
        JSONArray calorieInformation = JsonPath.read(data, "$..calories");
        return calorieInformation.get(0).toString();
    }
    public String parseCarbs(String data) {
        JSONArray carbInformation = JsonPath.read(data, "$..carbs");
        return carbInformation.get(0).toString();
    }
    public String parseFat(String data) {
        JSONArray fatInformation = JsonPath.read(data, "$..fat");
        return fatInformation.get(0).toString();
    }
    public String parseProtein(String data){
        JSONArray proteinInformation = JsonPath.read(data, "$..protein");
        return proteinInformation.get(0).toString();
    }

}
