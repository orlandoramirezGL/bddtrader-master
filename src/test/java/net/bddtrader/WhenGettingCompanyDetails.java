package net.bddtrader;

import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.everyItem;

public class WhenGettingCompanyDetails {

    @Before
    public void prepare_rest_config()
    {
        RestAssured.baseURI = "https://bddtrader.herokuapp.com/api";
    }


    @Test
    public void should_return_news_for_a_requested_company()
    {
        RestAssured.
                given()
                        .queryParam("symbols", "fb")
                .when()
                        .get("/news")
                .then()
                        .body("related", everyItem(containsString("FB")));
    }
}


