package resources;

import pojo.AddPlacePojo;
import pojo.Location;

import java.util.ArrayList;
import java.util.List;

public class PojoData {
    public AddPlacePojo pojoData(String name,String number,String address)
    {
        AddPlacePojo obj = new AddPlacePojo();
        Location l = new Location();
        List<String> li = new ArrayList<String>();
        li.add("shoe park");
        li.add("shop");
        l.setLat(-66.6);
        l.setLng(-88.9);
        obj.setAccuracy(100);
        obj.setAddress(address);
        obj.setLanguage("Telugu");
        obj.setLocation(l);
        obj.setName(name);
        obj.setWebsite("https://youtube.com");
        obj.setPhone_number(number);
        obj.setTypes(li);

        return obj;
    }
}
