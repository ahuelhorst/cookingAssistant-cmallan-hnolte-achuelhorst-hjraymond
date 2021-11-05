package edu.bsu.cs222;

import java.net.URL;

public class Recipe {
    public static class Builder{
        private String title;
        private String id;
        private String calorie;
        private String fat;
        private String carb;
        private String protein;
        private URL source;

        public Builder withTitle(String title){
            this.title = title;
            return this;
        }
        public Builder andId(String id){
            this.id = id;
            return this;
        }
        public Builder andCalorie(String calorie){
            this.calorie = calorie;
            return this;
        }
        public Builder andFat(String fat){
            this.fat = fat;
            return this;
        }
        public Builder andCarb(String carb){
            this.carb = carb;
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
    private final String calorie;
    private final String fat;
    private final String carb;
    private final String protein;

    public Recipe(Builder builder){
        this.title = builder.title;
        this.id = builder.id;
        this.source = builder.source;
        this.calorie = builder.calorie;
        this.fat = builder.fat;
        this.carb =  builder.fat;
        this.protein = builder.protein;
    }

    public String getTitle() {
        return title;
    }

    public URL getSource() {
        return source;
    }
}
