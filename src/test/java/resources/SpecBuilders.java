package resources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class SpecBuilders
{
    public static RequestSpecification reqspec;
    ResponseSpecification resspec;
    PrintStream log;
    PropertiesClass p=new PropertiesClass();
    public RequestSpecification requestSpecification() throws IOException
    {
        if(reqspec==null) {
            log = new PrintStream(new FileOutputStream("logging.txt"));

            reqspec = new RequestSpecBuilder().setBaseUri(p.propertiesMethod())
                    .addFilter(RequestLoggingFilter.logRequestTo(log))
                    .addFilter(ResponseLoggingFilter.logResponseTo(log))
                    .addQueryParam("key", "qaclick123")
                    .setContentType(ContentType.JSON).build();

            return reqspec;
        }
        return reqspec;
    }
    public ResponseSpecification responseSpecification()
    {
        resspec = new ResponseSpecBuilder().expectStatusCode(200)
                .expectContentType(ContentType.JSON).build();

        return resspec;
    }

}
