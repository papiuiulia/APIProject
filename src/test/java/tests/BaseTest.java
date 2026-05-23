package tests;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    protected RequestSpecification request;

    @BeforeClass
    public void setup() {

        RestAssured.baseURI = "https://reqres.in";

        request = RestAssured.given()
                .header("x-api-key",
                        "free_user_3E8CZxRa3WmMeklRhoDuoHBR7Tg");

    }
}