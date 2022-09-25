package com.testautomation.utility;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;



/**
 * The Class TestDataProvider.
 */
public abstract class TestDataProvider {

    /**
     * Shop by Category data provider.
     *
     * @return the object[]
     */
    @DataProvider(name = "Shop-By-Category-Test-Data")
    public static Object[] shopByCategoryDataProvider() {
        final JSONObject jsonObject = JsonDataReader.
            jsonReader("ShopByCategoryTestData.json");

        // Array to store JSON data.
        final Object[] data = new Object[1];

        // Store JSON data as key/value pairs in a hashMap.
        final HashMap<String, String> hashMap = new LinkedHashMap<>();
        if (jsonObject == null) {

            System.out.println("Extent Report location initialized . . .");

            throw new RuntimeException();
        }
        final Set<String> jsonObjKeys = jsonObject.keySet();
        for (final String jsonObjKey : jsonObjKeys) {
            hashMap.put(jsonObjKey, (String) jsonObject.get(jsonObjKey));
        }

        // Store HashMap in an array and return array
        data[0] = hashMap;
        return data;
    }

}
