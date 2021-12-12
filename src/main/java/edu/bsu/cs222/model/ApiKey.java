package edu.bsu.cs222.model;

public class ApiKey {

    public boolean checkFileLocation() {

        return ClassLoader.getSystemResource("key.txt") != null;
    }
}
