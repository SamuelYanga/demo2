package com.samuel.bdd.base;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public class Configurations {
    private final static Logger LOGGER = Logger.getLogger(Configurations.class);

    private static Properties properties;

    private static void readProperty() {
    	
		System.setProperty("webdriver.edge.driver", "D:/develop/eclipse_dev/git_code/automation/TacoBellAutomationAction/src/test/resources/selenium_standalone_binaries/windows/edge/64bit/MicrosoftWebDriver.exe");
		System.setProperty("webdriver.chrome.driver", "D:/develop/tacobell/driver/chrome_0328/chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "D:/develop/eclipse_dev/git_code/automation/TacoBellAutomationAction/src/test/resources/selenium_standalone_binaries/windows/marionette/64bit/geckodriver.exe");
		System.setProperty("webdriver.ie.driver", "D:/develop/tacobell/driver/IEDriverServer.exe");
    	
        properties = new Properties();
        InputStream is = null;
        is = Configurations.class.getClassLoader().getResourceAsStream("config.properties");
        try {
            properties.load(is);
        } catch (IOException e) {
            LOGGER.error("load properties file error", e);
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    LOGGER.error("close stream error", e);
                }
            }
        }
    }

    public static String getConfiguration(String key) {
        if (properties == null) {
            Configurations.readProperty();
        }
        String value = properties.getProperty(key);
        if (value == null) {
            value = System.getProperty(key);
        }
        return value;
    }

    public static int getIntegerConfiguration(String key) {
        String str = Configurations.getConfiguration(key);
        if (str != null) {
            return Integer.parseInt(str);
        }
        return 0;
    }

    public static boolean getBooleanConfiguration(String key) {
        String str = Configurations.getConfiguration(key);
        if (str != null) {
            return Boolean.valueOf(str);
        }
        return false;
    }
}
