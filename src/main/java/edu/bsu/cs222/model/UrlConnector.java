package edu.bsu.cs222.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Objects;

public class UrlConnector {

    BufferedReader br = new BufferedReader(new InputStreamReader((Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResourceAsStream("key.txt")))));
    String key = (br.readLine());

    public UrlConnector() throws IOException {
    }

    public String openConnection(URL url) throws IOException {
        URL keyUrl = addKey(url);
        URLConnection connection = keyUrl.openConnection();
        connection.setRequestProperty("User-Agent",
                "Revision Reporter/0.1 (http://www.cs.bsu.edu/~pvg/courses/cs222Fa21; cmallan@bsu.edu)");
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputStream;
        inputStream = in.readLine();
        return inputStream;
    }

    public URL addKey(URL url) throws MalformedURLException {
        String stringUrl = url.toString();
        String stringUrlWithKey = stringUrl + "&apiKey=%s";
        String formattedUrl = String.format(stringUrlWithKey, key);
        return new URL(formattedUrl);
    }
}
