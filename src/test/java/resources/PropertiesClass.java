package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesClass
{


    public String propertiesMethod() throws IOException
    {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(".\\src\\test\\java\\resources\\config.properties");
        prop.load(fis);
        return prop.getProperty("baseUrl");
    }
}
