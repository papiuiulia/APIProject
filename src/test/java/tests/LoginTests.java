package tests;

import io.qameta.allure.*;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

@Epic("ReqRes API Testing")
@Feature("Login Feature")

public class LoginTests extends BaseTest {

    @Test
    @Story("Successful Login")
    @Description("Verify that user can login with valid credentials")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Iulia")

    public void successfulLoginTest() {

        // Test Case:
        // Verify that a user can successfully login
        // using valid credentials.

        // Expected Result:
        // Status code should be 200
        // Response should contain authentication token

        String requestBody = "{\n" +
                "  \"email\": \"eve.holt@reqres.in\",\n" +
                "  \"password\": \"cityslicka\"\n" +
                "}";

        request
                .contentType(ContentType.JSON)
                .body(requestBody)

                .when()
                .log().all()
                .post("/api/login")

                .then()
                .log().all()
                .statusCode(200)
                .body("token", notNullValue());

    }

    @Test
    @Story("Login Validation")
    @Description("Verify that login fails when password is missing")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Iulia")

    public void loginWithoutPasswordTest() {

        // Test Case:
        // Verify that login fails when password is missing.

        // Expected Result:
        // Status code should be 400
        // Response should contain error message:
        // "Missing password"

        String requestBody = "{\n" +
                "  \"email\": \"peter@klaven\"\n" +
                "}";

        request
                .contentType(ContentType.JSON)
                .body(requestBody)

                .when()
                .post("/api/login")

                .then()
                .statusCode(400)
                .body("error", equalTo("Missing password"));

    }

}