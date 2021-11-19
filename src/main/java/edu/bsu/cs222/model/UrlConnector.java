package edu.bsu.cs222.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class UrlConnector {
    public String openConnection(URL url) throws IOException {
        URLConnection connection = url.openConnection();
        connection.setRequestProperty("User-Agent",
                "Revision Reporter/0.1 (http://www.cs.bsu.edu/~pvg/courses/cs222Fa21; cmallan@bsu.edu)");
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputStream;
        inputStream = in.readLine();
        return inputStream;
    }
}
