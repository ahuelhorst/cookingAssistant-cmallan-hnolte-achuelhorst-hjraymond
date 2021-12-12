package edu.bsu.cs222;

import edu.bsu.cs222.model.ApiKey;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ApiKeyTest {

    @Test
    public void testCheckApiKeyLocation() {
        ApiKey apiKey = new ApiKey();
        Boolean booleanValue = apiKey.checkFileLocation();
        Assertions.assertEquals(true, booleanValue);
    }
}
