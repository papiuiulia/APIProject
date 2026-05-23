package tests;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

public class UserTests extends BaseTest {

    @Test
    public void getUsersListTest() {

        // Test Case:
        // Verify that the users list is returned successfully.

        // Expected Result:
        // Status code should be 200
        // Response should contain users data
        // First user email should contain '@reqres.in'

        request

                .when()
                .get("/api/users?page=2")

                .then()
                .statusCode(200)
                .body("data", not(empty()))
                .body("data[0].email", containsString("@reqres.in"));

    }

    @Test
    public void createUserTest() {

        // Test Case:
        // Verify that a new user can be created successfully.

        // Expected Result:
        // Status code should be 201
        // Response should contain:
        // name, job, id and createdAt fields

        String requestBody = "{\n" +
                "  \"name\": \"Alex\",\n" +
                "  \"job\": \"QA Tester\"\n" +
                "}";

        request
                .contentType(ContentType.JSON)
                .body(requestBody)

                .when()
                .post("/api/users")

                .then()
                .statusCode(201)
                .body("name", equalTo("Alex"))
                .body("job", equalTo("QA Tester"))
                .body("id", notNullValue())
                .body("createdAt", notNullValue());

    }

    @Test
    public void updateUserTest() {

        // Test Case:
        // Verify that an existing user can be updated.

        // Expected Result:
        // Status code should be 200
        // Updated values should be returned
        // Response should contain updatedAt field

        String requestBody = "{\n" +
                "  \"name\": \"Alex Updated\",\n" +
                "  \"job\": \"Senior QA\"\n" +
                "}";

        request
                .contentType(ContentType.JSON)
                .body(requestBody)

                .when()
                .put("/api/users/2")

                .then()
                .statusCode(200)
                .body("name", equalTo("Alex Updated"))
                .body("job", equalTo("Senior QA"))
                .body("updatedAt", notNullValue());

    }

    @Test
    public void deleteUserTest() {

        // Test Case:
        // Verify that a user can be deleted successfully.

        // Expected Result:
        // Status code should be 204
        // Response body should be empty

        request

                .when()
                .delete("/api/users/2")

                .then()
                .statusCode(204);

    }

    @Test
    public void verifySpecificUserTest() {

        // Test Case:
        // Verify that a specific user's details are correct.

        // Expected Result:
        // Status code should be 200
        // User first name should be Janet
        // User last name should be Weaver

        request

                .when()
                .get("/api/users/2")

                .then()
                .statusCode(200)
                .body("data.first_name", equalTo("Janet"))
                .body("data.last_name", equalTo("Weaver"));

    }

}