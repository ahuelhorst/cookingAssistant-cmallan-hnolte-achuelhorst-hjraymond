package edu.bsu.cs222.model;

import java.net.URL;

public class Recipe {
    public static class Builder {
        private String title;
        private String id;
        private URL source;
        private String calories;
        private String fat;
        private String protein;

        public Builder withTitle(String title) {
            this.title = title;
            return this;
        }
        public Builder andId(String id) {
            this.id = id;
            return this;
        }
        public Builder andCalories(String calories){
            this.calories = calories;
            return this;
        }
        public Builder andFat(String fat){
            this.fat = fat;
            return this;
        }
        public Builder andProtein(String protein){
            this.protein = protein;
            return this;
        }
        public Recipe andSource(URL source){
            this.source = source;
            return new Recipe(this);
        }
    }
    private final String title;
    private final String id;
    private final URL source;
    private final String calories;
    private final String fat;
    private final String protein;

    public Recipe(Builder builder) {
        this.title = builder.title;
        this.id = builder.id;
        this.calories = builder.calories;
        this.fat = builder.fat;
        this.protein = builder.protein;
        this.source = builder.source;
    }
    public String getTitle() {
        return title;
    }
    public String getId(){
        return id;
    }
    public URL getSource() {
        return source;
    }
    public String getCalories() {
        return calories;
    }
    public String getFat() {
        return fat;
    }
    public String getProtein(){return protein;}
}
