package edu.bsu.cs222.model;

public class ApiKey {

    public boolean checkFileLocation() {
        if (ClassLoader.getSystemResource("key.txt") == null) {
            System.out.println("THIS IS FALSE ");
            return false;
        } else {
            return true;
        }
    }
}
