package edu.bsu.cs222.model;

public class ApiKey {

    public Boolean checkFileLocation() {
        return ClassLoader.getSystemResource("key.txt") != null;
    }
}
