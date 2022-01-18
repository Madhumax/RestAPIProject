package resources;

import io.restassured.path.json.JsonPath;

public class JsonPathClass
{
    public String getJson(String response, String key)
    {
        JsonPath js = new JsonPath(response);
        String value = js.get(key).toString();
        return value;
    }
}
