// src/test/java/vio/auto/data/DataReader.java
package vio.auto.data;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DataReader {

    // Method to read the JSON file and return form data as a Map
    public Map<String, String> getFormData(String relativeFilePath) throws IOException {
        // Create an ObjectMapper instance for JSON parsing
        ObjectMapper objectMapper = new ObjectMapper();

        // Resolve the absolute path to the file using the user.dir system property
        String absolutePath = System.getProperty("user.dir") + "/" + "src/test/java/vio/auto/data/UserData.json";

        // Read the JSON data into a JsonNode
        JsonNode jsonData = objectMapper.readTree(new File(absolutePath));

        // Create a Map to hold the extracted data
        Map<String, String> formData = new HashMap<>();

        // Extract the necessary data and store it in the map with null checks
        formData.put("username", getJsonNodeValue(jsonData, "username"));
        formData.put("email", getJsonNodeValue(jsonData, "email"));
        formData.put("password", getJsonNodeValue(jsonData, "password"));
        formData.put("birthDay", getJsonNodeValue(jsonData, "birthDay"));
        formData.put("birthMonth", getJsonNodeValue(jsonData, "birthMonth"));
        formData.put("birthYear", getJsonNodeValue(jsonData, "birthYear"));
        formData.put("firstName", getJsonNodeValue(jsonData, "firstName"));
        formData.put("lastName", getJsonNodeValue(jsonData, "lastName"));
        formData.put("company", getJsonNodeValue(jsonData, "company"));
        formData.put("address1", getJsonNodeValue(jsonData, "address1"));
        formData.put("address2", getJsonNodeValue(jsonData, "address2"));
        formData.put("country", getJsonNodeValue(jsonData, "country"));
        formData.put("state", getJsonNodeValue(jsonData, "state"));
        formData.put("city", getJsonNodeValue(jsonData, "city"));
        formData.put("zipCode", getJsonNodeValue(jsonData, "zipCode"));
        formData.put("phoneNumber", getJsonNodeValue(jsonData, "phoneNumber"));

        // Return the map containing the form data
        return formData;
    }

    // Helper method to safely extract text from a JsonNode
        private String getJsonNodeValue(JsonNode jsonData, String fieldName) {
        JsonNode node = jsonData.get(fieldName);
        return (node != null && !node.isNull()) ? node.asText() : "";
    }
}
