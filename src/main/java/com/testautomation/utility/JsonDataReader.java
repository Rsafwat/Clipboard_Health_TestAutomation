package com.testautomation.utility;

import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * The Class JsonDataReader.
 */
public abstract class JsonDataReader {

    /**
     * Json reader.
     *
     * @param dataFileName the data file name with json extension
     * @return the JSON object
     */
    public static JSONObject jsonReader(final String dataFileName) {
        final String dataFilePath = "src/main/resources/";
        JSONObject testObject = null;
        // Read JSON file.
        try {
            final FileReader reader = new FileReader(dataFilePath + dataFileName);
            final JSONParser jsonParser = new JSONParser();
            final JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
            testObject = jsonObject;
        } catch (IOException | ParseException exception) {
            exception.printStackTrace();
        }
        return testObject;
    }
}
