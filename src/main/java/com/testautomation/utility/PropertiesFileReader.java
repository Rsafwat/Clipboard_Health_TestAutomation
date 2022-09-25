package com.testautomation.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * The Class PropertiesFileReader.
 */
public class PropertiesFileReader {

    /**
     * Gets the property.
     *
     * @return the property
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public Properties getPropertiesFile() throws IOException {
        final Properties properties = new Properties();
        properties.load(
            new FileInputStream(
                "src/main/resources/browser-config.properties"
            )
        );
        return properties;
    }

}
