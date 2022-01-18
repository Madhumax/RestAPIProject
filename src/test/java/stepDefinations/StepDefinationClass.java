package stepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.specification.RequestSpecification;
import resources.JsonPathClass;
import resources.PojoData;
import resources.SpecBuilders;
import resources.enumClass;
import java.io.IOException;
import static org.junit.Assert.*;
import static io.restassured.RestAssured.given;


public class StepDefinationClass extends SpecBuilders
{
    PojoData data=new PojoData();
    RequestSpecification req;
    String response;
    JsonPathClass js=new JsonPathClass();
    public static String placeId;

    @Given("json payload with {string} {string} {string}")
    public void json_payload_with(String name, String number, String address) throws IOException
    {
        //postcode
        req=given().spec(requestSpecification())
                   .body(data.pojoData(name,number,address));
    }

    @When("user hits the {string} with {string} http request")
    public void user_hits_the_with_http_request(String resource, String method)
    {
    enumClass e=enumClass.valueOf(resource);
    String apiResource=e.getResource();
        System.out.println(apiResource);

        if(method.equalsIgnoreCase("post"))
        {
            response = req.when().post(apiResource)
                    .then().spec(responseSpecification()).extract().response().asString();

        }
        else if(method.equalsIgnoreCase("get"))
        {
            response = req.when().get(apiResource)
                    .then().spec(responseSpecification()).extract().response().asString();
        }



    }
    @Then("{string} is {string}")
    public void is(String expectedValue, String actualValue)
    {
        String statusValue=js.getJson(response,expectedValue);
        assertEquals(statusValue,actualValue);
    }

    @And("verify the {string} in the response matches with given name using {string}")
    public void verifyTheInTheResponseMatchesWithGivenNameUsing(String expectedName, String getResource) throws IOException
    {
        placeId=js.getJson(response,"place_id");
        req=given().spec(requestSpecification()).queryParam("place_id",placeId);
        user_hits_the_with_http_request(getResource, "get");
        String actualName=js.getJson(response,"name");
        assertEquals(actualName,expectedName);
    }

    @Given("deletePlace Json payload")
    public void deleteplaceJsonPayload() throws IOException
    {
        req=given().spec(requestSpecification()).body("{\n" +
                "    \"place_id\":\""+placeId+"\"\n" +
                "}\n");

    }
}

