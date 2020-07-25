package net.bddtrader;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

public class WhenGettingCompanyNews {

    @Before
    public void prepare_rest_config()
    {
        RestAssured.baseURI = "https://bddtrader.herokuapp.com/api";
    }


    @Test
    public void should_return_name_and_sector()
    {
        RestAssured
                .given()
                        .pathParam("symbol","aapl")
                .when()
                        .get("/stock/{symbol}/company")
                .then().statusCode(200)
                       .body("companyName", Matchers.equalTo("Apple, Inc."))
                       .body("sector",Matchers.equalTo("Electronic Technology"));
    }

}
/*
given().pathParam("symbol","aapl")
when()get("/stock/{symbol}/company")
then().statusCode(200);

when().get("stock/{symbol}/company","aapl")
then().statusCode(200);

given().pathParam("symbol","aapl")
when()get("/stock/{symbol}/chart/{period}","1y")
then().statusCode(200);

 */

