package edu.bsu.cs222;

import java.net.URL;

public class Recipe {
    public static class Builder{
        private String title;
        private String id;
        private URL source;
        public Builder withTitle(String title){
            this.title = title;
            return this;
        }
        public Builder andId(String id){
            this.id = id;
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

    public Recipe(Builder builder){
        this.title = builder.title;
        this.id = builder.id;
        this.source = builder.source;
    }

    public String getTitle() {
        return title;
    }

    public URL getSource() {
        return source;
    }
}
