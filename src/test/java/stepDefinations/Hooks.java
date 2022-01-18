package stepDefinations;


import io.cucumber.java.Before;

import java.io.IOException;

public class Hooks
{
    @Before("@deletePlace")
    public void deleteMethod() throws IOException
    {
        StepDefinationClass sd = new StepDefinationClass();
        if (StepDefinationClass.placeId == null)
        {
            sd.json_payload_with( "max",  "63278324",  "andhra");
            sd.user_hits_the_with_http_request("addPlaceAPI","post");
            sd.verifyTheInTheResponseMatchesWithGivenNameUsing("max","getPlaceAPI");
        }
    }
}
